package com.tencent.mobileqq.kandian.biz.xtab;

import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.kandian.biz.xtab.msgboard.RIJXTabMessageBoardRedUtil;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/xtab/RIJXTabFrame$mObserver$1", "Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "onChannelListBadgeupdate", "", "hasRedPoint", "", "onHashBtnBadgeUpdate", "isShowRed", "onHomepageModeGuideConfigReceived", "onXTabBadgeExposure", "info", "Lcom/tencent/mobileqq/kandian/repo/tab/RIJXTabRedDotInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabFrame$mObserver$1
  extends ReadInJoyObserver
{
  RIJXTabFrame$mObserver$1(FrameFragment paramFrameFragment) {}
  
  public void b(boolean paramBoolean)
  {
    RIJXTabFrame.f(this.a).a(paramBoolean);
  }
  
  public void c(boolean paramBoolean)
  {
    RIJXTabFrame.f(this.a).b(paramBoolean);
    RIJXTabMessageBoardRedUtil.a.a("0X800BCB4", RIJXTabMessageBoardRedUtil.a.d());
  }
  
  public void cN_()
  {
    KDXTabHomepageModeGuideViewModel localKDXTabHomepageModeGuideViewModel = RIJXTabFrame.i(this.a);
    if (localKDXTabHomepageModeGuideViewModel != null) {
      localKDXTabHomepageModeGuideViewModel.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame.mObserver.1
 * JD-Core Version:    0.7.0.1
 */