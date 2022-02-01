package com.tencent.qqcamerakit.capture.camerastrategy;

import com.tencent.qqcamerakit.capture.CameraSize;
import com.tencent.qqcamerakit.capture.camera.CameraAbility;
import com.tencent.qqcamerakit.capture.camera2.Camera2Control;
import com.tencent.qqcamerakit.common.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PictureSizeStrategy
{
  private static double a = 0.009999999776482582D;
  
  protected static CameraSize a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject1 = a();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      int i = Math.min(paramInt1, paramInt2);
      paramInt1 = Math.max(paramInt1, paramInt2);
      float f = paramInt1 / i;
      double d1 = 10000.0D;
      Object localObject2 = new ArrayList();
      CameraSize localCameraSize1 = new CameraSize();
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        CameraSize localCameraSize2 = (CameraSize)localIterator.next();
        if (localCameraSize2 != null)
        {
          if (QLog.a())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getPictureSize[list]: ");
            localStringBuilder.append(localCameraSize2);
            QLog.c("PictureSizeStrategy", 2, new Object[] { localStringBuilder.toString() });
          }
          double d3 = localCameraSize2.a();
          double d2 = f;
          Double.isNaN(d2);
          if (Math.abs(d3 - d2) <= a) {
            ((List)localObject2).add(localCameraSize2);
          }
          if (localCameraSize2.a >= paramInt1)
          {
            d3 = localCameraSize2.a();
            Double.isNaN(d2);
            if (d1 > Math.abs(d3 - d2))
            {
              d1 = localCameraSize2.a();
              Double.isNaN(d2);
              d1 = Math.abs(d1 - d2);
              localCameraSize1.a = localCameraSize2.a;
              localCameraSize1.b = localCameraSize2.b;
            }
          }
        }
      }
      if ((((List)localObject2).isEmpty()) && (localCameraSize1.a >= paramInt1))
      {
        if (QLog.a())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getPictureSize: ");
          ((StringBuilder)localObject1).append(localCameraSize1);
          QLog.c("PictureSizeStrategy", 2, new Object[] { ((StringBuilder)localObject1).toString() });
        }
        return localCameraSize1;
      }
      localCameraSize1 = new CameraSize();
      if ((((List)localObject2).isEmpty()) && (((List)localObject1).size() > 0))
      {
        localCameraSize1.a = ((CameraSize)((List)localObject1).get(0)).a;
        localCameraSize1.b = ((CameraSize)((List)localObject1).get(0)).b;
        return localCameraSize1;
      }
      if (((List)localObject2).isEmpty()) {
        return null;
      }
      if (paramInt5 == -1)
      {
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          localObject1 = localCameraSize1;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (CameraSize)((Iterator)localObject2).next();
          if (localCameraSize1.a < ((CameraSize)localObject1).a)
          {
            localCameraSize1.a = ((CameraSize)localObject1).a;
            localCameraSize1.b = ((CameraSize)localObject1).b;
          }
        }
      }
      localObject1 = a(paramInt3, paramInt4, paramInt5, (List)localObject2);
      if (((CameraSize)localObject1).a == 0) {
        return null;
      }
      return localObject1;
    }
    return null;
  }
  
  private static CameraSize a(int paramInt1, int paramInt2, int paramInt3, List<CameraSize> paramList)
  {
    paramInt3 = Math.max(paramInt1 * paramInt3, paramInt2 * paramInt3);
    if (QLog.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setParamsPictureSize targetWidth ");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.c("PictureSizeStrategy", 2, new Object[] { ((StringBuilder)localObject).toString() });
    }
    Object localObject = new CameraSize(0, 0);
    paramInt1 = 2147483647;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CameraSize localCameraSize = (CameraSize)paramList.next();
      paramInt2 = Math.abs(localCameraSize.a - paramInt3);
      if (paramInt1 > paramInt2)
      {
        ((CameraSize)localObject).a = localCameraSize.a;
        ((CameraSize)localObject).b = localCameraSize.b;
        paramInt1 = paramInt2;
      }
    }
    return localObject;
  }
  
  public static List<CameraSize> a()
  {
    if (CameraAPIStrategy.a) {
      return Camera2Control.a().a(true);
    }
    return CameraAbility.a().a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camerastrategy.PictureSizeStrategy
 * JD-Core Version:    0.7.0.1
 */