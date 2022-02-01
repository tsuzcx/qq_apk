package com.tencent.mobileqq.flashshow.presenter.feed;

import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002.DataBuilder;
import com.tencent.mobileqq.flashshow.widgets.common.FSFollowView.FSFollowReportListener;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

class FSFeedChildInteractPresenter$1
  implements FSFollowView.FSFollowReportListener
{
  FSFeedChildInteractPresenter$1(FSFeedChildInteractPresenter paramFSFeedChildInteractPresenter) {}
  
  public void a(int paramInt) {}
  
  public void b(int paramInt)
  {
    FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder((FeedCloudMeta.StFeed)this.a.b, this.a.e()).a(80).b(2).a(((FeedCloudMeta.StFeed)this.a.b).poster.id.get()).g(this.a.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildInteractPresenter.1
 * JD-Core Version:    0.7.0.1
 */