package com.tencent.ttpic.openapi;

public class PTGenderAttr$GenderInfo
{
  public float confidence;
  public int curGender;
  public long faceId;
  public int gender;
  public float[] rect = new float[4];
  
  PTGenderAttr$GenderInfo(PTGenderAttr paramPTGenderAttr, long paramLong, float[] paramArrayOfFloat, int paramInt1, int paramInt2, float paramFloat)
  {
    this.faceId = paramLong;
    this.rect = paramArrayOfFloat;
    this.gender = paramInt1;
    this.confidence = paramFloat;
    this.curGender = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.PTGenderAttr.GenderInfo
 * JD-Core Version:    0.7.0.1
 */