package com.tencent.mobileqq.together.clockin;

import com.tencent.qphone.base.util.QLog;

public class ClockView
{
  private ClockAnimController a;
  
  public ClockView(ClockAnimController paramClockAnimController)
  {
    this.a = paramClockAnimController;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClockView", 2, "notifyChanged : nEventId = " + paramInt);
    }
    if (this.a != null) {
      this.a.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.ClockView
 * JD-Core Version:    0.7.0.1
 */