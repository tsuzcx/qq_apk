package cooperation.qzone.webviewplugin;

import bifw;
import com.tencent.mobileqq.activity.QQSettingCleanActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;

public class QzoneCommonJsPlugin
  extends QzoneInternalWebViewPlugin
{
  private static final String JUMP_QZONE_CLEAN = "jumpQQCleanPage";
  public static final String NAMESPACE = "Qzone";
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {}
    while (!"jumpQQCleanPage".equalsIgnoreCase(paramString3)) {
      return false;
    }
    if (this.parentPlugin.mRuntime.a() != null)
    {
      QQSettingCleanActivity.a(this.parentPlugin.mRuntime.a());
      return true;
    }
    QLog.e("jumpCleanPage", 2, "call activity with null runtime");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneCommonJsPlugin
 * JD-Core Version:    0.7.0.1
 */