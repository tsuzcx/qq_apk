package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import bgjm;
import bgkd;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.log.QMLog;
import eipc.EIPCClient;
import org.json.JSONException;
import org.json.JSONObject;

public class SetAvatarNativePlugin
  extends BaseJsPlugin
{
  public static final String PARAM_ACTION = "param_action";
  public static final String PARAM_AVATAR_PATH = "param_avatar_path";
  public static final String TAG = "SetAvatarNativePlugin";
  
  private JSONObject getParam(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("SetAvatarNativePlugin", "Failed to parse jsonParams=" + parambgkd.b);
    }
    return null;
  }
  
  public void uploadAvatar(bgkd parambgkd)
  {
    try
    {
      Object localObject = getParam(parambgkd);
      QLog.i("SetAvatarNativePlugin", 1, "onInvoke, param=" + localObject);
      localObject = ((JSONObject)localObject).optJSONObject("data");
      if (localObject == null)
      {
        parambgkd.a(new JSONObject("empty data"), "empty data");
        return;
      }
      localObject = ((JSONObject)localObject).optString("path", null);
      localObject = bgjm.a().a((String)localObject);
      QLog.d("SetAvatarNativePlugin", 1, (String)localObject);
      Bundle localBundle = new Bundle();
      localBundle.putString("param_avatar_path", (String)localObject);
      QIPCClientHelper.getInstance().getClient().callServer("CommonModule", "set_avatar", localBundle, new SetAvatarNativePlugin.AvatarResultCallback(this, parambgkd));
      return;
    }
    catch (Throwable parambgkd)
    {
      QLog.e("SetAvatarNativePlugin", 1, "setAvatar err", parambgkd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.SetAvatarNativePlugin
 * JD-Core Version:    0.7.0.1
 */