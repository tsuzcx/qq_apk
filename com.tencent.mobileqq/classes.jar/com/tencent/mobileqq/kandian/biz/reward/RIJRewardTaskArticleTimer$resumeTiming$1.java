package com.tencent.mobileqq.kandian.biz.reward;

import android.os.Handler;
import com.tencent.mobileqq.kandian.biz.reward.mvp.RIJRewardTaskTimingPresenter;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJRewardTaskArticleTimer$resumeTiming$1
  implements Runnable
{
  RIJRewardTaskArticleTimer$resumeTiming$1(RIJRewardTaskArticleTimer paramRIJRewardTaskArticleTimer, String paramString, int paramInt) {}
  
  public final void run()
  {
    if (RIJRewardTaskArticleTimer.access$getStationaryTime$p(this.this$0) <= RIJRewardTaskConfig.e())
    {
      RIJRewardTaskArticleTimer localRIJRewardTaskArticleTimer = this.this$0;
      RIJRewardTaskArticleTimer.access$setStationaryTime$p(localRIJRewardTaskArticleTimer, RIJRewardTaskArticleTimer.access$getStationaryTime$p(localRIJRewardTaskArticleTimer) + 33);
      RIJRewardTaskArticleTimer.access$getRewardTaskTimingPresenter$p(this.this$0).a(this.a, this.b, 1);
    }
    else
    {
      RIJRewardTaskArticleTimer.access$getRewardTaskTimingPresenter$p(this.this$0).b();
    }
    RIJRewardTaskArticleTimer.access$getTimingHandler$p(this.this$0).postDelayed(RIJRewardTaskArticleTimer.access$getTimingRunnable$p(this.this$0), 33);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskArticleTimer.resumeTiming.1
 * JD-Core Version:    0.7.0.1
 */