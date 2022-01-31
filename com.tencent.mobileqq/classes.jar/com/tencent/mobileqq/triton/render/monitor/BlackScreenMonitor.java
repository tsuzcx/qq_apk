package com.tencent.mobileqq.triton.render.monitor;

import android.opengl.GLES30;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.mobileqq.triton.render.RenderContext.ISwapListener;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import java.nio.IntBuffer;

public class BlackScreenMonitor
  implements RenderContext.ISwapListener
{
  private static final String TAG = "BlackScreenMonitor";
  private final long CHECK_BLACK_INTERVAL = 2000L;
  private long lastBlackTime = -1L;
  private long lastCheckBlackTime = 0L;
  private TTEngine mTritonEngine;
  
  public BlackScreenMonitor(TTEngine paramTTEngine)
  {
    this.mTritonEngine = paramTTEngine;
  }
  
  private void checkBlackScreen()
  {
    long l = System.currentTimeMillis();
    RenderContext localRenderContext;
    if (l - this.lastCheckBlackTime >= 2000L)
    {
      localRenderContext = this.mTritonEngine.getRenderContext();
      if (localRenderContext != null) {}
    }
    else
    {
      return;
    }
    this.lastCheckBlackTime = l;
    int i = localRenderContext.getCanvasWidth() / 2 - 64;
    int j = localRenderContext.getCanvasHeight() / 2 - 64;
    if ((i < 0) || (j < 0)) {
      try
      {
        TTLog.e("BlackScreenMonitor", "checkBlackScreen params error x=" + i + " y=" + j + " w=" + 128 + " h=" + 128);
        return;
      }
      catch (Exception localException)
      {
        TTLog.e("BlackScreenMonitor", "checkBlackScreen exception ", localException);
        return;
      }
    }
    int[] arrayOfInt = new int[16384];
    IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt);
    localIntBuffer.position(0);
    GLES30.glReadPixels(i, j, 128, 128, 6408, 5121, localIntBuffer);
    this.mTritonEngine.getQQEnv().postRunable(new BlackScreenMonitor.1(this, arrayOfInt));
  }
  
  public long getLastBlackTime()
  {
    return this.lastBlackTime;
  }
  
  public void onSwap()
  {
    checkBlackScreen();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.monitor.BlackScreenMonitor
 * JD-Core Version:    0.7.0.1
 */