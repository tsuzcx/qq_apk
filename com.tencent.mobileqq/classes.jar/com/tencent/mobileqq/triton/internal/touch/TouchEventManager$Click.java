package com.tencent.mobileqq.triton.internal.touch;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click;", "", "startX", "", "startY", "(II)V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "endX", "getEndX", "()I", "setEndX", "(I)V", "endY", "getEndY", "setEndY", "getStartX", "setStartX", "getStartY", "setStartY", "timestamp", "getTimestamp", "setTimestamp", "Triton_release"}, k=1, mv={1, 1, 16})
final class TouchEventManager$Click
{
  private long duration;
  private int endX;
  private int endY;
  private int startX;
  private int startY;
  private long timestamp;
  
  public TouchEventManager$Click(int paramInt1, int paramInt2)
  {
    this.startX = paramInt1;
    this.startY = paramInt2;
    this.timestamp = System.currentTimeMillis();
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  public final int getEndX()
  {
    return this.endX;
  }
  
  public final int getEndY()
  {
    return this.endY;
  }
  
  public final int getStartX()
  {
    return this.startX;
  }
  
  public final int getStartY()
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
  
  public final void setEndX(int paramInt)
  {
    this.endX = paramInt;
  }
  
  public final void setEndY(int paramInt)
  {
    this.endY = paramInt;
  }
  
  public final void setStartX(int paramInt)
  {
    this.startX = paramInt;
  }
  
  public final void setStartY(int paramInt)
  {
    this.startY = paramInt;
  }
  
  public final void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.touch.TouchEventManager.Click
 * JD-Core Version:    0.7.0.1
 */