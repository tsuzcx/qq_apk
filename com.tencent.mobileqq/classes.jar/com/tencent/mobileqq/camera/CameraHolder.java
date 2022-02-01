package com.tencent.mobileqq.camera;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import com.tencent.mobileqq.camera.adapter.CameraWrapper;
import com.tencent.qphone.base.util.QLog;

@TargetApi(9)
public class CameraHolder
{
  private static CameraHolder jdField_a_of_type_ComTencentMobileqqCameraCameraHolder;
  private static Camera.CameraInfo[] jdField_b_of_type_ArrayOfAndroidHardwareCamera$CameraInfo;
  private final int jdField_a_of_type_Int;
  private CameraWrapper jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraWrapper = CameraWrapper.a();
  private final Camera.CameraInfo[] jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo;
  private int jdField_b_of_type_Int = -1;
  private int c = -1;
  private int d = -1;
  
  private CameraHolder()
  {
    Object localObject = jdField_b_of_type_ArrayOfAndroidHardwareCamera$CameraInfo;
    int k = 0;
    int j;
    if (localObject != null)
    {
      this.jdField_a_of_type_Int = localObject.length;
      this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo = ((Camera.CameraInfo[])localObject);
      j = k;
    }
    else
    {
      this.jdField_a_of_type_Int = a();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[CameraHolder] mNumberOfCameras = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        QLog.d("Q.camera.CameraHolder", 1, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo = new Camera.CameraInfo[this.jdField_a_of_type_Int];
      int i = 0;
      for (;;)
      {
        j = k;
        if (i >= this.jdField_a_of_type_Int) {
          break;
        }
        this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo[i] = new Camera.CameraInfo();
        try
        {
          Camera.getCameraInfo(i, this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo[i]);
        }
        catch (Exception localException)
        {
          QLog.e("Q.camera.CameraHolder", 2, localException, new Object[0]);
        }
        i += 1;
      }
    }
    while (j < this.jdField_a_of_type_Int)
    {
      if ((this.c == -1) && (this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo[j].facing == 0)) {
        this.c = j;
      } else if ((this.d == -1) && (this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo[j].facing == 1)) {
        this.d = j;
      }
      j += 1;
    }
  }
  
  public static CameraHolder a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqCameraCameraHolder == null) {
        try
        {
          if (jdField_a_of_type_ComTencentMobileqqCameraCameraHolder == null) {
            jdField_a_of_type_ComTencentMobileqqCameraCameraHolder = new CameraHolder();
          }
        }
        finally {}
      }
      CameraHolder localCameraHolder = jdField_a_of_type_ComTencentMobileqqCameraCameraHolder;
      return localCameraHolder;
    }
    finally {}
  }
  
  public int a()
  {
    return CameraWrapper.a().b();
  }
  
  public CameraWrapper a()
  {
    return CameraWrapper.a();
  }
  
  public Camera.CameraInfo[] a()
  {
    return this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraHolder
 * JD-Core Version:    0.7.0.1
 */