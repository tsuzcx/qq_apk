package com.tencent.mobileqq.triton.engine;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.triton.annotation.JNIModule;
import com.tencent.mobileqq.triton.api.TTChannel;
import com.tencent.mobileqq.triton.audio.e;
import com.tencent.mobileqq.triton.audio.f;
import com.tencent.mobileqq.triton.bridge.TTJSBridge;
import com.tencent.mobileqq.triton.debug.JankCanary;
import com.tencent.mobileqq.triton.font.FontBitmapManager;
import com.tencent.mobileqq.triton.game.GameLauncher;
import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.mobileqq.triton.sdk.EnvConfig;
import com.tencent.mobileqq.triton.sdk.FPSCallback;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.ITLog;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.ITTEngine.IListener;
import com.tencent.mobileqq.triton.sdk.ITTEngine.OnGetTraceRecordCallback;
import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;
import com.tencent.mobileqq.triton.sdk.audio.IAudioPlayerFactory;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.bridge.InspectorAgent;
import com.tencent.mobileqq.triton.sdk.bridge.ScriptContextType;
import com.tencent.mobileqq.triton.sdk.callback.ScreenShotCallback;
import com.tencent.mobileqq.triton.sdk.debug.JankTraceLevel;
import com.tencent.mobileqq.triton.sdk.game.GameLifecycle;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import com.tencent.mobileqq.triton.sdk.statics.NativeLibraryLoadStatistic;
import com.tencent.mobileqq.triton.sdk.statics.ScriptLoadResult;
import com.tencent.mobileqq.triton.sdk.statics.ScriptLoadStatics;
import com.tencent.mobileqq.triton.touch.TouchEventManager;
import com.tencent.mobileqq.triton.utils.CanvasRecorder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@JNIModule
public class TTEngine
  implements ITTEngine
{
  private final String a = toString();
  private final Context b;
  private final IQQEnv c;
  private final com.tencent.mobileqq.triton.bridge.b d;
  private final IJSEngine e;
  private final TTJSBridge f;
  private final GameLauncher g;
  private final f h;
  private final ArrayList<NativeLibraryLoadStatistic> i = new ArrayList();
  private volatile boolean j = false;
  private ITTEngine.IListener k;
  private boolean l = true;
  private Activity m;
  @TTNativeCall
  private final CanvasRecorder mCanvasRecorder;
  @TTNativeCall
  private final FontBitmapManager mFontBitmapManager;
  @TTNativeCall
  private final com.tencent.mobileqq.triton.game.a mLifecycleManager;
  @TTNativeCall
  private final TTChannel mTTChannel;
  private volatile d n;
  @TTNativeCall
  private long nativeTTAppHandle;
  private TTEngine.InspectorBridge o;
  private volatile RenderContext p;
  private c q;
  private volatile int r;
  private HashMap<String, Boolean> s;
  private long t;
  private long u;
  private EnvConfig v;
  private final JankCanary w;
  
  TTEngine(Context paramContext, IQQEnv paramIQQEnv, ITLog paramITLog, IJSEngine paramIJSEngine, IAudioPlayerFactory paramIAudioPlayerFactory, EnvConfig paramEnvConfig)
  {
    TTLog.a(paramITLog);
    TTLog.c(this.a, "new TTEngine, EnvConfig:" + paramEnvConfig);
    this.v = paramEnvConfig;
    this.b = paramContext.getApplicationContext();
    this.nativeTTAppHandle = 0L;
    this.mTTChannel = new TTChannel(this);
    this.mFontBitmapManager = new FontBitmapManager(this);
    this.mLifecycleManager = new com.tencent.mobileqq.triton.game.a();
    this.d = new com.tencent.mobileqq.triton.bridge.b(this);
    this.f = new TTJSBridge(this);
    this.f.a(paramEnvConfig.getLogConfig());
    if (paramEnvConfig != null)
    {
      paramContext = paramEnvConfig.getJSPath();
      this.g = new GameLauncher(this, this.f, paramContext);
      this.q = new c(this, paramContext);
      this.mCanvasRecorder = new CanvasRecorder(this);
      this.h = new f();
      this.w = new JankCanary(this);
      this.c = paramIQQEnv;
      this.e = paramIJSEngine;
      a(paramIAudioPlayerFactory);
      if (paramEnvConfig == null) {
        break label271;
      }
    }
    label271:
    for (paramContext = paramEnvConfig.getTritonPath();; paramContext = "")
    {
      b(paramContext);
      return;
      paramContext = "";
      break;
    }
  }
  
  @TTNativeCall
  private void _setTargetFPS(int paramInt)
  {
    setTargetFPS(paramInt);
  }
  
  private static ScriptLoadStatics a(String paramString1, int paramInt1, String paramString2, int paramInt2, long[] paramArrayOfLong, String[] paramArrayOfString)
  {
    ScriptLoadResult localScriptLoadResult;
    ScriptContextType localScriptContextType;
    switch (paramInt2)
    {
    default: 
      localScriptLoadResult = ScriptLoadResult.FAIL_INVALID_STATE;
      if (paramInt1 != 2) {
        if (paramInt1 != 3) {
          localScriptContextType = ScriptContextType.MAIN;
        }
      }
      break;
    }
    for (;;)
    {
      return new ScriptLoadStatics(localScriptLoadResult, localScriptContextType, paramString1, paramString2, paramArrayOfLong[0], paramArrayOfLong[1], paramArrayOfLong[2], paramArrayOfLong[3], paramArrayOfString[0]);
      localScriptLoadResult = ScriptLoadResult.SUCCESS_BUT_CACHE_REJECTED;
      break;
      localScriptLoadResult = ScriptLoadResult.SUCCESS_WITHOUT_CACHE;
      break;
      localScriptLoadResult = ScriptLoadResult.SUCCESS_WITH_CACHE;
      break;
      localScriptLoadResult = ScriptLoadResult.FAIL_READ_SCRIPT;
      break;
      localScriptLoadResult = ScriptLoadResult.FAIL_COMPILE;
      break;
      localScriptLoadResult = ScriptLoadResult.FAIL_EXECUTE;
      break;
      localScriptContextType = ScriptContextType.WORKER;
      continue;
      localScriptContextType = ScriptContextType.OPEN_DATA;
    }
  }
  
  private void a(IAudioPlayerFactory paramIAudioPlayerFactory)
  {
    com.tencent.mobileqq.triton.bridge.d.a locala = (com.tencent.mobileqq.triton.bridge.d.a)this.d.a(com.tencent.mobileqq.triton.bridge.d.a.class);
    if ((locala != null) && (locala.d() != null)) {
      locala.d().a(paramIAudioPlayerFactory);
    }
  }
  
  private void a(String paramString) {}
  
  /* Error */
  private void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokestatic 268	android/os/SystemClock:uptimeMillis	()J
    //   6: putfield 270	com/tencent/mobileqq/triton/engine/TTEngine:t	J
    //   9: aload_1
    //   10: aload_0
    //   11: getfield 73	com/tencent/mobileqq/triton/engine/TTEngine:i	Ljava/util/ArrayList;
    //   14: invokestatic 275	com/tencent/mobileqq/triton/engine/e:b	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   17: aload_0
    //   18: aload_1
    //   19: aload_0
    //   20: getfield 73	com/tencent/mobileqq/triton/engine/TTEngine:i	Ljava/util/ArrayList;
    //   23: invokestatic 278	com/tencent/mobileqq/triton/engine/e:a	(Ljava/lang/String;Ljava/util/ArrayList;)Ljava/util/HashMap;
    //   26: putfield 280	com/tencent/mobileqq/triton/engine/TTEngine:s	Ljava/util/HashMap;
    //   29: aload_0
    //   30: new 282	com/tencent/mobileqq/triton/engine/TTEngine$InspectorBridge
    //   33: dup
    //   34: aconst_null
    //   35: invokespecial 285	com/tencent/mobileqq/triton/engine/TTEngine$InspectorBridge:<init>	(Lcom/tencent/mobileqq/triton/engine/TTEngine$a;)V
    //   38: putfield 287	com/tencent/mobileqq/triton/engine/TTEngine:o	Lcom/tencent/mobileqq/triton/engine/TTEngine$InspectorBridge;
    //   41: aload_0
    //   42: new 289	com/tencent/mobileqq/triton/render/RenderContext
    //   45: dup
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 114	com/tencent/mobileqq/triton/engine/TTEngine:b	Landroid/content/Context;
    //   51: invokespecial 292	com/tencent/mobileqq/triton/render/RenderContext:<init>	(Lcom/tencent/mobileqq/triton/engine/TTEngine;Landroid/content/Context;)V
    //   54: putfield 294	com/tencent/mobileqq/triton/engine/TTEngine:p	Lcom/tencent/mobileqq/triton/render/RenderContext;
    //   57: aload_0
    //   58: aload_0
    //   59: invokevirtual 297	com/tencent/mobileqq/triton/engine/TTEngine:d	()I
    //   62: putfield 299	com/tencent/mobileqq/triton/engine/TTEngine:r	I
    //   65: aload_0
    //   66: invokevirtual 303	java/lang/Object:getClass	()Ljava/lang/Class;
    //   69: invokevirtual 309	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   72: instanceof 311
    //   75: istore_2
    //   76: aload_0
    //   77: getfield 83	com/tencent/mobileqq/triton/engine/TTEngine:a	Ljava/lang/String;
    //   80: new 90	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 313
    //   90: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: iload_2
    //   94: invokevirtual 316	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   97: ldc_w 318
    //   100: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokestatic 322	com/tencent/mobileqq/triton/jni/b:a	()Ljava/lang/String;
    //   106: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 104	com/tencent/mobileqq/triton/engine/TTLog:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   115: pop
    //   116: aload_0
    //   117: invokestatic 325	com/tencent/mobileqq/triton/jni/b:d	(Lcom/tencent/mobileqq/triton/engine/TTEngine;)Z
    //   120: ifeq +91 -> 211
    //   123: aload_0
    //   124: invokevirtual 328	com/tencent/mobileqq/triton/engine/TTEngine:l	()Lcom/tencent/mobileqq/triton/sdk/IQQEnv;
    //   127: bipush 8
    //   129: aconst_null
    //   130: invokeinterface 334 3 0
    //   135: aload_0
    //   136: getfield 169	com/tencent/mobileqq/triton/engine/TTEngine:q	Lcom/tencent/mobileqq/triton/engine/c;
    //   139: invokevirtual 337	com/tencent/mobileqq/triton/engine/c:a	()Z
    //   142: ifeq +15 -> 157
    //   145: aload_0
    //   146: invokevirtual 328	com/tencent/mobileqq/triton/engine/TTEngine:l	()Lcom/tencent/mobileqq/triton/sdk/IQQEnv;
    //   149: bipush 9
    //   151: aconst_null
    //   152: invokeinterface 334 3 0
    //   157: aload_0
    //   158: invokestatic 268	android/os/SystemClock:uptimeMillis	()J
    //   161: putfield 339	com/tencent/mobileqq/triton/engine/TTEngine:u	J
    //   164: aload_0
    //   165: new 341	com/tencent/mobileqq/triton/engine/d
    //   168: dup
    //   169: aload_0
    //   170: invokespecial 342	com/tencent/mobileqq/triton/engine/d:<init>	(Lcom/tencent/mobileqq/triton/engine/TTEngine;)V
    //   173: putfield 344	com/tencent/mobileqq/triton/engine/TTEngine:n	Lcom/tencent/mobileqq/triton/engine/d;
    //   176: aload_0
    //   177: aload_0
    //   178: getfield 138	com/tencent/mobileqq/triton/engine/TTEngine:d	Lcom/tencent/mobileqq/triton/bridge/b;
    //   181: invokevirtual 348	com/tencent/mobileqq/triton/engine/TTEngine:addGameLifeCycle	(Lcom/tencent/mobileqq/triton/sdk/game/GameLifecycle;)V
    //   184: aload_0
    //   185: new 350	com/tencent/mobileqq/triton/engine/a
    //   188: dup
    //   189: aload_0
    //   190: invokespecial 351	com/tencent/mobileqq/triton/engine/a:<init>	(Lcom/tencent/mobileqq/triton/engine/TTEngine;)V
    //   193: invokevirtual 348	com/tencent/mobileqq/triton/engine/TTEngine:addGameLifeCycle	(Lcom/tencent/mobileqq/triton/sdk/game/GameLifecycle;)V
    //   196: aload_0
    //   197: getfield 344	com/tencent/mobileqq/triton/engine/TTEngine:n	Lcom/tencent/mobileqq/triton/engine/d;
    //   200: invokevirtual 353	com/tencent/mobileqq/triton/engine/d:d	()V
    //   203: aload_0
    //   204: iconst_1
    //   205: putfield 75	com/tencent/mobileqq/triton/engine/TTEngine:j	Z
    //   208: aload_0
    //   209: monitorexit
    //   210: return
    //   211: aload_0
    //   212: getfield 83	com/tencent/mobileqq/triton/engine/TTEngine:a	Ljava/lang/String;
    //   215: ldc_w 355
    //   218: invokestatic 357	com/tencent/mobileqq/triton/engine/TTLog:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   221: pop
    //   222: aload_0
    //   223: sipush 2001
    //   226: invokevirtual 359	com/tencent/mobileqq/triton/engine/TTEngine:a	(I)V
    //   229: new 361	com/tencent/mobileqq/triton/sdk/TTEngineBuilder$EngineCreationException
    //   232: dup
    //   233: ldc_w 355
    //   236: invokespecial 363	com/tencent/mobileqq/triton/sdk/TTEngineBuilder$EngineCreationException:<init>	(Ljava/lang/String;)V
    //   239: athrow
    //   240: astore_1
    //   241: aload_0
    //   242: monitorexit
    //   243: aload_1
    //   244: athrow
    //   245: astore_1
    //   246: aload_0
    //   247: getfield 83	com/tencent/mobileqq/triton/engine/TTEngine:a	Ljava/lang/String;
    //   250: ldc_w 365
    //   253: invokestatic 357	com/tencent/mobileqq/triton/engine/TTLog:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   256: pop
    //   257: aload_0
    //   258: sipush 1001
    //   261: invokevirtual 359	com/tencent/mobileqq/triton/engine/TTEngine:a	(I)V
    //   264: new 361	com/tencent/mobileqq/triton/sdk/TTEngineBuilder$EngineCreationException
    //   267: dup
    //   268: aload_1
    //   269: invokespecial 368	com/tencent/mobileqq/triton/sdk/TTEngineBuilder$EngineCreationException:<init>	(Ljava/lang/Throwable;)V
    //   272: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	TTEngine
    //   0	273	1	paramString	String
    //   75	19	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	240	finally
    //   9	17	240	finally
    //   17	157	240	finally
    //   157	210	240	finally
    //   211	240	240	finally
    //   241	243	240	finally
    //   246	273	240	finally
    //   9	17	245	java/lang/UnsatisfiedLinkError
  }
  
  public static native void nativeFontManagerInit(AssetManager paramAssetManager, String paramString);
  
  public static native String nativeGetTTVersion();
  
  private void q()
  {
    IQQEnv localIQQEnv = this.c;
    if ((localIQQEnv != null) && (this.f != null)) {
      localIQQEnv.postRunable(new TTEngine.a(this));
    }
  }
  
  @NonNull
  public ScriptLoadStatics a(int paramInt, @NonNull String paramString1, @NonNull String paramString2, @Nullable String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      long[] arrayOfLong = new long[4];
      String[] arrayOfString = new String[1];
      return a(paramString2, paramInt, paramString1, com.tencent.mobileqq.triton.jni.b.a(this, paramInt, paramString1, this.g.getGameDebugPath(paramString2), paramString3, arrayOfLong, arrayOfString), arrayOfLong, arrayOfString);
    }
    throw new IllegalStateException("parameter must not be null or empty");
  }
  
  public void a()
  {
    com.tencent.mobileqq.triton.jni.b.a(this, m(), c(), n(), getGameLauncher(), f(), this.o);
  }
  
  public void a(int paramInt)
  {
    this.g.a(paramInt, this.u - this.t, h().d(), SystemClock.uptimeMillis() - h().c(), SystemClock.uptimeMillis() - this.t, this.q.b(), this.i);
    this.i.clear();
  }
  
  public void a(InspectorAgent paramInspectorAgent)
  {
    if (paramInspectorAgent != null) {
      this.o.a(paramInspectorAgent);
    }
  }
  
  public void a(@NonNull Runnable paramRunnable)
  {
    a(paramRunnable, 0L);
  }
  
  public void a(@NonNull Runnable paramRunnable, long paramLong)
  {
    a("post runnable after engine is destroyed");
    if (this.j) {
      com.tencent.mobileqq.triton.jni.b.a(this, paramRunnable, paramLong, 0);
    }
  }
  
  public void addFPSCallback(FPSCallback paramFPSCallback)
  {
    if (m() != null) {}
    for (com.tencent.mobileqq.triton.render.c.b localb = (com.tencent.mobileqq.triton.render.c.b)m().a(com.tencent.mobileqq.triton.render.c.b.class);; localb = null)
    {
      if (localb != null) {
        localb.a(paramFPSCallback);
      }
      return;
    }
  }
  
  public void addGameLifeCycle(GameLifecycle paramGameLifecycle)
  {
    this.mLifecycleManager.a(paramGameLifecycle);
  }
  
  public Activity b()
  {
    return this.m;
  }
  
  public CanvasRecorder c()
  {
    return this.mCanvasRecorder;
  }
  
  public View createGameView(Activity paramActivity, int paramInt1, int paramInt2)
  {
    if (m() != null) {
      return m().a(paramActivity, paramInt1, paramInt2, this.v.getDisplayMetrics().density);
    }
    throw new IllegalStateException("createGameView on null renderContext or null SystemInfoManager");
  }
  
  public int d()
  {
    return this.v.getScreenRefreshRate();
  }
  
  public ITTEngine.IListener e()
  {
    return this.k;
  }
  
  public FontBitmapManager f()
  {
    return this.mFontBitmapManager;
  }
  
  public IJSEngine g()
  {
    return this.d;
  }
  
  public IAudioNativeManager getAudioNativeManager()
  {
    return this.h;
  }
  
  public long getCurrentDrawCount()
  {
    return this.n.e();
  }
  
  public GameLauncher getGameLauncher()
  {
    return this.g;
  }
  
  public IJSEngine getJsEngine()
  {
    return this.e;
  }
  
  public ITTJSRuntime getJsRuntime(int paramInt)
  {
    return this.f.a(paramInt);
  }
  
  public long getLastBlackTime()
  {
    if (m() != null) {}
    for (com.tencent.mobileqq.triton.render.c.a locala = (com.tencent.mobileqq.triton.render.c.a)m().a(com.tencent.mobileqq.triton.render.c.a.class); locala != null; locala = null) {
      return locala.b();
    }
    return -1L;
  }
  
  public String getLastClicks()
  {
    if (this.p == null) {}
    TouchEventManager localTouchEventManager;
    do
    {
      return null;
      localTouchEventManager = this.p.e();
    } while (localTouchEventManager == null);
    return localTouchEventManager.b();
  }
  
  public ITNativeBufferPool getNativeBufferPool()
  {
    return this.f;
  }
  
  public boolean getOptionalSoLoadStatus(String paramString)
  {
    HashMap localHashMap = this.s;
    if ((localHashMap != null) && (!localHashMap.isEmpty()) && (this.s.containsKey(paramString))) {
      return ((Boolean)this.s.get(paramString)).booleanValue();
    }
    return false;
  }
  
  public native int getProcessedMessageCount();
  
  public Map<String, String> getResPathCache()
  {
    return GameLauncher.b();
  }
  
  public void getScreenShot(ScreenShotCallback paramScreenShotCallback)
  {
    if (m() != null) {}
    for (com.tencent.mobileqq.triton.render.c.d locald = (com.tencent.mobileqq.triton.render.c.d)m().a(com.tencent.mobileqq.triton.render.c.d.class);; locald = null)
    {
      if (locald != null) {
        locald.a(paramScreenShotCallback);
      }
      return;
    }
  }
  
  public int getTargetFPS()
  {
    return this.r;
  }
  
  public void getTraceRecord(@NonNull ITTEngine.OnGetTraceRecordCallback paramOnGetTraceRecordCallback)
  {
    this.w.a(paramOnGetTraceRecordCallback);
  }
  
  public c h()
  {
    return this.q;
  }
  
  public void handleFocusGain()
  {
    com.tencent.mobileqq.triton.bridge.d.a locala = (com.tencent.mobileqq.triton.bridge.d.a)this.d.a(com.tencent.mobileqq.triton.bridge.d.a.class);
    if ((locala != null) && (locala.d() != null)) {
      locala.d().a();
    }
  }
  
  public void handleFocusLoss()
  {
    com.tencent.mobileqq.triton.bridge.d.a locala = (com.tencent.mobileqq.triton.bridge.d.a)this.d.a(com.tencent.mobileqq.triton.bridge.d.a.class);
    if ((locala != null) && (locala.d() != null)) {
      locala.d().b();
    }
  }
  
  public com.tencent.mobileqq.triton.game.a i()
  {
    return this.mLifecycleManager;
  }
  
  public native void interruptLoop();
  
  public MiniGameInfo j()
  {
    if (getGameLauncher() != null) {
      return getGameLauncher().getCurrentGame();
    }
    return null;
  }
  
  public long k()
  {
    return this.nativeTTAppHandle;
  }
  
  public IQQEnv l()
  {
    return this.c;
  }
  
  public RenderContext m()
  {
    return this.p;
  }
  
  public TTChannel n()
  {
    return this.mTTChannel;
  }
  
  public native long nativeCanvasPresent();
  
  public native void nativeCreateTTApp(RenderContext paramRenderContext, CanvasRecorder paramCanvasRecorder, TTChannel paramTTChannel, GameLauncher paramGameLauncher, FontBitmapManager paramFontBitmapManager, TTEngine.InspectorBridge paramInspectorBridge);
  
  public native void nativeDiposeTTApp();
  
  public native boolean nativeEnvInit();
  
  public native void nativeFinalize();
  
  public native long nativeGetCurrentFrameDrawCallCount();
  
  public native int nativeLoadScriptPathWithCodeCache(int paramInt, @NonNull String paramString1, @NonNull String paramString2, @Nullable String paramString3, long[] paramArrayOfLong, String[] paramArrayOfString);
  
  public native int nativeLoadScriptStringWithCodeCache(int paramInt, @NonNull String paramString1, @NonNull String paramString2, @Nullable String paramString3, long[] paramArrayOfLong, String[] paramArrayOfString);
  
  public native void nativeOnVSync(long paramLong);
  
  public native void nativePause();
  
  public native void nativeResume();
  
  public native void nativeSaveScriptCodeCache();
  
  public native void nativeSetJankTraceLevel(int paramInt);
  
  public native boolean nativeStartDrawCall();
  
  public boolean o()
  {
    return (this.n != null) && (this.n.f());
  }
  
  public void onCreate(Activity paramActivity)
  {
    this.m = paramActivity;
    this.mLifecycleManager.onCreate(paramActivity, this);
  }
  
  public void onDestroy()
  {
    TTLog.c(this.a, "~TTEngine " + this);
    this.m = null;
    this.j = false;
    this.mLifecycleManager.onDestroy();
    if (this.p != null) {
      this.p.f();
    }
    if (this.n != null) {
      this.n.g();
    }
  }
  
  public void onPause()
  {
    this.mLifecycleManager.onPause();
    q();
    if (this.n != null) {
      this.n.h();
    }
  }
  
  public void onResume()
  {
    if (this.n != null) {
      this.n.i();
    }
    this.mLifecycleManager.onResume();
  }
  
  @TTNativeCall
  public String onScriptCall(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    paramArrayOfByte1 = new String(paramArrayOfByte1);
    paramArrayOfByte2 = new String(paramArrayOfByte2);
    return this.f.a(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
  }
  
  @TTNativeCall
  public String onScriptPublish(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    paramArrayOfByte1 = new String(paramArrayOfByte1);
    paramArrayOfByte2 = new String(paramArrayOfByte2);
    paramArrayOfByte3 = new String(paramArrayOfByte3);
    return this.f.a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt);
  }
  
  void p()
  {
    if (this.l) {
      com.tencent.mobileqq.triton.jni.b.f(this);
    }
  }
  
  public native void postRunnableDelayedWithPriority(@NonNull Runnable paramRunnable, long paramLong, int paramInt);
  
  public void removeFPSCallback(FPSCallback paramFPSCallback)
  {
    if (m() != null) {}
    for (com.tencent.mobileqq.triton.render.c.b localb = (com.tencent.mobileqq.triton.render.c.b)m().a(com.tencent.mobileqq.triton.render.c.b.class);; localb = null)
    {
      if (localb != null) {
        localb.b(paramFPSCallback);
      }
      return;
    }
  }
  
  public native boolean runLoop(boolean paramBoolean);
  
  public void setEnableCodeCache(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setEngineListener(ITTEngine.IListener paramIListener)
  {
    this.k = paramIListener;
  }
  
  public void setJankTraceLevel(JankTraceLevel paramJankTraceLevel)
  {
    com.tencent.mobileqq.triton.jni.b.a(this, paramJankTraceLevel.ordinal());
  }
  
  public void setTargetFPS(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= d()))
    {
      this.r = paramInt;
      if (this.n != null) {
        this.n.a(paramInt);
      }
      TTLog.c(this.a, "setTargetFPS:" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.TTEngine
 * JD-Core Version:    0.7.0.1
 */