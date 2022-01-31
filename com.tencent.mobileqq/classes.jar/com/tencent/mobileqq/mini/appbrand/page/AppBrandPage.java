package com.tencent.mobileqq.mini.appbrand.page;

import amgv;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bbll;
import benn;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.AppConfigInfo;
import com.tencent.mobileqq.mini.apkg.AppMode;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.NavigationBarInfo;
import com.tencent.mobileqq.mini.apkg.PageInfo;
import com.tencent.mobileqq.mini.apkg.TabBarInfo;
import com.tencent.mobileqq.mini.apkg.WindowInfo;
import com.tencent.mobileqq.mini.app.AppUIProxy;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton;
import com.tencent.mobileqq.mini.appbrand.ui.SwipeBackLayout.Callback;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.appbrand.utils.WebviewPool;
import com.tencent.mobileqq.mini.monitor.service.TaskMonitorManager;
import com.tencent.mobileqq.mini.monitor.ui.MiniAppMonitorInfoView;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule;
import com.tencent.mobileqq.mini.ui.MiniAIOEntryView;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.ui.NavigationBar.Listener;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.TabBarView;
import com.tencent.mobileqq.mini.widget.ToastView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class AppBrandPage
  extends AbsAppBrandPage
  implements PageWebview.PageWebViewListener, SwipeBackLayout.Callback, NavigationBar.Listener
{
  public static final String STYLE_CUSTOM = "custom";
  public static final String STYLE_DEFAULT = "default";
  public static final String TAG = "AppBrandPage";
  private FrameLayout centerLayout;
  private String curStyle = "default";
  private ViewGroup customStyleRootCache;
  private ViewGroup defaultStyleRootCache;
  public FrameLayout fullScreenLayout;
  boolean isInitReady;
  private AppBrandPage.MonitorBroadcastReceiver mBroadcastReceiver;
  private int mLayoutID = 1;
  public MiniAppMonitorInfoView mMiniAppMonitorInfoView;
  private boolean mNeedShowMonitorView;
  private String mUrl;
  private WebviewContainer mWebViewContainer = new WebviewContainer(getContext());
  private MiniAIOEntryView miniAIOEntryView;
  private NavigationBar navBar;
  private ViewGroup rootView;
  private TabBarView tabView;
  private benn toast;
  private ToastView toastView;
  private Map<String, WebviewContainer> webViewMap = new HashMap();
  
  public AppBrandPage(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext, paramAppBrandRuntime);
  }
  
  private int getDefaultNaviBarHeight()
  {
    return bbll.b(44.0F) + ImmersiveUtils.getStatusBarHeight(getContext());
  }
  
  private int getDefaultTabBarHeight()
  {
    return bbll.b(54.0F);
  }
  
  private String getLoadedUrl(String paramString1, String paramString2)
  {
    if ("switchTab".equals(paramString2))
    {
      paramString2 = this.webViewMap.entrySet().iterator();
      String str;
      do
      {
        if (!paramString2.hasNext()) {
          break;
        }
        str = (String)((Map.Entry)paramString2.next()).getKey();
      } while ((TextUtils.isEmpty(str)) || (!AppBrandUtil.getUrlWithoutParams(str).equals(paramString1)));
      return str;
    }
    if (this.webViewMap.containsKey(paramString1)) {}
    for (;;)
    {
      return paramString1;
      paramString1 = null;
    }
    return null;
  }
  
  private void switchTab(int paramInt, String paramString)
  {
    if (isTabPage())
    {
      if (this.tabView.getNeedShow()) {
        this.tabView.setVisibility(0);
      }
      if (paramInt == -1) {
        this.tabView.setTabSelected(paramString);
      }
    }
    for (;;)
    {
      setCallback(this);
      return;
      this.tabView.setTabSelected(paramInt);
      continue;
      if (this.tabView != null) {
        this.tabView.setVisibility(8);
      }
    }
  }
  
  public void cleanup()
  {
    MiniReportManager.reportEventType(this.apkgInfo.appConfig, 607, getUrl(), null, null, 0);
    Iterator localIterator = this.webViewMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      ((WebviewContainer)((Map.Entry)localIterator.next()).getValue()).destroy();
      localIterator.remove();
    }
    removeAllViews();
    try
    {
      if (this.mBroadcastReceiver != null) {
        getContext().unregisterReceiver(this.mBroadcastReceiver);
      }
      this.rootView = null;
      this.mUrl = null;
      this.isInitReady = false;
      super.cleanup();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected boolean clickMonitorPanel()
  {
    boolean bool2 = false;
    if (this.appBrandPageContainer.appBrandRuntime.activity != null)
    {
      if (this.mMiniAppMonitorInfoView != null) {
        break label114;
      }
      this.mMiniAppMonitorInfoView = new MiniAppMonitorInfoView(getContext(), null);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 53;
      this.appBrandPageContainer.appBrandRuntime.activity.addContentView(this.mMiniAppMonitorInfoView, localLayoutParams);
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
      label114:
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
  
  public View createContentView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPage", 4, "createContentView apkgInfo=" + this.apkgInfo);
    }
    if (this.rootView == null)
    {
      if (this.appBrandRuntime != null) {
        break label69;
      }
      if (this.customStyleRootCache == null) {
        this.customStyleRootCache = createCustomStyleContentView();
      }
    }
    return this.rootView;
    label69:
    this.curStyle = this.appBrandRuntime.apkgInfo.getAppConfigInfo().globalPageInfo.windowInfo.navigationBarInfo.style;
    if (this.customStyleRootCache != null) {}
    for (this.rootView = this.customStyleRootCache;; this.rootView = createCustomStyleContentView())
    {
      this.navBar.initAppBrandRuntime(this.appBrandRuntime);
      updateViewStyle(this.curStyle);
      TaskMonitorManager.g().switchPerfmPage(MiniProgramReportHelper.currentUrlFromAppBrandRuntime(this.appBrandRuntime), true);
      break;
    }
  }
  
  public ViewGroup createCustomStyleContentView()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, DisplayUtil.getRealHeight(getContext())));
    this.centerLayout = new FrameLayout(getContext());
    this.centerLayout.setId(2131364701);
    this.centerLayout.setBackgroundColor(-1);
    this.tabView = new TabBarView(getContext());
    this.tabView.setId(2131376791);
    this.tabView.setOnTabItemClickListener(this.appBrandPageContainer);
    this.tabView.setVisibility(8);
    this.navBar = new NavigationBar(getContext());
    this.navBar.setId(2131370669);
    return localRelativeLayout;
  }
  
  public FrameLayout getCenterLayout()
  {
    return this.centerLayout;
  }
  
  public PageWebview getCurrentPageWebview()
  {
    if (!TextUtils.isEmpty(this.mUrl)) {
      return getWebView(this.mUrl);
    }
    return null;
  }
  
  public WebviewContainer getCurrentWebviewContainer()
  {
    if (this.mUrl == null) {
      return null;
    }
    return (WebviewContainer)this.webViewMap.get(this.mUrl);
  }
  
  public NavigationBar getNavBar()
  {
    return this.navBar;
  }
  
  public int getNavBarHeight()
  {
    int i;
    if ((this.navBar == null) || (this.navBar.getVisibility() != 0)) {
      i = ImmersiveUtils.getStatusBarHeight(getContext());
    }
    int j;
    do
    {
      return i;
      j = this.navBar.getMeasuredHeight();
      i = j;
    } while (j > 0);
    return getDefaultNaviBarHeight();
  }
  
  public TabBarView getTabBar()
  {
    return this.tabView;
  }
  
  public int getTabBarHeight()
  {
    int i;
    if ((this.tabView == null) || (this.tabView.getVisibility() != 0)) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = this.tabView.getMeasuredHeight();
      i = j;
    } while (j > 0);
    return getDefaultTabBarHeight();
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public PageWebview getWebView(int paramInt)
  {
    Iterator localIterator = this.webViewMap.values().iterator();
    while (localIterator.hasNext())
    {
      PageWebview localPageWebview = ((WebviewContainer)localIterator.next()).getPageWebview();
      if ((localPageWebview != null) && (localPageWebview.pageWebviewId == paramInt)) {
        return localPageWebview;
      }
    }
    return null;
  }
  
  public PageWebview getWebView(String paramString)
  {
    paramString = (WebviewContainer)this.webViewMap.get(paramString);
    if (paramString != null) {
      return paramString.getPageWebview();
    }
    return null;
  }
  
  public WebviewContainer getWebviewContainerByUrl(String paramString)
  {
    return (WebviewContainer)this.webViewMap.get(paramString);
  }
  
  public boolean hasToastView()
  {
    return ((this.toastView != null) && (this.toastView.shown())) || (this.toast != null);
  }
  
  public void hideMiniAIOEntrance()
  {
    if (this.miniAIOEntryView != null)
    {
      this.miniAIOEntryView.setVisibility(8);
      this.miniAIOEntryView.destroy();
      this.miniAIOEntryView = null;
    }
  }
  
  public void hideToastView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPage", 2, "hideToastView toastView=" + this.toastView);
    }
    if (this.toastView != null)
    {
      this.toastView.hide();
      this.toastView = null;
    }
    if (this.toast != null)
    {
      this.toast.a();
      this.toast = null;
    }
  }
  
  protected void initMonitor()
  {
    this.mBroadcastReceiver = new AppBrandPage.MonitorBroadcastReceiver(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action.qq.miniapp.show.monitorview");
    getContext().registerReceiver(this.mBroadcastReceiver, localIntentFilter);
  }
  
  public boolean isHomePage()
  {
    return this.apkgInfo.isHomePage(this.mUrl);
  }
  
  public boolean isTabPage()
  {
    return this.apkgInfo.isTabBarPage(this.mUrl);
  }
  
  public void loadUrl(int paramInt, String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramString1.equals(this.mUrl))
    {
      onAppRoute(paramString2, paramString1);
      switchTab(paramInt, paramString1);
      if (getCurrentPageWebview() != null)
      {
        paramString1 = getCurrentPageWebview();
        if ("appLaunch".equals(paramString2)) {
          break label58;
        }
      }
      label58:
      for (bool1 = true;; bool1 = false)
      {
        paramString1.onResume(bool1);
        return;
      }
    }
    Object localObject1 = getLoadedUrl(paramString1, paramString2);
    Object localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.appBrandPageContainer.appBrandRuntime.serviceRuntime.loadAppServiceJs(paramString1);
      localObject2 = this.mWebViewContainer;
      this.mWebViewContainer = null;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new WebviewContainer(getContext());
        ((WebviewContainer)localObject1).setAppBrandRuntime(this.appBrandRuntime);
      }
      ((WebviewContainer)localObject1).init(paramString1);
      localObject2 = this.appBrandPageContainer.appBrandRuntime.webviewPool.getPageWebview(this.apkgInfo.appId);
      ((PageWebview)localObject2).swipeRefreshLayout = ((WebviewContainer)localObject1).swipeRefreshLayout;
      ((PageWebview)localObject2).mContext = getContext();
      ((PageWebview)localObject2).apkgInfo = this.apkgInfo;
      ((PageWebview)localObject2).appBrandRuntime = this.appBrandPageContainer.appBrandRuntime;
      ((PageWebview)localObject2).eventListener = this.appBrandPageContainer.appBrandRuntime.jsPluginEngine;
      ((PageWebview)localObject2).openType = paramString2;
      ((PageWebview)localObject2).mRouteUrl = paramString1;
      ((PageWebview)localObject2).listener = this;
      ((WebviewContainer)localObject1).setPageWebview((PageWebview)localObject2);
      this.webViewMap.put(paramString1, localObject1);
      ((PageWebview)localObject2).loadPageWebviewJs(this.apkgInfo);
      QLog.d("AppBrandPage", 4, "loadUrl url=" + paramString1 + ",centerLayout=" + this.centerLayout + ",webViewContainer=" + localObject1);
      this.centerLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
      localObject1 = paramString1;
      if (QLog.isColorLevel())
      {
        QLog.d("AppBrandPage", 4, "loadUrl put webViewContainer url=" + paramString1);
        localObject1 = paramString1;
      }
    }
    for (;;)
    {
      this.mUrl = ((String)localObject1);
      paramString1 = this.apkgInfo.mAppConfigInfo.getPageInfo((String)localObject1).windowInfo.navigationBarInfo.style;
      if (!this.curStyle.equals(paramString1))
      {
        this.curStyle = paramString1;
        updateViewStyle(paramString1);
      }
      int i = this.appBrandPageContainer.getPageCount();
      this.navBar.setListener(this);
      this.navBar.setWindowInfo(this.apkgInfo.mAppConfigInfo.getPageInfo((String)localObject1).windowInfo, this.appBrandPageContainer.appBrandRuntime.activity);
      paramString1 = this.navBar;
      if (i > 1)
      {
        bool1 = true;
        paramString1.setEnableBackIcon(bool1);
        this.navBar.getCapsuleButton().updateRedDotVisible();
        if (QLog.isColorLevel()) {
          QLog.d("AppBrandPage", 4, "loadUrl url=" + (String)localObject1 + ",pageCnt=" + i);
        }
        if (i != 1) {
          break label855;
        }
        i = 1;
        label558:
        if (this.apkgInfo.appConfig == null) {
          break label861;
        }
        this.isInternalApp = this.apkgInfo.appConfig.isLimitedAccessApp();
        label582:
        if ((i == 0) || (!this.isInternalApp)) {
          break label869;
        }
        bool1 = false;
        label597:
        setEnable(bool1);
        if (i == 0) {
          break label875;
        }
        setViewDragHelper(this.appBrandPageContainer, this);
        label617:
        if (i == 0) {
          break label887;
        }
        i = 2;
        label625:
        setScrollDirection(i);
        if ((this.appBrandRuntime.activity instanceof AppBrandUI))
        {
          paramString1 = (AppBrandUI)this.appBrandRuntime.activity;
          localObject2 = paramString1.getAppUIProxy();
          setServiceInfo((amgv)localObject2);
          if ((localObject2 instanceof AppUIProxy)) {
            setPostTab(((AppUIProxy)localObject2).mPostTable);
          }
          setActivity(paramString1);
        }
        switchTab(paramInt, (String)localObject1);
        if (getCurrentPageWebview() == null) {
          break;
        }
        paramString1 = getCurrentPageWebview();
        if ("appLaunch".equals(paramString2)) {
          break label893;
        }
      }
      label855:
      label861:
      label869:
      label875:
      label887:
      label893:
      for (bool1 = bool2;; bool1 = false)
      {
        paramString1.onResume(bool1);
        return;
        paramString1 = this.webViewMap.entrySet().iterator();
        while (paramString1.hasNext())
        {
          localObject2 = (Map.Entry)paramString1.next();
          WebviewContainer localWebviewContainer = (WebviewContainer)((Map.Entry)localObject2).getValue();
          if (((String)((Map.Entry)localObject2).getKey()).equals(localObject1))
          {
            if (localWebviewContainer.getParent() == null) {
              this.centerLayout.addView(localWebviewContainer, new FrameLayout.LayoutParams(-1, -1));
            }
            localWebviewContainer.setVisibility(0);
            onAppRoute(paramString2, (String)localObject1);
          }
          else
          {
            localWebviewContainer.setVisibility(8);
          }
        }
        bool1 = false;
        break;
        i = 0;
        break label558;
        this.isInternalApp = false;
        break label582;
        bool1 = true;
        break label597;
        setViewDragHelper(this, this.mContentView);
        break label617;
        i = 1;
        break label625;
      }
    }
  }
  
  public void loadUrl(String paramString1, String paramString2)
  {
    loadUrl(-1, paramString1, paramString2);
  }
  
  public void notifyChangePullDownRefreshStyle()
  {
    Iterator localIterator = this.webViewMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((WebviewContainer)((Map.Entry)localIterator.next()).getValue()).notifyChangePullDownRefreshStyle();
    }
  }
  
  public void onAddColorNote()
  {
    super.onAddColorNote();
    if (getCurrentWebviewContainer() != null) {
      getCurrentWebviewContainer().notifyOnColorNoteAnimStart();
    }
  }
  
  public void onAppRoute(String paramString1, String paramString2)
  {
    super.onAppRoute(paramString1, paramString2);
    MiniProgramReporter.getInstance().getReportHandler().post(new AppBrandPage.2(this, paramString2));
  }
  
  public void onClickBack(NavigationBar paramNavigationBar)
  {
    if ((this.appBrandRuntime != null) && (this.appBrandRuntime.activity != null) && (!this.appBrandRuntime.activity.isFinishing())) {
      this.appBrandRuntime.activity.onBackPressed();
    }
  }
  
  public void onCreate(AppBrandRuntime paramAppBrandRuntime, AppBrandPageContainer paramAppBrandPageContainer)
  {
    super.onCreate(paramAppBrandRuntime, paramAppBrandPageContainer);
    if (this.tabView != null) {
      this.tabView.setOnTabItemClickListener(paramAppBrandPageContainer);
    }
    initMonitor();
  }
  
  public void onMoveAppBrandToBack()
  {
    if (this.appBrandRuntime != null) {
      this.appBrandRuntime.moveAppBrandToBack();
    }
  }
  
  public void onPageBackground()
  {
    super.onPageBackground();
    if (getCurrentWebviewContainer() != null) {
      getCurrentWebviewContainer().notifyPageBackground();
    }
    MiniAppBannerIPCModule.notifyEnterBackground(this.apkgInfo);
  }
  
  public void onPageForeground()
  {
    super.onPageForeground();
    if (getCurrentWebviewContainer() != null) {
      getCurrentWebviewContainer().notifyPageForeground();
    }
    MiniAppBannerIPCModule.notifyEnterForeground(this.apkgInfo);
  }
  
  public void onSwipeFinish()
  {
    post(new AppBrandPage.1(this));
  }
  
  public void onWebViewReady(String paramString1, String paramString2)
  {
    onAppRoute(paramString1, paramString2);
  }
  
  public void reportPageVisit(String paramString)
  {
    Object localObject;
    if ((this.appBrandPageContainer != null) && (this.appBrandPageContainer.appBrandRuntime.mReportSeqNo != -1L)) {
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("page", AppBrandUtil.getUrlWithoutParams(paramString));
      label44:
      VACDReportUtil.a(this.appBrandPageContainer.appBrandRuntime.mReportSeqNo, null, "PageVisit", ((JSONObject)localObject).toString(), 0, null);
      StringBuilder localStringBuilder;
      if ((this.appBrandRuntime != null) && (this.appBrandRuntime.isFirstDomReady))
      {
        MiniProgramLpReportDC04239.reportPageView(this.apkgInfo.appConfig, "0", paramString, "show", "switch_page");
        MiniAppReportManager2.reportPageView("2page_show", "switch_page", paramString, this.apkgInfo.appConfig);
        localStringBuilder = new StringBuilder().append("--- report show switch page appid:");
        if ((this.apkgInfo.appConfig == null) || (this.apkgInfo.appConfig.config == null)) {
          break label204;
        }
      }
      label204:
      for (localObject = this.apkgInfo.appConfig.config.appId;; localObject = Integer.valueOf(0))
      {
        QLog.i("AppBrandPage", 1, localObject);
        MiniReportManager.reportEventType(this.apkgInfo.appConfig, 606, paramString, null, null, 0);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      break label44;
    }
  }
  
  public void setAppBrandRuntime(AppBrandRuntime paramAppBrandRuntime)
  {
    super.setAppBrandRuntime(paramAppBrandRuntime);
    this.mWebViewContainer.setAppBrandRuntime(paramAppBrandRuntime);
  }
  
  public void setDisablePullDownRefresh(boolean paramBoolean)
  {
    Iterator localIterator = this.webViewMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((WebviewContainer)((Map.Entry)localIterator.next()).getValue()).setDisablePullDownRefresh(paramBoolean);
    }
  }
  
  public boolean showMiniAIOEntrance(JSONObject paramJSONObject)
  {
    int i = -10;
    Object localObject = "";
    int j;
    if (paramJSONObject != null)
    {
      j = (int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("x", -10) + 0.5F);
      i = (int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("y", -10) + 0.5F);
    }
    for (paramJSONObject = paramJSONObject.optString("style");; paramJSONObject = (JSONObject)localObject)
    {
      if ((j < 0) || (i < 0)) {
        return false;
      }
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = j;
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      if (this.miniAIOEntryView == null) {
        if ((this.appBrandRuntime != null) && (this.appBrandRuntime.activity != null))
        {
          this.miniAIOEntryView = new MiniAIOEntryView(this.appBrandRuntime.activity, paramJSONObject);
          this.rootView.addView(this.miniAIOEntryView, (ViewGroup.LayoutParams)localObject);
        }
      }
      for (;;)
      {
        return true;
        this.miniAIOEntryView.setStyle(paramJSONObject);
        this.miniAIOEntryView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        requestLayout();
      }
      j = -10;
    }
  }
  
  public void showToastView(int paramInt1, String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPage", 2, "showToastView toastView=" + this.toastView);
    }
    if ((paramInt1 == 1) || ((paramInt1 == 0) && ("loading".equals(paramString1))))
    {
      if (this.toastView == null) {
        this.toastView = new ToastView(getContext(), this);
      }
      this.toastView.show(paramInt1, paramString1, paramString2, paramCharSequence, paramInt2, paramBoolean);
      return;
    }
    for (;;)
    {
      benn localbenn;
      try
      {
        localbenn = new benn(getContext());
        if (!TextUtils.isEmpty(paramString2))
        {
          localbenn.a(new BitmapDrawable(paramString2));
          localbenn.a(paramCharSequence);
          localbenn.c(paramInt2);
          localbenn.a();
          this.toast = localbenn;
          return;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("AppBrandPage", 1, "showToastView error.", paramString1);
        return;
      }
      if ("none".equals(paramString1)) {
        localbenn.b(-1);
      } else {
        localbenn.a(ToastView.getIconRes(paramString1));
      }
    }
  }
  
  public void stopPullDownRefresh()
  {
    Iterator localIterator = this.webViewMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((WebviewContainer)((Map.Entry)localIterator.next()).getValue()).stopPullDownRefresh();
    }
  }
  
  public void updateToastMsg(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPage", 2, "updateToastMsg toastView=" + this.toastView);
    }
    if (this.toastView == null) {
      return;
    }
    this.toastView.updateMsg(paramString);
  }
  
  public void updateViewStyle(String paramString)
  {
    this.curStyle = paramString;
    if (this.rootView.getChildCount() > 0) {
      this.rootView.removeAllViews();
    }
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    RelativeLayout.LayoutParams localLayoutParams3;
    if ((this.apkgInfo != null) && (this.apkgInfo.mAppConfigInfo.tabBarInfo != null) && (!this.apkgInfo.mAppConfigInfo.tabBarInfo.custom))
    {
      if ((this.tabView.getNeedShow()) && (isTabPage())) {
        this.tabView.setVisibility(0);
      }
      this.tabView.setInfo(this.apkgInfo.mAppConfigInfo.tabBarInfo);
      this.tabView.setOnTabItemClickListener(this.appBrandPageContainer);
      if ("top".equals(this.apkgInfo.mAppConfigInfo.tabBarInfo.position)) {
        if ("default".equals(this.curStyle))
        {
          this.rootView.addView(this.centerLayout);
          this.rootView.addView(this.tabView);
          this.rootView.addView(this.navBar);
          localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
          localLayoutParams2 = new RelativeLayout.LayoutParams(-1, getDefaultNaviBarHeight());
          localLayoutParams3 = new RelativeLayout.LayoutParams(-1, getDefaultTabBarHeight());
          if ((this.apkgInfo == null) || (this.apkgInfo.mAppConfigInfo.tabBarInfo == null)) {
            break label663;
          }
          if (!"top".equals(this.apkgInfo.mAppConfigInfo.tabBarInfo.position)) {
            break label584;
          }
          if ("default".equals(paramString)) {
            localLayoutParams1.addRule(3, this.tabView.getId());
          }
        }
      }
    }
    label663:
    for (;;)
    {
      this.centerLayout.setLayoutParams(localLayoutParams1);
      this.tabView.setLayoutParams(localLayoutParams3);
      this.navBar.setLayoutParams(localLayoutParams2);
      this.navBar.setBarStyle(this.curStyle);
      if ((!this.appBrandRuntime.apkgInfo.appConfig.isInternalApp()) || (!this.appBrandRuntime.apkgInfo.appConfig.config.appMode.closeTopRightCapsule)) {
        break label696;
      }
      this.navBar.getCapsuleButton().setVisibility(8);
      return;
      if (!"custom".equals(this.curStyle)) {
        break;
      }
      this.rootView.addView(this.centerLayout);
      this.rootView.addView(this.tabView);
      this.rootView.addView(this.navBar);
      break;
      if ("default".equals(this.curStyle))
      {
        this.rootView.addView(this.centerLayout);
        this.rootView.addView(this.tabView);
        this.rootView.addView(this.navBar);
        break;
      }
      if (!"custom".equals(this.curStyle)) {
        break;
      }
      this.rootView.addView(this.centerLayout);
      this.rootView.addView(this.tabView);
      this.rootView.addView(this.navBar);
      break;
      if ("default".equals(this.curStyle))
      {
        this.rootView.addView(this.navBar);
        this.rootView.addView(this.centerLayout);
        break;
      }
      if (!"custom".equals(this.curStyle)) {
        break;
      }
      this.rootView.addView(this.centerLayout);
      this.rootView.addView(this.navBar);
      break;
      label584:
      if ("default".equals(paramString))
      {
        localLayoutParams1.addRule(3, this.navBar.getId());
        localLayoutParams1.addRule(2, this.tabView.getId());
        localLayoutParams3.addRule(12, -1);
      }
      else if ("custom".equals(this.curStyle))
      {
        localLayoutParams1.addRule(2, this.tabView.getId());
        localLayoutParams3.addRule(12, -1);
        continue;
        if ("default".equals(this.curStyle))
        {
          localLayoutParams1.addRule(12);
          localLayoutParams1.addRule(3, this.navBar.getId());
        }
      }
    }
    label696:
    this.navBar.getCapsuleButton().setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.AppBrandPage
 * JD-Core Version:    0.7.0.1
 */