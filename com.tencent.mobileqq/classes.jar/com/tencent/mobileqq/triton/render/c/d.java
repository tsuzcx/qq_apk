package com.tencent.mobileqq.triton.render.c;

import android.opengl.GLES30;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.mobileqq.triton.render.RenderContext.a;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.callback.ScreenShotCallback;
import java.nio.IntBuffer;

public class d
  implements RenderContext.a
{
  private TTEngine a;
  private ScreenShotCallback b;
  private boolean c = false;
  
  public d(TTEngine paramTTEngine)
  {
    this.a = paramTTEngine;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0) || (paramInt1 >= paramInt3) || (paramInt2 >= paramInt4)) {}
    try
    {
      TTLog.b("ScreenShootMonitor", "createScreenShot params error x=" + paramInt1 + " y=" + paramInt2 + " w=" + paramInt3 + " h=" + paramInt4);
      return;
    }
    catch (Exception localException)
    {
      int[] arrayOfInt;
      IntBuffer localIntBuffer;
      TTLog.b("ScreenShootMonitor", "createScreenShot exception ", localException);
    }
    arrayOfInt = new int[paramInt3 * paramInt4];
    localIntBuffer = IntBuffer.wrap(arrayOfInt);
    localIntBuffer.position(0);
    GLES30.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, localIntBuffer);
    this.a.l().postRunable(new d.a(this, paramInt3, paramInt4, arrayOfInt));
    return;
  }
  
  private void b()
  {
    RenderContext localRenderContext = this.a.m();
    if ((this.c) && (localRenderContext != null))
    {
      this.c = false;
      a(0, 0, localRenderContext.c(), localRenderContext.b());
    }
  }
  
  public void a()
  {
    b();
  }
  
  public void a(ScreenShotCallback paramScreenShotCallback)
  {
    if (paramScreenShotCallback != null)
    {
      this.b = paramScreenShotCallback;
      this.c = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.c.d
 * JD-Core Version:    0.7.0.1
 */