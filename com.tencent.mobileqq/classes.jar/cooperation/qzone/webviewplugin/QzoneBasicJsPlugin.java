package cooperation.qzone.webviewplugin;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneBasicJsPlugin
  extends QzoneInternalWebViewPlugin
{
  private String a;
  
  public QzoneBasicJsPlugin()
  {
    this.jdField_a_of_type_JavaLangString = QzoneBasicJsPlugin.class.getSimpleName();
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {}
    while ((!"openUrl".equals(paramString3)) || (paramVarArgs == null) || (paramVarArgs.length < 1)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "openUrl=" + paramVarArgs[0]);
    }
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("url");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().loadUrl(paramJsBridgeListener);
      return false;
    }
    catch (JSONException paramJsBridgeListener)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "handle openUrl", paramJsBridgeListener);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneBasicJsPlugin
 * JD-Core Version:    0.7.0.1
 */