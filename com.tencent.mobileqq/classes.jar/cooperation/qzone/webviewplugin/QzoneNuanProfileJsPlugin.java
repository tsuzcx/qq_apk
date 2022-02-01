package cooperation.qzone.webviewplugin;

import bifw;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import org.json.JSONObject;

public class QzoneNuanProfileJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ("jumpNuanProfile".equals(paramString3))
    {
      bool1 = bool2;
      if (!"Qzone".equals(paramString2)) {}
    }
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("uin", "");
      paramString1 = QZoneHelper.UserInfo.getInstance();
      paramString1.qzone_uin = this.parentPlugin.mRuntime.a().getAccount();
      QZoneHelper.forwardToNuanProfile(this.parentPlugin.mRuntime.a(), paramString1, paramJsBridgeListener, -1);
      bool1 = true;
      return bool1;
    }
    catch (Throwable paramJsBridgeListener) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneNuanProfileJsPlugin
 * JD-Core Version:    0.7.0.1
 */