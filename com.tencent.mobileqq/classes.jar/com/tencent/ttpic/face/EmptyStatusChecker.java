package com.tencent.ttpic.face;

import com.tencent.ttpic.model.StickerItem.FeatureStatValueRange;

public class EmptyStatusChecker
  implements FaceStatusChecker
{
  private static EmptyStatusChecker instance = new EmptyStatusChecker();
  
  public static EmptyStatusChecker getInstance()
  {
    return instance;
  }
  
  public float getLevel(FaceRangeStatus paramFaceRangeStatus, StickerItem.FeatureStatValueRange paramFeatureStatValueRange)
  {
    return 0.0F;
  }
  
  public boolean isInRange(FaceRangeStatus paramFaceRangeStatus, StickerItem.FeatureStatValueRange paramFeatureStatValueRange)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.face.EmptyStatusChecker
 * JD-Core Version:    0.7.0.1
 */