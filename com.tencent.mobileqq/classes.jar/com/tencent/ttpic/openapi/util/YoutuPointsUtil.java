package com.tencent.ttpic.openapi.util;

import android.graphics.PointF;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YoutuPointsUtil
{
  private static void adjustEyeFeatureFloat(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[40] = ((float)(paramArrayOfFloat[38] + (paramArrayOfFloat[40] - paramArrayOfFloat[38]) * 0.98D));
    paramArrayOfFloat[41] = ((float)(paramArrayOfFloat[37] + (paramArrayOfFloat[41] - paramArrayOfFloat[37]) * 0.95D));
    paramArrayOfFloat[42] = ((float)(paramArrayOfFloat[36] + (paramArrayOfFloat[42] - paramArrayOfFloat[36]) * 0.9D));
    paramArrayOfFloat[50] = ((float)(paramArrayOfFloat[48] + (paramArrayOfFloat[50] - paramArrayOfFloat[48]) * 0.98D));
    paramArrayOfFloat[51] = ((float)(paramArrayOfFloat[47] + (paramArrayOfFloat[51] - paramArrayOfFloat[47]) * 0.95D));
    paramArrayOfFloat[52] = ((float)(paramArrayOfFloat[46] + (paramArrayOfFloat[52] - paramArrayOfFloat[46]) * 0.9D));
    paramArrayOfFloat[35] = ((float)(paramArrayOfFloat[35] + (paramArrayOfFloat[39] - paramArrayOfFloat[35]) / 40.0D));
  }
  
  private static void adjustEyeFeatureV2(PointF[] paramArrayOfPointF)
  {
    paramArrayOfPointF[40].x = ((float)(paramArrayOfPointF[38].x + (paramArrayOfPointF[40].x - paramArrayOfPointF[38].x) * 0.98D));
    paramArrayOfPointF[40].y = ((float)(paramArrayOfPointF[38].y + (paramArrayOfPointF[40].y - paramArrayOfPointF[38].y) * 0.98D));
    paramArrayOfPointF[41].x = ((float)(paramArrayOfPointF[37].x + (paramArrayOfPointF[41].x - paramArrayOfPointF[37].x) * 0.95D));
    paramArrayOfPointF[41].y = ((float)(paramArrayOfPointF[37].y + (paramArrayOfPointF[41].y - paramArrayOfPointF[37].y) * 0.95D));
    paramArrayOfPointF[42].x = ((float)(paramArrayOfPointF[36].x + (paramArrayOfPointF[42].x - paramArrayOfPointF[36].x) * 0.9D));
    paramArrayOfPointF[42].y = ((float)(paramArrayOfPointF[36].y + (paramArrayOfPointF[42].y - paramArrayOfPointF[36].y) * 0.9D));
    paramArrayOfPointF[50].x = ((float)(paramArrayOfPointF[48].x + (paramArrayOfPointF[50].x - paramArrayOfPointF[48].x) * 0.98D));
    paramArrayOfPointF[50].y = ((float)(paramArrayOfPointF[48].y + (paramArrayOfPointF[50].y - paramArrayOfPointF[48].y) * 0.98D));
    paramArrayOfPointF[51].x = ((float)(paramArrayOfPointF[47].x + (paramArrayOfPointF[51].x - paramArrayOfPointF[47].x) * 0.95D));
    paramArrayOfPointF[51].y = ((float)(paramArrayOfPointF[47].y + (paramArrayOfPointF[51].y - paramArrayOfPointF[47].y) * 0.95D));
    paramArrayOfPointF[52].x = ((float)(paramArrayOfPointF[46].x + (paramArrayOfPointF[52].x - paramArrayOfPointF[46].x) * 0.9D));
    paramArrayOfPointF[52].y = ((float)(paramArrayOfPointF[46].y + (paramArrayOfPointF[52].y - paramArrayOfPointF[46].y) * 0.9D));
    PointF localPointF = paramArrayOfPointF[35];
    localPointF.y = ((float)(localPointF.y + (paramArrayOfPointF[39].x - paramArrayOfPointF[35].x) / 40.0D));
    localPointF = paramArrayOfPointF[45];
    localPointF.y = ((float)(localPointF.y + (paramArrayOfPointF[45].x - paramArrayOfPointF[49].x) / 40.0D));
  }
  
  public static float[] calEyeEulerAngles(List<PointF> paramList)
  {
    new PointF();
    new PointF();
    PointF localPointF2 = new PointF(((PointF)paramList.get(54)).x, ((PointF)paramList.get(54)).y);
    PointF localPointF1 = new PointF(localPointF2.x - ((PointF)paramList.get(49)).x, localPointF2.y - ((PointF)paramList.get(49)).y);
    localPointF2 = new PointF(localPointF2.x - ((PointF)paramList.get(45)).x, localPointF2.y - ((PointF)paramList.get(45)).y);
    float f1 = (float)Math.sqrt(Math.pow(localPointF1.x, 2.0D) + Math.pow(localPointF1.y, 2.0D));
    double d = Math.pow(localPointF2.x, 2.0D);
    float f2 = ((float)Math.sqrt(Math.pow(localPointF2.y, 2.0D) + d) + f1) * 0.5F;
    float f3 = (float)(1.570796F / 3.0D * ((f1 - f2) / f2));
    localPointF2 = new PointF(((PointF)paramList.get(45)).x - ((PointF)paramList.get(49)).x, ((PointF)paramList.get(45)).y - ((PointF)paramList.get(49)).y);
    f2 = (float)((Math.atan2(localPointF1.x, localPointF1.y) - Math.atan2(localPointF2.x, localPointF2.y)) * 180.0D / 3.141592653589793D);
    float f4;
    if (f2 > 180.0D)
    {
      f1 = (float)(f2 - 360.0D);
      localPointF1 = new PointF(f1 * -1.570796F / 270.0F, f3);
      PointF localPointF3 = new PointF(((PointF)paramList.get(44)).x, ((PointF)paramList.get(44)).y);
      localPointF2 = new PointF(localPointF3.x - ((PointF)paramList.get(39)).x, localPointF3.y - ((PointF)paramList.get(39)).y);
      localPointF3 = new PointF(localPointF3.x - ((PointF)paramList.get(35)).x, localPointF3.y - ((PointF)paramList.get(35)).y);
      f1 = (float)Math.sqrt(Math.pow(localPointF2.x, 2.0D) + Math.pow(localPointF2.y, 2.0D));
      f2 = ((float)Math.sqrt(Math.pow(localPointF3.x, 2.0D) + Math.pow(localPointF3.y, 2.0D)) + f1) * 0.5F;
      f3 = -(1.570796F / 3.0F);
      f4 = (f1 - f2) / f2;
      paramList = new PointF(((PointF)paramList.get(35)).x - ((PointF)paramList.get(39)).x, ((PointF)paramList.get(35)).y - ((PointF)paramList.get(39)).y);
      f2 = (float)((Math.atan2(localPointF2.x, localPointF2.y) - Math.atan2(paramList.x, paramList.y)) * 180.0D / 3.141592653589793D);
      if (f2 <= 180.0D) {
        break label839;
      }
      f1 = (float)(f2 - 360.0D);
    }
    for (;;)
    {
      paramList = new PointF(f1 * 1.570796F / 270.0F, f3 * f4);
      f1 = localPointF1.x;
      f2 = paramList.x;
      f3 = localPointF1.y;
      paramList = new PointF((f1 + f2) * 0.5F, (paramList.y + f3) * 0.5F);
      return new float[] { paramList.x, paramList.y, 0.0F };
      f1 = f2;
      if (f2 >= -180.0D) {
        break;
      }
      f1 = (float)(f2 + 360.0D);
      break;
      label839:
      f1 = f2;
      if (f2 < -180.0D) {
        f1 = (float)(f2 + 360.0D);
      }
    }
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
      localPointF.x += paramArrayOfFloat[(i * 2)];
      localPointF.y += paramArrayOfFloat[(i * 2 + 1)];
      i += 1;
    }
    localPointF.x /= (paramInt2 - paramInt1 + 1);
    localPointF.y /= (paramInt2 - paramInt1 + 1);
    return localPointF;
  }
  
  public static List<PointF> getIris3Points(List<List<PointF>> paramList1, List<List<PointF>> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((CollectionUtils.isEmpty(paramList1)) || (CollectionUtils.isEmpty(paramList2))) {
      return localArrayList;
    }
    paramList1 = (List)paramList1.get(0);
    paramList2 = (List)paramList2.get(0);
    localArrayList.add(paramList1.get(43));
    localArrayList.add(paramList1.get(53));
    return localArrayList;
  }
  
  public static List<PointF> getIris4Points(List<List<PointF>> paramList1, List<List<PointF>> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((CollectionUtils.isEmpty(paramList1)) || (CollectionUtils.isEmpty(paramList2))) {
      return localArrayList;
    }
    paramList1 = (List)paramList1.get(0);
    paramList2 = (List)paramList2.get(0);
    localArrayList.add(paramList1.get(44));
    localArrayList.add(paramList1.get(54));
    return localArrayList;
  }
  
  public static List<PointF> getIrisPoints(float[] paramArrayOfFloat)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfFloat.length != 188) {}
    for (;;)
    {
      return localArrayList;
      int i = 90;
      while (i < 94)
      {
        localArrayList.add(new PointF(paramArrayOfFloat[(i * 2)], paramArrayOfFloat[(i * 2 + 1)]));
        i += 1;
      }
    }
  }
  
  public static List<PointF> getIrisRelatedPoints(List<List<PointF>> paramList1, List<List<PointF>> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((CollectionUtils.isEmpty(paramList1)) || (CollectionUtils.isEmpty(paramList2))) {
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
    return localArrayList;
  }
  
  private static float getMiddleFloat(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    return paramArrayOfFloat[paramInt1] / 2.0F + paramArrayOfFloat[paramInt2] / 2.0F;
  }
  
  private static PointF getMiddleV2(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    return new PointF((paramArrayOfFloat[(paramInt1 * 2)] + paramArrayOfFloat[(paramInt2 * 2)]) / 2.0F, (paramArrayOfFloat[(paramInt1 * 2 + 1)] + paramArrayOfFloat[(paramInt2 * 2 + 1)]) / 2.0F);
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
      ((PointF)paramList.get(i)).set(f3 * f5, f4 * f6);
      i += 1;
    }
    while (paramList.size() > 83) {
      paramList.remove(paramList.size() - 1);
    }
  }
  
  public static Float[] smoothYTPointsVisPoints(Float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 90)) {}
    for (;;)
    {
      return paramArrayOfFloat;
      int j = 0;
      int i = 66;
      while (i <= 82)
      {
        int k = j;
        if (paramArrayOfFloat[i].floatValue() < 0.7D) {
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      if (j >= 15)
      {
        i = 66;
        while (i <= 82)
        {
          if (paramArrayOfFloat[i].floatValue() >= 0.7D) {
            paramArrayOfFloat[i] = Float.valueOf(0.5F);
          }
          i += 1;
        }
      }
    }
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
    while (i <= 17)
    {
      arrayOfPointF[i].x = paramArrayOfFloat[((i + 68) * 2 + 0)];
      arrayOfPointF[i].y = paramArrayOfFloat[((i + 68) * 2 + 1)];
      i += 1;
    }
    arrayOfPointF[18] = getMiddleV2(paramArrayOfFloat, 86, 87);
    i = 19;
    while (i <= 34)
    {
      arrayOfPointF[i].x = paramArrayOfFloat[((i - 19) * 2 + 0)];
      arrayOfPointF[i].y = paramArrayOfFloat[((i - 19) * 2 + 1)];
      i += 1;
    }
    i = 35;
    while (i <= 42)
    {
      arrayOfPointF[i].x = paramArrayOfFloat[((i - 19) * 2 + 0)];
      arrayOfPointF[i].y = paramArrayOfFloat[((i - 19) * 2 + 1)];
      i += 1;
    }
    arrayOfPointF[43] = getArrayMiddleV2(paramArrayOfFloat, 16, 23);
    arrayOfPointF[44].x = paramArrayOfFloat['°'];
    arrayOfPointF[44].y = paramArrayOfFloat['±'];
    i = 45;
    while (i <= 52)
    {
      arrayOfPointF[i].x = paramArrayOfFloat[((i - 21) * 2 + 0)];
      arrayOfPointF[i].y = paramArrayOfFloat[((i - 21) * 2 + 1)];
      i += 1;
    }
    arrayOfPointF[53] = getArrayMiddleV2(paramArrayOfFloat, 24, 31);
    arrayOfPointF[54].x = paramArrayOfFloat['²'];
    arrayOfPointF[54].y = paramArrayOfFloat['³'];
    arrayOfPointF[55].x = ((float)(paramArrayOfFloat[66] * 0.5D + paramArrayOfFloat[40] * 0.5D));
    arrayOfPointF[55].y = ((float)(paramArrayOfFloat[67] * 0.5D + paramArrayOfFloat[41] * 0.5D));
    arrayOfPointF[56].x = ((float)(0.1D * paramArrayOfFloat[64] + paramArrayOfFloat[70] * 0.45D + paramArrayOfFloat[72] * 0.45D));
    arrayOfPointF[56].y = ((float)(0.1D * paramArrayOfFloat[65] + paramArrayOfFloat[71] * 0.45D + paramArrayOfFloat[73] * 0.45D));
    i = 57;
    while (i <= 61)
    {
      arrayOfPointF[i].x = paramArrayOfFloat[((i - 20) * 2 + 0)];
      arrayOfPointF[i].y = paramArrayOfFloat[((i - 20) * 2 + 1)];
      i += 1;
    }
    arrayOfPointF[62].x = ((float)(0.1D * paramArrayOfFloat[64] + paramArrayOfFloat[86] * 0.45D + paramArrayOfFloat[84] * 0.45D));
    arrayOfPointF[62].y = ((float)(0.1D * paramArrayOfFloat[65] + paramArrayOfFloat[87] * 0.45D + paramArrayOfFloat[85] * 0.45D));
    arrayOfPointF[63].x = ((float)(paramArrayOfFloat[66] * 0.5D + paramArrayOfFloat[56] * 0.5D));
    arrayOfPointF[63].y = ((float)(paramArrayOfFloat[67] * 0.5D + paramArrayOfFloat[57] * 0.5D));
    arrayOfPointF[64].x = paramArrayOfFloat[64];
    arrayOfPointF[64].y = paramArrayOfFloat[65];
    arrayOfPointF[65].x = paramArrayOfFloat[90];
    arrayOfPointF[65].y = paramArrayOfFloat[91];
    arrayOfPointF[66].x = paramArrayOfFloat[102];
    arrayOfPointF[66].y = paramArrayOfFloat[103];
    i = 67;
    while (i <= 71)
    {
      arrayOfPointF[i].x = paramArrayOfFloat[((i - 21) * 2 + 0)];
      arrayOfPointF[i].y = paramArrayOfFloat[((i - 21) * 2 + 1)];
      i += 1;
    }
    arrayOfPointF[72] = getMiddleV2(paramArrayOfFloat, 60, 61);
    arrayOfPointF[73].x = paramArrayOfFloat[118];
    arrayOfPointF[73].y = paramArrayOfFloat[119];
    arrayOfPointF[74] = getMiddleV2(paramArrayOfFloat, 57, 58);
    i = 75;
    while (i <= 79)
    {
      arrayOfPointF[i].x = paramArrayOfFloat[((131 - i) * 2 + 0)];
      arrayOfPointF[i].y = paramArrayOfFloat[((131 - i) * 2 + 1)];
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
    arrayOfFloat[55] = ((float)(0.5D * paramArrayOfFloat[33] + 0.5D * paramArrayOfFloat[20]));
    arrayOfFloat[56] = ((float)(0.1D * paramArrayOfFloat[32] + 0.45D * paramArrayOfFloat[35] + 0.45D * paramArrayOfFloat[36]));
    i = 57;
    while (i <= 61)
    {
      arrayOfFloat[i] = paramArrayOfFloat[(i - 20)];
      i += 1;
    }
    arrayOfFloat[62] = ((float)(0.1D * paramArrayOfFloat[32] + 0.45D * paramArrayOfFloat[43] + 0.45D * paramArrayOfFloat[42]));
    arrayOfFloat[63] = ((float)(0.5D * paramArrayOfFloat[33] + 0.5D * paramArrayOfFloat[28]));
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
    paramArrayOfFloat.add(new PointF(2.0F * ((PointF)paramArrayOfFloat.get(35)).x - ((PointF)paramArrayOfFloat.get(6)).x, (float)(((PointF)paramArrayOfFloat.get(39)).y + (((PointF)paramArrayOfFloat.get(39)).y - ((PointF)paramArrayOfFloat.get(56)).y) * 3.2D)));
    paramArrayOfFloat.add(new PointF((float)(2.4D * ((PointF)paramArrayOfFloat.get(64)).x - 1.4D * ((PointF)paramArrayOfFloat.get(9)).x), (float)(2.5D * localPointF.y - 1.5D * ((PointF)paramArrayOfFloat.get(59)).y)));
    paramArrayOfFloat.add(new PointF(2.0F * ((PointF)paramArrayOfFloat.get(45)).x - ((PointF)paramArrayOfFloat.get(12)).x, (float)(((PointF)paramArrayOfFloat.get(49)).y * 4.2D - ((PointF)paramArrayOfFloat.get(62)).y * 3.2D)));
    float f1 = localPointF.x;
    float f2 = ((PointF)paramArrayOfFloat.get(59)).x;
    float f3 = ((PointF)paramArrayOfFloat.get(39)).y;
    paramArrayOfFloat.add(new PointF(2.0F * f1 - f2, (float)((((PointF)paramArrayOfFloat.get(49)).y + f3) / 2.0D - (((PointF)paramArrayOfFloat.get(64)).y - localPointF.y) * 1.4D)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.YoutuPointsUtil
 * JD-Core Version:    0.7.0.1
 */