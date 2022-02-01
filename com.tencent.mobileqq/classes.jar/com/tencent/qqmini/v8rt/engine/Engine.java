package com.tencent.qqmini.v8rt.engine;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.v8rt.anno.CallByNative;
import com.tencent.qqmini.v8rt.anno.NotNull;
import com.tencent.qqmini.v8rt.debug.WebSocketServerInspectAgent;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Engine
{
  public static final String ENGINE_ASSETS = "tv8rt";
  public static final int ENG_INIT_ERR = 100;
  public static final int ENG_INIT_ERR_LOAD_SO = 101;
  public static final int ENG_INIT_STATUS_OK = 0;
  public static final int ENG_INIT_STATUS_RELEASED = 1;
  public static final int ENG_INIT_STATUS_UNKNOWN = -1;
  public static final int ENG_NDK_INIT = 102;
  public static final String TAG = "TV8ENG";
  static Engine.InspectorBridge sInspectorBridge;
  private static Engine sInstance;
  private static Executor sIoExecutor;
  private boolean isEnableDebugger = false;
  private boolean isWaitForDebugger = false;
  public Context mContext = null;
  private V8JsRuntime mDefaultJsRuntime;
  public EnginePathProvider mEnginePathProvider = null;
  public int mInitStatus = -1;
  public boolean mIsEnableCodeCache = true;
  private LibLoader mLibLoader;
  private Map<Integer, V8JsRuntime> mV8RuntimeMap = new ConcurrentHashMap();
  private V8TimerThread mV8TimerThread;
  
  private void createApp()
  {
    long l = SystemClock.g().uptimeMillis();
    nativeInit(2500);
    this.mEnginePathProvider.copyEngineAssets("tv8rt", true);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.mV8TimerThread = new V8TimerThread(new Engine.1(this, localCountDownLatch));
    this.mV8TimerThread.start();
    try
    {
      localCountDownLatch.await();
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("injectJS BaseLib cost time:");
    localStringBuilder.append(SystemClock.g().uptimeMillis() - l);
    localStringBuilder.append("ms");
    Logger.i("TV8ENG", localStringBuilder.toString());
  }
  
  @CallByNative
  public static String getEngineJsPath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getEngineJsPath ");
    localStringBuilder.append(paramString);
    Logger.i("TV8ENG", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(getInstance().mEnginePathProvider.getEngineJSDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static Engine getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new Engine();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public static Executor getIoExecutor()
  {
    if (sIoExecutor == null) {
      sIoExecutor = Executors.newSingleThreadExecutor();
    }
    return sIoExecutor;
  }
  
  @CallByNative
  public static void handleJavaScriptException(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = new String(paramArrayOfByte);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("js exception:\n");
      localStringBuilder.append(paramArrayOfByte);
      Logger.e("Log", localStringBuilder.toString());
    }
  }
  
  public static int loadScriptPathWithCodeCache(int paramInt1, int paramInt2, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3))) {
      return nativeLoadScriptPathWithCodeCache(paramInt1, paramInt2, paramString1, paramString2, paramString3);
    }
    throw new IllegalStateException("all parameter must not be null or empty");
  }
  
  public static int loadScriptStringWithCodeCache(int paramInt1, int paramInt2, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return nativeLoadScriptStringWithCodeCache(paramInt1, paramInt2, paramString1, paramString2, paramString3);
    }
    throw new IllegalStateException("all parameter must not be null or empty");
  }
  
  public static native int nativeCreateScriptEngine(Engine.InspectorBridge paramInspectorBridge);
  
  public static native void nativeDispose();
  
  public static native boolean nativeEnvInit();
  
  public static native void nativeFinalize();
  
  public static native String nativeGetVersion();
  
  public static native void nativeInit(int paramInt);
  
  public static native boolean nativeInjectConsole(int paramInt1, int paramInt2);
  
  public static native boolean nativeInjectJsBridge(int paramInt1, int paramInt2);
  
  public static native boolean nativeInjectJsWorker(int paramInt1, int paramInt2);
  
  public static native boolean nativeInjectNativeBuffer(int paramInt1, int paramInt2);
  
  public static native boolean nativeInjectTimer(int paramInt1, int paramInt2);
  
  public static native int nativeLoadScriptPathWithCodeCache(int paramInt1, int paramInt2, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3);
  
  public static native int nativeLoadScriptStringWithCodeCache(int paramInt1, int paramInt2, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3);
  
  public static native long nativeOnVSync(long paramLong);
  
  public static native void nativeSaveScriptCodeCache();
  
  @CallByNative
  public static String onScriptCall(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    return V8JsBridge.onScriptCall(new String(paramArrayOfByte1), new String(paramArrayOfByte2), paramInt1, paramInt2);
  }
  
  @CallByNative
  public static String onScriptPublish(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    return V8JsBridge.onScriptPublish(new String(paramArrayOfByte1), new String(paramArrayOfByte2), new String(paramArrayOfByte3), paramInt);
  }
  
  @CallByNative
  public static int onWorkerCreate(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onWorkerCreate :");
    localStringBuilder.append(paramArrayOfByte);
    Logger.d("TV8ENG", localStringBuilder.toString());
    return V8JsBridge.onWorkerCreate(paramArrayOfByte, paramInt);
  }
  
  @CallByNative
  public static void onWorkerPostMsgToAppService(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onWorkerPostMsgToAppService :");
    localStringBuilder.append(paramArrayOfByte);
    Logger.d("TV8ENG", localStringBuilder.toString());
    V8JsBridge.onWorkerPostMsgToAppService(paramArrayOfByte, paramInt);
  }
  
  @CallByNative
  public static void onWorkerPostMsgToWorker(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onWorkerPostMsgToWorker :");
    localStringBuilder.append(paramArrayOfByte);
    Logger.d("TV8ENG", localStringBuilder.toString());
    V8JsBridge.onWorkerPostMsgToWorker(paramInt1, paramArrayOfByte, paramInt2);
  }
  
  @CallByNative
  public static void onWorkerTerminate(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onWorkerTerminate :");
    localStringBuilder.append(paramInt1);
    Logger.d("TV8ENG", localStringBuilder.toString());
    V8JsBridge.onWorkerTerminate(paramInt1, paramInt2);
  }
  
  public static native boolean runLoop();
  
  public static void setIoExecutor(Executor paramExecutor)
  {
    if (sIoExecutor != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setIoExecutor ");
      localStringBuilder.append(paramExecutor);
      Logger.i("TV8ENG", localStringBuilder.toString());
    }
    sIoExecutor = paramExecutor;
  }
  
  public static native void stopLoop();
  
  public V8JsRuntime createJsRuntime()
  {
    try
    {
      int i = this.mInitStatus;
      Object localObject1 = null;
      if (i != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("createJsRuntime failed!");
        ((StringBuilder)localObject1).append(this.mInitStatus);
        Logger.e("TV8ENG", ((StringBuilder)localObject1).toString());
        return null;
      }
      if ((this.isEnableDebugger) && (sInspectorBridge == null)) {
        sInspectorBridge = new Engine.InspectorBridge(new WebSocketServerInspectAgent(this.isWaitForDebugger), null);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("debuggerOption:");
      localStringBuilder.append(this.isEnableDebugger);
      localStringBuilder.append(",");
      localStringBuilder.append(this.isWaitForDebugger);
      Logger.i("TV8ENG", localStringBuilder.toString());
      i = nativeCreateScriptEngine(sInspectorBridge);
      if (sInspectorBridge != null) {
        localObject1 = sInspectorBridge.getInspectorAgent();
      }
      localObject1 = new V8JsRuntime(i, (IInspectorAgent)localObject1);
      JsRuntimeLoader.initDefaultContext(this.mEnginePathProvider, ((V8JsRuntime)localObject1).getDefaultContext());
      this.mV8RuntimeMap.put(Integer.valueOf(i), localObject1);
      return localObject1;
    }
    finally {}
  }
  
  public V8JsRuntime getJsRuntime()
  {
    try
    {
      if (this.mDefaultJsRuntime == null) {
        this.mDefaultJsRuntime = createJsRuntime();
      }
      V8JsRuntime localV8JsRuntime = this.mDefaultJsRuntime;
      return localV8JsRuntime;
    }
    finally {}
  }
  
  public V8JsRuntime getJsRuntime(int paramInt)
  {
    return (V8JsRuntime)this.mV8RuntimeMap.get(Integer.valueOf(paramInt));
  }
  
  public int getStatus()
  {
    return this.mInitStatus;
  }
  
  public Engine initEngine(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (this.mInitStatus == 0) {
          return this;
        }
        this.mContext = paramContext;
        this.mEnginePathProvider = new EnginePathProvider(paramContext);
        if (this.mLibLoader != null)
        {
          paramContext = new StringBuilder();
          paramContext.append("initEngine using libLoader ");
          paramContext.append(this.mLibLoader);
          Logger.e("TV8ENG", paramContext.toString());
          bool1 = this.mLibLoader.loadSo();
          boolean bool2 = bool1;
          if (!bool1)
          {
            this.mLibLoader = new DefaultSoLoader();
            bool2 = this.mLibLoader.loadSo();
          }
          if (!bool2)
          {
            Logger.e("TV8ENG", "initEngine loadSo fail!");
            this.mInitStatus = 101;
            return this;
          }
          paramContext = new StringBuilder();
          paramContext.append("initEngine version : ");
          paramContext.append(nativeGetVersion());
          Logger.i("TV8ENG", paramContext.toString());
          if (!nativeEnvInit())
          {
            Logger.e("TV8ENG", "initEngine nativeEnvInit fail!");
            this.mInitStatus = 102;
            return this;
          }
          createApp();
          this.mInitStatus = 0;
          return this;
        }
      }
      finally {}
      boolean bool1 = false;
    }
  }
  
  public void release()
  {
    this.mInitStatus = 1;
  }
  
  public void removeJsRuntime(V8JsRuntime paramV8JsRuntime)
  {
    this.mV8RuntimeMap.remove(Integer.valueOf(paramV8JsRuntime.getId()));
  }
  
  public void saveScriptCodeCache()
  {
    if (this.mIsEnableCodeCache) {
      getIoExecutor().execute(new Engine.2(this));
    }
  }
  
  public void setDebuggerOption(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.isEnableDebugger = paramBoolean1;
    this.isWaitForDebugger = paramBoolean2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDebuggerOption:");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramBoolean2);
    Logger.i("TV8ENG", localStringBuilder.toString());
  }
  
  public void setLibLoader(LibLoader paramLibLoader)
  {
    this.mLibLoader = paramLibLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.Engine
 * JD-Core Version:    0.7.0.1
 */