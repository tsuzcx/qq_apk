package com.tencent.ttpic.face;

import com.tencent.ttpic.openapi.model.StickerItem.ValueRange;

public class MouthStatusChecker
  implements FaceStatusChecker
{
  private static MouthStatusChecker instance = new MouthStatusChecker();
  
  public static MouthStatusChecker getInstance()
  {
    return instance;
  }
  
  public float getLevel(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange)
  {
    return paramFaceRangeStatus.mouth;
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
      if (paramFaceRangeStatus.mouth >= paramValueRange.min)
      {
        bool1 = bool2;
        if (paramFaceRangeStatus.mouth <= paramValueRange.max) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.face.MouthStatusChecker
 * JD-Core Version:    0.7.0.1
 */