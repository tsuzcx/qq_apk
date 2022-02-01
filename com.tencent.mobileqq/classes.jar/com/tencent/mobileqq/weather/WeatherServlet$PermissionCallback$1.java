package com.tencent.mobileqq.weather;

import com.tencent.common.app.AppInterface;
import mqq.app.NewIntent;

class WeatherServlet$PermissionCallback$1
  implements Runnable
{
  WeatherServlet$PermissionCallback$1(WeatherServlet.PermissionCallback paramPermissionCallback, NewIntent paramNewIntent, AppInterface paramAppInterface) {}
  
  public void run()
  {
    this.a.putExtra("adcode", 0);
    this.b.startServlet(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.WeatherServlet.PermissionCallback.1
 * JD-Core Version:    0.7.0.1
 */