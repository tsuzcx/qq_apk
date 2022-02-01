package com.tencent.mobileqq.troop.onlinemember.handler;

import android.os.SystemClock;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class TroopOnlineMemberHandler$1
  extends LbsManagerServiceOnLocationChangeListener
{
  TroopOnlineMemberHandler$1(TroopOnlineMemberHandler paramTroopOnlineMemberHandler, String paramString1, long paramLong, String paramString2)
  {
    super(paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    long l = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLocationFinish, time=");
      localStringBuilder.append(l - this.a);
      localStringBuilder.append("ms");
      QLog.i("TroopOnlineMemberHandler", 2, localStringBuilder.toString());
    }
    if (paramInt != 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDetailOnlineMemberList, startLocation, errorCode=");
      localStringBuilder.append(paramInt);
      QLog.i("TroopOnlineMemberHandler", 1, localStringBuilder.toString());
    }
    TroopOnlineMemberHandler.a(this.c, this.b, paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.onlinemember.handler.TroopOnlineMemberHandler.1
 * JD-Core Version:    0.7.0.1
 */