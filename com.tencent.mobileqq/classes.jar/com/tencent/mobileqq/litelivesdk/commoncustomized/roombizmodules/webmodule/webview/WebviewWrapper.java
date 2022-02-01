package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider;
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
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private JsBizAdapter jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter;
  private LiteLiveJsProvider jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider;
  private LiteLiveSdkWebViewBaseBuilder jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder;
  private LiveBusinessJsInterface jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiveBusinessJsInterface;
  private final CloseGuard jdField_a_of_type_CooperationQzoneCloseGuard = CloseGuard.get();
  private boolean jdField_a_of_type_Boolean;
  
  public WebviewWrapper(Context paramContext, JsBizAdapter paramJsBizAdapter, LiteLiveJsProvider paramLiteLiveJsProvider, LiveBusinessJsInterface paramLiveBusinessJsInterface, View paramView)
  {
    this(paramContext, false, paramJsBizAdapter, paramLiteLiveJsProvider, paramLiveBusinessJsInterface, paramView);
  }
  
  public WebviewWrapper(Context paramContext, boolean paramBoolean, JsBizAdapter paramJsBizAdapter, LiteLiveJsProvider paramLiteLiveJsProvider, LiveBusinessJsInterface paramLiveBusinessJsInterface, View paramView)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter = paramJsBizAdapter;
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider = paramLiteLiveJsProvider;
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiveBusinessJsInterface = paramLiveBusinessJsInterface;
    this.jdField_a_of_type_AndroidViewView = paramView;
    preInit();
  }
  
  public void a()
  {
    QLog.i("WebviewWrapper", 1, "ilivetime WebViewDirector start ");
    new WebViewDirector(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder).a(null, LiteLiveSdkWebViewPluginManager.a().a(), null);
    QLog.i("WebviewWrapper", 1, "ilivetime WebViewDirector end ");
  }
  
  public void callJs(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder.a(paramString);
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
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder.c();
    }
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void onDetach()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      ViewParent localViewParent = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeAllViewsInLayout();
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
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder.b();
    }
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder.a();
    }
  }
  
  public void onWebViewReady(Intent paramIntent, boolean paramBoolean)
  {
    boolean bool1 = true;
    if ((paramIntent == null) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {}
    String str2;
    String str1;
    do
    {
      boolean bool2;
      do
      {
        return;
        str2 = paramIntent.getStringExtra("wns_proxy_http_data");
        str1 = paramIntent.getStringExtra("url");
        bool2 = TextUtils.isEmpty(str2);
      } while (((bool2) && (TextUtils.isEmpty(str1))) || ((!paramBoolean) && (bool2)));
      boolean bool3 = paramIntent.getBooleanExtra("key_wns_cache_hit", false);
      if (QLog.isColorLevel()) {
        QLog.i("WebviewWrapper", 2, "LiteLiveSdk load Url: " + str1 + ", wns proxy html hit caches:" + bool3);
      }
      if (bool3)
      {
        QLog.i("WebviewWrapper", 2, "bHitCache is true");
        return;
      }
      if ((!paramBoolean) || (!bool2)) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(str1);
    } while (!QLog.isColorLevel());
    QLog.i("WebviewWrapper", 2, "LiteLiveSdk load Url: " + str1 + ", wns proxy html return failed!");
    return;
    String str3 = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
    if ((TextUtils.isEmpty(str3)) || ("about:blank".equals(str3))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {}
      try
      {
        if (paramIntent.getBooleanExtra("need_force_refresh", false))
        {
          QLog.i("WebviewWrapper", 2, "isCurrentUrlEmpty loadDataWithBaseURL");
          WebSoPlugin.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, str1, str2);
        }
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          QLog.e("WebviewWrapper", 1, "onwebview ready exception", paramIntent);
          continue;
          paramBoolean = false;
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      paramIntent = new StringBuilder().append("load Url: ").append(str1).append(", htmlBody(true), currentUrl(");
      if (i != 0) {
        break label317;
      }
      paramBoolean = bool1;
      QLog.i("WebviewWrapper", 2, paramBoolean + ")");
      return;
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
        WebSettings localWebSettings = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings();
        if (localWebSettings != null)
        {
          localWebSettings.setMixedContentMode(0);
          localWebSettings.setMixedContentMode(0);
        }
      }
      QLog.i("WebviewWrapper", 2, "new TouchWebView cost " + (System.currentTimeMillis() - l));
    }
  }
  
  public void setOnWebviewTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnTouchListener(paramOnTouchListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebviewWrapper
 * JD-Core Version:    0.7.0.1
 */