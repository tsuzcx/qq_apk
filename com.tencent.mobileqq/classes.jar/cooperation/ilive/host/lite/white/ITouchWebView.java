package cooperation.ilive.host.lite.white;

import android.view.View;
import android.webkit.ValueCallback;

public abstract interface ITouchWebView
{
  public abstract void addJavascriptInterface(Object paramObject, String paramString);
  
  public abstract void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback);
  
  public abstract View getContentView();
  
  public abstract void loadUrl(String paramString);
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setHorizontalScrollBarEnabled(boolean paramBoolean);
  
  public abstract void setOverScrollMode(int paramInt);
  
  public abstract void setVerticalScrollBarEnabled(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.host.lite.white.ITouchWebView
 * JD-Core Version:    0.7.0.1
 */