package com.tencent.qqmini.v8rt.engine;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.v8rt.anno.CallByNative;
import com.tencent.qqmini.v8rt.anno.NotNull;
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
  static Engine.InspectorBridge sInspectorBridge = null;
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
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      throw new IllegalStateException("all parameter must not be null or empty");
    }
    return nativeLoadScriptStringWithCodeCache(paramInt1, paramInt2, paramString1, paramString2, paramString3);
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
    Logger.d("TV8ENG", "onWorkerCreate :" + paramArrayOfByte);
    return V8JsBridge.onWorkerCreate(paramArrayOfByte, paramInt);
  }
  
  @CallByNative
  public static void onWorkerPostMsgToAppService(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    Logger.d("TV8ENG", "onWorkerPostMsgToAppService :" + paramArrayOfByte);
    V8JsBridge.onWorkerPostMsgToAppService(paramArrayOfByte, paramInt);
  }
  
  @CallByNative
  public static void onWorkerPostMsgToWorker(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    Logger.d("TV8ENG", "onWorkerPostMsgToWorker :" + paramArrayOfByte);
    V8JsBridge.onWorkerPostMsgToWorker(paramInt1, paramArrayOfByte, paramInt2);
  }
  
  @CallByNative
  public static void onWorkerTerminate(int paramInt1, int paramInt2)
  {
    Logger.d("TV8ENG", "onWorkerTerminate :" + paramInt1);
    V8JsBridge.onWorkerTerminate(paramInt1, paramInt2);
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
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 58	com/tencent/qqmini/v8rt/engine/Engine:mInitStatus	I
    //   10: ifeq +36 -> 46
    //   13: ldc 24
    //   15: new 120	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 288
    //   25: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: getfield 58	com/tencent/qqmini/v8rt/engine/Engine:mInitStatus	I
    //   32: invokevirtual 272	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 189	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   41: pop
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_2
    //   45: areturn
    //   46: aload_0
    //   47: getfield 71	com/tencent/qqmini/v8rt/engine/Engine:isEnableDebugger	Z
    //   50: ifeq +31 -> 81
    //   53: getstatic 52	com/tencent/qqmini/v8rt/engine/Engine:sInspectorBridge	Lcom/tencent/qqmini/v8rt/engine/Engine$InspectorBridge;
    //   56: ifnonnull +25 -> 81
    //   59: new 290	com/tencent/qqmini/v8rt/engine/Engine$InspectorBridge
    //   62: dup
    //   63: new 292	com/tencent/qqmini/v8rt/debug/WebSocketServerInspectAgent
    //   66: dup
    //   67: aload_0
    //   68: getfield 73	com/tencent/qqmini/v8rt/engine/Engine:isWaitForDebugger	Z
    //   71: invokespecial 295	com/tencent/qqmini/v8rt/debug/WebSocketServerInspectAgent:<init>	(Z)V
    //   74: aconst_null
    //   75: invokespecial 298	com/tencent/qqmini/v8rt/engine/Engine$InspectorBridge:<init>	(Lcom/tencent/qqmini/v8rt/engine/IInspectorAgent;Lcom/tencent/qqmini/v8rt/engine/Engine$1;)V
    //   78: putstatic 52	com/tencent/qqmini/v8rt/engine/Engine:sInspectorBridge	Lcom/tencent/qqmini/v8rt/engine/Engine$InspectorBridge;
    //   81: ldc 24
    //   83: new 120	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 300
    //   93: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_0
    //   97: getfield 71	com/tencent/qqmini/v8rt/engine/Engine:isEnableDebugger	Z
    //   100: invokevirtual 303	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   103: ldc_w 305
    //   106: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_0
    //   110: getfield 73	com/tencent/qqmini/v8rt/engine/Engine:isWaitForDebugger	Z
    //   113: invokevirtual 303	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   116: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 142	com/tencent/qqmini/v8rt/engine/Logger:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   122: pop
    //   123: getstatic 52	com/tencent/qqmini/v8rt/engine/Engine:sInspectorBridge	Lcom/tencent/qqmini/v8rt/engine/Engine$InspectorBridge;
    //   126: invokestatic 307	com/tencent/qqmini/v8rt/engine/Engine:nativeCreateScriptEngine	(Lcom/tencent/qqmini/v8rt/engine/Engine$InspectorBridge;)I
    //   129: istore_1
    //   130: aload_3
    //   131: astore_2
    //   132: getstatic 52	com/tencent/qqmini/v8rt/engine/Engine:sInspectorBridge	Lcom/tencent/qqmini/v8rt/engine/Engine$InspectorBridge;
    //   135: ifnull +10 -> 145
    //   138: getstatic 52	com/tencent/qqmini/v8rt/engine/Engine:sInspectorBridge	Lcom/tencent/qqmini/v8rt/engine/Engine$InspectorBridge;
    //   141: invokevirtual 311	com/tencent/qqmini/v8rt/engine/Engine$InspectorBridge:getInspectorAgent	()Lcom/tencent/qqmini/v8rt/engine/IInspectorAgent;
    //   144: astore_2
    //   145: new 313	com/tencent/qqmini/v8rt/engine/V8JsRuntime
    //   148: dup
    //   149: iload_1
    //   150: aload_2
    //   151: invokespecial 316	com/tencent/qqmini/v8rt/engine/V8JsRuntime:<init>	(ILcom/tencent/qqmini/v8rt/engine/IInspectorAgent;)V
    //   154: astore_2
    //   155: aload_0
    //   156: getfield 62	com/tencent/qqmini/v8rt/engine/Engine:mEnginePathProvider	Lcom/tencent/qqmini/v8rt/engine/EnginePathProvider;
    //   159: aload_2
    //   160: invokevirtual 320	com/tencent/qqmini/v8rt/engine/V8JsRuntime:getDefaultContext	()Lcom/tencent/qqmini/v8rt/engine/V8JsContext;
    //   163: invokestatic 326	com/tencent/qqmini/v8rt/engine/JsRuntimeLoader:initDefaultContext	(Lcom/tencent/qqmini/v8rt/engine/EnginePathProvider;Lcom/tencent/qqmini/v8rt/engine/V8JsContext;)Z
    //   166: pop
    //   167: aload_0
    //   168: getfield 67	com/tencent/qqmini/v8rt/engine/Engine:mV8RuntimeMap	Ljava/util/Map;
    //   171: iload_1
    //   172: invokestatic 332	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aload_2
    //   176: invokeinterface 338 3 0
    //   181: pop
    //   182: goto -140 -> 42
    //   185: astore_2
    //   186: aload_0
    //   187: monitorexit
    //   188: aload_2
    //   189: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	Engine
    //   129	43	1	i	int
    //   3	173	2	localObject1	Object
    //   185	4	2	localObject2	Object
    //   1	130	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   6	42	185	finally
    //   46	81	185	finally
    //   81	130	185	finally
    //   132	145	185	finally
    //   145	182	185	finally
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
  
  public void setDebuggerOption(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.isEnableDebugger = paramBoolean1;
    this.isWaitForDebugger = paramBoolean2;
    Logger.i("TV8ENG", "setDebuggerOption:" + paramBoolean1 + "," + paramBoolean2);
  }
  
  public void setLibLoader(LibLoader paramLibLoader)
  {
    this.mLibLoader = paramLibLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.Engine
 * JD-Core Version:    0.7.0.1
 */