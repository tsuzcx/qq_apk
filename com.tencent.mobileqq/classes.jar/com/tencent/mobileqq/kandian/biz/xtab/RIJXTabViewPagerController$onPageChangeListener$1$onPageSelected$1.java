package com.tencent.mobileqq.kandian.biz.xtab;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeStore;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJXTabViewPagerController$onPageChangeListener$1$onPageSelected$1
  implements Runnable
{
  RIJXTabViewPagerController$onPageChangeListener$1$onPageSelected$1(RIJXTabViewPagerController.onPageChangeListener.1 param1, int paramInt) {}
  
  public final void run()
  {
    RIJXTabBadgeStore.a(this.a, true);
    Object localObject = ReadInJoyUtils.a();
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (localObject != null)
      {
        ((KandianMergeManager)localObject).l();
        RIJXTabViewPagerController.a(this.this$0.a).a().a();
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabViewPagerController.onPageChangeListener.1.onPageSelected.1
 * JD-Core Version:    0.7.0.1
 */