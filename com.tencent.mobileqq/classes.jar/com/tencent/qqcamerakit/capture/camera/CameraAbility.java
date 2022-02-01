package com.tencent.qqcamerakit.capture.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.qqcamerakit.capture.CameraProxy;
import com.tencent.qqcamerakit.capture.CameraSize;
import com.tencent.qqcamerakit.common.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CameraAbility
{
  private static int jdField_a_of_type_Int = 0;
  private static CameraAbility jdField_a_of_type_ComTencentQqcamerakitCaptureCameraCameraAbility;
  private static int b = -1;
  private static int c = -1;
  private Camera.Parameters jdField_a_of_type_AndroidHardwareCamera$Parameters;
  
  static
  {
    int j = 0;
    try
    {
      Object localObject = CameraProxy.a();
      if (localObject != null)
      {
        SharedPreferences localSharedPreferences = ((Context)localObject).getSharedPreferences("qcamera_local", 0);
        if (localSharedPreferences.contains("localsp_camera_num")) {
          jdField_a_of_type_Int = localSharedPreferences.getInt("localsp_camera_num", 0);
        }
      }
      int i = j;
      if (jdField_a_of_type_Int == 0)
      {
        jdField_a_of_type_Int = Camera.getNumberOfCameras();
        i = j;
        if (localObject != null)
        {
          ((Context)localObject).getSharedPreferences("qcamera_local", 0).edit().putInt("localsp_camera_num", jdField_a_of_type_Int).commit();
          i = j;
        }
      }
      while (i < jdField_a_of_type_Int)
      {
        localObject = new Camera.CameraInfo();
        Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
        if ((((Camera.CameraInfo)localObject).facing == 0) && (b == -1)) {
          b = i;
        } else if (1 == ((Camera.CameraInfo)localObject).facing) {
          c = i;
        }
        i += 1;
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (QLog.a()) {
        QLog.a("CameraAbility", 2, "", localRuntimeException);
      }
      jdField_a_of_type_Int = 1;
    }
  }
  
  public static int a()
  {
    return c;
  }
  
  public static CameraAbility a()
  {
    if (jdField_a_of_type_ComTencentQqcamerakitCaptureCameraCameraAbility == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQqcamerakitCaptureCameraCameraAbility == null) {
          jdField_a_of_type_ComTencentQqcamerakitCaptureCameraCameraAbility = new CameraAbility();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQqcamerakitCaptureCameraCameraAbility;
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Int > 0;
  }
  
  public static int b()
  {
    return b;
  }
  
  public static boolean b()
  {
    return (a()) && (b != -1);
  }
  
  public static boolean c()
  {
    return (a()) && (c != -1);
  }
  
  public List<int[]> a()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPreviewFpsRange();
      return localList;
    }
    catch (Exception localException)
    {
      label34:
      break label34;
    }
    return null;
  }
  
  public List<CameraSize> a(boolean paramBoolean)
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    if (paramBoolean) {}
    try
    {
      localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPictureSizes();
    }
    catch (Exception localException)
    {
      List localList;
      QLog.a("CameraAbility", 1, localException, new Object[] { "getPreviewSizes, isPicture: ", Boolean.valueOf(paramBoolean) });
      localIterator = null;
    }
    localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPreviewSizes();
    Iterator localIterator;
    ArrayList localArrayList = new ArrayList();
    if (localIterator != null)
    {
      localIterator = localIterator.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Camera.Size)localIterator.next();
        localObject = new CameraSize(((Camera.Size)localObject).width, ((Camera.Size)localObject).height);
        localArrayList.add(localObject);
        if (QLog.a()) {
          QLog.d("CameraAbility", 2, new Object[] { "getPreviewSizes, isPicture: ", Boolean.valueOf(paramBoolean), " ", localObject });
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidHardwareCamera$Parameters = null;
  }
  
  public boolean a(int paramInt)
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPreviewFormats();
      if (localList == null) {
        return false;
      }
      boolean bool = localList.contains(Integer.valueOf(paramInt));
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean a(Camera paramCamera)
  {
    a();
    boolean bool = false;
    if (paramCamera == null) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera$Parameters = paramCamera.getParameters();
    }
    catch (Exception paramCamera)
    {
      paramCamera.printStackTrace();
      this.jdField_a_of_type_AndroidHardwareCamera$Parameters = null;
    }
    if (this.jdField_a_of_type_AndroidHardwareCamera$Parameters != null) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(String paramString)
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedFocusModes();
      if (localList == null) {
        return false;
      }
      boolean bool = localList.contains(paramString);
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public boolean d()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      boolean bool = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.isZoomSupported();
      return bool;
    }
    catch (Exception localException)
    {
      label34:
      break label34;
    }
    return false;
  }
  
  public boolean e()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    boolean bool1 = false;
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedFlashModes();
      if (localList == null) {
        return false;
      }
      boolean bool2 = localList.contains("torch");
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camera.CameraAbility
 * JD-Core Version:    0.7.0.1
 */