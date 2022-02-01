package com.tencent.mobileqq.together.clockin;

import com.tencent.TMG.utils.QLog;
import java.util.Observable;

public class ClockAnimController
  extends Observable
{
  private boolean a = false;
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyAnimChanged : nEventId = ");
      localStringBuilder.append(paramInt);
      QLog.d("ClockAnimController", 0, localStringBuilder.toString());
    }
    if (paramInt == 1) {
      this.a = true;
    }
    if (paramInt == 4) {
      this.a = false;
    }
    setChanged();
    notifyObservers(Integer.valueOf(paramInt));
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPlayAnim : isPlayAnim = ");
      localStringBuilder.append(this.a);
      QLog.d("ClockAnimController", 0, localStringBuilder.toString());
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.ClockAnimController
 * JD-Core Version:    0.7.0.1
 */