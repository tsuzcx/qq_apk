package com.tencent.mobileqq.mini.appbrand.page;

import ajyc;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import bcpq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.WindowInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.WebviewPool;
import com.tencent.mobileqq.mini.monitor.service.TaskMonitorManager;
import com.tencent.mobileqq.mini.monitor.ui.MiniAppMonitorInfoView;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mobileqq.mini.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.mini.widget.TabBarView.OnTabItemClickListener;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public final class AppBrandPageContainer
  extends FrameLayout
  implements TabBarView.OnTabItemClickListener
{
  public static final String TAG = "AppBrandPageContainer";
  private static final boolean mEnableNewPage;
  public AppBrandRuntime appBrandRuntime;
  public FrameLayout fullScreenLayout;
  private AppBrandPageContainer.MonitorBroadcastReceiver mBroadcastReceiver;
  private MiniAppMonitorInfoView mMiniAppMonitorInfoView;
  private boolean mNeedShowMonitorView;
  private AbsAppBrandPage mPageTobeRemoved;
  public LinkedList<AbsAppBrandPage> pageLinkedList = new LinkedList();
  public int refreshStyleColor = -1;
  
  static
  {
    boolean bool = true;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_redirectto_config", 1) == 1) {}
    for (;;)
    {
      mEnableNewPage = bool;
      return;
      bool = false;
    }
  }
  
  public AppBrandPageContainer(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    this.appBrandRuntime = paramAppBrandRuntime;
    setBackgroundColor(0);
  }
  
  private void bringToFront(AbsAppBrandPage paramAbsAppBrandPage, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPageContainer", 4, "bringToFront page=" + paramAbsAppBrandPage + ",viewAnim=" + paramBoolean);
    }
    if (paramAbsAppBrandPage == null) {
      return;
    }
    this.pageLinkedList.remove(paramAbsAppBrandPage);
    this.pageLinkedList.push(paramAbsAppBrandPage);
    paramAbsAppBrandPage.bringToFront();
    requestLayout();
    invalidate();
    paramAbsAppBrandPage.onPageForeground();
  }
  
  private void executeDownSubPack(String paramString1, String paramString2)
  {
    WeakReference localWeakReference = new WeakReference(this);
    if ((this.appBrandRuntime.activity == null) || (this.appBrandRuntime.activity.isFinishing()))
    {
      QLog.e("AppBrandPageContainer", 1, "executeDownSubPack return, activity is null or finishing.");
      return;
    }
    bcpq localbcpq = new bcpq(this.appBrandRuntime.activity);
    localbcpq.a(ajyc.a(2131700588));
    localbcpq.setCancelable(false);
    localbcpq.show();
    this.appBrandRuntime.apkgInfo.downloadSubPack(paramString1, new AppBrandPageContainer.1(this, paramString1, localWeakReference, paramString2, localbcpq));
  }
  
  private AbsAppBrandPage getBrandPage()
  {
    AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)this.pageLinkedList.peek();
    Object localObject;
    if (localAbsAppBrandPage == null)
    {
      localObject = BrandPagePool.g().obtainBrandPage(getContext(), this.appBrandRuntime);
      ((AbsAppBrandPage)localObject).onCreate(this.appBrandRuntime, this);
      this.pageLinkedList.push(localObject);
    }
    do
    {
      return localObject;
      localObject = localAbsAppBrandPage;
    } while (localAbsAppBrandPage.getCurrentPageWebview() == null);
    localAbsAppBrandPage.getCurrentPageWebview().onPause(true);
    return localAbsAppBrandPage;
  }
  
  private void initMonitor()
  {
    if ((this.appBrandRuntime == null) || (this.appBrandRuntime.activity == null)) {
      return;
    }
    this.mBroadcastReceiver = new AppBrandPageContainer.MonitorBroadcastReceiver(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action.qq.miniapp.show.monitorview");
    this.appBrandRuntime.activity.registerReceiver(this.mBroadcastReceiver, localIntentFilter);
  }
  
  private boolean isUrlResReady(String paramString)
  {
    return (this.appBrandRuntime.apkgInfo.isUrlResReady(paramString)) && (this.appBrandRuntime.apkgInfo.isUrlFileExist(paramString));
  }
  
  public final void cleanup(boolean paramBoolean)
  {
    Iterator localIterator = this.pageLinkedList.iterator();
    while (localIterator.hasNext())
    {
      AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)localIterator.next();
      if (localAbsAppBrandPage.getCurrentPageWebview() != null) {
        localAbsAppBrandPage.getCurrentPageWebview().resetTitle();
      }
      if ((paramBoolean) && (localAbsAppBrandPage.isTabPage()))
      {
        localAbsAppBrandPage.onPageBackground();
      }
      else
      {
        this.appBrandRuntime.webviewPool.recyclePageWebview(localAbsAppBrandPage.getCurrentPageWebview(), BaseApplicationImpl.sApplication);
        localAbsAppBrandPage.cleanup();
        localIterator.remove();
      }
    }
    try
    {
      if (this.mBroadcastReceiver != null)
      {
        this.appBrandRuntime.activity.unregisterReceiver(this.mBroadcastReceiver);
        this.mBroadcastReceiver = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AppBrandPageContainer", 4, "cleanup keepTabPage=" + paramBoolean + ",pageLinkedList size=" + this.pageLinkedList.size());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AppBrandPageContainer", 1, "unregisterReceiver exception.", localThrowable);
      }
    }
  }
  
  public boolean clickMonitorPanel()
  {
    boolean bool2 = false;
    if ((this.appBrandRuntime != null) && (this.appBrandRuntime.activity != null))
    {
      if (this.mMiniAppMonitorInfoView != null) {
        break label115;
      }
      this.mMiniAppMonitorInfoView = new MiniAppMonitorInfoView(getContext(), null);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 53;
      this.appBrandRuntime.activity.addContentView(this.mMiniAppMonitorInfoView, localLayoutParams);
      this.mMiniAppMonitorInfoView.setVisibility(0);
      this.mMiniAppMonitorInfoView.startRefreshMonitorUi();
    }
    for (;;)
    {
      boolean bool1 = bool2;
      if (this.mMiniAppMonitorInfoView != null)
      {
        bool1 = bool2;
        if (this.mMiniAppMonitorInfoView.getVisibility() == 0) {
          bool1 = true;
        }
      }
      return bool1;
      label115:
      if (this.mMiniAppMonitorInfoView.getVisibility() == 0)
      {
        this.mMiniAppMonitorInfoView.stopRefreshMonitorUi();
        this.mMiniAppMonitorInfoView.setVisibility(8);
      }
      else
      {
        this.mMiniAppMonitorInfoView.startRefreshMonitorUi();
        this.mMiniAppMonitorInfoView.setVisibility(0);
      }
    }
  }
  
  public PageWebview findPageWebView(int paramInt)
  {
    Iterator localIterator = this.pageLinkedList.iterator();
    while (localIterator.hasNext())
    {
      PageWebview localPageWebview = ((AbsAppBrandPage)localIterator.next()).getWebView(paramInt);
      if (localPageWebview != null) {
        return localPageWebview;
      }
    }
    return null;
  }
  
  public AbsAppBrandPage getCurrentPage()
  {
    return (AbsAppBrandPage)this.pageLinkedList.peek();
  }
  
  public PageWebview getCurrentPageWebview()
  {
    AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)this.pageLinkedList.peek();
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPageContainer", 4, "getCurrentPageWebview page=" + localAbsAppBrandPage);
    }
    if (localAbsAppBrandPage != null) {
      return localAbsAppBrandPage.getCurrentPageWebview();
    }
    return null;
  }
  
  public WebviewContainer getCurrentWebviewContainer()
  {
    AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)this.pageLinkedList.peek();
    if (localAbsAppBrandPage != null) {
      return localAbsAppBrandPage.getCurrentWebviewContainer();
    }
    return null;
  }
  
  public AbsAppBrandPage getPageByWebViewId(int paramInt)
  {
    Iterator localIterator = this.pageLinkedList.iterator();
    while (localIterator.hasNext())
    {
      AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)localIterator.next();
      if (localAbsAppBrandPage.getWebView(paramInt) != null) {
        return localAbsAppBrandPage;
      }
    }
    return null;
  }
  
  public final int getPageCount()
  {
    return this.pageLinkedList.size();
  }
  
  public boolean handleBackPressed()
  {
    WebviewContainer localWebviewContainer = getCurrentWebviewContainer();
    return (localWebviewContainer != null) && (localWebviewContainer.handleBackPressed());
  }
  
  public void launch(String paramString1, String paramString2)
  {
    QLog.i("miniapp-start", 1, "launch type=" + paramString2 + ",url=" + paramString1 + ",currPageCount=" + getPageCount());
    if (!isUrlResReady(paramString1))
    {
      executeDownSubPack(paramString1, paramString2);
      return;
    }
    AppBrandPage localAppBrandPage = BrandPagePool.g().obtainBrandPage(getContext(), this.appBrandRuntime);
    this.pageLinkedList.push(localAppBrandPage);
    localAppBrandPage.onCreate(this.appBrandRuntime, this);
    localAppBrandPage.loadUrl(paramString1, paramString2);
  }
  
  public void navigateBack(int paramInt, boolean paramBoolean)
  {
    QLog.i("miniapp-start", 1, "navigateBack delta=" + paramInt + ",viewAnim=" + paramBoolean);
    MiniAppStateManager.getInstance().notifyChange("hideInput");
    Object localObject1 = (AbsAppBrandPage)this.pageLinkedList.peek();
    if (localObject1 != null)
    {
      localObject2 = (InputMethodManager)((AbsAppBrandPage)localObject1).getContext().getSystemService("input_method");
      if (localObject2 != null) {}
    }
    int i;
    do
    {
      int j;
      do
      {
        return;
        if (((InputMethodManager)localObject2).isActive()) {
          ((InputMethodManager)localObject2).hideSoftInputFromWindow(((AbsAppBrandPage)localObject1).getWindowToken(), 0);
        }
        j = getPageCount();
      } while ((j < 2) || (paramInt < 1));
      i = paramInt;
      if (paramInt >= j) {
        i = j - 1;
      }
      reportPageViewHide();
      localObject1 = this.pageLinkedList.iterator();
      paramInt = 0;
      if ((paramInt < i) && (this.pageLinkedList.size() >= 1)) {
        break;
      }
      localObject1 = (AbsAppBrandPage)this.pageLinkedList.peek();
      QLog.d("AppBrandPageContainer", 4, "navigateBack backPage=" + localObject1);
    } while (localObject1 == null);
    Object localObject2 = ((AbsAppBrandPage)localObject1).getCurrentWebviewContainer();
    if ((localObject2 != null) && (this.appBrandRuntime != null) && (this.appBrandRuntime.activity != null) && (!this.appBrandRuntime.activity.isFinishing()))
    {
      i = this.appBrandRuntime.activity.getRequestedOrientation();
      localObject2 = ((WebviewContainer)localObject2).getPageOrientation();
      if (!WindowInfo.ORIENTATION_AUTO.equals(localObject2)) {
        break label443;
      }
      paramInt = 4;
    }
    for (;;)
    {
      if (paramInt != i) {
        this.appBrandRuntime.activity.setRequestedOrientation(paramInt);
      }
      if (((AbsAppBrandPage)localObject1).getCurrentPageWebview() != null) {
        ((AbsAppBrandPage)localObject1).getCurrentPageWebview().onResume(true);
      }
      ((AbsAppBrandPage)localObject1).onPageForeground();
      ((AbsAppBrandPage)localObject1).onAppRoute("navigateBack", ((AbsAppBrandPage)localObject1).getUrl());
      return;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AbsAppBrandPage)((Iterator)localObject1).next();
        QLog.d("AppBrandPageContainer", 4, "navigateBack clearPage=" + localObject2);
        Animation localAnimation = AnimationUtils.loadAnimation(AppLoaderFactory.getAppLoaderManager().getContext(), 2130772257);
        localAnimation.setDuration(200L);
        localAnimation.setAnimationListener(new AppBrandPageContainer.3(this, (AbsAppBrandPage)localObject2));
        ((AbsAppBrandPage)localObject2).startAnimation(localAnimation);
        ((Iterator)localObject1).remove();
      }
      paramInt += 1;
      break;
      label443:
      if (WindowInfo.ORIENTATION_LANDSCAPE.equals(localObject2)) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
    }
  }
  
  public void navigateTo(String paramString)
  {
    QLog.i("miniapp-start", 1, "navigateTo url=" + paramString + "; aliveWebViewCount : " + BaseAppBrandWebview.aliveWebViewCount);
    if (BaseAppBrandWebview.aliveWebViewCount > 11)
    {
      Toast.makeText(getContext(), ajyc.a(2131700586), 0).show();
      QLog.e("AppBrandPageContainer", 4, "打开WebView数量超过上限");
      return;
    }
    MiniProgramReporter.getInstance().getReportHandler().post(new AppBrandPageContainer.2(this));
    if (!isUrlResReady(paramString))
    {
      executeDownSubPack(paramString, "navigateTo");
      return;
    }
    TaskMonitorManager.g().switchPerfmPage(MiniProgramReportHelper.currentUrlFromAppBrandRuntime(this.appBrandRuntime), false);
    Object localObject = getCurrentPage();
    if (localObject != null)
    {
      if (((AbsAppBrandPage)localObject).getCurrentPageWebview() != null)
      {
        ((AbsAppBrandPage)localObject).getCurrentPageWebview().resetTitle();
        ((AbsAppBrandPage)localObject).getCurrentPageWebview().onPause(true);
      }
      ((AbsAppBrandPage)localObject).onPageBackground();
    }
    localObject = BrandPagePool.g().obtainBrandPage(getContext(), this.appBrandRuntime);
    this.pageLinkedList.push(localObject);
    ((AppBrandPage)localObject).onCreate(this.appBrandRuntime, this);
    ((AppBrandPage)localObject).loadUrl(paramString, "navigateTo");
    if (!((AppBrandPage)localObject).isHomePage()) {
      ((AppBrandPage)localObject).setVisibility(4);
    }
    TaskMonitorManager.g().switchPerfmPage(MiniProgramReportHelper.currentUrlFromAppBrandRuntime(this.appBrandRuntime), true);
  }
  
  public void notifyOnAddColorNote()
  {
    getBrandPage().onAddColorNote();
  }
  
  public void onAttachWindow()
  {
    initMonitor();
  }
  
  public void onDomReady()
  {
    AppBrandTask.runTaskOnUiThreadDelay(new AppBrandPageContainer.4(this), 50L);
  }
  
  public void onTabItemClick(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPageContainer", 4, "onTabItemClick pagePath=" + paramString1);
    }
    swichTab(paramInt, paramString1);
    try
    {
      if (this.appBrandRuntime != null)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("index", paramInt);
        localJSONObject.put("pagePath", paramString1);
        localJSONObject.put("text", paramString2);
        if (this.appBrandRuntime.getPageWebView() != null) {
          this.appBrandRuntime.evaluateServiceSubcribeJS("onTabItemTap", localJSONObject.toString(), this.appBrandRuntime.getPageWebView().pageWebviewId);
        }
      }
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("AppBrandPageContainer", 1, "onTabItemClick error,", paramString1);
    }
  }
  
  public void redirectTo(String paramString)
  {
    QLog.i("miniapp-start", 1, "redirectTo url=" + paramString);
    if (!isUrlResReady(paramString))
    {
      executeDownSubPack(paramString, "redirectTo");
      return;
    }
    reportPageViewHide();
    if (!mEnableNewPage)
    {
      AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)this.pageLinkedList.peek();
      if (localAbsAppBrandPage != null)
      {
        if (localAbsAppBrandPage.getCurrentPageWebview() != null) {
          localAbsAppBrandPage.getCurrentPageWebview().resetTitle();
        }
        localObject = localAbsAppBrandPage;
        if (localAbsAppBrandPage.getUrl() != null)
        {
          localObject = localAbsAppBrandPage;
          if (!localAbsAppBrandPage.getUrl().equals(paramString))
          {
            if ((localAbsAppBrandPage.getCenterLayout() != null) && (localAbsAppBrandPage.appBrandPageContainer != null) && (localAbsAppBrandPage.appBrandPageContainer.getCurrentWebviewContainer() != null)) {
              localAbsAppBrandPage.getCenterLayout().removeView(localAbsAppBrandPage.appBrandPageContainer.getCurrentWebviewContainer());
            }
            bringToFront(localAbsAppBrandPage, false);
            localObject = localAbsAppBrandPage;
          }
        }
      }
      for (;;)
      {
        ((AbsAppBrandPage)localObject).loadUrl(paramString, "redirectTo");
        return;
        localObject = BrandPagePool.g().obtainBrandPage(getContext(), this.appBrandRuntime);
        ((AbsAppBrandPage)localObject).onCreate(this.appBrandRuntime, this);
        this.pageLinkedList.push(localObject);
      }
    }
    this.mPageTobeRemoved = ((AbsAppBrandPage)this.pageLinkedList.peek());
    Object localObject = BrandPagePool.g().obtainBrandPage(getContext(), this.appBrandRuntime);
    this.pageLinkedList.push(localObject);
    ((AppBrandPage)localObject).onCreate(this.appBrandRuntime, this);
    ((AppBrandPage)localObject).loadUrl(paramString, "redirectTo");
    if (!((AppBrandPage)localObject).isHomePage())
    {
      ((AppBrandPage)localObject).setVisibility(4);
      return;
    }
    onDomReady();
  }
  
  public void reportPageViewHide()
  {
    Object localObject = (AbsAppBrandPage)this.pageLinkedList.peek();
    if (localObject != null) {}
    for (localObject = ((AbsAppBrandPage)localObject).getUrl();; localObject = null)
    {
      MiniProgramLpReportDC04239.reportPageView(this.appBrandRuntime.apkgInfo.appConfig, "0", (String)localObject, "hide", null);
      return;
    }
  }
  
  public void reportPageViewShow(String paramString)
  {
    Object localObject = (AbsAppBrandPage)this.pageLinkedList.peek();
    if (localObject != null) {}
    for (localObject = ((AbsAppBrandPage)localObject).getUrl();; localObject = null)
    {
      MiniProgramLpReportDC04239.reportPageView(this.appBrandRuntime.apkgInfo.appConfig, "0", (String)localObject, "show", paramString);
      QLog.i("AppBrandPageContainer", 1, "--- report show " + paramString);
      return;
    }
  }
  
  public void swichTab(int paramInt, String paramString)
  {
    QLog.i("miniapp-start", 1, "swichTab url=" + paramString);
    reportPageViewHide();
    cleanup(true);
    AbsAppBrandPage localAbsAppBrandPage = getBrandPage();
    localAbsAppBrandPage.loadUrl(paramInt, paramString, "switchTab");
    localAbsAppBrandPage.onPageForeground();
  }
  
  public void swichTab(String paramString)
  {
    QLog.i("miniapp-start", 1, "swichTab url=" + paramString);
    reportPageViewHide();
    cleanup(true);
    AbsAppBrandPage localAbsAppBrandPage = getBrandPage();
    localAbsAppBrandPage.loadUrl(paramString, "switchTab");
    localAbsAppBrandPage.onPageForeground();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer
 * JD-Core Version:    0.7.0.1
 */