package com.tencent.mobileqq.shortvideo.camera2;

import android.hardware.Camera.PreviewCallback;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import java.nio.ByteBuffer;

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
        localObject = Camera2Control.a(this.a);
        if (localObject != null)
        {
          ByteBuffer localByteBuffer = paramImageReader.getPlanes()[0].getBuffer();
          byte[] arrayOfByte = new byte[localByteBuffer.remaining()];
          localByteBuffer.get(arrayOfByte);
          ((Camera.PreviewCallback)localObject).onPreviewFrame(arrayOfByte, null);
        }
        paramImageReader.close();
        return;
      }
    }
    catch (Exception paramImageReader)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Camera2] onImageAvailable mPreviewReader exception:");
      ((StringBuilder)localObject).append(paramImageReader);
      Camera2Utils.a(1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control.4
 * JD-Core Version:    0.7.0.1
 */