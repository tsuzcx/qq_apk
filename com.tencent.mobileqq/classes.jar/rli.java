import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask;
import com.tencent.biz.pubaccount.readinjoy.reward.aidl.RIJAidlServerRewardTaskModule.model.2;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/RIJAidlServerRewardTaskModule;", "Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/IRIJAidlInterfaceForRewardTask$Stub;", "()V", "model", "Lcom/tencent/biz/pubaccount/readinjoy/reward/mvp/RIJRewardTaskTimingModel;", "getModel", "()Lcom/tencent/biz/pubaccount/readinjoy/reward/mvp/RIJRewardTaskTimingModel;", "model$delegate", "Lkotlin/Lazy;", "dailyMissionCount", "", "getCurrentTask", "Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask;", "getLastTask", "getTaskProgress", "hasRead", "", "rowKey", "", "isEnable", "isNowInKanDianTab", "maxTaskTimeForArticleInMs", "maxTaskTimeWhenArticleStationaryInMs", "missionCompletedTimeInMs", "reportTaskCompleted", "", "type", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/IReportTaskProgressCallback;", "setCurrentTask", "task", "setLastTask", "setRead", "taskCompletedToday", "updateTaskProgress", "timeInMs", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rli
  extends rkx
{
  private final Lazy a = LazyKt.lazy((Function0)RIJAidlServerRewardTaskModule.model.2.INSTANCE);
  
  private final rln a()
  {
    return (rln)this.a.getValue();
  }
  
  public int a()
  {
    return a().b();
  }
  
  @Nullable
  public RIJRewardTask a()
  {
    return a().a();
  }
  
  public void a(int paramInt)
  {
    a().a(paramInt);
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
  
  public void a(@Nullable String paramString, int paramInt, @Nullable rkz paramrkz)
  {
    a().a(paramString, paramInt, (rkd)new rlj(paramrkz));
  }
  
  public boolean a()
  {
    return ReadinjoyTabFrame.d_();
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
    return a().a();
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
    return rjy.a();
  }
  
  public int c()
  {
    return rjy.a();
  }
  
  public int d()
  {
    return rjy.b();
  }
  
  public int e()
  {
    return rjy.c();
  }
  
  public int f()
  {
    return rjy.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rli
 * JD-Core Version:    0.7.0.1
 */