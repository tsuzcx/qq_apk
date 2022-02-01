package cooperation.comic.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.LiuHaiUtils;
import com.tencent.webbundle.sdk.IWebBundleRuntime;
import com.tencent.webbundle.sdk.WebBundleManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.comic.VipComicHelper;
import cooperation.comic.VipComicReportUtils;
import cooperation.comic.jsp.QQComicJsPlugin;
import cooperation.comic.jsp.QQComicJsPluginProxy;
import cooperation.comic.utils.FirstInObservable;
import cooperation.comic.utils.QQComicPluginBridge;
import cooperation.comic.webbundle.WebBundleFragment;
import java.net.URL;
import java.util.HashMap;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class QQComicFragment
  extends WebViewFragment
{
  private long jdField_a_of_type_Long;
  private QQComicJsPlugin jdField_a_of_type_CooperationComicJspQQComicJsPlugin;
  private Observer jdField_a_of_type_JavaUtilObserver;
  
  public static WebViewFragment a(Intent paramIntent)
  {
    if (Boolean.valueOf(paramIntent.getBooleanExtra("openWithWebBundle", false)).booleanValue()) {
      localObject1 = new WebBundleFragment();
    }
    for (;;)
    {
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putParcelable("intent", paramIntent);
      ((WebViewFragment)localObject1).setArguments((Bundle)localObject2);
      int i = paramIntent.getIntExtra("reportSourceFrom", 0);
      if (i != 0) {
        localObject2 = paramIntent.getStringExtra("url");
      }
      try
      {
        localObject2 = new URL((String)localObject2);
        VipComicHelper.c = ((URL)localObject2).getPath().substring(((URL)localObject2).getPath().lastIndexOf("/") + 1);
        VipComicHelper.a = i + "";
        if ((TextUtils.isEmpty(VipComicHelper.a)) || ("NULL".equalsIgnoreCase(VipComicHelper.a))) {
          QLog.e("WebLog_WebViewFragment", 1, "[webFragment] from is null");
        }
        for (;;)
        {
          VipComicHelper.b = paramIntent.getStringExtra("reportActionFrom");
          VipComicHelper.a();
          return localObject1;
          localObject1 = new QQComicFragment();
          break;
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewFragment", 2, "[webFragment] from is " + VipComicHelper.a);
          }
        }
        return localObject1;
      }
      catch (Exception paramIntent) {}
    }
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    return String.format("%s=%s; PATH=/; DOMAIN=.%s; Max-Age=31556926;", new Object[] { paramString1, paramString2, paramString3 });
  }
  
  private void a() {}
  
  private void b()
  {
    long l = System.currentTimeMillis();
    CookieManager localCookieManager = CookieManager.getInstance();
    String str1 = VipComicReportUtils.a();
    if (TextUtils.isEmpty(str1)) {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "the qimei is null");
      }
    }
    while (localCookieManager == null) {
      return;
    }
    String str2 = localCookieManager.getCookie(this.mUrl);
    if (str2 != null)
    {
      if (str2.contains("qimei="))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewFragment", 2, "the cookie has qimei!");
        }
        QLog.i("WebLog_WebViewFragment", 1, "get qimei cost: " + (System.currentTimeMillis() - l));
        return;
      }
      str1 = a("qimei", str1, "vip.qq.com");
      QLog.d("WebLog_WebViewFragment", 4, "new cookie:" + str1);
      if ((this.mUrl != null) && (!this.mUrl.isEmpty())) {
        localCookieManager.setCookie(this.mUrl, str1);
      }
      c();
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "cookieManager sync after cookie is " + localCookieManager.getCookie(this.mUrl));
      }
    }
    for (;;)
    {
      QLog.i("WebLog_WebViewFragment", 1, "set qimei cost: " + (System.currentTimeMillis() - l));
      return;
      QLog.e("WebLog_WebViewFragment", 1, "cookie is null");
    }
  }
  
  private void c()
  {
    try
    {
      QLog.d("WebLog_WebViewFragment", 1, "[cookie] sync cookie.");
      CookieSyncManager.getInstance().sync();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      if (this.mApp.getApp() != null)
      {
        CookieSyncManager.createInstance(this.mApp.getApp());
        CookieSyncManager.getInstance().sync();
        QLog.w("WebLog_WebViewFragment", 2, "sync failed, createInstance first");
        return;
      }
      QLog.w("WebLog_WebViewFragment", 2, "application is null");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("WebLog_WebViewFragment", 1, "sync failed, encounter unexpected problem! ");
    }
  }
  
  private void d()
  {
    if ((getHostActivity() == null) || (this.contentView == null)) {}
    for (;;)
    {
      return;
      LiuHaiUtils.a(getHostActivity());
      LiuHaiUtils.enableNotch(getHostActivity());
      if (LiuHaiUtils.jdField_a_of_type_Boolean)
      {
        if ((this.jdField_a_of_type_Long & 1L) == 1L) {}
        for (int i = LiuHaiUtils.jdField_a_of_type_Int; this.contentView.a != null; i = 0)
        {
          this.contentView.a.setPadding(0, i, 0, 0);
          this.contentView.a.setBackgroundColor(-16777216);
          return;
        }
      }
    }
  }
  
  public QQComicJsPlugin a()
  {
    if (this.jdField_a_of_type_CooperationComicJspQQComicJsPlugin != null) {
      return this.jdField_a_of_type_CooperationComicJspQQComicJsPlugin;
    }
    if ((getWebView() != null) && (getWebView().getPluginEngine() != null))
    {
      WebViewPlugin localWebViewPlugin = getWebView().getPluginEngine().a("comic");
      if ((localWebViewPlugin instanceof QQComicJsPlugin))
      {
        this.jdField_a_of_type_CooperationComicJspQQComicJsPlugin = ((QQComicJsPlugin)localWebViewPlugin);
        return this.jdField_a_of_type_CooperationComicJspQQComicJsPlugin;
      }
    }
    return null;
  }
  
  public boolean a()
  {
    QQComicJsPlugin localQQComicJsPlugin = a();
    JSONObject localJSONObject1;
    if (localQQComicJsPlugin != null)
    {
      localQQComicJsPlugin = (QQComicJsPlugin)localQQComicJsPlugin;
      localJSONObject1 = new JSONObject();
    }
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("status", localQQComicJsPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      localJSONObject1.put("data", localJSONObject2);
      label54:
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "notifySecretModeChange. status=" + localQQComicJsPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      }
      if (!TextUtils.isEmpty(localQQComicJsPlugin.b)) {
        getWebView().callJs(localQQComicJsPlugin.b, new String[] { localJSONObject1.toString() });
      }
      return true;
    }
    catch (Exception localException)
    {
      break label54;
    }
  }
  
  String[] a()
  {
    String[] arrayOfString = new String[5];
    Object localObject = a();
    if ((localObject != null) && (((QQComicJsPlugin)localObject).jdField_a_of_type_CooperationComicJspQQComicJsPluginProxy != null))
    {
      localObject = ((QQComicJsPlugin)localObject).jdField_a_of_type_CooperationComicJspQQComicJsPluginProxy.a();
      if (localObject != null)
      {
        arrayOfString[0] = ((String)((HashMap)localObject).get("page_id"));
        arrayOfString[1] = ((String)((HashMap)localObject).get("obj_type"));
        arrayOfString[2] = ((String)((HashMap)localObject).get("ret_id"));
        arrayOfString[3] = ((String)((HashMap)localObject).get("ext2"));
        arrayOfString[4] = ((String)((HashMap)localObject).get("source"));
      }
    }
    return arrayOfString;
  }
  
  public void adjustWebViewTopMargin(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
    }
    int j = paramInt1;
    int k = paramInt2;
    if (!this.mUIStyleHandler.a.b)
    {
      if (!this.mUIStyle.m) {
        break label60;
      }
      k = paramInt2;
      j = paramInt1;
    }
    for (;;)
    {
      super.adjustWebViewTopMargin(j, k);
      return;
      label60:
      j = paramInt1;
      k = paramInt2;
      if ((this.jdField_a_of_type_Long & 1L) == 1L)
      {
        j = paramInt1;
        k = paramInt2;
        if (LiuHaiUtils.jdField_a_of_type_Boolean)
        {
          k = paramInt2 - i;
          j = paramInt1 - i;
        }
      }
    }
  }
  
  public SwiftBrowserComponentsProvider createComponentsProvider()
  {
    return new SwiftBrowserComponentsProvider(this, 127, new QQComicFragment.2(this));
  }
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    d();
    return super.doCreateLoopStep_Final(paramBundle);
  }
  
  public int doCreateLoopStep_InitWebView(Bundle paramBundle)
  {
    try
    {
      if ((this.mUrl != null) && (this.jdField_a_of_type_Long == 0L))
      {
        QLog.d("WebLog_WebViewFragment", 2, new Object[] { "dealWithWvx: url=", this.mUrl });
        String str = Uri.parse(this.mUrl).getQueryParameter("_wvx");
        if (str != null) {
          this.jdField_a_of_type_Long = Long.parseLong(str, 10);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("WebLog_WebViewFragment", 2, "dealWithWvx: ", localException);
      }
    }
    return super.doCreateLoopStep_InitWebView(paramBundle);
  }
  
  public String getUAMark()
  {
    return "VipComic";
  }
  
  public void initWebView()
  {
    super.initWebView();
    b();
  }
  
  public void onClick(View paramView)
  {
    if (((paramView == this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView) || (paramView == this.mSwiftTitleUI.d)) && (this.mSwiftTitleUI.jdField_a_of_type_Boolean))
    {
      this.mSwiftTitleUI.d(false);
      if ((this.browserApp != null) && (this.browserApp.getApp() != null)) {
        this.browserApp.getApp().getSharedPreferences("boodo_" + this.browserApp.getCurrentAccountUin(), 0).edit().putBoolean("private_read_red_dot", true).apply();
      }
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.intent.getParcelableExtra("defaultResultData");
    if ((paramBundle instanceof Intent)) {
      getActivity().setResult(0, (Intent)paramBundle);
    }
    a();
    VipComicHelper.a(this.mApp);
    VipComicHelper.a(getHostActivity());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQComicPluginBridge.c(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_JavaUtilObserver = null;
    FragmentActivity localFragmentActivity = getActivity();
    IWebBundleRuntime localIWebBundleRuntime = WebBundleManager.getInstance("comic").getRuntime();
    if ((localFragmentActivity != null) && (localFragmentActivity.isFinishing()) && (localIWebBundleRuntime != null) && (localFragmentActivity == localIWebBundleRuntime.getContext()))
    {
      WebBundleManager.getInstance("comic").destroy();
      QLog.w("WebLog_WebViewFragment", 1, "activity finish and destroy webBundle");
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    QLog.d("WebLog_WebViewFragment", 4, "QQComicFragment onPageFinished ");
    if (QQComicPluginBridge.a != null)
    {
      QLog.d("WebLog_WebViewFragment", 4, "QQComicPluginBridge sFirstInObservable is not null ");
      QQComicPluginBridge.a.a(paramWebView.getContext());
    }
    this.jdField_a_of_type_JavaUtilObserver = new QQComicFragment.1(this, paramWebView);
    QQComicPluginBridge.b(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void onStop()
  {
    super.onStop();
    QQComicJsPlugin localQQComicJsPlugin = a();
    if (localQQComicJsPlugin != null) {
      localQQComicJsPlugin.a();
    }
  }
  
  public void setImmersiveStatus(boolean paramBoolean)
  {
    super.setImmersiveStatus(paramBoolean);
    d();
  }
  
  public void showTitleBar(boolean paramBoolean)
  {
    super.showTitleBar(paramBoolean);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.ui.QQComicFragment
 * JD-Core Version:    0.7.0.1
 */