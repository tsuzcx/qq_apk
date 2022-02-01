package com.tencent.ttpic.baseutils.device;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.GsonUtils;

class DeviceAttrs$1
  implements Runnable
{
  DeviceAttrs$1(DeviceAttrs paramDeviceAttrs, String paramString1, String paramString2, String paramString3, DeviceAttrs.UpdateListener paramUpdateListener) {}
  
  public void run()
  {
    Object localObject1 = DeviceAttrs.access$000(this.this$0).getString("xml_version", "0");
    Object localObject2 = DeviceAttrs.access$100();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("[checkVersion] currentVer = ");
    ((StringBuilder)localObject3).append((String)localObject1);
    LogUtils.d((String)localObject2, ((StringBuilder)localObject3).toString());
    localObject1 = DeviceUpdate.checkConfigVersion(DeviceAttrs.access$200(this.this$0), this.val$packageName, (String)localObject1, this.val$appId, this.val$appVersion);
    localObject2 = DeviceAttrs.access$100();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("[checkVersion] jsonStr = ");
    ((StringBuilder)localObject3).append((String)localObject1);
    LogUtils.d((String)localObject2, ((StringBuilder)localObject3).toString());
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = GsonUtils.json2JsonObject((String)localObject1);
        if (localObject1 == null) {
          return;
        }
        localObject2 = GsonUtils.getStringUnsafe((JsonObject)localObject1, "ret");
        localObject3 = DeviceAttrs.access$100();
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("[checkVersion] retStr = ");
        ((StringBuilder)localObject4).append((String)localObject2);
        LogUtils.d((String)localObject3, ((StringBuilder)localObject4).toString());
        if (((String)localObject2).equals("1"))
        {
          localObject3 = GsonUtils.getStringUnsafe((JsonObject)localObject1, "camCoreConfUrl");
          localObject2 = DeviceAttrs.access$100();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("[checkVersion] urlStr = ");
          ((StringBuilder)localObject4).append((String)localObject3);
          LogUtils.d((String)localObject2, ((StringBuilder)localObject4).toString());
          localObject2 = GsonUtils.getStringUnsafe((JsonObject)localObject1, "curCamCoreVersion");
          localObject4 = DeviceAttrs.access$100();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[checkVersion] verStr = ");
          localStringBuilder.append((String)localObject2);
          LogUtils.d((String)localObject4, localStringBuilder.toString());
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(DeviceAttrs.access$300(this.this$0));
          ((StringBuilder)localObject4).append("phone_attrs_config.zip");
          localObject4 = ((StringBuilder)localObject4).toString();
          if (DeviceUpdate.httpDownloadFile((String)localObject3, (String)localObject4))
          {
            localObject3 = DeviceUpdate.unZip((String)localObject4, DeviceAttrs.access$300(this.this$0));
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              localObject4 = DeviceAttrs.access$100();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[checkVersion] unZipfilePath = ");
              localStringBuilder.append((String)localObject3);
              LogUtils.d((String)localObject4, localStringBuilder.toString());
              localObject4 = DeviceAttrs.access$000(this.this$0).edit();
              ((SharedPreferences.Editor)localObject4).putString("xml_version", (String)localObject2);
              ((SharedPreferences.Editor)localObject4).apply();
              localObject2 = DeviceParser.parseCameraAttrsFile(DeviceAttrs.access$400(this.this$0), (String)localObject3, DeviceInstance.getInstance().getDeviceName(), DeviceAttrs.access$500(this.this$0));
              if (localObject2 != null) {
                DeviceAttrs.access$600(this.this$0, (String)localObject2);
              }
              DeviceAttrs.access$700(this.this$0);
              DeviceAttrs.access$800(this.this$0);
              if (this.val$listener != null)
              {
                localObject2 = this.val$listener;
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append(DeviceAttrs.access$200(this.this$0));
                ((StringBuilder)localObject3).append(", download and parse success");
                ((DeviceAttrs.UpdateListener)localObject2).onSuccess(((StringBuilder)localObject3).toString());
              }
              localObject2 = new Intent();
              ((Intent)localObject2).setAction("action_check_online_update_finish");
              DeviceAttrs.access$400(this.this$0).sendBroadcast((Intent)localObject2);
            }
          }
        }
        localObject2 = this.this$0;
        bool = true;
        if (GsonUtils.optInt((JsonObject)localObject1, "nativeJpegEnable", 1) == 1)
        {
          ((DeviceAttrs)localObject2).serverJpegEnable = bool;
          return;
        }
      }
      catch (Exception localException)
      {
        localObject2 = DeviceAttrs.access$100();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("checkVersion JSONException e = ");
        ((StringBuilder)localObject3).append(localException);
        LogUtils.e((String)localObject2, ((StringBuilder)localObject3).toString());
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.device.DeviceAttrs.1
 * JD-Core Version:    0.7.0.1
 */