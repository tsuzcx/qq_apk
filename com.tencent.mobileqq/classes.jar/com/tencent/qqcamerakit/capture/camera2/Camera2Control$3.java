package com.tencent.qqcamerakit.capture.camera2;

import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import com.tencent.qqcamerakit.capture.cameraextend.TakePictureTask;
import com.tencent.qqcamerakit.common.QLog;
import java.nio.ByteBuffer;

class Camera2Control$3
  implements ImageReader.OnImageAvailableListener
{
  Camera2Control$3(Camera2Control paramCamera2Control) {}
  
  public void onImageAvailable(ImageReader paramImageReader)
  {
    try
    {
      paramImageReader = paramImageReader.acquireNextImage();
      if (paramImageReader != null)
      {
        localObject = paramImageReader.getPlanes()[0].getBuffer();
        byte[] arrayOfByte = new byte[((ByteBuffer)localObject).remaining()];
        ((ByteBuffer)localObject).get(arrayOfByte);
        if (Camera2Control.a(this.a) != null)
        {
          Camera2Control.a(this.a).a = arrayOfByte;
          Camera2Control.a(this.a).c = 100;
          new TakePictureTask(Camera2Control.a(this.a)).execute(new Void[0]);
        }
        paramImageReader.close();
        return;
      }
    }
    catch (Exception paramImageReader)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Camera2] onImageAvailable mImageReader exception:");
      ((StringBuilder)localObject).append(paramImageReader);
      QLog.d("Camera2Control", 1, new Object[] { ((StringBuilder)localObject).toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camera2.Camera2Control.3
 * JD-Core Version:    0.7.0.1
 */