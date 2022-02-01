package com.tencent.mobileqq.pushnotice.proxy;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class HuaWeiPushProcessor$2
  implements Runnable
{
  HuaWeiPushProcessor$2(HuaWeiPushProcessor paramHuaWeiPushProcessor) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        QLog.d("HPush", 1, "HPush_Huawei getPush Token run : ");
        Object localObject1 = BaseApplicationImpl.getContext();
        if (BaseApplicationImpl.sProcessId == 1)
        {
          localObject2 = AGConnectServicesConfig.fromContext((Context)localObject1).getString("client/app_id");
          localObject2 = HmsInstanceId.getInstance((Context)localObject1).getToken((String)localObject2, "HCM");
          this.this$0.a((String)localObject2);
          this.this$0.f();
          boolean bool = NotificationManagerCompat.from((Context)localObject1).areNotificationsEnabled();
          if (!bool) {
            break label211;
          }
          i = 1;
          ReportController.b(BaseApplicationImpl.getApplication().getRuntime(), "CliStatus", "", "", "0X800BAC8", "0X800BAC8", 0, 1, i, String.valueOf(i), "", "", "");
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("HPush_Huawei Push Token is not null: ");
            ((StringBuilder)localObject1).append(TextUtils.isEmpty(this.this$0.e()));
            QLog.d("HPush", 2, new Object[] { ((StringBuilder)localObject1).toString(), ",msgNotifyEnable = ", Boolean.valueOf(bool) });
            return;
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("HPush_Huawei getPush Token : ");
        ((StringBuilder)localObject2).append(localException);
        QLog.d("HPush", 1, ((StringBuilder)localObject2).toString());
      }
      return;
      label211:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.proxy.HuaWeiPushProcessor.2
 * JD-Core Version:    0.7.0.1
 */