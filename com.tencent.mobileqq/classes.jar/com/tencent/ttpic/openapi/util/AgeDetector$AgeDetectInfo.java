package com.tencent.ttpic.openapi.util;

import com.tencent.ttpic.facedetect.AgeType;

class AgeDetector$AgeDetectInfo
  extends AgeDetector.AgeParams
{
  float[] points;
  
  public AgeDetector$AgeDetectInfo(AgeDetector paramAgeDetector, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, boolean paramBoolean, long paramLong)
  {
    super(paramAgeDetector);
    this.ageType = AgeType.DEFAULT.value;
    this.faceID = paramLong;
    this.isInImage = paramBoolean;
    this.points = new float[] { paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.AgeDetector.AgeDetectInfo
 * JD-Core Version:    0.7.0.1
 */