package com.tencent.mobileqq.location.net;

import com.tencent.commonsdk.util.notification.QQNotificationManager;

class LocationHandler$4
  implements Runnable
{
  LocationHandler$4(LocationHandler paramLocationHandler) {}
  
  public void run()
  {
    QQNotificationManager.getInstance().cancel("LocationHandler", 525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationHandler.4
 * JD-Core Version:    0.7.0.1
 */