package dualsim.common;

import android.webkit.WebView;

public abstract interface IKcActivationViewer
{
  public abstract WebView getWebView();
  
  public abstract void onDestroy();
  
  public abstract void startLoad();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dualsim.common.IKcActivationViewer
 * JD-Core Version:    0.7.0.1
 */