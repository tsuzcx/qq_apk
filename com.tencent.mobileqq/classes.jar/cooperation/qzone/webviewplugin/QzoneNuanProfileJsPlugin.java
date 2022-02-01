package cooperation.qzone.webviewplugin;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import org.json.JSONObject;

public class QzoneNuanProfileJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("jumpNuanProfile".equals(paramString3)) && ("Qzone".equals(paramString2))) {}
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("uin", "");
      paramString1 = QZoneHelper.UserInfo.getInstance();
      paramString1.qzone_uin = this.parentPlugin.mRuntime.a().getAccount();
      QZoneHelper.forwardToNuanProfile(this.parentPlugin.mRuntime.a(), paramString1, paramJsBridgeListener, -1);
      return true;
    }
    catch (Throwable paramJsBridgeListener) {}
    return false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneNuanProfileJsPlugin
 * JD-Core Version:    0.7.0.1
 */