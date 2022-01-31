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
  public static String a;
  public static String b = "setPGCNavViewSetting";
  
  static
  {
    jdField_a_of_type_JavaLangString = "Qzone";
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals(jdField_a_of_type_JavaLangString)) || (!b.equals(paramString3))) {
      return false;
    }
    QZLog.i("QzoneHomePageJsPlugin", 4, "navigation url:" + paramString1 + " pkgName:" + paramString2 + " method:" + paramString3 + " jsonString:" + paramVarArgs[0]);
    paramJsBridgeListener = new Intent("JsCallReflushNavigationBar");
    paramJsBridgeListener.putExtra("navigationBar", paramVarArgs[0]);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().sendBroadcast(paramJsBridgeListener);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.famous.QzoneHomePageJsPlugin
 * JD-Core Version:    0.7.0.1
 */