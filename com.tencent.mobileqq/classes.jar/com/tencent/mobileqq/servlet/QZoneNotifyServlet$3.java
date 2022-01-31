package com.tencent.mobileqq.servlet;

import ayxp;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qphone.base.util.QLog;

public final class QZoneNotifyServlet$3
  implements Runnable
{
  public void run()
  {
    try
    {
      SosoInterface.a(ayxp.a());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "locate exception " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneNotifyServlet.3
 * JD-Core Version:    0.7.0.1
 */