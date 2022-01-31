package com.tencent.mobileqq.shortvideo.ptvfilter;

import com.tencent.ttpic.model.StickerItem;
import java.util.Arrays;

public class NonFitItem
  extends StickerItem
{
  public int a;
  public int b;
  
  public String toString()
  {
    return "NonFitItem{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", triggerMode=" + this.a + ", clickMode=" + this.b + ", playCount=" + this.playCount + ", frameDuration=" + this.frameDuration + ", frames=" + this.frames + ", width=" + this.width + ", height=" + this.height + ", position=" + Arrays.toString(this.position) + ", audio='" + this.audio + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.NonFitItem
 * JD-Core Version:    0.7.0.1
 */