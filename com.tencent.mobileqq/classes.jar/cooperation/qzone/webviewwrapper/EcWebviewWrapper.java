package cooperation.qzone.webviewwrapper;

import aadt;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import bgtj;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.CloseGuard;

public class EcWebviewWrapper
  implements IWebviewWrapper
{
  private static final String TAG = "WebviewWrapper";
  private final CloseGuard guard = CloseGuard.get();
  private Context mContext;
  private QzoneWebViewBaseBuilder mWebViewBuilder;
  private TouchWebView mWebview;
  
  public EcWebviewWrapper(Context paramContext)
  {
    this.mContext = paramContext;
    preInit();
  }
  
  public void callJs(String paramString)
  {
    if (this.mWebViewBuilder != null) {
      this.mWebViewBuilder.callJs(paramString);
    }
  }
  
  protected void finalize()
  {
    try
    {
      this.guard.warnIfOpen();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public WebView getWebview()
  {
    return this.mWebview;
  }
  
  public void onDestroy()
  {
    this.guard.close();
    onDetach();
    if (this.mWebViewBuilder != null) {
      this.mWebViewBuilder.onDestroy();
    }
    this.mWebview = null;
    this.mContext = null;
  }
  
  public void onDetach()
  {
    if (this.mWebview != null)
    {
      ViewParent localViewParent = this.mWebview.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeAllViewsInLayout();
      }
    }
  }
  
  public void onInit(Activity paramActivity, Intent paramIntent, String paramString, IWebviewListener paramIWebviewListener)
  {
    this.guard.open("onDestroy");
    this.mWebViewBuilder = new QzoneWebViewBaseBuilder(this.mContext, paramActivity, paramIntent, QzoneWebViewPluginManager.getInstance().getRuntime(), true);
    this.mWebview.setVisibility(4);
    this.mWebViewBuilder.setWebView(this.mWebview);
    this.mWebViewBuilder.setWebviewStatusListener(new EcWebviewWrapper.1(this, paramIWebviewListener));
    new bgtj(this.mWebViewBuilder).a(null, QzoneWebViewPluginManager.getInstance().getRuntime(), null);
  }
  
  public void onPause()
  {
    if (this.mWebViewBuilder != null) {
      this.mWebViewBuilder.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.mWebViewBuilder != null) {
      this.mWebViewBuilder.onResume();
    }
  }
  
  public void onWebViewReady(Intent paramIntent, boolean paramBoolean)
  {
    boolean bool1 = true;
    if ((paramIntent == null) || (this.mWebview == null)) {}
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
      this.mWebview.loadUrl(str1);
    } while (!QLog.isColorLevel());
    QLog.i("WebviewWrapper", 2, "CoverQzoneShowWebView load Url: " + str1 + ", wns proxy html return failed!");
    return;
    String str3 = this.mWebview.getUrl();
    if ((TextUtils.isEmpty(str3)) || ("about:blank".equals(str3))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {}
      try
      {
        if (paramIntent.getBooleanExtra("need_force_refresh", false))
        {
          QLog.i("WebviewWrapper", 2, "saxon@ isCurrentUrlEmpty loadDataWithBaseURL");
          aadt.a(this.mWebview, str1, str2);
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
    if (this.mWebview == null)
    {
      long l = System.currentTimeMillis();
      this.mWebview = new TouchWebView(this.mContext);
      if (Build.VERSION.SDK_INT >= 21)
      {
        WebSettings localWebSettings = this.mWebview.getSettings();
        if (localWebSettings != null)
        {
          localWebSettings.setMixedContentMode(0);
          localWebSettings.setMixedContentMode(0);
        }
      }
      QLog.i("WebviewWrapper", 2, "saxon@ new TouchWebView cost " + (System.currentTimeMillis() - l));
    }
  }
  
  public void setOnWebviewTouchListener(View.OnTouchListener paramOnTouchListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewwrapper.EcWebviewWrapper
 * JD-Core Version:    0.7.0.1
 */