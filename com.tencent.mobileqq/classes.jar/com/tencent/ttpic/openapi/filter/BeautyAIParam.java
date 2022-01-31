package com.tencent.ttpic.openapi.filter;

public class BeautyAIParam
{
  private static float[][] beautyAITable = { { 0.0F, 0.0F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, { 0.15F, 0.3F, 0.3F, 0.08F, 0.7F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F }, { 0.15F, 0.4F, 0.3F, 0.08F, 0.7F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F }, { 0.15F, 0.4F, 0.3F, 0.08F, 0.7F, 0.5F, 0.4F, 0.5F, 0.3F, 0.0F }, { 0.3F, 0.3F, 0.3F, 0.16F, 0.7F, 0.0F, 0.0F, 0.0F, 0.4F, 1.0F }, { 0.3F, 0.3F, 0.3F, 0.16F, 0.7F, 0.0F, 0.2F, 0.2F, 0.4F, 1.0F }, { 0.3F, 0.3F, 0.3F, 0.16F, 0.7F, 0.7F, 0.7F, 0.7F, 0.6F, 1.0F } };
  private static float[][] beautyAITableClose;
  private static boolean sNeedAIBeauty = true;
  private float[][] beautyAIMaxTable;
  private float[][] beautyAIMaxTableClose;
  private float[] beautyGeneral;
  private float[] beautyGeneralClose;
  private int personType;
  
  static
  {
    float[] arrayOfFloat1 = { 0.3F, 0.0F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.0F, 0.6F, 0.0F };
    float[] arrayOfFloat2 = { 0.3F, 0.0F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.0F, 0.6F, 0.0F };
    float[] arrayOfFloat3 = { 0.3F, 0.0F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.0F, 0.6F, 0.0F };
    float[] arrayOfFloat4 = { 0.3F, 0.0F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.0F, 0.6F, 0.0F };
    float[] arrayOfFloat5 = { 0.3F, 0.0F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.0F, 0.6F, 0.0F };
    beautyAITableClose = new float[][] { arrayOfFloat1, arrayOfFloat2, arrayOfFloat3, arrayOfFloat4, { 0.3F, 0.0F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.0F, 0.6F, 0.0F }, arrayOfFloat5, { 0.3F, 0.0F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.0F, 0.6F, 0.0F } };
  }
  
  public BeautyAIParam()
  {
    float[] arrayOfFloat1 = { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.9F, 1.0F };
    float[] arrayOfFloat2 = { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.29F, 0.29F, 0.9F, 1.0F };
    this.beautyAIMaxTable = new float[][] { { 0.5F, 0.5F, 0.5F, 0.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F }, { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.7F, 0.0F }, { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.7F, 0.0F }, { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.71F, 0.57F, 0.71F, 0.8F, 0.0F }, arrayOfFloat1, arrayOfFloat2, { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F } };
    this.beautyGeneral = new float[] { 0.3F, 0.4F, 0.3F, 0.16F, 0.7F, 0.7F, 0.7F, 0.7F, 0.6F, 0.0F };
    arrayOfFloat1 = new float[] { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    arrayOfFloat2 = new float[] { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.beautyAIMaxTableClose = new float[][] { arrayOfFloat1, { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F }, { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F }, { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F }, { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F }, arrayOfFloat2, { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F } };
    this.beautyGeneralClose = new float[] { 0.3F, 0.0F, 0.0F, 0.0F, 0.7F, 0.7F, 0.7F, 0.7F, 0.6F, 0.0F };
    this.personType = 0;
  }
  
  public static float[][] getBeautyAITable()
  {
    return beautyAITable;
  }
  
  public static boolean needAIBeautyValid()
  {
    return sNeedAIBeauty;
  }
  
  public static void setAIBeautyValid(boolean paramBoolean)
  {
    sNeedAIBeauty = paramBoolean;
  }
  
  public void closeAIBeauty()
  {
    beautyAITable = beautyAITableClose;
    this.beautyAIMaxTable = this.beautyAIMaxTableClose;
    this.beautyGeneral = this.beautyGeneralClose;
  }
  
  public float getRealValue(BeautyAIParam.AI_TYPE paramAI_TYPE, float paramFloat)
  {
    float f = paramFloat;
    if (this.beautyGeneral[paramAI_TYPE.value] != 0.0F)
    {
      f = paramFloat;
      if (paramAI_TYPE != BeautyAIParam.AI_TYPE.FACEOFF)
      {
        if (paramFloat >= this.beautyGeneral[paramAI_TYPE.value]) {
          break label67;
        }
        f = beautyAITable[this.personType][paramAI_TYPE.value] * paramFloat / this.beautyGeneral[paramAI_TYPE.value];
      }
    }
    return f;
    label67:
    return beautyAITable[this.personType][paramAI_TYPE.value] + (paramFloat - this.beautyGeneral[paramAI_TYPE.value]) / (1.0F - this.beautyGeneral[paramAI_TYPE.value]) * (this.beautyAIMaxTable[this.personType][paramAI_TYPE.value] - beautyAITable[this.personType][paramAI_TYPE.value]);
  }
  
  public void setBeautyAITable(float[][] paramArrayOfFloat)
  {
    beautyAITable = paramArrayOfFloat;
  }
  
  public void setBeautyGeneral(float[] paramArrayOfFloat)
  {
    this.beautyGeneral = paramArrayOfFloat;
  }
  
  public void setBeautyParam(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      this.personType = 5;
      return;
    }
    if (!paramBoolean1)
    {
      if (paramInt < 6)
      {
        this.personType = 0;
        return;
      }
      if (paramInt < 16)
      {
        this.personType = 1;
        return;
      }
      if (paramInt < 36)
      {
        this.personType = 2;
        return;
      }
      this.personType = 3;
      return;
    }
    if (paramInt < 6)
    {
      this.personType = 0;
      return;
    }
    if (paramInt < 16)
    {
      this.personType = 4;
      return;
    }
    if (paramInt < 36)
    {
      this.personType = 5;
      return;
    }
    this.personType = 6;
  }
  
  public void setFemalePercent(float paramFloat)
  {
    beautyAITableClose[4][0] = (paramFloat * 0.3F);
    beautyAITableClose[5][0] = (paramFloat * 0.3F);
    beautyAITableClose[6][0] = (paramFloat * 0.3F);
  }
  
  public void setMalePercent(float paramFloat)
  {
    beautyAITableClose[1][0] = (paramFloat * 0.3F);
    beautyAITableClose[2][0] = (paramFloat * 0.3F);
    beautyAITableClose[3][0] = (paramFloat * 0.3F);
  }
  
  public void setbeautyAIMaxTable(float[][] paramArrayOfFloat)
  {
    this.beautyAIMaxTable = paramArrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.BeautyAIParam
 * JD-Core Version:    0.7.0.1
 */