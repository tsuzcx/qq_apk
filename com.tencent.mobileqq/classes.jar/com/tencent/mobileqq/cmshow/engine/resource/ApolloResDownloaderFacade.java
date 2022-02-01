package com.tencent.mobileqq.cmshow.engine.resource;

import android.os.Bundle;
import com.tencent.mobileqq.cmshow.brickengine.resource.downloader.BKResourceDownloader;
import com.tencent.mobileqq.cmshow.crossengine.resource.downloader.CEResourceDownloader;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.EngineType;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.vip.DownloadListener;
import java.util.Collection;
import java.util.Iterator;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/resource/ApolloResDownloaderFacade;", "", "()V", "TAG", "", "mLock", "Ljava/util/concurrent/locks/ReentrantLock;", "mResourceDownloaderMap", "", "Lcom/tencent/mobileqq/cmshow/engine/EngineType;", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResDownloader;", "checkDownloadFaceData", "", "app", "Lmqq/app/AppRuntime;", "url", "faceDataDownloadListener", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResDownloader$OnFaceDataDownloadListener;", "createResDownloader", "engineType", "downLoadCmShowRes", "path", "params", "Landroid/os/Bundle;", "listener", "Lcom/tencent/mobileqq/vip/DownloadListener;", "downloadApolloResOrder", "uin", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResDownloader$OnApolloDownLoadListener;", "outRoleId", "", "outDressIds", "", "actionId", "actionType", "forceUpdate", "", "getApolloResDownloader", "getApolloResDownloaderForScene", "scene", "Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;", "registerResourceDownloader", "resDownloader", "unRegisterResourceDownloader", "ApolloMergeDownLoadListener", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloResDownloaderFacade
{
  public static final ApolloResDownloaderFacade a = new ApolloResDownloaderFacade();
  private static final Map<EngineType, IApolloResDownloader> b = (Map)new ConcurrentHashMap();
  private static final ReentrantLock c = new ReentrantLock();
  
  private final IApolloResDownloader b(EngineType paramEngineType)
  {
    if (paramEngineType == EngineType.CE) {
      return (IApolloResDownloader)new CEResourceDownloader();
    }
    return (IApolloResDownloader)new BKResourceDownloader();
  }
  
  @NotNull
  public final IApolloResDownloader a(@NotNull EngineType paramEngineType)
  {
    Intrinsics.checkParameterIsNotNull(paramEngineType, "engineType");
    Object localObject2 = (IApolloResDownloader)b.get(paramEngineType);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      Lock localLock = (Lock)c;
      localLock.lock();
      try
      {
        localObject2 = (IApolloResDownloader)b.get(paramEngineType);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = a.b(paramEngineType);
          localObject2 = b;
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          ((Map)localObject2).put(paramEngineType, localObject1);
        }
        paramEngineType = Unit.INSTANCE;
      }
      finally
      {
        localLock.unlock();
      }
    }
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    return localObject1;
  }
  
  @NotNull
  public final IApolloResDownloader a(@NotNull Scene paramScene)
  {
    Intrinsics.checkParameterIsNotNull(paramScene, "scene");
    return a(CMShowPlatform.a.c(paramScene));
  }
  
  public final void a(@NotNull EngineType paramEngineType, @NotNull IApolloResDownloader paramIApolloResDownloader)
  {
    Intrinsics.checkParameterIsNotNull(paramEngineType, "engineType");
    Intrinsics.checkParameterIsNotNull(paramIApolloResDownloader, "resDownloader");
    Lock localLock = (Lock)c;
    localLock.lock();
    try
    {
      b.put(paramEngineType, paramIApolloResDownloader);
      paramEngineType = Unit.INSTANCE;
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public final void a(@Nullable AppRuntime paramAppRuntime, @Nullable String paramString, @Nullable IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, int paramInt1, @Nullable int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    paramOnApolloDownLoadListener = new ApolloResDownloaderFacade.ApolloMergeDownLoadListener(b.size(), paramOnApolloDownLoadListener);
    Iterator localIterator = b.values().iterator();
    while (localIterator.hasNext()) {
      ((IApolloResDownloader)localIterator.next()).a(paramAppRuntime, paramString, (IApolloResDownloader.OnApolloDownLoadListener)paramOnApolloDownLoadListener, paramInt1, paramArrayOfInt, paramInt2, paramInt3, paramBoolean);
    }
  }
  
  public final void a(@Nullable AppRuntime paramAppRuntime, @Nullable String paramString, @Nullable IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener)
  {
    Iterator localIterator = b.values().iterator();
    while (localIterator.hasNext()) {
      ((IApolloResDownloader)localIterator.next()).a(paramAppRuntime, paramString, paramOnFaceDataDownloadListener);
    }
  }
  
  public final void a(@Nullable AppRuntime paramAppRuntime, @Nullable String paramString1, @Nullable String paramString2, @Nullable Bundle paramBundle, @Nullable DownloadListener paramDownloadListener)
  {
    Iterator localIterator = b.values().iterator();
    while (localIterator.hasNext()) {
      ((IApolloResDownloader)localIterator.next()).a(paramAppRuntime, paramString1, paramString2, paramBundle, paramDownloadListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.ApolloResDownloaderFacade
 * JD-Core Version:    0.7.0.1
 */