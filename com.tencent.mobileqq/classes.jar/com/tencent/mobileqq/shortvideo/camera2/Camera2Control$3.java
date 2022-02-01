package com.tencent.mobileqq.shortvideo.camera2;

import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Handler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize;
import java.nio.ByteBuffer;

class Camera2Control$3
  implements ImageReader.OnImageAvailableListener
{
  Camera2Control$3(Camera2Control paramCamera2Control) {}
  
  public void onImageAvailable(ImageReader paramImageReader)
  {
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Camera2]Image Capture cost:");
      ((StringBuilder)localObject).append((float)(System.currentTimeMillis() - Camera2Control.a(this.a)) / 1000.0F);
      Camera2Utils.a(1, ((StringBuilder)localObject).toString());
      Camera2Support.a(2, Camera2Control.a(this.a).a * Camera2Control.a(this.a).b, System.currentTimeMillis() - Camera2Control.a(this.a));
      paramImageReader = paramImageReader.acquireNextImage();
      if (paramImageReader != null)
      {
        localObject = paramImageReader.getPlanes()[0].getBuffer();
        byte[] arrayOfByte = new byte[((ByteBuffer)localObject).remaining()];
        ((ByteBuffer)localObject).get(arrayOfByte);
        if ((Camera2Control.a(this.a) != null) && (Camera2Control.a(this.a) != null))
        {
          Camera2Control.a(this.a).a = Camera2Control.a(this.a).a;
          Camera2Control.a(this.a).post(new Camera2Control.ImageSaveServer(arrayOfByte, Camera2Control.a(this.a)));
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
      Camera2Utils.a(1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control.3
 * JD-Core Version:    0.7.0.1
 */