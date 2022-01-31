package cooperation.qzone.webviewplugin.personalize;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class QZonePersonalizeJsHandleLogic
{
  public static void a(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return;
    }
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      int i = paramVarArgs.optInt("facade", -1);
      int j = paramVarArgs.optInt("feedskin", -1);
      int k = paramVarArgs.optInt("avatar", -1);
      int m = paramVarArgs.optInt("float", -1);
      int n = paramVarArgs.optInt("customvip", -1);
      int i1 = paramVarArgs.optInt("praise", -1);
      int i2 = paramVarArgs.optInt("player", -1);
      paramVarArgs = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "SetPersonalizeFinished");
      localBundle.putInt("facade", i);
      localBundle.putInt("feedskin", j);
      localBundle.putInt("avatar", k);
      localBundle.putInt("floatObject", m);
      localBundle.putInt("customvip", n);
      localBundle.putInt("praise", i1);
      localBundle.putInt("player", i2);
      paramVarArgs.putExtras(localBundle);
      QZoneHelper.a(paramPluginRuntime.a(), QZoneHelper.UserInfo.a(), paramVarArgs);
      return;
    }
    catch (JSONException paramPluginRuntime) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZonePersonalizeJsHandleLogic
 * JD-Core Version:    0.7.0.1
 */