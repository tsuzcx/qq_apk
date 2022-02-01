package cooperation.qzone.webviewplugin;

import android.content.Intent;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QzoneReactMessageDeliverPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String NAMESPACE = "Qzone";
  
  private void deliverMsg(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramPluginRuntime == null)) {
      return;
    }
    QLog.i("QzoneReactMessageDeliverPlugin", 1, paramArrayOfString[0]);
    paramWebViewPlugin = new Intent("ReactNativeMsgDeliver");
    paramWebViewPlugin.putExtra("args", paramArrayOfString[0]);
    BaseApplication.getContext().sendBroadcast(paramWebViewPlugin);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"Qzone".equals(paramString2)) || (this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {}
    while (!"deliverMsg".equalsIgnoreCase(paramString3)) {
      return false;
    }
    deliverMsg(this.parentPlugin, this.parentPlugin.mRuntime, paramVarArgs);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneReactMessageDeliverPlugin
 * JD-Core Version:    0.7.0.1
 */