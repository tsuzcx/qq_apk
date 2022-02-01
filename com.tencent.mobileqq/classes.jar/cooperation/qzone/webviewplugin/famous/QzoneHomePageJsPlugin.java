package cooperation.qzone.webviewplugin.famous;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin;

public class QzoneHomePageJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static String METHOD_NAME = "setPGCNavViewSetting";
  public static String PKG_NAME = "Qzone";
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (paramString2.equals(PKG_NAME))
    {
      if (!METHOD_NAME.equals(paramString3)) {
        return false;
      }
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("navigation url:");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append(" pkgName:");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(" method:");
      paramJsBridgeListener.append(paramString3);
      paramJsBridgeListener.append(" jsonString:");
      paramJsBridgeListener.append(paramVarArgs[0]);
      QZLog.i("QzoneHomePageJsPlugin", 4, paramJsBridgeListener.toString());
      paramJsBridgeListener = new Intent("JsCallReflushNavigationBar");
      paramJsBridgeListener.putExtra("navigationBar", paramVarArgs[0]);
      if ((this.parentPlugin != null) && (this.parentPlugin.mRuntime != null) && (this.parentPlugin.mRuntime.a() != null)) {
        this.parentPlugin.mRuntime.a().sendBroadcast(paramJsBridgeListener);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.famous.QzoneHomePageJsPlugin
 * JD-Core Version:    0.7.0.1
 */