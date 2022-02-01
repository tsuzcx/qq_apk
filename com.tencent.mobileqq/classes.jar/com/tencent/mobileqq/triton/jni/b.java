package com.tencent.mobileqq.triton.jni;

import com.tencent.mobileqq.triton.api.TTChannel;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTEngine.InspectorBridge;
import com.tencent.mobileqq.triton.font.FontBitmapManager;
import com.tencent.mobileqq.triton.game.GameLauncher;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.mobileqq.triton.utils.CanvasRecorder;

public final class b
{
  public static int a(TTEngine paramTTEngine, int paramInt, String paramString1, String paramString2, String paramString3, long[] paramArrayOfLong, String[] paramArrayOfString)
  {
    try
    {
      int i = paramTTEngine.nativeLoadScriptPathWithCodeCache(paramInt, paramString1, paramString2, paramString3, paramArrayOfLong, paramArrayOfString);
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramTTEngine.nativeLoadScriptPathWithCodeCache(paramInt, paramString1, paramString2, paramString3, paramArrayOfLong, paramArrayOfString);
  }
  
  public static String a()
  {
    try
    {
      String str = TTEngine.nativeGetTTVersion();
      return str;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return TTEngine.nativeGetTTVersion();
  }
  
  public static void a(TTEngine paramTTEngine)
  {
    try
    {
      paramTTEngine.interruptLoop();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramTTEngine.interruptLoop();
    }
  }
  
  public static void a(TTEngine paramTTEngine, int paramInt)
  {
    try
    {
      paramTTEngine.nativeSetJankTraceLevel(paramInt);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramTTEngine.nativeSetJankTraceLevel(paramInt);
    }
  }
  
  public static void a(TTEngine paramTTEngine, long paramLong)
  {
    try
    {
      paramTTEngine.nativeOnVSync(paramLong);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramTTEngine.nativeOnVSync(paramLong);
    }
  }
  
  public static void a(TTEngine paramTTEngine, RenderContext paramRenderContext, CanvasRecorder paramCanvasRecorder, TTChannel paramTTChannel, GameLauncher paramGameLauncher, FontBitmapManager paramFontBitmapManager, TTEngine.InspectorBridge paramInspectorBridge)
  {
    try
    {
      paramTTEngine.nativeCreateTTApp(paramRenderContext, paramCanvasRecorder, paramTTChannel, paramGameLauncher, paramFontBitmapManager, paramInspectorBridge);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramTTEngine.nativeCreateTTApp(paramRenderContext, paramCanvasRecorder, paramTTChannel, paramGameLauncher, paramFontBitmapManager, paramInspectorBridge);
    }
  }
  
  public static void a(TTEngine paramTTEngine, Runnable paramRunnable, long paramLong, int paramInt)
  {
    try
    {
      paramTTEngine.postRunnableDelayedWithPriority(paramRunnable, paramLong, paramInt);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramTTEngine.postRunnableDelayedWithPriority(paramRunnable, paramLong, paramInt);
    }
  }
  
  public static boolean a(TTEngine paramTTEngine, boolean paramBoolean)
  {
    try
    {
      boolean bool = paramTTEngine.runLoop(paramBoolean);
      return bool;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramTTEngine.runLoop(paramBoolean);
  }
  
  public static long b(TTEngine paramTTEngine)
  {
    try
    {
      long l = paramTTEngine.nativeCanvasPresent();
      return l;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramTTEngine.nativeCanvasPresent();
  }
  
  public static void c(TTEngine paramTTEngine)
  {
    try
    {
      paramTTEngine.nativeDiposeTTApp();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramTTEngine.nativeDiposeTTApp();
    }
  }
  
  public static boolean d(TTEngine paramTTEngine)
  {
    try
    {
      boolean bool = paramTTEngine.nativeEnvInit();
      return bool;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramTTEngine.nativeEnvInit();
  }
  
  public static long e(TTEngine paramTTEngine)
  {
    try
    {
      long l = paramTTEngine.nativeGetCurrentFrameDrawCallCount();
      return l;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramTTEngine.nativeGetCurrentFrameDrawCallCount();
  }
  
  public static void f(TTEngine paramTTEngine)
  {
    try
    {
      paramTTEngine.nativeSaveScriptCodeCache();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramTTEngine.nativeSaveScriptCodeCache();
    }
  }
  
  public static boolean g(TTEngine paramTTEngine)
  {
    try
    {
      boolean bool = paramTTEngine.nativeStartDrawCall();
      return bool;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramTTEngine.nativeStartDrawCall();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.jni.b
 * JD-Core Version:    0.7.0.1
 */