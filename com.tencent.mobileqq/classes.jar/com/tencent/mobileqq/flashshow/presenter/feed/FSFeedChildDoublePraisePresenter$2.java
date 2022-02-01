package com.tencent.mobileqq.flashshow.presenter.feed;

import android.view.MotionEvent;
import com.tencent.mobileqq.flashshow.presenter.feed.event.FSDoubleViewClickEvent;
import com.tencent.mobileqq.flashshow.widgets.FSDoubleClickLayout.OnTapClickListener;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;

class FSFeedChildDoublePraisePresenter$2
  implements FSDoubleClickLayout.OnTapClickListener
{
  FSFeedChildDoublePraisePresenter$2(FSFeedChildDoublePraisePresenter paramFSFeedChildDoublePraisePresenter) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.a;
    paramMotionEvent.b(new FSDoubleViewClickEvent(((FeedCloudMeta.StFeed)paramMotionEvent.b).id.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildDoublePraisePresenter.2
 * JD-Core Version:    0.7.0.1
 */