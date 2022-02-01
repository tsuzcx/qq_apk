package cooperation.ilive.host.lite;

class PluginWebView$1
  implements com.tencent.smtt.sdk.ValueCallback<String>
{
  PluginWebView$1(PluginWebView paramPluginWebView, android.webkit.ValueCallback paramValueCallback) {}
  
  public void onReceiveValue(String paramString)
  {
    android.webkit.ValueCallback localValueCallback = this.val$var2;
    if (localValueCallback != null) {
      localValueCallback.onReceiveValue(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.host.lite.PluginWebView.1
 * JD-Core Version:    0.7.0.1
 */