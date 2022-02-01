package com.tencent.mobileqq.pushnotice;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

final class PushNoticeUtil$1
  implements Runnable
{
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
          PushNoticeUtil.a(HmsInstanceId.getInstance((Context)localObject1).getToken((String)localObject2, "HCM"));
          PushNoticeUtil.b();
          boolean bool = NotificationManagerCompat.from((Context)localObject1).areNotificationsEnabled();
          if (!bool) {
            break label195;
          }
          i = 1;
          ReportController.b(BaseApplicationImpl.getApplication().getRuntime(), "CliStatus", "", "", "0X800BAC8", "0X800BAC8", 0, 1, i, String.valueOf(i), "", "", "");
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("HPush_Huawei Push Token is not null: ");
            ((StringBuilder)localObject1).append(TextUtils.isEmpty(PushNoticeUtil.a));
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
      label195:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.PushNoticeUtil.1
 * JD-Core Version:    0.7.0.1
 */