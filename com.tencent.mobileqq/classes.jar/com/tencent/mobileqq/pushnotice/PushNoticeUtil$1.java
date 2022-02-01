package com.tencent.mobileqq.pushnotice;

import android.text.TextUtils;
import baiw;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public final class PushNoticeUtil$1
  implements Runnable
{
  public void run()
  {
    try
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      if (BaseApplicationImpl.sProcessId == 1)
      {
        String str = AGConnectServicesConfig.fromContext(localBaseApplication).getString("client/app_id");
        baiw.a = HmsInstanceId.getInstance(localBaseApplication).getToken(str, "HCM");
        baiw.b();
        if (QLog.isColorLevel()) {
          QLog.d("HPush", 2, "HPush_Huawei Push Token : " + TextUtils.isEmpty(baiw.a));
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("HPush", 2, "HPush_Huawei getPush Token : " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.PushNoticeUtil.1
 * JD-Core Version:    0.7.0.1
 */