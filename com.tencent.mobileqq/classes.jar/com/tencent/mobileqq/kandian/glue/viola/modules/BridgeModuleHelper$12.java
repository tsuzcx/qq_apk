package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJLogUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil.NetInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class BridgeModuleHelper$12
  implements Runnable
{
  BridgeModuleHelper$12(JSONObject paramJSONObject, BridgeModule paramBridgeModule, String paramString) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.b();
    Activity localActivity = BridgeModuleHelper.e();
    if (localObject != null)
    {
      if (localActivity == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.optString("id"));
      localStringBuilder.append("|");
      localStringBuilder.append(this.a.optString("subid"));
      localStringBuilder.append("|");
      localStringBuilder.append(this.a.optString("content"));
      localStringBuilder.append("|");
      localStringBuilder.append("ANDROID");
      localStringBuilder.append("|");
      localStringBuilder.append("8.8.17.5770");
      localStringBuilder.append("|");
      localStringBuilder.append(DeviceInfoUtil.g());
      localStringBuilder.append("|");
      localStringBuilder.append(RIJLogUtil.a.a(((QQAppInterface)localObject).getCurrentAccountUin()));
      localStringBuilder.append("|");
      localStringBuilder.append(Build.MODEL);
      localStringBuilder.append("|");
      boolean bool = TextUtils.isEmpty(DeviceInfoUtil.f(localActivity).c);
      String str = "未知";
      if (bool) {
        localObject = "未知";
      } else {
        localObject = DeviceInfoUtil.f(localActivity).c;
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("|");
      if (TextUtils.isEmpty(DeviceInfoUtil.f(localActivity).a)) {
        localObject = str;
      } else {
        localObject = DeviceInfoUtil.f(localActivity).a;
      }
      localStringBuilder.append((String)localObject);
      if (this.a.optBoolean("isall", false))
      {
        QLog.w("ViolaLog", 1, localStringBuilder.toString());
        this.b.invokeCallJS(this.c, null);
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.w("ViolaLog", 2, localStringBuilder.toString());
        this.b.invokeCallJS(this.c, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.12
 * JD-Core Version:    0.7.0.1
 */