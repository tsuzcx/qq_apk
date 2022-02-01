package com.tencent.viola.module;

import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.utils.ViolaBrightnessController.OnBrightNessChangeListener;
import com.tencent.viola.utils.ViolaLogUtils;
import org.json.JSONObject;

class DeviceModule$2
  implements ViolaBrightnessController.OnBrightNessChangeListener
{
  DeviceModule$2(DeviceModule paramDeviceModule, String paramString) {}
  
  public void onChange(float paramFloat)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("value", paramFloat);
      ViolaBridgeManager.getInstance().callbackJavascript(this.this$0.getViolaInstance().getInstanceId(), "device", "callback", this.val$callback, localJSONObject, true);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ViolaLogUtils.e("brightnessChange", "getSystemBrightness error:" + localException.getMessage());
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.module.DeviceModule.2
 * JD-Core Version:    0.7.0.1
 */