package com.tencent.mobileqq.shortvideo.facedancegame.utils;

import android.graphics.PointF;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceDetectUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.ArrayList;
import java.util.List;

public class ActUtil
{
  private static final String a = com.tencent.ttpic.util.ActUtil.class.getSimpleName();
  
  private static float a(float paramFloat)
  {
    return paramFloat * paramFloat * paramFloat * paramFloat * (35.0F - 84.0F * paramFloat + 70.0F * paramFloat * paramFloat - 20.0F * paramFloat * paramFloat * paramFloat);
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat1 < paramFloat3) {
      paramFloat1 = paramFloat3;
    }
    for (;;)
    {
      if (paramFloat1 > paramFloat4) {}
      for (float f = paramFloat4;; f = paramFloat1)
      {
        if (paramFloat2 < paramFloat3) {}
        for (paramFloat1 = paramFloat3;; paramFloat1 = paramFloat2)
        {
          paramFloat2 = paramFloat1;
          if (paramFloat1 > paramFloat4) {
            paramFloat2 = paramFloat4;
          }
          paramFloat2 = Math.abs(f - paramFloat2) * 2.0F / (paramFloat4 - paramFloat3);
          paramFloat1 = paramFloat2;
          if (paramFloat2 > 1.0D) {
            paramFloat1 = 1.0F;
          }
          return 1.0F - a(paramFloat1);
        }
      }
    }
  }
  
  private static float a(PointF paramPointF1, PointF paramPointF2)
  {
    return (float)Math.sqrt((paramPointF1.x - paramPointF2.x) * (paramPointF1.x - paramPointF2.x) + (paramPointF1.y - paramPointF2.y) * (paramPointF1.y - paramPointF2.y));
  }
  
  public static float a(List paramList1, List paramList2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, double[] paramArrayOfDouble)
  {
    if ((paramList1 == null) || (paramList2 == null) || (paramArrayOfFloat1 == null) || (paramArrayOfFloat1.length < 3) || (paramArrayOfDouble == null) || (paramArrayOfDouble.length < 7)) {
      return 0.0F;
    }
    paramList1 = FaceOffUtil.getFullCoords(FaceDetectUtil.facePointf83to90(paramList1), 2.0F);
    paramList2 = FaceOffUtil.getFullCoords(FaceDetectUtil.facePointf83to90(paramList2), 2.0F);
    if ((paramList2.size() < 106) || (paramList1.size() < 106)) {
      return 0.0F;
    }
    ArrayList localArrayList1 = new ArrayList(paramList1.size());
    ArrayList localArrayList2 = new ArrayList(paramList2.size());
    float f1 = AlgoUtils.getDistance((PointF)paramList1.get(99), (PointF)paramList1.get(105));
    float f2 = AlgoUtils.getDistance((PointF)paramList1.get(99), (PointF)paramList1.get(101));
    float f3 = AlgoUtils.getDistance((PointF)paramList2.get(99), (PointF)paramList2.get(105));
    float f4 = AlgoUtils.getDistance((PointF)paramList2.get(99), (PointF)paramList2.get(101));
    int i = 0;
    while (i < paramList1.size())
    {
      localArrayList1.add(new PointF(((PointF)paramList1.get(i)).x / f1, ((PointF)paramList1.get(i)).y / f2));
      localArrayList2.add(new PointF(((PointF)paramList2.get(i)).x / f3, ((PointF)paramList2.get(i)).y / f4));
      i += 1;
    }
    f3 = a(a((PointF)localArrayList1.get(37), (PointF)localArrayList1.get(41)) / a((PointF)localArrayList1.get(35), (PointF)localArrayList1.get(39)), a((PointF)localArrayList2.get(37), (PointF)localArrayList2.get(41)) / a((PointF)localArrayList2.get(35), (PointF)localArrayList2.get(39)), 0.18F, 0.5F);
    f4 = a(a((PointF)localArrayList1.get(47), (PointF)localArrayList1.get(51)) / a((PointF)localArrayList1.get(45), (PointF)localArrayList1.get(49)), a((PointF)localArrayList2.get(47), (PointF)localArrayList2.get(51)) / a((PointF)localArrayList2.get(45), (PointF)localArrayList2.get(49)), 0.18F, 0.5F);
    float f5 = a(a((PointF)localArrayList1.get(73), (PointF)localArrayList1.get(81)) / a((PointF)localArrayList1.get(65), (PointF)localArrayList1.get(66)), a((PointF)localArrayList2.get(73), (PointF)localArrayList2.get(81)) / a((PointF)localArrayList2.get(65), (PointF)localArrayList2.get(66)), 0.05F, 0.6F);
    float f6 = a(paramArrayOfFloat1[0], paramArrayOfFloat2[0], -15.0F, 15.0F);
    float f7 = a(paramArrayOfFloat1[1], paramArrayOfFloat2[1], -20.0F, 20.0F);
    float f8 = a(paramArrayOfFloat1[2], paramArrayOfFloat2[2], -15.0F, 15.0F);
    f1 = (((PointF)localArrayList1.get(44)).x - ((PointF)localArrayList1.get(35)).x) / (((PointF)localArrayList1.get(39)).x - ((PointF)localArrayList1.get(35)).x);
    f2 = (((PointF)localArrayList1.get(54)).x - ((PointF)localArrayList1.get(45)).x) / (((PointF)localArrayList1.get(49)).x - ((PointF)localArrayList1.get(45)).x);
    float f9 = (((PointF)localArrayList2.get(44)).x - ((PointF)localArrayList2.get(35)).x) / (((PointF)localArrayList2.get(39)).x - ((PointF)localArrayList2.get(35)).x);
    float f10 = (((PointF)localArrayList2.get(54)).x - ((PointF)localArrayList2.get(45)).x) / (((PointF)localArrayList2.get(49)).x - ((PointF)localArrayList2.get(45)).x);
    f9 = a((f1 + f2) / 2.0F, (f10 + f9) / 2.0F, 0.25F, 0.75F);
    f2 = 0.0F;
    f1 = 0.0F;
    i = 0;
    while (i < 7)
    {
      f2 = (float)(f2 + paramArrayOfDouble[i] * new float[] { f3, f4, f5, f6, f7, f8, f9 }[i]);
      f1 = (float)(f1 + paramArrayOfDouble[i]);
      i += 1;
    }
    return f2 / f1 * 100.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.facedancegame.utils.ActUtil
 * JD-Core Version:    0.7.0.1
 */