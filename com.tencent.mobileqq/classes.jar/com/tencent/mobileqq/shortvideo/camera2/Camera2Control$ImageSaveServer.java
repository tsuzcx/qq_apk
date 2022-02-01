package com.tencent.mobileqq.shortvideo.camera2;

import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import java.io.File;

class Camera2Control$ImageSaveServer
  implements Runnable
{
  private final byte[] a;
  private final Camera2Control.Camera2PictureData b;
  
  Camera2Control$ImageSaveServer(byte[] paramArrayOfByte, Camera2Control.Camera2PictureData paramCamera2PictureData)
  {
    this.a = paramArrayOfByte;
    this.b = paramCamera2PictureData;
  }
  
  public void run()
  {
    byte[] arrayOfByte = this.a;
    String str = null;
    if (arrayOfByte == null)
    {
      Camera2Utils.a(2, "[Camera2]ImageSaveServer params error!");
      if (this.b.c != null) {
        this.b.c.a(null);
      }
      return;
    }
    int i = Camera2Utils.a(this.b.f, this.b.d);
    boolean bool = this.b.e;
    try
    {
      ImageUtil.b(CameraUtils.b(this.a, this.b.b, bool, i), this.b.a);
      i = 1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2]ImageSaveServer OutOfMemoryError:");
      localStringBuilder.append(localOutOfMemoryError);
      Camera2Utils.a(2, localStringBuilder.toString());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2]ImageSaveServer Exception:");
      localStringBuilder.append(localException);
      Camera2Utils.a(2, localStringBuilder.toString());
    }
    i = 0;
    if (this.b.c != null)
    {
      CameraCover.PictureCallback localPictureCallback = this.b.c;
      if (i != 0) {
        str = this.b.a.getAbsolutePath();
      }
      localPictureCallback.a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control.ImageSaveServer
 * JD-Core Version:    0.7.0.1
 */