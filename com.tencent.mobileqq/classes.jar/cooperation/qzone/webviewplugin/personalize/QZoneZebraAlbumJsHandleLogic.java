package cooperation.qzone.webviewplugin.personalize;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

public class QZoneZebraAlbumJsHandleLogic
{
  public static final String TAG = "QZoneZebraAlbumJsHandleLogicQZonePersonalizePlugin";
  
  public static void handleCleanZebraNum(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    paramVarArgs = new Intent("action_js2qzone");
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", "CleanZebraNum");
    paramVarArgs.putExtras(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneZebraAlbumJsHandleLogicQZonePersonalizePlugin", 2, "actionString: " + paramVarArgs.getAction());
    }
    QZoneHelper.forwardToQzoneTransluentActivity(paramPluginRuntime.a(), QZoneHelper.UserInfo.getInstance(), paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZoneZebraAlbumJsHandleLogic
 * JD-Core Version:    0.7.0.1
 */