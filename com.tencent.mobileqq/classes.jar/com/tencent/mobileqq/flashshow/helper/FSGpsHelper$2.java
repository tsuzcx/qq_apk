package com.tencent.mobileqq.flashshow.helper;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class FSGpsHelper$2
  extends LbsManagerServiceOnLocationChangeListener
{
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
      {
        FSGpsHelper.a(this.b, paramSosoLbsInfo);
        if (this.a.get() != null) {
          ((FSGpsHelper.IGetGpsInfoListener)this.a.get()).a(FSGpsHelper.a(this.b));
        }
      }
      else
      {
        if (this.a.get() != null) {
          ((FSGpsHelper.IGetGpsInfoListener)this.a.get()).a();
        }
        QLog.d("FSGpsHelper", 1, "getLocationNow get GpsInfo from request: location is null");
      }
    }
    else
    {
      QLog.d("FSGpsHelper", 1, "getLocationNow get GpsInfo from request: failed");
      if (this.a.get() != null) {
        ((FSGpsHelper.IGetGpsInfoListener)this.a.get()).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.helper.FSGpsHelper.2
 * JD-Core Version:    0.7.0.1
 */