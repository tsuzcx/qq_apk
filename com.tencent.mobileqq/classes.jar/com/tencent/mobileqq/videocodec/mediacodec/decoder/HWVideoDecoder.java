package com.tencent.mobileqq.videocodec.mediacodec.decoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;

@TargetApi(16)
public class HWVideoDecoder
  implements IVideoDecoder
{
  private DecodeOutputSurface a;
  private Thread b;
  private HWVideoDecoder.DecodeRunnable c;
  
  private void a(DecodeConfig paramDecodeConfig, Surface paramSurface, HWDecodeListener paramHWDecodeListener)
  {
    if ((paramDecodeConfig != null) && (paramSurface != null))
    {
      SLog.b("HWVideoDecoder", "startDecode config = %s", paramDecodeConfig);
      Thread localThread = this.b;
      if (localThread != null)
      {
        c();
        try
        {
          localThread.join();
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      this.c = new HWVideoDecoder.DecodeRunnable(paramDecodeConfig.a, paramSurface, paramHWDecodeListener);
      this.c.a(paramDecodeConfig);
      this.b = ThreadManager.newFreeThread(this.c, "HWVideoDecoder-Thread", 8);
      this.b.start();
      return;
    }
    throw new IllegalArgumentException("both decodeConfig and surface should not be null");
  }
  
  public int a()
  {
    return this.c.a();
  }
  
  public void a(DecodeConfig paramDecodeConfig, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, HWDecodeListener paramHWDecodeListener)
  {
    this.a = new DecodeOutputSurface(paramInt, paramOnFrameAvailableListener);
    a(paramDecodeConfig, this.a.a, paramHWDecodeListener);
  }
  
  public int b()
  {
    return this.c.b();
  }
  
  public void c()
  {
    Thread localThread = this.b;
    if (localThread != null) {
      localThread.interrupt();
    }
    this.b = null;
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.decoder.HWVideoDecoder
 * JD-Core Version:    0.7.0.1
 */