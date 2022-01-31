package com.tencent.mobileqq.shortvideo.dancemachine.utils;

import com.tencent.mobileqq.qmcf.QmcfManager;
import java.util.List;

public class PoseDataConvert
{
  private static int[][] mirrorMap;
  
  static
  {
    int[] arrayOfInt1 = { 16, 17 };
    int[] arrayOfInt2 = { 4, 7 };
    int[] arrayOfInt3 = { 8, 11 };
    int[] arrayOfInt4 = { 9, 12 };
    int[] arrayOfInt5 = { 34, 35 };
    int[] arrayOfInt6 = { 20, 23 };
    int[] arrayOfInt7 = { 21, 24 };
    int[] arrayOfInt8 = { 22, 25 };
    int[] arrayOfInt9 = { 26, 29 };
    int[] arrayOfInt10 = { 27, 30 };
    mirrorMap = new int[][] { { 14, 15 }, arrayOfInt1, { 2, 5 }, { 3, 6 }, arrayOfInt2, arrayOfInt3, arrayOfInt4, { 10, 13 }, { 32, 33 }, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, arrayOfInt10, { 28, 31 } };
  }
  
  public static float[] convertPointsOld(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = (paramArrayOfFloat.length - 1) / 3;
    float[] arrayOfFloat = new float[j * 3];
    int i = 0;
    while (i < j)
    {
      arrayOfFloat[(i * 3)] = (-(paramFloat3 - paramArrayOfFloat[(i * 3)] * 2.0F) / paramFloat3);
      arrayOfFloat[(i * 3 + 1)] = ((paramFloat4 - paramArrayOfFloat[(i * 3 + 1)] * 2.0F) / paramFloat4);
      arrayOfFloat[(i * 3 + 2)] = paramArrayOfFloat[(i * 3 + 2)];
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
      paramFloat1 = paramArrayOfFloat[(i * 3)];
      if (QmcfManager.getInstance().needConvertCoor()) {
        paramFloat1 = paramFloat3 - paramArrayOfFloat[(i * 3)];
      }
      paramFloat4 = paramArrayOfFloat[(i * 3 + 1)];
      arrayOfFloat[(i * 3)] = (paramFloat1 * f);
      arrayOfFloat[(i * 3 + 1)] = (paramFloat4 * paramFloat2);
      arrayOfFloat[(i * 3 + 2)] = paramArrayOfFloat[(i * 3 + 2)];
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public static void convertToVec3f(float[] paramArrayOfFloat, List<Vec3f> paramList)
  {
    int j = paramArrayOfFloat.length / 3;
    if (paramList.size() < j)
    {
      paramList.clear();
      i = 0;
      while (i < j)
      {
        paramList.add(new Vec3f());
        i += 1;
      }
    }
    int i = 0;
    while (i < j)
    {
      Vec3f localVec3f2 = (Vec3f)paramList.get(i);
      Vec3f localVec3f1 = localVec3f2;
      if (localVec3f2 == null)
      {
        localVec3f1 = new Vec3f();
        paramList.set(i, localVec3f1);
      }
      localVec3f1.set(paramArrayOfFloat[(i * 3)], paramArrayOfFloat[(i * 3 + 1)], paramArrayOfFloat[(i * 3 + 2)]);
      i += 1;
    }
    if (QmcfManager.getInstance().needConvertCoor()) {
      mirrorTrans(paramList);
    }
  }
  
  public static void mirrorTrans(List<Vec3f> paramList)
  {
    if (paramList.size() != 36) {}
    for (;;)
    {
      return;
      int i = 0;
      Vec3f localVec3f;
      while (i < paramList.size())
      {
        localVec3f = (Vec3f)paramList.get(i);
        i += 1;
      }
      i = 0;
      while (i < mirrorMap.length)
      {
        localVec3f = (Vec3f)paramList.get(mirrorMap[i][0]);
        paramList.set(mirrorMap[i][0], paramList.get(mirrorMap[i][1]));
        paramList.set(mirrorMap[i][1], localVec3f);
        i += 1;
      }
    }
  }
  
  public static float[] normalizedPoseData(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramArrayOfFloat = convertPointsToFrameCoordinate(paramArrayOfFloat, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    int j = paramArrayOfFloat.length / 3;
    int i = 0;
    while (i < j)
    {
      paramArrayOfFloat[(i * 3)] = (-(paramFloat1 - paramArrayOfFloat[(i * 3)] * 2.0F) / paramFloat1);
      paramArrayOfFloat[(i * 3 + 1)] = ((paramFloat2 - paramArrayOfFloat[(i * 3 + 1)] * 2.0F) / paramFloat2);
      i += 1;
    }
    return paramArrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.utils.PoseDataConvert
 * JD-Core Version:    0.7.0.1
 */