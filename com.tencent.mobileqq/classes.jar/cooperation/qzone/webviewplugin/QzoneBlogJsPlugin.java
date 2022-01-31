package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

public class QzoneBlogJsPlugin
  extends QzoneInternalWebViewPlugin
{
  private static void a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    paramWebViewPlugin = new Intent("action_js2qzone");
    paramArrayOfString = new Bundle();
    paramArrayOfString.putString("cmd", "writeBlogSuccess");
    paramWebViewPlugin.putExtras(paramArrayOfString);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneBlogJsPlugin", 2, "handleWriteBlog actionString: " + paramWebViewPlugin.getAction());
    }
    QZoneHelper.a(paramPluginRuntime.a(), QZoneHelper.UserInfo.a(), paramWebViewPlugin);
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.a == null) || (this.a.mRuntime == null)) {}
    while (!paramString3.equalsIgnoreCase("writeBlogSuccess")) {
      return false;
    }
    a(this.a, this.a.mRuntime, paramVarArgs);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneBlogJsPlugin
 * JD-Core Version:    0.7.0.1
 */