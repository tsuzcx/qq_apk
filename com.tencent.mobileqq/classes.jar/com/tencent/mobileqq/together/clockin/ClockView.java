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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyChanged : nEventId = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ClockView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((ClockAnimController)localObject).a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.ClockView
 * JD-Core Version:    0.7.0.1
 */