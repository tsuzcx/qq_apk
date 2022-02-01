package cooperation.ilive.host.lite;

import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.smtt.sdk.WebView;
import cooperation.ilive.host.lite.white.ITouchWebView;

public class PluginWebView
  implements ITouchWebView
{
  private WebView mWebView;
  
  public PluginWebView(WebView paramWebView)
  {
    this.mWebView = paramWebView;
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    WebView localWebView = this.mWebView;
    if (localWebView == null) {
      return;
    }
    localWebView.addJavascriptInterface(paramObject, paramString);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    WebView localWebView = this.mWebView;
    if (localWebView == null) {
      return;
    }
    localWebView.evaluateJavascript(paramString, new PluginWebView.1(this, paramValueCallback));
  }
  
  public View getContentView()
  {
    return this.mWebView;
  }
  
  public void loadUrl(String paramString)
  {
    WebView localWebView = this.mWebView;
    if (localWebView == null) {
      return;
    }
    localWebView.loadUrl(paramString);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    WebView localWebView = this.mWebView;
    if (localWebView == null) {
      return;
    }
    localWebView.setBackgroundColor(paramInt);
  }
  
  public void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    WebView localWebView = this.mWebView;
    if (localWebView == null) {
      return;
    }
    localWebView.setHorizontalScrollBarEnabled(paramBoolean);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    WebView localWebView = this.mWebView;
    if (localWebView == null) {
      return;
    }
    localWebView.setOverScrollMode(paramInt);
  }
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    WebView localWebView = this.mWebView;
    if (localWebView == null) {
      return;
    }
    localWebView.setVerticalScrollBarEnabled(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.host.lite.PluginWebView
 * JD-Core Version:    0.7.0.1
 */