package com.tencent.mobileqq.kandian.biz.reward;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.reward.utils.RIJRewardTaskPrefHelper;
import com.tencent.mobileqq.kandian.biz.reward.utils.Utils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyEntityManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTaskLocalRepo;", "", "()V", "value", "", "completedTaskCountToday", "getCompletedTaskCountToday", "()I", "setCompletedTaskCountToday", "(I)V", "Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTask;", "currentTask", "getCurrentTask", "()Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTask;", "setCurrentTask", "(Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTask;)V", "entityManagerFactory", "Lcom/tencent/mobileqq/persistence/EntityManagerFactory;", "lastTask", "getLastTask", "setLastTask", "", "lastUpdateLevelTimestamp", "getLastUpdateLevelTimestamp", "()J", "setLastUpdateLevelTimestamp", "(J)V", "lastUpdateTimestamp", "getLastUpdateTimestamp", "setLastUpdateTimestamp", "sp", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getSp", "()Landroid/content/SharedPreferences;", "sp$delegate", "Lkotlin/Lazy;", "taskTimeCache", "Landroid/util/LruCache;", "", "getTaskTimeCache", "()Landroid/util/LruCache;", "taskTimeCache$delegate", "addCached", "", "rowKey", "addCachedInternal", "getEntityManagerFactory", "getGlobalTimeInMs", "isCoinTiming", "", "init", "isCached", "loadFromDB", "saveToDB", "setGlobalTimeInMs", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTaskLocalRepo
{
  public static final RIJRewardTaskLocalRepo.Companion a = new RIJRewardTaskLocalRepo.Companion(null);
  private static volatile RIJRewardTaskLocalRepo e;
  private EntityManagerFactory b;
  private final Lazy c = LazyKt.lazy((Function0)RIJRewardTaskLocalRepo.taskTimeCache.2.INSTANCE);
  private final Lazy d = LazyKt.lazy((Function0)RIJRewardTaskLocalRepo.sp.2.INSTANCE);
  
  private final void a(long paramLong)
  {
    h().edit().putLong(RIJRewardTaskPrefHelper.b("RIJ_REWARD_TASK_KEY_KEY_LAST_UPDATE_TS"), paramLong).apply();
  }
  
  private final void b(long paramLong)
  {
    h().edit().putLong(RIJRewardTaskPrefHelper.b("RIJ_REWARD_TASK_KEY_KEY_LAST_UPDATE_LEVEL_TS"), paramLong).apply();
  }
  
  private final void c(String paramString)
  {
    g().put(paramString, paramString);
  }
  
  private final void d(String paramString)
  {
    ThreadManager.excute((Runnable)new RIJRewardTaskLocalRepo.saveToDB.1(this, paramString), 32, null, true);
  }
  
  @JvmStatic
  @NotNull
  public static final RIJRewardTaskLocalRepo f()
  {
    return a.a();
  }
  
  private final LruCache<String, String> g()
  {
    return (LruCache)this.c.getValue();
  }
  
  private final SharedPreferences h()
  {
    return (SharedPreferences)this.d.getValue();
  }
  
  private final long i()
  {
    return h().getLong(RIJRewardTaskPrefHelper.b("RIJ_REWARD_TASK_KEY_KEY_LAST_UPDATE_TS"), 0L);
  }
  
  private final long j()
  {
    return h().getLong(RIJRewardTaskPrefHelper.b("RIJ_REWARD_TASK_KEY_KEY_LAST_UPDATE_LEVEL_TS"), 0L);
  }
  
  private final void k()
  {
    ThreadManager.excute((Runnable)new RIJRewardTaskLocalRepo.loadFromDB.1(this), 32, null, true);
  }
  
  private final EntityManagerFactory l()
  {
    Object localObject1 = RIJQQAppInterfaceUtil.d();
    if (localObject1 != null) {
      try
      {
        if (this.b != null)
        {
          EntityManagerFactory localEntityManagerFactory = this.b;
          if (localEntityManagerFactory != null) {
            if (TextUtils.equals((CharSequence)((ReadInJoyEntityManagerFactory)localEntityManagerFactory).name, (CharSequence)localObject1)) {
              break label94;
            }
          } else {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyEntityManagerFactory");
          }
        }
        localObject1 = new ReadInJoyEntityManagerFactory((String)localObject1);
        ThreadManager.excute((Runnable)new RIJRewardTaskLocalRepo.getEntityManagerFactory.1.1((ReadInJoyEntityManagerFactory)localObject1), 16, null, false);
        this.b = ((EntityManagerFactory)localObject1);
        label94:
        localObject1 = Unit.INSTANCE;
        localObject1 = this.b;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        return localObject1;
      }
      finally {}
    }
    throw ((Throwable)new IllegalStateException("Can not create a entity factory, the account is null."));
  }
  
  public final int a(boolean paramBoolean)
  {
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    if (paramBoolean)
    {
      long l1;
      if (paramBoolean) {
        l1 = i();
      } else {
        l1 = j();
      }
      if (!Utils.a(l1, l2)) {
        a(0, paramBoolean);
      }
    }
    SharedPreferences localSharedPreferences = h();
    String str;
    if (paramBoolean) {
      str = "RIJ_REWARD_TASK_KEY_KEY_TASK_PROGRESS_IN_MS";
    } else {
      str = "RIJ_REWARD_TASK_KEY_KEY_TASK_LEVEL_PROGRESS_IN_MS";
    }
    return localSharedPreferences.getInt(RIJRewardTaskPrefHelper.b(str), 0);
  }
  
  @Nullable
  public final RIJRewardTask a()
  {
    return RIJRewardTaskPrefHelper.a("RIJ_REWARD_TASK_KEY_KEY_CURRENT_TASK");
  }
  
  public final void a(int paramInt)
  {
    h().edit().putInt(RIJRewardTaskPrefHelper.b("RIJ_REWARD_TASK_KEY_KEY_TASK_COMPLETED_COUNT"), paramInt).apply();
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (paramBoolean) {
      a(l);
    } else {
      b(l);
    }
    String str;
    if (paramBoolean) {
      str = "RIJ_REWARD_TASK_KEY_KEY_TASK_PROGRESS_IN_MS";
    } else {
      str = "RIJ_REWARD_TASK_KEY_KEY_TASK_LEVEL_PROGRESS_IN_MS";
    }
    h().edit().putInt(RIJRewardTaskPrefHelper.b(str), paramInt).apply();
  }
  
  public final void a(@Nullable RIJRewardTask paramRIJRewardTask)
  {
    RIJRewardTaskPrefHelper.a("RIJ_REWARD_TASK_KEY_KEY_CURRENT_TASK", paramRIJRewardTask);
  }
  
  public final boolean a(@Nullable String paramString)
  {
    return g().get(paramString) != null;
  }
  
  @Nullable
  public final RIJRewardTask b()
  {
    return RIJRewardTaskPrefHelper.a("RIJ_REWARD_TASK_KEY_KEY_LAST_TASK");
  }
  
  public final void b(@Nullable RIJRewardTask paramRIJRewardTask)
  {
    RIJRewardTaskPrefHelper.a("RIJ_REWARD_TASK_KEY_KEY_LAST_TASK", paramRIJRewardTask);
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    c(paramString);
    d(paramString);
  }
  
  public final int c()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (!Utils.a(i(), l)) {
      a(0);
    }
    return h().getInt(RIJRewardTaskPrefHelper.b("RIJ_REWARD_TASK_KEY_KEY_TASK_COMPLETED_COUNT"), 0);
  }
  
  public final void d()
  {
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskLocalRepo
 * JD-Core Version:    0.7.0.1
 */