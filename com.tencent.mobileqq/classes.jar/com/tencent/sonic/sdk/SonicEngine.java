package com.tencent.sonic.sdk;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SonicEngine
{
  private static final String TAG = "SonicSdk_SonicEngine";
  private static SonicEngine sInstance;
  private final SonicConfig config;
  private final ConcurrentHashMap<String, SonicSession> preloadSessionPool = new ConcurrentHashMap(5);
  private final ConcurrentHashMap<String, SonicSession> runningSessionHashMap = new ConcurrentHashMap(5);
  private final SonicRuntime runtime;
  private final SonicSession.Callback sessionCallback = new SonicEngine.1(this);
  
  private SonicEngine(SonicRuntime paramSonicRuntime, SonicConfig paramSonicConfig)
  {
    this.runtime = paramSonicRuntime;
    this.config = paramSonicConfig;
  }
  
  public static SonicEngine createInstance(@NonNull SonicRuntime paramSonicRuntime, @NonNull SonicConfig paramSonicConfig)
  {
    try
    {
      if (sInstance == null)
      {
        sInstance = new SonicEngine(paramSonicRuntime, paramSonicConfig);
        if (paramSonicConfig.AUTO_INIT_DB_WHEN_CREATE) {
          sInstance.initSonicDB();
        }
      }
      paramSonicRuntime = sInstance;
      return paramSonicRuntime;
    }
    finally {}
  }
  
  public static SonicEngine getInstance()
  {
    try
    {
      if (sInstance == null) {
        throw new IllegalStateException("SonicEngine::createInstance() needs to be called before SonicEngine::getInstance()");
      }
    }
    finally {}
    SonicEngine localSonicEngine = sInstance;
    return localSonicEngine;
  }
  
  private SonicSession internalCreateSession(String paramString1, String paramString2, SonicSessionConfig paramSonicSessionConfig)
  {
    if (!this.runningSessionHashMap.containsKey(paramString1))
    {
      paramString1 = new SonicSession(paramString1, paramString2, paramSonicSessionConfig);
      paramString1.addSessionStateChangedCallback(this.sessionCallback);
      if (paramSonicSessionConfig.AUTO_START_WHEN_CREATE) {
        paramString1.start();
      }
      return paramString1;
    }
    if (this.runtime.shouldLog(6)) {
      this.runtime.log("SonicSdk_SonicEngine", 6, "internalCreateSession error:sessionId(" + paramString1 + ") is running now.");
    }
    return null;
  }
  
  /* Error */
  public static boolean isGetInstanceAllowed()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 53	com/tencent/sonic/sdk/SonicEngine:sInstance	Lcom/tencent/sonic/sdk/SonicEngine;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +10 -> 18
    //   11: iconst_1
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_0
    //   20: goto -7 -> 13
    //   23: astore_1
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	8	0	bool	boolean
    //   6	2	1	localSonicEngine	SonicEngine
    //   23	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  private boolean isSessionAvailable(String paramString)
  {
    long l = SonicDataHelper.getLastSonicUnavailableTime(paramString);
    if (System.currentTimeMillis() > l) {
      return true;
    }
    if (this.runtime.shouldLog(6)) {
      this.runtime.log("SonicSdk_SonicEngine", 6, "sessionId(" + paramString + ") is unavailable and unavailable time until " + l + ".");
    }
    return false;
  }
  
  private SonicSession lookupSession(SonicSessionConfig paramSonicSessionConfig, String paramString, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramSonicSessionConfig != null))
    {
      SonicSession localSonicSession2 = (SonicSession)this.preloadSessionPool.get(paramString);
      SonicSession localSonicSession1 = localSonicSession2;
      if (localSonicSession2 != null)
      {
        if ((paramSonicSessionConfig.equals(localSonicSession2.config)) && ((localSonicSession2.config.PRELOAD_SESSION_EXPIRED_TIME <= 0L) || (System.currentTimeMillis() - localSonicSession2.createdTime <= localSonicSession2.config.PRELOAD_SESSION_EXPIRED_TIME))) {
          break label146;
        }
        if (this.runtime.shouldLog(6)) {
          this.runtime.log("SonicSdk_SonicEngine", 6, "lookupSession error:sessionId(" + paramString + ") is expired.");
        }
        this.preloadSessionPool.remove(paramString);
        localSonicSession2.destroy();
        localSonicSession1 = null;
      }
      label146:
      do
      {
        return localSonicSession1;
        localSonicSession1 = localSonicSession2;
      } while (!paramBoolean);
      this.preloadSessionPool.remove(paramString);
      return localSonicSession2;
    }
    return null;
  }
  
  public static String makeSessionId(String paramString, boolean paramBoolean)
  {
    return getInstance().getRuntime().makeSessionId(paramString, paramBoolean);
  }
  
  public boolean cleanCache()
  {
    try
    {
      if (!this.preloadSessionPool.isEmpty())
      {
        this.runtime.log("SonicSdk_SonicEngine", 4, "cleanCache: remove all preload sessions, size=" + this.preloadSessionPool.size() + ".");
        Iterator localIterator = this.preloadSessionPool.values().iterator();
        while (localIterator.hasNext()) {
          ((SonicSession)localIterator.next()).destroy();
        }
        this.preloadSessionPool.clear();
      }
    }
    finally {}
    if (!this.runningSessionHashMap.isEmpty()) {
      this.runtime.log("SonicSdk_SonicEngine", 6, "cleanCache fail, running session map's size is " + this.runningSessionHashMap.size() + ".");
    }
    for (boolean bool = false;; bool = SonicUtils.removeAllSessionCache())
    {
      return bool;
      this.runtime.log("SonicSdk_SonicEngine", 4, "cleanCache: remove all sessions cache.");
    }
  }
  
  /* Error */
  public SonicSession createSession(@NonNull String paramString, @NonNull SonicSessionConfig paramSonicSessionConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 240	com/tencent/sonic/sdk/SonicEngine:isSonicAvailable	()Z
    //   6: ifeq +64 -> 70
    //   9: aload_1
    //   10: aload_2
    //   11: getfield 243	com/tencent/sonic/sdk/SonicSessionConfig:IS_ACCOUNT_RELATED	Z
    //   14: invokestatic 244	com/tencent/sonic/sdk/SonicEngine:makeSessionId	(Ljava/lang/String;Z)Ljava/lang/String;
    //   17: astore 4
    //   19: aload 4
    //   21: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +59 -> 83
    //   27: aload_0
    //   28: aload_2
    //   29: aload 4
    //   31: iconst_1
    //   32: invokespecial 246	com/tencent/sonic/sdk/SonicEngine:lookupSession	(Lcom/tencent/sonic/sdk/SonicSessionConfig;Ljava/lang/String;Z)Lcom/tencent/sonic/sdk/SonicSession;
    //   35: astore_3
    //   36: aload_3
    //   37: ifnull +12 -> 49
    //   40: aload_3
    //   41: aload_1
    //   42: invokevirtual 249	com/tencent/sonic/sdk/SonicSession:setIsPreload	(Ljava/lang/String;)V
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_3
    //   48: areturn
    //   49: aload_0
    //   50: aload 4
    //   52: invokespecial 251	com/tencent/sonic/sdk/SonicEngine:isSessionAvailable	(Ljava/lang/String;)Z
    //   55: ifeq -10 -> 45
    //   58: aload_0
    //   59: aload 4
    //   61: aload_1
    //   62: aload_2
    //   63: invokespecial 253	com/tencent/sonic/sdk/SonicEngine:internalCreateSession	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/sonic/sdk/SonicSessionConfig;)Lcom/tencent/sonic/sdk/SonicSession;
    //   66: astore_3
    //   67: goto -22 -> 45
    //   70: aload_0
    //   71: getfield 43	com/tencent/sonic/sdk/SonicEngine:runtime	Lcom/tencent/sonic/sdk/SonicRuntime;
    //   74: ldc 8
    //   76: bipush 6
    //   78: ldc 255
    //   80: invokevirtual 122	com/tencent/sonic/sdk/SonicRuntime:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aconst_null
    //   84: astore_3
    //   85: goto -40 -> 45
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	SonicEngine
    //   0	93	1	paramString	String
    //   0	93	2	paramSonicSessionConfig	SonicSessionConfig
    //   35	50	3	localSonicSession	SonicSession
    //   17	43	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	36	88	finally
    //   40	45	88	finally
    //   49	67	88	finally
    //   70	83	88	finally
  }
  
  public SonicConfig getConfig()
  {
    return this.config;
  }
  
  public SonicRuntime getRuntime()
  {
    return this.runtime;
  }
  
  public void initSonicDB()
  {
    try
    {
      SonicDBHelper.createInstance(getRuntime().getContext()).getWritableDatabase();
      return;
    }
    catch (Throwable localThrowable)
    {
      SonicUtils.log("SonicSdk_SonicEngine", 6, "initSonicDB getWritableDatabase encounter error." + localThrowable.getMessage());
    }
  }
  
  public boolean isSonicAvailable()
  {
    return !SonicDBHelper.getInstance().isUpgrading();
  }
  
  public boolean preCreateSession(@NonNull String paramString, @NonNull SonicSessionConfig paramSonicSessionConfig)
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        if (isSonicAvailable())
        {
          String str = makeSessionId(paramString, paramSonicSessionConfig.IS_ACCOUNT_RELATED);
          bool1 = bool2;
          if (!TextUtils.isEmpty(str))
          {
            if (lookupSession(paramSonicSessionConfig, str, false) != null)
            {
              this.runtime.log("SonicSdk_SonicEngine", 6, "preCreateSession：sessionId(" + str + ") is already in preload pool.");
              bool1 = bool2;
            }
          }
          else {
            return bool1;
          }
          if (this.preloadSessionPool.size() < this.config.MAX_PRELOAD_SESSION_COUNT)
          {
            bool1 = bool2;
            if (!isSessionAvailable(str)) {
              continue;
            }
            bool1 = bool2;
            if (!this.runtime.isNetworkValid()) {
              continue;
            }
            paramString = internalCreateSession(str, paramString, paramSonicSessionConfig);
            bool1 = bool2;
            if (paramString == null) {
              continue;
            }
            this.preloadSessionPool.put(str, paramString);
            bool1 = true;
            continue;
          }
          this.runtime.log("SonicSdk_SonicEngine", 6, "create id(" + str + ") fail for preload size is bigger than " + this.config.MAX_PRELOAD_SESSION_COUNT + ".");
          bool1 = bool2;
          continue;
        }
        this.runtime.log("SonicSdk_SonicEngine", 6, "preCreateSession fail for sonic service is unavailable!");
      }
      finally {}
      boolean bool1 = bool2;
    }
  }
  
  /* Error */
  public boolean preCreateSession(@NonNull String paramString, @NonNull SonicSessionConfig paramSonicSessionConfig, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokevirtual 240	com/tencent/sonic/sdk/SonicEngine:isSonicAvailable	()Z
    //   9: ifeq +77 -> 86
    //   12: aload_1
    //   13: aload_2
    //   14: getfield 243	com/tencent/sonic/sdk/SonicSessionConfig:IS_ACCOUNT_RELATED	Z
    //   17: invokestatic 244	com/tencent/sonic/sdk/SonicEngine:makeSessionId	(Ljava/lang/String;Z)Ljava/lang/String;
    //   20: astore 9
    //   22: new 310	java/io/File
    //   25: dup
    //   26: aload 9
    //   28: invokestatic 316	com/tencent/sonic/sdk/SonicFileUtils:getSonicHtmlPath	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokespecial 317	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: invokevirtual 320	java/io/File:exists	()Z
    //   37: ifeq +33 -> 70
    //   40: aload 9
    //   42: invokestatic 323	com/tencent/sonic/sdk/SonicDataHelper:getTemplateUpdateTime	(Ljava/lang/String;)J
    //   45: lstore 6
    //   47: lload 6
    //   49: lload_3
    //   50: lcmp
    //   51: ifle +8 -> 59
    //   54: aload_0
    //   55: monitorexit
    //   56: iload 8
    //   58: ireturn
    //   59: aload_0
    //   60: aload_1
    //   61: aload_2
    //   62: invokevirtual 325	com/tencent/sonic/sdk/SonicEngine:preCreateSession	(Ljava/lang/String;Lcom/tencent/sonic/sdk/SonicSessionConfig;)Z
    //   65: istore 8
    //   67: goto -13 -> 54
    //   70: iload 5
    //   72: ifeq -18 -> 54
    //   75: aload_0
    //   76: aload_1
    //   77: aload_2
    //   78: invokevirtual 325	com/tencent/sonic/sdk/SonicEngine:preCreateSession	(Ljava/lang/String;Lcom/tencent/sonic/sdk/SonicSessionConfig;)Z
    //   81: istore 8
    //   83: goto -29 -> 54
    //   86: aload_0
    //   87: getfield 43	com/tencent/sonic/sdk/SonicEngine:runtime	Lcom/tencent/sonic/sdk/SonicRuntime;
    //   90: ldc 8
    //   92: bipush 6
    //   94: ldc_w 307
    //   97: invokevirtual 122	com/tencent/sonic/sdk/SonicRuntime:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: goto -46 -> 54
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	SonicEngine
    //   0	108	1	paramString	String
    //   0	108	2	paramSonicSessionConfig	SonicSessionConfig
    //   0	108	3	paramLong	long
    //   0	108	5	paramInt	int
    //   45	3	6	l	long
    //   1	81	8	bool	boolean
    //   20	21	9	str	String
    // Exception table:
    //   from	to	target	type
    //   5	47	103	finally
    //   59	67	103	finally
    //   75	83	103	finally
    //   86	100	103	finally
  }
  
  public void removeExpiredSessionCache(@NonNull Map<String, Long> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      long l1 = ((Long)paramMap.get(str)).longValue();
      long l2 = SonicDataHelper.getTemplateUpdateTime(str);
      if (SonicUtils.shouldLog(3)) {
        SonicUtils.log("SonicSdk_SonicEngine", 3, "removeExpiredSessionCache sessionId(" + str + ") newTemplateUpdateTime = " + l1 + ", curTemplateUpdateTime = " + l2);
      }
      if ((0L != l2) && (l2 < l1)) {
        removeSessionCache(str);
      }
    }
  }
  
  /* Error */
  public boolean removeSessionCache(@NonNull String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/sonic/sdk/SonicEngine:preloadSessionPool	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 159	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 82	com/tencent/sonic/sdk/SonicSession
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull +51 -> 66
    //   18: aload_3
    //   19: invokevirtual 182	com/tencent/sonic/sdk/SonicSession:destroy	()V
    //   22: aload_0
    //   23: getfield 32	com/tencent/sonic/sdk/SonicEngine:preloadSessionPool	Ljava/util/concurrent/ConcurrentHashMap;
    //   26: aload_1
    //   27: invokevirtual 179	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: pop
    //   31: aload_0
    //   32: getfield 43	com/tencent/sonic/sdk/SonicEngine:runtime	Lcom/tencent/sonic/sdk/SonicRuntime;
    //   35: ldc 8
    //   37: iconst_4
    //   38: new 105	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   45: ldc 140
    //   47: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_1
    //   51: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc_w 358
    //   57: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokevirtual 122	com/tencent/sonic/sdk/SonicRuntime:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: aload_0
    //   67: getfield 34	com/tencent/sonic/sdk/SonicEngine:runningSessionHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   70: aload_1
    //   71: invokevirtual 80	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   74: ifne +48 -> 122
    //   77: aload_0
    //   78: getfield 43	com/tencent/sonic/sdk/SonicEngine:runtime	Lcom/tencent/sonic/sdk/SonicRuntime;
    //   81: ldc 8
    //   83: iconst_4
    //   84: new 105	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   91: ldc 140
    //   93: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_1
    //   97: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc_w 360
    //   103: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokevirtual 122	com/tencent/sonic/sdk/SonicRuntime:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: aload_1
    //   113: invokestatic 362	com/tencent/sonic/sdk/SonicUtils:removeSessionCache	(Ljava/lang/String;)V
    //   116: iconst_1
    //   117: istore_2
    //   118: aload_0
    //   119: monitorexit
    //   120: iload_2
    //   121: ireturn
    //   122: aload_0
    //   123: getfield 43	com/tencent/sonic/sdk/SonicEngine:runtime	Lcom/tencent/sonic/sdk/SonicRuntime;
    //   126: ldc 8
    //   128: bipush 6
    //   130: new 105	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   137: ldc 140
    //   139: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_1
    //   143: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc_w 364
    //   149: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokevirtual 122	com/tencent/sonic/sdk/SonicRuntime:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: iconst_0
    //   159: istore_2
    //   160: goto -42 -> 118
    //   163: astore_1
    //   164: aload_0
    //   165: monitorexit
    //   166: aload_1
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	SonicEngine
    //   0	168	1	paramString	String
    //   117	43	2	bool	boolean
    //   13	6	3	localSonicSession	SonicSession
    // Exception table:
    //   from	to	target	type
    //   2	14	163	finally
    //   18	66	163	finally
    //   66	116	163	finally
    //   122	158	163	finally
  }
  
  public void trimSonicCache()
  {
    SonicFileUtils.checkAndTrimCache();
    SonicFileUtils.checkAndTrimResourceCache();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicEngine
 * JD-Core Version:    0.7.0.1
 */