package com.tencent.mobileqq.together.clockin;

import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.qphone.base.util.QLog;

class ClockInViewHelper$2
  extends TroopBusinessObserver
{
  ClockInViewHelper$2(ClockInViewHelper paramClockInViewHelper) {}
  
  public void onGetSignInStatus(boolean paramBoolean, String paramString1, String paramString2, Object paramObject, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClockInViewHelper", 2, "onGetSignInStatus isSucc = " + paramBoolean + ", troopUin = " + paramString1 + ", memberUin = " + paramString2);
    }
    ClockInViewHelper.a(this.a, paramBoolean, paramString1, paramString2, paramObject, paramInt);
  }
  
  public void onSetSignInStatus(boolean paramBoolean, String paramString1, String paramString2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClockInViewHelper", 2, "onSetSignInStatus isSucc = " + paramBoolean + ", troopUin = " + paramString1 + ", memberUin = " + paramString2);
    }
    ClockInViewHelper.a(this.a, paramBoolean, paramString1, paramString2, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.ClockInViewHelper.2
 * JD-Core Version:    0.7.0.1
 */