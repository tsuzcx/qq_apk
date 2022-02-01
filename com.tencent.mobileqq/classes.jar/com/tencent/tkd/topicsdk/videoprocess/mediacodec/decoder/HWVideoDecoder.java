package com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;
import com.tencent.tkd.topicsdk.framework.TLog;

@TargetApi(16)
public class HWVideoDecoder
  implements IVideoDecoder
{
  private Thread a;
  private HWVideoDecoder.DecodeRunnable b;
  
  private void a(DecodeConfig paramDecodeConfig, Surface paramSurface, HWDecodeListener paramHWDecodeListener)
  {
    if ((paramDecodeConfig != null) && (paramSurface != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDecode config = ");
      ((StringBuilder)localObject).append(paramDecodeConfig);
      TLog.a("HWVideoDecoder", ((StringBuilder)localObject).toString());
      localObject = this.a;
      if (localObject != null)
      {
        a();
        try
        {
          ((Thread)localObject).join();
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      this.b = new HWVideoDecoder.DecodeRunnable(paramDecodeConfig.a, paramSurface, paramHWDecodeListener);
      this.b.a(paramDecodeConfig);
      this.a = new Thread(this.b, "HWVideoDecoder-Thread");
      this.a.start();
      return;
    }
    throw new IllegalArgumentException("both decodeConfig and surface should not be null");
  }
  
  public void a()
  {
    Thread localThread = this.a;
    if (localThread != null) {
      localThread.interrupt();
    }
    this.a = null;
    this.b = null;
  }
  
  public void a(DecodeConfig paramDecodeConfig, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, HWDecodeListener paramHWDecodeListener)
  {
    a(paramDecodeConfig, new DecodeOutputSurface(paramInt, paramOnFrameAvailableListener).a, paramHWDecodeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.HWVideoDecoder
 * JD-Core Version:    0.7.0.1
 */