package com.tencent.mobileqq.kandian.biz.xtab;

import com.tencent.mobileqq.kandian.biz.common.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJXTabBar$onPageChangeListener$1$onPageSelected$1
  implements Runnable
{
  RIJXTabBar$onPageChangeListener$1$onPageSelected$1(RIJXTabBar.onPageChangeListener.1 param1, int paramInt) {}
  
  public final void run()
  {
    List localList = RIJXTabFrameUtils.getChannelCoverList();
    int i = this.a;
    boolean bool;
    if ((i >= 0) && (i < localList.size()) && (((TabChannelCoverInfo)localList.get(this.a)).isImmersive)) {
      bool = true;
    } else {
      bool = false;
    }
    this.this$0.a.a(bool, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabBar.onPageChangeListener.1.onPageSelected.1
 * JD-Core Version:    0.7.0.1
 */