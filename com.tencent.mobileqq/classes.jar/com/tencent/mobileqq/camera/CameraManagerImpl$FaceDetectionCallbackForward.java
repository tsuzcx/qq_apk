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
  private final Handler a;
  private final CameraManager.CameraFaceDetectionCallback b;
  private final CameraManager.CameraProxy c;
  
  public void onFaceDetection(Camera.Face[] paramArrayOfFace, Camera paramCamera)
  {
    paramCamera = new StringBuilder();
    paramCamera.append("[onFaceDetection] faces = ");
    paramCamera.append(paramArrayOfFace);
    paramCamera.append(", length = ");
    paramCamera.append(paramArrayOfFace.length);
    QLog.d("Q.camera.CameraManagerImpl", 2, paramCamera.toString());
    this.a.post(new CameraManagerImpl.FaceDetectionCallbackForward.1(this, paramArrayOfFace));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl.FaceDetectionCallbackForward
 * JD-Core Version:    0.7.0.1
 */