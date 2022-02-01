package com.tencent.ttpic.util;

import android.graphics.PointF;
import com.tencent.ttpic.model.FaceFeature;
import com.tencent.ttpic.openapi.util.FaceDetectUtil;
import java.util.Iterator;
import java.util.List;

public class CosFunUtil
{
  public static void getExtFaceFeature(float[][] paramArrayOfFloat)
  {
    PointF localPointF2 = new PointF(paramArrayOfFloat[54][0] - paramArrayOfFloat[44][0], paramArrayOfFloat[54][1] - paramArrayOfFloat[44][1]);
    PointF localPointF1 = new PointF((paramArrayOfFloat[54][0] + paramArrayOfFloat[44][0]) * 0.5F, (paramArrayOfFloat[54][1] + paramArrayOfFloat[44][1]) * 0.5F);
    if ((localPointF2.x < 0.01D) && (localPointF2.y < 0.01D)) {
      return;
    }
    float f1 = 99999.0F;
    int i = 24;
    while (i < 27)
    {
      localPointF3 = pointWithW(localPointF2, localPointF1, new PointF(paramArrayOfFloat[i][0], paramArrayOfFloat[i][1]));
      f2 = f1;
      if (localPointF3.y < f1) {
        f2 = localPointF3.y;
      }
      i += 1;
      f1 = f2;
    }
    i = 32;
    while (i < 35)
    {
      localPointF3 = pointWithW(localPointF2, localPointF1, new PointF(paramArrayOfFloat[i][0], paramArrayOfFloat[i][1]));
      f2 = f1;
      if (localPointF3.y < f1) {
        f2 = localPointF3.y;
      }
      i += 1;
      f1 = f2;
    }
    i = 90;
    while (i < 97)
    {
      localPointF3 = pointWithW(localPointF2, localPointF1, new PointF(paramArrayOfFloat[i][0], paramArrayOfFloat[i][1]));
      f2 = f1;
      if (localPointF3.y < f1) {
        f2 = localPointF3.y;
      }
      i += 1;
      f1 = f2;
    }
    float f2 = pointWithW(localPointF2, localPointF1, new PointF(paramArrayOfFloat[0][0], paramArrayOfFloat[0][1])).x;
    float f3 = pointWithW(localPointF2, localPointF1, new PointF(paramArrayOfFloat[18][0], paramArrayOfFloat[18][1])).x;
    float f4 = pointWithW(localPointF2, localPointF1, new PointF(paramArrayOfFloat[9][0], paramArrayOfFloat[9][1])).y;
    PointF localPointF3 = w_pointWithW(localPointF2, localPointF1, new PointF((f2 + f3) * 0.5F, (f1 + f4) * 0.5F));
    Object localObject = w_pointWithW(localPointF2, localPointF1, new PointF((f3 - f2) * 0.6F, 0.0F));
    localObject = new PointF(((PointF)localObject).x - localPointF1.x, ((PointF)localObject).y - localPointF1.y);
    localPointF2 = w_pointWithW(localPointF2, localPointF1, new PointF(0.0F, (f4 - f1) * 0.55F));
    localPointF2 = new PointF(localPointF2.x - localPointF1.x, localPointF2.y - localPointF1.y);
    localPointF1 = new PointF(localPointF3.x, localPointF3.y);
    localPointF3 = new PointF(((PointF)localObject).x, ((PointF)localObject).y);
    localPointF2 = new PointF(localPointF2.x, localPointF2.y);
    paramArrayOfFloat[99][0] = (localPointF1.x - localPointF3.x - localPointF2.x);
    paramArrayOfFloat[99][1] = (localPointF1.y - localPointF3.y - localPointF2.y);
    paramArrayOfFloat[100][0] = (localPointF1.x - localPointF3.x);
    paramArrayOfFloat[100][1] = (localPointF1.y - localPointF3.y);
    paramArrayOfFloat[101][0] = (localPointF1.x - localPointF3.x + localPointF2.x);
    paramArrayOfFloat[101][1] = (localPointF1.y - localPointF3.y + localPointF2.y);
    paramArrayOfFloat[102][0] = (localPointF1.x + localPointF2.x);
    paramArrayOfFloat[102][1] = (localPointF1.y + localPointF2.y);
    paramArrayOfFloat[103][0] = (localPointF1.x + localPointF3.x + localPointF2.x);
    paramArrayOfFloat[103][1] = (localPointF1.y + localPointF3.y + localPointF2.y);
    paramArrayOfFloat[104][0] = (localPointF1.x + localPointF3.x);
    paramArrayOfFloat[104][1] = (localPointF1.y + localPointF3.y);
    paramArrayOfFloat[105][0] = (localPointF1.x + localPointF3.x - localPointF2.x);
    localObject = paramArrayOfFloat[105];
    f1 = localPointF1.y;
    localObject[1] = (localPointF3.y + f1 - localPointF2.y);
    paramArrayOfFloat[106][0] = (localPointF1.x - localPointF2.x);
    paramArrayOfFloat[106][1] = (localPointF1.y - localPointF2.y);
  }
  
