package com.tencent.mobileqq.triton.jni;

import android.content.res.AssetManager;
import com.tencent.mobileqq.triton.api.TTChannel;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.font.FontBitmapManager;
import com.tencent.mobileqq.triton.internal.game.EngineScriptPackageBridge;
import com.tencent.mobileqq.triton.internal.game.GameDataFileSystemBridge;
import com.tencent.mobileqq.triton.internal.game.GameScriptPackageBridge;
import com.tencent.mobileqq.triton.internal.script.InspectorBridge;
import com.tencent.mobileqq.triton.internal.script.ScriptSystem;
import com.tencent.mobileqq.triton.internal.touch.TouchProviderBridge;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.mobileqq.triton.utils.CanvasRecorder;

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
  
  public static void nativeCreateTTApp(TTEngine paramTTEngine, RenderContext paramRenderContext, CanvasRecorder paramCanvasRecorder, TTChannel paramTTChannel, FontBitmapManager paramFontBitmapManager, InspectorBridge paramInspectorBridge, TouchProviderBridge paramTouchProviderBridge, EngineScriptPackageBridge paramEngineScriptPackageBridge, ScriptSystem paramScriptSystem)
  {
    try
    {
      paramTTEngine.nativeCreateTTApp(paramRenderContext, paramCanvasRecorder, paramTTChannel, paramFontBitmapManager, paramInspectorBridge, paramTouchProviderBridge, paramEngineScriptPackageBridge, paramScriptSystem);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramTTEngine.nativeCreateTTApp(paramRenderContext, paramCanvasRecorder, paramTTChannel, paramFontBitmapManager, paramInspectorBridge, paramTouchProviderBridge, paramEngineScriptPackageBridge, paramScriptSystem);
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
  
  public static void nativeInitGameInfo(TTEngine paramTTEngine, GameScriptPackageBridge paramGameScriptPackageBridge, GameDataFileSystemBridge paramGameDataFileSystemBridge)
  {
    try
    {
      paramTTEngine.nativeInitGameInfo(paramGameScriptPackageBridge, paramGameDataFileSystemBridge);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramTTEngine.nativeInitGameInfo(paramGameScriptPackageBridge, paramGameDataFileSystemBridge);
    }
  }
  
  public static void nativeOnVSync(TTEngine paramTTEngine, long paramLong)
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
  
  public static void nativeSetJankTraceLevel(TTEngine paramTTEngine, int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.jni.JNICaller.TTEngine
 * JD-Core Version:    0.7.0.1
 */