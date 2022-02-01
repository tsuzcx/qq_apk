package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import eipc.EIPCClient;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class SetAvatarNativePlugin
  extends BaseJsPlugin
{
  private JSONObject a(RequestEvent paramRequestEvent)
  {
    try
    {
      localObject = new JSONObject(paramRequestEvent.jsonParams);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      label14:
      break label14;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Failed to parse jsonParams=");
    ((StringBuilder)localObject).append(paramRequestEvent.jsonParams);
    QLog.e("SetAvatarNativePlugin", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  @JsEvent({"uploadAvatar"})
  public void uploadAvatar(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject1 = a(paramRequestEvent);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onInvoke, param=");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.i("SetAvatarNativePlugin", 1, ((StringBuilder)localObject2).toString());
      localObject1 = ((JSONObject)localObject1).optJSONObject("data");
      if (localObject1 == null)
      {
        paramRequestEvent.fail(new JSONObject("empty data"), "empty data");
        return;
      }
      localObject1 = ((JSONObject)localObject1).optString("path", null);
      localObject1 = ((IMiniAppFileManager)this.mMiniAppContext.getManager(IMiniAppFileManager.class)).getAbsolutePath((String)localObject1);
      QLog.d("SetAvatarNativePlugin", 1, (String)localObject1);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("param_avatar_path", (String)localObject1);
      QIPCClientHelper.getInstance().getClient().callServer("CommonModule", "set_avatar", (Bundle)localObject2, new SetAvatarNativePlugin.AvatarResultCallback(this, paramRequestEvent));
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("SetAvatarNativePlugin", 1, "setAvatar err", paramRequestEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.SetAvatarNativePlugin
 * JD-Core Version:    0.7.0.1
 */