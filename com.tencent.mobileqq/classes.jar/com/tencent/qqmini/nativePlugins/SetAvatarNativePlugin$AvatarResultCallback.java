package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import bgkd;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

class SetAvatarNativePlugin$AvatarResultCallback
  implements EIPCResultCallback
{
  private bgkd req;
  
  SetAvatarNativePlugin$AvatarResultCallback(SetAvatarNativePlugin paramSetAvatarNativePlugin, bgkd parambgkd)
  {
    this.req = parambgkd;
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SetAvatarNativePlugin", 2, "onCallback, result=" + paramEIPCResult);
    }
    if (paramEIPCResult == null) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SetAvatarNativePlugin", 2, "onCallback, result.isSuccess=" + paramEIPCResult.isSuccess());
        }
        paramEIPCResult = paramEIPCResult.data;
        if (paramEIPCResult != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SetAvatarNativePlugin", 2, "onCallback, data is null");
      return;
      localObject = paramEIPCResult.getString("param_action");
      if (QLog.isColorLevel()) {
        QLog.d("SetAvatarNativePlugin", 2, "onCallback, action=" + (String)localObject);
      }
    } while (!"set_avatar".equals(localObject));
    int i = paramEIPCResult.getInt("param_result_code", -1);
    paramEIPCResult = paramEIPCResult.getString("param_result_desc", "null");
    if (QLog.isColorLevel()) {
      QLog.d("SetAvatarNativePlugin", 2, "onCallback, errCode=" + i + ", errDesc=" + paramEIPCResult);
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("param_result_code", i);
      ((JSONObject)localObject).put("param_result_desc", paramEIPCResult);
      label222:
      if (i == 0)
      {
        this.req.a((JSONObject)localObject);
        return;
      }
      this.req.a((JSONObject)localObject, paramEIPCResult);
      return;
    }
    catch (Exception localException)
    {
      break label222;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.SetAvatarNativePlugin.AvatarResultCallback
 * JD-Core Version:    0.7.0.1
 */