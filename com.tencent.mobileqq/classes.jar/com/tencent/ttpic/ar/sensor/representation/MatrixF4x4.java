package com.tencent.ttpic.ar.sensor.representation;

import com.tencent.ttpic.baseutils.log.LogUtils;

public class MatrixF4x4
{
  public static final int[] matIndCol16_3x3;
  public static final int[] matIndCol16_4x4 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
  public static final int[] matIndCol9_3x3 = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
  public static final int[] matIndRow16_3x3;
  public static final int[] matIndRow16_4x4 = { 0, 4, 8, 12, 1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15 };
  public static final int[] matIndRow9_3x3;
  private boolean colMaj = true;
  public float[] matrix = new float[16];
  
  static
  {
    matIndCol16_3x3 = new int[] { 0, 1, 2, 4, 5, 6, 8, 9, 10 };
    matIndRow9_3x3 = new int[] { 0, 3, 6, 1, 4, 7, 3, 5, 8 };
    matIndRow16_3x3 = new int[] { 0, 4, 8, 1, 5, 9, 2, 6, 10 };
  }
  
  public MatrixF4x4()
  {
    Matrix.setIdentityM(this.matrix, 0);
  }
  
  public float[] getMatrix()
  {
    return this.matrix;
  }
  
  public boolean isColumnMajor()
  {
    return this.colMaj;
  }
  
  public void multiplyMatrix(float[] paramArrayOfFloat1, int paramInt1, float[] paramArrayOfFloat2, int paramInt2)
  {
    int i = 0;
    while (i < 4)
    {
      int j = 0;
      while (j < 4)
      {
        int m = paramInt2 + 0 + j;
        float f = paramArrayOfFloat2[m];
        float[] arrayOfFloat = this.matrix;
        int k = i * 4 + j;
        paramArrayOfFloat2[m] = (f + arrayOfFloat[k] * paramArrayOfFloat1[(paramInt1 + 0 + i)]);
        m = paramInt2 + 4 + j;
        paramArrayOfFloat2[m] += arrayOfFloat[k] * paramArrayOfFloat1[(paramInt1 + 4 + i)];
        m = paramInt2 + 8 + j;
        paramArrayOfFloat2[m] += arrayOfFloat[k] * paramArrayOfFloat1[(paramInt1 + 8 + i)];
        m = paramInt2 + 12 + j;
        paramArrayOfFloat2[m] += arrayOfFloat[k] * paramArrayOfFloat1[(paramInt1 + 12 + i)];
        j += 1;
      }
      i += 1;
    }
  }
  
  public void multiplyMatrix4x4ByMatrix(MatrixF4x4 paramMatrixF4x4)
  {
    float[] arrayOfFloat = new float[16];
    float[] tmp6_5 = arrayOfFloat;
    tmp6_5[0] = 0.0F;
    float[] tmp10_6 = tmp6_5;
    tmp10_6[1] = 0.0F;
    float[] tmp14_10 = tmp10_6;
    tmp14_10[2] = 0.0F;
    float[] tmp18_14 = tmp14_10;
    tmp18_14[3] = 0.0F;
    float[] tmp22_18 = tmp18_14;
    tmp22_18[4] = 0.0F;
    float[] tmp26_22 = tmp22_18;
    tmp26_22[5] = 0.0F;
    float[] tmp30_26 = tmp26_22;
    tmp30_26[6] = 0.0F;
    float[] tmp35_30 = tmp30_26;
    tmp35_30[7] = 0.0F;
    float[] tmp40_35 = tmp35_30;
    tmp40_35[8] = 0.0F;
    float[] tmp45_40 = tmp40_35;
    tmp45_40[9] = 0.0F;
    float[] tmp50_45 = tmp45_40;
    tmp50_45[10] = 0.0F;
    float[] tmp55_50 = tmp50_45;
    tmp55_50[11] = 0.0F;
    float[] tmp60_55 = tmp55_50;
    tmp60_55[12] = 0.0F;
    float[] tmp65_60 = tmp60_55;
    tmp65_60[13] = 0.0F;
    float[] tmp70_65 = tmp65_60;
    tmp70_65[14] = 0.0F;
    float[] tmp75_70 = tmp70_65;
    tmp75_70[15] = 0.0F;
    tmp75_70;
    multiplyMatrix(paramMatrixF4x4.getMatrix(), 0, arrayOfFloat, 0);
    paramMatrixF4x4.setMatrix(arrayOfFloat);
  }
  
