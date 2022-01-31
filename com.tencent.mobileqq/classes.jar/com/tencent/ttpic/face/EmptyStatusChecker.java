package com.tencent.ttpic.face;

import com.tencent.ttpic.openapi.model.StickerItem.ValueRange;

public class EmptyStatusChecker
  implements FaceStatusChecker
{
  private static EmptyStatusChecker instance = new EmptyStatusChecker();
  
  public static EmptyStatusChecker getInstance()
  {
    return instance;
  }
  
  public float getLevel(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange)
  {
    return 0.0F;
  }
  
  public boolean isInRange(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.face.EmptyStatusChecker
 * JD-Core Version:    0.7.0.1
 */