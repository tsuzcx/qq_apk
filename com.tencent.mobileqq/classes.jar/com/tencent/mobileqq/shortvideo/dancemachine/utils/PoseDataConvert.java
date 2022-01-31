package com.tencent.mobileqq.shortvideo.dancemachine.utils;

import com.tencent.mobileqq.qmcf.QmcfManager;
import java.util.List;

public class PoseDataConvert
{
  private static int[][] a;
  
  static
  {
    int[] arrayOfInt = { 20, 23 };
    a = new int[][] { { 14, 15 }, { 16, 17 }, { 2, 5 }, { 3, 6 }, { 4, 7 }, { 8, 11 }, { 9, 12 }, { 10, 13 }, { 32, 33 }, { 34, 35 }, arrayOfInt, { 21, 24 }, { 22, 25 }, { 26, 29 }, { 27, 30 }, { 28, 31 } };
  }
  
  public static void a(List paramList)
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
      while (i < a.length)
      {
        localVec3f = (Vec3f)paramList.get(a[i][0]);
        paramList.set(a[i][0], paramList.get(a[i][1]));
        paramList.set(a[i][1], localVec3f);
        i += 1;
      }
    }
  }
  
  public static void a(float[] paramArrayOfFloat, List paramList)
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
      localVec3f1.a(paramArrayOfFloat[(i * 3)], paramArrayOfFloat[(i * 3 + 1)], paramArrayOfFloat[(i * 3 + 2)]);
      i += 1;
    }
    if (QmcfManager.a().b()) {
      a(paramList);
    }
  }
  
  public static float[] a(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f = paramFloat1 / paramFloat3;
    paramFloat2 /= paramFloat4;
    int j = (paramArrayOfFloat.length - 1) / 3;
    float[] arrayOfFloat = new float[j * 3];
    int i = 0;
    while (i < j)
    {
      paramFloat1 = paramArrayOfFloat[(i * 3)];
      if (QmcfManager.a().b()) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.utils.PoseDataConvert
 * JD-Core Version:    0.7.0.1
 */