  public void multiplyVector3fByMatrix(Vector3f paramVector3f)
  {
    if (this.matrix.length == 9)
    {
      float[] arrayOfFloat1 = paramVector3f.toArray();
      boolean bool = this.colMaj;
      float f4 = 0.0F;
      float f3 = 0.0F;
      int j = 0;
      int i = 0;
      float f5;
      float f6;
      float[] arrayOfFloat2;
      if (!bool)
      {
        f2 = 0.0F;
        f1 = 0.0F;
        for (;;)
        {
          f4 = f2;
          f5 = f3;
          f6 = f1;
          if (i >= 3) {
            break;
          }
          j = i * 3;
          arrayOfFloat2 = this.matrix;
          f3 += arrayOfFloat2[(j + 0)] * arrayOfFloat1[i];
          f2 += arrayOfFloat2[(j + 1)] * arrayOfFloat1[i];
          f1 += arrayOfFloat2[(j + 2)] * arrayOfFloat1[i];
          i += 1;
        }
      }
      float f2 = 0.0F;
      float f1 = 0.0F;
      i = j;
      f3 = f4;
      for (;;)
      {
        f4 = f2;
        f5 = f3;
        f6 = f1;
        if (i >= 3) {
          break;
        }
        arrayOfFloat2 = this.matrix;
        f3 += arrayOfFloat2[(i + 0)] * arrayOfFloat1[i];
        f2 += arrayOfFloat2[(i + 3)] * arrayOfFloat1[i];
        f1 += arrayOfFloat2[(i + 6)] * arrayOfFloat1[i];
        i += 1;
      }
      paramVector3f.setX(f5);
      paramVector3f.setY(f4);
      paramVector3f.setZ(f6);
      return;
    }
    paramVector3f = new StringBuilder();
    paramVector3f.append("Matrix is invalid, is ");
    paramVector3f.append(this.matrix.length);
    paramVector3f.append(" long, this function expects the internal matrix to be of size 9");
    LogUtils.e("matrix", paramVector3f.toString());
  }
  
  public void multiplyVector4fByMatrix(Vector4f paramVector4f)
  {
    if (this.matrix.length == 16)
    {
      float[] arrayOfFloat1 = paramVector4f.array();
      boolean bool = this.colMaj;
      int j = 0;
      int i = 0;
      float f5 = 0.0F;
      float f4 = 0.0F;
      float f6;
      float f7;
      float f8;
      float[] arrayOfFloat2;
      if (bool)
      {
        f3 = 0.0F;
        f2 = 0.0F;
        f1 = 0.0F;
        for (;;)
        {
          f5 = f3;
          f6 = f4;
          f7 = f2;
          f8 = f1;
          if (i >= 4) {
            break;
          }
          j = i * 4;
          arrayOfFloat2 = this.matrix;
          f4 += arrayOfFloat2[(j + 0)] * arrayOfFloat1[i];
          f3 += arrayOfFloat2[(j + 1)] * arrayOfFloat1[i];
          f2 += arrayOfFloat2[(j + 2)] * arrayOfFloat1[i];
          f1 += arrayOfFloat2[(j + 3)] * arrayOfFloat1[i];
          i += 1;
        }
      }
      float f3 = 0.0F;
      float f2 = 0.0F;
      float f1 = 0.0F;
      f4 = f5;
      i = j;
      for (;;)
      {
        f5 = f3;
        f6 = f4;
        f7 = f2;
        f8 = f1;
        if (i >= 4) {
          break;
        }
        arrayOfFloat2 = this.matrix;
        f4 += arrayOfFloat2[(i + 0)] * arrayOfFloat1[i];
        f3 += arrayOfFloat2[(i + 4)] * arrayOfFloat1[i];
        f2 += arrayOfFloat2[(i + 8)] * arrayOfFloat1[i];
        f1 += arrayOfFloat2[(i + 12)] * arrayOfFloat1[i];
        i += 1;
      }
      paramVector4f.setX(f6);
      paramVector4f.setY(f5);
      paramVector4f.setZ(f7);
      paramVector4f.setW(f8);
      return;
    }
    paramVector4f = new StringBuilder();
    paramVector4f.append("Matrix is invalid, is ");
    paramVector4f.append(this.matrix.length);
    paramVector4f.append(" long, this equation expects a 16 value matrix");
    LogUtils.e("matrix", paramVector4f.toString());
  }
  
  public void set(MatrixF4x4 paramMatrixF4x4)
  {
    paramMatrixF4x4 = paramMatrixF4x4.matrix;
    float[] arrayOfFloat = this.matrix;
    System.arraycopy(paramMatrixF4x4, 0, arrayOfFloat, 0, arrayOfFloat.length);
  }
  
  public void setColumnMajor(boolean paramBoolean)
  {
    this.colMaj = paramBoolean;
  }
  
