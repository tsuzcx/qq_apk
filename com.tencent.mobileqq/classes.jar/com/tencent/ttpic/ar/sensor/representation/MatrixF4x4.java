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
        int k = i * 4;
        int m = paramInt2 + 0 + j;
        paramArrayOfFloat2[m] += this.matrix[(k + j)] * paramArrayOfFloat1[(paramInt1 + 0 + i)];
        m = paramInt2 + 4 + j;
        paramArrayOfFloat2[m] += this.matrix[(k + j)] * paramArrayOfFloat1[(paramInt1 + 4 + i)];
        m = paramInt2 + 8 + j;
        paramArrayOfFloat2[m] += this.matrix[(k + j)] * paramArrayOfFloat1[(paramInt1 + 8 + i)];
        m = paramInt2 + 12 + j;
        float f = paramArrayOfFloat2[m];
        paramArrayOfFloat2[m] = (this.matrix[(k + j)] * paramArrayOfFloat1[(paramInt1 + 12 + i)] + f);
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
    float f4 = 0.0F;
    float f2 = 0.0F;
    if (this.matrix.length == 9)
    {
      float[] arrayOfFloat = paramVector3f.toArray();
      float f5;
      float f6;
      float f7;
      float f8;
      float f9;
      if (!this.colMaj)
      {
        i = 0;
        f1 = 0.0F;
        f3 = 0.0F;
        for (;;)
        {
          f4 = f3;
          f5 = f2;
          f6 = f1;
          if (i >= 3) {
            break;
          }
          int j = i * 3;
          f4 = this.matrix[(j + 0)];
          f5 = arrayOfFloat[i];
          f6 = this.matrix[(j + 1)];
          f7 = arrayOfFloat[i];
          f8 = this.matrix[(j + 2)];
          f9 = arrayOfFloat[i];
          i += 1;
          f3 = f8 * f9 + f3;
          f2 = f6 * f7 + f2;
          f1 = f4 * f5 + f1;
        }
      }
      int i = 0;
      float f1 = 0.0F;
      float f3 = 0.0F;
      f2 = f4;
      for (;;)
      {
        f4 = f3;
        f5 = f2;
        f6 = f1;
        if (i >= 3) {
          break;
        }
        f4 = this.matrix[(i + 0)];
        f5 = arrayOfFloat[i];
        f6 = this.matrix[(i + 3)];
        f7 = arrayOfFloat[i];
        f8 = this.matrix[(i + 6)];
        f9 = arrayOfFloat[i];
        i += 1;
        f3 = f8 * f9 + f3;
        f2 = f6 * f7 + f2;
        f1 = f4 * f5 + f1;
      }
      paramVector3f.setX(f6);
      paramVector3f.setY(f5);
      paramVector3f.setZ(f4);
      return;
    }
    LogUtils.e("matrix", "Matrix is invalid, is " + this.matrix.length + " long, this function expects the internal matrix to be of size 9");
  }
  
  public void multiplyVector4fByMatrix(Vector4f paramVector4f)
  {
    float f5 = 0.0F;
    float f3 = 0.0F;
    if (this.matrix.length == 16)
    {
      float[] arrayOfFloat = paramVector4f.array();
      float f6;
      float f7;
      float f8;
      float f9;
      float f10;
      float f11;
      float f12;
      if (this.colMaj)
      {
        i = 0;
        f2 = 0.0F;
        f1 = 0.0F;
        f4 = 0.0F;
        for (;;)
        {
          f5 = f4;
          f6 = f3;
          f7 = f2;
          f8 = f1;
          if (i >= 4) {
            break;
          }
          int j = i * 4;
          f5 = this.matrix[(j + 0)];
          f6 = arrayOfFloat[i];
          f7 = this.matrix[(j + 1)];
          f8 = arrayOfFloat[i];
          f9 = this.matrix[(j + 2)];
          f10 = arrayOfFloat[i];
          f11 = this.matrix[(j + 3)];
          f12 = arrayOfFloat[i];
          i += 1;
          f4 = f11 * f12 + f4;
          f3 = f9 * f10 + f3;
          f2 = f7 * f8 + f2;
          f1 = f5 * f6 + f1;
        }
      }
      int i = 0;
      float f2 = 0.0F;
      float f1 = 0.0F;
      float f4 = 0.0F;
      f3 = f5;
      for (;;)
      {
        f5 = f4;
        f6 = f3;
        f7 = f2;
        f8 = f1;
        if (i >= 4) {
          break;
        }
        f5 = this.matrix[(i + 0)];
        f6 = arrayOfFloat[i];
        f7 = this.matrix[(i + 4)];
        f8 = arrayOfFloat[i];
        f9 = this.matrix[(i + 8)];
        f10 = arrayOfFloat[i];
        f11 = this.matrix[(i + 12)];
        f12 = arrayOfFloat[i];
        i += 1;
        f4 = f11 * f12 + f4;
        f3 = f9 * f10 + f3;
        f2 = f7 * f8 + f2;
        f1 = f5 * f6 + f1;
      }
      paramVector4f.setX(f8);
      paramVector4f.setY(f7);
      paramVector4f.setZ(f6);
      paramVector4f.setW(f5);
      return;
    }
    LogUtils.e("matrix", "Matrix is invalid, is " + this.matrix.length + " long, this equation expects a 16 value matrix");
  }
  
  public void set(MatrixF4x4 paramMatrixF4x4)
  {
    System.arraycopy(paramMatrixF4x4.matrix, 0, this.matrix, 0, this.matrix.length);
  }
  
  public void setColumnMajor(boolean paramBoolean)
  {
    this.colMaj = paramBoolean;
  }
  
  public void setMatrix(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat.length == 16) || (paramArrayOfFloat.length == 9))
    {
      this.matrix = paramArrayOfFloat;
      return;
    }
    throw new IllegalArgumentException("Matrix set is invalid, size is " + paramArrayOfFloat.length + " expected 9 or 16");
  }
  
  public void setW0(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_4x4[12]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_4x4[12]] = paramFloat;
      return;
    }
    throw new IllegalStateException("length of matrix should be 16");
  }
  
  public void setW1(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_4x4[13]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_4x4[13]] = paramFloat;
      return;
    }
    throw new IllegalStateException("length of matrix should be 16");
  }
  
  public void setW2(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_4x4[14]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_4x4[14]] = paramFloat;
      return;
    }
    throw new IllegalStateException("length of matrix should be 16");
  }
  
  public void setW3(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_4x4[15]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_4x4[15]] = paramFloat;
      return;
    }
    throw new IllegalStateException("length of matrix should be 16");
  }
  
  public void setX0(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_3x3[0]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_3x3[0]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      this.matrix[matIndCol9_3x3[0]] = paramFloat;
      return;
    }
    this.matrix[matIndRow9_3x3[0]] = paramFloat;
  }
  
  public void setX1(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_3x3[1]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_3x3[1]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      this.matrix[matIndCol9_3x3[1]] = paramFloat;
      return;
    }
    this.matrix[matIndRow9_3x3[1]] = paramFloat;
  }
  
  public void setX2(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_3x3[2]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_3x3[2]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      this.matrix[matIndCol9_3x3[2]] = paramFloat;
      return;
    }
    this.matrix[matIndRow9_3x3[2]] = paramFloat;
  }
  
  public void setX3(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_4x4[3]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_4x4[3]] = paramFloat;
      return;
    }
    throw new IllegalStateException("length of matrix should be 16");
  }
  
  public void setY0(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_3x3[3]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_3x3[3]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      this.matrix[matIndCol9_3x3[3]] = paramFloat;
      return;
    }
    this.matrix[matIndRow9_3x3[3]] = paramFloat;
  }
  
  public void setY1(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_3x3[4]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_3x3[4]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      this.matrix[matIndCol9_3x3[4]] = paramFloat;
      return;
    }
    this.matrix[matIndRow9_3x3[4]] = paramFloat;
  }
  
  public void setY2(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_3x3[5]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_3x3[5]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      this.matrix[matIndCol9_3x3[5]] = paramFloat;
      return;
    }
    this.matrix[matIndRow9_3x3[5]] = paramFloat;
  }
  
  public void setY3(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_4x4[7]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_4x4[7]] = paramFloat;
      return;
    }
    throw new IllegalStateException("length of matrix should be 16");
  }
  
  public void setZ0(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_3x3[6]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_3x3[6]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      this.matrix[matIndCol9_3x3[6]] = paramFloat;
      return;
    }
    this.matrix[matIndRow9_3x3[6]] = paramFloat;
  }
  
  public void setZ1(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_3x3[7]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_3x3[7]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      this.matrix[matIndCol9_3x3[7]] = paramFloat;
      return;
    }
    this.matrix[matIndRow9_3x3[7]] = paramFloat;
  }
  
  public void setZ2(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_3x3[8]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_3x3[8]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      this.matrix[matIndCol9_3x3[8]] = paramFloat;
      return;
    }
    this.matrix[matIndRow9_3x3[8]] = paramFloat;
  }
  
  public void setZ3(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_4x4[11]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_4x4[11]] = paramFloat;
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
    int j = 0;
    int i = 0;
    if (this.matrix.length == 16)
    {
      arrayOfFloat = new float[16];
      while (i < 4)
      {
        j = i * 4;
        arrayOfFloat[j] = this.matrix[i];
        arrayOfFloat[(j + 1)] = this.matrix[(i + 4)];
        arrayOfFloat[(j + 2)] = this.matrix[(i + 8)];
        arrayOfFloat[(j + 3)] = this.matrix[(i + 12)];
        i += 1;
      }
      this.matrix = arrayOfFloat;
      return;
    }
    float[] arrayOfFloat = new float[9];
    i = j;
    while (i < 3)
    {
      j = i * 3;
      arrayOfFloat[j] = this.matrix[i];
      arrayOfFloat[(j + 1)] = this.matrix[(i + 3)];
      arrayOfFloat[(j + 2)] = this.matrix[(i + 6)];
      i += 1;
    }
    this.matrix = arrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.ar.sensor.representation.MatrixF4x4
 * JD-Core Version:    0.7.0.1
 */