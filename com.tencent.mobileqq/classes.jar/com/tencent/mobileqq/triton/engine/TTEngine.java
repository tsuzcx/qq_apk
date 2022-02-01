package com.tencent.mobileqq.triton.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.hardware.display.DisplayManager;
import android.os.SystemClock;
import android.view.Display;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.triton.annotation.JNIModule;
import com.tencent.mobileqq.triton.api.TTChannel;
import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonInitException;
import com.tencent.mobileqq.triton.font.FontBitmapManager;
import com.tencent.mobileqq.triton.game.GameLauncher;
import com.tencent.mobileqq.triton.internal.debug.JankCanaryAgent;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.engine.StatisticsManagerImpl;
import com.tencent.mobileqq.triton.internal.engine.TTAppAgent;
import com.tencent.mobileqq.triton.internal.game.EngineScriptPackageBridge;
import com.tencent.mobileqq.triton.internal.game.GameDataFileSystemBridge;
import com.tencent.mobileqq.triton.internal.game.GameScriptPackageBridge;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.model.PlatformConfig;
import com.tencent.mobileqq.triton.internal.script.InspectorBridge;
import com.tencent.mobileqq.triton.internal.script.ScriptSystem;
import com.tencent.mobileqq.triton.internal.touch.TouchProviderBridge;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.jni.JNICaller.TTEngine;
import com.tencent.mobileqq.triton.model.DebugConfig;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.mobileqq.triton.script.InspectorAgent;
import com.tencent.mobileqq.triton.statistic.NativeLibraryLoadStatistic;
import com.tencent.mobileqq.triton.utils.CanvasRecorder;
import com.tencent.mobileqq.triton.utils.TritonKeep;
import io.github.landerlyoung.jenny.NativeFieldProxy;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import io.github.landerlyoung.jenny.NativeProxyForClasses;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@JNIModule
@TritonKeep
@NativeProxy(allFields=false, allMethods=false, namespace="jni")
@NativeProxyForClasses(classes={Runnable.class}, namespace="jni")
public class TTEngine
{
  static final String NAME = "TTEngine";
  @TritonKeep
  private final CanvasRecorder mCanvasRecorder;
  private final Context mContext;
  private final EngineContext mEngineContext;
  private long mEngineInitLoadSoEndTime;
  private long mEngineInitStartTime;
  private final GameLauncher mGameLauncher;
  private volatile boolean mInitJSContext = false;
  private InspectorBridge mInspectorBridge;
  private JankCanaryAgent mJankCanary;
  private EngineScriptLoader mJsRuntimeLoader;
  private final ArrayList<NativeLibraryLoadStatistic> mNativeLibraryLoadStatistics = new ArrayList();
  private final PlatformConfig mPlatformConfig;
  private volatile RenderContext mRenderContext;
  private volatile ScriptService mScriptEngine;
  @TritonKeep
  private final TTChannel mTTChannel;
  private TouchProviderBridge mTouchEventManager;
  @TritonKeep
  @NativeFieldProxy(getter=true, setter=false)
  private long nativeTTAppHandle;
  private final String tag = "TTEngine@" + Integer.toHexString(System.identityHashCode(this));
  
  public TTEngine(PlatformConfig paramPlatformConfig, EngineContext paramEngineContext, List<NativeLibraryLoadStatistic> paramList)
  {
    this.mPlatformConfig = paramPlatformConfig;
    this.mEngineContext = paramEngineContext;
    this.mNativeLibraryLoadStatistics.addAll(paramList);
    this.mContext = paramPlatformConfig.getContext();
    this.nativeTTAppHandle = 0L;
    this.mTTChannel = new TTChannel(paramPlatformConfig.getDebugConfig());
    this.mGameLauncher = new GameLauncher(this);
    this.mJsRuntimeLoader = new EngineScriptLoader(paramEngineContext);
    this.mCanvasRecorder = new CanvasRecorder(this);
    bindErrorCallback(paramEngineContext);
    initEngine();
  }
  
  private void bindErrorCallback(EngineContext paramEngineContext)
  {
    this.mTTChannel.setOnScriptErrorCallback(new TTEngine.1(this, paramEngineContext));
    this.mTTChannel.setOnRenderErrorCallback(new TTEngine.2(this, paramEngineContext));
  }
  
  private static float getScreenRefreshRate(Context paramContext)
  {
    paramContext = ((DisplayManager)paramContext.getSystemService("display")).getDisplays();
    if ((paramContext != null) && (paramContext.length > 0)) {
      return paramContext[0].getRefreshRate();
    }
    return 60.0F;
  }
  
