package com.tencent.mobileqq.kandian.biz.xtab;

import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeReporter;
import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeStore;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJXTabViewPagerController$tryHandleGuideBadgeOnPageSelected$1
  implements Runnable
{
  RIJXTabViewPagerController$tryHandleGuideBadgeOnPageSelected$1(RIJXTabViewPagerController paramRIJXTabViewPagerController, int paramInt) {}
  
  public final void run()
  {
    RIJXTabBadgeStore.a.c(this.a);
    RIJXTabBadgeReporter.c(this.a);
    RIJXTabViewPagerController.a(this.this$0).getTabLayout().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabViewPagerController.tryHandleGuideBadgeOnPageSelected.1
 * JD-Core Version:    0.7.0.1
 */