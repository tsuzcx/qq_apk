package com.tencent.mobileqq.weather;

import com.tencent.common.app.AppInterface;
import mqq.app.NewIntent;

class WeatherServlet$PermissionCallback$1
  implements Runnable
{
  WeatherServlet$PermissionCallback$1(WeatherServlet.PermissionCallback paramPermissionCallback, NewIntent paramNewIntent, AppInterface paramAppInterface) {}
  
  public void run()
  {
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("adcode", 0);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.WeatherServlet.PermissionCallback.1
 * JD-Core Version:    0.7.0.1
 */