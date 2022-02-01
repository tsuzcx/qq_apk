package com.tencent.qqcamerakit.capture.camera2;

import android.media.Image;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import com.tencent.qqcamerakit.capture.CameraPreviewCallBack;
import com.tencent.qqcamerakit.common.QLog;

class Camera2Control$4
  implements ImageReader.OnImageAvailableListener
{
  Camera2Control$4(Camera2Control paramCamera2Control) {}
  
  public void onImageAvailable(ImageReader paramImageReader)
  {
    try
    {
      paramImageReader = paramImageReader.acquireNextImage();
      if (paramImageReader != null)
      {
        if (Camera2Control.a(this.a) != null) {
          Camera2Control.a(this.a).onPreviewFrame(paramImageReader);
        }
        paramImageReader.close();
        return;
      }
    }
    catch (Exception paramImageReader)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2] onImageAvailable mPreviewReader exception:");
      localStringBuilder.append(paramImageReader);
      QLog.d("Camera2Control", 1, new Object[] { localStringBuilder.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camera2.Camera2Control.4
 * JD-Core Version:    0.7.0.1
 */