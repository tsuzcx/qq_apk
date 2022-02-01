package com.tencent.mobileqq.richmedia.capture.data;

import java.io.Serializable;

public class CaptureRedDotConfig$CategoryRedConfig
  implements Serializable
{
  public int categoryId;
  public long firstShowTime;
  public boolean hasShow;
  public transient boolean isShowing = false;
  public boolean showRedDot;
  public int version;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{");
    localStringBuilder.append("categoryId=");
    localStringBuilder.append(this.categoryId);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(", showRedDot=");
    localStringBuilder.append(this.showRedDot);
    localStringBuilder.append(", hasShow=");
    localStringBuilder.append(this.hasShow);
    localStringBuilder.append(", firstShowTime=");
    localStringBuilder.append(this.firstShowTime);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig.CategoryRedConfig
 * JD-Core Version:    0.7.0.1
 */