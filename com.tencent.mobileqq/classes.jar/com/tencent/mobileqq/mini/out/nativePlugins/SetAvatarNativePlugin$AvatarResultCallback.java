package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

class SetAvatarNativePlugin$AvatarResultCallback
  implements EIPCResultCallback
{
  NativePlugin.JSContext mJsContext;
  
  SetAvatarNativePlugin$AvatarResultCallback(SetAvatarNativePlugin paramSetAvatarNativePlugin, NativePlugin.JSContext paramJSContext)
  {
    this.mJsContext = paramJSContext;
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SetAvatarNativePlugin", 2, "onCallback, result=" + paramEIPCResult);
    }
    if (paramEIPCResult == null) {}
    int i;
    do
    {
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
      i = paramEIPCResult.getInt("param_result_code", -1);
      paramEIPCResult = paramEIPCResult.getString("param_result_desc", "null");
      if (QLog.isColorLevel()) {
        QLog.d("SetAvatarNativePlugin", 2, "onCallback, errCode=" + i + ", errDesc=" + paramEIPCResult);
      }
    } while (this.mJsContext == null);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("param_result_code", i);
      ((JSONObject)localObject).put("param_result_desc", paramEIPCResult);
      label235:
      NativePlugin.JSContext localJSContext = this.mJsContext;
      if (i == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localJSContext.evaluateCallback(bool, (JSONObject)localObject, paramEIPCResult);
        return;
      }
    }
    catch (Exception localException)
    {
      break label235;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.SetAvatarNativePlugin.AvatarResultCallback
 * JD-Core Version:    0.7.0.1
 */