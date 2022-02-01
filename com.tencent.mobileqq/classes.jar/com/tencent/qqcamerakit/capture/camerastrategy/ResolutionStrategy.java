package com.tencent.qqcamerakit.capture.camerastrategy;

import com.tencent.qqcamerakit.capture.CameraProxy.CustomPreviewSizeStrategy;
import com.tencent.qqcamerakit.capture.CameraSize;
import com.tencent.qqcamerakit.capture.camera.CameraAbility;
import com.tencent.qqcamerakit.capture.camera2.Camera2Control;
import com.tencent.qqcamerakit.common.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.qqcamerakit.capture.CameraSize;>;

public class ResolutionStrategy
{
  private static double a = 0.009999999776482582D;
  public static CameraProxy.CustomPreviewSizeStrategy a;
  
  public static CameraSize a(List<CameraSize> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getPreviewSizeV2: dstwidth = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("  dstheight = ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.c("ResolutionStrategy", 2, new Object[] { ((StringBuilder)localObject).toString() });
    }
    Object localObject = a(paramList, paramInt1, paramInt2, 2600, 1500, 1700, 1000);
    if (localObject != null)
    {
      if (QLog.a()) {
        QLog.c("ResolutionStrategy", 2, new Object[] { "getPreviewSizeGuaranteeOK: DEFAULT resolution is OK." });
      }
      return localObject;
    }
    localObject = a(paramList, paramInt1, paramInt2, 2600, 1500, 1000, 700);
    if (localObject != null)
    {
      if (QLog.a()) {
        QLog.c("ResolutionStrategy", 2, new Object[] { "getPreviewSizeGuaranteeOK: 720P resolution is OK." });
      }
      return localObject;
    }
    return b(paramList, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private static CameraSize a(List<CameraSize> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (QLog.a())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getHighVersionPreviewSize[wantedPreviewSize]: width=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("  height=");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.c("ResolutionStrategy", 2, new Object[] { ((StringBuilder)localObject1).toString() });
    }
    float f3 = paramInt1 / paramInt2;
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    CameraSize localCameraSize;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      label313:
      while (paramList.hasNext())
      {
        localCameraSize = (CameraSize)paramList.next();
        if (localCameraSize != null)
        {
          int i = Math.max(localCameraSize.a, localCameraSize.b);
          int j = Math.min(localCameraSize.a, localCameraSize.b);
          if ((localCameraSize.b == paramInt2) && (localCameraSize.a == paramInt1))
          {
            ((List)localObject1).add(new CameraSize(paramInt1, paramInt2));
            if (!QLog.a()) {
              break;
            }
            paramList = new StringBuilder();
            paramList.append("getHighVersionPreviewSize first: width = ");
            paramList.append(paramInt1);
            paramList.append("  height = ");
            paramList.append(paramInt2);
            QLog.c("ResolutionStrategy", 2, new Object[] { paramList.toString() });
            break;
          }
          if ((i > paramInt5) && (i < paramInt3))
          {
            if (j > paramInt6)
            {
              if (j >= paramInt4) {
                break label313;
              }
              ((List)localObject2).add(new CameraSize(i, j));
            }
          }
          else {}
        }
      }
    }
    float f1 = 10000.0F;
    float f2 = f1;
    if (((List)localObject1).size() == 0)
    {
      paramList = ((List)localObject2).iterator();
      while (paramList.hasNext())
      {
        localCameraSize = (CameraSize)paramList.next();
        if (localCameraSize != null)
        {
          paramInt1 = Math.max(localCameraSize.a, localCameraSize.b);
          paramInt2 = Math.min(localCameraSize.a, localCameraSize.b);
          f2 = f3 - paramInt1 / paramInt2;
          if (Math.abs(f2) < jdField_a_of_type_Double) {
            ((List)localObject1).add(localCameraSize);
          }
          if (Math.abs(f2) < f1) {
            f1 = Math.abs(f2);
          }
        }
      }
      f2 = f1;
      if (QLog.a())
      {
        paramInt1 = 0;
        for (;;)
        {
          f2 = f1;
          if (paramInt1 >= ((List)localObject1).size()) {
            break;
          }
          paramList = new StringBuilder();
          paramList.append("getHighVersionPreviewSize secend: width = ");
          paramList.append(((CameraSize)((List)localObject1).get(paramInt1)).a);
          paramList.append(" height = ");
          paramList.append(((CameraSize)((List)localObject1).get(paramInt1)).b);
          paramList.append(" w/h = ");
          paramList.append(((CameraSize)((List)localObject1).get(paramInt1)).a / ((CameraSize)((List)localObject1).get(paramInt1)).b);
          QLog.c("ResolutionStrategy", 2, new Object[] { paramList.toString() });
          paramInt1 += 1;
        }
      }
    }
    if (((List)localObject1).size() == 0)
    {
      paramList = ((List)localObject2).iterator();
      while (paramList.hasNext())
      {
        localObject2 = (CameraSize)paramList.next();
        if (localObject2 != null)
        {
          paramInt1 = Math.max(((CameraSize)localObject2).a, ((CameraSize)localObject2).b);
          paramInt2 = Math.min(((CameraSize)localObject2).a, ((CameraSize)localObject2).b);
          if (Math.abs(Math.abs(f3 - paramInt1 / paramInt2) - f2) < jdField_a_of_type_Double) {
            ((List)localObject1).add(localObject2);
          }
        }
      }
      if (QLog.a())
      {
        paramInt1 = 0;
        while (paramInt1 < ((List)localObject1).size())
        {
          paramList = new StringBuilder();
          paramList.append("getHighVersionPreviewSize third: width = ");
          paramList.append(((CameraSize)((List)localObject1).get(paramInt1)).a);
          paramList.append(" height = ");
          paramList.append(((CameraSize)((List)localObject1).get(paramInt1)).b);
          paramList.append(" w/h = ");
          paramList.append(((CameraSize)((List)localObject1).get(paramInt1)).a / ((CameraSize)((List)localObject1).get(paramInt1)).b);
          QLog.c("ResolutionStrategy", 2, new Object[] { paramList.toString() });
          paramInt1 += 1;
        }
      }
    }
    if (((List)localObject1).size() > 0)
    {
      paramList = (CameraSize)((List)localObject1).get(0);
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (CameraSize)((Iterator)localObject2).next();
        if ((localObject1 != null) && (((CameraSize)localObject1).a * ((CameraSize)localObject1).b > paramList.a * paramList.b)) {
          paramList = (List<CameraSize>)localObject1;
        }
      }
      return paramList;
    }
    return null;
  }
  
  public static List<CameraSize> a()
  {
    if (CameraAPIStrategy.a) {
      return Camera2Control.a().a(false);
    }
    return CameraAbility.a().a(false);
  }
  
  public static CameraSize[] a(CameraSize paramCameraSize1, CameraSize paramCameraSize2, CameraSize paramCameraSize3)
  {
    if (QLog.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getPreviewAndPictureSize, viewSize:");
      ((StringBuilder)localObject).append(paramCameraSize1);
      ((StringBuilder)localObject).append(" wantedPreviewSize: ");
      ((StringBuilder)localObject).append(paramCameraSize2);
      ((StringBuilder)localObject).append(" wantedPictureSize: ");
      ((StringBuilder)localObject).append(paramCameraSize3);
      QLog.c("ResolutionStrategy", 2, new Object[] { ((StringBuilder)localObject).toString() });
    }
    CameraSize[] arrayOfCameraSize = new CameraSize[2];
    Object localObject = a();
    CameraProxy.CustomPreviewSizeStrategy localCustomPreviewSizeStrategy = jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy$CustomPreviewSizeStrategy;
    if (localCustomPreviewSizeStrategy != null) {
      localObject = localCustomPreviewSizeStrategy.a((List)localObject, paramCameraSize2.a, paramCameraSize2.b, paramCameraSize1.a, paramCameraSize1.b);
    } else {
      localObject = a((List)localObject, paramCameraSize2.a, paramCameraSize2.b, paramCameraSize1.a, paramCameraSize1.b);
    }
    if (localObject != null)
    {
      arrayOfCameraSize[0] = localObject;
      if (QLog.a())
      {
        boolean bool;
        if (jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy$CustomPreviewSizeStrategy != null) {
          bool = true;
        } else {
          bool = false;
        }
        QLog.c("ResolutionStrategy", 2, new Object[] { "getPreviewSize preview = ", localObject, " customPreviewSizeStrategy:", Boolean.valueOf(bool) });
      }
      int i = paramCameraSize3.a;
      int j = paramCameraSize3.b;
      if (paramCameraSize3.equals(paramCameraSize2))
      {
        i = ((CameraSize)localObject).a;
        j = ((CameraSize)localObject).b;
      }
      paramCameraSize1 = PictureSizeStrategy.a(i, j, paramCameraSize1.a, paramCameraSize1.b, 1);
      if (paramCameraSize1 != null)
      {
        arrayOfCameraSize[1] = paramCameraSize1;
        if (QLog.a())
        {
          QLog.c("ResolutionStrategy", 2, new Object[] { "getPictureSize picture = ", paramCameraSize1 });
          return arrayOfCameraSize;
        }
      }
      else
      {
        QLog.c("ResolutionStrategy", 1, new Object[] { "getPictureSize previewSize null" });
      }
      return arrayOfCameraSize;
    }
    QLog.a("ResolutionStrategy", 1, new Object[] { "getPreviewSize previewSize null" });
    return arrayOfCameraSize;
  }
  
  private static CameraSize b(List<CameraSize> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = paramInt4;
    double d2 = paramInt3;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    boolean bool = QLog.a();
    Object localObject1 = "ResolutionStrategy";
    if (bool)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getPreviewSize[self-adaption] physicRatio = ");
      ((StringBuilder)localObject2).append(d1);
      QLog.c("ResolutionStrategy", 2, new Object[] { ((StringBuilder)localObject2).toString() });
    }
    long l1 = 9223372036854775807L;
    CameraSize localCameraSize = new CameraSize();
    Object localObject2 = localObject1;
    Object localObject3;
    long l2;
    double d3;
    if (paramList != null)
    {
      localObject2 = localObject1;
      if (!paramList.isEmpty())
      {
        localObject3 = paramList.iterator();
        for (;;)
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (CameraSize)((Iterator)localObject3).next();
          if ((localObject2 != null) && (((CameraSize)localObject2).a >= paramInt1) && (((CameraSize)localObject2).b >= paramInt2))
          {
            d2 = ((CameraSize)localObject2).a;
            paramInt3 = ((CameraSize)localObject2).b;
            l2 = l1;
            d3 = paramInt3;
            Double.isNaN(d2);
            Double.isNaN(d3);
            if (d2 / d3 >= d1)
            {
              long l3 = ((CameraSize)localObject2).a * ((CameraSize)localObject2).b;
              if (l3 < l2)
              {
                localCameraSize.a = ((CameraSize)localObject2).a;
                localCameraSize.b = ((CameraSize)localObject2).b;
                l1 = l3;
              }
              else if ((l3 == l2) && (((CameraSize)localObject2).a < localCameraSize.a))
              {
                localCameraSize.a = ((CameraSize)localObject2).a;
                localCameraSize.b = ((CameraSize)localObject2).b;
              }
            }
          }
        }
      }
    }
    if (QLog.a()) {
      QLog.c((String)localObject2, 2, new Object[] { "getPreviewSize[self-adaption] have no resolution >= (w*h)" });
    }
    l1 = 0L;
    if (((localCameraSize.a <= 0) || (localCameraSize.b <= 0)) && (paramList != null) && (!paramList.isEmpty()))
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (CameraSize)((Iterator)localObject1).next();
        if (localObject3 != null)
        {
          d2 = ((CameraSize)localObject3).a;
          d3 = ((CameraSize)localObject3).b;
          Double.isNaN(d2);
          Double.isNaN(d3);
          if (d2 / d3 >= d1)
          {
            l2 = ((CameraSize)localObject3).a * ((CameraSize)localObject3).b;
            if (l2 > l1)
            {
              localCameraSize.a = ((CameraSize)localObject3).a;
              localCameraSize.b = ((CameraSize)localObject3).b;
              l1 = l2;
            }
            else if ((l2 == l1) && (((CameraSize)localObject3).a < localCameraSize.a))
            {
              localCameraSize.a = ((CameraSize)localObject3).a;
              localCameraSize.b = ((CameraSize)localObject3).b;
            }
          }
        }
      }
    }
    if (QLog.a())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getPreviewSize[self-adaption] cSize.width=");
      ((StringBuilder)localObject1).append(localCameraSize.a);
      ((StringBuilder)localObject1).append("  cSize.height=");
      ((StringBuilder)localObject1).append(localCameraSize.b);
      QLog.c((String)localObject2, 2, new Object[] { ((StringBuilder)localObject1).toString() });
    }
    if ((localCameraSize.a > 0) && (localCameraSize.b > 0)) {
      return localCameraSize;
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.get(0) != null))
    {
      localCameraSize.a = ((CameraSize)paramList.get(0)).a;
      localCameraSize.b = ((CameraSize)paramList.get(0)).b;
      return localCameraSize;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camerastrategy.ResolutionStrategy
 * JD-Core Version:    0.7.0.1
 */