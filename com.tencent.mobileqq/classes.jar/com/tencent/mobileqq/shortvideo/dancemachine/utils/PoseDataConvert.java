package com.tencent.mobileqq.shortvideo.dancemachine.utils;

import com.tencent.mobileqq.qmcf.QmcfManager;
import java.util.List;

public class PoseDataConvert
{
  private static int[][] mirrorMap;
  
  static
  {
    int[] arrayOfInt1 = { 16, 17 };
    int[] arrayOfInt2 = { 2, 5 };
    int[] arrayOfInt3 = { 4, 7 };
    int[] arrayOfInt4 = { 9, 12 };
    int[] arrayOfInt5 = { 34, 35 };
    int[] arrayOfInt6 = { 20, 23 };
    int[] arrayOfInt7 = { 21, 24 };
    int[] arrayOfInt8 = { 22, 25 };
    int[] arrayOfInt9 = { 28, 31 };
    mirrorMap = new int[][] { { 14, 15 }, arrayOfInt1, arrayOfInt2, { 3, 6 }, arrayOfInt3, { 8, 11 }, arrayOfInt4, { 10, 13 }, { 32, 33 }, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, { 26, 29 }, { 27, 30 }, arrayOfInt9 };
  }
  
  public static float[] convertPointsOld(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = (paramArrayOfFloat.length - 1) / 3;
    float[] arrayOfFloat = new float[j * 3];
    int i = 0;
    while (i < j)
    {
      int k = i * 3;
      arrayOfFloat[k] = (-(paramFloat3 - paramArrayOfFloat[k] * 2.0F) / paramFloat3);
      int m = k + 1;
      arrayOfFloat[m] = ((paramFloat4 - paramArrayOfFloat[m] * 2.0F) / paramFloat4);
      k += 2;
      arrayOfFloat[k] = paramArrayOfFloat[k];
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public static float[] convertPointsToFrameCoordinate(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f = paramFloat1 / paramFloat3;
    paramFloat2 /= paramFloat4;
    int j = (paramArrayOfFloat.length - 1) / 3;
    float[] arrayOfFloat = new float[j * 3];
    int i = 0;
    while (i < j)
    {
      int k = i * 3;
      paramFloat1 = paramArrayOfFloat[k];
      if (QmcfManager.getInstance().needConvertCoor()) {
        paramFloat1 = paramFloat3 - paramArrayOfFloat[k];
      }
      int m = k + 1;
      paramFloat4 = paramArrayOfFloat[m];
      arrayOfFloat[k] = (paramFloat1 * f);
      arrayOfFloat[m] = (paramFloat4 * paramFloat2);
      k += 2;
      arrayOfFloat[k] = paramArrayOfFloat[k];
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public static void convertToVec3f(float[] paramArrayOfFloat, List<Vec3f> paramList)
  {
    int m = paramArrayOfFloat.length / 3;
    int j = paramList.size();
    int k = 0;
    int i = k;
    if (j < m)
    {
      paramList.clear();
      j = 0;
      for (;;)
      {
        i = k;
        if (j >= m) {
          break;
        }
        paramList.add(new Vec3f());
        j += 1;
      }
    }
    while (i < m)
    {
      Vec3f localVec3f2 = (Vec3f)paramList.get(i);
      Vec3f localVec3f1 = localVec3f2;
      if (localVec3f2 == null)
      {
        localVec3f1 = new Vec3f();
        paramList.set(i, localVec3f1);
      }
      j = i * 3;
      localVec3f1.set(paramArrayOfFloat[j], paramArrayOfFloat[(j + 1)], paramArrayOfFloat[(j + 2)]);
      i += 1;
    }
    if (QmcfManager.getInstance().needConvertCoor()) {
      mirrorTrans(paramList);
    }
  }
  
  public static void mirrorTrans(List<Vec3f> paramList)
  {
    if (paramList.size() != 36) {
      return;
    }
    int i = 0;
    Object localObject;
    while (i < paramList.size())
    {
      localObject = (Vec3f)paramList.get(i);
      i += 1;
    }
    i = 0;
    for (;;)
    {
      localObject = mirrorMap;
      if (i >= localObject.length) {
        break;
      }
      localObject = (Vec3f)paramList.get(localObject[i][0]);
      int[][] arrayOfInt = mirrorMap;
      paramList.set(arrayOfInt[i][0], paramList.get(arrayOfInt[i][1]));
      paramList.set(mirrorMap[i][1], localObject);
      i += 1;
    }
  }
  
  public static float[] normalizedPoseData(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramArrayOfFloat = convertPointsToFrameCoordinate(paramArrayOfFloat, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    int j = paramArrayOfFloat.length / 3;
    int i = 0;
    while (i < j)
    {
      int k = i * 3;
      paramArrayOfFloat[k] = (-(paramFloat1 - paramArrayOfFloat[k] * 2.0F) / paramFloat1);
      k += 1;
      paramArrayOfFloat[k] = ((paramFloat2 - paramArrayOfFloat[k] * 2.0F) / paramFloat2);
      i += 1;
    }
    return paramArrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.utils.PoseDataConvert
 * JD-Core Version:    0.7.0.1
 */