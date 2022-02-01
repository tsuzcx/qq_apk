package com.tencent.mobileqq.webview.swift;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.CustomScrollView.OnGestureListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.temp.api.IWebviewApi;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponent;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserNavigator;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.BaseOpenWebMonitor;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class WebViewFragment
  extends QBaseFragment
  implements View.OnClickListener, CustomScrollView.OnGestureListener, WebViewProvider, WebUiUtils.QQBrowserBaseActivityInterface, WebUiUtils.WebShareInterface
{
  public static final String TAG = "WebLog_WebViewFragment";
  public WebBrowserViewContainer contentView;
  protected Intent intent;
  protected boolean isDestroyed;
  protected volatile AppRuntime mApp;
  public final SwiftBrowserComponentsProvider mComponentsProvider = createComponentsProvider();
  protected boolean mNightMode = false;
  private SwiftBrowserStatistics mStatistics;
  private SwiftIphoneTitleBarUI mSwiftTitleUI;
  private SwiftBrowserUIStyle mUIStyle;
  private SwiftBrowserUIStyleHandler mUIStyleHandler;
  protected String mUrl = null;
  protected WebUiUtils.WebShareInterface share;
  protected TouchWebView webView;
  protected WebViewKernel webViewKernel;
  protected WebViewSurface webViewSurface;
  
  private WebUiUtils.WebShareInterface ensureShare()
  {
    if (this.share == null) {
      this.share = ((WebUiUtils.WebShareInterface)((IWebviewApi)QRoute.api(IWebviewApi.class)).createShare(getAppRuntime(), super.getActivity()));
    }
    return this.share;
  }
  
  public static WebViewFragment newInstance(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    paramIntent = new WebViewFragment();
    paramIntent.setArguments(localBundle);
    return paramIntent;
  }
  
  public void activityFinish()
  {
    this.webViewSurface.e();
  }
  
  public SwiftBrowserComponentsProvider createComponentsProvider()
  {
    return new SwiftBrowserComponentsProvider(this, 511, null);
  }
  
  public WebViewWrapper createWebViewWrapper(boolean paramBoolean)
  {
    return null;
  }
  
  public void destroy()
  {
    WebUiUtils.WebShareInterface localWebShareInterface = this.share;
    if (localWebShareInterface != null) {
      localWebShareInterface.destroy();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQBrowserActivity onActivityResult,requestCode=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",resultCode=");
      localStringBuilder.append(paramInt2);
      QLog.d("WebLog_WebViewFragment", 2, localStringBuilder.toString());
    }
    this.webViewSurface.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackEvent()
  {
    this.mStatistics.c("state_back");
    this.webViewKernel.f();
    if (TextUtils.isEmpty(this.mUrl))
    {
      localObject1 = this.webView;
      if (localObject1 != null) {
        this.mUrl = ((TouchWebView)localObject1).getUrl();
      }
    }
    this.mStatistics.b(getIntent(), this.mUrl);
    this.mStatistics.a(BaseApplication.getContext(), this.mUrl, this.intent);
    BaseOpenWebMonitor.c(this.intent);
    if (this.webViewSurface.a()) {
      return;
    }
    this.webViewKernel.g();
    Object localObject1 = new HashMap(1);
    ((Map)localObject1).put("target", Integer.valueOf(3));
    if (this.webViewKernel.a(8589934601L, (Map)localObject1)) {
      return;
    }
    if ((!this.mUIStyle.g) && ((this.mUIStyle.jdField_a_of_type_Long & 0x4) == 0L))
    {
      Object localObject2 = this.webView;
      if ((localObject2 != null) && (((TouchWebView)localObject2).canGoBack()))
      {
        this.webView.stopLoading();
        this.webView.goBack();
        localObject2 = this.webView.getPluginEngine();
        if (localObject2 != null) {
          ((WebViewPluginEngine)localObject2).a(this.webView.getUrl(), 8589934610L, (Map)localObject1);
        }
        return;
      }
    }
    super.getActivity().finish();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    this.webViewSurface.a(paramConfiguration);
    this.webViewKernel.a(8589934611L, null);
  }
  
  @TargetApi(11)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    BaseOpenWebMonitor.a(this.intent);
    Object localObject = (SwiftBrowserNavigator)this.mComponentsProvider.a(1);
    if ((localObject != null) && (((SwiftBrowserNavigator)localObject).a(this.intent)))
    {
      super.getActivity().finish();
      return true;
    }
    preInitData();
    this.mStatistics.c("state_activity_create");
    this.mStatistics.a(this.intent, this.mUrl);
    Util.a("Web_qqbrowser_dooncreate");
    StatisticCollector.getInstance(BaseApplication.getContext(), 10000L);
    this.mStatistics.O = System.currentTimeMillis();
    this.mNightMode = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    localObject = this.mStatistics;
    this.isDestroyed = false;
    ((SwiftBrowserStatistics)localObject).k = false;
    ((SwiftBrowserStatistics)localObject).P = System.currentTimeMillis();
    this.webViewKernel.a(paramBundle);
    this.webViewSurface.a(paramBundle);
    this.mStatistics.jdField_s_of_type_Long = (System.currentTimeMillis() - this.mStatistics.c);
    Util.b("Web_qqbrowser_dooncreate");
    this.mStatistics.T = System.currentTimeMillis();
    return true;
  }
  
  public void doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 24)
    {
      if (paramInt != 25)
      {
        if (paramInt != 82) {
          return;
        }
        this.webViewKernel.a(8589934607L, null);
        return;
      }
      this.webViewKernel.a(8589934608L, null);
      return;
    }
    this.webViewKernel.a(8589934609L, null);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("intent", paramIntent);
    this.webViewKernel.a(128L, localHashMap);
    if (this.webViewSurface.a(paramIntent)) {
      return;
    }
    if ((paramIntent.getDataString() == null) || (this.webView == null))
    {
      this.intent = paramIntent;
      preInitData();
    }
    this.webViewKernel.a(paramIntent);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mUIStyle.jdField_a_of_type_Boolean))
    {
      WebViewUIUtils.b(super.getActivity());
      WebViewUIUtils.a(super.getActivity());
    }
  }
  
  public void flingLToR()
  {
    Object localObject = this.webView;
    if (localObject == null)
    {
      doOnBackEvent();
      return;
    }
    if (((TouchWebView)localObject).canGoBack())
    {
      localObject = new HashMap(1);
      ((Map)localObject).put("target", Integer.valueOf(2));
      if (this.webView.goBack((Map)localObject)) {
        reset();
      }
    }
    else
    {
      doOnBackEvent();
    }
  }
  
  public AppRuntime getAppRuntime()
  {
    if (this.mApp == null) {
      this.mApp = MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    return this.mApp;
  }
  
  public SwiftBrowserComponentsProvider getComponentProvider()
  {
    return this.mComponentsProvider;
  }
  
  public WebBrowserViewContainer getContentView()
  {
    return this.contentView;
  }
  
  public String getCurrentUrl()
  {
    String str2 = this.mUrl;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      TouchWebView localTouchWebView = this.webView;
      str1 = str2;
      if (localTouchWebView != null)
      {
        if (!TextUtils.isEmpty(localTouchWebView.getUrl())) {
          return this.webView.getUrl();
        }
        str1 = this.intent.getStringExtra("url");
      }
    }
    return str1;
  }
  
  public Activity getHostActivity()
  {
    return super.getActivity();
  }
  
  public WebView getHostWebView()
  {
    return this.webView;
  }
  
  public Intent getIntent()
  {
    return this.intent;
  }
  
  public View.OnClickListener getOnclickListener()
  {
    return this;
  }
  
  public String getRedirect302Url()
  {
    WebViewKernel localWebViewKernel = this.webViewKernel;
    if (localWebViewKernel == null) {
      return "";
    }
    return localWebViewKernel.a();
  }
  
  public Resources getResource()
  {
    return super.getResources();
  }
  
  public <T> T getShare()
  {
    return ensureShare();
  }
  
  public String getShareUrl()
  {
    if (ensureShare() == null) {
      return "";
    }
    return ensureShare().getShareUrl();
  }
  
  public SwiftBrowserStatistics getStatistics()
  {
    return this.mStatistics;
  }
  
  public SwiftIphoneTitleBarUI getSwiftTitleUI()
  {
    return this.mSwiftTitleUI;
  }
  
  public SwiftBrowserUIStyle getUIStyle()
  {
    return this.mUIStyle;
  }
  
  public SwiftBrowserUIStyleHandler getUIStyleHandler()
  {
    return this.mUIStyleHandler;
  }
  
  public String getUin()
  {
    if (this.mApp != null) {
      return this.mApp.getAccount();
    }
    Intent localIntent = this.intent;
    if ((localIntent != null) && (localIntent.getExtras() != null)) {
      return this.intent.getExtras().getString("uin");
    }
    return null;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public String getUrlFromIntent()
  {
    String str2 = this.intent.getStringExtra("url");
    String str1 = str2;
    if (str2 == null)
    {
      str2 = this.intent.getStringExtra("key_params_qq");
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    return str1;
  }
  
  public WebUiUtils.WebShareInterface getWebShareInterface()
  {
    return this;
  }
  
  public WebUiUtils.WebTitleBarInterface getWebTitleBarInterface()
  {
    return this.webViewSurface;
  }
  
  public CustomWebView getWebView()
  {
    return this.webView;
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return this.webViewSurface;
  }
  
  public WebViewProvider getWebViewProvider()
  {
    return this;
  }
  
  public boolean isActivityResume()
  {
    if (getQBaseActivity() != null) {
      return getQBaseActivity().isResume();
    }
    return false;
  }
  
  public boolean isDestroyed()
  {
    return this.isDestroyed;
  }
  
  public boolean isNightMode()
  {
    return this.mNightMode;
  }
  
  protected void listenKeyboardShowHide(View paramView)
  {
    if ((Build.VERSION.SDK_INT >= 11) && (paramView != null)) {
      paramView.addOnLayoutChangeListener(new WebViewFragment.1(this));
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((getHostActivity() != null) && (getHostActivity().isFinishing()))
    {
      paramBundle = new StringBuilder();
      paramBundle.append("HostActivity ");
      paramBundle.append(getHostActivity());
      paramBundle.append(" is finishing! Don't call WebViewFragment.doOnCreate!");
      QLog.e("WebLog_WebViewFragment", 1, paramBundle.toString());
      return;
    }
    doOnCreate(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    this.intent = ((Intent)super.getArguments().getParcelable("intent"));
    Object localObject = this.intent;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((Intent)localObject).getExtras();
    }
    if (localObject != null) {
      if (((Bundle)localObject).getClassLoader() == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewFragment", 2, "No classloader for this fragment");
        }
        this.intent.setExtrasClassLoader(WebViewTitleStyle.class.getClassLoader());
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("already has classloader for this fragment: ");
        localStringBuilder.append(((Bundle)localObject).getClassLoader());
        QLog.d("WebLog_WebViewFragment", 2, localStringBuilder.toString());
      }
    }
    super.onAttach(paramActivity);
  }
  
  public void onClick(View paramView)
  {
    this.webViewSurface.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.webViewSurface = new WebViewSurface(this);
    this.mStatistics = ((SwiftBrowserStatistics)this.mComponentsProvider.a(-2));
    this.mUIStyleHandler = ((SwiftBrowserUIStyleHandler)this.mComponentsProvider.a(2));
    this.mUIStyle = this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
    this.mSwiftTitleUI = this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI;
    this.webViewKernel = new WebViewKernel(this, getWebViewKernelCallBack(), this.mUIStyle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((WebAccelerateHelper.preloadBrowserView instanceof WebBrowserViewContainer))
    {
      this.contentView = ((WebBrowserViewContainer)WebAccelerateHelper.preloadBrowserView);
      WebAccelerateHelper.preloadBrowserView = null;
      this.mStatistics.jdField_s_of_type_Boolean = true;
    }
    else
    {
      this.contentView = new WebBrowserViewContainer(super.getActivity());
    }
    paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
    this.contentView.setLayoutParams(paramLayoutInflater);
    listenKeyboardShowHide(this.contentView);
    paramLayoutInflater = this.contentView;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebLog_WebViewFragment", 2, "doOnDestroy");
    }
    Object localObject = this.mStatistics;
    this.isDestroyed = true;
    ((SwiftBrowserStatistics)localObject).k = true;
    localObject = this.share;
    if (localObject != null) {
      ((WebUiUtils.WebShareInterface)localObject).destroy();
    }
    this.webViewSurface.c();
    this.webViewKernel.e();
    this.mApp = null;
    super.onDestroy();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    long l;
    if (paramBoolean) {
      l = 512L;
    } else {
      l = 256L;
    }
    this.webViewKernel.a(l, null);
  }
  
  public void onLowMemory()
  {
    try
    {
      if ((SwiftBrowserStatistics.u) && (this.mStatistics != null) && (this.mStatistics.c > 0L)) {
        ReportController.b(null, "dc00899", "WV_Analysis", "", "memory_consumption", SwiftBrowserStatistics.a(this.mUrl), this.mStatistics.jdField_e_of_type_Int, 0, "", this.mStatistics.f, this.mStatistics.jdField_e_of_type_JavaLangString, "");
      }
      label76:
      super.onLowMemory();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label76;
    }
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onPause");
    }
    this.webViewSurface.a();
    this.webViewKernel.d();
    super.onPause();
  }
  
  public void onPostThemeChanged()
  {
    if (getAppRuntime() != null)
    {
      this.mNightMode = ThemeUtil.isInNightMode(getAppRuntime());
      this.webViewKernel.a(8589934604L, null);
    }
    this.webViewSurface.d();
  }
  
  public void onResume()
  {
    Util.a("Web_qqbrowser_doonresume");
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onResume");
    }
    this.webViewKernel.c();
    this.webViewSurface.a(this.webViewKernel.a());
    Util.b("Web_qqbrowser_doonresume");
    super.onResume();
  }
  
  public void onStop()
  {
    this.webViewSurface.b();
    super.onStop();
  }
  
  public final int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i = switchRequestCode(paramWebViewPlugin, paramByte);
    if (i == -1)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WebLog_WebViewFragment", 2, "pluginStartActivityForResult not handled");
        return i;
      }
    }
    else {
      super.startActivityForResult(paramIntent, i);
    }
    return i;
  }
  
  void preInitData()
  {
    this.mUrl = getUrlFromIntent();
    this.mUIStyleHandler.a(this.mUrl);
    if (this.mUIStyle.jdField_a_of_type_Long != 4L)
    {
      if ((this.mUIStyle.jdField_a_of_type_Long & 0x2) != 0L) {
        this.intent.putExtra("hide_more_button", true);
      }
      if ((this.mUIStyle.jdField_a_of_type_Long & 1L) != 0L) {
        this.intent.putExtra("webStyle", "noBottomBar");
      }
      if ((this.mUIStyle.jdField_a_of_type_Long & 0x100000) > 0L) {
        this.intent.putExtra("ignoreLoginWeb", true);
      }
    }
  }
  
  public void reset()
  {
    ensureShare().reset();
  }
  
  public void setCurUrl(String paramString)
  {
    this.mUrl = paramString;
  }
  
  public boolean setShareUrl(String paramString)
  {
    return ensureShare().setShareUrl(paramString);
  }
  
  public boolean setSummary(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    return ensureShare().setSummary(paramString1, paramString2, paramString3, paramString4, paramBundle);
  }
  
  public void setTitle(String paramString)
  {
    this.mSwiftTitleUI.c(paramString);
  }
  
  public void setWebView(TouchWebView paramTouchWebView)
  {
    this.webView = paramTouchWebView;
  }
  
  public boolean shareStructMsgForH5(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    return ensureShare().shareStructMsgForH5(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
  }
  
  public void showActionSheet()
  {
    SwiftBrowserComponentsProvider.SwiftBrowserComponent localSwiftBrowserComponent = (SwiftBrowserComponentsProvider.SwiftBrowserComponent)this.mComponentsProvider.a(4);
    ((IWebviewApi)QRoute.api(IWebviewApi.class)).showActionSheet(this.mUIStyle.jdField_a_of_type_Long, localSwiftBrowserComponent, ensureShare());
  }
  
  public final int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    CustomWebView localCustomWebView = paramWebViewPlugin.mRuntime.a();
    if (localCustomWebView == null) {
      return -1;
    }
    if (localCustomWebView.getPluginEngine() == null) {
      return -1;
    }
    int i = WebViewUtil.a(paramWebViewPlugin);
    if (i == -1)
    {
      if (QLog.isColorLevel())
      {
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("switchRequestCode failed: webView index=");
        paramWebViewPlugin.append(0);
        paramWebViewPlugin.append(", pluginIndex=");
        paramWebViewPlugin.append(i);
        QLog.d("WebLog_WebViewFragment", 2, paramWebViewPlugin.toString());
      }
      return -1;
    }
    return i << 8 & 0xFF00 | 0x0 | paramByte & 0xFF;
  }
  
  public int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte, boolean paramBoolean)
  {
    return switchRequestCode(paramWebViewPlugin, paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragment
 * JD-Core Version:    0.7.0.1
 */