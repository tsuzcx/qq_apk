package com.tencent.mobileqq.onlinestatus.location;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class LocationHandler$1
  implements Runnable
{
  LocationHandler$1(LocationHandler paramLocationHandler, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] startLocationUpdate: invoked. call over time runnable");
    }
    if (this.a) {
      QQToast.a(MobileQQ.sMobileQQ, "位置获取失败，请稍后再试", 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.location.LocationHandler.1
 * JD-Core Version:    0.7.0.1
 */