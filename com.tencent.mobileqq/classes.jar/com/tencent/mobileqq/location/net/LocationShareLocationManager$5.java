package com.tencent.mobileqq.location.net;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class LocationShareLocationManager$5
  implements ReportLocationHandler.OnGetLocationCallback
{
  LocationShareLocationManager$5(LocationShareLocationManager paramLocationShareLocationManager) {}
  
  public LocationItem a()
  {
    if (LocationShareLocationManager.b(this.a) == null) {
      QLog.d("Q.LocationShare", 1, "[LocationManager] getLocation: invoked. location null detected");
    }
    return new LocationItem(((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getAccount(), LocationShareLocationManager.b(this.a), LocationShareLocationManager.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationShareLocationManager.5
 * JD-Core Version:    0.7.0.1
 */