package com.tencent.mobileqq.camera;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.Face;
import android.hardware.Camera.FaceDetectionListener;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

@TargetApi(14)
class CameraManagerImpl$FaceDetectionCallbackForward
  implements Camera.FaceDetectionListener
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final CameraManager.CameraFaceDetectionCallback jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraFaceDetectionCallback;
  private final CameraManager.CameraProxy jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy;
  
  public void onFaceDetection(Camera.Face[] paramArrayOfFace, Camera paramCamera)
  {
    QLog.d("Q.camera.CameraManagerImpl", 2, "[onFaceDetection] faces = " + paramArrayOfFace + ", length = " + paramArrayOfFace.length);
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.FaceDetectionCallbackForward.1(this, paramArrayOfFace));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl.FaceDetectionCallbackForward
 * JD-Core Version:    0.7.0.1
 */