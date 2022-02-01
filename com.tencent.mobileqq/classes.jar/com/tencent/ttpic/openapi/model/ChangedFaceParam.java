package com.tencent.ttpic.openapi.model;

import android.graphics.PointF;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.facebeauty.FaceParam;
import com.tencent.view.RendererUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ChangedFaceParam
{
  public FaceParam mFaceParam;
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
  
  private List<Integer> getUserSkinColor(List<Double> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList.size() < 2) {
      return localArrayList;
    }
    double d2 = ((Double)paramList.get(0)).doubleValue();
    double d1 = ((Double)paramList.get(1)).doubleValue();
    paramList = new int[3];
    int[] arrayOfInt1 = new int[3];
    int[] arrayOfInt2 = new int[3];
    int[] arrayOfInt3 = new int[3];
    int i = 0;
    while (i < 3)
    {
      arrayOfInt1[i] = -1;
      paramList[i] = -1;
      arrayOfInt3[i] = -1;
      arrayOfInt2[i] = -1;
      int j = 0;
      float f2 = 0.0F;
      float f1 = 0.0F;
      while (j < 256)
      {
        f2 += this.userFaceColor[i][j];
        f1 += this.userAllColor[i][j];
        if ((paramList[i] < 0) && (f2 > d2)) {
          paramList[i] = j;
        }
        if ((arrayOfInt1[i] < 0) && (f2 >= d1)) {
          arrayOfInt1[i] = (j - 1);
        }
        if ((arrayOfInt2[i] < 0) && (f1 > d2)) {
          arrayOfInt2[i] = j;
        }
        if ((arrayOfInt3[i] < 0) && (f1 >= d1)) {
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
  
  private boolean isSkinColor(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    if ((paramInt1 <= 80) && (paramInt2 <= 80) && (paramInt3 <= 80)) {
      return false;
    }
    if ((paramInt1 < 230) && (paramInt2 < 230) && (paramInt3 < 230) && ((paramInt3 >= paramInt2) || (paramInt2 >= paramInt1))) {
      return false;
    }
    if (paramInt1 + paramInt2 > 400) {
      return false;
    }
    float f2 = paramInt1 / 255.0F;
    float f3 = paramInt2 / 255.0F;
    float f4 = paramInt3 / 255.0F;
    float f1 = 128.0F - 81.084999F * f2 + f3 * 112.0F - 30.915001F * f4;
    f2 = f2 * 112.0F + 128.0F - f3 * 93.786003F - f4 * 18.214001F;
    boolean bool1 = bool2;
    if (f1 >= 85.0F)
    {
      if (f1 > 135.0F) {
        return false;
      }
      bool1 = bool2;
      if (f2 >= 260.0F - f1)
      {
        bool1 = bool2;
        if (f2 <= 280.0F - f1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean isSkinColorV2(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    if ((paramInt1 <= 80) && (paramInt2 <= 80) && (paramInt3 <= 80)) {
      return false;
    }
    if ((paramInt1 < 230) && (paramInt2 < 230) && (paramInt3 < 230) && ((paramInt3 >= paramInt2) || (paramInt2 >= paramInt1))) {
      return false;
    }
    float f2 = paramInt1 / 255.0F;
    float f3 = paramInt2 / 255.0F;
    float f4 = paramInt3 / 255.0F;
    float f1 = 128.0F - 81.084999F * f2 + f3 * 112.0F - 30.915001F * f4;
    f2 = f2 * 112.0F + 128.0F - f3 * 93.786003F - f4 * 18.214001F;
    boolean bool1 = bool2;
    if (f1 >= 85.0F)
    {
      if (f1 > 135.0F) {
        return false;
      }
      bool1 = bool2;
      if (f2 >= 255.0F - f1)
      {
        bool1 = bool2;
        if (f2 <= 280.0F - f1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private List<Integer> updateSkinData(Frame paramFrame, List<Double> paramList)
  {
    byte[] arrayOfByte = new byte[paramFrame.width * paramFrame.height * 4];
    RendererUtils.saveTextureToRgbBuffer(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, arrayOfByte, paramFrame.getFBO());
    paramFrame = (int[][])Array.newInstance(Integer.TYPE, new int[] { 3, 256 });
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 3, 256 });
    int i = 0;
    int j = 0;
    while (i < 40000)
    {
      int k = arrayOfByte[(j + 3)];
      int m = arrayOfByte[j] & 0xFF;
      int n = arrayOfByte[(j + 1)] & 0xFF;
      int i1 = arrayOfByte[(j + 2)] & 0xFF;
      j += 4;
      if ((k & 0xFF) >= 128)
      {
        if (isSkinColorV2(m, n, i1))
        {
          arrayOfInt1 = paramFrame[0];
          arrayOfInt1[m] += 1;
          arrayOfInt1 = paramFrame[1];
          arrayOfInt1[n] += 1;
          arrayOfInt1 = paramFrame[2];
          arrayOfInt1[i1] += 1;
        }
        int[] arrayOfInt1 = arrayOfInt[0];
        arrayOfInt1[m] += 1;
        arrayOfInt1 = arrayOfInt[1];
        arrayOfInt1[n] += 1;
        arrayOfInt1 = arrayOfInt[2];
        arrayOfInt1[i1] += 1;
      }
      i += 1;
    }
    return getUserSkinColor(paramList, updateUserSkinColor(paramFrame, arrayOfInt));
  }
  
  public void calSkinParams(Frame paramFrame, List<Double> paramList)
  {
    int j = paramList.size();
    int i = 0;
    float f3 = -1.0F;
    float f2;
    float f6;
    float f5;
    float f1;
    if (j >= 6)
    {
      f2 = ((Double)paramList.get(0)).floatValue();
      f6 = ((Double)paramList.get(1)).floatValue();
      f5 = ((Double)paramList.get(2)).floatValue();
      f3 = ((Double)paramList.get(3)).floatValue();
      f1 = ((Double)paramList.get(4)).floatValue();
      f4 = ((Double)paramList.get(5)).floatValue();
    }
    else
    {
      f4 = -1.0F;
      f2 = -1.0F;
      f6 = -1.0F;
      f5 = -1.0F;
      f1 = -1.0F;
    }
    int k = paramFrame.width * paramFrame.height;
    paramList = new byte[k * 4];
    RendererUtils.saveTextureToRgbBuffer(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, paramList, paramFrame.getFBO());
    j = 0;
    double d7 = 0.0D;
    double d5 = 0.0D;
    double d4 = 0.0D;
    double d3 = 0.0D;
    double d2 = 0.0D;
    double d1 = 0.0D;
    double d6;
    while (i < k)
    {
      int i1 = i * 4;
      int m = paramList[i1] & 0xFF;
      int n = paramList[(i1 + 1)] & 0xFF;
      i1 = paramList[(i1 + 2)] & 0xFF;
      boolean bool = isSkinColor(m, n, i1);
      f7 = m / 255.0F;
      f8 = n / 255.0F;
      f9 = i1 / 255.0F;
      if (bool)
      {
        d6 = f7;
        Double.isNaN(d6);
        d6 = d7 + d6;
        d7 = f8;
        Double.isNaN(d7);
        d5 += d7;
        d7 = f9;
        Double.isNaN(d7);
        d7 = d4 + d7;
        j += 1;
        d4 = d6;
        d6 = d7;
      }
      else
      {
        d6 = d4;
        d4 = d7;
      }
      d7 = f7;
      Double.isNaN(d7);
      d3 += d7;
      d7 = f8;
      Double.isNaN(d7);
      d2 += d7;
      d7 = f9;
      Double.isNaN(d7);
      d1 += d7;
      i += 1;
      d7 = d4;
      d4 = d6;
    }
    if ((j >= k / 100) && ((f3 > 0.01F) || (f1 > 0.01F) || (f4 > 0.01F)))
    {
      double d8 = j;
      Double.isNaN(d8);
      d6 = d7 / d8;
      Double.isNaN(d8);
      d5 /= d8;
      Double.isNaN(d8);
      d4 /= d8;
    }
    else
    {
      d4 = 0.0D;
      d5 = 0.0D;
      d6 = 0.0D;
    }
    d7 = k;
    Double.isNaN(d7);
    d3 /= d7;
    Double.isNaN(d7);
    float f7 = f4;
    d2 /= d7;
    Double.isNaN(d7);
    d1 /= d7;
    float f4 = (float)d3;
    float f8 = (float)d2;
    float f9 = (float)d1;
    if (d6 > 0.0D)
    {
      f6 = (float)d6;
      f2 = (float)d5;
      f5 = (float)d4;
      f4 = f3;
      f3 = f5;
      f5 = f1;
      f1 = f6;
      f6 = f7;
    }
    else
    {
      f3 = f6;
      f6 = f5;
      f1 = f4;
      f5 = f3;
      f4 = f2;
      f3 = f9;
      f2 = f8;
    }
    if ((f4 <= 0.0F) && (f5 <= 0.0F) && (f6 <= 0.0F))
    {
      f4 = f2;
      f6 = f3;
      f5 = f1;
      f7 = f4;
    }
    else
    {
      f7 = f5;
      f5 = f4;
    }
    this.userColor1 = new UniformParam.Float3fParam("userColor1", f1, f2, f3);
    this.modelColor1 = new UniformParam.Float3fParam("modelColor1", f5, f7, f6);
  }
  
  public void calSkinParams(Frame paramFrame, List<Double> paramList1, List<Double> paramList2)
  {
    List localList = updateSkinData(paramFrame, paramList2);
    if (localList.size() < 12) {
      return;
    }
    paramFrame = new float[12];
    paramList2 = new float[12];
    int j = 0;
    int i = 0;
    while (i < 12)
    {
      paramFrame[i] = (((Integer)localList.get(i)).intValue() / 255.0F);
      paramList2[i] = ((float)(((Double)paramList1.get(i)).doubleValue() / 255.0D));
      i += 1;
    }
    float f;
    int k;
    double d1;
    double d2;
    if ((paramFrame[0] >= 0.0F) && (paramFrame[1] >= 0.0F) && (paramFrame[2] >= 0.0F) && (paramList2[0] >= 0.0F) && (paramList2[1] >= 0.0F) && (paramList2[2] >= 0.0F))
    {
      i = 0;
      while (i < 3)
      {
        j = i + 3;
        f = paramList2[j];
        k = i + 0;
        f = f - paramList2[k] - (paramFrame[j] - paramFrame[k]);
        if (f > 0.0F)
        {
          d1 = paramList2[j];
          d2 = f;
          Double.isNaN(d2);
          d2 *= 0.5D;
          Double.isNaN(d1);
          paramList2[j] = ((float)(d1 - d2));
          d1 = paramList2[k];
          Double.isNaN(d1);
          paramList2[k] = ((float)(d1 + d2));
        }
        i += 1;
      }
      this.userColor1 = new UniformParam.Float3fParam("userColor1", paramFrame[0], paramFrame[1], paramFrame[2]);
      this.userColor2 = new UniformParam.Float3fParam("userColor2", paramFrame[3], paramFrame[4], paramFrame[5]);
      this.modelColor1 = new UniformParam.Float3fParam("modelColor1", paramList2[0], paramList2[1], paramList2[2]);
      this.modelColor2 = new UniformParam.Float3fParam("modelColor2", paramList2[3], paramList2[4], paramList2[5]);
      return;
    }
    i = j;
    while (i < 3)
    {
      j = i + 9;
      f = paramList2[j];
      k = i + 6;
      f = f - paramList2[k] - (paramFrame[j] - paramFrame[k]);
      if (f > 0.0F)
      {
        d1 = paramList2[j];
        d2 = f;
        Double.isNaN(d2);
        d2 *= 0.5D;
        Double.isNaN(d1);
        paramList2[j] = ((float)(d1 - d2));
        d1 = paramList2[k];
        Double.isNaN(d1);
        paramList2[k] = ((float)(d1 + d2));
      }
      i += 1;
    }
    this.userColor1 = new UniformParam.Float3fParam("userColor1", paramFrame[6], paramFrame[7], paramFrame[8]);
    this.userColor2 = new UniformParam.Float3fParam("userColor2", paramFrame[9], paramFrame[10], paramFrame[11]);
    this.modelColor1 = new UniformParam.Float3fParam("modelColor1", paramList2[6], paramList2[7], paramList2[8]);
    this.modelColor2 = new UniformParam.Float3fParam("modelColor2", paramList2[9], paramList2[10], paramList2[11]);
  }
  
  public boolean updateUserSkinColor(int[][] paramArrayOfInt1, int[][] paramArrayOfInt2)
  {
    int k = 0;
    int i = 0;
    int j = 0;
    while (k < 256)
    {
      j += paramArrayOfInt2[0][k];
      i += paramArrayOfInt1[0][k];
      k += 1;
    }
    boolean bool;
    if (i * 5 > j) {
      bool = true;
    } else {
      bool = false;
    }
    if (j <= 0) {
      j = 1;
    }
    float f1 = 1.0F / j;
    if (i <= 0) {
      i = 1;
    }
    float f2 = 1.0F / i;
    i = 0;
    while (i < 3)
    {
      j = 0;
      while (j < 256)
      {
        this.userAllColor[i][j] = (paramArrayOfInt2[i][j] * f1);
        this.userFaceColor[i][j] = (paramArrayOfInt1[i][j] * f2);
        j += 1;
      }
      i += 1;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.ChangedFaceParam
 * JD-Core Version:    0.7.0.1
 */