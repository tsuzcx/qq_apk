import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopTabFragment;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopWebview;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.smtt.sdk.WebView;

public class opu
  extends opt
{
  public opu(EcshopTabFragment paramEcshopTabFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView, String paramString)
  {
    super(paramContext, paramActivity, paramAppInterface, paramTouchWebView, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    EcshopTabFragment.a(this.a).setVisibility(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     opu
 * JD-Core Version:    0.7.0.1
 */