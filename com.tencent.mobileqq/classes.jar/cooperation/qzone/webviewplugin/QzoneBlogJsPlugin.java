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
  public static final String NAMESPACE = "Qzone";
  private static final String TAG = "QzoneBlogJsPlugin";
  
  private static void handleWriteBlog(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    paramWebViewPlugin = new Intent("action_js2qzone");
    paramArrayOfString = new Bundle();
    paramArrayOfString.putString("cmd", "writeBlogSuccess");
    paramWebViewPlugin.putExtras(paramArrayOfString);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneBlogJsPlugin", 2, "handleWriteBlog actionString: " + paramWebViewPlugin.getAction());
    }
    QZoneHelper.forwardToQzoneTransluentActivity(paramPluginRuntime.a(), QZoneHelper.UserInfo.getInstance(), paramWebViewPlugin);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {}
    while (!paramString3.equalsIgnoreCase("writeBlogSuccess")) {
      return false;
    }
    handleWriteBlog(this.parentPlugin, this.parentPlugin.mRuntime, paramVarArgs);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneBlogJsPlugin
 * JD-Core Version:    0.7.0.1
 */