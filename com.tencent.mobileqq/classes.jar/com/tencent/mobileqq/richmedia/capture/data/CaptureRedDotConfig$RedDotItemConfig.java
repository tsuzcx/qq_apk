package com.tencent.mobileqq.richmedia.capture.data;

import java.io.Serializable;

public class CaptureRedDotConfig$RedDotItemConfig
  implements Serializable
{
  public String filterId;
  public long firstShowTime;
  public boolean hasShow;
  public transient boolean isShowing = false;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("RedDotItemConfig{");
    localStringBuilder.append("filterId='").append(this.filterId).append('\'');
    localStringBuilder.append(", hasShow=").append(this.hasShow);
    localStringBuilder.append(", firstShowTime=").append(this.firstShowTime);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig.RedDotItemConfig
 * JD-Core Version:    0.7.0.1
 */