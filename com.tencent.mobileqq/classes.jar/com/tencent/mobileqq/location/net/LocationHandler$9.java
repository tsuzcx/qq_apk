package com.tencent.mobileqq.location.net;

import com.tencent.commonsdk.util.notification.QQNotificationManager;

class LocationHandler$9
  implements Runnable
{
  LocationHandler$9(LocationHandler paramLocationHandler) {}
  
  public void run()
  {
    QQNotificationManager.getInstance().cancel("LocationHandler", 525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationHandler.9
 * JD-Core Version:    0.7.0.1
 */