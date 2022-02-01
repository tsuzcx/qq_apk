package com.tencent.mobileqq.shortvideo.mediadevice;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class CameraAbility
{
  private static int jdField_a_of_type_Int = 0;
  private static CameraAbility jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraAbility;
  private static int b = -1;
  private static int c = -1;
  private Camera.Parameters jdField_a_of_type_AndroidHardwareCamera$Parameters;
  
  static
  {
    int j = 0;
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = CameraUtils.b(BaseApplicationImpl.getContext());
      if (((SharedPreferences)localObject).contains("local_sp_camera_num")) {
        jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("local_sp_camera_num", 0);
      } else {
        jdField_a_of_type_Int = Camera.getNumberOfCameras();
      }
      int i = j;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getNumberOfCameras cost: ");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
        QLog.i("CameraAbility", 2, ((StringBuilder)localObject).toString());
        i = j;
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
      if (QLog.isColorLevel()) {
        QLog.i("CameraAbility", 2, "", localRuntimeException);
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
    if (jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraAbility == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraAbility == null) {
          jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraAbility = new CameraAbility();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraAbility;
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
  
  public List<Camera.Size> a()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    List<Camera.Size> localList1;
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPreviewSizes();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localList1 = null;
    }
    if ((localList1 != null) && (QLog.isColorLevel()))
    {
      Iterator localIterator = localList1.iterator();
      while (localIterator.hasNext())
      {
        Camera.Size localSize = (Camera.Size)localIterator.next();
        if (localSize != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[@] getPreviewSizes:w=");
          localStringBuilder.append(localSize.width);
          localStringBuilder.append(",h=");
          localStringBuilder.append(localSize.height);
          localStringBuilder.append(" w/h=");
          localStringBuilder.append(localSize.width / localSize.height);
          QLog.d("CameraAbility", 2, localStringBuilder.toString());
        }
      }
    }
    return localList1;
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
    return this.jdField_a_of_type_AndroidHardwareCamera$Parameters != null;
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
  
  public List<Camera.Size> b()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    List<Camera.Size> localList1;
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPictureSizes();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localList1 = null;
    }
    if ((localList1 != null) && (QLog.isColorLevel()))
    {
      Iterator localIterator = localList1.iterator();
      while (localIterator.hasNext())
      {
        Camera.Size localSize = (Camera.Size)localIterator.next();
        if (localSize != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[@] getPictureSizes:w=");
          localStringBuilder.append(localSize.width);
          localStringBuilder.append(",h=");
          localStringBuilder.append(localSize.height);
          localStringBuilder.append(" w/h=");
          localStringBuilder.append(localSize.width / localSize.height);
          QLog.d("CameraAbility", 2, localStringBuilder.toString());
        }
      }
    }
    return localList1;
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
    catch (Exception paramString)
    {
      label55:
      break label55;
    }
    return false;
  }
  
  @TargetApi(9)
  public List<int[]> c()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility
 * JD-Core Version:    0.7.0.1
 */