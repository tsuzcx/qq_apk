package com.tencent.mobileqq.kandian.biz.xtab;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.kandian.biz.feeds.api.impl.RIJChannelStayTimeMonitor;
import com.tencent.mobileqq.kandian.biz.tab.KDBottomTabThemeManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/xtab/RIJXTabViewPagerController$onPageChangeListener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "index", "offset", "", "positionOffsetPixels", "onPageSelected", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabViewPagerController$onPageChangeListener$1
  implements ViewPager.OnPageChangeListener
{
  public void onPageScrollStateChanged(int paramInt)
  {
    RIJXTabViewPagerController.a(this.a).getTabLayout().onPageScrollStateChanged(paramInt);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    RIJXTabViewPagerController.a(this.a).getTabLayout().onPageScrolled(paramInt1, paramFloat, paramInt2);
  }
  
  public void onPageSelected(int paramInt)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.d(paramInt);
    if (localTabChannelCoverInfo != null)
    {
      int i = localTabChannelCoverInfo.mChannelCoverId;
      RIJChannelStayTimeMonitor.INSTANCE.onChannelChanged(localTabChannelCoverInfo, this.a.f());
      RIJXTabViewPagerController.f(this.a).a(localTabChannelCoverInfo);
      RIJXTabViewPagerController.a(this.a, paramInt, localTabChannelCoverInfo);
      RIJXTabViewPagerController.a(this.a).getTabLayout().onPageSelected(paramInt);
      RIJXTabViewPagerController.a(this.a, paramInt, i);
      RIJXTabViewPagerController.a(this.a, localTabChannelCoverInfo);
      com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting.e = i;
      com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting.f = localTabChannelCoverInfo;
      KDBottomTabThemeManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabViewPagerController.onPageChangeListener.1
 * JD-Core Version:    0.7.0.1
 */