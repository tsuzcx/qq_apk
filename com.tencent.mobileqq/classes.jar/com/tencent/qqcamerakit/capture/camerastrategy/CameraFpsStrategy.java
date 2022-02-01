package com.tencent.qqcamerakit.capture.camerastrategy;

import com.tencent.qqcamerakit.capture.CameraProxy.CustomFpsStrategy;
import com.tencent.qqcamerakit.capture.camera.CameraAbility;
import com.tencent.qqcamerakit.capture.camera2.Camera2Control;
import com.tencent.qqcamerakit.common.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CameraFpsStrategy
{
  public static CameraProxy.CustomFpsStrategy a;
  public static boolean a = false;
  
  private static List<int[]> a()
  {
    List localList;
    if (CameraAPIStrategy.jdField_a_of_type_Boolean) {
      localList = Camera2Control.a().a();
    } else {
      localList = CameraAbility.a().a();
    }
    a(localList);
    return localList;
  }
  
  private static void a(List<int[]> paramList)
  {
    int i;
    if ((paramList != null) && (paramList.size() > 0)) {
      i = 0;
    }
    while (i < paramList.size())
    {
      Object localObject = (int[])paramList.get(i);
      if ((localObject != null) && (localObject.length >= 2))
      {
        if (QLog.a())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("printFpsRange[i=");
          localStringBuilder.append(i);
          localStringBuilder.append(" fps[low]=");
          localStringBuilder.append(localObject[0]);
          localStringBuilder.append(" fps[high]=");
          localStringBuilder.append(localObject[1]);
          localStringBuilder.append("]");
          QLog.c("CameraFpsStrategy", 2, new Object[] { localStringBuilder.toString() });
        }
      }
      else if (QLog.a())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("printFpsRange[i=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" ele=null]");
        QLog.c("CameraFpsStrategy", 2, new Object[] { ((StringBuilder)localObject).toString() });
      }
      i += 1;
      continue;
      if (QLog.a()) {
        QLog.c("CameraFpsStrategy", 2, new Object[] { "printFpsRange[listFpsRange=null]" });
      }
    }
  }
  
  public static int[] a(int paramInt)
  {
    Object localObject = a();
    CameraProxy.CustomFpsStrategy localCustomFpsStrategy = jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy$CustomFpsStrategy;
    if (localCustomFpsStrategy != null) {
      localObject = localCustomFpsStrategy.a((List)localObject, paramInt);
    } else {
      localObject = a((List)localObject, paramInt);
    }
    if (QLog.a())
    {
      boolean bool = false;
      paramInt = localObject[0];
      int i = localObject[1];
      if (jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy$CustomFpsStrategy != null) {
        bool = true;
      }
      QLog.c("CameraFpsStrategy", 2, new Object[] { "getFpsRange, selectFps:", Integer.valueOf(paramInt), " ", Integer.valueOf(i), " customFpsStrategy:", Boolean.valueOf(bool) });
    }
    return localObject;
  }
  
  private static int[] a(List<int[]> paramList)
  {
    int i;
    if (CameraAPIStrategy.jdField_a_of_type_Boolean) {
      i = 15;
    } else {
      i = 15000;
    }
    Iterator localIterator = paramList.iterator();
    label25:
    int[] arrayOfInt;
    for (paramList = null; localIterator.hasNext(); paramList = arrayOfInt)
    {
      arrayOfInt = (int[])localIterator.next();
      if ((paramList != null) && ((arrayOfInt[0] > i) || (arrayOfInt[1] - arrayOfInt[0] <= paramList[1] - paramList[0]))) {
        break label25;
      }
    }
    return paramList;
  }
  
  public static int[] a(List<int[]> paramList, int paramInt)
  {
    int[] arrayOfInt3 = new int[2];
    int[] tmp7_5 = arrayOfInt3;
    tmp7_5[0] = 2147483647;
    int[] tmp12_7 = tmp7_5;
    tmp12_7[1] = 2147483647;
    tmp12_7;
    if (!CameraAPIStrategy.jdField_a_of_type_Boolean) {
      paramInt *= 1000;
    }
    if (paramList == null)
    {
      arrayOfInt3[0] = paramInt;
      arrayOfInt3[1] = paramInt;
      return arrayOfInt3;
    }
    boolean bool;
    if (jdField_a_of_type_Boolean) {
      bool = CameraCompatible.b(CameraCompatibleConfig.KEY.g) ^ true;
    } else {
      bool = CameraCompatible.b(CameraCompatibleConfig.KEY.h);
    }
    if (QLog.a()) {
      QLog.c("CameraFpsStrategy", 2, new Object[] { "selectFpsRange, fixFpsMode:", Boolean.valueOf(jdField_a_of_type_Boolean), " fixedFps:", Boolean.valueOf(bool) });
    }
    int[] arrayOfInt2;
    int[] arrayOfInt1;
    if (bool)
    {
      arrayOfInt2 = b(paramList, paramInt);
      arrayOfInt1 = arrayOfInt2;
      if (arrayOfInt2 == null) {
        arrayOfInt1 = c(paramList, paramInt);
      }
    }
    else
    {
      arrayOfInt2 = c(paramList, paramInt);
      arrayOfInt1 = arrayOfInt2;
      if (arrayOfInt2 == null) {
        arrayOfInt1 = b(paramList, paramInt);
      }
    }
    if (arrayOfInt1 == null)
    {
      if (QLog.a()) {
        QLog.c("CameraFpsStrategy", 2, new Object[] { "selectFpsRange, fpsRange null, goto backup strategy" });
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        arrayOfInt2 = (int[])paramList.next();
        if ((arrayOfInt2 != null) && (arrayOfInt2.length >= 2) && (paramInt >= arrayOfInt2[0]) && (paramInt <= arrayOfInt2[1]))
        {
          arrayOfInt3[0] = paramInt;
          arrayOfInt3[1] = arrayOfInt2[1];
          return arrayOfInt3;
        }
      }
    }
    return arrayOfInt1;
  }
  
  private static int[] b(List<int[]> paramList, int paramInt)
  {
    if (QLog.a()) {
      QLog.c("CameraFpsStrategy", 2, new Object[] { "getZoneFps" });
    }
    int[] arrayOfInt1 = new int[2];
    int[] tmp26_25 = arrayOfInt1;
    tmp26_25[0] = 2147483647;
    int[] tmp31_26 = tmp26_25;
    tmp31_26[1] = 2147483647;
    tmp31_26;
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      int[] arrayOfInt2 = (int[])((Iterator)localObject).next();
      if ((arrayOfInt2 != null) && (arrayOfInt2.length >= 2)) {
        if ((arrayOfInt2[0] >= paramInt) && (arrayOfInt2[1] < arrayOfInt1[1]))
        {
          arrayOfInt1[0] = arrayOfInt2[0];
          arrayOfInt1[1] = arrayOfInt2[1];
        }
        else if ((arrayOfInt2[0] >= paramInt) && (arrayOfInt2[1] == arrayOfInt1[1]) && (arrayOfInt2[0] < arrayOfInt1[0]))
        {
          arrayOfInt1[0] = arrayOfInt2[0];
          arrayOfInt1[1] = arrayOfInt2[1];
        }
      }
    }
    if ((arrayOfInt1[0] == 2147483647) || (arrayOfInt1[1] == 2147483647))
    {
      arrayOfInt1[1] = 0;
      arrayOfInt1[0] = 0;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (int[])paramList.next();
        if ((localObject != null) && (localObject.length >= 2)) {
          if ((localObject[0] <= paramInt) && (localObject[1] > arrayOfInt1[1]))
          {
            arrayOfInt1[0] = localObject[0];
            arrayOfInt1[1] = localObject[1];
          }
          else if ((localObject[0] <= paramInt) && (localObject[1] == arrayOfInt1[1]) && (localObject[0] > arrayOfInt1[0]))
          {
            arrayOfInt1[0] = localObject[0];
            arrayOfInt1[1] = localObject[1];
          }
        }
      }
    }
    if ((arrayOfInt1[0] != 2147483647) && (arrayOfInt1[1] != 2147483647)) {
      return arrayOfInt1;
    }
    return null;
  }
  
  private static int[] c(List<int[]> paramList, int paramInt)
  {
    if (QLog.a()) {
      QLog.c("CameraFpsStrategy", 2, new Object[] { "getMaxRangeFps" });
    }
    Object localObject1 = null;
    Object localObject2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      int[] arrayOfInt = (int[])localIterator.next();
      if (arrayOfInt[1] >= paramInt) {
        ((List)localObject2).add(arrayOfInt);
      }
    }
    localIterator = ((List)localObject2).iterator();
    paramInt = 0;
    while (localIterator.hasNext())
    {
      localObject2 = (int[])localIterator.next();
      int i = localObject2[1] - localObject2[0];
      if (i > paramInt)
      {
        localObject1 = localObject2;
        paramInt = i;
      }
    }
    if (localObject1 != null) {
      return localObject1;
    }
    return a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camerastrategy.CameraFpsStrategy
 * JD-Core Version:    0.7.0.1
 */