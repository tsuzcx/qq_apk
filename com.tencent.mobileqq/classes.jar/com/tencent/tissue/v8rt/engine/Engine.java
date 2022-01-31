package com.tencent.tissue.v8rt.engine;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tissue.v8rt.anno.CallByNative;
import com.tencent.tissue.v8rt.anno.NotNull;
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
  private static Engine sInstance;
  private static Executor sIoExecutor;
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
      Logger.i("TV8ENG", "injectJS BaseLib cost time:" + (SystemClock.g().uptimeMillis() - l) + "ms");
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  @CallByNative
  public static String getEngineJsPath(String paramString)
  {
    Logger.i("TV8ENG", "getEngineJsPath " + paramString);
    return getInstance().mEnginePathProvider.getEngineJSDir() + File.separator + paramString;
  }
  
  public static Engine getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new Engine();
      }
      return sInstance;
    }
    finally {}
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
      Logger.e("Log", "js exception:\n" + paramArrayOfByte);
    }
  }
  
  public static int loadScriptPathWithCodeCache(int paramInt1, int paramInt2, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      throw new IllegalStateException("all parameter must not be null or empty");
    }
    return nativeLoadScriptPathWithCodeCache(paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static int loadScriptStringWithCodeCache(int paramInt1, int paramInt2, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      throw new IllegalStateException("all parameter must not be null or empty");
    }
    return nativeLoadScriptStringWithCodeCache(paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static native int nativeCreateScriptEngine();
  
  public static native void nativeDispose();
  
  public static native boolean nativeEnvInit();
  
  public static native void nativeFinalize();
  
  public static native String nativeGetVersion();
  
  public static native void nativeInit(int paramInt);
  
  public static native boolean nativeInjectConsole(int paramInt1, int paramInt2);
  
  public static native boolean nativeInjectJsBridge(int paramInt1, int paramInt2);
  
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
  
  public static native boolean runLoop();
  
  public static void setIoExecutor(Executor paramExecutor)
  {
    if (sIoExecutor != null) {
      Logger.i("TV8ENG", "setIoExecutor " + paramExecutor);
    }
    sIoExecutor = paramExecutor;
  }
  
  public static native void stopLoop();
  
  /* Error */
  public V8JsRuntime createJsRuntime()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/tencent/tissue/v8rt/engine/Engine:mInitStatus	I
    //   6: ifeq +37 -> 43
    //   9: ldc 24
    //   11: new 109	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   18: ldc 242
    //   20: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 50	com/tencent/tissue/v8rt/engine/Engine:mInitStatus	I
    //   27: invokevirtual 245	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 178	com/tencent/tissue/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   36: pop
    //   37: aconst_null
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: areturn
    //   43: invokestatic 247	com/tencent/tissue/v8rt/engine/Engine:nativeCreateScriptEngine	()I
    //   46: istore_1
    //   47: new 249	com/tencent/tissue/v8rt/engine/V8JsRuntime
    //   50: dup
    //   51: iload_1
    //   52: invokespecial 250	com/tencent/tissue/v8rt/engine/V8JsRuntime:<init>	(I)V
    //   55: astore_2
    //   56: aload_0
    //   57: getfield 54	com/tencent/tissue/v8rt/engine/Engine:mEnginePathProvider	Lcom/tencent/tissue/v8rt/engine/EnginePathProvider;
    //   60: aload_2
    //   61: invokevirtual 254	com/tencent/tissue/v8rt/engine/V8JsRuntime:getDefaultContext	()Lcom/tencent/tissue/v8rt/engine/V8JsContext;
    //   64: invokestatic 260	com/tencent/tissue/v8rt/engine/JsRuntimeLoader:initDefaultContext	(Lcom/tencent/tissue/v8rt/engine/EnginePathProvider;Lcom/tencent/tissue/v8rt/engine/V8JsContext;)Z
    //   67: pop
    //   68: aload_0
    //   69: getfield 59	com/tencent/tissue/v8rt/engine/Engine:mV8RuntimeMap	Ljava/util/Map;
    //   72: iload_1
    //   73: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   76: aload_2
    //   77: invokeinterface 272 3 0
    //   82: pop
    //   83: goto -44 -> 39
    //   86: astore_2
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_2
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	Engine
    //   46	27	1	i	int
    //   38	39	2	localV8JsRuntime	V8JsRuntime
    //   86	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	37	86	finally
    //   43	83	86	finally
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
    boolean bool1 = false;
    try
    {
      if (this.mInitStatus == 0) {
        return this;
      }
      this.mContext = paramContext;
      this.mEnginePathProvider = new EnginePathProvider(paramContext);
      if (this.mLibLoader != null)
      {
        Logger.e("TV8ENG", "initEngine using libLoader " + this.mLibLoader);
        bool1 = this.mLibLoader.loadSo();
      }
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
    }
    finally {}
    Logger.i("TV8ENG", "initEngine version : " + nativeGetVersion());
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
  
  public void setLibLoader(LibLoader paramLibLoader)
  {
    this.mLibLoader = paramLibLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.Engine
 * JD-Core Version:    0.7.0.1
 */