package cooperation.qzone.webviewplugin;

import com.tencent.mobileqq.activity.QQSettingCleanActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

public class QzoneCommonJsPlugin
  extends QzoneInternalWebViewPlugin
{
  private static final String JUMP_QZONE_CLEAN = "jumpQQCleanPage";
  public static final String NAMESPACE = "Qzone";
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2.equals("Qzone")) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if ("jumpQQCleanPage".equalsIgnoreCase(paramString3))
      {
        if (this.parentPlugin.mRuntime.d() != null)
        {
          QQSettingCleanActivity.a(this.parentPlugin.mRuntime.d());
          return true;
        }
        QLog.e("jumpCleanPage", 2, "call activity with null runtime");
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneCommonJsPlugin
 * JD-Core Version:    0.7.0.1
 */