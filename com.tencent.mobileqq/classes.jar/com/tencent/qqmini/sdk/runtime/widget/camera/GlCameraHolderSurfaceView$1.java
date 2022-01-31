package com.tencent.qqmini.sdk.runtime.widget.camera;

import android.hardware.Camera.Size;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

class GlCameraHolderSurfaceView$1
  implements Runnable
{
  GlCameraHolderSurfaceView$1(GlCameraHolderSurfaceView paramGlCameraHolderSurfaceView, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Log.d("GlCameraHolderSurfaceVi", "run: execute");
    byte[] arrayOfByte = new byte[this.a.length];
    int i = 0;
    while (i < this.this$0.a.height)
    {
      int j = 0;
      while (j < this.this$0.a.width)
      {
        arrayOfByte[(this.this$0.a.height * j + this.this$0.a.height - i - 1)] = this.a[(this.this$0.a.width * i + j)];
        j += 1;
      }
      i += 1;
    }
    i = this.this$0.a.height;
    i = this.this$0.a.width;
    GlCameraHolderSurfaceView.a(this.this$0).set(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.camera.GlCameraHolderSurfaceView.1
 * JD-Core Version:    0.7.0.1
 */