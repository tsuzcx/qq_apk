package com.tencent.ttpic.openapi.model;

import java.util.Arrays;

public class DoodleItem
  extends StickerItem
{
  public int count;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StickerItem{id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", triggerType=");
    localStringBuilder.append(getTriggerTypeString());
    localStringBuilder.append(", alwaysTriggered=");
    localStringBuilder.append(this.alwaysTriggered);
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
    localStringBuilder.append(", anchorPoint=");
    localStringBuilder.append(Arrays.toString(this.anchorPoint));
    localStringBuilder.append(", alignFacePoints=");
    localStringBuilder.append(Arrays.toString(this.alignFacePoints));
    localStringBuilder.append(", scalePivots=");
    localStringBuilder.append(Arrays.toString(this.scalePivots));
    localStringBuilder.append(", scaleFactor=");
    localStringBuilder.append(this.scaleFactor);
    localStringBuilder.append(", support3D=");
    localStringBuilder.append(this.support3D);
    localStringBuilder.append(", count=");
    localStringBuilder.append(this.count);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.DoodleItem
 * JD-Core Version:    0.7.0.1
 */