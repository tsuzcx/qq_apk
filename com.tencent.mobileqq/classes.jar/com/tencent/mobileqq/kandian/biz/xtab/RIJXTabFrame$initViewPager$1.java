package com.tencent.mobileqq.kandian.biz.xtab;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class RIJXTabFrame$initViewPager$1<T>
  implements Observer<List<? extends TabChannelCoverInfo>>
{
  RIJXTabFrame$initViewPager$1(RIJXTabFrame paramRIJXTabFrame) {}
  
  public final void a(List<? extends TabChannelCoverInfo> paramList)
  {
    RIJXTabViewPagerController localRIJXTabViewPagerController = RIJXTabFrame.g(this.a);
    Intrinsics.checkExpressionValueIsNotNull(paramList, "it");
    localRIJXTabViewPagerController.a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame.initViewPager.1
 * JD-Core Version:    0.7.0.1
 */