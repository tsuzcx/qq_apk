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
  public static final RIJRewardTaskLocalRepo.Companion a;
  private static volatile RIJRewardTaskLocalRepo jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskLocalRepo;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)RIJRewardTaskLocalRepo.taskTimeCache.2.INSTANCE);
  private final Lazy b = LazyKt.lazy((Function0)RIJRewardTaskLocalRepo.sp.2.INSTANCE);
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskLocalRepo$Companion = new RIJRewardTaskLocalRepo.Companion(null);
  }
  
  private final long a()
  {
    return a().getLong(RIJRewardTaskPrefHelper.a("RIJ_REWARD_TASK_KEY_KEY_LAST_UPDATE_TS"), 0L);
  }
  
  private final SharedPreferences a()
  {
    return (SharedPreferences)this.b.getValue();
  }
  
  private final LruCache<String, String> a()
  {
    return (LruCache)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  private final EntityManagerFactory a()
  {
    Object localObject1 = RIJQQAppInterfaceUtil.a();
    if (localObject1 != null) {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory != null)
        {
          EntityManagerFactory localEntityManagerFactory = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
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
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = ((EntityManagerFactory)localObject1);
        label94:
        localObject1 = Unit.INSTANCE;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        return localObject1;
      }
      finally {}
    }
    throw ((Throwable)new IllegalStateException("Can not create a entity factory, the account is null."));
  }
  
  private final void a(long paramLong)
  {
    a().edit().putLong(RIJRewardTaskPrefHelper.a("RIJ_REWARD_TASK_KEY_KEY_LAST_UPDATE_TS"), paramLong).apply();
  }
  
  private final long b()
  {
    return a().getLong(RIJRewardTaskPrefHelper.a("RIJ_REWARD_TASK_KEY_KEY_LAST_UPDATE_LEVEL_TS"), 0L);
  }
  
  @JvmStatic
  @NotNull
  public static final RIJRewardTaskLocalRepo b()
  {
    return jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskLocalRepo$Companion.a();
  }
  
  private final void b()
  {
    ThreadManager.excute((Runnable)new RIJRewardTaskLocalRepo.loadFromDB.1(this), 32, null, true);
  }
  
  private final void b(long paramLong)
  {
    a().edit().putLong(RIJRewardTaskPrefHelper.a("RIJ_REWARD_TASK_KEY_KEY_LAST_UPDATE_LEVEL_TS"), paramLong).apply();
  }
  
  private final void b(String paramString)
  {
    a().put(paramString, paramString);
  }
  
  private final void c(String paramString)
  {
    ThreadManager.excute((Runnable)new RIJRewardTaskLocalRepo.saveToDB.1(this, paramString), 32, null, true);
  }
  
  public final int a()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (!Utils.a(a(), l)) {
      a(0);
    }
    return a().getInt(RIJRewardTaskPrefHelper.a("RIJ_REWARD_TASK_KEY_KEY_TASK_COMPLETED_COUNT"), 0);
  }
  
  public final int a(boolean paramBoolean)
  {
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    if (paramBoolean)
    {
      long l1;
      if (paramBoolean) {
        l1 = a();
      } else {
        l1 = b();
      }
      if (!Utils.a(l1, l2)) {
        a(0, paramBoolean);
      }
    }
    SharedPreferences localSharedPreferences = a();
    String str;
    if (paramBoolean) {
      str = "RIJ_REWARD_TASK_KEY_KEY_TASK_PROGRESS_IN_MS";
    } else {
      str = "RIJ_REWARD_TASK_KEY_KEY_TASK_LEVEL_PROGRESS_IN_MS";
    }
    return localSharedPreferences.getInt(RIJRewardTaskPrefHelper.a(str), 0);
  }
  
  @Nullable
  public final RIJRewardTask a()
  {
    return RIJRewardTaskPrefHelper.a("RIJ_REWARD_TASK_KEY_KEY_CURRENT_TASK");
  }
  
  public final void a()
  {
    b();
  }
  
  public final void a(int paramInt)
  {
    a().edit().putInt(RIJRewardTaskPrefHelper.a("RIJ_REWARD_TASK_KEY_KEY_TASK_COMPLETED_COUNT"), paramInt).apply();
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
    a().edit().putInt(RIJRewardTaskPrefHelper.a(str), paramInt).apply();
  }
  
  public final void a(@Nullable RIJRewardTask paramRIJRewardTask)
  {
    RIJRewardTaskPrefHelper.a("RIJ_REWARD_TASK_KEY_KEY_CURRENT_TASK", paramRIJRewardTask);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    b(paramString);
    c(paramString);
  }
  
  public final boolean a(@Nullable String paramString)
  {
    return a().get(paramString) != null;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskLocalRepo
 * JD-Core Version:    0.7.0.1
 */