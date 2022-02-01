package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.App;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.CloseGuard;
import cooperation.qzone.webviewwrapper.IWebviewListener;
import cooperation.qzone.webviewwrapper.IWebviewWrapper;

public class WebviewWrapper
  implements IWebviewWrapper
{
  protected Context a;
  private View jdField_a_of_type_AndroidViewView;
  protected TouchWebView a;
  private JsBizAdapter jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter;
  private LiteLiveJsProvider jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider;
  private App jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp;
  protected LiteLiveSdkWebViewBaseBuilder a;
  private LiveBusinessJsInterface jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiveBusinessJsInterface;
  protected final CloseGuard a;
  private boolean jdField_a_of_type_Boolean;
  
  public WebviewWrapper(Context paramContext, JsBizAdapter paramJsBizAdapter, LiteLiveJsProvider paramLiteLiveJsProvider, LiveBusinessJsInterface paramLiveBusinessJsInterface, View paramView)
  {
    this(paramContext, false, paramJsBizAdapter, paramLiteLiveJsProvider, paramLiveBusinessJsInterface, paramView);
  }
  
  public WebviewWrapper(Context paramContext, boolean paramBoolean, JsBizAdapter paramJsBizAdapter, LiteLiveJsProvider paramLiteLiveJsProvider, LiveBusinessJsInterface paramLiveBusinessJsInterface, View paramView)
  {
    this.jdField_a_of_type_CooperationQzoneCloseGuard = CloseGuard.get();
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter = paramJsBizAdapter;
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider = paramLiteLiveJsProvider;
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiveBusinessJsInterface = paramLiveBusinessJsInterface;
    this.jdField_a_of_type_AndroidViewView = paramView;
    preInit();
  }
  
  public LiteLiveJsProvider a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider;
  }
  
  public App a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp;
  }
  
  public void a()
  {
    QLog.i("WebviewWrapper", 1, "ilivetime WebViewDirector start ");
    new WebViewDirector(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder).a(null, LiteLiveSdkWebViewPluginManager.a().a(), null);
    QLog.i("WebviewWrapper", 1, "ilivetime WebViewDirector end ");
  }
  
  public void a(Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    LiteLiveSdkWebViewBaseBuilder localLiteLiveSdkWebViewBaseBuilder = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder;
    if (localLiteLiveSdkWebViewBaseBuilder != null) {
      localLiteLiveSdkWebViewBaseBuilder.a(paramContext, paramJsBizAdapter);
    }
  }
  
  public void a(App paramApp)
  {
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp = paramApp;
  }
  
  public void callJs(String paramString)
  {
    LiteLiveSdkWebViewBaseBuilder localLiteLiveSdkWebViewBaseBuilder = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder;
    if (localLiteLiveSdkWebViewBaseBuilder != null) {
      localLiteLiveSdkWebViewBaseBuilder.a(paramString);
    }
  }
  
  protected void finalize()
  {
    try
    {
      this.jdField_a_of_type_CooperationQzoneCloseGuard.warnIfOpen();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public WebView getWebview()
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_CooperationQzoneCloseGuard.close();
    onDetach();
    LiteLiveSdkWebViewBaseBuilder localLiteLiveSdkWebViewBaseBuilder = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder;
    if (localLiteLiveSdkWebViewBaseBuilder != null) {
      localLiteLiveSdkWebViewBaseBuilder.c();
    }
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void onDetach()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localObject != null)
    {
      localObject = ((TouchWebView)localObject).getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeAllViewsInLayout();
      }
    }
  }
  
  public void onInit(Activity paramActivity, Intent paramIntent, String paramString, IWebviewListener paramIWebviewListener)
  {
    this.jdField_a_of_type_CooperationQzoneCloseGuard.open("onDestroy");
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder = new LiteLiveSdkWebViewBaseBuilder(this.jdField_a_of_type_AndroidContentContext, paramActivity, paramIntent, LiteLiveSdkWebViewPluginManager.a().a(), false, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter, this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider, this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiveBusinessJsInterface, this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder.a(new WebviewWrapper.1(this, paramIWebviewListener));
  }
  
  public void onPause()
  {
    LiteLiveSdkWebViewBaseBuilder localLiteLiveSdkWebViewBaseBuilder = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder;
    if (localLiteLiveSdkWebViewBaseBuilder != null) {
      localLiteLiveSdkWebViewBaseBuilder.b();
    }
  }
  
  public void onResume()
  {
    LiteLiveSdkWebViewBaseBuilder localLiteLiveSdkWebViewBaseBuilder = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder;
    if (localLiteLiveSdkWebViewBaseBuilder != null) {
      localLiteLiveSdkWebViewBaseBuilder.a();
    }
  }
  
  public void onWebViewReady(Intent paramIntent, boolean paramBoolean)
  {
    String str2;
    String str1;
    int i;
    if (paramIntent != null)
    {
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
        return;
      }
      str2 = paramIntent.getStringExtra("wns_proxy_http_data");
      str1 = paramIntent.getStringExtra("url");
      boolean bool1 = TextUtils.isEmpty(str2);
      if ((bool1) && (TextUtils.isEmpty(str1))) {
        return;
      }
      if ((!paramBoolean) && (bool1)) {
        return;
      }
      boolean bool2 = paramIntent.getBooleanExtra("key_wns_cache_hit", false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LiteLiveSdk load Url: ");
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append(", wns proxy html hit caches:");
        ((StringBuilder)localObject).append(bool2);
        QLog.i("WebviewWrapper", 2, ((StringBuilder)localObject).toString());
      }
      if (bool2)
      {
        QLog.i("WebviewWrapper", 2, "bHitCache is true");
        return;
      }
      if ((paramBoolean) && (bool1))
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(str1);
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("LiteLiveSdk load Url: ");
          paramIntent.append(str1);
          paramIntent.append(", wns proxy html return failed!");
          QLog.i("WebviewWrapper", 2, paramIntent.toString());
        }
        return;
      }
      Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"about:blank".equals(localObject))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {}
    }
    try
    {
      if (!paramIntent.getBooleanExtra("need_force_refresh", false)) {
        break label289;
      }
      QLog.i("WebviewWrapper", 2, "isCurrentUrlEmpty loadDataWithBaseURL");
      WebSoPlugin.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, str1, str2);
    }
    catch (Exception paramIntent)
    {
      label280:
      break label280;
    }
    QLog.e("WebviewWrapper", 1, "onwebview ready exception", paramIntent);
    label289:
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("load Url: ");
      paramIntent.append(str1);
      paramIntent.append(", htmlBody(true), currentUrl(");
      paramIntent.append(i ^ 0x1);
      paramIntent.append(")");
      QLog.i("WebviewWrapper", 2, paramIntent.toString());
    }
  }
  
  public void preInit()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)
    {
      long l = System.currentTimeMillis();
      if (this.jdField_a_of_type_Boolean) {
        QbSdk.forceSysWebView();
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = WebViewPool.a.a();
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings();
        if (localObject != null)
        {
          ((WebSettings)localObject).setUserAgentString("");
          ((WebSettings)localObject).setMixedContentMode(0);
          ((WebSettings)localObject).setMixedContentMode(0);
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("new TouchWebView cost ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.i("WebviewWrapper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void setOnWebviewTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    TouchWebView localTouchWebView = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localTouchWebView != null) {
      localTouchWebView.setOnTouchListener(paramOnTouchListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebviewWrapper
 * JD-Core Version:    0.7.0.1
 */