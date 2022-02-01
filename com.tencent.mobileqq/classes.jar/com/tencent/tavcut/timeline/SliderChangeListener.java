package com.tencent.tavcut.timeline;

public abstract interface SliderChangeListener
{
  public abstract void onIndicatorMove(float paramFloat);
  
  public abstract void onIndicatorMove(long paramLong);
  
  public abstract void onIndicatorPress();
  
  public abstract void onIndicatorRelease();
  
  public abstract void onSelectionChange(long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract void onSliderBarMove(boolean paramBoolean, float paramFloat1, float paramFloat2);
  
  public abstract void onSliderBarRelease(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.timeline.SliderChangeListener
 * JD-Core Version:    0.7.0.1
 */