  private void initEngine()
  {
    try
    {
      this.mEngineInitStartTime = SystemClock.uptimeMillis();
      Logger.i(this.tag, "initEngine load triton version : " + JNICaller.TTEngine.nativeGetTTVersion() + " classLoader:" + getClass().getClassLoader());
      this.mEngineContext.getStatisticsManager().getTargetFPSHolder().setValue(Float.valueOf(getScreenRefreshRate(this.mContext)));
      if (!JNICaller.TTEngine.nativeEnvInit(this))
      {
        Logger.e(this.tag, "initEngine nativeEnvInit fail!");
        onInitFinish(ErrorCodes.NATIVE_FUNCTION_CALL);
        throw new TritonInitException("initEngine nativeEnvInit fail!", ErrorCodes.NATIVE_FUNCTION_CALL);
      }
    }
    finally {}
    this.mInspectorBridge = new InspectorBridge(getEngineContext().getLifeCycleOwner());
    this.mJankCanary = new JankCanaryAgent(TTAppAgent.nativeGetInstance(this.nativeTTAppHandle, 1), new TTEngine.3(this), this.mEngineContext.getMainThreadExecutor(), getEngineContext().getStatisticsManager().getJankTraceLevelHolder(), getEngineContext().getStatisticsManager().getTraceInfoCallbackHolder());
    ValueHolder localValueHolder = new ValueHolder(Boolean.valueOf(false), getEngineContext());
    localValueHolder.observe(new TTEngine.4(this));
    this.mTouchEventManager = new TouchProviderBridge(this.mJankCanary, getEngineContext().getLifeCycleOwner(), getEngineContext().getStatisticsManager().getLastClicksHolder(), getEngineContext().getStatisticsManager().getLastClickInfoHolder());
    StatisticsManagerImpl localStatisticsManagerImpl = getEngineContext().getStatisticsManager();
    this.mRenderContext = new RenderContext(new TTEngine.5(this), getEngineContext().getLifeCycleOwner(), this.nativeTTAppHandle, localStatisticsManagerImpl.getCurrentFPSHolder(), localStatisticsManagerImpl.getLastBlackScreenTimeMillisHolder(), localValueHolder, localStatisticsManagerImpl.getAccumulatedDrawCallsHolder(), getEngineContext().getScreenShotCallbackHolder(), this.mContext, this.mPlatformConfig.getWorkerExecutor(), this.mPlatformConfig.getMainThreadExecutor(), this.mTouchEventManager, this.mPlatformConfig.getEnableOpenGlEs3());
    this.mEngineInitLoadSoEndTime = SystemClock.uptimeMillis();
    this.mScriptEngine = new ScriptService(this, this.mEngineContext.getStatisticsManager().getTargetFPSHolder(), this.mEngineContext.getStatisticsManager().getFrameCallbackHolder(), this.mEngineContext.getStatisticsManager().getAccumulatedDrawCallsHolder(), this.mEngineContext.getStatisticsManager().getCurrentDrawCallsHolder(), this.mEngineContext.getStatisticsManager().getAccumulatedFramesHolder(), this.mPlatformConfig.getDebugConfig().getDebugEnabled());
    this.mScriptEngine.awaitStart();
    this.mInitJSContext = true;
  }
  
  public static native void nativeFontManagerInit(AssetManager paramAssetManager, String paramString);
  
  public static native String nativeGetTTVersion();
  
  @TritonKeep
  @NativeMethodProxy
  private void setTargetFPS(int paramInt)
  {
    if (paramInt > 0) {
      getEngineContext().getStatisticsManager().getTargetFPSHolder().setValue(Float.valueOf(paramInt));
    }
  }
  
  public void createTTApp()
  {
    JNICaller.TTEngine.nativeCreateTTApp(this, getRenderContext(), getCanvasRecorder(), getTTChannel(), this.mEngineContext.getFontBitmapManager(), this.mInspectorBridge, this.mRenderContext.getTouchEventManager(), new EngineScriptPackageBridge(this.mEngineContext.getEnginePackage()), this.mEngineContext.getScriptSystem());
  }
  
  public CanvasRecorder getCanvasRecorder()
  {
    return this.mCanvasRecorder;
  }
  
  public long getCurrentDrawCount()
  {
    return getEngineContext().getStatisticsManager().getCurrentDrawCalls();
  }
  
  public EngineContext getEngineContext()
  {
    return this.mEngineContext;
  }
  
  public GameLauncher getGameLauncher()
  {
    return this.mGameLauncher;
  }
  
