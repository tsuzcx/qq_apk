package com.tencent.mobileqq.flashshow.presenter.feed;

import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002.DataBuilder;
import com.tencent.mobileqq.flashshow.widgets.FSDoubleClickLayout.OnDoubleClickListener;
import com.tencent.mobileqq.flashshow.widgets.FSDoublePraiseView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

class FSFeedChildDoublePraisePresenter$1
  implements FSDoubleClickLayout.OnDoubleClickListener
{
  FSFeedChildDoublePraisePresenter$1(FSFeedChildDoublePraisePresenter paramFSFeedChildDoublePraisePresenter, int paramInt) {}
  
  public void a()
  {
    FSFeedChildDoublePraisePresenter.a(this.b).a();
    if (this.b.b == null) {
      return;
    }
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.b.b;
    FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(localStFeed, this.b.e()).a(69).b(2).a(localStFeed.poster.id.get()).g(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildDoublePraisePresenter.1
 * JD-Core Version:    0.7.0.1
 */