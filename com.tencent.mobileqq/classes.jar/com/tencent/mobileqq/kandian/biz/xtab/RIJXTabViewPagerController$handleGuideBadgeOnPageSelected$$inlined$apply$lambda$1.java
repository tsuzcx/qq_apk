package com.tencent.mobileqq.kandian.biz.xtab;

import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeReporter;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeStore;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/mobileqq/kandian/biz/xtab/RIJXTabViewPagerController$handleGuideBadgeOnPageSelected$1$1"}, k=3, mv={1, 1, 16})
final class RIJXTabViewPagerController$handleGuideBadgeOnPageSelected$$inlined$apply$lambda$1
  implements Runnable
{
  RIJXTabViewPagerController$handleGuideBadgeOnPageSelected$$inlined$apply$lambda$1(TabChannelCoverInfo paramTabChannelCoverInfo, RIJXTabViewPagerController paramRIJXTabViewPagerController) {}
  
  public final void run()
  {
    RIJXTabBadgeStore.a.b(this.a.mChannelCoverId);
    RIJXTabBadgeReporter.c(this.a.mChannelCoverId);
    RIJXTabViewPagerController.a(this.this$0).a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabViewPagerController.handleGuideBadgeOnPageSelected..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */