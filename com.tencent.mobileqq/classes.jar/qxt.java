import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyEntityManagerFactory;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskLocalRepo.getEntityManagerFactory.1.1;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskLocalRepo.loadFromDB.1;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskLocalRepo.saveToDB.1;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskLocalRepo.sp.2;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskLocalRepo.taskTimeCache.2;
import com.tencent.mobileqq.app.ThreadManager;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTaskLocalRepo;", "", "()V", "value", "", "completedTaskCountToday", "getCompletedTaskCountToday", "()I", "setCompletedTaskCountToday", "(I)V", "Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask;", "currentTask", "getCurrentTask", "()Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask;", "setCurrentTask", "(Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask;)V", "entityManagerFactory", "Lcom/tencent/mobileqq/persistence/EntityManagerFactory;", "globalTimeInMs", "getGlobalTimeInMs", "setGlobalTimeInMs", "lastTask", "getLastTask", "setLastTask", "", "lastUpdateTimestamp", "getLastUpdateTimestamp", "()J", "setLastUpdateTimestamp", "(J)V", "sp", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getSp", "()Landroid/content/SharedPreferences;", "sp$delegate", "Lkotlin/Lazy;", "taskTimeCache", "Landroid/util/LruCache;", "", "getTaskTimeCache", "()Landroid/util/LruCache;", "taskTimeCache$delegate", "addCached", "", "rowKey", "addCachedInternal", "getEntityManagerFactory", "init", "isCached", "", "loadFromDB", "saveToDB", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qxt
{
  private static volatile qxt jdField_a_of_type_Qxt;
  public static final qxu a;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)RIJRewardTaskLocalRepo.taskTimeCache.2.INSTANCE);
  private final Lazy b = LazyKt.lazy((Function0)RIJRewardTaskLocalRepo.sp.2.INSTANCE);
  
  static
  {
    jdField_a_of_type_Qxu = new qxu(null);
  }
  
  private final long a()
  {
    return a().getLong(qzl.a("RIJ_REWARD_TASK_KEY_KEY_LAST_UPDATE_TS"), 0L);
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
    String str1 = pay.a();
    EntityManagerFactory localEntityManagerFactory;
    if (str1 != null) {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
          break label74;
        }
        localEntityManagerFactory = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
        if (localEntityManagerFactory != null) {
          break label54;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyEntityManagerFactory");
      }
      finally {}
    } else {
      throw ((Throwable)new IllegalStateException("Can not create a entity factory, the account is null."));
    }
    label54:
    if (!TextUtils.equals((CharSequence)((ReadInJoyEntityManagerFactory)localEntityManagerFactory).name, (CharSequence)str2))
    {
      label74:
      localObject = new ReadInJoyEntityManagerFactory(str2);
      ThreadManager.excute((Runnable)new RIJRewardTaskLocalRepo.getEntityManagerFactory.1.1((ReadInJoyEntityManagerFactory)localObject), 16, null, false);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = ((EntityManagerFactory)localObject);
    }
    Object localObject = Unit.INSTANCE;
    localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return localObject;
  }
  
  private final void a(long paramLong)
  {
    a().edit().putLong(qzl.a("RIJ_REWARD_TASK_KEY_KEY_LAST_UPDATE_TS"), paramLong).apply();
  }
  
  @JvmStatic
  @NotNull
  public static final qxt b()
  {
    return jdField_a_of_type_Qxu.a();
  }
  
  private final void b()
  {
    ThreadManager.excute((Runnable)new RIJRewardTaskLocalRepo.loadFromDB.1(this), 32, null, true);
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
    if (!qzm.a(a(), l)) {
      a(0);
    }
    return a().getInt(qzl.a("RIJ_REWARD_TASK_KEY_KEY_TASK_COMPLETED_COUNT"), 0);
  }
  
  @Nullable
  public final RIJRewardTask a()
  {
    return qzl.a("RIJ_REWARD_TASK_KEY_KEY_CURRENT_TASK");
  }
  
  public final void a()
  {
    b();
  }
  
  public final void a(int paramInt)
  {
    a().edit().putInt(qzl.a("RIJ_REWARD_TASK_KEY_KEY_TASK_COMPLETED_COUNT"), paramInt).apply();
  }
  
  public final void a(@Nullable RIJRewardTask paramRIJRewardTask)
  {
    qzl.a("RIJ_REWARD_TASK_KEY_KEY_CURRENT_TASK", paramRIJRewardTask);
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
  
  public final int b()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (!qzm.a(a(), l)) {
      b(0);
    }
    return a().getInt(qzl.a("RIJ_REWARD_TASK_KEY_KEY_TASK_PROGRESS_IN_MS"), 0);
  }
  
  @Nullable
  public final RIJRewardTask b()
  {
    return qzl.a("RIJ_REWARD_TASK_KEY_KEY_LAST_TASK");
  }
  
  public final void b(int paramInt)
  {
    a(NetConnInfoCenter.getServerTimeMillis());
    a().edit().putInt(qzl.a("RIJ_REWARD_TASK_KEY_KEY_TASK_PROGRESS_IN_MS"), paramInt).apply();
  }
  
  public final void b(@Nullable RIJRewardTask paramRIJRewardTask)
  {
    qzl.a("RIJ_REWARD_TASK_KEY_KEY_LAST_TASK", paramRIJRewardTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qxt
 * JD-Core Version:    0.7.0.1
 */