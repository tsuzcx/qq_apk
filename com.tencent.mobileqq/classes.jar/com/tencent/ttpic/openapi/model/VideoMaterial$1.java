package com.tencent.ttpic.openapi.model;

import java.util.Comparator;

class VideoMaterial$1
  implements Comparator<Integer>
{
  VideoMaterial$1(VideoMaterial paramVideoMaterial, int[] paramArrayOfInt) {}
  
  public int compare(Integer paramInteger1, Integer paramInteger2)
  {
    return this.val$frameIndex[paramInteger1.intValue()] - this.val$frameIndex[paramInteger2.intValue()];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.VideoMaterial.1
 * JD-Core Version:    0.7.0.1
 */