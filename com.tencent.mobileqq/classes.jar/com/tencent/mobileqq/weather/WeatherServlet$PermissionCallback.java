package com.tencent.mobileqq.weather;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.NewIntent;
import mqq.app.QQPermissionCallback;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

final class WeatherServlet$PermissionCallback
  implements QQPermissionCallback
{
  private WeakReference<AppInterface> a;
  private WeakReference<NewIntent> b;
  private WeakReference<AppActivity> c;
  
  private WeatherServlet$PermissionCallback(AppInterface paramAppInterface, NewIntent paramNewIntent, AppActivity paramAppActivity)
  {
    this.a = new WeakReference(paramAppInterface);
    this.b = new WeakReference(paramNewIntent);
    this.c = new WeakReference(paramAppActivity);
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherServlet", 1, "User requestPermissions denied...");
    }
    AppInterface localAppInterface = (AppInterface)this.a.get();
    NewIntent localNewIntent = (NewIntent)this.b.get();
    AppActivity localAppActivity = (AppActivity)this.c.get();
    if ((localAppInterface != null) && (localNewIntent != null) && (localAppActivity != null))
    {
      ThreadManager.getSubThreadHandler().post(new WeatherServlet.PermissionCallback.1(this, localNewIntent, localAppInterface));
      DialogUtil.a(localAppActivity, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherServlet", 1, "User requestPermissions grant...");
    }
    paramArrayOfString = (AppInterface)this.a.get();
    paramArrayOfInt = (NewIntent)this.b.get();
    if ((paramArrayOfString != null) && (paramArrayOfInt != null)) {
      WeatherServlet.a(paramArrayOfString, paramArrayOfInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.WeatherServlet.PermissionCallback
 * JD-Core Version:    0.7.0.1
 */