package com.tencent.ttpic.model;

import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.Arrays;

public class NonFitItem
  extends StickerItem
{
  public int clickMode;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NonFitItem{id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", triggerMode=");
    localStringBuilder.append(this.triggerMode);
    localStringBuilder.append(", clickMode=");
    localStringBuilder.append(this.clickMode);
    localStringBuilder.append(", playCount=");
    localStringBuilder.append(this.playCount);
    localStringBuilder.append(", frameDuration=");
    localStringBuilder.append(this.frameDuration);
    localStringBuilder.append(", frames=");
    localStringBuilder.append(this.frames);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append(", position=");
    localStringBuilder.append(Arrays.toString(this.position));
    localStringBuilder.append(", audio='");
    localStringBuilder.append(this.audio);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.model.NonFitItem
 * JD-Core Version:    0.7.0.1
 */