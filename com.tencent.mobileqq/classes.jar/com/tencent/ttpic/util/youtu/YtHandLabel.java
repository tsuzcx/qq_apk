package com.tencent.ttpic.util.youtu;

public class YtHandLabel
{
  private static final int LOST_TIME_INTERVAL = 300;
  private static final String TAG = YtHandLabel.class.getSimpleName();
  public long lostStartTimestamp;
  public String name = "";
  public int value = -1;
  
  public boolean isConsiderLost()
  {
    return System.currentTimeMillis() - this.lostStartTimestamp > 300L;
  }
  
  public void reset()
  {
    this.value = -1;
    this.name = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.YtHandLabel
 * JD-Core Version:    0.7.0.1
 */