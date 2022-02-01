package com.tencent.mobileqq.kandian.base.video.player.pool;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.video.player.LitePlayer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/pool/PlayerPool;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "CONFIG_ID", "", "ENABLE", "", "getENABLE", "()Z", "setENABLE", "(Z)V", "RECYCLE_CACHE_SIZE", "getRECYCLE_CACHE_SIZE", "()I", "setRECYCLE_CACHE_SIZE", "(I)V", "RECYCLE_POOL_SIZE", "getRECYCLE_POOL_SIZE", "setRECYCLE_POOL_SIZE", "REUSE_INTERVAL", "getREUSE_INTERVAL", "setREUSE_INTERVAL", "TAG", "", "pool", "", "Landroid/app/Activity;", "", "Lcom/tencent/mobileqq/kandian/base/video/player/pool/PlayerPool$PlayerCache;", "getCacheList", "activity", "getClassName", "obj", "", "getPlayerCache", "getPlayerName", "player", "isActivityDestroyed", "obtain", "T", "Lcom/tencent/mobileqq/kandian/base/video/player/LitePlayer;", "failback", "Lkotlin/Function1;", "", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)Lcom/tencent/mobileqq/kandian/base/video/player/LitePlayer;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "recyclePlayer", "(Landroid/app/Activity;Lcom/tencent/mobileqq/kandian/base/video/player/LitePlayer;)Z", "releaseAllCache", "releaseCache", "trimCacheList", "cacheList", "PlayerCache", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PlayerPool
  implements Application.ActivityLifecycleCallbacks
{
  public static final PlayerPool a;
  private static final Map<Activity, Set<PlayerPool.PlayerCache>> b;
  private static boolean c;
  private static int d;
  private static int e;
  private static int f;
  
  static
  {
    Object localObject = new PlayerPool();
    a = (PlayerPool)localObject;
    b = (Map)new LinkedHashMap();
    d = 3;
    e = 5;
    f = 500;
    BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject);
    localObject = Aladdin.getConfig(503);
    c = ((AladdinConfig)localObject).getBooleanFromString("player_pool_enable", c);
    e = ((AladdinConfig)localObject).getIntegerFromString("pool_size", e);
    d = ((AladdinConfig)localObject).getIntegerFromString("cache_size", d);
    f = ((AladdinConfig)localObject).getIntegerFromString("reuse_interval", f);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("config: enable=");
      ((StringBuilder)localObject).append(c);
      ((StringBuilder)localObject).append(", poolSize=");
      ((StringBuilder)localObject).append(e);
      ((StringBuilder)localObject).append(", cacheSize=");
      ((StringBuilder)localObject).append(d);
      ((StringBuilder)localObject).append(",reuseInterval=");
      ((StringBuilder)localObject).append(f);
      QLog.d("LitePlayer-PlayerPool", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private final String a(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject.getClass().getSimpleName());
    localStringBuilder.append('@');
    localStringBuilder.append(paramObject.hashCode());
    return localStringBuilder.toString();
  }
  
  private final void a(Activity paramActivity, Set<PlayerPool.PlayerCache> paramSet)
  {
    Object localObject = new ArrayList();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      PlayerPool.PlayerCache localPlayerCache = (PlayerPool.PlayerCache)localIterator.next();
      if (!localPlayerCache.a()) {
        ((ArrayList)localObject).add(localPlayerCache);
      }
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramSet.remove((PlayerPool.PlayerCache)((Iterator)localObject).next());
    }
    if (paramSet.size() == 0) {
      b.remove(paramActivity);
    }
  }
  
  private final String b(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject.getClass().getSimpleName());
    localStringBuilder.append('<');
    localStringBuilder.append(Integer.toHexString(paramObject.hashCode()));
    localStringBuilder.append('>');
    return localStringBuilder.toString();
  }
  
  private final boolean b(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramActivity.isDestroyed();
    }
    return paramActivity.isFinishing();
  }
  
  private final Set<PlayerPool.PlayerCache> c(Activity paramActivity)
  {
    Object localObject2 = (Set)b.get(paramActivity);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = (Set)new LinkedHashSet();
      b.put(paramActivity, localObject1);
    }
    if ((b(paramActivity)) && (((Set)localObject1).size() == 0))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getCacheList: finished activity=");
        ((StringBuilder)localObject2).append(a(paramActivity));
        QLog.d("LitePlayer-PlayerPool", 2, ((StringBuilder)localObject2).toString());
      }
      b.remove(paramActivity);
    }
    return localObject1;
  }
  
  private final PlayerPool.PlayerCache d(Activity paramActivity)
  {
    Set localSet = c(paramActivity);
    a(paramActivity, localSet);
    Object localObject2 = (PlayerPool.PlayerCache)null;
    Iterator localIterator = localSet.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (PlayerPool.PlayerCache)localIterator.next();
    } while (!((PlayerPool.PlayerCache)localObject1).b());
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getPlayerCache: activity=");
      ((StringBuilder)localObject2).append(a(paramActivity));
      ((StringBuilder)localObject2).append(", size=");
      ((StringBuilder)localObject2).append(localSet.size());
      ((StringBuilder)localObject2).append(", candidate=");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("LitePlayer-PlayerPool", 2, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 != null) {
      localSet.remove(localObject1);
    }
    if (localObject1 != null) {
      ((PlayerPool.PlayerCache)localObject1).f();
    }
    return localObject1;
  }
  
  public final int a()
  {
    return f;
  }
  
  @NotNull
  public final <T extends LitePlayer> T a(@NotNull Activity paramActivity, @NotNull Function1<? super Unit, ? extends T> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "failback");
    if (!c) {
      return (LitePlayer)paramFunction1.invoke(Unit.INSTANCE);
    }
    paramActivity = d(paramActivity);
    if (paramActivity != null) {
      paramActivity = paramActivity.c();
    } else {
      paramActivity = null;
    }
    Activity localActivity = paramActivity;
    if (!(paramActivity instanceof LitePlayer)) {
      localActivity = null;
    }
    if (localActivity != null) {
      return localActivity;
    }
    return (LitePlayer)paramFunction1.invoke(Unit.INSTANCE);
  }
  
  public final void a(@Nullable Activity paramActivity)
  {
    if (paramActivity != null)
    {
      Set localSet = a.c(paramActivity);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("releaseCache: activity=");
        ((StringBuilder)localObject).append(a.a(paramActivity));
        ((StringBuilder)localObject).append(", size=");
        ((StringBuilder)localObject).append(localSet.size());
        QLog.d("LitePlayer-PlayerPool", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = localSet.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((PlayerPool.PlayerCache)((Iterator)localObject).next()).d();
      }
      localSet.clear();
      b.remove(paramActivity);
    }
  }
  
  public final <T extends LitePlayer> boolean a(@NotNull Activity paramActivity, @NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramT, "player");
    if (!c) {
      return false;
    }
    Object localObject1 = new PlayerPool.PlayerCache(paramT);
    if (b(paramActivity))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("recyclePlayer: finished activity=");
        ((StringBuilder)localObject2).append(a(paramActivity));
        ((StringBuilder)localObject2).append(", player=");
        ((StringBuilder)localObject2).append(b(paramT));
        ((StringBuilder)localObject2).append('-');
        ((StringBuilder)localObject2).append(paramT.l());
        QLog.d("LitePlayer-PlayerPool", 2, ((StringBuilder)localObject2).toString());
      }
      ((PlayerPool.PlayerCache)localObject1).d();
      b.remove(paramActivity);
      return false;
    }
    Object localObject2 = c(paramActivity);
    if (((Set)localObject2).size() >= d)
    {
      if (QLog.isColorLevel())
      {
        paramT = new StringBuilder();
        paramT.append("recyclePlayer: overesize activity=");
        paramT.append(a(paramActivity));
        paramT.append(", size=");
        paramT.append(((Set)localObject2).size());
        paramT.append(", limit=");
        paramT.append(d);
        QLog.d("LitePlayer-PlayerPool", 2, paramT.toString());
      }
      ((PlayerPool.PlayerCache)localObject1).d();
      return false;
    }
    if (((PlayerPool.PlayerCache)localObject1).a())
    {
      ((PlayerPool.PlayerCache)localObject1).e();
      ((Set)localObject2).add(localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("recyclePlayer: activity=");
        ((StringBuilder)localObject1).append(a.a(paramActivity));
        ((StringBuilder)localObject1).append(", player=");
        ((StringBuilder)localObject1).append(a.b(paramT));
        ((StringBuilder)localObject1).append('-');
        ((StringBuilder)localObject1).append(paramT.l());
        ((StringBuilder)localObject1).append(", size=");
        ((StringBuilder)localObject1).append(((Set)localObject2).size());
        QLog.d("LitePlayer-PlayerPool", 2, ((StringBuilder)localObject1).toString());
      }
      return true;
    }
    ((PlayerPool.PlayerCache)localObject1).d();
    return false;
  }
  
  public final void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LitePlayer-PlayerPool", 2, "releaseAllCache: ");
    }
    Iterator localIterator = new ArrayList((Collection)b.keySet()).iterator();
    while (localIterator.hasNext()) {
      a((Activity)localIterator.next());
    }
    b.clear();
  }
  
  public void onActivityCreated(@Nullable Activity paramActivity, @Nullable Bundle paramBundle) {}
  
  public void onActivityDestroyed(@Nullable Activity paramActivity)
  {
    if (!c) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityDestroyed: pool size=");
      localStringBuilder.append(b.size());
      QLog.d("LitePlayer-PlayerPool", 2, localStringBuilder.toString());
    }
    a(paramActivity);
  }
  
  public void onActivityPaused(@Nullable Activity paramActivity) {}
  
  public void onActivityResumed(@Nullable Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(@Nullable Activity paramActivity, @Nullable Bundle paramBundle) {}
  
  public void onActivityStarted(@Nullable Activity paramActivity) {}
  
  public void onActivityStopped(@Nullable Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.pool.PlayerPool
 * JD-Core Version:    0.7.0.1
 */