import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppContentView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.videoceiling.GdtWebViewBuilder;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.smtt.sdk.WebView;

public class kxs
  extends GdtWebViewBuilder
{
  public kxs(ReadInJoyNativeAdAppContentView paramReadInJoyNativeAdAppContentView, Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramIntent, paramAppInterface);
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.a(paramWebView, paramString, paramBitmap);
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    GdtLog.b("AbsWebView", "shouldOverrideUrlLoading:" + paramString);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge://"))) {}
    Object localObject;
    do
    {
      return true;
      localObject = ((CustomWebView)paramWebView).a();
      if ((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        if ((localObject != null) && (((WebViewPluginEngine)localObject).a(paramString, 16L, null))) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      paramString = Uri.parse(paramString);
      localObject = paramString.getScheme();
    } while (!AuthorizeConfig.a().a(paramWebView.getUrl(), (String)localObject).booleanValue());
    paramWebView = new Intent("android.intent.action.VIEW", paramString);
    paramWebView.addFlags(268435456);
    try
    {
      this.e.startActivity(paramWebView);
      return true;
    }
    catch (ActivityNotFoundException paramWebView)
    {
      GdtLog.d("AbsWebView", paramWebView.toString());
    }
    return true;
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    super.b(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kxs
 * JD-Core Version:    0.7.0.1
 */