package com.tencent.viola.module;

import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.utils.OrientationDetector.OnOrientationChangedListener;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import org.json.JSONObject;

class DeviceModule$1
  implements OrientationDetector.OnOrientationChangedListener
{
  DeviceModule$1(DeviceModule paramDeviceModule, String paramString) {}
  
  public void onOrientationChanged(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("value", ViolaUtils.getScreenOrientation(paramInt));
      ViolaBridgeManager.getInstance().callbackJavascript(this.this$0.getViolaInstance().getInstanceId(), "device", "callback", this.val$callback, localJSONObject, true);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ViolaLogUtils.e("DeviceModule", "getOrientationChanged error:" + localException.getMessage());
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.module.DeviceModule.1
 * JD-Core Version:    0.7.0.1
 */