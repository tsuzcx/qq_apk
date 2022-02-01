package com.tencent.mobileqq.flashshow.presenter.feed;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;

public class FSFeedChildBottomInputPresenter
  extends FSBaseFeedChildPresenter<FeedCloudMeta.StFeed>
  implements View.OnClickListener
{
  private Context f;
  
  public void a(@NonNull View paramView)
  {
    super.a(paramView);
    this.f = paramView.getContext();
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    super.a(paramStFeed, paramInt);
    a(false);
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      paramView.getId();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildBottomInputPresenter
 * JD-Core Version:    0.7.0.1
 */