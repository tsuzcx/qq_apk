package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

class SetAvatarNativePlugin$AvatarResultCallback
  implements EIPCResultCallback
{
  JSContext mJsContext;
  
  SetAvatarNativePlugin$AvatarResultCallback(SetAvatarNativePlugin paramSetAvatarNativePlugin, JSContext paramJSContext)
  {
    this.mJsContext = paramJSContext;
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onCallback, result=");
      ((StringBuilder)localObject1).append(paramEIPCResult);
      QLog.d("SetAvatarNativePlugin", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramEIPCResult == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onCallback, result.isSuccess=");
      ((StringBuilder)localObject1).append(paramEIPCResult.isSuccess());
      QLog.d("SetAvatarNativePlugin", 2, ((StringBuilder)localObject1).toString());
    }
    paramEIPCResult = paramEIPCResult.data;
    if (paramEIPCResult == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SetAvatarNativePlugin", 2, "onCallback, data is null");
      }
      return;
    }
    Object localObject1 = paramEIPCResult.getString("param_action");
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onCallback, action=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("SetAvatarNativePlugin", 2, ((StringBuilder)localObject2).toString());
    }
    int i;
    if ("set_avatar".equals(localObject1))
    {
      i = paramEIPCResult.getInt("param_result_code", -1);
      paramEIPCResult = paramEIPCResult.getString("param_result_desc", "null");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onCallback, errCode=");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(", errDesc=");
        ((StringBuilder)localObject1).append(paramEIPCResult);
        QLog.d("SetAvatarNativePlugin", 2, ((StringBuilder)localObject1).toString());
      }
      if (this.mJsContext != null) {
        localObject1 = new JSONObject();
      }
    }
    try
    {
      ((JSONObject)localObject1).put("param_result_code", i);
      ((JSONObject)localObject1).put("param_result_desc", paramEIPCResult);
      label281:
      localObject2 = this.mJsContext;
      boolean bool;
      if (i == 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((JSContext)localObject2).evaluateCallback(bool, (JSONObject)localObject1, paramEIPCResult);
      return;
    }
    catch (Exception localException)
    {
      break label281;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.SetAvatarNativePlugin.AvatarResultCallback
 * JD-Core Version:    0.7.0.1
 */