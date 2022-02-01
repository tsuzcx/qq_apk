package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

class DeviceInfoPlugin$1
  implements EIPCResultCallback
{
  DeviceInfoPlugin$1(DeviceInfoPlugin paramDeviceInfoPlugin, JSContext paramJSContext) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.d("DeviceInfoPlugin", 1, "ACTION_GET_GUID_INFO onCallback");
    if (paramEIPCResult == null)
    {
      QLog.e("DeviceInfoPlugin", 1, "ACTION_GET_GUID_INFO error, result is null");
      return;
    }
    if (paramEIPCResult.code == 0)
    {
      paramEIPCResult = paramEIPCResult.data.getString("guid", "");
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("guid", paramEIPCResult);
        this.val$jsContext.evaluateCallback(true, localJSONObject, "");
        return;
      }
      catch (JSONException paramEIPCResult)
      {
        this.val$jsContext.evaluateCallback(false, null, paramEIPCResult.getMessage());
        QLog.e("DeviceInfoPlugin", 1, new Object[] { "evaluateCallback error : ", paramEIPCResult.getMessage() });
        return;
      }
    }
    this.val$jsContext.evaluateCallback(false, null, String.valueOf(-102));
    QLog.e("DeviceInfoPlugin", 1, "ACTION_GET_GUID_INFO failed, code return error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.DeviceInfoPlugin.1
 * JD-Core Version:    0.7.0.1
 */