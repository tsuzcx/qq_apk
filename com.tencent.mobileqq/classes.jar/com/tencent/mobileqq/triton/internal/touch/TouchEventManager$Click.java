package com.tencent.mobileqq.triton.internal.touch;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click;", "", "startX", "", "startY", "(FF)V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "endX", "getEndX", "()F", "setEndX", "(F)V", "endY", "getEndY", "setEndY", "getStartX", "setStartX", "getStartY", "setStartY", "timestamp", "getTimestamp", "setTimestamp", "Triton_release"}, k=1, mv={1, 1, 16})
final class TouchEventManager$Click
{
  private long duration;
  private float endX;
  private float endY;
  private float startX;
  private float startY;
  private long timestamp;
  
  public TouchEventManager$Click(float paramFloat1, float paramFloat2)
  {
    this.startX = paramFloat1;
    this.startY = paramFloat2;
    this.timestamp = System.currentTimeMillis();
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  public final float getEndX()
  {
    return this.endX;
  }
  
  public final float getEndY()
  {
    return this.endY;
  }
  
  public final float getStartX()
  {
    return this.startX;
  }
  
  public final float getStartY()
  {
    return this.startY;
  }
  
  public final long getTimestamp()
  {
    return this.timestamp;
  }
  
  public final void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public final void setEndX(float paramFloat)
  {
    this.endX = paramFloat;
  }
  
  public final void setEndY(float paramFloat)
  {
    this.endY = paramFloat;
  }
  
  public final void setStartX(float paramFloat)
  {
    this.startX = paramFloat;
  }
  
  public final void setStartY(float paramFloat)
  {
    this.startY = paramFloat;
  }
  
  public final void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.touch.TouchEventManager.Click
 * JD-Core Version:    0.7.0.1
 */