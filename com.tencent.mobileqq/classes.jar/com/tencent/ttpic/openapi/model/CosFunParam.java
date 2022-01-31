package com.tencent.ttpic.openapi.model;

import android.graphics.PointF;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.view.RendererUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CosFunParam
{
  public int mFaceTexture = -1;
  public int mHeight;
  public List<PointF> mUserFacePointsList;
  public int mWidth;
  public UniformParam modelColor1 = new UniformParam.Float3fParam("modelColor1", 0.0F, 0.0F, 0.0F);
  public UniformParam modelColor2 = new UniformParam.Float3fParam("modelColor2", 0.0F, 0.0F, 0.0F);
  public float[][] userAllColor = (float[][])Array.newInstance(Float.TYPE, new int[] { 3, 256 });
  public UniformParam userColor1 = new UniformParam.Float3fParam("userColor1", 0.0F, 0.0F, 0.0F);
  public UniformParam userColor2 = new UniformParam.Float3fParam("userColor2", 0.0F, 0.0F, 0.0F);
  public float[][] userFaceColor = (float[][])Array.newInstance(Float.TYPE, new int[] { 3, 256 });
  
  private boolean isSkinColor(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= 80) && (paramInt2 <= 80) && (paramInt3 <= 80)) {}
    float f2;
    float f1;
    do
    {
      do
      {
        return false;
      } while (((paramInt1 < 230) && (paramInt2 < 230) && (paramInt3 < 230) && ((paramInt3 >= paramInt2) || (paramInt2 >= paramInt1))) || (paramInt1 + paramInt2 > 400));
      f2 = paramInt1 / 255.0F;
      float f3 = paramInt2 / 255.0F;
      float f4 = paramInt3 / 255.0F;
      f1 = 128.0F - 81.084999F * f2 + 112.0F * f3 - 30.915001F * f4;
      f2 = f2 * 112.0F + 128.0F - f3 * 93.786003F - 18.214001F * f4;
    } while ((f1 < 85.0F) || (f1 > 135.0F) || (f2 < 260.0F - f1) || (f2 > 280.0F - f1));
    return true;
  }
  
  private boolean isSkinColorV2(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= 80) && (paramInt2 <= 80) && (paramInt3 <= 80)) {}
    float f2;
    float f1;
    do
    {
      do
      {
        return false;
      } while ((paramInt1 < 230) && (paramInt2 < 230) && (paramInt3 < 230) && ((paramInt3 >= paramInt2) || (paramInt2 >= paramInt1)));
      f2 = paramInt1 / 255.0F;
      float f3 = paramInt2 / 255.0F;
      float f4 = paramInt3 / 255.0F;
      f1 = 128.0F - 81.084999F * f2 + 112.0F * f3 - 30.915001F * f4;
      f2 = f2 * 112.0F + 128.0F - f3 * 93.786003F - 18.214001F * f4;
    } while ((f1 < 85.0F) || (f1 > 135.0F) || (f2 < 255.0F - f1) || (f2 > 280.0F - f1));
    return true;
  }
  
  private List<Integer> updateColorRange(List<Double> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList.size() < 2) {
      return localArrayList;
    }
    double d1 = ((Double)paramList.get(0)).doubleValue();
    double d2 = ((Double)paramList.get(1)).doubleValue();
    paramList = new int[3];
    int[] arrayOfInt1 = new int[3];
    int[] arrayOfInt2 = new int[3];
    int[] arrayOfInt3 = new int[3];
    int i = 0;
    while (i < 3)
    {
      float f2 = 0.0F;
      float f1 = 0.0F;
      arrayOfInt1[i] = -1;
      paramList[i] = -1;
      arrayOfInt3[i] = -1;
      arrayOfInt2[i] = -1;
      int j = 0;
      while (j < 256)
      {
        f2 += this.userFaceColor[i][j];
        f1 += this.userAllColor[i][j];
        if ((paramList[i] < 0) && (f2 > d1)) {
          paramList[i] = j;
        }
        if ((arrayOfInt1[i] < 0) && (f2 >= d2)) {
          arrayOfInt1[i] = (j - 1);
        }
        if ((arrayOfInt2[i] < 0) && (f1 > d1)) {
          arrayOfInt2[i] = j;
        }
        if ((arrayOfInt3[i] < 0) && (f1 >= d2)) {
          arrayOfInt3[i] = (j - 1);
        }
        j += 1;
      }
      if (paramList[i] >= arrayOfInt1[i]) {
        paramList[i] += 1;
      }
      if (arrayOfInt2[i] >= arrayOfInt3[i]) {
        arrayOfInt2[i] += 1;
      }
      i += 1;
    }
    if (!paramBoolean)
    {
      paramList[2] = -1;
      paramList[1] = -1;
      paramList[0] = -1;
      arrayOfInt1[2] = -1;
      arrayOfInt1[1] = -1;
      arrayOfInt1[0] = -1;
    }
    localArrayList.add(Integer.valueOf(paramList[0]));
    localArrayList.add(Integer.valueOf(paramList[1]));
    localArrayList.add(Integer.valueOf(paramList[2]));
    localArrayList.add(Integer.valueOf(arrayOfInt1[0]));
    localArrayList.add(Integer.valueOf(arrayOfInt1[1]));
    localArrayList.add(Integer.valueOf(arrayOfInt1[2]));
    localArrayList.add(Integer.valueOf(arrayOfInt2[0]));
    localArrayList.add(Integer.valueOf(arrayOfInt2[1]));
    localArrayList.add(Integer.valueOf(arrayOfInt2[2]));
    localArrayList.add(Integer.valueOf(arrayOfInt3[0]));
    localArrayList.add(Integer.valueOf(arrayOfInt3[1]));
    localArrayList.add(Integer.valueOf(arrayOfInt3[2]));
    return localArrayList;
  }
  
  private List<Integer> updateSkinData(Frame paramFrame, List<Double> paramList)
  {
    byte[] arrayOfByte = new byte[paramFrame.width * paramFrame.height * 4];
    RendererUtils.saveTextureToRgbBuffer(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, arrayOfByte, paramFrame.getFBO());
    int[][] arrayOfInt1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { 3, 256 });
    int[][] arrayOfInt2 = (int[][])Array.newInstance(Integer.TYPE, new int[] { 3, 256 });
    int k = paramFrame.width;
    int m = paramFrame.height;
    int i = 0;
    int j = 0;
    if (j < m * k)
    {
      if ((arrayOfByte[(i + 3)] & 0xFF) < 128) {
        i += 4;
      }
      for (;;)
      {
        j += 1;
        break;
        int n = arrayOfByte[i] & 0xFF;
        int i1 = arrayOfByte[(i + 1)] & 0xFF;
        int i2 = arrayOfByte[(i + 2)] & 0xFF;
        i += 4;
        if (isSkinColorV2(n, i1, i2))
        {
          paramFrame = arrayOfInt1[0];
          paramFrame[n] += 1;
          paramFrame = arrayOfInt1[1];
          paramFrame[i1] += 1;
          paramFrame = arrayOfInt1[2];
          paramFrame[i2] += 1;
        }
        paramFrame = arrayOfInt2[0];
        paramFrame[n] += 1;
        paramFrame = arrayOfInt2[1];
        paramFrame[i1] += 1;
        paramFrame = arrayOfInt2[2];
        paramFrame[i2] += 1;
      }
    }
    return updateColorRange(paramList, updateUserSkinColor(arrayOfInt1, arrayOfInt2));
  }
  
  public void calSkinParams(Frame paramFrame, List<Double> paramList)
  {
    float f4 = -1.0F;
    float f5 = -1.0F;
    float f6 = -1.0F;
    float f3 = -1.0F;
    float f2 = -1.0F;
    float f1 = -1.0F;
    if (paramList.size() >= 6)
    {
      f4 = ((Double)paramList.get(0)).floatValue();
      f5 = ((Double)paramList.get(1)).floatValue();
      f6 = ((Double)paramList.get(2)).floatValue();
      f3 = ((Double)paramList.get(3)).floatValue();
      f2 = ((Double)paramList.get(4)).floatValue();
      f1 = ((Double)paramList.get(5)).floatValue();
    }
    int m = paramFrame.width * paramFrame.height;
    paramList = new byte[m * 4];
    RendererUtils.saveTextureToRgbBuffer(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, paramList, paramFrame.getFBO());
    double d3 = 0.0D;
    double d7 = 0.0D;
    double d2 = 0.0D;
    double d5 = 0.0D;
    double d1 = 0.0D;
    double d4 = 0.0D;
    int j = 0;
    int i = 0;
    float f7;
    float f8;
    float f9;
    double d6;
    while (i < m)
    {
      int k = paramList[(i * 4)] & 0xFF;
      int n = paramList[(i * 4 + 1)] & 0xFF;
      int i1 = paramList[(i * 4 + 2)] & 0xFF;
      boolean bool = isSkinColor(k, n, i1);
      f7 = k / 255.0F;
      f8 = n / 255.0F;
      f9 = i1 / 255.0F;
      k = j;
      double d9 = d4;
      double d8 = d5;
      d6 = d7;
      if (bool)
      {
        d6 = d7 + f7;
        d8 = d5 + f8;
        d9 = d4 + f9;
        k = j + 1;
      }
      d3 += f7;
      d2 += f8;
      d4 = f9;
      i += 1;
      d1 = d4 + d1;
      j = k;
      d4 = d9;
      d5 = d8;
      d7 = d6;
    }
    if ((j < m / 100) || ((f3 <= 0.01F) && (f2 <= 0.01F) && (f1 <= 0.01F)))
    {
      d4 = 0.0D;
      d5 = 0.0D;
      d6 = 0.0D;
      d3 /= m;
      d2 /= m;
      d1 /= m;
      f7 = (float)d3;
      f8 = (float)d2;
      f9 = (float)d1;
      if (d6 <= 0.0D) {
        break label623;
      }
      f4 = (float)d6;
      f5 = (float)d5;
      f7 = (float)d4;
      f6 = f3;
      f3 = f5;
      f5 = f2;
      f2 = f7;
    }
    for (;;)
    {
      f9 = f1;
      f8 = f5;
      f7 = f6;
      if (f6 <= 0.0F)
      {
        f9 = f1;
        f8 = f5;
        f7 = f6;
        if (f5 <= 0.0F)
        {
          f9 = f1;
          f8 = f5;
          f7 = f6;
          if (f1 <= 0.0F)
          {
            f9 = f2;
            f8 = f3;
            f7 = f4;
          }
        }
      }
      this.userColor1 = new UniformParam.Float3fParam("userColor1", f4, f3, f2);
      this.modelColor1 = new UniformParam.Float3fParam("modelColor1", f7, f8, f9);
      return;
      d6 = d7 / j;
      d5 /= j;
      d4 /= j;
      break;
      label623:
      f2 = f9;
      f1 = f6;
      f3 = f8;
      f6 = f4;
      f4 = f7;
    }
  }
  
  public void calSkinParams(Frame paramFrame, List<Double> paramList1, List<Double> paramList2)
  {
    paramFrame = updateSkinData(paramFrame, paramList2);
    if (paramFrame.size() < 12) {
      return;
    }
    paramList2 = new float[12];
    float[] arrayOfFloat = new float[12];
    int i = 0;
    while (i < 12)
    {
      paramList2[i] = (((Integer)paramFrame.get(i)).intValue() / 255.0F);
      arrayOfFloat[i] = ((float)(((Double)paramList1.get(i)).doubleValue() / 255.0D));
      i += 1;
    }
    float f;
    int j;
    if ((paramList2[0] < 0.0F) || (paramList2[1] < 0.0F) || (paramList2[2] < 0.0F) || (arrayOfFloat[0] < 0.0F) || (arrayOfFloat[1] < 0.0F) || (arrayOfFloat[2] < 0.0F))
    {
      i = 0;
      while (i < 3)
      {
        f = arrayOfFloat[(i + 9)] - arrayOfFloat[(i + 6)] - (paramList2[(i + 9)] - paramList2[(i + 6)]);
        if (f > 0.0F)
        {
          j = i + 9;
          arrayOfFloat[j] = ((float)(arrayOfFloat[j] - f * 0.5D));
          j = i + 6;
          arrayOfFloat[j] = ((float)(arrayOfFloat[j] + f * 0.5D));
        }
        i += 1;
      }
      this.userColor1 = new UniformParam.Float3fParam("userColor1", paramList2[6], paramList2[7], paramList2[8]);
      this.userColor2 = new UniformParam.Float3fParam("userColor2", paramList2[9], paramList2[10], paramList2[11]);
      this.modelColor1 = new UniformParam.Float3fParam("modelColor1", arrayOfFloat[6], arrayOfFloat[7], arrayOfFloat[8]);
      this.modelColor2 = new UniformParam.Float3fParam("modelColor2", arrayOfFloat[9], arrayOfFloat[10], arrayOfFloat[11]);
      return;
    }
    i = 0;
    while (i < 3)
    {
      f = arrayOfFloat[(i + 3)] - arrayOfFloat[(i + 0)] - (paramList2[(i + 3)] - paramList2[(i + 0)]);
      if (f > 0.0F)
      {
        j = i + 3;
        arrayOfFloat[j] = ((float)(arrayOfFloat[j] - f * 0.5D));
        j = i + 0;
        arrayOfFloat[j] = ((float)(arrayOfFloat[j] + f * 0.5D));
      }
      i += 1;
    }
    this.userColor1 = new UniformParam.Float3fParam("userColor1", paramList2[0], paramList2[1], paramList2[2]);
    this.userColor2 = new UniformParam.Float3fParam("userColor2", paramList2[3], paramList2[4], paramList2[5]);
    this.modelColor1 = new UniformParam.Float3fParam("modelColor1", arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
    this.modelColor2 = new UniformParam.Float3fParam("modelColor2", arrayOfFloat[3], arrayOfFloat[4], arrayOfFloat[5]);
  }
  
  public boolean updateUserSkinColor(int[][] paramArrayOfInt1, int[][] paramArrayOfInt2)
  {
    int k = 0;
    int i = 0;
    int m;
    for (int j = 0; k < 256; j = m + j)
    {
      m = paramArrayOfInt2[0][k];
      int n = paramArrayOfInt1[0][k];
      k += 1;
      i = n + i;
    }
    boolean bool;
    label73:
    float f1;
    label84:
    float f2;
    if (i * 5 > j)
    {
      bool = true;
      if (j <= 0) {
        break label167;
      }
      f1 = 1.0F / j;
      if (i <= 0) {
        break label173;
      }
      f2 = 1.0F / i;
      i = 0;
    }
    for (;;)
    {
      if (i >= 3) {
        break label188;
      }
      j = 0;
      for (;;)
      {
        if (j < 256)
        {
          this.userAllColor[i][j] = (paramArrayOfInt2[i][j] * f1);
          this.userFaceColor[i][j] = (paramArrayOfInt1[i][j] * f2);
          j += 1;
          continue;
          bool = false;
          break;
          label167:
          j = 1;
          break label73;
          label173:
          i = 1;
          break label84;
        }
      }
      i += 1;
    }
    label188:
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.CosFunParam
 * JD-Core Version:    0.7.0.1
 */