package com.tencent.util.notification;

import bkyy;
import com.tencent.commonsdk.util.notification.QQNotificationManager;

public class NotifyIdManager$2
  implements Runnable
{
  public NotifyIdManager$2(bkyy parambkyy, QQNotificationManager paramQQNotificationManager) {}
  
  public void run()
  {
    int i = 512;
    while (i < 522)
    {
      this.a.cancel("NotifyIdManager", i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.util.notification.NotifyIdManager.2
 * JD-Core Version:    0.7.0.1
 */