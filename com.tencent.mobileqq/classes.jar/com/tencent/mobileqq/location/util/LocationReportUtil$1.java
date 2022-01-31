package com.tencent.mobileqq.location.util;

import android.os.Handler;
import atpw;
import bdiv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public final class LocationReportUtil$1
  implements Runnable
{
  public LocationReportUtil$1(boolean paramBoolean) {}
  
  public void run()
  {
    if (atpw.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationReportUtil", 2, new Object[] { "run: invoked. need stop report. ", " reporting: ", Boolean.valueOf(this.a) });
      }
      return;
    }
    long l = System.currentTimeMillis() / 1000L - atpw.a();
    bdiv.a(BaseApplicationImpl.getApplication(), this.a, (int)l);
    if (QLog.isColorLevel()) {
      QLog.d("LocationReportUtil", 2, new Object[] { "updateLocationBgReport.run: invoked. ", " sProcBgAliveTimeSecond: ", Long.valueOf(l), " reporting: ", Boolean.valueOf(this.a) });
    }
    atpw.a().postDelayed(this, 30000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.location.util.LocationReportUtil.1
 * JD-Core Version:    0.7.0.1
 */