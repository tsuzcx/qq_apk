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
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("cmd", "CleanZebraNum");
    paramVarArgs.putExtras((Bundle)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("actionString: ");
      ((StringBuilder)localObject).append(paramVarArgs.getAction());
      QLog.d("QZoneZebraAlbumJsHandleLogicQZonePersonalizePlugin", 2, ((StringBuilder)localObject).toString());
    }
    QZoneHelper.forwardToQzoneTransluentActivity(paramPluginRuntime.a(), QZoneHelper.UserInfo.getInstance(), paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZoneZebraAlbumJsHandleLogic
 * JD-Core Version:    0.7.0.1
 */