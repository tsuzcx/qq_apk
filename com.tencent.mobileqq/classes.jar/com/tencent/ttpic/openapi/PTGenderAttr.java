package com.tencent.ttpic.openapi;

import java.util.ArrayList;

public class PTGenderAttr
{
  public static final int GENDER_FEMALE = 0;
  public static final int GENDER_MALE = 1;
  private ArrayList<PTGenderAttr.GenderInfo> genderInfos;
  
  public void addGenderInfo(long paramLong, float[] paramArrayOfFloat, int paramInt1, int paramInt2, float paramFloat)
  {
    if (this.genderInfos == null) {
      this.genderInfos = new ArrayList();
    }
    this.genderInfos.add(new PTGenderAttr.GenderInfo(this, paramLong, paramArrayOfFloat, paramInt1, paramInt2, paramFloat));
  }
  
  public ArrayList<PTGenderAttr.GenderInfo> getGenderInfos()
  {
    return this.genderInfos;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.PTGenderAttr
 * JD-Core Version:    0.7.0.1
 */