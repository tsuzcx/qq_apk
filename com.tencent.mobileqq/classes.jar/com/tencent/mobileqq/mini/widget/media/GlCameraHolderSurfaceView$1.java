package com.tencent.mobileqq.mini.widget.media;

import android.hardware.Camera.Size;
import android.util.Log;
import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.BinaryBitmap;
import com.tencent.mobileqq.mini.zxing.MultiFormatReader;
import com.tencent.mobileqq.mini.zxing.PlanarYUVLuminanceSource;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.common.HybridBinarizer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class GlCameraHolderSurfaceView$1
  implements Runnable
{
  GlCameraHolderSurfaceView$1(GlCameraHolderSurfaceView paramGlCameraHolderSurfaceView, byte[] paramArrayOfByte, long paramLong) {}
  
  public void run()
  {
    Log.d("GlCameraHolderSurfaceVi", "run: execute");
    Object localObject1 = new byte[this.val$data.length];
    int i = 0;
    while (i < this.this$0.cameraSize.height)
    {
      j = 0;
      while (j < this.this$0.cameraSize.width)
      {
        localObject1[(this.this$0.cameraSize.height * j + this.this$0.cameraSize.height - i - 1)] = this.val$data[(this.this$0.cameraSize.width * i + j)];
        j += 1;
      }
      i += 1;
    }
    i = this.this$0.cameraSize.height;
    int j = this.this$0.cameraSize.width;
    try
    {
      localObject1 = new BinaryBitmap(new HybridBinarizer(new PlanarYUVLuminanceSource((byte[])localObject1, i, j, 0, 0, i, j, false)));
      Log.d("GlCameraHolderSurfaceVi", "run: " + ((BinaryBitmap)localObject1).getWidth() + ":" + ((BinaryBitmap)localObject1).getHeight());
      localObject1 = GlCameraHolderSurfaceView.access$000(this.this$0).decodeWithState((BinaryBitmap)localObject1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l;
        String str;
        Log.d("GlCameraHolderSurfaceVi", "run: failed to decode frame", localException);
        GlCameraHolderSurfaceView.access$000(this.this$0).reset();
        Object localObject2 = null;
      }
    }
    finally
    {
      GlCameraHolderSurfaceView.access$000(this.this$0).reset();
    }
    if (localObject1 != null)
    {
      l = System.nanoTime();
      str = ((Result)localObject1).getText();
      Log.i("GlCameraHolderSurfaceVi", "Found barcode in " + TimeUnit.NANOSECONDS.toMillis(l - this.val$start) + " ms, " + str + ", " + ((Result)localObject1).getBarcodeFormat().name());
      this.this$0.onCodeRead(str);
    }
    GlCameraHolderSurfaceView.access$100(this.this$0).set(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.GlCameraHolderSurfaceView.1
 * JD-Core Version:    0.7.0.1
 */