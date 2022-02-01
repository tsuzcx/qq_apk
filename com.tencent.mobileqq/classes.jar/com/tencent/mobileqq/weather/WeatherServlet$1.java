package com.tencent.mobileqq.weather;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.NewIntent;

final class WeatherServlet$1
  implements DialogInterface.OnClickListener
{
  WeatherServlet$1(AppActivity paramAppActivity, AppInterface paramAppInterface, NewIntent paramNewIntent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = this.a;
      paramDialogInterface.requestPermissions(new WeatherServlet.PermissionCallback(this.b, this.c, paramDialogInterface, null), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    if (QLog.isColorLevel())
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("dialog button non positive clicked: ");
      paramDialogInterface.append(paramInt);
      QLog.d("WeatherServlet", 2, paramDialogInterface.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.WeatherServlet.1
 * JD-Core Version:    0.7.0.1
 */