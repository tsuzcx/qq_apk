package com.tencent.sonic.sdk;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.File;
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
  private final SonicSession.Callback sessionCallback = new SonicEngine.2(this);
  
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
      if (sInstance != null)
      {
        SonicEngine localSonicEngine = sInstance;
        return localSonicEngine;
      }
      throw new IllegalStateException("SonicEngine::createInstance() needs to be called before SonicEngine::getInstance()");
    }
    finally {}
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
    if (this.runtime.shouldLog(6))
    {
      paramString2 = this.runtime;
      paramSonicSessionConfig = new StringBuilder();
      paramSonicSessionConfig.append("internalCreateSession error:sessionId(");
      paramSonicSessionConfig.append(paramString1);
      paramSonicSessionConfig.append(") is running now.");
      paramString2.log("SonicSdk_SonicEngine", 6, paramSonicSessionConfig.toString());
    }
    return null;
  }
  
  public static boolean isGetInstanceAllowed()
  {
    try
    {
      SonicEngine localSonicEngine = sInstance;
      boolean bool;
      if (localSonicEngine != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean isSessionAvailable(String paramString)
  {
    long l = SonicDataHelper.getLastSonicUnavailableTime(paramString);
    if (System.currentTimeMillis() > l) {
      return true;
    }
    if (this.runtime.shouldLog(6))
    {
      SonicRuntime localSonicRuntime = this.runtime;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sessionId(");
      localStringBuilder.append(paramString);
      localStringBuilder.append(") is unavailable and unavailable time until ");
      localStringBuilder.append(l);
      localStringBuilder.append(".");
      localSonicRuntime.log("SonicSdk_SonicEngine", 6, localStringBuilder.toString());
    }
    return false;
  }
  
  private SonicSession lookupSession(SonicSessionConfig paramSonicSessionConfig, String paramString, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramSonicSessionConfig != null))
    {
      SonicSession localSonicSession = (SonicSession)this.preloadSessionPool.get(paramString);
      if (localSonicSession != null) {
        if ((paramSonicSessionConfig.equals(localSonicSession.config)) && ((localSonicSession.config.PRELOAD_SESSION_EXPIRED_TIME <= 0L) || (System.currentTimeMillis() - localSonicSession.createdTime <= localSonicSession.config.PRELOAD_SESSION_EXPIRED_TIME)))
        {
          if (paramBoolean)
          {
            this.preloadSessionPool.remove(paramString);
            return localSonicSession;
          }
        }
        else
        {
          if (this.runtime.shouldLog(6))
          {
            paramSonicSessionConfig = this.runtime;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("lookupSession error:sessionId(");
            localStringBuilder.append(paramString);
            localStringBuilder.append(") is expired.");
            paramSonicSessionConfig.log("SonicSdk_SonicEngine", 6, localStringBuilder.toString());
          }
          this.preloadSessionPool.remove(paramString);
          localSonicSession.destroy();
          return null;
        }
      }
      return localSonicSession;
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
      Object localObject1;
      StringBuilder localStringBuilder;
      if (!this.preloadSessionPool.isEmpty())
      {
        localObject1 = this.runtime;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("cleanCache: remove all preload sessions, size=");
        localStringBuilder.append(this.preloadSessionPool.size());
        localStringBuilder.append(".");
        ((SonicRuntime)localObject1).log("SonicSdk_SonicEngine", 4, localStringBuilder.toString());
        localObject1 = this.preloadSessionPool.values().iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((SonicSession)((Iterator)localObject1).next()).destroy();
        }
        this.preloadSessionPool.clear();
      }
      if (!this.runningSessionHashMap.isEmpty())
      {
        localObject1 = this.runtime;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("cleanCache fail, running session map's size is ");
        localStringBuilder.append(this.runningSessionHashMap.size());
        localStringBuilder.append(".");
        ((SonicRuntime)localObject1).log("SonicSdk_SonicEngine", 6, localStringBuilder.toString());
        return false;
      }
      this.runtime.log("SonicSdk_SonicEngine", 4, "cleanCache: remove all sessions cache.");
      boolean bool = SonicUtils.removeAllSessionCache();
      return bool;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public SonicSession createSession(@NonNull String paramString, @NonNull SonicSessionConfig paramSonicSessionConfig)
  {
    try
    {
      if (isSonicAvailable())
      {
        String str = makeSessionId(paramString, paramSonicSessionConfig.IS_ACCOUNT_RELATED);
        if (!TextUtils.isEmpty(str))
        {
          SonicSession localSonicSession = lookupSession(paramSonicSessionConfig, str, true);
          if (localSonicSession != null) {
            localSonicSession.setIsPreload(paramString);
          } else if (isSessionAvailable(str)) {
            localSonicSession = internalCreateSession(str, paramString, paramSonicSessionConfig);
          }
          return localSonicSession;
        }
      }
      else
      {
        this.runtime.log("SonicSdk_SonicEngine", 6, "createSession fail for sonic service is unavailable!");
      }
      return null;
    }
    finally {}
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
      SonicDBHelper localSonicDBHelper = SonicDBHelper.createInstance(getRuntime().getContext());
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        getRuntime().postTaskToSessionThread(new SonicEngine.1(this, localSonicDBHelper));
        return;
      }
      localSonicDBHelper.getWritableDatabase();
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initSonicDB getWritableDatabase encounter error.");
      localStringBuilder.append(localThrowable.getMessage());
      SonicUtils.log("SonicSdk_SonicEngine", 6, localStringBuilder.toString());
    }
  }
  
  public boolean isSonicAvailable()
  {
    return SonicDBHelper.getInstance().isUpgrading() ^ true;
  }
  
  public boolean preCreateSession(@NonNull String paramString, @NonNull SonicSessionConfig paramSonicSessionConfig)
  {
    try
    {
      if (isSonicAvailable())
      {
        String str = makeSessionId(paramString, paramSonicSessionConfig.IS_ACCOUNT_RELATED);
        if (!TextUtils.isEmpty(str))
        {
          if (lookupSession(paramSonicSessionConfig, str, false) != null)
          {
            paramString = this.runtime;
            paramSonicSessionConfig = new StringBuilder();
            paramSonicSessionConfig.append("preCreateSession：sessionId(");
            paramSonicSessionConfig.append(str);
            paramSonicSessionConfig.append(") is already in preload pool.");
            paramString.log("SonicSdk_SonicEngine", 6, paramSonicSessionConfig.toString());
            return false;
          }
          if (this.preloadSessionPool.size() < this.config.MAX_PRELOAD_SESSION_COUNT)
          {
            if ((isSessionAvailable(str)) && (this.runtime.isNetworkValid()))
            {
              paramString = internalCreateSession(str, paramString, paramSonicSessionConfig);
              if (paramString != null)
              {
                this.preloadSessionPool.put(str, paramString);
                return true;
              }
            }
          }
          else
          {
            paramString = this.runtime;
            paramSonicSessionConfig = new StringBuilder();
            paramSonicSessionConfig.append("create id(");
            paramSonicSessionConfig.append(str);
            paramSonicSessionConfig.append(") fail for preload size is bigger than ");
            paramSonicSessionConfig.append(this.config.MAX_PRELOAD_SESSION_COUNT);
            paramSonicSessionConfig.append(".");
            paramString.log("SonicSdk_SonicEngine", 6, paramSonicSessionConfig.toString());
          }
        }
      }
      else
      {
        this.runtime.log("SonicSdk_SonicEngine", 6, "preCreateSession fail for sonic service is unavailable!");
      }
      return false;
    }
    finally {}
  }
  
  public boolean preCreateSession(@NonNull String paramString, @NonNull SonicSessionConfig paramSonicSessionConfig, long paramLong, int paramInt)
  {
    try
    {
      if (isSonicAvailable())
      {
        String str = makeSessionId(paramString, paramSonicSessionConfig.IS_ACCOUNT_RELATED);
        if (new File(SonicFileUtils.getSonicHtmlPath(str)).exists())
        {
          long l = SonicDataHelper.getTemplateUpdateTime(str);
          if (l > paramLong) {
            return false;
          }
          bool = preCreateSession(paramString, paramSonicSessionConfig);
          return bool;
        }
        if (paramInt == 0) {
          return false;
        }
        boolean bool = preCreateSession(paramString, paramSonicSessionConfig);
        return bool;
      }
      this.runtime.log("SonicSdk_SonicEngine", 6, "preCreateSession fail for sonic service is unavailable!");
      return false;
    }
    finally {}
  }
  
  public void removeExpiredSessionCache(@NonNull Map<String, Long> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      long l1 = ((Long)paramMap.get(str)).longValue();
      long l2 = SonicDataHelper.getTemplateUpdateTime(str);
      if (SonicUtils.shouldLog(3))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeExpiredSessionCache sessionId(");
        localStringBuilder.append(str);
        localStringBuilder.append(") newTemplateUpdateTime = ");
        localStringBuilder.append(l1);
        localStringBuilder.append(", curTemplateUpdateTime = ");
        localStringBuilder.append(l2);
        SonicUtils.log("SonicSdk_SonicEngine", 3, localStringBuilder.toString());
      }
      if ((0L != l2) && (l2 < l1)) {
        removeSessionCache(str);
      }
    }
  }
  
  public boolean removeSessionCache(@NonNull String paramString)
  {
    try
    {
      Object localObject = (SonicSession)this.preloadSessionPool.get(paramString);
      if (localObject != null)
      {
        ((SonicSession)localObject).destroy();
        this.preloadSessionPool.remove(paramString);
        localObject = this.runtime;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sessionId(");
        localStringBuilder.append(paramString);
        localStringBuilder.append(") removeSessionCache: remove preload session.");
        ((SonicRuntime)localObject).log("SonicSdk_SonicEngine", 4, localStringBuilder.toString());
      }
      if (!this.runningSessionHashMap.containsKey(paramString))
      {
        localObject = this.runtime;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sessionId(");
        localStringBuilder.append(paramString);
        localStringBuilder.append(") removeSessionCache success.");
        ((SonicRuntime)localObject).log("SonicSdk_SonicEngine", 4, localStringBuilder.toString());
        SonicUtils.removeSessionCache(paramString);
        return true;
      }
      localObject = this.runtime;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sessionId(");
      localStringBuilder.append(paramString);
      localStringBuilder.append(") removeSessionCache fail: session is running.");
      ((SonicRuntime)localObject).log("SonicSdk_SonicEngine", 6, localStringBuilder.toString());
      return false;
    }
    finally {}
  }
  
  public void trimSonicCache()
  {
    SonicFileUtils.checkAndTrimCache();
    SonicFileUtils.checkAndTrimResourceCache();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicEngine
 * JD-Core Version:    0.7.0.1
 */