package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import org.json.JSONObject;

public class SetAvatarNativePlugin
  implements NativePlugin
{
  public static final String PARAM_ACTION = "param_action";
  public static final String PARAM_AVATAR_PATH = "param_avatar_path";
  public static final String TAG = "SetAvatarNativePlugin";
  
  public void onDestroy() {}
  
  public void onInvoke(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onInvoke, param=");
    ((StringBuilder)localObject).append(paramJSONObject);
    QLog.i("SetAvatarNativePlugin", 1, ((StringBuilder)localObject).toString());
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("data");
      if (paramJSONObject == null)
      {
        paramJSContext.evaluateCallback(false, new JSONObject("empty data"), "empty data");
        return;
      }
      paramJSONObject = paramJSONObject.optString("path", null);
      paramJSONObject = MiniAppFileManager.getInstance().getAbsolutePath(paramJSONObject);
      QLog.d("SetAvatarNativePlugin", 1, paramJSONObject);
      localObject = new Bundle();
      ((Bundle)localObject).putString("param_avatar_path", paramJSONObject);
      QIPCClientHelper.getInstance().getClient().callServer("CommonModule", "set_avatar", (Bundle)localObject, new SetAvatarNativePlugin.AvatarResultCallback(this, paramJSContext));
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("SetAvatarNativePlugin", 1, "setAvatar err", paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.SetAvatarNativePlugin
 * JD-Core Version:    0.7.0.1
 */