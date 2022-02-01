package com.tencent.viola.module;

import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.utils.ViolaLogUtils;
import org.json.JSONObject;

class DeviceModule$3
  extends ContentObserver
{
  DeviceModule$3(DeviceModule paramDeviceModule, Handler paramHandler, String paramString)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    super.onChange(paramBoolean, paramUri);
    paramUri = new JSONObject();
    try
    {
      paramUri.put("volume", DeviceModule.access$300(this.this$0).getStreamVolume(3) / DeviceModule.access$400(this.this$0));
      if (this.this$0.getViolaInstance() != null) {
        ViolaBridgeManager.getInstance().callbackJavascript(this.this$0.getViolaInstance().getInstanceId(), "device", "callback", this.val$callback, paramUri, true);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ViolaLogUtils.e("brightnessChange", "volumeChange error:" + localException.getMessage());
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.module.DeviceModule.3
 * JD-Core Version:    0.7.0.1
 */