package cooperation.qqreader.proxy;

import cooperation.qqreader.host.webview.ReaderBaseWebViewPlugin;

public abstract interface ReaderJsCallback
{
  public abstract void onCallback(String paramString1, String paramString2);
  
  public abstract void onInitPluginCallBack(ReaderBaseWebViewPlugin paramReaderBaseWebViewPlugin);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.proxy.ReaderJsCallback
 * JD-Core Version:    0.7.0.1
 */