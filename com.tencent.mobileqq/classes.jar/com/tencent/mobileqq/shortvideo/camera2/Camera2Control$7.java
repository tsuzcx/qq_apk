package com.tencent.mobileqq.shortvideo.camera2;

import android.os.Handler;
import com.samsung.android.sdk.camera.SCameraCaptureProcessor.CaptureCallback;
import java.nio.ByteBuffer;

class Camera2Control$7
  extends SCameraCaptureProcessor.CaptureCallback
{
  Camera2Control$7(Camera2Control paramCamera2Control, long paramLong) {}
  
  public void onError(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Camera2]Samsung Capture onError:");
    localStringBuilder.append(paramInt);
    Camera2Utils.a(1, localStringBuilder.toString());
    Camera2Control.a(this.b, 0L);
  }
  
  public void onPictureAvailable(ByteBuffer paramByteBuffer)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[Camera2]Samsung Capture cost:");
    ((StringBuilder)localObject).append((float)(System.currentTimeMillis() - this.a) / 1000.0F);
    Camera2Utils.a(1, ((StringBuilder)localObject).toString());
    Camera2Support.a(2, Camera2Control.o(this.b), System.currentTimeMillis() - this.a);
    if ((Camera2Control.f(this.b) != null) && (Camera2Control.j(this.b) != null) && (paramByteBuffer != null))
    {
      localObject = new byte[paramByteBuffer.remaining()];
      paramByteBuffer.get((byte[])localObject);
      Camera2Control.j(this.b).f = Camera2Control.k(this.b).b;
      Camera2Control.f(this.b).post(new Camera2Control.ImageSaveServer((byte[])localObject, Camera2Control.j(this.b)));
    }
    Camera2Control.a(this.b, 0L);
    Camera2Control.e(this.b, false);
    Camera2Control.e(this.b).a(0);
    Camera2Control.n(this.b);
  }
  
  public void onShutter()
  {
    Camera2Utils.a(1, "[Camera2]samsungCapture onShutter!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control.7
 * JD-Core Version:    0.7.0.1
 */