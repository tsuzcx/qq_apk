package com.tencent.mobileqq.cmshow.engine.resource;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloPreDownloadData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.brickengine.resource.BKResourceManager;
import com.tencent.mobileqq.cmshow.brickengine.resource.util.BKGetResPathUtil;
import com.tencent.mobileqq.cmshow.crossengine.resource.CEResourceManager;
import com.tencent.mobileqq.cmshow.crossengine.resource.util.CEGetResPathUtil;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.EngineType;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/resource/ApolloResManagerFacade;", "", "()V", "TAG", "", "mAppRuntime", "Lmqq/app/AppRuntime;", "mLock", "Ljava/util/concurrent/locks/ReentrantLock;", "mResourceManagerMap", "", "Lcom/tencent/mobileqq/cmshow/engine/EngineType;", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;", "checkBasicActionExist", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "checkCompat2DActionRsc", "checkUpdateActionRes", "serverId", "", "serverVersion", "", "localArray", "Lorg/json/JSONArray;", "checkUserDress", "Lcom/tencent/common/app/AppInterface;", "uin", "from", "createResManager", "engineType", "getApolloResManager", "getApolloResManagerForScene", "scene", "Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;", "getRoleConfigJsonFile", "Ljava/io/File;", "roleId", "handlePushUpdateBaseRes", "appId", "newVersion", "name", "handlePushUpdateDressRes", "handlePushUpdatePanelJsonCfg", "handlePushUpdateRoleRes", "onCreate", "appRuntime", "onDestroy", "registerResourceManager", "resManager", "unRegisterResourceManager", "updateAndDownloadPreRes", "preDownloadDataMapNew", "Lcom/tencent/mobileqq/apollo/model/ApolloPreDownloadData;", "updateUserDress", "apolloBaseInfos", "", "Lcom/tencent/mobileqq/apollo/model/ApolloBaseInfo;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloResManagerFacade
{
  public static final ApolloResManagerFacade a = new ApolloResManagerFacade();
  private static final Map<EngineType, IApolloResManager> b = (Map)new ConcurrentHashMap();
  private static AppRuntime c;
  private static final ReentrantLock d = new ReentrantLock();
  
  private final IApolloResManager b(EngineType paramEngineType)
  {
    if (paramEngineType == EngineType.CE) {
      return (IApolloResManager)new CEResourceManager();
    }
    return (IApolloResManager)new BKResourceManager();
  }
  
  @NotNull
  public final IApolloResManager a(@NotNull EngineType paramEngineType)
  {
    Intrinsics.checkParameterIsNotNull(paramEngineType, "engineType");
    IApolloResManager localIApolloResManager = (IApolloResManager)b.get(paramEngineType);
    Object localObject = localIApolloResManager;
    if (localIApolloResManager == null)
    {
      Lock localLock = (Lock)d;
      localLock.lock();
      try
      {
        localIApolloResManager = (IApolloResManager)b.get(paramEngineType);
        localObject = localIApolloResManager;
        if (localIApolloResManager == null)
        {
          localIApolloResManager = a.b(paramEngineType);
          localObject = b;
          if (localIApolloResManager == null) {
            Intrinsics.throwNpe();
          }
          ((Map)localObject).put(paramEngineType, localIApolloResManager);
          localObject = localIApolloResManager;
          if (c != null)
          {
            if (localIApolloResManager == null) {
              Intrinsics.throwNpe();
            }
            localIApolloResManager.a(c);
            localObject = localIApolloResManager;
          }
        }
        paramEngineType = Unit.INSTANCE;
      }
      finally
      {
        localLock.unlock();
      }
    }
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return localObject;
  }
  
  @NotNull
  public final IApolloResManager a(@NotNull Scene paramScene)
  {
    Intrinsics.checkParameterIsNotNull(paramScene, "scene");
    return a(CMShowPlatform.a.c(paramScene));
  }
  
  @Nullable
  public final File a(int paramInt)
  {
    File localFile2 = new File(BKGetResPathUtil.a(1, paramInt), "config.json");
    File localFile1 = localFile2;
    if (!localFile2.exists()) {
      localFile1 = new File(CEGetResPathUtil.a(1, paramInt), "config.json");
    }
    return localFile1;
  }
  
  public final void a()
  {
    Iterator localIterator = b.values().iterator();
    while (localIterator.hasNext()) {
      ((IApolloResManager)localIterator.next()).d();
    }
  }
  
  public final void a(int paramInt1, int paramInt2, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Iterator localIterator = b.values().iterator();
    while (localIterator.hasNext()) {
      ((IApolloResManager)localIterator.next()).a(paramInt1, paramInt2, paramString);
    }
  }
  
  public final void a(int paramInt, long paramLong, @NotNull JSONArray paramJSONArray)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONArray, "localArray");
    Iterator localIterator = b.values().iterator();
    while (localIterator.hasNext()) {
      ((IApolloResManager)localIterator.next()).a(paramInt, paramLong, paramJSONArray);
    }
  }
  
  public final void a(@Nullable AppInterface paramAppInterface, @Nullable String paramString1, @Nullable String paramString2)
  {
    Iterator localIterator = b.values().iterator();
    while (localIterator.hasNext()) {
      ((IApolloResManager)localIterator.next()).a(paramAppInterface, paramString1, paramString2);
    }
  }
  
  public final void a(@NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Iterator localIterator = b.values().iterator();
    while (localIterator.hasNext()) {
      ((IApolloResManager)localIterator.next()).a(paramQQAppInterface);
    }
  }
  
  public final void a(@NotNull EngineType paramEngineType, @NotNull IApolloResManager paramIApolloResManager)
  {
    Intrinsics.checkParameterIsNotNull(paramEngineType, "engineType");
    Intrinsics.checkParameterIsNotNull(paramIApolloResManager, "resManager");
    Lock localLock = (Lock)d;
    localLock.lock();
    try
    {
      b.put(paramEngineType, paramIApolloResManager);
      paramIApolloResManager = Unit.INSTANCE;
      localLock.unlock();
      paramIApolloResManager = new StringBuilder();
      paramIApolloResManager.append("[registerResourceManager] engineType=");
      paramIApolloResManager.append(paramEngineType);
      QLog.d("ApolloResManagerFacadeImpl", 1, paramIApolloResManager.toString());
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public final void a(@Nullable List<ApolloBaseInfo> paramList)
  {
    Iterator localIterator = b.values().iterator();
    while (localIterator.hasNext()) {
      ((IApolloResManager)localIterator.next()).a(paramList);
    }
  }
  
  public final void a(@Nullable Map<String, ApolloPreDownloadData> paramMap)
  {
    Iterator localIterator = b.values().iterator();
    while (localIterator.hasNext()) {
      ((IApolloResManager)localIterator.next()).a(paramMap);
    }
  }
  
  public final void a(@Nullable AppRuntime paramAppRuntime)
  {
    if (CMResUtil.c()) {
      a(EngineType.BK, (IApolloResManager)new BKResourceManager());
    }
    if (CMResUtil.b()) {
      a(EngineType.CE, (IApolloResManager)new CEResourceManager());
    }
    Iterator localIterator = b.values().iterator();
    while (localIterator.hasNext()) {
      ((IApolloResManager)localIterator.next()).a(paramAppRuntime);
    }
    c = paramAppRuntime;
  }
  
  public final void b()
  {
    b.clear();
  }
  
  public final void b(int paramInt1, int paramInt2, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Iterator localIterator = b.values().iterator();
    while (localIterator.hasNext()) {
      ((IApolloResManager)localIterator.next()).b(paramInt1, paramInt2, paramString);
    }
  }
  
  public final void c(int paramInt1, int paramInt2, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Iterator localIterator = b.values().iterator();
    while (localIterator.hasNext()) {
      ((IApolloResManager)localIterator.next()).c(paramInt1, paramInt2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade
 * JD-Core Version:    0.7.0.1
 */