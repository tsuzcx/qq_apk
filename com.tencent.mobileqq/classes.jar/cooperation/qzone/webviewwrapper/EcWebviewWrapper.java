package cooperation.qzone.webviewwrapper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.mobileqq.webview.WebViewDirector;
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
    QzoneWebViewBaseBuilder localQzoneWebViewBaseBuilder = this.mWebViewBuilder;
    if (localQzoneWebViewBaseBuilder != null) {
      localQzoneWebViewBaseBuilder.callJs(paramString);
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
    QzoneWebViewBaseBuilder localQzoneWebViewBaseBuilder = this.mWebViewBuilder;
    if (localQzoneWebViewBaseBuilder != null) {
      localQzoneWebViewBaseBuilder.onDestroy();
    }
    this.mWebview = null;
    this.mContext = null;
  }
  
  public void onDetach()
  {
    Object localObject = this.mWebview;
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
    this.guard.open("onDestroy");
    this.mWebViewBuilder = new QzoneWebViewBaseBuilder(this.mContext, paramActivity, paramIntent, QzoneWebViewPluginManager.getInstance().getRuntime(), true);
    this.mWebview.setVisibility(4);
    this.mWebViewBuilder.setWebView(this.mWebview);
    this.mWebViewBuilder.setWebviewStatusListener(new EcWebviewWrapper.1(this, paramIWebviewListener));
    new WebViewDirector(this.mWebViewBuilder).a(null, QzoneWebViewPluginManager.getInstance().getRuntime(), null);
  }
  
  public void onPause()
  {
    QzoneWebViewBaseBuilder localQzoneWebViewBaseBuilder = this.mWebViewBuilder;
    if (localQzoneWebViewBaseBuilder != null) {
      localQzoneWebViewBaseBuilder.onPause();
    }
  }
  
  public void onResume()
  {
    QzoneWebViewBaseBuilder localQzoneWebViewBaseBuilder = this.mWebViewBuilder;
    if (localQzoneWebViewBaseBuilder != null) {
      localQzoneWebViewBaseBuilder.onResume();
    }
  }
  
  public void onWebViewReady(Intent paramIntent, boolean paramBoolean)
  {
    String str2;
    String str1;
    int i;
    if (paramIntent != null)
    {
      if (this.mWebview == null) {
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
        ((StringBuilder)localObject).append("CoverQzoneShowWebView load Url: ");
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
        this.mWebview.loadUrl(str1);
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("CoverQzoneShowWebView load Url: ");
          paramIntent.append(str1);
          paramIntent.append(", wns proxy html return failed!");
          QLog.i("WebviewWrapper", 2, paramIntent.toString());
        }
        return;
      }
      Object localObject = this.mWebview.getUrl();
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
      QLog.i("WebviewWrapper", 2, "saxon@ isCurrentUrlEmpty loadDataWithBaseURL");
      WebSoPlugin.a(this.mWebview, str1, str2);
    }
    catch (Exception paramIntent)
    {
      label280:
      break label280;
    }
    QLog.e("WebviewWrapper", 1, "saxon@ onwebview ready exception", paramIntent);
    label289:
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("CoverQzoneShowWebView load Url: ");
      paramIntent.append(str1);
      paramIntent.append(", htmlBody(true), currentUrl(");
      paramIntent.append(i ^ 0x1);
      paramIntent.append(")");
      QLog.i("WebviewWrapper", 2, paramIntent.toString());
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
        localObject = this.mWebview.getSettings();
        if (localObject != null)
        {
          ((WebSettings)localObject).setMixedContentMode(0);
          ((WebSettings)localObject).setMixedContentMode(0);
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saxon@ new TouchWebView cost ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.i("WebviewWrapper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void setOnWebviewTouchListener(View.OnTouchListener paramOnTouchListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewwrapper.EcWebviewWrapper
 * JD-Core Version:    0.7.0.1
 */