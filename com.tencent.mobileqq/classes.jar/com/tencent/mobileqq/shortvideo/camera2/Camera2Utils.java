package com.tencent.mobileqq.shortvideo.camera2;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize;>;

@TargetApi(21)
public class Camera2Utils
{
  public static int a(CameraCharacteristics paramCameraCharacteristics, int paramInt)
  {
    int i = paramInt;
    if (paramInt == -1) {
      i = 0;
    }
    paramInt = (i + 45) / 90 * 90;
    i = ((Integer)paramCameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
    paramCameraCharacteristics = (Integer)paramCameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
    if ((paramCameraCharacteristics != null) && (paramCameraCharacteristics.intValue() == 0)) {
      return (i - paramInt + 360) % 360;
    }
    return (i + paramInt) % 360;
  }
  
  @TargetApi(21)
  private static CameraControl.CustomSize a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Camera2Control.Camera2Info paramCamera2Info)
  {
    if (paramCamera2Info != null) {}
    Object localObject2;
    for (;;)
    {
      float f2;
      try
      {
        if (paramCamera2Info.a())
        {
          paramCamera2Info = (StreamConfigurationMap)paramCamera2Info.b.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
          if (paramCamera2Info == null)
          {
            a(2, "[Camera2]getPictureSize map null!");
            return null;
          }
          localObject1 = new CameraControl.CustomSize();
          localObject2 = paramCamera2Info.getOutputSizes(256);
          if ((localObject2 != null) && (localObject2.length > 0))
          {
            paramCamera2Info = new ArrayList();
            int j = localObject2.length;
            int i = 0;
            if (i < j)
            {
              localArrayList = localObject2[i];
              paramCamera2Info.add(new CameraControl.CustomSize(localArrayList.getWidth(), localArrayList.getHeight()));
              i += 1;
              continue;
            }
            localObject2 = new CameraControl.CustomSize();
            f1 = 10000.0F;
            i = Math.min(paramInt1, paramInt2);
            paramInt1 = Math.max(paramInt1, paramInt2);
            float f3 = paramInt1 / i;
            ArrayList localArrayList = new ArrayList();
            Iterator localIterator = paramCamera2Info.iterator();
            boolean bool = localIterator.hasNext();
            if (bool)
            {
              CameraControl.CustomSize localCustomSize = (CameraControl.CustomSize)localIterator.next();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("[Camera2] setPictureSize[list]: width=");
              localStringBuilder.append(localCustomSize.a);
              localStringBuilder.append(" height=");
              localStringBuilder.append(localCustomSize.b);
              localStringBuilder.append(" w/h=");
              localStringBuilder.append(localCustomSize.a / localCustomSize.b);
              a(1, localStringBuilder.toString());
              float f4 = localCustomSize.a / localCustomSize.b - f3;
              if (Math.abs(f4) <= CameraControl.c) {
                localArrayList.add(localCustomSize);
              }
              f2 = f1;
              if (localCustomSize.a >= paramInt1)
              {
                f2 = f1;
                if (f1 > Math.abs(f4))
                {
                  f2 = Math.abs(f4);
                  ((CameraControl.CustomSize)localObject2).a = localCustomSize.a;
                  ((CameraControl.CustomSize)localObject2).b = localCustomSize.b;
                }
              }
            }
            else
            {
              if ((localArrayList.isEmpty()) && (((CameraControl.CustomSize)localObject2).a >= paramInt1))
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                paramCamera2Info = new StringBuilder();
                paramCamera2Info.append("[Camera2]getPictureSize: width=");
                paramCamera2Info.append(((CameraControl.CustomSize)localObject2).a);
                paramCamera2Info.append(" height=");
                paramCamera2Info.append(((CameraControl.CustomSize)localObject2).b);
                paramCamera2Info.append(" w/h=");
                paramCamera2Info.append(((CameraControl.CustomSize)localObject2).a / ((CameraControl.CustomSize)localObject2).b);
                QLog.i("Camera2Control", 2, paramCamera2Info.toString());
                return localObject2;
              }
              if ((localArrayList.isEmpty()) && (paramCamera2Info.size() > 0))
              {
                ((CameraControl.CustomSize)localObject1).a = ((CameraControl.CustomSize)paramCamera2Info.get(0)).a;
                ((CameraControl.CustomSize)localObject1).b = ((CameraControl.CustomSize)paramCamera2Info.get(0)).b;
                return localObject1;
              }
              if (localArrayList.isEmpty()) {
                return null;
              }
              if (paramInt5 == -1)
              {
                localObject2 = localArrayList.iterator();
                paramCamera2Info = (Camera2Control.Camera2Info)localObject1;
                if (((Iterator)localObject2).hasNext())
                {
                  paramCamera2Info = (CameraControl.CustomSize)((Iterator)localObject2).next();
                  if (((CameraControl.CustomSize)localObject1).a >= paramCamera2Info.a) {
                    continue;
                  }
                  ((CameraControl.CustomSize)localObject1).a = paramCamera2Info.a;
                  ((CameraControl.CustomSize)localObject1).b = paramCamera2Info.b;
                  continue;
                }
              }
              else
              {
                paramCamera2Info = a(paramInt3, paramInt4, paramInt5, localArrayList);
              }
              if (paramCamera2Info.a != 0) {
                break label751;
              }
              return null;
            }
          }
          else
          {
            a(2, "[Camera2]getPictureSize outPutSizes null!");
            return null;
          }
        }
        else
        {
          a(2, "[Camera2]getPictureSize camera2Info null!");
          return null;
        }
      }
      catch (Exception paramCamera2Info)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[Camera2]getPictureSize");
        ((StringBuilder)localObject1).append(paramCamera2Info);
        a(2, ((StringBuilder)localObject1).toString());
        return null;
      }
      float f1 = f2;
    }
    return localObject2;
    label751:
    return paramCamera2Info;
  }
  
  public static CameraControl.CustomSize a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, Camera2Control.Camera2Info paramCamera2Info)
  {
    if (paramCamera2Info != null) {}
    for (;;)
    {
      Object localObject1;
      int j;
      try
      {
        if (paramCamera2Info.a())
        {
          localObject1 = (StreamConfigurationMap)paramCamera2Info.b.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
          paramCamera2Info = new ArrayList();
          localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
          j = 0;
          int i;
          if (localObject1 != null)
          {
            int k = localObject1.length;
            i = 0;
            if (i < k)
            {
              Object localObject2 = localObject1[i];
              paramCamera2Info.add(new CameraControl.CustomSize(localObject2.getWidth(), localObject2.getHeight()));
              i += 1;
              continue;
            }
          }
          if (paramCamera2Info.size() > 0)
          {
            i = 0;
            if (i < paramCamera2Info.size())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("[Camera2] getPreviewSizeV2 sizeGuaranteeOK[list]: width=");
              ((StringBuilder)localObject1).append(((CameraControl.CustomSize)paramCamera2Info.get(i)).a);
              ((StringBuilder)localObject1).append(" height=");
              ((StringBuilder)localObject1).append(((CameraControl.CustomSize)paramCamera2Info.get(i)).b);
              ((StringBuilder)localObject1).append(" w/h=");
              ((StringBuilder)localObject1).append(((CameraControl.CustomSize)paramCamera2Info.get(i)).a / ((CameraControl.CustomSize)paramCamera2Info.get(i)).b);
              a(1, ((StringBuilder)localObject1).toString());
              i += 1;
              continue;
            }
          }
          localObject1 = a(paramCamera2Info, paramInt1, paramInt2);
          if (localObject1 != null)
          {
            if (!QLog.isColorLevel()) {
              break label455;
            }
            paramCamera2Info = new StringBuilder();
            paramCamera2Info.append("[Camera2] getPreviewSizeV2 sizeGuaranteeOK: DEFAULT resolution os OK. size:");
            paramCamera2Info.append(((CameraControl.CustomSize)localObject1).toString());
            QLog.i("Camera2Control", 2, paramCamera2Info.toString());
            return localObject1;
          }
          localObject1 = a(paramCamera2Info, 960, 720);
          if (localObject1 != null)
          {
            if (!QLog.isColorLevel()) {
              break label458;
            }
            QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: 640*480 resolution os OK.");
            return localObject1;
          }
          paramCamera2Info = a(paramCamera2Info, paramInt1, paramInt2, paramInt3, paramInt4);
          if (!paramBoolean) {
            break;
          }
          if (paramCamera2Info == null)
          {
            paramInt3 = 0;
            break label461;
          }
          paramInt3 = paramCamera2Info.a;
          break label461;
          paramInt4 = paramCamera2Info.b;
          NewFlowCameraReporter.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
          return paramCamera2Info;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[Camera2]getPreviewSizeV2 camera2Info: ");
        ((StringBuilder)localObject1).append(paramCamera2Info);
        a(2, ((StringBuilder)localObject1).toString());
        return null;
      }
      catch (Exception paramCamera2Info)
      {
        continue;
      }
      a(2, "[Camera2] getPreviewSizeV2 exception!");
      return null;
      label455:
      return localObject1;
      label458:
      return localObject1;
      label461:
      if (paramCamera2Info == null) {
        paramInt4 = j;
      }
    }
    return paramCamera2Info;
  }
  
  private static CameraControl.CustomSize a(int paramInt1, int paramInt2, int paramInt3, List<CameraControl.CustomSize> paramList)
  {
    paramInt3 = Math.max(paramInt1 * paramInt3, paramInt2 * paramInt3);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setParamsPictureSize targetWidth ");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.i("Camera2Control", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new CameraControl.CustomSize(0, 0);
    paramInt1 = 2147483647;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CameraControl.CustomSize localCustomSize = (CameraControl.CustomSize)paramList.next();
      paramInt2 = Math.abs(localCustomSize.a - paramInt3);
      if (paramInt1 > paramInt2)
      {
        ((CameraControl.CustomSize)localObject).a = localCustomSize.a;
        ((CameraControl.CustomSize)localObject).b = localCustomSize.b;
        paramInt1 = paramInt2;
      }
    }
    return localObject;
  }
  
  private static CameraControl.CustomSize a(List<CameraControl.CustomSize> paramList, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Camera2] getHighVersionPreviewSize[wantedPreviewSize]: width=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("  height=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("Camera2Control", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new CameraControl.CustomSize();
    int i = -1;
    int j = i;
    if (paramList != null)
    {
      j = i;
      if (!paramList.isEmpty())
      {
        paramList = paramList.iterator();
        for (;;)
        {
          j = i;
          if (!paramList.hasNext()) {
            break;
          }
          CameraControl.CustomSize localCustomSize = (CameraControl.CustomSize)paramList.next();
          if ((localCustomSize != null) && (localCustomSize.b == paramInt2) && (localCustomSize.a >= paramInt1) && ((i < 0) || (localCustomSize.a <= i))) {
            i = localCustomSize.a;
          }
        }
      }
    }
    if (j > 0)
    {
      ((CameraControl.CustomSize)localObject).b = paramInt2;
      ((CameraControl.CustomSize)localObject).a = j;
      if (((CameraControl.CustomSize)localObject).a / 4 == ((CameraControl.CustomSize)localObject).b / 3)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[4:3]...");
        }
        return localObject;
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("[Camera2] getHighVersionPreviewSize: RATIO_MUST_EQUAL cSize:");
        paramList.append(((CameraControl.CustomSize)localObject).toString());
        QLog.i("Camera2Control", 2, paramList.toString());
      }
      return localObject;
    }
    return null;
  }
  
  private static CameraControl.CustomSize a(List<CameraControl.CustomSize> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = paramInt4;
    double d2 = paramInt3;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[Camera2] getPreviewSize[self-adaption] physicRatio=");
      ((StringBuilder)localObject1).append(d1);
      QLog.i("Camera2Control", 2, ((StringBuilder)localObject1).toString());
    }
    long l1 = 9223372036854775807L;
    Object localObject1 = new CameraControl.CustomSize();
    Object localObject2;
    CameraControl.CustomSize localCustomSize;
    double d3;
    long l2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localCustomSize = (CameraControl.CustomSize)((Iterator)localObject2).next();
        if ((localCustomSize != null) && (localCustomSize.a >= paramInt1) && (localCustomSize.b >= paramInt2))
        {
          d2 = localCustomSize.a;
          d3 = localCustomSize.b;
          Double.isNaN(d2);
          Double.isNaN(d3);
          if (d2 / d3 >= d1)
          {
            l2 = localCustomSize.a * localCustomSize.b;
            if (l2 < l1)
            {
              ((CameraControl.CustomSize)localObject1).a = localCustomSize.a;
              ((CameraControl.CustomSize)localObject1).b = localCustomSize.b;
              l1 = l2;
            }
            else if ((l2 == l1) && (localCustomSize.a < ((CameraControl.CustomSize)localObject1).a))
            {
              ((CameraControl.CustomSize)localObject1).a = localCustomSize.a;
              ((CameraControl.CustomSize)localObject1).b = localCustomSize.b;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] have no resolution >= (w*h)");
    }
    l1 = 0L;
    if (((((CameraControl.CustomSize)localObject1).a <= 0) || (((CameraControl.CustomSize)localObject1).b <= 0)) && (paramList != null) && (!paramList.isEmpty()))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localCustomSize = (CameraControl.CustomSize)((Iterator)localObject2).next();
        if (localCustomSize != null)
        {
          d2 = localCustomSize.a;
          d3 = localCustomSize.b;
          Double.isNaN(d2);
          Double.isNaN(d3);
          if (d2 / d3 >= d1)
          {
            l2 = localCustomSize.a * localCustomSize.b;
            if (l2 > l1)
            {
              ((CameraControl.CustomSize)localObject1).a = localCustomSize.a;
              ((CameraControl.CustomSize)localObject1).b = localCustomSize.b;
              l1 = l2;
            }
            else if ((l2 == l1) && (localCustomSize.a < ((CameraControl.CustomSize)localObject1).a))
            {
              ((CameraControl.CustomSize)localObject1).a = localCustomSize.a;
              ((CameraControl.CustomSize)localObject1).b = localCustomSize.b;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[Camera2] getPreviewSize[self-adaption] cSize.width=");
      ((StringBuilder)localObject2).append(((CameraControl.CustomSize)localObject1).a);
      ((StringBuilder)localObject2).append("  cSize.height=");
      ((StringBuilder)localObject2).append(((CameraControl.CustomSize)localObject1).b);
      QLog.i("Camera2Control", 2, ((StringBuilder)localObject2).toString());
    }
    if ((((CameraControl.CustomSize)localObject1).a > 0) && (((CameraControl.CustomSize)localObject1).b > 0)) {
      return localObject1;
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.get(0) != null))
    {
      ((CameraControl.CustomSize)localObject1).a = ((CameraControl.CustomSize)paramList.get(0)).a;
      ((CameraControl.CustomSize)localObject1).b = ((CameraControl.CustomSize)paramList.get(0)).b;
      return localObject1;
    }
    return null;
  }
  
  private static CameraControl.CustomSize a(List<CameraControl.CustomSize> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[@] getHighVersionPreviewSizeV3[wantedPreviewSize]: width=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("  height=");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.i("Camera2Control", 2, ((StringBuilder)localObject1).toString());
    }
    float f3 = paramInt1 / paramInt2;
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    CameraControl.CustomSize localCustomSize;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localCustomSize = (CameraControl.CustomSize)paramList.next();
        if (localCustomSize != null)
        {
          int i = Math.max(localCustomSize.a, localCustomSize.b);
          int j = Math.min(localCustomSize.a, localCustomSize.b);
          if ((localCustomSize.b == paramInt2) && (i == paramInt1))
          {
            ((List)localObject1).add(new CameraControl.CustomSize(paramInt1, paramInt2));
            if (!QLog.isColorLevel()) {
              break;
            }
            paramList = new StringBuilder();
            paramList.append("[@] getHighVersionPreviewSizeV3 first: width=");
            paramList.append(paramInt1);
            paramList.append("  height=");
            paramList.append(paramInt2);
            QLog.i("Camera2Control", 2, paramList.toString());
            break;
          }
          if ((i > paramInt5) && (i < paramInt3))
          {
            if (j > paramInt6)
            {
              if (j >= paramInt4) {
                continue;
              }
              ((List)localObject2).add(new CameraControl.CustomSize(i, j));
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
        localCustomSize = (CameraControl.CustomSize)paramList.next();
        if (localCustomSize != null)
        {
          paramInt1 = Math.max(localCustomSize.a, localCustomSize.b);
          paramInt2 = Math.min(localCustomSize.a, localCustomSize.b);
          f2 = f3 - paramInt1 / paramInt2;
          if (Math.abs(f2) < CameraControl.c) {
            ((List)localObject1).add(localCustomSize);
          }
          if (Math.abs(f2) < f1) {
            f1 = Math.abs(f2);
          }
        }
      }
      f2 = f1;
      if (QLog.isColorLevel())
      {
        paramInt1 = 0;
        for (;;)
        {
          f2 = f1;
          if (paramInt1 >= ((List)localObject1).size()) {
            break;
          }
          paramList = new StringBuilder();
          paramList.append("[@] getHighVersionPreviewSizeV3 secend: width=");
          paramList.append(((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).a);
          paramList.append(" height=");
          paramList.append(((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).b);
          paramList.append(" w/h=");
          paramList.append(((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).a / ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).b);
          QLog.i("Camera2Control", 2, paramList.toString());
          paramInt1 += 1;
        }
      }
    }
    if (((List)localObject1).size() == 0)
    {
      paramList = ((List)localObject2).iterator();
      while (paramList.hasNext())
      {
        localObject2 = (CameraControl.CustomSize)paramList.next();
        if (localObject2 != null)
        {
          paramInt1 = Math.max(((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b);
          paramInt2 = Math.min(((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b);
          if (Math.abs(Math.abs(f3 - paramInt1 / paramInt2) - f2) < CameraControl.c) {
            ((List)localObject1).add(localObject2);
          }
        }
      }
      if (QLog.isColorLevel())
      {
        paramInt1 = 0;
        while (paramInt1 < ((List)localObject1).size())
        {
          paramList = new StringBuilder();
          paramList.append("[@] getHighVersionPreviewSizeV3 third: width=");
          paramList.append(((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).a);
          paramList.append(" height=");
          paramList.append(((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).b);
          paramList.append(" w/h=");
          paramList.append(((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).a / ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).b);
          QLog.i("Camera2Control", 2, paramList.toString());
          paramInt1 += 1;
        }
      }
    }
    if (((List)localObject1).size() > 0)
    {
      paramList = (CameraControl.CustomSize)((List)localObject1).get(0);
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (CameraControl.CustomSize)((Iterator)localObject2).next();
        if ((localObject1 != null) && (((CameraControl.CustomSize)localObject1).a * ((CameraControl.CustomSize)localObject1).b > paramList.a * paramList.b)) {
          paramList = (List<CameraControl.CustomSize>)localObject1;
        }
      }
      return paramList;
    }
    return null;
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (paramInt == 1)
    {
      QLog.w("Camera2Control", 1, paramString);
      return;
    }
    if (paramInt == 2) {
      QLog.e("Camera2Control", 1, paramString);
    }
  }
  
  public static CameraControl.CustomSize[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Camera2Control.Camera2Info paramCamera2Info)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[Camera2] getPreviewAndPictureSizeV2 wanted size=");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(" cliped=");
    ((StringBuilder)localObject1).append(paramInt3);
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(paramInt4);
    a(1, ((StringBuilder)localObject1).toString());
    localObject1 = new CameraControl.CustomSize[2];
    Object localObject2 = a(paramInt1, paramInt2, paramInt3, paramInt4, true, paramCamera2Info);
    if (localObject2 != null)
    {
      localObject1[0] = localObject2;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 preview=");
      localStringBuilder.append(((CameraControl.CustomSize)localObject2).a);
      localStringBuilder.append(" ");
      localStringBuilder.append(((CameraControl.CustomSize)localObject2).b);
      a(1, localStringBuilder.toString());
      paramCamera2Info = a(((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b, paramInt3, paramInt4, 1, paramCamera2Info);
      localObject1[1] = paramCamera2Info;
      if (paramCamera2Info != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 picture=");
        ((StringBuilder)localObject2).append(paramCamera2Info.a);
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append(paramCamera2Info.b);
        a(1, ((StringBuilder)localObject2).toString());
      }
    }
    return localObject1;
  }
  
  @TargetApi(21)
  private static CameraControl.CustomSize b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, Camera2Control.Camera2Info paramCamera2Info)
  {
    if (paramCamera2Info != null) {}
    for (;;)
    {
      Object localObject1;
      int j;
      try
      {
        if (paramCamera2Info.a())
        {
          localObject1 = (StreamConfigurationMap)paramCamera2Info.b.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
          paramCamera2Info = new ArrayList();
          localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
          if (localObject1 == null) {
            return null;
          }
          int k = localObject1.length;
          j = 0;
          int i = 0;
          if (i < k)
          {
            Object localObject2 = localObject1[i];
            paramCamera2Info.add(new CameraControl.CustomSize(localObject2.getWidth(), localObject2.getHeight()));
            i += 1;
            continue;
          }
          if (paramCamera2Info.size() > 0)
          {
            i = 0;
            if (i < paramCamera2Info.size())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("[Camera2] getPreviewSizeV3 sizeGuaranteeOK[list]: width=");
              ((StringBuilder)localObject1).append(((CameraControl.CustomSize)paramCamera2Info.get(i)).a);
              ((StringBuilder)localObject1).append(" height=");
              ((StringBuilder)localObject1).append(((CameraControl.CustomSize)paramCamera2Info.get(i)).b);
              ((StringBuilder)localObject1).append(" w/h=");
              ((StringBuilder)localObject1).append(((CameraControl.CustomSize)paramCamera2Info.get(i)).a / ((CameraControl.CustomSize)paramCamera2Info.get(i)).b);
              a(1, ((StringBuilder)localObject1).toString());
              i += 1;
              continue;
            }
          }
          localObject1 = a(paramCamera2Info, paramInt1, paramInt2, 2600, 1500, 1700, 1000);
          if (localObject1 != null)
          {
            if (QLog.isColorLevel())
            {
              paramCamera2Info = new StringBuilder();
              paramCamera2Info.append("[Camera2] getPreviewSizeV3 SizeGuaranteeOK: DEFAULT resolution os OK. size:");
              paramCamera2Info.append(localObject1);
              QLog.i("Camera2Control", 2, paramCamera2Info.toString());
            }
            if (paramBoolean)
            {
              NewFlowCameraReporter.a(2, paramInt1, paramInt2, ((CameraControl.CustomSize)localObject1).a, ((CameraControl.CustomSize)localObject1).b);
              return localObject1;
            }
          }
          else
          {
            localObject1 = a(paramCamera2Info, paramInt1, paramInt2, 2600, 1500, 1000, 700);
            if (localObject1 != null)
            {
              if (QLog.isColorLevel())
              {
                paramCamera2Info = new StringBuilder();
                paramCamera2Info.append("[Camera2] getPreviewSizeV3 SizeGuaranteeOK: 640*480 resolution os OK. size:");
                paramCamera2Info.append(localObject1);
                QLog.i("Camera2Control", 2, paramCamera2Info.toString());
              }
              if (!paramBoolean) {
                break label585;
              }
              NewFlowCameraReporter.a(3, paramInt1, paramInt2, ((CameraControl.CustomSize)localObject1).a, ((CameraControl.CustomSize)localObject1).b);
              return localObject1;
            }
            paramCamera2Info = a(paramCamera2Info, paramInt1, paramInt2, paramInt3, paramInt4);
            if (paramBoolean)
            {
              if (paramCamera2Info == null)
              {
                paramInt3 = 0;
                break label588;
              }
              paramInt3 = paramCamera2Info.a;
              break label588;
              paramInt4 = paramCamera2Info.b;
              NewFlowCameraReporter.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[Camera2] getPreviewSizeGuaranteeOK: getPreviewSize. size:");
            ((StringBuilder)localObject1).append(paramCamera2Info);
            QLog.i("Camera2Control", 2, ((StringBuilder)localObject1).toString());
            return paramCamera2Info;
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[Camera2]getPreviewSizeV3 camera2Info: ");
          ((StringBuilder)localObject1).append(paramCamera2Info);
          a(2, ((StringBuilder)localObject1).toString());
          return null;
        }
      }
      catch (Exception paramCamera2Info)
      {
        return null;
      }
      return localObject1;
      label585:
      return localObject1;
      label588:
      if (paramCamera2Info == null) {
        paramInt4 = j;
      }
    }
    return paramCamera2Info;
  }
  
  public static CameraControl.CustomSize[] b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Camera2Control.Camera2Info paramCamera2Info)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[Camera2] getPreviewAndPictureSizeV3 wanted size=");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(" cliped=");
    ((StringBuilder)localObject1).append(paramInt3);
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(paramInt4);
    a(1, ((StringBuilder)localObject1).toString());
    if (paramCamera2Info == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[Camera2] getPreviewAndPictureSizeV3 camera2Info:");
      ((StringBuilder)localObject1).append(paramCamera2Info);
      a(2, ((StringBuilder)localObject1).toString());
      return null;
    }
    localObject1 = new CameraControl.CustomSize[2];
    Object localObject2 = b(paramInt1, paramInt2, paramInt3, paramInt4, true, paramCamera2Info);
    if (localObject2 != null)
    {
      localObject1[0] = localObject2;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 preview=");
      localStringBuilder.append(((CameraControl.CustomSize)localObject2).a);
      localStringBuilder.append(" ");
      localStringBuilder.append(((CameraControl.CustomSize)localObject2).b);
      a(1, localStringBuilder.toString());
      paramCamera2Info = a(((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b, paramInt3, paramInt4, 1, paramCamera2Info);
      localObject1[1] = paramCamera2Info;
      if (paramCamera2Info != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 picture=");
        ((StringBuilder)localObject2).append(paramCamera2Info.a);
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append(paramCamera2Info.b);
        a(1, ((StringBuilder)localObject2).toString());
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Utils
 * JD-Core Version:    0.7.0.1
 */