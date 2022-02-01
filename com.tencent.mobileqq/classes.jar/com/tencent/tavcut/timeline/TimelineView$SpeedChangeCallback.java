package com.tencent.tavcut.timeline;

public abstract interface TimelineView$SpeedChangeCallback
{
  public static final int CODE_TOO_FAST_FOR_1_5_TIME_SPEED = 1001;
  public static final int CODE_TOO_FAST_FOR_2_0_TIME_SPEED = 1000;
  
  public abstract void onChangeFailed(int paramInt);
  
  public abstract void onChangeSucc(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.timeline.TimelineView.SpeedChangeCallback
 * JD-Core Version:    0.7.0.1
 */