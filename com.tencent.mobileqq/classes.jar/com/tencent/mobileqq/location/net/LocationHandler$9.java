package com.tencent.mobileqq.location.net;

import atpw;
import com.tencent.commonsdk.util.notification.QQNotificationManager;

public class LocationHandler$9
  implements Runnable
{
  public LocationHandler$9(atpw paramatpw) {}
  
  public void run()
  {
    QQNotificationManager.getInstance().cancel("LocationHandler", 525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationHandler.9
 * JD-Core Version:    0.7.0.1
 */