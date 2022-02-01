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
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 58	com/tencent/tissue/v8rt/engine/Engine:mInitStatus	I
    //   10: ifeq +35 -> 45
    //   13: ldc 24
    //   15: new 120	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   22: ldc 253
    //   24: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: getfield 58	com/tencent/tissue/v8rt/engine/Engine:mInitStatus	I
    //   31: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 189	com/tencent/tissue/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   40: pop
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: areturn
    //   45: aload_0
    //   46: getfield 71	com/tencent/tissue/v8rt/engine/Engine:isEnableDebugger	Z
    //   49: ifeq +31 -> 80
    //   52: getstatic 52	com/tencent/tissue/v8rt/engine/Engine:sInspectorBridge	Lcom/tencent/tissue/v8rt/engine/Engine$InspectorBridge;
    //   55: ifnonnull +25 -> 80
    //   58: new 258	com/tencent/tissue/v8rt/engine/Engine$InspectorBridge
    //   61: dup
    //   62: new 260	com/tencent/tissue/v8rt/debug/WebSocketServerInspectAgent
    //   65: dup
    //   66: aload_0
    //   67: getfield 73	com/tencent/tissue/v8rt/engine/Engine:isWaitForDebugger	Z
    //   70: invokespecial 263	com/tencent/tissue/v8rt/debug/WebSocketServerInspectAgent:<init>	(Z)V
    //   73: aconst_null
    //   74: invokespecial 266	com/tencent/tissue/v8rt/engine/Engine$InspectorBridge:<init>	(Lcom/tencent/tissue/v8rt/engine/IInspectorAgent;Lcom/tencent/tissue/v8rt/engine/Engine$1;)V
    //   77: putstatic 52	com/tencent/tissue/v8rt/engine/Engine:sInspectorBridge	Lcom/tencent/tissue/v8rt/engine/Engine$InspectorBridge;
    //   80: ldc 24
    //   82: new 120	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   89: ldc_w 268
    //   92: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: getfield 71	com/tencent/tissue/v8rt/engine/Engine:isEnableDebugger	Z
    //   99: invokevirtual 271	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   102: ldc_w 273
    //   105: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_0
    //   109: getfield 73	com/tencent/tissue/v8rt/engine/Engine:isWaitForDebugger	Z
    //   112: invokevirtual 271	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   115: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 142	com/tencent/tissue/v8rt/engine/Logger:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   121: pop
    //   122: getstatic 52	com/tencent/tissue/v8rt/engine/Engine:sInspectorBridge	Lcom/tencent/tissue/v8rt/engine/Engine$InspectorBridge;
    //   125: invokestatic 275	com/tencent/tissue/v8rt/engine/Engine:nativeCreateScriptEngine	(Lcom/tencent/tissue/v8rt/engine/Engine$InspectorBridge;)I
    //   128: istore_1
    //   129: aload_3
    //   130: astore_2
    //   131: getstatic 52	com/tencent/tissue/v8rt/engine/Engine:sInspectorBridge	Lcom/tencent/tissue/v8rt/engine/Engine$InspectorBridge;
    //   134: ifnull +10 -> 144
    //   137: getstatic 52	com/tencent/tissue/v8rt/engine/Engine:sInspectorBridge	Lcom/tencent/tissue/v8rt/engine/Engine$InspectorBridge;
    //   140: invokevirtual 279	com/tencent/tissue/v8rt/engine/Engine$InspectorBridge:getInspectorAgent	()Lcom/tencent/tissue/v8rt/engine/IInspectorAgent;
    //   143: astore_2
    //   144: new 281	com/tencent/tissue/v8rt/engine/V8JsRuntime
    //   147: dup
    //   148: iload_1
    //   149: aload_2
    //   150: invokespecial 284	com/tencent/tissue/v8rt/engine/V8JsRuntime:<init>	(ILcom/tencent/tissue/v8rt/engine/IInspectorAgent;)V
    //   153: astore_2
    //   154: aload_0
    //   155: getfield 62	com/tencent/tissue/v8rt/engine/Engine:mEnginePathProvider	Lcom/tencent/tissue/v8rt/engine/EnginePathProvider;
    //   158: aload_2
    //   159: invokevirtual 288	com/tencent/tissue/v8rt/engine/V8JsRuntime:getDefaultContext	()Lcom/tencent/tissue/v8rt/engine/V8JsContext;
    //   162: invokestatic 294	com/tencent/tissue/v8rt/engine/JsRuntimeLoader:initDefaultContext	(Lcom/tencent/tissue/v8rt/engine/EnginePathProvider;Lcom/tencent/tissue/v8rt/engine/V8JsContext;)Z
    //   165: pop
    //   166: aload_0
    //   167: getfield 67	com/tencent/tissue/v8rt/engine/Engine:mV8RuntimeMap	Ljava/util/Map;
    //   170: iload_1
    //   171: invokestatic 300	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: aload_2
    //   175: invokeinterface 306 3 0
    //   180: pop
    //   181: goto -140 -> 41
    //   184: astore_2
    //   185: aload_0
    //   186: monitorexit
    //   187: aload_2
    //   188: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	Engine
    //   128	43	1	i	int
    //   3	172	2	localObject1	Object
    //   184	4	2	localObject2	Object
    //   1	129	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   6	41	184	finally
    //   45	80	184	finally
    //   80	129	184	finally
    //   131	144	184	finally
    //   144	181	184	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.Engine
 * JD-Core Version:    0.7.0.1
 */