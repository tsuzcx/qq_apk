package com.tencent.mobileqq.triton.engine;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.triton.annotation.JNIModule;
import com.tencent.mobileqq.triton.api.TTChannel;
import com.tencent.mobileqq.triton.api.http.NativeHttp;
import com.tencent.mobileqq.triton.audio.TTAudioPlayerManager;
import com.tencent.mobileqq.triton.audio.WebAudioProxy;
import com.tencent.mobileqq.triton.bridge.TTJSBridge;
import com.tencent.mobileqq.triton.bridge.TTJSInnerEngine;
import com.tencent.mobileqq.triton.bridge.plugins.AudioPlugin;
import com.tencent.mobileqq.triton.font.FontBitmapManager;
import com.tencent.mobileqq.triton.game.GameLauncher;
import com.tencent.mobileqq.triton.game.LifecycleManager;
import com.tencent.mobileqq.triton.jni.JNICaller.TTEngine;
import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.jni.TTNativeModule;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.mobileqq.triton.render.monitor.BlackScreenMonitor;
import com.tencent.mobileqq.triton.render.monitor.FPSMonitor;
import com.tencent.mobileqq.triton.render.monitor.ScreenShootMonitor;
import com.tencent.mobileqq.triton.sdk.APIProxy;
import com.tencent.mobileqq.triton.sdk.FPSCallback;
import com.tencent.mobileqq.triton.sdk.GameEngineClassloader;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.ITHttp;
import com.tencent.mobileqq.triton.sdk.ITLog;
import com.tencent.mobileqq.triton.sdk.ITSoLoader;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.ITTEngine.IListener;
import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;
import com.tencent.mobileqq.triton.sdk.audio.IAudioPlayerBuilder;
import com.tencent.mobileqq.triton.sdk.bridge.IInspectorAgent;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.callback.ScreenShotCallback;
import com.tencent.mobileqq.triton.sdk.game.GameLifecycle;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import com.tencent.mobileqq.triton.utils.CanvasRecorder;
import com.tencent.mobileqq.triton.utils.SystemInfoManager;
import com.tencent.mobileqq.triton.views.GameUserInfoBtnManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

