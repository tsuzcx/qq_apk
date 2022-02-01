package com.tencent.viola.module;

import android.os.Handler;
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
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("getOrientationChanged error:");
      localStringBuilder2.append(localException.getMessage());
      ViolaLogUtils.e("DeviceModule", localStringBuilder2.toString());
      localException.printStackTrace();
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("onOrientationChanged orientation:");
    localStringBuilder1.append(paramInt);
    localStringBuilder1.append(",mLastOrientation:");
    localStringBuilder1.append(DeviceModule.access$000(this.this$0));
    ViolaLogUtils.d("DeviceModule", localStringBuilder1.toString());
    if ((paramInt == DeviceModule.access$000(this.this$0)) && (System.currentTimeMillis() - DeviceModule.access$100(this.this$0) <= 900L))
    {
      DeviceModule.access$200(this.this$0).postDelayed(new DeviceModule.1.1(this, localJSONObject), 500L);
      return;
    }
    DeviceModule.access$102(this.this$0, System.currentTimeMillis());
    if (this.this$0.getViolaInstance() != null) {
      ViolaBridgeManager.getInstance().callbackJavascript(this.this$0.getViolaInstance().getInstanceId(), "device", "callback", this.val$callback, localJSONObject, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.module.DeviceModule.1
 * JD-Core Version:    0.7.0.1
 */