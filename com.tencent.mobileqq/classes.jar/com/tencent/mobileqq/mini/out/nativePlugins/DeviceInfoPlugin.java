package com.tencent.mobileqq.mini.out.nativePlugins;

import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class DeviceInfoPlugin
  implements NativePlugin
{
  public static final String API_GET_GUID = "getGUID";
  private static final String TAG = "DeviceInfoPlugin";
  
  public void onDestroy() {}
  
  public void onInvoke(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    QLog.d("DeviceInfoPlugin", 1, "onInvoke getGUID");
    QIPCClientHelper.getInstance().callServer("DeviceProtectQIPCModule", "ACTION_GET_GUID_INFO", null, new DeviceInfoPlugin.1(this, paramJSContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.DeviceInfoPlugin
 * JD-Core Version:    0.7.0.1
 */