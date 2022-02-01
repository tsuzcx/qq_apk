package com.tencent.mobileqq.flashshow.presenter.feed;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import feedcloud.FeedCloudMeta.StFeed;

public class FSFeedChildHeaderPresenter
  extends FSBaseFeedChildPresenter<FeedCloudMeta.StFeed>
  implements View.OnClickListener
{
  private LinearLayout f;
  
  public void a(@NonNull View paramView)
  {
    super.a(paramView);
    this.f = ((LinearLayout)paramView.findViewById(2131433372));
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    super.a(paramStFeed, paramInt);
    a(false);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    LinearLayout localLinearLayout = this.f;
    if (localLinearLayout == null) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 0;
    }
    localLinearLayout.setVisibility(i);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildHeaderPresenter
 * JD-Core Version:    0.7.0.1
 */