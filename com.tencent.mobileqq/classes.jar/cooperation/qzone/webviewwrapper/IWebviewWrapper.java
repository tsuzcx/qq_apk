package cooperation.qzone.webviewwrapper;

import android.app.Activity;
import android.content.Intent;
import android.view.View.OnTouchListener;
import com.tencent.smtt.sdk.WebView;

public abstract interface IWebviewWrapper
{
  public abstract void callJs(String paramString);
  
  public abstract WebView getWebview();
  
  public abstract void onDestroy();
  
  public abstract void onDetach();
  
  public abstract void onInit(Activity paramActivity, Intent paramIntent, String paramString, IWebviewListener paramIWebviewListener);
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onWebViewReady(Intent paramIntent, boolean paramBoolean);
  
  public abstract void preInit();
  
  public abstract void setOnWebviewTouchListener(View.OnTouchListener paramOnTouchListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.webviewwrapper.IWebviewWrapper
 * JD-Core Version:    0.7.0.1
 */