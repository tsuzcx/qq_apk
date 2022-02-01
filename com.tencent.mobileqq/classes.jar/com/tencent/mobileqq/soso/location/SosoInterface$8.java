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
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("setDeviceId（） has exception = ");
        localStringBuilder2.append(localException);
        QLog.d("SOSO.LBS", 1, localStringBuilder2.toString());
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("mLocationManager.setDeviceId（） mOaid = ");
        localStringBuilder1.append(SosoInterface.mOaid);
        QLog.d("SOSO.LBS", 2, localStringBuilder1.toString());
      }
    }
    else
    {
      QLog.d("SOSO.LBS", 1, "getOaid（） mOaid is empty ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.SosoInterface.8
 * JD-Core Version:    0.7.0.1
 */