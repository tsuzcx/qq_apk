package com.tencent.mobileqq.servlet;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.qphone.base.util.QLog;

final class QZoneNotifyServlet$3
  implements Runnable
{
  public void run()
  {
    try
    {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(QZoneNotifyServlet.a());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "locate exception " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneNotifyServlet.3
 * JD-Core Version:    0.7.0.1
 */