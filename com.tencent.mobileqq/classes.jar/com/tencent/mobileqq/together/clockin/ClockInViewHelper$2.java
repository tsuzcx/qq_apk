package com.tencent.mobileqq.together.clockin;

import com.tencent.mobileqq.troop.clockin.api.TroopClockInObserver;
import com.tencent.qphone.base.util.QLog;

class ClockInViewHelper$2
  extends TroopClockInObserver
{
  ClockInViewHelper$2(ClockInViewHelper paramClockInViewHelper) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSetClockInStatus isSucc = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", troopUin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", memberUin = ");
      localStringBuilder.append(paramString2);
      QLog.d("ClockInViewHelper", 2, localStringBuilder.toString());
    }
    ClockInViewHelper.a(this.a, paramBoolean, paramString1, paramString2, paramObject);
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, Object paramObject, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetClockInStatus isSucc = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", troopUin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", memberUin = ");
      localStringBuilder.append(paramString2);
      QLog.d("ClockInViewHelper", 2, localStringBuilder.toString());
    }
    ClockInViewHelper.a(this.a, paramBoolean, paramString1, paramString2, paramObject, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.ClockInViewHelper.2
 * JD-Core Version:    0.7.0.1
 */