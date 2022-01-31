import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopWebview;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.smtt.sdk.WebView;

public class nrv
  extends nrx
{
  public nrv(EcshopNewPageFragment paramEcshopNewPageFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView)
  {
    super(paramContext, paramActivity, paramAppInterface, paramTouchWebView);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    EcshopNewPageFragment.a(this.a).setVisibility(0);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrv
 * JD-Core Version:    0.7.0.1
 */