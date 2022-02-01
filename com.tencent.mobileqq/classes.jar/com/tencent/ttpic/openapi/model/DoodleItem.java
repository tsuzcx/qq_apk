package com.tencent.ttpic.openapi.model;

import java.util.Arrays;

public class DoodleItem
  extends StickerItem
{
  public int count;
  
  public String toString()
  {
    return "StickerItem{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", type=" + this.type + ", triggerType=" + getTriggerTypeString() + ", alwaysTriggered=" + this.alwaysTriggered + ", playCount=" + this.playCount + ", frameDuration=" + this.frameDuration + ", frames=" + this.frames + ", width=" + this.width + ", height=" + this.height + ", position=" + Arrays.toString(this.position) + ", audio='" + this.audio + '\'' + ", anchorPoint=" + Arrays.toString(this.anchorPoint) + ", alignFacePoints=" + Arrays.toString(this.alignFacePoints) + ", scalePivots=" + Arrays.toString(this.scalePivots) + ", scaleFactor=" + this.scaleFactor + ", support3D=" + this.support3D + ", count=" + this.count + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.DoodleItem
 * JD-Core Version:    0.7.0.1
 */