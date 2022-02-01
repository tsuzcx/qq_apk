package com.tencent.mobileqq.kandian.biz.xtab;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeStore;
import kotlin.Metadata;
import kotlin.TypeCastException;
import mqq.manager.Manager;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJXTabViewPagerController$tryHandleBadgeOnPageSelected$1
  implements Runnable
{
  RIJXTabViewPagerController$tryHandleBadgeOnPageSelected$1(RIJXTabViewPagerController paramRIJXTabViewPagerController, int paramInt) {}
  
  public final void run()
  {
    RIJXTabBadgeStore.a(this.a, true);
    Manager localManager = RIJQQAppInterfaceUtil.b().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    if (localManager != null)
    {
      ((KandianMergeManager)localManager).I();
      RIJXTabViewPagerController.a(this.this$0).getTabLayout().a();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabViewPagerController.tryHandleBadgeOnPageSelected.1
 * JD-Core Version:    0.7.0.1
 */