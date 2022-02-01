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
      ArrayList localArrayList;
      float f2;
      try
      {
        if (!paramCamera2Info.a())
        {
          a(2, "[Camera2]getPictureSize camera2Info null!");
          return null;
        }
        Object localObject1 = (StreamConfigurationMap)paramCamera2Info.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (localObject1 == null)
        {
          a(2, "[Camera2]getPictureSize map null!");
          return null;
        }
        paramCamera2Info = new CameraControl.CustomSize();
        localObject2 = ((StreamConfigurationMap)localObject1).getOutputSizes(256);
        if ((localObject2 == null) || (localObject2.length <= 0))
        {
          a(2, "[Camera2]getPictureSize outPutSizes null!");
          return null;
        }
        localObject1 = new ArrayList();
        int j = localObject2.length;
        int i = 0;
        if (i < j)
        {
          localArrayList = localObject2[i];
          ((List)localObject1).add(new CameraControl.CustomSize(localArrayList.getWidth(), localArrayList.getHeight()));
          i += 1;
          continue;
        }
        localObject2 = new CameraControl.CustomSize();
        f1 = 10000.0F;
        i = Math.min(paramInt1, paramInt2);
        paramInt1 = Math.max(paramInt1, paramInt2);
        float f3 = paramInt1 / i;
        localArrayList = new ArrayList();
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          CameraControl.CustomSize localCustomSize = (CameraControl.CustomSize)localIterator.next();
          a(1, "[Camera2] setPictureSize[list]: width=" + localCustomSize.a + " height=" + localCustomSize.b + " w/h=" + localCustomSize.a / localCustomSize.b);
          float f4 = localCustomSize.a / localCustomSize.b;
          if (Math.abs(f4 - f3) <= CameraControl.a) {
            localArrayList.add(localCustomSize);
          }
          f2 = f1;
          if (localCustomSize.a < paramInt1) {
            break label685;
          }
          f2 = f1;
          if (f1 <= Math.abs(f4 - f3)) {
            break label685;
          }
          f2 = Math.abs(f4 - f3);
          ((CameraControl.CustomSize)localObject2).a = localCustomSize.a;
          ((CameraControl.CustomSize)localObject2).b = localCustomSize.b;
          break label685;
        }
        if ((localArrayList.isEmpty()) && (((CameraControl.CustomSize)localObject2).a >= paramInt1))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Camera2Control", 2, "[Camera2]getPictureSize: width=" + ((CameraControl.CustomSize)localObject2).a + " height=" + ((CameraControl.CustomSize)localObject2).b + " w/h=" + ((CameraControl.CustomSize)localObject2).a / ((CameraControl.CustomSize)localObject2).b);
          break;
        }
        if ((localArrayList.isEmpty()) && (((List)localObject1).size() > 0))
        {
          paramCamera2Info.a = ((CameraControl.CustomSize)((List)localObject1).get(0)).a;
          paramCamera2Info.b = ((CameraControl.CustomSize)((List)localObject1).get(0)).b;
          return paramCamera2Info;
        }
        if (localArrayList.isEmpty()) {
          return null;
        }
        if (paramInt5 == -1)
        {
          localObject1 = localArrayList.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (CameraControl.CustomSize)((Iterator)localObject1).next();
            if (paramCamera2Info.a >= ((CameraControl.CustomSize)localObject2).a) {
              continue;
            }
            paramCamera2Info.a = ((CameraControl.CustomSize)localObject2).a;
            paramCamera2Info.b = ((CameraControl.CustomSize)localObject2).b;
            continue;
          }
          if (paramCamera2Info.a != 0) {
            break label682;
          }
        }
      }
      catch (Exception paramCamera2Info)
      {
        a(2, "[Camera2]getPictureSize" + paramCamera2Info);
        return null;
      }
      for (;;)
      {
        return null;
        paramCamera2Info = a(paramInt3, paramInt4, paramInt5, localArrayList);
      }
      label682:
      return paramCamera2Info;
      label685:
      float f1 = f2;
    }
    return localObject2;
  }
  
  public static CameraControl.CustomSize a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, Camera2Control.Camera2Info paramCamera2Info)
  {
    int j = 0;
    if (paramCamera2Info != null) {}
    try
    {
      if (!paramCamera2Info.a())
      {
        a(2, "[Camera2]getPreviewSizeV2 camera2Info: " + paramCamera2Info);
        return null;
      }
      localObject1 = (StreamConfigurationMap)paramCamera2Info.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      paramCamera2Info = new ArrayList();
      localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
      int i;
      if (localObject1 != null)
      {
        int k = localObject1.length;
        i = 0;
        while (i < k)
        {
          Object localObject2 = localObject1[i];
          paramCamera2Info.add(new CameraControl.CustomSize(localObject2.getWidth(), localObject2.getHeight()));
          i += 1;
        }
      }
      if (paramCamera2Info.size() > 0)
      {
        i = 0;
        while (i < paramCamera2Info.size())
        {
          a(1, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK[list]: width=" + ((CameraControl.CustomSize)paramCamera2Info.get(i)).a + " height=" + ((CameraControl.CustomSize)paramCamera2Info.get(i)).b + " w/h=" + ((CameraControl.CustomSize)paramCamera2Info.get(i)).a / ((CameraControl.CustomSize)paramCamera2Info.get(i)).b);
          i += 1;
        }
      }
      localObject1 = a(paramCamera2Info, paramInt1, paramInt2);
      if (localObject1 != null)
      {
        paramCamera2Info = (Camera2Control.Camera2Info)localObject1;
        if (!QLog.isColorLevel()) {
          break label422;
        }
        QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: DEFAULT resolution os OK. size:" + ((CameraControl.CustomSize)localObject1).toString());
        return localObject1;
      }
    }
    catch (Exception paramCamera2Info)
    {
      a(2, "[Camera2] getPreviewSizeV2 exception!");
      return null;
    }
    Object localObject1 = a(paramCamera2Info, 960, 720);
    if (localObject1 != null)
    {
      paramCamera2Info = (Camera2Control.Camera2Info)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: 640*480 resolution os OK.");
        return localObject1;
      }
    }
    else
    {
      localObject1 = a(paramCamera2Info, paramInt1, paramInt2, paramInt3, paramInt4);
      paramCamera2Info = (Camera2Control.Camera2Info)localObject1;
      if (paramBoolean) {
        if (localObject1 == null)
        {
          paramInt3 = 0;
          break label425;
        }
      }
    }
    for (;;)
    {
      NewFlowCameraReporter.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
      return localObject1;
      paramInt3 = ((CameraControl.CustomSize)localObject1).a;
      label422:
      label425:
      while (localObject1 != null)
      {
        paramInt4 = ((CameraControl.CustomSize)localObject1).b;
        break;
        return paramCamera2Info;
      }
      paramInt4 = j;
    }
  }
  
  private static CameraControl.CustomSize a(int paramInt1, int paramInt2, int paramInt3, List<CameraControl.CustomSize> paramList)
  {
    paramInt3 = Math.max(paramInt1 * paramInt3, paramInt2 * paramInt3);
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "setParamsPictureSize targetWidth " + paramInt3);
    }
    CameraControl.CustomSize localCustomSize1 = new CameraControl.CustomSize(0, 0);
    paramList = paramList.iterator();
    paramInt1 = 2147483647;
    if (paramList.hasNext())
    {
      CameraControl.CustomSize localCustomSize2 = (CameraControl.CustomSize)paramList.next();
      paramInt2 = Math.abs(localCustomSize2.a - paramInt3);
      if (paramInt1 <= paramInt2) {
        break label126;
      }
      localCustomSize1.a = localCustomSize2.a;
      localCustomSize1.b = localCustomSize2.b;
      paramInt1 = paramInt2;
    }
    label126:
    for (;;)
    {
      break;
      return localCustomSize1;
    }
  }
  
  private static CameraControl.CustomSize a(List<CameraControl.CustomSize> paramList, int paramInt1, int paramInt2)
  {
    int j = -1;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[wantedPreviewSize]: width=" + paramInt1 + "  height=" + paramInt2);
    }
    CameraControl.CustomSize localCustomSize1 = new CameraControl.CustomSize();
    int i = j;
    if (paramList != null)
    {
      i = j;
      if (!paramList.isEmpty())
      {
        paramList = paramList.iterator();
        i = -1;
        if (paramList.hasNext())
        {
          CameraControl.CustomSize localCustomSize2 = (CameraControl.CustomSize)paramList.next();
          if ((localCustomSize2 == null) || (localCustomSize2.b != paramInt2) || (localCustomSize2.a < paramInt1) || ((i >= 0) && (localCustomSize2.a > i))) {
            break label235;
          }
          i = localCustomSize2.a;
        }
      }
    }
    label235:
    for (;;)
    {
      break;
      if (i > 0)
      {
        localCustomSize1.b = paramInt2;
        localCustomSize1.a = i;
        if (localCustomSize1.a / 4 == localCustomSize1.b / 3)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[4:3]...");
          }
          return localCustomSize1;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize: RATIO_MUST_EQUAL cSize:" + localCustomSize1.toString());
        }
        return localCustomSize1;
      }
      return null;
    }
  }
  
  private static CameraControl.CustomSize a(List<CameraControl.CustomSize> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d = paramInt4 / paramInt3;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] physicRatio=" + d);
    }
    CameraControl.CustomSize localCustomSize1 = new CameraControl.CustomSize();
    Iterator localIterator;
    long l1;
    CameraControl.CustomSize localCustomSize2;
    long l2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 9223372036854775807L;
      if (localIterator.hasNext())
      {
        localCustomSize2 = (CameraControl.CustomSize)localIterator.next();
        if ((localCustomSize2 != null) && (localCustomSize2.a >= paramInt1) && (localCustomSize2.b >= paramInt2) && (localCustomSize2.a / localCustomSize2.b >= d))
        {
          l2 = localCustomSize2.a * localCustomSize2.b;
          if (l2 < l1)
          {
            localCustomSize1.a = localCustomSize2.a;
            localCustomSize1.b = localCustomSize2.b;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localCustomSize2.a < localCustomSize1.a))
          {
            localCustomSize1.a = localCustomSize2.a;
            localCustomSize1.b = localCustomSize2.b;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] have no resolution >= (w*h)");
    }
    if (((localCustomSize1.a <= 0) || (localCustomSize1.b <= 0)) && (paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 0L;
      if (localIterator.hasNext())
      {
        localCustomSize2 = (CameraControl.CustomSize)localIterator.next();
        if ((localCustomSize2 != null) && (localCustomSize2.a / localCustomSize2.b >= d))
        {
          l2 = localCustomSize2.a * localCustomSize2.b;
          if (l2 > l1)
          {
            localCustomSize1.a = localCustomSize2.a;
            localCustomSize1.b = localCustomSize2.b;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localCustomSize2.a < localCustomSize1.a))
          {
            localCustomSize1.a = localCustomSize2.a;
            localCustomSize1.b = localCustomSize2.b;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] cSize.width=" + localCustomSize1.a + "  cSize.height=" + localCustomSize1.b);
    }
    if ((localCustomSize1.a > 0) && (localCustomSize1.b > 0)) {
      return localCustomSize1;
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.get(0) != null))
    {
      localCustomSize1.a = ((CameraControl.CustomSize)paramList.get(0)).a;
      localCustomSize1.b = ((CameraControl.CustomSize)paramList.get(0)).b;
      return localCustomSize1;
    }
    return null;
  }
  
  private static CameraControl.CustomSize a(List<CameraControl.CustomSize> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3[wantedPreviewSize]: width=" + paramInt1 + "  height=" + paramInt2);
    }
    float f3 = paramInt1 / paramInt2;
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramList = paramList.iterator();
    }
    label234:
    label874:
    label877:
    label880:
    label881:
    for (;;)
    {
      CameraControl.CustomSize localCustomSize;
      int i;
      int j;
      if (paramList.hasNext())
      {
        localCustomSize = (CameraControl.CustomSize)paramList.next();
        if (localCustomSize == null) {
          continue;
        }
        i = Math.max(localCustomSize.a, localCustomSize.b);
        j = Math.min(localCustomSize.a, localCustomSize.b);
        if ((localCustomSize.b != paramInt2) || (i != paramInt1)) {
          break label347;
        }
        ((List)localObject1).add(new CameraControl.CustomSize(paramInt1, paramInt2));
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 first: width=" + paramInt1 + "  height=" + paramInt2);
        }
      }
      float f1;
      float f2;
      if (((List)localObject1).size() == 0)
      {
        paramList = ((List)localObject2).iterator();
        f1 = 10000.0F;
        if (paramList.hasNext())
        {
          localCustomSize = (CameraControl.CustomSize)paramList.next();
          if (localCustomSize == null) {
            break label880;
          }
          paramInt1 = Math.max(localCustomSize.a, localCustomSize.b);
          paramInt2 = Math.min(localCustomSize.a, localCustomSize.b);
          f2 = paramInt1 / paramInt2;
          if (Math.abs(f3 - f2) < CameraControl.a) {
            ((List)localObject1).add(localCustomSize);
          }
          if (Math.abs(f3 - f2) >= f1) {
            break label880;
          }
          f1 = Math.abs(f3 - f2);
        }
      }
      for (;;)
      {
        break label234;
        if ((i <= paramInt5) || (i >= paramInt3) || (j <= paramInt6) || (j >= paramInt4)) {
          break label881;
        }
        ((List)localObject2).add(new CameraControl.CustomSize(i, j));
        break;
        f2 = f1;
        if (QLog.isColorLevel())
        {
          f2 = f1;
          if (localObject1 != null)
          {
            paramInt1 = 0;
            for (;;)
            {
              f2 = f1;
              if (paramInt1 >= ((List)localObject1).size()) {
                break;
              }
              QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 secend: width=" + ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).a + " height=" + ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).b + " w/h=" + ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).a / ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).b);
              paramInt1 += 1;
            }
            f2 = 10000.0F;
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
              if (Math.abs(Math.abs(f3 - paramInt1 / paramInt2) - f2) < CameraControl.a) {
                ((List)localObject1).add(localObject2);
              }
            }
          }
          if ((QLog.isColorLevel()) && (localObject1 != null))
          {
            paramInt1 = 0;
            while (paramInt1 < ((List)localObject1).size())
            {
              QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 third: width=" + ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).a + " height=" + ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).b + " w/h=" + ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).a / ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).b);
              paramInt1 += 1;
            }
          }
        }
        if (((List)localObject1).size() > 0)
        {
          paramList = (CameraControl.CustomSize)((List)localObject1).get(0);
          localObject2 = ((List)localObject1).iterator();
          localObject1 = paramList;
          if (!((Iterator)localObject2).hasNext()) {
            break label874;
          }
          localObject1 = (CameraControl.CustomSize)((Iterator)localObject2).next();
          if ((localObject1 == null) || (((CameraControl.CustomSize)localObject1).a * ((CameraControl.CustomSize)localObject1).b <= paramList.a * paramList.b)) {
            break label877;
          }
          paramList = (List<CameraControl.CustomSize>)localObject1;
        }
        for (;;)
        {
          break;
          localObject1 = null;
          return localObject1;
        }
      }
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      QLog.w("Camera2Control", 1, paramString);
    }
    while (paramInt != 2) {
      return;
    }
    QLog.e("Camera2Control", 1, paramString);
  }
  
  public static CameraControl.CustomSize[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Camera2Control.Camera2Info paramCamera2Info)
  {
    a(1, "[Camera2] getPreviewAndPictureSizeV2 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    CameraControl.CustomSize[] arrayOfCustomSize = new CameraControl.CustomSize[2];
    CameraControl.CustomSize localCustomSize = a(paramInt1, paramInt2, paramInt3, paramInt4, true, paramCamera2Info);
    if (localCustomSize != null)
    {
      arrayOfCustomSize[0] = localCustomSize;
      a(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 preview=" + localCustomSize.a + " " + localCustomSize.b);
      paramCamera2Info = a(localCustomSize.a, localCustomSize.b, paramInt3, paramInt4, 1, paramCamera2Info);
      arrayOfCustomSize[1] = paramCamera2Info;
      if (paramCamera2Info != null) {
        a(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 picture=" + paramCamera2Info.a + " " + paramCamera2Info.b);
      }
    }
    return arrayOfCustomSize;
  }
  
  @TargetApi(21)
  private static CameraControl.CustomSize b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, Camera2Control.Camera2Info paramCamera2Info)
  {
    if (paramCamera2Info != null) {}
    try
    {
      if (!paramCamera2Info.a())
      {
        a(2, "[Camera2]getPreviewSizeV3 camera2Info: " + paramCamera2Info);
        return null;
      }
      Object localObject1 = (StreamConfigurationMap)paramCamera2Info.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      paramCamera2Info = new ArrayList();
      localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
      if (localObject1 == null) {
        return null;
      }
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        paramCamera2Info.add(new CameraControl.CustomSize(localObject2.getWidth(), localObject2.getHeight()));
        i += 1;
      }
      if (paramCamera2Info.size() > 0)
      {
        i = 0;
        while (i < paramCamera2Info.size())
        {
          a(1, "[Camera2] getPreviewSizeV3 sizeGuaranteeOK[list]: width=" + ((CameraControl.CustomSize)paramCamera2Info.get(i)).a + " height=" + ((CameraControl.CustomSize)paramCamera2Info.get(i)).b + " w/h=" + ((CameraControl.CustomSize)paramCamera2Info.get(i)).a / ((CameraControl.CustomSize)paramCamera2Info.get(i)).b);
          i += 1;
        }
      }
      localObject1 = a(paramCamera2Info, paramInt1, paramInt2, 2600, 1500, 1700, 1000);
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: DEFAULT resolution os OK. size:" + localObject1);
        }
        if (paramBoolean) {
          NewFlowCameraReporter.a(2, paramInt1, paramInt2, ((CameraControl.CustomSize)localObject1).a, ((CameraControl.CustomSize)localObject1).b);
        }
      }
      else
      {
        localObject1 = a(paramCamera2Info, paramInt1, paramInt2, 2600, 1500, 1000, 700);
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: 640*480 resolution os OK. size:" + localObject1);
          }
          if (!paramBoolean) {
            break label519;
          }
          NewFlowCameraReporter.a(3, paramInt1, paramInt2, ((CameraControl.CustomSize)localObject1).a, ((CameraControl.CustomSize)localObject1).b);
          break label519;
        }
        paramCamera2Info = a(paramCamera2Info, paramInt1, paramInt2, paramInt3, paramInt4);
        if (paramBoolean)
        {
          if (paramCamera2Info != null) {
            break label495;
          }
          paramInt3 = 0;
          break label522;
        }
      }
      for (;;)
      {
        NewFlowCameraReporter.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
        if (QLog.isColorLevel())
        {
          QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeGuaranteeOK: getPreviewSize. size:" + paramCamera2Info);
          return paramCamera2Info;
          label495:
          paramInt3 = paramCamera2Info.a;
        }
        label519:
        label522:
        while (paramCamera2Info != null)
        {
          paramInt4 = paramCamera2Info.b;
          break;
          return paramCamera2Info;
          return localObject1;
          return localObject1;
        }
        paramInt4 = 0;
      }
      return null;
    }
    catch (Exception paramCamera2Info) {}
  }
  
  public static CameraControl.CustomSize[] b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Camera2Control.Camera2Info paramCamera2Info)
  {
    a(1, "[Camera2] getPreviewAndPictureSizeV3 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    if (paramCamera2Info == null)
    {
      a(2, "[Camera2] getPreviewAndPictureSizeV3 camera2Info:" + paramCamera2Info);
      return null;
    }
    CameraControl.CustomSize[] arrayOfCustomSize = new CameraControl.CustomSize[2];
    CameraControl.CustomSize localCustomSize = b(paramInt1, paramInt2, paramInt3, paramInt4, true, paramCamera2Info);
    if (localCustomSize != null)
    {
      arrayOfCustomSize[0] = localCustomSize;
      a(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 preview=" + localCustomSize.a + " " + localCustomSize.b);
      paramCamera2Info = a(localCustomSize.a, localCustomSize.b, paramInt3, paramInt4, 1, paramCamera2Info);
      arrayOfCustomSize[1] = paramCamera2Info;
      if (paramCamera2Info != null) {
        a(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 picture=" + paramCamera2Info.a + " " + paramCamera2Info.b);
      }
    }
    return arrayOfCustomSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Utils
 * JD-Core Version:    0.7.0.1
 */