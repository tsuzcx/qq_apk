package com.tencent.mobileqq.kandian.biz.reward.aidl;

import com.tencent.mobileqq.kandian.biz.common.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTask;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskConfig;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskRemoteRepo.IReportTaskProgressCallback;
import com.tencent.mobileqq.kandian.biz.reward.mvp.RIJRewardTaskTimingModel;
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
  
  private final RIJRewardTaskTimingModel a()
  {
    return (RIJRewardTaskTimingModel)this.a.getValue();
  }
  
  public int a()
  {
    return a().a();
  }
  
  @Nullable
  public RIJRewardTask a()
  {
    return a().a();
  }
  
  public void a(int paramInt)
  {
    a().a(paramInt, true);
  }
  
  public void a(@Nullable RIJRewardTask paramRIJRewardTask)
  {
    a().a(paramRIJRewardTask);
  }
  
  public void a(@Nullable String paramString)
  {
    if (paramString != null) {
      a().a(paramString);
    }
  }
  
  public void a(@Nullable String paramString, int paramInt, @Nullable IReportTaskProgressCallback paramIReportTaskProgressCallback)
  {
    a().a(paramString, paramInt, (RIJRewardTaskRemoteRepo.IReportTaskProgressCallback)new RIJAidlServerRewardTaskModule.reportTaskCompleted.1(paramIReportTaskProgressCallback));
  }
  
  public boolean a()
  {
    return RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab();
  }
  
  public boolean a(@Nullable String paramString)
  {
    if (paramString != null) {
      return a().a(paramString);
    }
    return false;
  }
  
  public int b()
  {
    return a().a(true);
  }
  
  @Nullable
  public RIJRewardTask b()
  {
    return a().b();
  }
  
  public void b(@Nullable RIJRewardTask paramRIJRewardTask)
  {
    a().b(paramRIJRewardTask);
  }
  
  public boolean b()
  {
    return RIJRewardTaskConfig.a();
  }
  
  public int c()
  {
    return RIJRewardTaskConfig.a();
  }
  
  public int d()
  {
    return RIJRewardTaskConfig.b();
  }
  
  public int e()
  {
    return RIJRewardTaskConfig.c();
  }
  
  public int f()
  {
    return RIJRewardTaskConfig.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.aidl.RIJAidlServerRewardTaskModule
 * JD-Core Version:    0.7.0.1
 */