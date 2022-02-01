package com.tencent.ttpic.face;

import com.tencent.ttpic.openapi.model.StickerItem.ValueRange;

public class EyesStatusChecker
  implements FaceStatusChecker
{
  private static EyesStatusChecker instance = new EyesStatusChecker();
  
  public static EyesStatusChecker getInstance()
  {
    return instance;
  }
  
  public float getLevel(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange)
  {
    return (paramFaceRangeStatus.leftEye + paramFaceRangeStatus.rightEye) / 2.0F;
  }
  
  public boolean isInRange(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFaceRangeStatus != null)
    {
      if (paramValueRange == null) {
        return false;
      }
      bool1 = bool2;
      if (paramFaceRangeStatus.leftEye >= paramValueRange.min)
      {
        bool1 = bool2;
        if (paramFaceRangeStatus.leftEye <= paramValueRange.max)
        {
          bool1 = bool2;
          if (paramFaceRangeStatus.rightEye >= paramValueRange.min)
          {
            bool1 = bool2;
            if (paramFaceRangeStatus.rightEye <= paramValueRange.max) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.face.EyesStatusChecker
 * JD-Core Version:    0.7.0.1
 */