  public void setMatrix(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat.length != 16) && (paramArrayOfFloat.length != 9))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Matrix set is invalid, size is ");
      localStringBuilder.append(paramArrayOfFloat.length);
      localStringBuilder.append(" expected 9 or 16");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.matrix = paramArrayOfFloat;
  }
  
  public void setW0(float paramFloat)
  {
    float[] arrayOfFloat = this.matrix;
    if (arrayOfFloat.length == 16)
    {
      if (this.colMaj)
      {
        arrayOfFloat[matIndCol16_4x4[12]] = paramFloat;
        return;
      }
      arrayOfFloat[matIndRow16_4x4[12]] = paramFloat;
      return;
    }
    throw new IllegalStateException("length of matrix should be 16");
  }
  
  public void setW1(float paramFloat)
  {
    float[] arrayOfFloat = this.matrix;
    if (arrayOfFloat.length == 16)
    {
      if (this.colMaj)
      {
        arrayOfFloat[matIndCol16_4x4[13]] = paramFloat;
        return;
      }
      arrayOfFloat[matIndRow16_4x4[13]] = paramFloat;
      return;
    }
    throw new IllegalStateException("length of matrix should be 16");
  }
  
  public void setW2(float paramFloat)
  {
    float[] arrayOfFloat = this.matrix;
    if (arrayOfFloat.length == 16)
    {
      if (this.colMaj)
      {
        arrayOfFloat[matIndCol16_4x4[14]] = paramFloat;
        return;
      }
      arrayOfFloat[matIndRow16_4x4[14]] = paramFloat;
      return;
    }
    throw new IllegalStateException("length of matrix should be 16");
  }
  
  public void setW3(float paramFloat)
  {
    float[] arrayOfFloat = this.matrix;
    if (arrayOfFloat.length == 16)
    {
      if (this.colMaj)
      {
        arrayOfFloat[matIndCol16_4x4[15]] = paramFloat;
        return;
      }
      arrayOfFloat[matIndRow16_4x4[15]] = paramFloat;
      return;
    }
    throw new IllegalStateException("length of matrix should be 16");
  }
  
  public void setX0(float paramFloat)
  {
    float[] arrayOfFloat = this.matrix;
    if (arrayOfFloat.length == 16)
    {
      if (this.colMaj)
      {
        arrayOfFloat[matIndCol16_3x3[0]] = paramFloat;
        return;
      }
      arrayOfFloat[matIndRow16_3x3[0]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      arrayOfFloat[matIndCol9_3x3[0]] = paramFloat;
      return;
    }
    arrayOfFloat[matIndRow9_3x3[0]] = paramFloat;
  }
  
  public void setX1(float paramFloat)
  {
    float[] arrayOfFloat = this.matrix;
    if (arrayOfFloat.length == 16)
    {
      if (this.colMaj)
      {
        arrayOfFloat[matIndCol16_3x3[1]] = paramFloat;
        return;
      }
      arrayOfFloat[matIndRow16_3x3[1]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      arrayOfFloat[matIndCol9_3x3[1]] = paramFloat;
      return;
    }
    arrayOfFloat[matIndRow9_3x3[1]] = paramFloat;
  }
  
  public void setX2(float paramFloat)
  {
    float[] arrayOfFloat = this.matrix;
    if (arrayOfFloat.length == 16)
    {
      if (this.colMaj)
      {
        arrayOfFloat[matIndCol16_3x3[2]] = paramFloat;
        return;
      }
      arrayOfFloat[matIndRow16_3x3[2]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      arrayOfFloat[matIndCol9_3x3[2]] = paramFloat;
      return;
    }
    arrayOfFloat[matIndRow9_3x3[2]] = paramFloat;
  }
  
  public void setX3(float paramFloat)
  {
    float[] arrayOfFloat = this.matrix;
    if (arrayOfFloat.length == 16)
    {
      if (this.colMaj)
      {
        arrayOfFloat[matIndCol16_4x4[3]] = paramFloat;
        return;
      }
      arrayOfFloat[matIndRow16_4x4[3]] = paramFloat;
      return;
    }
    throw new IllegalStateException("length of matrix should be 16");
  }
  
  public void setY0(float paramFloat)
  {
    float[] arrayOfFloat = this.matrix;
    if (arrayOfFloat.length == 16)
    {
      if (this.colMaj)
      {
        arrayOfFloat[matIndCol16_3x3[3]] = paramFloat;
        return;
      }
      arrayOfFloat[matIndRow16_3x3[3]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      arrayOfFloat[matIndCol9_3x3[3]] = paramFloat;
      return;
    }
    arrayOfFloat[matIndRow9_3x3[3]] = paramFloat;
  }
  
  public void setY1(float paramFloat)
  {
    float[] arrayOfFloat = this.matrix;
    if (arrayOfFloat.length == 16)
    {
      if (this.colMaj)
      {
        arrayOfFloat[matIndCol16_3x3[4]] = paramFloat;
        return;
      }
      arrayOfFloat[matIndRow16_3x3[4]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      arrayOfFloat[matIndCol9_3x3[4]] = paramFloat;
      return;
    }
    arrayOfFloat[matIndRow9_3x3[4]] = paramFloat;
  }
  
  public void setY2(float paramFloat)
  {
    float[] arrayOfFloat = this.matrix;
    if (arrayOfFloat.length == 16)
    {
      if (this.colMaj)
      {
        arrayOfFloat[matIndCol16_3x3[5]] = paramFloat;
        return;
      }
      arrayOfFloat[matIndRow16_3x3[5]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      arrayOfFloat[matIndCol9_3x3[5]] = paramFloat;
      return;
    }
    arrayOfFloat[matIndRow9_3x3[5]] = paramFloat;
  }
  
  public void setY3(float paramFloat)
  {
    float[] arrayOfFloat = this.matrix;
    if (arrayOfFloat.length == 16)
    {
      if (this.colMaj)
      {
        arrayOfFloat[matIndCol16_4x4[7]] = paramFloat;
        return;
      }
      arrayOfFloat[matIndRow16_4x4[7]] = paramFloat;
      return;
    }
    throw new IllegalStateException("length of matrix should be 16");
  }
  
  public void setZ0(float paramFloat)
  {
    float[] arrayOfFloat = this.matrix;
    if (arrayOfFloat.length == 16)
    {
      if (this.colMaj)
      {
        arrayOfFloat[matIndCol16_3x3[6]] = paramFloat;
        return;
      }
      arrayOfFloat[matIndRow16_3x3[6]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      arrayOfFloat[matIndCol9_3x3[6]] = paramFloat;
      return;
    }
    arrayOfFloat[matIndRow9_3x3[6]] = paramFloat;
  }
  
  public void setZ1(float paramFloat)
  {
    float[] arrayOfFloat = this.matrix;
    if (arrayOfFloat.length == 16)
    {
      if (this.colMaj)
      {
        arrayOfFloat[matIndCol16_3x3[7]] = paramFloat;
        return;
      }
      arrayOfFloat[matIndRow16_3x3[7]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      arrayOfFloat[matIndCol9_3x3[7]] = paramFloat;
      return;
    }
    arrayOfFloat[matIndRow9_3x3[7]] = paramFloat;
  }
  
  public void setZ2(float paramFloat)
  {
    float[] arrayOfFloat = this.matrix;
    if (arrayOfFloat.length == 16)
    {
      if (this.colMaj)
      {
        arrayOfFloat[matIndCol16_3x3[8]] = paramFloat;
        return;
      }
      arrayOfFloat[matIndRow16_3x3[8]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      arrayOfFloat[matIndCol9_3x3[8]] = paramFloat;
      return;
    }
    arrayOfFloat[matIndRow9_3x3[8]] = paramFloat;
  }
  
  public void setZ3(float paramFloat)
  {
    float[] arrayOfFloat = this.matrix;
    if (arrayOfFloat.length == 16)
    {
      if (this.colMaj)
      {
        arrayOfFloat[matIndCol16_4x4[11]] = paramFloat;
        return;
      }
      arrayOfFloat[matIndRow16_4x4[11]] = paramFloat;
      return;
    }
    throw new IllegalStateException("length of matrix should be 16");
  }
  
  public int size()
  {
    return this.matrix.length;
  }
  
  public void transpose()
  {
    int k = this.matrix.length;
    int j = 0;
    int i = 0;
    float[] arrayOfFloat2;
    if (k == 16)
    {
      arrayOfFloat1 = new float[16];
      while (i < 4)
      {
        j = i * 4;
        arrayOfFloat2 = this.matrix;
        arrayOfFloat1[j] = arrayOfFloat2[i];
        arrayOfFloat1[(j + 1)] = arrayOfFloat2[(i + 4)];
        arrayOfFloat1[(j + 2)] = arrayOfFloat2[(i + 8)];
        arrayOfFloat1[(j + 3)] = arrayOfFloat2[(i + 12)];
        i += 1;
      }
      this.matrix = arrayOfFloat1;
      return;
    }
    float[] arrayOfFloat1 = new float[9];
    i = j;
    while (i < 3)
    {
      j = i * 3;
      arrayOfFloat2 = this.matrix;
      arrayOfFloat1[j] = arrayOfFloat2[i];
      arrayOfFloat1[(j + 1)] = arrayOfFloat2[(i + 3)];
      arrayOfFloat1[(j + 2)] = arrayOfFloat2[(i + 6)];
      i += 1;
    }
    this.matrix = arrayOfFloat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.ar.sensor.representation.MatrixF4x4
 * JD-Core Version:    0.7.0.1
 */