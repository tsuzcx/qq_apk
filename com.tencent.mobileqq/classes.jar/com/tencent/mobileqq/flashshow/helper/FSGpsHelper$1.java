package com.tencent.mobileqq.flashshow.helper;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class FSGpsHelper$1
  extends LbsManagerServiceOnLocationChangeListener
{
  FSGpsHelper$1(FSGpsHelper paramFSGpsHelper, String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
      {
        FSGpsHelper.a(this.a, paramSosoLbsInfo);
        return;
      }
      QLog.d("FSGpsHelper", 1, "preGetLocation get GpsInfo from request: location is null");
      return;
    }
    QLog.d("FSGpsHelper", 1, "preGetLocation get GpsInfo from request: failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.helper.FSGpsHelper.1
 * JD-Core Version:    0.7.0.1
 */