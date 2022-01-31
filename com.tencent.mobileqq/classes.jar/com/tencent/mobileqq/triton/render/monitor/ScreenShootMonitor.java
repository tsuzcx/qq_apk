package com.tencent.mobileqq.triton.render.monitor;

import android.opengl.GLES30;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.mobileqq.triton.render.RenderContext.ISwapListener;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.callback.ScreenShotCallback;
import java.nio.IntBuffer;

public class ScreenShootMonitor
  implements RenderContext.ISwapListener
{
  private static final String TAG = "ScreenShootMonitor";
  private TTEngine mTritonEngine;
  private ScreenShotCallback screenShotCallback;
  private boolean screenShotFlag = false;
  
  public ScreenShootMonitor(TTEngine paramTTEngine)
  {
    this.mTritonEngine = paramTTEngine;
  }
  
  private void checkScreenShoot()
  {
    RenderContext localRenderContext = this.mTritonEngine.getRenderContext();
    if ((this.screenShotFlag) && (localRenderContext != null))
    {
      this.screenShotFlag = false;
      createScreenShot(0, 0, localRenderContext.getCanvasWidth(), localRenderContext.getCanvasHeight());
    }
  }
  
  private void createScreenShot(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0) || (paramInt1 >= paramInt3) || (paramInt2 >= paramInt4)) {}
    try
    {
      TTLog.e("ScreenShootMonitor", "createScreenShot params error x=" + paramInt1 + " y=" + paramInt2 + " w=" + paramInt3 + " h=" + paramInt4);
      return;
    }
    catch (Exception localException)
    {
      int[] arrayOfInt;
      IntBuffer localIntBuffer;
      TTLog.e("ScreenShootMonitor", "createScreenShot exception ", localException);
    }
    arrayOfInt = new int[paramInt3 * paramInt4];
    localIntBuffer = IntBuffer.wrap(arrayOfInt);
    localIntBuffer.position(0);
    GLES30.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, localIntBuffer);
    this.mTritonEngine.getQQEnv().postRunable(new ScreenShootMonitor.1(this, paramInt3, paramInt4, arrayOfInt));
    return;
  }
  
  public void getGameScreenShot(ScreenShotCallback paramScreenShotCallback)
  {
    if (paramScreenShotCallback != null)
    {
      this.screenShotCallback = paramScreenShotCallback;
      this.screenShotFlag = true;
    }
  }
  
  public void onSwap()
  {
    checkScreenShoot();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.monitor.ScreenShootMonitor
 * JD-Core Version:    0.7.0.1
 */