import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppContentView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.smtt.sdk.WebView;

public class nph
  extends aave
{
  public nph(ReadInJoyNativeAdAppContentView paramReadInJoyNativeAdAppContentView, Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramIntent, paramAppInterface);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    paramWebView = this.a.findViewById(2131362681);
    if ((paramWebView != null) && (ReadInJoyNativeAdAppContentView.a(this.a) != null))
    {
      ReadInJoyNativeAdAppContentView.a(this.a).setVisibility(8);
      paramWebView.setVisibility(0);
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    aase.b("AbsWebView", "shouldOverrideUrlLoading:" + paramString);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge://"))) {}
    Object localObject;
    do
    {
      return true;
      localObject = ((CustomWebView)paramWebView).getPluginEngine();
      if ((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        if ((localObject != null) && (((WebViewPluginEngine)localObject).a(paramString, 16L, null))) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      paramString = Uri.parse(paramString);
      localObject = paramString.getScheme();
    } while (!myl.a().a(paramWebView.getUrl(), (String)localObject).booleanValue());
    paramWebView = new Intent("android.intent.action.VIEW", paramString);
    paramWebView.addFlags(268435456);
    try
    {
      this.mContext.startActivity(paramWebView);
      return true;
    }
    catch (ActivityNotFoundException paramWebView)
    {
      aase.d("AbsWebView", paramWebView.toString());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nph
 * JD-Core Version:    0.7.0.1
 */