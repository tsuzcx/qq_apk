package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class GameBuddyPlugin
  implements NativePlugin
{
  public static final String API_NAME_CHECK_AIO_TYPE = "checkGameBuddyType";
  public static final String API_NAME_OPEN_AIO = "invokeGameBuddyAio";
  public static final String TAG = "GameBuddyPlugin";
  
  public void onDestroy()
  {
    QLog.i("GameBuddyPlugin", 1, "[onDestroy]");
  }
  
  public void onInvoke(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    if (paramJSContext == null) {}
    try
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.i("GameBuddyPlugin", 2, "onInvoke jsContext is null return");
      return;
    }
    catch (Throwable paramJSONObject)
    {
      String str;
      Bundle localBundle;
      QLog.e("GameBuddyPlugin", 1, paramJSONObject, new Object[0]);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameBuddyPlugin", 2, paramJSONObject.toString());
    }
    str = paramJSONObject.optString("api_name");
    if (("invokeGameBuddyAio".equals(str)) || ("checkGameBuddyType".equals(str)))
    {
      paramJSONObject = paramJSONObject.optJSONObject("data").optString("uid");
      localBundle = new Bundle();
      localBundle.putString("uin_value", paramJSONObject);
      QIPCClientHelper.getInstance().callServer("module_game_buddy", "action_check_aio_type", localBundle, new GameBuddyPlugin.1(this, paramJSContext, str, paramJSONObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.GameBuddyPlugin
 * JD-Core Version:    0.7.0.1
 */