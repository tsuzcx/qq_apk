package com.tencent.mobileqq.location.net;

import aruq;
import com.tencent.commonsdk.util.notification.QQNotificationManager;

public class LocationHandler$9
  implements Runnable
{
  public LocationHandler$9(aruq paramaruq) {}
  
  public void run()
  {
    QQNotificationManager.getInstance().cancel("LocationHandler", 525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationHandler.9
 * JD-Core Version:    0.7.0.1
 */