  private static PointF pointWithW(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    return new PointF((paramPointF1.x * paramPointF3.x + paramPointF1.y * paramPointF3.y - paramPointF1.x * paramPointF2.x - paramPointF1.y * paramPointF2.y) / (paramPointF1.x * paramPointF1.x + paramPointF1.y * paramPointF1.y), (paramPointF1.x * paramPointF3.y - paramPointF1.y * paramPointF3.x - paramPointF1.x * paramPointF2.y + paramPointF1.y * paramPointF2.x) / (paramPointF1.x * paramPointF1.x + paramPointF1.y * paramPointF1.y));
  }
  
  public static void scale(FaceFeature paramFaceFeature, double paramDouble)
  {
    if (paramFaceFeature == null) {
      return;
    }
    scale(paramFaceFeature.points, paramDouble);
    paramFaceFeature.width = ((int)(paramFaceFeature.width * paramDouble));
    paramFaceFeature.height = ((int)(paramFaceFeature.height * paramDouble));
  }
  
  public static void scale(List<PointF> paramList, double paramDouble)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        PointF localPointF = (PointF)paramList.next();
        localPointF.x = ((float)(localPointF.x * paramDouble));
        localPointF.y = ((float)(localPointF.y * paramDouble));
      }
    }
  }
  
  public static void updateFacePoints(List<PointF> paramList)
  {
    float f1 = AlgoUtils.getDistance((PointF)paramList.get(99), (PointF)paramList.get(105));
    float f2 = AlgoUtils.getDistance((PointF)paramList.get(99), (PointF)paramList.get(101));
    int i = 0;
    while (i < 83)
    {
      float f3 = AlgoUtils.distanceOfPoint2Line((PointF)paramList.get(99), (PointF)paramList.get(101), f2, (PointF)paramList.get(i));
      float f4 = AlgoUtils.distanceOfPoint2Line((PointF)paramList.get(99), (PointF)paramList.get(105), f1, (PointF)paramList.get(i));
      ((PointF)paramList.get(i)).set(1.0F * f3, 1.0F * f4);
      i += 1;
    }
    paramList.subList(83, paramList.size()).clear();
    FaceDetectUtil.facePointf83to90(paramList);
    FaceOffUtil.getFullCoords(paramList, 2.0F);
  }
  
  private static PointF w_pointWithW(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    return new PointF(paramPointF2.x + paramPointF3.x * paramPointF1.x - paramPointF3.y * paramPointF1.y, paramPointF2.y + paramPointF3.x * paramPointF1.y + paramPointF3.y * paramPointF1.x);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.util.CosFunUtil
 * JD-Core Version:    0.7.0.1
 */