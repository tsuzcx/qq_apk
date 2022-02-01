package cooperation.qqreader.js;

import android.text.TextUtils;
import cooperation.qqreader.host.webview.ReaderBaseWebViewPlugin;
import cooperation.qqreader.proxy.ReaderJsCallback;

class ReaderJsPlugin$1
  implements ReaderJsCallback
{
  ReaderJsPlugin$1(ReaderJsPlugin paramReaderJsPlugin) {}
  
  public void onCallback(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      ReaderJsPlugin.a(this.a, paramString1, new String[] { paramString2 });
    }
  }
  
  public void onInitPluginCallBack(ReaderBaseWebViewPlugin paramReaderBaseWebViewPlugin)
  {
    if (paramReaderBaseWebViewPlugin != null) {
      paramReaderBaseWebViewPlugin.init(this.a.mRuntime, ReaderJsPlugin.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.js.ReaderJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */