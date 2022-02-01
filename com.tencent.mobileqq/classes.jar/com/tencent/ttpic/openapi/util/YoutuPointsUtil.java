package com.tencent.ttpic.openapi.util;

import android.graphics.PointF;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YoutuPointsUtil
{
  private static final int LEN_83 = 166;
  private static final int LEN_90 = 180;
  
  private static void adjustEyeFeatureFloat(float[] paramArrayOfFloat)
  {
    double d1 = paramArrayOfFloat[38];
    double d2 = paramArrayOfFloat[40] - paramArrayOfFloat[38];
    Double.isNaN(d2);
    Double.isNaN(d1);
    paramArrayOfFloat[40] = ((float)(d1 + d2 * 0.98D));
    d1 = paramArrayOfFloat[37];
    d2 = paramArrayOfFloat[41] - paramArrayOfFloat[37];
    Double.isNaN(d2);
    Double.isNaN(d1);
    paramArrayOfFloat[41] = ((float)(d1 + d2 * 0.95D));
    d1 = paramArrayOfFloat[36];
    d2 = paramArrayOfFloat[42] - paramArrayOfFloat[36];
    Double.isNaN(d2);
    Double.isNaN(d1);
    paramArrayOfFloat[42] = ((float)(d1 + d2 * 0.9D));
    d1 = paramArrayOfFloat[48];
    d2 = paramArrayOfFloat[50] - paramArrayOfFloat[48];
    Double.isNaN(d2);
    Double.isNaN(d1);
    paramArrayOfFloat[50] = ((float)(d1 + d2 * 0.98D));
    d1 = paramArrayOfFloat[47];
    d2 = paramArrayOfFloat[51] - paramArrayOfFloat[47];
    Double.isNaN(d2);
    Double.isNaN(d1);
    paramArrayOfFloat[51] = ((float)(d1 + d2 * 0.95D));
    d1 = paramArrayOfFloat[46];
    d2 = paramArrayOfFloat[52] - paramArrayOfFloat[46];
    Double.isNaN(d2);
    Double.isNaN(d1);
    paramArrayOfFloat[52] = ((float)(d1 + d2 * 0.9D));
    d1 = paramArrayOfFloat[35];
    d2 = paramArrayOfFloat[39] - paramArrayOfFloat[35];
    Double.isNaN(d2);
    d2 /= 40.0D;
    Double.isNaN(d1);
    paramArrayOfFloat[35] = ((float)(d1 + d2));
  }
  
  private static void adjustEyeFeatureV2(PointF[] paramArrayOfPointF)
  {
    PointF localPointF = paramArrayOfPointF[40];
    double d1 = paramArrayOfPointF[38].x;
    double d2 = paramArrayOfPointF[40].x - paramArrayOfPointF[38].x;
    Double.isNaN(d2);
    Double.isNaN(d1);
    localPointF.x = ((float)(d1 + d2 * 0.98D));
    localPointF = paramArrayOfPointF[40];
    d1 = paramArrayOfPointF[38].y;
    d2 = paramArrayOfPointF[40].y - paramArrayOfPointF[38].y;
    Double.isNaN(d2);
    Double.isNaN(d1);
    localPointF.y = ((float)(d1 + d2 * 0.98D));
    localPointF = paramArrayOfPointF[41];
    d1 = paramArrayOfPointF[37].x;
    d2 = paramArrayOfPointF[41].x - paramArrayOfPointF[37].x;
    Double.isNaN(d2);
    Double.isNaN(d1);
    localPointF.x = ((float)(d1 + d2 * 0.95D));
    localPointF = paramArrayOfPointF[41];
    d1 = paramArrayOfPointF[37].y;
    d2 = paramArrayOfPointF[41].y - paramArrayOfPointF[37].y;
    Double.isNaN(d2);
    Double.isNaN(d1);
    localPointF.y = ((float)(d1 + d2 * 0.95D));
    localPointF = paramArrayOfPointF[42];
    d1 = paramArrayOfPointF[36].x;
    d2 = paramArrayOfPointF[42].x - paramArrayOfPointF[36].x;
    Double.isNaN(d2);
    Double.isNaN(d1);
    localPointF.x = ((float)(d1 + d2 * 0.9D));
    localPointF = paramArrayOfPointF[42];
    d1 = paramArrayOfPointF[36].y;
    d2 = paramArrayOfPointF[42].y - paramArrayOfPointF[36].y;
    Double.isNaN(d2);
    Double.isNaN(d1);
    localPointF.y = ((float)(d1 + d2 * 0.9D));
    localPointF = paramArrayOfPointF[50];
    d1 = paramArrayOfPointF[48].x;
    d2 = paramArrayOfPointF[50].x - paramArrayOfPointF[48].x;
    Double.isNaN(d2);
    Double.isNaN(d1);
    localPointF.x = ((float)(d1 + d2 * 0.98D));
    localPointF = paramArrayOfPointF[50];
    d1 = paramArrayOfPointF[48].y;
    d2 = paramArrayOfPointF[50].y - paramArrayOfPointF[48].y;
    Double.isNaN(d2);
    Double.isNaN(d1);
    localPointF.y = ((float)(d1 + d2 * 0.98D));
    localPointF = paramArrayOfPointF[51];
    d1 = paramArrayOfPointF[47].x;
    d2 = paramArrayOfPointF[51].x - paramArrayOfPointF[47].x;
    Double.isNaN(d2);
    Double.isNaN(d1);
    localPointF.x = ((float)(d1 + d2 * 0.95D));
    localPointF = paramArrayOfPointF[51];
    d1 = paramArrayOfPointF[47].y;
    d2 = paramArrayOfPointF[51].y - paramArrayOfPointF[47].y;
    Double.isNaN(d2);
    Double.isNaN(d1);
    localPointF.y = ((float)(d1 + d2 * 0.95D));
    localPointF = paramArrayOfPointF[52];
    d1 = paramArrayOfPointF[46].x;
    d2 = paramArrayOfPointF[52].x - paramArrayOfPointF[46].x;
    Double.isNaN(d2);
    Double.isNaN(d1);
    localPointF.x = ((float)(d1 + d2 * 0.9D));
    localPointF = paramArrayOfPointF[52];
    d1 = paramArrayOfPointF[46].y;
    d2 = paramArrayOfPointF[52].y - paramArrayOfPointF[46].y;
    Double.isNaN(d2);
    Double.isNaN(d1);
    localPointF.y = ((float)(d1 + d2 * 0.9D));
    localPointF = paramArrayOfPointF[35];
    d1 = localPointF.y;
    d2 = paramArrayOfPointF[39].x - paramArrayOfPointF[35].x;
    Double.isNaN(d2);
    d2 /= 40.0D;
    Double.isNaN(d1);
    localPointF.y = ((float)(d1 + d2));
    localPointF = paramArrayOfPointF[45];
    d1 = localPointF.y;
    d2 = paramArrayOfPointF[45].x - paramArrayOfPointF[49].x;
    Double.isNaN(d2);
    d2 /= 40.0D;
    Double.isNaN(d1);
    localPointF.y = ((float)(d1 + d2));
  }
  
  public static float[] calEyeEulerAngles(List<PointF> paramList)
  {
    new PointF();
    new PointF();
    PointF localPointF2 = new PointF(((PointF)paramList.get(54)).x, ((PointF)paramList.get(54)).y);
    PointF localPointF1 = new PointF(localPointF2.x - ((PointF)paramList.get(49)).x, localPointF2.y - ((PointF)paramList.get(49)).y);
    localPointF2 = new PointF(localPointF2.x - ((PointF)paramList.get(45)).x, localPointF2.y - ((PointF)paramList.get(45)).y);
    float f1 = (float)Math.sqrt(Math.pow(localPointF1.x, 2.0D) + Math.pow(localPointF1.y, 2.0D));
    float f2 = ((float)Math.sqrt(Math.pow(localPointF2.x, 2.0D) + Math.pow(localPointF2.y, 2.0D)) + f1) * 0.5F;
    double d1 = 1.570796F;
    Double.isNaN(d1);
    d1 /= 3.0D;
    double d2 = (f1 - f2) / f2;
    Double.isNaN(d2);
    f2 = (float)(d1 * d2);
    localPointF2 = new PointF(((PointF)paramList.get(45)).x - ((PointF)paramList.get(49)).x, ((PointF)paramList.get(45)).y - ((PointF)paramList.get(49)).y);
    f1 = (float)((Math.atan2(localPointF1.x, localPointF1.y) - Math.atan2(localPointF2.x, localPointF2.y)) * 180.0D / 3.141592653589793D);
    d1 = f1;
    if (d1 > 180.0D) {
      Double.isNaN(d1);
    }
    for (d1 -= 360.0D;; d1 += 360.0D)
    {
      f1 = (float)d1;
      break;
      if (d1 >= -180.0D) {
        break;
      }
      Double.isNaN(d1);
    }
    localPointF1 = new PointF(-1.570796F * f1 / 270.0F, f2);
    PointF localPointF3 = new PointF(((PointF)paramList.get(44)).x, ((PointF)paramList.get(44)).y);
    localPointF2 = new PointF(localPointF3.x - ((PointF)paramList.get(39)).x, localPointF3.y - ((PointF)paramList.get(39)).y);
    localPointF3 = new PointF(localPointF3.x - ((PointF)paramList.get(35)).x, localPointF3.y - ((PointF)paramList.get(35)).y);
    f1 = (float)Math.sqrt(Math.pow(localPointF2.x, 2.0D) + Math.pow(localPointF2.y, 2.0D));
    f2 = ((float)Math.sqrt(Math.pow(localPointF3.x, 2.0D) + Math.pow(localPointF3.y, 2.0D)) + f1) * 0.5F;
    f2 = (f1 - f2) / f2;
    paramList = new PointF(((PointF)paramList.get(35)).x - ((PointF)paramList.get(39)).x, ((PointF)paramList.get(35)).y - ((PointF)paramList.get(39)).y);
    f1 = (float)((Math.atan2(localPointF2.x, localPointF2.y) - Math.atan2(paramList.x, paramList.y)) * 180.0D / 3.141592653589793D);
    d1 = f1;
    if (d1 > 180.0D) {
      Double.isNaN(d1);
    }
    for (d1 -= 360.0D;; d1 += 360.0D)
    {
      f1 = (float)d1;
      break;
      if (d1 >= -180.0D) {
        break;
      }
      Double.isNaN(d1);
    }
    paramList = new PointF(1.570796F * f1 / 270.0F, -0.5235988F * f2);
    paramList = new PointF((localPointF1.x + paramList.x) * 0.5F, (localPointF1.y + paramList.y) * 0.5F);
    return new float[] { paramList.x, paramList.y, 0.0F };
  }
  
  private static void calculatePoints(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 *= 2;
    paramArrayOfFloat1[paramInt1] = (getFacePointX(paramArrayOfFloat2, paramInt2) + (getFacePointX(paramArrayOfFloat2, paramInt3) - getFacePointX(paramArrayOfFloat2, paramInt2)) / 2.0F);
    paramArrayOfFloat1[(paramInt1 + 1)] = (getFacePointY(paramArrayOfFloat2, paramInt2) + (getFacePointY(paramArrayOfFloat2, paramInt3) - getFacePointY(paramArrayOfFloat2, paramInt2)) / 2.0F);
  }
  
  private static float getArrayMiddleFloat(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    Float localFloat = Float.valueOf(0.0F);
    int i = paramInt1;
    while (i <= paramInt2)
    {
      localFloat = Float.valueOf(localFloat.floatValue() + paramArrayOfFloat[i]);
      i += 1;
    }
    return Float.valueOf(localFloat.floatValue() / (paramInt2 - paramInt1 + 1)).floatValue();
  }
  
  private static PointF getArrayMiddleV2(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    PointF localPointF = new PointF();
    int i = paramInt1;
    while (i <= paramInt2)
    {
      f1 = localPointF.x;
      int j = i * 2;
      localPointF.x = (f1 + paramArrayOfFloat[j]);
      localPointF.y += paramArrayOfFloat[(j + 1)];
      i += 1;
    }
    float f1 = localPointF.x;
    float f2 = paramInt2 - paramInt1 + 1;
    localPointF.x = (f1 / f2);
    localPointF.y /= f2;
    return localPointF;
  }
  
  private static float getFacePointX(float[] paramArrayOfFloat, int paramInt)
  {
    if (paramArrayOfFloat != null)
    {
      int i = paramArrayOfFloat.length;
      paramInt *= 2;
      if (i > paramInt) {
        return paramArrayOfFloat[paramInt];
      }
    }
    return 0.0F;
  }
  
  public static float getFacePointY(float[] paramArrayOfFloat, int paramInt)
  {
    if (paramArrayOfFloat != null)
    {
      int i = paramArrayOfFloat.length;
      paramInt = paramInt * 2 + 1;
      if (i > paramInt) {
        return paramArrayOfFloat[paramInt];
      }
    }
    return 0.0F;
  }
  
  public static List<PointF> getIris3Points(List<List<PointF>> paramList1, List<List<PointF>> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    if (!CollectionUtils.isEmpty(paramList1))
    {
      if (CollectionUtils.isEmpty(paramList2)) {
        return localArrayList;
      }
      paramList1 = (List)paramList1.get(0);
      paramList2 = (List)paramList2.get(0);
      localArrayList.add(paramList1.get(43));
      localArrayList.add(paramList1.get(53));
    }
    return localArrayList;
  }
  
  public static List<PointF> getIris4Points(List<List<PointF>> paramList1, List<List<PointF>> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    if (!CollectionUtils.isEmpty(paramList1))
    {
      if (CollectionUtils.isEmpty(paramList2)) {
        return localArrayList;
      }
      paramList1 = (List)paramList1.get(0);
      paramList2 = (List)paramList2.get(0);
      localArrayList.add(paramList1.get(44));
      localArrayList.add(paramList1.get(54));
    }
    return localArrayList;
  }
  
  public static List<PointF> getIrisPoints(float[] paramArrayOfFloat)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfFloat.length != 188) {
      return localArrayList;
    }
    int i = 90;
    while (i < 94)
    {
      int j = i * 2;
      localArrayList.add(new PointF(paramArrayOfFloat[j], paramArrayOfFloat[(j + 1)]));
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<PointF> getIrisRelatedPoints(List<List<PointF>> paramList1, List<List<PointF>> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    if (!CollectionUtils.isEmpty(paramList1))
    {
      if (CollectionUtils.isEmpty(paramList2)) {
        return localArrayList;
      }
      paramList1 = (List)paramList1.get(0);
      paramList2 = (List)paramList2.get(0);
      localArrayList.add(paramList1.get(44));
      localArrayList.add(paramList1.get(41));
      localArrayList.add(paramList2.get(0));
      localArrayList.add(paramList1.get(37));
      localArrayList.add(paramList2.get(1));
      localArrayList.add(paramList1.get(54));
      localArrayList.add(paramList1.get(51));
      localArrayList.add(paramList2.get(2));
      localArrayList.add(paramList1.get(47));
      localArrayList.add(paramList2.get(3));
    }
    return localArrayList;
  }
  
  private static float getMiddleFloat(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    return paramArrayOfFloat[paramInt1] / 2.0F + paramArrayOfFloat[paramInt2] / 2.0F;
  }
  
  private static PointF getMiddleV2(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    paramInt1 *= 2;
    float f = paramArrayOfFloat[paramInt1];
    paramInt2 *= 2;
    return new PointF((f + paramArrayOfFloat[paramInt2]) / 2.0F, (paramArrayOfFloat[(paramInt1 + 1)] + paramArrayOfFloat[(paramInt2 + 1)]) / 2.0F);
  }
  
  public static void normalizePoints(List<PointF> paramList)
  {
    float f1 = AlgoUtils.getDistance((PointF)paramList.get(99), (PointF)paramList.get(105));
    float f2 = AlgoUtils.getDistance((PointF)paramList.get(99), (PointF)paramList.get(101));
    int i = (int)(f1 * 1.0F);
    int j = (int)(1.0F * f2);
    float f3 = i / f1;
    float f4 = j / f2;
    i = 0;
    while (i < 83)
    {
      float f5 = AlgoUtils.distanceOfPoint2Line((PointF)paramList.get(99), (PointF)paramList.get(101), f2, (PointF)paramList.get(i));
      float f6 = AlgoUtils.distanceOfPoint2Line((PointF)paramList.get(99), (PointF)paramList.get(105), f1, (PointF)paramList.get(i));
      ((PointF)paramList.get(i)).set(f5 * f3, f6 * f4);
      i += 1;
    }
    while (paramList.size() > 83) {
      paramList.remove(paramList.size() - 1);
    }
  }
  
  public static Float[] smoothYTPointsVisPoints(Float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null)
    {
      if (paramArrayOfFloat.length < 90) {
        return paramArrayOfFloat;
      }
      int m = 66;
      int i = 66;
      int k;
      for (int j = 0; i <= 82; j = k)
      {
        k = j;
        if (paramArrayOfFloat[i].floatValue() < 0.7D) {
          k = j + 1;
        }
        i += 1;
      }
      if (j >= 15)
      {
        i = m;
        while (i <= 82)
        {
          if (paramArrayOfFloat[i].floatValue() >= 0.7D) {
            paramArrayOfFloat[i] = Float.valueOf(0.5F);
          }
          i += 1;
        }
      }
    }
    return paramArrayOfFloat;
  }
  
  public static float[] transform83PointsTo90(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float['´'];
    if (paramArrayOfFloat != null)
    {
      if (paramArrayOfFloat.length < 166) {
        return arrayOfFloat;
      }
      int j = 0;
      int i = 0;
      while (j < 83)
      {
        int k = j * 2;
        arrayOfFloat[k] = paramArrayOfFloat[k];
        k += 1;
        arrayOfFloat[k] = paramArrayOfFloat[k];
        i += 1;
        j += 1;
      }
      j = i * 2;
      arrayOfFloat[j] = (getFacePointX(paramArrayOfFloat, 55) + (getFacePointX(paramArrayOfFloat, 63) - getFacePointX(paramArrayOfFloat, 55)) / 2.0F);
      arrayOfFloat[(j + 1)] = (getFacePointY(paramArrayOfFloat, 55) + (getFacePointY(paramArrayOfFloat, 63) - getFacePointY(paramArrayOfFloat, 55)) / 2.0F);
      i += 1;
      j = i * 2;
      arrayOfFloat[j] = (getFacePointX(paramArrayOfFloat, 23) + (getFacePointX(paramArrayOfFloat, 31) - getFacePointX(paramArrayOfFloat, 23)) / 2.0F);
      arrayOfFloat[(j + 1)] = (getFacePointY(paramArrayOfFloat, 23) + (getFacePointY(paramArrayOfFloat, 31) - getFacePointY(paramArrayOfFloat, 23)) / 2.0F);
      i += 1;
      j = i * 2;
      arrayOfFloat[j] = (getFacePointX(paramArrayOfFloat, 59) + (getFacePointX(paramArrayOfFloat, 77) - getFacePointX(paramArrayOfFloat, 59)) / 2.0F);
      arrayOfFloat[(j + 1)] = (getFacePointY(paramArrayOfFloat, 59) + (getFacePointY(paramArrayOfFloat, 77) - getFacePointY(paramArrayOfFloat, 59)) / 2.0F);
      i += 1;
      j = i * 2;
      arrayOfFloat[j] = (getFacePointX(paramArrayOfFloat, 35) + (getFacePointX(paramArrayOfFloat, 35) - getFacePointX(paramArrayOfFloat, 6)));
      arrayOfFloat[(j + 1)] = (getFacePointY(paramArrayOfFloat, 35) + (getFacePointY(paramArrayOfFloat, 35) - getFacePointY(paramArrayOfFloat, 6)));
      i += 1;
      j = i * 2;
      arrayOfFloat[j] = (getFacePointX(paramArrayOfFloat, 64) + (getFacePointX(paramArrayOfFloat, 64) - getFacePointX(paramArrayOfFloat, 9)) * 1.4F);
      arrayOfFloat[(j + 1)] = (getFacePointY(paramArrayOfFloat, 64) + (getFacePointY(paramArrayOfFloat, 64) - getFacePointY(paramArrayOfFloat, 9)) * 1.4F);
      i += 1;
      j = i * 2;
      arrayOfFloat[j] = (getFacePointX(paramArrayOfFloat, 45) + (getFacePointX(paramArrayOfFloat, 45) - getFacePointX(paramArrayOfFloat, 12)));
      arrayOfFloat[(j + 1)] = (getFacePointY(paramArrayOfFloat, 45) + (getFacePointY(paramArrayOfFloat, 45) - getFacePointY(paramArrayOfFloat, 12)));
      i = (i + 1) * 2;
      arrayOfFloat[i] = (getFacePointX(arrayOfFloat, 83) + (getFacePointX(arrayOfFloat, 83) - getFacePointX(arrayOfFloat, 59)));
      arrayOfFloat[(i + 1)] = (getFacePointY(arrayOfFloat, 83) + (getFacePointY(arrayOfFloat, 83) - getFacePointY(arrayOfFloat, 59)));
    }
    return arrayOfFloat;
  }
  
  public static List<PointF> transform90PointsTo83(float[] paramArrayOfFloat)
  {
    PointF[] arrayOfPointF = new PointF[83];
    int i = 0;
    while (i < arrayOfPointF.length)
    {
      arrayOfPointF[i] = new PointF();
      i += 1;
    }
    arrayOfPointF[0] = getMiddleV2(paramArrayOfFloat, 67, 68);
    i = 1;
    int j;
    while (i <= 17)
    {
      localPointF = arrayOfPointF[i];
      j = (i + 68) * 2;
      localPointF.x = paramArrayOfFloat[(j + 0)];
      arrayOfPointF[i].y = paramArrayOfFloat[(j + 1)];
      i += 1;
    }
    arrayOfPointF[18] = getMiddleV2(paramArrayOfFloat, 86, 87);
    i = 19;
    while (i <= 34)
    {
      localPointF = arrayOfPointF[i];
      j = (i - 19) * 2;
      localPointF.x = paramArrayOfFloat[(j + 0)];
      arrayOfPointF[i].y = paramArrayOfFloat[(j + 1)];
      i += 1;
    }
    i = 35;
    while (i <= 42)
    {
      localPointF = arrayOfPointF[i];
      j = (i - 19) * 2;
      localPointF.x = paramArrayOfFloat[(j + 0)];
      arrayOfPointF[i].y = paramArrayOfFloat[(j + 1)];
      i += 1;
    }
    arrayOfPointF[43] = getArrayMiddleV2(paramArrayOfFloat, 16, 23);
    arrayOfPointF[44].x = paramArrayOfFloat['°'];
    arrayOfPointF[44].y = paramArrayOfFloat['±'];
    i = 45;
    while (i <= 52)
    {
      localPointF = arrayOfPointF[i];
      j = (i - 21) * 2;
      localPointF.x = paramArrayOfFloat[(j + 0)];
      arrayOfPointF[i].y = paramArrayOfFloat[(j + 1)];
      i += 1;
    }
    arrayOfPointF[53] = getArrayMiddleV2(paramArrayOfFloat, 24, 31);
    arrayOfPointF[54].x = paramArrayOfFloat['²'];
    arrayOfPointF[54].y = paramArrayOfFloat['³'];
    PointF localPointF = arrayOfPointF[55];
    double d1 = paramArrayOfFloat[66];
    Double.isNaN(d1);
    double d2 = paramArrayOfFloat[40];
    Double.isNaN(d2);
    localPointF.x = ((float)(d1 * 0.5D + d2 * 0.5D));
    localPointF = arrayOfPointF[55];
    d1 = paramArrayOfFloat[67];
    Double.isNaN(d1);
    d2 = paramArrayOfFloat[41];
    Double.isNaN(d2);
    localPointF.y = ((float)(d1 * 0.5D + d2 * 0.5D));
    localPointF = arrayOfPointF[56];
    d1 = paramArrayOfFloat[64];
    Double.isNaN(d1);
    d2 = paramArrayOfFloat[70];
    Double.isNaN(d2);
    double d3 = paramArrayOfFloat[72];
    Double.isNaN(d3);
    localPointF.x = ((float)(d1 * 0.1D + d2 * 0.45D + d3 * 0.45D));
    localPointF = arrayOfPointF[56];
    d1 = paramArrayOfFloat[65];
    Double.isNaN(d1);
    d2 = paramArrayOfFloat[71];
    Double.isNaN(d2);
    d3 = paramArrayOfFloat[73];
    Double.isNaN(d3);
    localPointF.y = ((float)(d1 * 0.1D + d2 * 0.45D + d3 * 0.45D));
    i = 57;
    while (i <= 61)
    {
      localPointF = arrayOfPointF[i];
      j = (i - 20) * 2;
      localPointF.x = paramArrayOfFloat[(j + 0)];
      arrayOfPointF[i].y = paramArrayOfFloat[(j + 1)];
      i += 1;
    }
    localPointF = arrayOfPointF[62];
    d1 = paramArrayOfFloat[64];
    Double.isNaN(d1);
    d2 = paramArrayOfFloat[86];
    Double.isNaN(d2);
    d3 = paramArrayOfFloat[84];
    Double.isNaN(d3);
    localPointF.x = ((float)(d1 * 0.1D + d2 * 0.45D + d3 * 0.45D));
    localPointF = arrayOfPointF[62];
    d1 = paramArrayOfFloat[65];
    Double.isNaN(d1);
    d2 = paramArrayOfFloat[87];
    Double.isNaN(d2);
    d3 = paramArrayOfFloat[85];
    Double.isNaN(d3);
    localPointF.y = ((float)(d1 * 0.1D + d2 * 0.45D + d3 * 0.45D));
    localPointF = arrayOfPointF[63];
    d1 = paramArrayOfFloat[66];
    Double.isNaN(d1);
    d2 = paramArrayOfFloat[56];
    Double.isNaN(d2);
    localPointF.x = ((float)(d1 * 0.5D + d2 * 0.5D));
    localPointF = arrayOfPointF[63];
    i = 67;
    d1 = paramArrayOfFloat[67];
    Double.isNaN(d1);
    d2 = paramArrayOfFloat[57];
    Double.isNaN(d2);
    localPointF.y = ((float)(d1 * 0.5D + d2 * 0.5D));
    arrayOfPointF[64].x = paramArrayOfFloat[64];
    arrayOfPointF[64].y = paramArrayOfFloat[65];
    arrayOfPointF[65].x = paramArrayOfFloat[90];
    arrayOfPointF[65].y = paramArrayOfFloat[91];
    arrayOfPointF[66].x = paramArrayOfFloat[102];
    arrayOfPointF[66].y = paramArrayOfFloat[103];
    while (i <= 71)
    {
      localPointF = arrayOfPointF[i];
      j = (i - 21) * 2;
      localPointF.x = paramArrayOfFloat[(j + 0)];
      arrayOfPointF[i].y = paramArrayOfFloat[(j + 1)];
      i += 1;
    }
    arrayOfPointF[72] = getMiddleV2(paramArrayOfFloat, 60, 61);
    arrayOfPointF[73].x = paramArrayOfFloat[118];
    arrayOfPointF[73].y = paramArrayOfFloat[119];
    arrayOfPointF[74] = getMiddleV2(paramArrayOfFloat, 57, 58);
    i = 75;
    while (i <= 79)
    {
      localPointF = arrayOfPointF[i];
      j = (131 - i) * 2;
      localPointF.x = paramArrayOfFloat[(j + 0)];
      arrayOfPointF[i].y = paramArrayOfFloat[(j + 1)];
      i += 1;
    }
    arrayOfPointF[80] = getMiddleV2(paramArrayOfFloat, 62, 63);
    arrayOfPointF[81].x = paramArrayOfFloat[''];
    arrayOfPointF[81].y = paramArrayOfFloat[''];
    arrayOfPointF[82] = getMiddleV2(paramArrayOfFloat, 65, 66);
    adjustEyeFeatureV2(arrayOfPointF);
    paramArrayOfFloat = new ArrayList();
    paramArrayOfFloat.addAll(Arrays.asList(arrayOfPointF));
    return paramArrayOfFloat;
  }
  
  public static float[] transform90PointsVisTo83(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[83];
    int i = 0;
    while (i < arrayOfFloat.length)
    {
      arrayOfFloat[i] = 0.0F;
      i += 1;
    }
    arrayOfFloat[0] = getMiddleFloat(paramArrayOfFloat, 67, 68);
    i = 1;
    while (i <= 17)
    {
      arrayOfFloat[i] = paramArrayOfFloat[(i + 68)];
      i += 1;
    }
    arrayOfFloat[18] = getMiddleFloat(paramArrayOfFloat, 86, 87);
    i = 19;
    while (i <= 34)
    {
      arrayOfFloat[i] = paramArrayOfFloat[(i - 19)];
      i += 1;
    }
    i = 35;
    while (i <= 42)
    {
      arrayOfFloat[i] = paramArrayOfFloat[(i - 19)];
      i += 1;
    }
    arrayOfFloat[43] = getArrayMiddleFloat(paramArrayOfFloat, 16, 23);
    arrayOfFloat[44] = paramArrayOfFloat[88];
    i = 45;
    while (i <= 52)
    {
      arrayOfFloat[i] = paramArrayOfFloat[(i - 21)];
      i += 1;
    }
    arrayOfFloat[53] = getArrayMiddleFloat(paramArrayOfFloat, 24, 31);
    arrayOfFloat[54] = paramArrayOfFloat[89];
    double d1 = paramArrayOfFloat[33];
    Double.isNaN(d1);
    double d2 = paramArrayOfFloat[20];
    Double.isNaN(d2);
    arrayOfFloat[55] = ((float)(d1 * 0.5D + d2 * 0.5D));
    d1 = paramArrayOfFloat[32];
    Double.isNaN(d1);
    d2 = paramArrayOfFloat[35];
    Double.isNaN(d2);
    double d3 = paramArrayOfFloat[36];
    Double.isNaN(d3);
    arrayOfFloat[56] = ((float)(d1 * 0.1D + d2 * 0.45D + d3 * 0.45D));
    i = 57;
    while (i <= 61)
    {
      arrayOfFloat[i] = paramArrayOfFloat[(i - 20)];
      i += 1;
    }
    d1 = paramArrayOfFloat[32];
    Double.isNaN(d1);
    d2 = paramArrayOfFloat[43];
    Double.isNaN(d2);
    d3 = paramArrayOfFloat[42];
    Double.isNaN(d3);
    arrayOfFloat[62] = ((float)(d1 * 0.1D + d2 * 0.45D + d3 * 0.45D));
    d1 = paramArrayOfFloat[33];
    Double.isNaN(d1);
    d2 = paramArrayOfFloat[28];
    Double.isNaN(d2);
    arrayOfFloat[63] = ((float)(d1 * 0.5D + d2 * 0.5D));
    arrayOfFloat[64] = paramArrayOfFloat[32];
    arrayOfFloat[65] = paramArrayOfFloat[45];
    arrayOfFloat[66] = paramArrayOfFloat[51];
    i = 67;
    while (i <= 71)
    {
      arrayOfFloat[i] = paramArrayOfFloat[(i - 21)];
      i += 1;
    }
    arrayOfFloat[72] = getMiddleFloat(paramArrayOfFloat, 60, 61);
    arrayOfFloat[73] = paramArrayOfFloat[59];
    arrayOfFloat[74] = getMiddleFloat(paramArrayOfFloat, 57, 58);
    i = 75;
    while (i <= 79)
    {
      arrayOfFloat[i] = paramArrayOfFloat[(131 - i)];
      i += 1;
    }
    arrayOfFloat[80] = getMiddleFloat(paramArrayOfFloat, 62, 63);
    arrayOfFloat[81] = paramArrayOfFloat[64];
    arrayOfFloat[82] = getMiddleFloat(paramArrayOfFloat, 65, 66);
    return arrayOfFloat;
  }
  
  public static List<PointF> transformYTPointsToPtuPoints(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = transform90PointsTo83(paramArrayOfFloat);
    PointF localPointF = AlgoUtils.middlePoint((PointF)paramArrayOfFloat.get(55), (PointF)paramArrayOfFloat.get(63));
    paramArrayOfFloat.add(localPointF);
    paramArrayOfFloat.add(AlgoUtils.middlePoint((PointF)paramArrayOfFloat.get(23), (PointF)paramArrayOfFloat.get(31)));
    paramArrayOfFloat.add(AlgoUtils.middlePoint((PointF)paramArrayOfFloat.get(59), (PointF)paramArrayOfFloat.get(77)));
    float f1 = ((PointF)paramArrayOfFloat.get(35)).x;
    float f2 = ((PointF)paramArrayOfFloat.get(6)).x;
    double d1 = ((PointF)paramArrayOfFloat.get(39)).y;
    double d2 = ((PointF)paramArrayOfFloat.get(39)).y - ((PointF)paramArrayOfFloat.get(56)).y;
    Double.isNaN(d2);
    Double.isNaN(d1);
    paramArrayOfFloat.add(new PointF(f1 * 2.0F - f2, (float)(d1 + d2 * 3.2D)));
    d1 = ((PointF)paramArrayOfFloat.get(64)).x;
    Double.isNaN(d1);
    d2 = ((PointF)paramArrayOfFloat.get(9)).x;
    Double.isNaN(d2);
    f1 = (float)(d1 * 2.4D - d2 * 1.4D);
    d1 = localPointF.y;
    Double.isNaN(d1);
    d2 = ((PointF)paramArrayOfFloat.get(59)).y;
    Double.isNaN(d2);
    paramArrayOfFloat.add(new PointF(f1, (float)(d1 * 2.5D - d2 * 1.5D)));
    f1 = ((PointF)paramArrayOfFloat.get(45)).x;
    f2 = ((PointF)paramArrayOfFloat.get(12)).x;
    d1 = ((PointF)paramArrayOfFloat.get(49)).y;
    Double.isNaN(d1);
    d2 = ((PointF)paramArrayOfFloat.get(62)).y;
    Double.isNaN(d2);
    paramArrayOfFloat.add(new PointF(f1 * 2.0F - f2, (float)(d1 * 4.2D - d2 * 3.2D)));
    f1 = localPointF.x;
    f2 = ((PointF)paramArrayOfFloat.get(59)).x;
    d1 = ((PointF)paramArrayOfFloat.get(39)).y + ((PointF)paramArrayOfFloat.get(49)).y;
    Double.isNaN(d1);
    d1 /= 2.0D;
    d2 = ((PointF)paramArrayOfFloat.get(64)).y - localPointF.y;
    Double.isNaN(d2);
    paramArrayOfFloat.add(new PointF(f1 * 2.0F - f2, (float)(d1 - d2 * 1.4D)));
    return paramArrayOfFloat;
  }
  
  public static Float[] transformYTPointsVisToPtuPoints(float[] paramArrayOfFloat)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayOfFloat = transform90PointsVisTo83(paramArrayOfFloat);
    int i = 0;
    while (i < 83)
    {
      localArrayList.add(Float.valueOf(paramArrayOfFloat[i]));
      i += 1;
    }
    localArrayList.add(Float.valueOf((paramArrayOfFloat[55] + paramArrayOfFloat[63]) / 2.0F));
    localArrayList.add(Float.valueOf((paramArrayOfFloat[23] + paramArrayOfFloat[31]) / 2.0F));
    localArrayList.add(Float.valueOf((paramArrayOfFloat[59] + paramArrayOfFloat[77]) / 2.0F));
    localArrayList.add(Float.valueOf(1.0F));
    localArrayList.add(Float.valueOf(1.0F));
    localArrayList.add(Float.valueOf(1.0F));
    localArrayList.add(Float.valueOf(1.0F));
    return (Float[])localArrayList.toArray(new Float[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.YoutuPointsUtil
 * JD-Core Version:    0.7.0.1
 */