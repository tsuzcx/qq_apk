package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

class SetAvatarNativePlugin$AvatarResultCallback
  implements EIPCResultCallback
{
  private RequestEvent b;
  
  SetAvatarNativePlugin$AvatarResultCallback(SetAvatarNativePlugin paramSetAvatarNativePlugin, RequestEvent paramRequestEvent)
  {
    this.b = paramRequestEvent;
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCallback, result=");
      ((StringBuilder)localObject).append(paramEIPCResult);
      QLog.d("SetAvatarNativePlugin", 2, ((StringBuilder)localObject).toString());
    }
    if (paramEIPCResult == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCallback, result.isSuccess=");
      ((StringBuilder)localObject).append(paramEIPCResult.isSuccess());
      QLog.d("SetAvatarNativePlugin", 2, ((StringBuilder)localObject).toString());
    }
    paramEIPCResult = paramEIPCResult.data;
    if (paramEIPCResult == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SetAvatarNativePlugin", 2, "onCallback, data is null");
      }
      return;
    }
    Object localObject = paramEIPCResult.getString("param_action");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCallback, action=");
      localStringBuilder.append((String)localObject);
      QLog.d("SetAvatarNativePlugin", 2, localStringBuilder.toString());
    }
    int i;
    if ("set_avatar".equals(localObject))
    {
      i = paramEIPCResult.getInt("param_result_code", -1);
      paramEIPCResult = paramEIPCResult.getString("param_result_desc", "null");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onCallback, errCode=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", errDesc=");
        ((StringBuilder)localObject).append(paramEIPCResult);
        QLog.d("SetAvatarNativePlugin", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("param_result_code", i);
      ((JSONObject)localObject).put("param_result_desc", paramEIPCResult);
      label254:
      if (i == 0)
      {
        this.b.ok((JSONObject)localObject);
        return;
      }
      this.b.fail((JSONObject)localObject, paramEIPCResult);
      return;
    }
    catch (Exception localException)
    {
      break label254;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.SetAvatarNativePlugin.AvatarResultCallback
 * JD-Core Version:    0.7.0.1
 */