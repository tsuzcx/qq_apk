package com.tencent.mobileqq.triton.jni;

import android.content.res.AssetManager;
import com.tencent.mobileqq.triton.api.TTChannel;
import com.tencent.mobileqq.triton.api.http.NativeHttp;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTEngine.InspectorBridge;
import com.tencent.mobileqq.triton.font.FontBitmapManager;
import com.tencent.mobileqq.triton.game.GameLauncher;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.mobileqq.triton.utils.CanvasRecorder;
import com.tencent.mobileqq.triton.views.GameUserInfoBtnManager;

public final class JNICaller$TTEngine
{
  public static int getProcessedMessageCount(TTEngine paramTTEngine)
  {
    try
    {
      int i = paramTTEngine.getProcessedMessageCount();
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramTTEngine.getProcessedMessageCount();
  }
  
  public static void interruptLoop(TTEngine paramTTEngine)
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
  
  public static long nativeCanvasPresent(TTEngine paramTTEngine)
  {
    try
    {
      long l = paramTTEngine.nativeCanvasPresent();
      return l;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramTTEngine.nativeCanvasPresent();
  }
  
  public static void nativeCreateTTApp(TTEngine paramTTEngine, RenderContext paramRenderContext, CanvasRecorder paramCanvasRecorder, TTChannel paramTTChannel, GameUserInfoBtnManager paramGameUserInfoBtnManager, GameLauncher paramGameLauncher, NativeHttp paramNativeHttp, FontBitmapManager paramFontBitmapManager, TTEngine.InspectorBridge paramInspectorBridge)
  {
    try
    {
      paramTTEngine.nativeCreateTTApp(paramRenderContext, paramCanvasRecorder, paramTTChannel, paramGameUserInfoBtnManager, paramGameLauncher, paramNativeHttp, paramFontBitmapManager, paramInspectorBridge);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramTTEngine.nativeCreateTTApp(paramRenderContext, paramCanvasRecorder, paramTTChannel, paramGameUserInfoBtnManager, paramGameLauncher, paramNativeHttp, paramFontBitmapManager, paramInspectorBridge);
    }
  }
  
  public static void nativeDiposeTTApp(TTEngine paramTTEngine)
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
  
  public static void nativeEnableJankTrace(TTEngine paramTTEngine, boolean paramBoolean)
  {
    try
    {
      paramTTEngine.nativeEnableJankTrace(paramBoolean);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramTTEngine.nativeEnableJankTrace(paramBoolean);
    }
  }
  
  public static boolean nativeEnvInit(TTEngine paramTTEngine)
  {
    try
    {
      boolean bool = paramTTEngine.nativeEnvInit();
      return bool;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramTTEngine.nativeEnvInit();
  }
  
  public static void nativeFinalize(TTEngine paramTTEngine)
  {
    try
    {
      paramTTEngine.nativeFinalize();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramTTEngine.nativeFinalize();
    }
  }
  
  public static void nativeFontManagerInit(AssetManager paramAssetManager, String paramString)
  {
    try
    {
      TTEngine.nativeFontManagerInit(paramAssetManager, paramString);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      TTEngine.nativeFontManagerInit(paramAssetManager, paramString);
    }
  }
  
  public static long nativeGetCurrentFrameDrawCallCount(TTEngine paramTTEngine)
  {
    try
    {
      long l = paramTTEngine.nativeGetCurrentFrameDrawCallCount();
      return l;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramTTEngine.nativeGetCurrentFrameDrawCallCount();
  }
  
  public static String nativeGetTTVersion()
  {
    try
    {
      String str = TTEngine.nativeGetTTVersion();
      return str;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return TTEngine.nativeGetTTVersion();
  }
  
  public static int nativeLoadScriptPathWithCodeCache(TTEngine paramTTEngine, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      int i = paramTTEngine.nativeLoadScriptPathWithCodeCache(paramInt, paramString1, paramString2, paramString3);
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramTTEngine.nativeLoadScriptPathWithCodeCache(paramInt, paramString1, paramString2, paramString3);
  }
  
  public static int nativeLoadScriptStringWithCodeCache(TTEngine paramTTEngine, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      int i = paramTTEngine.nativeLoadScriptStringWithCodeCache(paramInt, paramString1, paramString2, paramString3);
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramTTEngine.nativeLoadScriptStringWithCodeCache(paramInt, paramString1, paramString2, paramString3);
  }
  
  public static long nativeOnVSync(TTEngine paramTTEngine, long paramLong)
  {
    try
    {
      long l = paramTTEngine.nativeOnVSync(paramLong);
      return l;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramTTEngine.nativeOnVSync(paramLong);
  }
  
  public static void nativePause(TTEngine paramTTEngine)
  {
    try
    {
      paramTTEngine.nativePause();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramTTEngine.nativePause();
    }
  }
  
  public static void nativeResume(TTEngine paramTTEngine)
  {
    try
    {
      paramTTEngine.nativeResume();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramTTEngine.nativeResume();
    }
  }
  
  public static void nativeSaveScriptCodeCache(TTEngine paramTTEngine)
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
  
  public static boolean nativeStartDrawCall(TTEngine paramTTEngine)
  {
    try
    {
      boolean bool = paramTTEngine.nativeStartDrawCall();
      return bool;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramTTEngine.nativeStartDrawCall();
  }
  
  public static void postRunnableDelayedWithPriority(TTEngine paramTTEngine, Runnable paramRunnable, long paramLong, int paramInt)
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
  
  public static boolean runLoop(TTEngine paramTTEngine, boolean paramBoolean)
  {
    try
    {
      boolean bool = paramTTEngine.runLoop(paramBoolean);
      return bool;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramTTEngine.runLoop(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.jni.JNICaller.TTEngine
 * JD-Core Version:    0.7.0.1
 */