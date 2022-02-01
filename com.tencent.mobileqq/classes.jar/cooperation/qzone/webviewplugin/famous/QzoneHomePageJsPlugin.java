package cooperation.qzone.webviewplugin.famous;

import android.app.Activity;
import android.content.Intent;
import bgve;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin;

public class QzoneHomePageJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static String METHOD_NAME = "setPGCNavViewSetting";
  public static String PKG_NAME = "Qzone";
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals(PKG_NAME)) || (!METHOD_NAME.equals(paramString3))) {
      return false;
    }
    QZLog.i("QzoneHomePageJsPlugin", 4, "navigation url:" + paramString1 + " pkgName:" + paramString2 + " method:" + paramString3 + " jsonString:" + paramVarArgs[0]);
    paramJsBridgeListener = new Intent("JsCallReflushNavigationBar");
    paramJsBridgeListener.putExtra("navigationBar", paramVarArgs[0]);
    if ((this.parentPlugin != null) && (this.parentPlugin.mRuntime != null) && (this.parentPlugin.mRuntime.a() != null)) {
      this.parentPlugin.mRuntime.a().sendBroadcast(paramJsBridgeListener);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.famous.QzoneHomePageJsPlugin
 * JD-Core Version:    0.7.0.1
 */