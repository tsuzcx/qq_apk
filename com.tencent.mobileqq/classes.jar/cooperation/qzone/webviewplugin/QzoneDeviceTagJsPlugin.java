package cooperation.qzone.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import ankh;
import anki;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import mqq.os.MqqHandler;

public class QzoneDeviceTagJsPlugin
  extends QzoneInternalWebViewPlugin
  implements WebEventListener
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = QzoneBlogJsPlugin.class.getSimpleName();
  }
  
  private static void a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    paramPluginRuntime.a().getHandler(QzoneDeviceTagJsPlugin.class).post(new ankh(paramArrayOfString));
  }
  
  private static void b(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    paramPluginRuntime.a().getHandler(QzoneDeviceTagJsPlugin.class).post(new anki());
  }
  
  public void a()
  {
    super.a();
    RemoteHandleManager.a().b(this);
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"Qzone".equals(paramString2)) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if ("GetDeviceInfo".equalsIgnoreCase(paramString3))
    {
      RemoteHandleManager.a().a(this);
      b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("SetUserTail".equalsIgnoreCase(paramString3))
    {
      RemoteHandleManager.a().a(this);
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    return false;
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      do
      {
        do
        {
          return;
          paramBundle = paramBundle.getBundle("data");
          if (paramBundle != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(jdField_a_of_type_JavaLangString, 2, "call js function,bundle is empty");
        return;
        if (!"cmd.getDeviceInfos".equals(paramString)) {
          break;
        }
        paramString = paramBundle.getString("param.DeviceInfos");
      } while (TextUtils.isEmpty(paramString));
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.QZPhoneTagJSInterface.onReceive({code:0,data:" + paramString + "})");
      return;
    } while (!"cmd.setUserTail".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDeviceTagJsPlugin
 * JD-Core Version:    0.7.0.1
 */