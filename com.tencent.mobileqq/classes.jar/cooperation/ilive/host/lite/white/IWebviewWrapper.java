package cooperation.ilive.host.lite.white;

import android.content.Context;
import android.content.Intent;
import android.view.View.OnTouchListener;

public abstract interface IWebviewWrapper
{
  public abstract void callJs(String paramString);
  
  public abstract ITouchWebView getWebview();
  
  public abstract void onDestroy();
  
  public abstract void onDetach();
  
  public abstract void onInit(Context paramContext, Intent paramIntent, String paramString, IWebviewListener paramIWebviewListener);
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onWebViewReady(Intent paramIntent, boolean paramBoolean);
  
  public abstract void preInit();
  
  public abstract void setOnWebviewTouchListener(View.OnTouchListener paramOnTouchListener);
  
  public abstract void webViewDirectorConstruct();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.host.lite.white.IWebviewWrapper
 * JD-Core Version:    0.7.0.1
 */