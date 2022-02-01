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
    if (QLog.isColorLevel())
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("handleWriteBlog actionString: ");
      paramArrayOfString.append(paramWebViewPlugin.getAction());
      QLog.d("QzoneBlogJsPlugin", 2, paramArrayOfString.toString());
    }
    QZoneHelper.forwardToQzoneTransluentActivity(paramPluginRuntime.d(), QZoneHelper.UserInfo.getInstance(), paramWebViewPlugin);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2.equals("Qzone")) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if (paramString3.equalsIgnoreCase("writeBlogSuccess"))
      {
        handleWriteBlog(this.parentPlugin, this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneBlogJsPlugin
 * JD-Core Version:    0.7.0.1
 */