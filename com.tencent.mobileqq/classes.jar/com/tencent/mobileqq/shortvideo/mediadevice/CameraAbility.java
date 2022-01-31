package com.tencent.mobileqq.shortvideo.mediadevice;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.Iterator;
import java.util.List;

public class CameraAbility
{
  private static int jdField_a_of_type_Int;
  private static CameraAbility jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraAbility;
  private static int b;
  private static int c;
  private Camera.Parameters jdField_a_of_type_AndroidHardwareCamera$Parameters;
  
  static
  {
    int i = 0;
    if (!CameraAbility.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      b = -1;
      c = -1;
      for (;;)
      {
        try
        {
          if (!VersionUtils.c()) {
            break label117;
          }
          jdField_a_of_type_Int = Camera.getNumberOfCameras();
          if (i < jdField_a_of_type_Int)
          {
            Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, localCameraInfo);
            if (localCameraInfo == null) {
              break label122;
            }
            if ((localCameraInfo.facing == 0) && (b == -1)) {
              b = i;
            } else if (1 == localCameraInfo.facing) {
              c = i;
            }
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("CameraAbility", 2, "", localRuntimeException);
          }
          jdField_a_of_type_Int = 1;
        }
        return;
        label117:
        jdField_a_of_type_Int = 1;
        return;
        label122:
        i += 1;
      }
    }
  }
  
  public static int a()
  {
    return c;
  }
  
  public static CameraAbility a()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraAbility == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraAbility == null) {
        jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraAbility = new CameraAbility();
      }
      return jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraAbility;
    }
    finally {}
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
  
  public List a()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList1 = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPreviewSizes();
      if ((localList1 != null) && (QLog.isColorLevel()))
      {
        Iterator localIterator = localList1.iterator();
        while (localIterator.hasNext())
        {
          Camera.Size localSize = (Camera.Size)localIterator.next();
          if (localSize != null) {
            QLog.d("CameraAbility", 2, "[@] getPreviewSizes:w=" + localSize.width + ",h=" + localSize.height + " w/h=" + localSize.width / localSize.height);
          }
        }
      }
    }
    catch (Exception localException)
    {
      List localList2;
      for (;;)
      {
        localException.printStackTrace();
        localList2 = null;
      }
      return localList2;
    }
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
      if (bool) {
        return true;
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean a(Camera paramCamera)
  {
    a();
    if (paramCamera == null) {}
    for (;;)
    {
      return false;
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera$Parameters = paramCamera.getParameters();
        if (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null) {
          continue;
        }
        return true;
      }
      catch (Exception paramCamera)
      {
        for (;;)
        {
          paramCamera.printStackTrace();
          this.jdField_a_of_type_AndroidHardwareCamera$Parameters = null;
        }
      }
    }
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
      if (bool) {
        return true;
      }
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public List b()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList1 = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPictureSizes();
      if ((localList1 != null) && (QLog.isColorLevel()))
      {
        Iterator localIterator = localList1.iterator();
        while (localIterator.hasNext())
        {
          Camera.Size localSize = (Camera.Size)localIterator.next();
          if (localSize != null) {
            QLog.d("CameraAbility", 2, "[@] getPictureSizes:w=" + localSize.width + ",h=" + localSize.height + " w/h=" + localSize.width / localSize.height);
          }
        }
      }
    }
    catch (Exception localException)
    {
      List localList2;
      for (;;)
      {
        localException.printStackTrace();
        localList2 = null;
      }
      return localList2;
    }
  }
  
  public boolean b(String paramString)
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedSceneModes();
      if ((localList != null) && (!localList.isEmpty()))
      {
        boolean bool = localList.contains(paramString);
        return bool;
      }
    }
    catch (Exception paramString) {}
    return false;
  }
  
  @TargetApi(9)
  public List c()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPreviewFpsRange();
      return localList;
    }
    catch (Exception localException) {}
    return null;
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
    catch (Exception localException) {}
    return false;
  }
  
  public boolean e()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedFlashModes();
      if (localList == null) {
        return false;
      }
      boolean bool = localList.contains("torch");
      if (bool) {
        return true;
      }
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility
 * JD-Core Version:    0.7.0.1
 */