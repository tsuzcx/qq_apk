package com.tencent.mobileqq.kandian.biz.push;

import com.tencent.commonsdk.util.notification.QQNotificationManager;

final class RIJPushNotification$1
  implements Runnable
{
  public void run()
  {
    QQNotificationManager.getInstance().cancel("RIJPushNotification", 526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.RIJPushNotification.1
 * JD-Core Version:    0.7.0.1
 */