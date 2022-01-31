package com.tencent.ttpic.face;

import com.tencent.ttpic.model.StickerItem.FeatureStatValueRange;

public class MouthStatusChecker
  implements FaceStatusChecker
{
  private static MouthStatusChecker instance = new MouthStatusChecker();
  
  public static MouthStatusChecker getInstance()
  {
    return instance;
  }
  
  public float getLevel(FaceRangeStatus paramFaceRangeStatus, StickerItem.FeatureStatValueRange paramFeatureStatValueRange)
  {
    return paramFaceRangeStatus.mouth;
  }
  
  public boolean isInRange(FaceRangeStatus paramFaceRangeStatus, StickerItem.FeatureStatValueRange paramFeatureStatValueRange)
  {
    if ((paramFaceRangeStatus == null) || (paramFeatureStatValueRange == null)) {}
    while ((paramFaceRangeStatus.mouth < paramFeatureStatValueRange.min) || (paramFaceRangeStatus.mouth > paramFeatureStatValueRange.max)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.face.MouthStatusChecker
 * JD-Core Version:    0.7.0.1
 */