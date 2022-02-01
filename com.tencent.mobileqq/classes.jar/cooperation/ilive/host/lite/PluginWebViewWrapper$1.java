package cooperation.ilive.host.lite;

import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.LiveBusinessJsInterface;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebJsParams;
import cooperation.ilive.lite.module.IliveWebBizModule;

class PluginWebViewWrapper$1
  implements LiveBusinessJsInterface
{
  PluginWebViewWrapper$1(PluginWebViewWrapper paramPluginWebViewWrapper) {}
  
  public WebJsParams onJsParamsParse(String paramString)
  {
    return IliveWebBizModule.d(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.host.lite.PluginWebViewWrapper.1
 * JD-Core Version:    0.7.0.1
 */