package com.tencent.mobileqq.shortvideo.mtveffects;

public class MTV1ShapePoints
{
  public static float[] getOneRectPoints(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float[] arrayOfFloat = new float[8];
    float f = paramFloat1 - 1.0F;
    arrayOfFloat[0] = f;
    arrayOfFloat[1] = (paramFloat2 - 1.0F + paramFloat3);
    paramFloat1 = 1.0F - paramFloat1;
    arrayOfFloat[2] = paramFloat1;
    arrayOfFloat[3] = arrayOfFloat[1];
    arrayOfFloat[4] = paramFloat1;
    arrayOfFloat[5] = (1.0F - paramFloat2);
    arrayOfFloat[6] = f;
    arrayOfFloat[7] = arrayOfFloat[5];
    return arrayOfFloat;
  }
  
  public static float[] getTwoStaggerRectPoints(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    float[] arrayOfFloat = new float[20];
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = paramFloat3;
    if (paramFloat5 < 0.0F)
    {
      paramFloat5 = paramFloat1 - 1.0F;
      arrayOfFloat[2] = paramFloat5;
      float f = paramFloat2 - 1.0F;
      arrayOfFloat[3] = (f + paramFloat4 + paramFloat3);
      arrayOfFloat[4] = 0.0F;
      arrayOfFloat[5] = arrayOfFloat[3];
      arrayOfFloat[6] = 0.0F;
      arrayOfFloat[7] = (f + paramFloat3);
      paramFloat1 = 1.0F - paramFloat1;
      arrayOfFloat[8] = paramFloat1;
      arrayOfFloat[9] = arrayOfFloat[7];
      arrayOfFloat[10] = paramFloat1;
      paramFloat1 = 1.0F - paramFloat2;
      arrayOfFloat[11] = (paramFloat1 - paramFloat4);
      arrayOfFloat[12] = 0.0F;
      arrayOfFloat[13] = arrayOfFloat[11];
      arrayOfFloat[14] = 0.0F;
      arrayOfFloat[15] = paramFloat1;
      arrayOfFloat[16] = paramFloat5;
      arrayOfFloat[17] = arrayOfFloat[15];
    }
    else
    {
      arrayOfFloat[2] = (paramFloat1 - 1.0F);
      arrayOfFloat[3] = (paramFloat2 - 1.0F + paramFloat3);
      arrayOfFloat[4] = 0.0F;
      arrayOfFloat[5] = arrayOfFloat[3];
      arrayOfFloat[10] = (1.0F - paramFloat1);
      arrayOfFloat[11] = (1.0F - paramFloat2);
      arrayOfFloat[12] = 0.0F;
      arrayOfFloat[13] = arrayOfFloat[11];
      arrayOfFloat[6] = 0.0F;
      arrayOfFloat[7] = (arrayOfFloat[11] - paramFloat5);
      arrayOfFloat[8] = arrayOfFloat[10];
      arrayOfFloat[9] = arrayOfFloat[7];
      arrayOfFloat[14] = arrayOfFloat[4];
      arrayOfFloat[15] = (arrayOfFloat[5] + paramFloat5);
      arrayOfFloat[16] = arrayOfFloat[2];
      arrayOfFloat[17] = arrayOfFloat[15];
    }
    arrayOfFloat[18] = arrayOfFloat[2];
    arrayOfFloat[19] = arrayOfFloat[3];
    return arrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.MTV1ShapePoints
 * JD-Core Version:    0.7.0.1
 */