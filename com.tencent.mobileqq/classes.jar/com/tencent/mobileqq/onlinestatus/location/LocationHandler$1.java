package com.tencent.mobileqq.onlinestatus.location;

import azle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class LocationHandler$1
  implements Runnable
{
  public LocationHandler$1(azle paramazle, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] startLocationUpdate: invoked. call over time runnable");
    }
    if (this.a) {
      QQToast.a(BaseApplicationImpl.context, "位置获取失败，请稍后再试", 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.location.LocationHandler.1
 * JD-Core Version:    0.7.0.1
 */