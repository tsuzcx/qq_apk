package com.tencent.mobileqq.soso.location;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.mobileqq.soso.location.inject.LbsGdtUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

final class SosoInterface$8
  implements Runnable
{
  public void run()
  {
    SosoInterface.mOaid = LbsGdtUtils.getOaid();
    if (!TextUtils.isEmpty(SosoInterface.mOaid))
    {
      if (SosoInterface.access$2400() == null) {
        SosoInterface.access$2402(TencentLocationManager.getInstance(MobileQQ.sMobileQQ.getApplicationContext()));
      }
      try
      {
        SosoInterface.access$2400().setDeviceID(new Pair("oaId", SosoInterface.mOaid));
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 2, "mLocationManager.setDeviceId（） mOaid = " + SosoInterface.mOaid);
        }
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("SOSO.LBS", 1, "setDeviceId（） has exception = " + localException);
        }
      }
    }
    QLog.d("SOSO.LBS", 1, "getOaid（） mOaid is empty ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.SosoInterface.8
 * JD-Core Version:    0.7.0.1
 */