package com.tencent.mobileqq.triton.jni;

import android.view.Surface;
import com.tencent.mobileqq.triton.render.RenderContext;

public final class a
{
  public static void a(RenderContext paramRenderContext, long paramLong)
  {
    try
    {
      paramRenderContext.nExit(paramLong);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramRenderContext.nExit(paramLong);
    }
  }
  
  public static void a(RenderContext paramRenderContext, long paramLong, Surface paramSurface)
  {
    try
    {
      paramRenderContext.nSurfaceChanged(paramLong, paramSurface);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramRenderContext.nSurfaceChanged(paramLong, paramSurface);
    }
  }
  
  public static void a(RenderContext paramRenderContext, long paramLong, Surface paramSurface, boolean paramBoolean, int paramInt1, int paramInt2, float paramFloat)
  {
    try
    {
      paramRenderContext.nInitRenderContext(paramLong, paramSurface, paramBoolean, paramInt1, paramInt2, paramFloat);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramRenderContext.nInitRenderContext(paramLong, paramSurface, paramBoolean, paramInt1, paramInt2, paramFloat);
    }
  }
  
  public static void b(RenderContext paramRenderContext, long paramLong)
  {
    try
    {
      paramRenderContext.nOnPause(paramLong);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramRenderContext.nOnPause(paramLong);
    }
  }
  
  public static void c(RenderContext paramRenderContext, long paramLong)
  {
    try
    {
      paramRenderContext.nOnResume(paramLong);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramRenderContext.nOnResume(paramLong);
    }
  }
  
  public static void d(RenderContext paramRenderContext, long paramLong)
  {
    try
    {
      paramRenderContext.nSurfaceDestroyed(paramLong);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramRenderContext.nSurfaceDestroyed(paramLong);
    }
  }
  
  public static void e(RenderContext paramRenderContext, long paramLong)
  {
    try
    {
      paramRenderContext.nUpdateRenderContext(paramLong);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramRenderContext.nUpdateRenderContext(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.jni.a
 * JD-Core Version:    0.7.0.1
 */