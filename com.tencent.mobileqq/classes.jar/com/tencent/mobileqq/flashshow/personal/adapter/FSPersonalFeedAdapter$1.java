package com.tencent.mobileqq.flashshow.personal.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.flashshow.personal.bean.FSPersonalFeedInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FSPersonalFeedAdapter$1
  implements View.OnClickListener
{
  FSPersonalFeedAdapter$1(FSPersonalFeedAdapter paramFSPersonalFeedAdapter, int paramInt, FSPersonalFeedInfo paramFSPersonalFeedInfo) {}
  
  public void onClick(View paramView)
  {
    if (FSPersonalFeedAdapter.a(this.c) != null) {
      FSPersonalFeedAdapter.a(this.c).a(this.a, this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.adapter.FSPersonalFeedAdapter.1
 * JD-Core Version:    0.7.0.1
 */