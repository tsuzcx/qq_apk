package com.tencent.mobileqq.kandian.biz.xtab;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJChannelStayTimeMonitor;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import mqq.os.MqqHandler;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/xtab/RIJXTabViewPagerController$onPageChangeListener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "index", "offset", "", "positionOffsetPixels", "onPageSelected", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabViewPagerController$onPageChangeListener$1
  implements ViewPager.OnPageChangeListener
{
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a(paramInt);
    if (localTabChannelCoverInfo != null)
    {
      int i = localTabChannelCoverInfo.mChannelCoverId;
      QBaseFragment localQBaseFragment = this.a.a(paramInt);
      Object localObject = localQBaseFragment;
      if (!(localQBaseFragment instanceof ReadInJoyBaseFragment)) {
        localObject = null;
      }
      localObject = (ReadInJoyBaseFragment)localObject;
      if (localObject != null)
      {
        ((IRIJChannelStayTimeMonitor)QRoute.api(IRIJChannelStayTimeMonitor.class)).onChannelChanged(localTabChannelCoverInfo, this.a.a());
        if (RIJXTabViewPagerController.a(this.a, i))
        {
          ((ReadInJoyBaseFragment)localObject).a(3);
          ThreadManager.getUIHandler().postDelayed((Runnable)new RIJXTabViewPagerController.onPageChangeListener.1.onPageSelected.1(this, i), 500L);
        }
        RIJXTabViewPagerController.a(this.a, localTabChannelCoverInfo);
        com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting.b = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabViewPagerController.onPageChangeListener.1
 * JD-Core Version:    0.7.0.1
 */