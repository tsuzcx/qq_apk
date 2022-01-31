package com.tencent.ttpic.face;

import com.tencent.ttpic.model.StickerItem.FeatureStatValueRange;

public class SingleEyeStatusChecker
  implements FaceStatusChecker
{
  private static SingleEyeStatusChecker instance = new SingleEyeStatusChecker();
  
  public static SingleEyeStatusChecker getInstance()
  {
    return instance;
  }
  
  public float getLevel(FaceRangeStatus paramFaceRangeStatus, StickerItem.FeatureStatValueRange paramFeatureStatValueRange)
  {
    return Math.max(paramFaceRangeStatus.leftEye, paramFaceRangeStatus.rightEye);
  }
  
  public boolean isInRange(FaceRangeStatus paramFaceRangeStatus, StickerItem.FeatureStatValueRange paramFeatureStatValueRange)
  {
    if ((paramFaceRangeStatus == null) || (paramFeatureStatValueRange == null)) {}
    while (((paramFaceRangeStatus.leftEye < paramFeatureStatValueRange.min) || (paramFaceRangeStatus.leftEye > paramFeatureStatValueRange.max)) && ((paramFaceRangeStatus.rightEye < paramFeatureStatValueRange.min) || (paramFaceRangeStatus.rightEye > paramFeatureStatValueRange.max))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.face.SingleEyeStatusChecker
 * JD-Core Version:    0.7.0.1
 */