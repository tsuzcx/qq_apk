package com.tencent.ttpic.face;

import com.tencent.ttpic.openapi.model.StickerItem.ValueRange;

public class LeftEyeStatusChecker
  implements FaceStatusChecker
{
  private static LeftEyeStatusChecker instance = new LeftEyeStatusChecker();
  
  public static LeftEyeStatusChecker getInstance()
  {
    return instance;
  }
  
  public float getLevel(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange)
  {
    return paramFaceRangeStatus.leftEye;
  }
  
  public boolean isInRange(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange)
  {
    if ((paramFaceRangeStatus == null) || (paramValueRange == null)) {}
    while ((paramFaceRangeStatus.leftEye < paramValueRange.min) || (paramFaceRangeStatus.leftEye > paramValueRange.max)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.face.LeftEyeStatusChecker
 * JD-Core Version:    0.7.0.1
 */