  public EngineScriptLoader getJsRuntimeLoader()
  {
    return this.mJsRuntimeLoader;
  }
  
  public long getNativeTTAppHandle()
  {
    return this.nativeTTAppHandle;
  }
  
  public native int getProcessedMessageCount();
  
  public RenderContext getRenderContext()
  {
    return this.mRenderContext;
  }
  
  public TTChannel getTTChannel()
  {
    return this.mTTChannel;
  }
  
  public void initGameInfo()
  {
    JNICaller.TTEngine.nativeInitGameInfo(this, new GameScriptPackageBridge(this.mEngineContext.getGamePackage()), new GameDataFileSystemBridge(this.mEngineContext.getDataFileSystem()));
  }
  
  public native void interruptLoop();
  
  public native long nativeCanvasPresent();
  
  public native void nativeCreateTTApp(RenderContext paramRenderContext, CanvasRecorder paramCanvasRecorder, TTChannel paramTTChannel, FontBitmapManager paramFontBitmapManager, InspectorBridge paramInspectorBridge, TouchProviderBridge paramTouchProviderBridge, EngineScriptPackageBridge paramEngineScriptPackageBridge, ScriptSystem paramScriptSystem);
  
  public native void nativeDiposeTTApp();
  
  public native boolean nativeEnvInit();
  
  public native void nativeFinalize();
  
  public native long nativeGetCurrentFrameDrawCallCount();
  
  public native void nativeInitGameInfo(GameScriptPackageBridge paramGameScriptPackageBridge, GameDataFileSystemBridge paramGameDataFileSystemBridge);
  
  public native void nativeOnVSync(long paramLong);
  
  public native void nativePause();
  
  public native void nativeResume();
  
  public native void nativeSaveScriptCodeCache();
  
  public native void nativeSetJankTraceLevel(int paramInt);
  
  public native boolean nativeStartDrawCall();
  
  public void onDestroy()
  {
    Logger.i(this.tag, "~TTEngine " + this);
    this.mInitJSContext = false;
    if (this.mRenderContext != null) {
      this.mRenderContext.onDestroy();
    }
    if (this.mScriptEngine != null) {
      this.mScriptEngine.onDestroy();
    }
  }
  
  public void onInitFinish(ErrorCodes paramErrorCodes)
  {
    this.mGameLauncher.onInitDone(paramErrorCodes, this.mEngineInitLoadSoEndTime - this.mEngineInitStartTime, getJsRuntimeLoader().getLoadScriptScriptTimeMs(), SystemClock.uptimeMillis() - getJsRuntimeLoader().getLoadEngineScriptEndTime(), SystemClock.uptimeMillis() - this.mEngineInitStartTime, this.mJsRuntimeLoader.getEngineScriptLoadStatics(), this.mJsRuntimeLoader.getEngineScriptInitException(), this.mNativeLibraryLoadStatistics);
  }
  
  public void onPause()
  {
    if (this.mScriptEngine != null) {
      this.mScriptEngine.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.mScriptEngine != null) {
      this.mScriptEngine.onResume();
    }
  }
  
  public boolean postRunnable(@NonNull Runnable paramRunnable)
  {
    return postRunnableDelayed(paramRunnable, 0L);
  }
  
  public boolean postRunnableDelayed(@NonNull Runnable paramRunnable, long paramLong)
  {
    try
    {
      this.mEngineContext.getLock().lock();
      if (this.mEngineContext.getEngineState() == EngineState.DESTROYED)
      {
        Logger.w(this.tag, "postRunnable after engine is destroyed " + paramRunnable + " to " + this);
        return false;
      }
      JNICaller.TTEngine.postRunnableDelayedWithPriority(this, new TTEngine.6(this, paramRunnable), paramLong, 0);
      return true;
    }
    finally
    {
      this.mEngineContext.getLock().unlock();
    }
  }
  
  public native void postRunnableDelayedWithPriority(@NonNull Runnable paramRunnable, long paramLong, int paramInt);
  
  public native boolean runLoop(boolean paramBoolean);
  
  public void saveScriptCodeCache()
  {
    JNICaller.TTEngine.nativeSaveScriptCodeCache(this);
  }
  
  public void setInspectorAgent(InspectorAgent paramInspectorAgent)
  {
    if (paramInspectorAgent != null) {
      this.mInspectorBridge.setProxy(paramInspectorAgent);
    }
  }
  
  public String toString()
  {
    return super.toString() + " " + this.mEngineContext.getId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.TTEngine
 * JD-Core Version:    0.7.0.1
 */