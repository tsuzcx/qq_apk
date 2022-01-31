package cooperation.qzone.webviewwrapper;

import amnv;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.CloseGuard;

public class WebviewWrapper
  implements IWebviewWrapper
{
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  private Context jdField_a_of_type_AndroidContentContext;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private final CloseGuard jdField_a_of_type_CooperationQzoneCloseGuard = CloseGuard.a();
  private QzoneWebViewBaseBuilder jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewBaseBuilder;
  
  public WebviewWrapper(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    preInit();
  }
  
  public void callJs(String paramString)
  {
    if (this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewBaseBuilder != null) {
      this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewBaseBuilder.a(paramString);
    }
  }
  
  protected void finalize()
  {
    try
    {
      this.jdField_a_of_type_CooperationQzoneCloseGuard.b();
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
    this.jdField_a_of_type_CooperationQzoneCloseGuard.a();
    onDetach();
    if (this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewBaseBuilder != null) {
      this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewBaseBuilder.d();
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
    this.jdField_a_of_type_CooperationQzoneCloseGuard.a("onDestroy");
    this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewBaseBuilder = new QzoneWebViewBaseBuilder(this.jdField_a_of_type_AndroidContentContext, paramActivity, paramIntent, QzoneWebViewPluginManager.a().a(), true);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setVisibility(4);
    this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewBaseBuilder.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewBaseBuilder.a(new amnv(this, paramIWebviewListener));
    new WebViewDirector(this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewBaseBuilder).a(null, QzoneWebViewPluginManager.a().a(), null);
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewBaseBuilder != null) {
      this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewBaseBuilder.c();
    }
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewBaseBuilder != null) {
      this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewBaseBuilder.b();
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
        QLog.i("WebviewWrapper", 2, "CoverQzoneShowWebView load Url: " + str1 + ", wns proxy html hit caches:" + bool3);
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
    QLog.i("WebviewWrapper", 2, "CoverQzoneShowWebView load Url: " + str1 + ", wns proxy html return failed!");
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
          QLog.i("WebviewWrapper", 2, "saxon@ isCurrentUrlEmpty loadDataWithBaseURL");
          WebSoPlugin.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, str1, str2);
        }
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          QLog.e("WebviewWrapper", 1, "saxon@ onwebview ready exception", paramIntent);
          continue;
          paramBoolean = false;
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      paramIntent = new StringBuilder().append("CoverQzoneShowWebView load Url: ").append(str1).append(", htmlBody(true), currentUrl(");
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
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(this.jdField_a_of_type_AndroidContentContext);
      QLog.i("WebviewWrapper", 2, "saxon@ new TouchWebView cost " + (System.currentTimeMillis() - l));
    }
  }
  
  public void setOnWebviewTouchListener(View.OnTouchListener paramOnTouchListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewwrapper.WebviewWrapper
 * JD-Core Version:    0.7.0.1
 */