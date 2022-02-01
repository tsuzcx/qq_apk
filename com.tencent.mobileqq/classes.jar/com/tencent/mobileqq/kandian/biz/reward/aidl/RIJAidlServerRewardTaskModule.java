package com.tencent.mobileqq.kandian.biz.reward.aidl;

import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTask;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskConfig;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskRemoteRepo.IReportTaskProgressCallback;
import com.tencent.mobileqq.kandian.biz.reward.mvp.RIJRewardTaskTimingModel;
import com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/aidl/RIJAidlServerRewardTaskModule;", "Lcom/tencent/mobileqq/kandian/biz/reward/aidl/IRIJAidlInterfaceForRewardTask$Stub;", "()V", "model", "Lcom/tencent/mobileqq/kandian/biz/reward/mvp/RIJRewardTaskTimingModel;", "getModel", "()Lcom/tencent/mobileqq/kandian/biz/reward/mvp/RIJRewardTaskTimingModel;", "model$delegate", "Lkotlin/Lazy;", "dailyMissionCount", "", "getCurrentTask", "Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTask;", "getLastTask", "getTaskProgress", "hasRead", "", "rowKey", "", "isEnable", "isNowInKanDianTab", "maxTaskTimeForArticleInMs", "maxTaskTimeWhenArticleStationaryInMs", "missionCompletedTimeInMs", "reportTaskCompleted", "", "type", "callback", "Lcom/tencent/mobileqq/kandian/biz/reward/aidl/IReportTaskProgressCallback;", "setCurrentTask", "task", "setLastTask", "setRead", "taskCompletedToday", "updateTaskProgress", "timeInMs", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJAidlServerRewardTaskModule
  extends IRIJAidlInterfaceForRewardTask.Stub
{
  private final Lazy a = LazyKt.lazy((Function0)RIJAidlServerRewardTaskModule.model.2.INSTANCE);
  
  private final RIJRewardTaskTimingModel k()
  {
    return (RIJRewardTaskTimingModel)this.a.getValue();
  }
  
  @Nullable
  public RIJRewardTask a()
  {
    return k().a();
  }
  
  public void a(int paramInt)
  {
    k().a(paramInt, true);
  }
  
  public void a(@Nullable RIJRewardTask paramRIJRewardTask)
  {
    k().a(paramRIJRewardTask);
  }
  
  public void a(@Nullable String paramString, int paramInt, @Nullable IReportTaskProgressCallback paramIReportTaskProgressCallback)
  {
    k().a(paramString, paramInt, (RIJRewardTaskRemoteRepo.IReportTaskProgressCallback)new RIJAidlServerRewardTaskModule.reportTaskCompleted.1(paramIReportTaskProgressCallback));
  }
  
  public boolean a(@Nullable String paramString)
  {
    if (paramString != null) {
      return k().a(paramString);
    }
    return false;
  }
  
  @Nullable
  public RIJRewardTask b()
  {
    return k().b();
  }
  
  public void b(@Nullable RIJRewardTask paramRIJRewardTask)
  {
    k().b(paramRIJRewardTask);
  }
  
  public void b(@Nullable String paramString)
  {
    if (paramString != null) {
      k().b(paramString);
    }
  }
  
  public int c()
  {
    return k().c();
  }
  
  public int d()
  {
    return k().a(true);
  }
  
  public boolean e()
  {
    return RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab();
  }
  
  public boolean f()
  {
    return RIJRewardTaskConfig.a();
  }
  
  public int g()
  {
    return RIJRewardTaskConfig.b();
  }
  
  public int h()
  {
    return RIJRewardTaskConfig.c();
  }
  
  public int i()
  {
    return RIJRewardTaskConfig.d();
  }
  
  public int j()
  {
    return RIJRewardTaskConfig.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.aidl.RIJAidlServerRewardTaskModule
 * JD-Core Version:    0.7.0.1
 */