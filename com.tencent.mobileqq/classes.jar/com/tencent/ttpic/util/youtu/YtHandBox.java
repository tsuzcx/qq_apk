package com.tencent.ttpic.util.youtu;

public class YtHandBox
{
  public float confidence = 0.0F;
  public int handType = -999;
  public float height = 0.0F;
  public long makeTime = 0L;
  public float width = 0.0F;
  public float x = 0.0F;
  public float y = 0.0F;
  
  public YtHandBox copy()
  {
    YtHandBox localYtHandBox = new YtHandBox();
    localYtHandBox.x = this.x;
    localYtHandBox.y = this.y;
    localYtHandBox.width = this.width;
    localYtHandBox.height = this.height;
    localYtHandBox.confidence = this.confidence;
    localYtHandBox.makeTime = this.makeTime;
    localYtHandBox.handType = this.handType;
    return localYtHandBox;
  }
  
  public boolean isValid()
  {
    return (this.width > 0.0F) && (this.height > 0.0F);
  }
  
  public void reset()
  {
    this.confidence = 0.0F;
    this.height = 0.0F;
    this.width = 0.0F;
    this.y = 0.0F;
    this.x = 0.0F;
    this.makeTime = 0L;
    this.handType = -999;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.YtHandBox
 * JD-Core Version:    0.7.0.1
 */