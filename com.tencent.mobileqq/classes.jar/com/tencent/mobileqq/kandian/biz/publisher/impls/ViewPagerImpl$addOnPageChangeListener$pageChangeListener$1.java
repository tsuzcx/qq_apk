package com.tencent.mobileqq.kandian.biz.publisher.impls;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.tkd.topicsdk.interfaces.OnPageChangeListenerProxy;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/publisher/impls/ViewPagerImpl$addOnPageChangeListener$pageChangeListener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViewPagerImpl$addOnPageChangeListener$pageChangeListener$1
  implements ViewPager.OnPageChangeListener
{
  ViewPagerImpl$addOnPageChangeListener$pageChangeListener$1(OnPageChangeListenerProxy paramOnPageChangeListenerProxy) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.a.b(paramInt);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.a.a(paramInt1, paramFloat, paramInt2);
  }
  
  public void onPageSelected(int paramInt)
  {
    this.a.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.ViewPagerImpl.addOnPageChangeListener.pageChangeListener.1
 * JD-Core Version:    0.7.0.1
 */