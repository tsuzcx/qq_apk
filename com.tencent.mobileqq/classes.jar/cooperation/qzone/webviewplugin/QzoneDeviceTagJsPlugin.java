package cooperation.qzone.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
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
  public static final String NAMESPACE = "Qzone";
  private static final String TAG = QzoneBlogJsPlugin.class.getSimpleName();
  
  private static void handleDeviceTag(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    paramPluginRuntime.a().getHandler(QzoneDeviceTagJsPlugin.class).post(new QzoneDeviceTagJsPlugin.2());
  }
  
  private static void handleUserTail(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    paramPluginRuntime.a().getHandler(QzoneDeviceTagJsPlugin.class).post(new QzoneDeviceTagJsPlugin.1(paramArrayOfString));
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("Qzone".equals(paramString2)) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if ("GetDeviceInfo".equalsIgnoreCase(paramString3))
      {
        RemoteHandleManager.getInstance().addWebEventListener(this);
        handleDeviceTag(this.parentPlugin, this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
      if ("SetUserTail".equalsIgnoreCase(paramString3))
      {
        RemoteHandleManager.getInstance().addWebEventListener(this);
        handleUserTail(this.parentPlugin, this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
    }
    return false;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    RemoteHandleManager.getInstance().removeWebEventListener(this);
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (!paramBundle.containsKey("data")) {
        return;
      }
      paramBundle = paramBundle.getBundle("data");
      if (paramBundle == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "call js function,bundle is empty");
        }
        return;
      }
      if ("cmd.getDeviceInfos".equals(paramString))
      {
        paramString = paramBundle.getString("param.DeviceInfos");
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
        paramBundle = this.parentPlugin;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("window.QZPhoneTagJSInterface.onReceive({code:0,data:");
        localStringBuilder.append(paramString);
        localStringBuilder.append("})");
        paramBundle.callJs(localStringBuilder.toString());
        return;
      }
      if (!"cmd.setUserTail".equals(paramString)) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDeviceTagJsPlugin
 * JD-Core Version:    0.7.0.1
 */