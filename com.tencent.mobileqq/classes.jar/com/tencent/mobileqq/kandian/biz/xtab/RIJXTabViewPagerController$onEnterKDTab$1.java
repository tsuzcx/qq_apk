package com.tencent.mobileqq.kandian.biz.xtab;

import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPager;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPager.CustomFragmentPagerAdapter;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJXTabViewPagerController$onEnterKDTab$1
  implements Runnable
{
  RIJXTabViewPagerController$onEnterKDTab$1(RIJXTabViewPagerController paramRIJXTabViewPagerController) {}
  
  public final void run()
  {
    int i = RIJXTabViewPagerController.d(this.this$0).getCurrentItem();
    RIJXTabViewPagerController.e(this.this$0).onPageSelected(i);
    RIJXTabViewPagerController.b(this.this$0).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabViewPagerController.onEnterKDTab.1
 * JD-Core Version:    0.7.0.1
 */