package com.tencent.mobileqq.richmedia.capture.view;

import android.graphics.Rect;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraAutoFocusCallBack;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class CameraCaptureView$5
  implements CameraProxy.CameraAutoFocusCallBack
{
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAutoFocusCallback requestFocus when capture : ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", [Camera2]camera2:");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("CameraCaptureView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = CameraCaptureView.a;
    File localFile = this.a;
    Rect localRect = new Rect(0, 0, this.d.c, this.d.d);
    CameraCaptureView localCameraCaptureView = this.d;
    ((CameraProxy)localObject).a(localFile, localRect, localCameraCaptureView, this.b, this.c, 1, localCameraCaptureView.Q);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.5
 * JD-Core Version:    0.7.0.1
 */