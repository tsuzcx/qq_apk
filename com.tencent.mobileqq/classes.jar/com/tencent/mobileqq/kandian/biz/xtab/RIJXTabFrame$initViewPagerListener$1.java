package com.tencent.mobileqq.kandian.biz.xtab;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.kandian.glue.report.RIJKanDianTabReport;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.tkd.topicsdk.entry.controller.IEntryViewController.DefaultImpls;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/xtab/RIJXTabFrame$initViewPagerListener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabFrame$initViewPagerListener$1
  implements ViewPager.OnPageChangeListener
{
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    Object localObject = this.a.a().a(paramInt);
    RIJXTabFrame.a(this.a, (TabChannelCoverInfo)localObject);
    RIJKanDianTabReport.a((TabChannelCoverInfo)localObject);
    if (this.a.a() == 0)
    {
      localObject = RIJXTabFrame.a(this.a);
      if (localObject != null) {
        IEntryViewController.DefaultImpls.a(RIJXTabFrame.a(this.a), (String)localObject, null, 2, null);
      }
    }
    else
    {
      localObject = RIJXTabFrame.a(this.a);
      if (localObject != null) {
        IEntryViewController.DefaultImpls.b(RIJXTabFrame.a(this.a), (String)localObject, null, 2, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame.initViewPagerListener.1
 * JD-Core Version:    0.7.0.1
 */