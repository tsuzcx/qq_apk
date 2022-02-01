package com.tencent.mobileqq.kandian.biz.reward;

import android.os.Handler;
import com.tencent.mobileqq.kandian.biz.account.RIJUserLevelTimeUtils;
import com.tencent.mobileqq.kandian.biz.reward.api.IRIJRewardTaskArticleTimer;
import com.tencent.mobileqq.kandian.biz.reward.mvp.RIJRewardTaskTimingPresenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTaskArticleTimer;", "Lcom/tencent/mobileqq/kandian/biz/reward/api/IRIJRewardTaskArticleTimer;", "()V", "rewardTaskTimingPresenter", "Lcom/tencent/mobileqq/kandian/biz/reward/mvp/RIJRewardTaskTimingPresenter;", "kotlin.jvm.PlatformType", "getRewardTaskTimingPresenter", "()Lcom/tencent/mobileqq/kandian/biz/reward/mvp/RIJRewardTaskTimingPresenter;", "rewardTaskTimingPresenter$delegate", "Lkotlin/Lazy;", "stationaryTime", "", "timingHandler", "Landroid/os/Handler;", "getTimingHandler", "()Landroid/os/Handler;", "timingHandler$delegate", "timingRunnable", "Ljava/lang/Runnable;", "enabled", "", "pauseTiming", "", "resetStationaryTime", "resumeTiming", "rowKey", "", "maxTaskTimeInMs", "startTiming", "stopTiming", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTaskArticleTimer
  implements IRIJRewardTaskArticleTimer
{
  public static final RIJRewardTaskArticleTimer.Companion Companion = new RIJRewardTaskArticleTimer.Companion(null);
  private static final String TAG = "RIJRewardTaskArticleTimer";
  private final Lazy rewardTaskTimingPresenter$delegate = LazyKt.lazy((Function0)RIJRewardTaskArticleTimer.rewardTaskTimingPresenter.2.INSTANCE);
  private int stationaryTime;
  private final Lazy timingHandler$delegate = LazyKt.lazy((Function0)RIJRewardTaskArticleTimer.timingHandler.2.INSTANCE);
  private Runnable timingRunnable;
  
  private final RIJRewardTaskTimingPresenter getRewardTaskTimingPresenter()
  {
    return (RIJRewardTaskTimingPresenter)this.rewardTaskTimingPresenter$delegate.getValue();
  }
  
  private final Handler getTimingHandler()
  {
    return (Handler)this.timingHandler$delegate.getValue();
  }
  
  @JvmStatic
  public static final boolean isNowInKanDianTab()
  {
    return Companion.a();
  }
  
  private final void pauseTiming()
  {
    getRewardTaskTimingPresenter().a();
    QLog.i("RIJRewardTaskArticleTimer", 1, "pause timing");
    getTimingHandler().removeCallbacksAndMessages(null);
  }
  
  private final void resumeTiming(String paramString, int paramInt)
  {
    getTimingHandler().removeCallbacksAndMessages(null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resume timing:  stationaryTime: ");
    localStringBuilder.append(this.stationaryTime);
    QLog.i("RIJRewardTaskArticleTimer", 1, localStringBuilder.toString());
    this.timingRunnable = ((Runnable)new RIJRewardTaskArticleTimer.resumeTiming.1(this, paramString, paramInt));
    getTimingHandler().post(this.timingRunnable);
  }
  
  public boolean enabled()
  {
    return (RIJRewardTaskConfig.a()) || (RIJUserLevelTimeUtils.a());
  }
  
  public void resetStationaryTime()
  {
    this.stationaryTime = 0;
  }
  
  public void startTiming(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    if (!enabled()) {
      return;
    }
    resumeTiming(paramString, paramInt);
  }
  
  public void stopTiming()
  {
    if (!enabled()) {
      return;
    }
    pauseTiming();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskArticleTimer
 * JD-Core Version:    0.7.0.1
 */