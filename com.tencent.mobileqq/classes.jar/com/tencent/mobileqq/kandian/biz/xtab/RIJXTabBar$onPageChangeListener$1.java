package com.tencent.mobileqq.kandian.biz.xtab;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import mqq.os.MqqHandler;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/xtab/RIJXTabBar$onPageChangeListener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "index", "offset", "", "positionOffsetPixels", "onPageSelected", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabBar$onPageChangeListener$1
  implements ViewPager.OnPageChangeListener
{
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    ThreadManager.getUIHandler().post((Runnable)new RIJXTabBar.onPageChangeListener.1.onPageSelected.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabBar.onPageChangeListener.1
 * JD-Core Version:    0.7.0.1
 */