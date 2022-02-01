package com.tencent.mobileqq.kandian.biz.xtab;

import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/kandian/biz/xtab/KDXTabHomepageModeGuideViewModel$HomepageGuideData;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class RIJXTabFrame$initViewPager$2<T>
  implements Observer<KDXTabHomepageModeGuideViewModel.HomepageGuideData>
{
  RIJXTabFrame$initViewPager$2(RIJXTabFrame paramRIJXTabFrame) {}
  
  public final void a(KDXTabHomepageModeGuideViewModel.HomepageGuideData paramHomepageGuideData)
  {
    if (paramHomepageGuideData != null)
    {
      RIJXTabFrame.h(this.a).a((FrameLayout)RIJXTabFrame.e(this.a), paramHomepageGuideData.c(), paramHomepageGuideData.a());
      RIJXTabFrame.h(this.a).a((Function1)new RIJXTabFrame.initViewPager.2..special..inlined.let.lambda.1(paramHomepageGuideData, this));
      paramHomepageGuideData = RIJXTabFrame.i(this.a);
      if (paramHomepageGuideData != null) {
        paramHomepageGuideData.d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame.initViewPager.2
 * JD-Core Version:    0.7.0.1
 */