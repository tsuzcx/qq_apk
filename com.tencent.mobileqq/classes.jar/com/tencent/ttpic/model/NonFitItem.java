package com.tencent.ttpic.model;

import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.Arrays;

public class NonFitItem
  extends StickerItem
{
  public int clickMode;
  
  public String toString()
  {
    return "NonFitItem{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", triggerMode=" + this.triggerMode + ", clickMode=" + this.clickMode + ", playCount=" + this.playCount + ", frameDuration=" + this.frameDuration + ", frames=" + this.frames + ", width=" + this.width + ", height=" + this.height + ", position=" + Arrays.toString(this.position) + ", audio='" + this.audio + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.model.NonFitItem
 * JD-Core Version:    0.7.0.1
 */