@JNIModule
@TTNativeModule(name="TTEngine")
public class TTEngine
  implements ITTEngine
{
  static final String NAME = "TTEngine";
  private static final String TAG = "TTEngine";
  private volatile boolean bInitJSContext = false;
  private Activity mAttachedActivity;
  @TTNativeCall
  private CanvasRecorder mCanvasRecorder;
  private Executor mDiskIoExecutor;
  private boolean mEnableCodeCache = true;
  @TTNativeCall
  private FontBitmapManager mFontBitmapManager;
  private GameLauncher mGameLauncher;
  @TTNativeCall
  private GameUserInfoBtnManager mGameUserInfoBtnManager;
  private TTJSInnerEngine mInnerJSEngine;
  private TTEngine.InspectorBridge mInspectorBridge;
  private TTJSBridge mJSBridge;
  private IJSEngine mJSEngine;
  private JsRuntimeLoader mJsRuntimeLoader;
  private LifecycleManager mLifecycleManager;
  private ITTEngine.IListener mListener;
  @TTNativeCall
  private NativeHttp mNativeHttp;
  private IQQEnv mQQEnv;
  private volatile RenderContext mRenderContext;
  private volatile ScriptService mScriptEngine;
  private SystemInfoManager mSystemInfoManager;
  @TTNativeCall
  private TTChannel mTTChannel;
  private volatile int mTargetFPS;
  private WebAudioProxy mWebAudioProxy;
  @TTNativeCall
  private long nativeTTAppHandle;
  private HashMap<String, Boolean> optionalSoLoadStatusMap;
  
  public TTEngine()
  {
    TTLog.i("TTEngine", "new TTEngine " + this);
    this.nativeTTAppHandle = 0L;
    this.mTTChannel = new TTChannel(this);
    this.mFontBitmapManager = new FontBitmapManager(this);
    this.mNativeHttp = new NativeHttp(this);
    this.mGameUserInfoBtnManager = new GameUserInfoBtnManager(this);
    this.mLifecycleManager = new LifecycleManager();
    this.mInnerJSEngine = new TTJSInnerEngine(this);
    this.mJSBridge = new TTJSBridge(this);
    this.mGameLauncher = new GameLauncher(this, this.mJSBridge);
    this.mJsRuntimeLoader = new JsRuntimeLoader(this);
    this.mCanvasRecorder = new CanvasRecorder(this);
    this.mWebAudioProxy = new WebAudioProxy();
  }
  
  @TTNativeCall
  private void _setTargetFPS(int paramInt)
  {
    setTargetFPS(paramInt);
  }
  
  private void assertInited(String paramString)
  {
    if (!this.bInitJSContext) {}
  }
  
  public static native void nativeFontManagerInit(AssetManager paramAssetManager, String paramString);
  
  public static native String nativeGetTTVersion();
  
  public void addFPSCallback(FPSCallback paramFPSCallback)
  {
    if (getRenderContext() != null) {}
    for (FPSMonitor localFPSMonitor = (FPSMonitor)getRenderContext().getSwapListener(FPSMonitor.class);; localFPSMonitor = null)
    {
      if (localFPSMonitor != null) {
        localFPSMonitor.addFPSCallback(paramFPSCallback);
      }
      return;
    }
  }
  
  public void addGameLifeCycle(GameLifecycle paramGameLifecycle)
  {
    this.mLifecycleManager.addGameLifeCycle(paramGameLifecycle);
  }
  
  public View createGameView(Activity paramActivity, int paramInt1, int paramInt2)
  {
    if ((getRenderContext() == null) || (getSystemInfoManager() == null)) {
      throw new IllegalStateException("createGameView on null renderContext or null SystemInfoManager");
    }
    return getRenderContext().createGameView(paramActivity, paramInt1, paramInt2, getSystemInfoManager().getDensity());
  }
  
  public void createTTApp()
  {
    JNICaller.TTEngine.nativeCreateTTApp(this, getRenderContext(), getCanvasRecorder(), getTTChannel(), getUserInfoBtnManager(), (GameLauncher)getGameLauncher(), (NativeHttp)getNativeHttp(), getFontBitmapManager(), this.mInspectorBridge);
  }
  
  public APIProxy getApiProxy()
  {
    return this.mTTChannel.getApiProxy();
  }
  
  public Activity getAttachedActivity()
  {
    return this.mAttachedActivity;
  }
  
  public IAudioNativeManager getAudioNativeManager()
  {
    return this.mWebAudioProxy;
  }
  
  public CanvasRecorder getCanvasRecorder()
  {
    return this.mCanvasRecorder;
  }
  
  public long getCurrentDrawCount()
  {
    return ScriptService.getCurrentDrawCallCount();
  }
  
  public int getDisplayRefreshRate()
  {
    if (this.mSystemInfoManager != null) {
      return this.mSystemInfoManager.getScreenRefreshRate();
    }
    return 60;
  }
  
  public ITTEngine.IListener getEngineListener()
  {
    return this.mListener;
  }
  
  public FontBitmapManager getFontBitmapManager()
  {
    return this.mFontBitmapManager;
  }
  
  public IGameLauncher getGameLauncher()
  {
    return this.mGameLauncher;
  }
  
  public IJSEngine getInnerJsEngine()
  {
    return this.mInnerJSEngine;
  }
  
  public IJSEngine getJsEngine()
  {
    return this.mJSEngine;
  }
  
  public ITTJSRuntime getJsRuntime(int paramInt)
  {
    return this.mJSBridge.getJsRuntime(paramInt);
  }
  
  public JsRuntimeLoader getJsRuntimeLoader()
  {
    return this.mJsRuntimeLoader;
  }
  
  public long getLastBlackTime()
  {
    if (getRenderContext() != null) {}
    for (BlackScreenMonitor localBlackScreenMonitor = (BlackScreenMonitor)getRenderContext().getSwapListener(BlackScreenMonitor.class); localBlackScreenMonitor != null; localBlackScreenMonitor = null) {
      return localBlackScreenMonitor.getLastBlackTime();
    }
    return -1L;
  }
  
  public LifecycleManager getLifecycleManager()
  {
    return this.mLifecycleManager;
  }
  
  public MiniGameInfo getMiniGameInfo()
  {
    if (getGameLauncher() != null) {
      return getGameLauncher().getCurrentGame();
    }
    return null;
  }
  
  public ITNativeBufferPool getNativeBufferPool()
  {
    return this.mJSBridge;
  }
  
  public ITHttp getNativeHttp()
  {
    return this.mNativeHttp;
  }
  
  public long getNativeTTAppHandle()
  {
    return this.nativeTTAppHandle;
  }
  
  public boolean getOptionalSoLoadStatus(String paramString)
  {
    if ((this.optionalSoLoadStatusMap != null) && (!this.optionalSoLoadStatusMap.isEmpty()) && (this.optionalSoLoadStatusMap.containsKey(paramString))) {
      return ((Boolean)this.optionalSoLoadStatusMap.get(paramString)).booleanValue();
    }
    return false;
  }
  
  public native int getProcessedMessageCount();
  
  public IQQEnv getQQEnv()
  {
    return this.mQQEnv;
  }
  
  public RenderContext getRenderContext()
  {
    return this.mRenderContext;
  }
  
  public Map<String, String> getResPathCache()
  {
    return GameLauncher.getResPathCache();
  }
  
  public void getScreenShot(ScreenShotCallback paramScreenShotCallback)
  {
    if (getRenderContext() != null) {}
    for (ScreenShootMonitor localScreenShootMonitor = (ScreenShootMonitor)getRenderContext().getSwapListener(ScreenShootMonitor.class);; localScreenShootMonitor = null)
    {
      if (localScreenShootMonitor != null) {
        localScreenShootMonitor.getGameScreenShot(paramScreenShotCallback);
      }
      return;
    }
  }
  
  public SystemInfoManager getSystemInfoManager()
  {
    return this.mSystemInfoManager;
  }
  
  public TTChannel getTTChannel()
  {
    return this.mTTChannel;
  }
  
  public int getTargetFPS()
  {
    return this.mTargetFPS;
  }
  
  public GameUserInfoBtnManager getUserInfoBtnManager()
  {
    return this.mGameUserInfoBtnManager;
  }
  
  public void handleFocusGain()
  {
    if (this.mInnerJSEngine != null) {}
    for (AudioPlugin localAudioPlugin = (AudioPlugin)this.mInnerJSEngine.getPlugin(AudioPlugin.class);; localAudioPlugin = null)
    {
      if ((localAudioPlugin != null) && (localAudioPlugin.getAudioPlayerManager() != null)) {
        localAudioPlugin.getAudioPlayerManager().handleFocusGain();
      }
      return;
    }
  }
  
  public void handleFocusLoss()
  {
    if (this.mInnerJSEngine != null) {}
    for (AudioPlugin localAudioPlugin = (AudioPlugin)this.mInnerJSEngine.getPlugin(AudioPlugin.class);; localAudioPlugin = null)
    {
      if ((localAudioPlugin != null) && (localAudioPlugin.getAudioPlayerManager() != null)) {
        localAudioPlugin.getAudioPlayerManager().handleFocusLoss();
      }
      return;
    }
  }
  
  public int initEngine(Context paramContext, ITTEngine.IListener paramIListener, IInspectorAgent paramIInspectorAgent)
  {
    try
    {
      if (this.bInitJSContext) {
        return 0;
      }
      getQQEnv().reportDC04266(1001, null);
      if (!TTSoLoader.loadSo())
      {
        TTLog.e("TTEngine", "initEngine loadSo fail!");
        return 1001;
      }
      this.optionalSoLoadStatusMap = TTSoLoader.loadOptionalSoList();
      getQQEnv().reportDC04266(1002, null);
      if (paramIInspectorAgent != null) {
        this.mInspectorBridge = new TTEngine.InspectorBridge(paramIInspectorAgent, null);
      }
      this.mListener = paramIListener;
      this.mSystemInfoManager = new SystemInfoManager(this, paramContext);
      this.mRenderContext = new RenderContext(this, paramContext);
      this.mTargetFPS = getDisplayRefreshRate();
      boolean bool = getClass().getClassLoader() instanceof GameEngineClassloader;
      TTLog.i("TTEngine", "initEngine load triton from dex?" + bool + " version : " + JNICaller.TTEngine.nativeGetTTVersion());
      if (!JNICaller.TTEngine.nativeEnvInit(this))
      {
        TTLog.e("TTEngine", "initEngine nativeEnvInit fail!");
        return 2001;
      }
    }
    finally {}
    getQQEnv().reportDC04266(8, null);
    if (this.mJsRuntimeLoader.collectJsFileToPreload()) {
      getQQEnv().reportDC04266(9, null);
    }
    this.mScriptEngine = new ScriptService(this);
    addGameLifeCycle(this.mInnerJSEngine);
    addGameLifeCycle(new CodeCacheSaver(this));
    this.bInitJSContext = true;
    return 0;
  }
  
  public native void interruptLoop();
  
  public boolean isGLThread()
  {
    return (this.mScriptEngine != null) && (this.mScriptEngine.isJSThread());
  }
  
  public int loadScriptPathWithCodeCache(int paramInt, @NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      throw new IllegalStateException("all parameter must not be null or empty");
    }
    return JNICaller.TTEngine.nativeLoadScriptPathWithCodeCache(this, paramInt, paramString1, this.mGameLauncher.getGameDebugPath(paramString2), paramString3);
  }
  
  public int loadScriptStringWithCodeCache(int paramInt, @NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      throw new IllegalStateException("all parameter must not be null or empty");
    }
    return JNICaller.TTEngine.nativeLoadScriptStringWithCodeCache(this, paramInt, paramString1, this.mGameLauncher.getGameDebugPath(paramString2), paramString3);
  }
  
  public native long nativeCanvasPresent();
  
  public native void nativeCreateTTApp(RenderContext paramRenderContext, CanvasRecorder paramCanvasRecorder, TTChannel paramTTChannel, GameUserInfoBtnManager paramGameUserInfoBtnManager, GameLauncher paramGameLauncher, NativeHttp paramNativeHttp, FontBitmapManager paramFontBitmapManager, TTEngine.InspectorBridge paramInspectorBridge);
  
  public native void nativeDiposeTTApp();
  
  public native void nativeEnableJankTrace(boolean paramBoolean);
  
  public native boolean nativeEnvInit();
  
  public native void nativeFinalize();
  
  public native long nativeGetCurrentFrameDrawCallCount();
  
  public native int nativeLoadScriptPathWithCodeCache(int paramInt, @NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3);
  
  public native int nativeLoadScriptStringWithCodeCache(int paramInt, @NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3);
  
  public native long nativeOnVSync(long paramLong);
  
  public native void nativePause();
  
  public native void nativeResume();
  
  public native void nativeSaveScriptCodeCache();
  
  public native boolean nativeStartDrawCall();
  
  public void onCreate(Activity paramActivity)
  {
    this.mAttachedActivity = paramActivity;
    this.mLifecycleManager.onCreate(paramActivity);
  }
  
  public void onDestroy()
  {
    TTLog.i("TTEngine", "~TTEngine " + this);
    this.mAttachedActivity = null;
    this.bInitJSContext = false;
    if (this.mLifecycleManager != null) {
      this.mLifecycleManager.onDestroy();
    }
    if (this.mRenderContext != null) {
      this.mRenderContext.onDestroy();
    }
    if (this.mScriptEngine != null) {
      this.mScriptEngine.onDestroy();
    }
  }
  
  public void onPause()
  {
    this.mLifecycleManager.onPause();
    if (this.mScriptEngine != null) {
      this.mScriptEngine.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.mScriptEngine != null) {
      this.mScriptEngine.onResume();
    }
    this.mLifecycleManager.onResume();
  }
  
  @TTNativeCall
  public String onScriptCall(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    paramArrayOfByte1 = new String(paramArrayOfByte1);
    paramArrayOfByte2 = new String(paramArrayOfByte2);
    return this.mJSBridge.onScriptCall(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
  }
  
  @TTNativeCall
  public String onScriptPublish(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    paramArrayOfByte1 = new String(paramArrayOfByte1);
    paramArrayOfByte2 = new String(paramArrayOfByte2);
    paramArrayOfByte3 = new String(paramArrayOfByte3);
    return this.mJSBridge.onScriptPublish(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt);
  }
  
  public void postRunnable(@NonNull Runnable paramRunnable)
  {
    postRunnableDelayed(paramRunnable, 0L);
  }
  
  public void postRunnableDelayed(@NonNull Runnable paramRunnable, long paramLong)
  {
    assertInited("post runnable after engine is destroyed");
    if (this.bInitJSContext) {
      JNICaller.TTEngine.postRunnableDelayedWithPriority(this, paramRunnable, paramLong, 0);
    }
  }
  
  public native void postRunnableDelayedWithPriority(@NonNull Runnable paramRunnable, long paramLong, int paramInt);
  
  public void removeFPSCallback(FPSCallback paramFPSCallback)
  {
    if (getRenderContext() != null) {}
    for (FPSMonitor localFPSMonitor = (FPSMonitor)getRenderContext().getSwapListener(FPSMonitor.class);; localFPSMonitor = null)
    {
      if (localFPSMonitor != null) {
        localFPSMonitor.removeFPSCallback(paramFPSCallback);
      }
      return;
    }
  }
  
  public native boolean runLoop(boolean paramBoolean);
  
  void saveScriptCodeCache()
  {
    if (this.mEnableCodeCache) {
      JNICaller.TTEngine.nativeSaveScriptCodeCache(this);
    }
  }
  
  public void setApiProxy(APIProxy paramAPIProxy)
  {
    this.mTTChannel.setApiProxy(paramAPIProxy);
  }
  
  public void setAudioPlayerBuilder(IAudioPlayerBuilder paramIAudioPlayerBuilder)
  {
    if (this.mInnerJSEngine != null) {}
    for (AudioPlugin localAudioPlugin = (AudioPlugin)this.mInnerJSEngine.getPlugin(AudioPlugin.class);; localAudioPlugin = null)
    {
      if ((localAudioPlugin != null) && (localAudioPlugin.getAudioPlayerManager() != null)) {
        localAudioPlugin.getAudioPlayerManager().setAudioPlayerBuilder(paramIAudioPlayerBuilder);
      }
      return;
    }
  }
  
  public void setDiskIoExecutor(@NonNull Executor paramExecutor)
  {
    this.mDiskIoExecutor = paramExecutor;
  }
  
  public void setEnableCodeCache(boolean paramBoolean)
  {
    this.mEnableCodeCache = paramBoolean;
  }
  
  public void setEnableJankCanary(boolean paramBoolean)
  {
    JNICaller.TTEngine.nativeEnableJankTrace(this, paramBoolean);
  }
  
  public void setEngineListener(ITTEngine.IListener paramIListener)
  {
    this.mListener = paramIListener;
  }
  
  public void setJsEngine(IJSEngine paramIJSEngine)
  {
    this.mJSEngine = paramIJSEngine;
  }
  
  public void setLog(ITLog paramITLog)
  {
    TTLog.init(paramITLog);
  }
  
  public void setQQEnv(IQQEnv paramIQQEnv)
  {
    this.mQQEnv = paramIQQEnv;
  }
  
  public void setSoLoader(ITSoLoader paramITSoLoader)
  {
    TTSoLoader.setSoLoader(paramITSoLoader);
  }
  
  public void setTargetFPS(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= getDisplayRefreshRate()))
    {
      this.mTargetFPS = paramInt;
      if (this.mScriptEngine != null) {
        this.mScriptEngine.onTargetFpsChange(paramInt);
      }
      TTLog.i("TTEngine", "setTargetFPS:" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.TTEngine
 * JD-Core Version:    0.7.0.1
 */