package com.tencent.mobileqq.triton.jni;

import android.view.Surface;
import com.tencent.mobileqq.triton.render.RenderContext;

public final class JNICaller$RenderContext
{
  public static void nExit(RenderContext paramRenderContext, long paramLong)
  {
    try
    {
      paramRenderContext.nExit(paramLong);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label6:
      break label6;
    }
    paramRenderContext.nExit(paramLong);
  }
  
  public static void nInitRenderContext(RenderContext paramRenderContext, long paramLong, Surface paramSurface, boolean paramBoolean, int paramInt1, int paramInt2, float paramFloat)
  {
    try
    {
      paramRenderContext.nInitRenderContext(paramLong, paramSurface, paramBoolean, paramInt1, paramInt2, paramFloat);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label15:
      break label15;
    }
    paramRenderContext.nInitRenderContext(paramLong, paramSurface, paramBoolean, paramInt1, paramInt2, paramFloat);
  }
  
  public static void nOnPause(RenderContext paramRenderContext, long paramLong)
  {
    try
    {
      paramRenderContext.nOnPause(paramLong);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label6:
      break label6;
    }
    paramRenderContext.nOnPause(paramLong);
  }
  
  public static void nOnResume(RenderContext paramRenderContext, long paramLong)
  {
    try
    {
      paramRenderContext.nOnResume(paramLong);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label6:
      break label6;
    }
    paramRenderContext.nOnResume(paramLong);
  }
  
  public static void nSurfaceChanged(RenderContext paramRenderContext, long paramLong, Surface paramSurface)
  {
    try
    {
      paramRenderContext.nSurfaceChanged(paramLong, paramSurface);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label7:
      break label7;
    }
    paramRenderContext.nSurfaceChanged(paramLong, paramSurface);
  }
  
  public static void nSurfaceDestroyed(RenderContext paramRenderContext, long paramLong)
  {
    try
    {
      paramRenderContext.nSurfaceDestroyed(paramLong);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label6:
      break label6;
    }
    paramRenderContext.nSurfaceDestroyed(paramLong);
  }
  
  public static void nUpdateRenderContext(RenderContext paramRenderContext, long paramLong)
  {
    try
    {
      paramRenderContext.nUpdateRenderContext(paramLong);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label6:
      break label6;
    }
    paramRenderContext.nUpdateRenderContext(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.jni.JNICaller.RenderContext
 * JD-Core Version:    0.7.0.1
 */