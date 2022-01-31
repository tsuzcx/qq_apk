package com.tencent.ttpic.face;

import com.tencent.ttpic.openapi.model.StickerItem.ValueRange;

public class SingleEyeStatusChecker
  implements FaceStatusChecker
{
  private static SingleEyeStatusChecker instance = new SingleEyeStatusChecker();
  
  public static SingleEyeStatusChecker getInstance()
  {
    return instance;
  }
  
  public float getLevel(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange)
  {
    return Math.max(paramFaceRangeStatus.leftEye, paramFaceRangeStatus.rightEye);
  }
  
  public boolean isInRange(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange)
  {
    if ((paramFaceRangeStatus == null) || (paramValueRange == null)) {}
    while (((paramFaceRangeStatus.leftEye < paramValueRange.min) || (paramFaceRangeStatus.leftEye > paramValueRange.max)) && ((paramFaceRangeStatus.rightEye < paramValueRange.min) || (paramFaceRangeStatus.rightEye > paramValueRange.max))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.face.SingleEyeStatusChecker
 * JD-Core Version:    0.7.0.1
 */