package com.tencent.mobileqq.pushnotice;

import android.text.TextUtils;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import com.tencent.qphone.base.util.QLog;

public class QQHuaweiPushService
  extends HmsMessageService
{
  public void onMessageReceived(RemoteMessage paramRemoteMessage)
  {
    super.onMessageReceived(paramRemoteMessage);
    if (QLog.isColorLevel()) {
      QLog.d("HPush", 2, "HPush_Huawei Push Token-QQHuaweiPushSddervice.onMessageReceived : ");
    }
  }
  
  public void onNewToken(String paramString)
  {
    super.onNewToken(paramString);
    PushNoticeUtil.a = paramString;
    if (!TextUtils.isEmpty(PushNoticeUtil.a)) {
      PushNoticeUtil.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("HPush", 2, "HPush_Huawei Push Token-QQHuaweiPushService.onNewToken : " + TextUtils.isEmpty(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.QQHuaweiPushService
 * JD-Core Version:    0.7.0.1
 */