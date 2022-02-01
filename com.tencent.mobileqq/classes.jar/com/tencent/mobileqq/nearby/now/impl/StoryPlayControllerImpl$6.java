package com.tencent.mobileqq.nearby.now.impl;

import android.view.View;
import com.tencent.mobileqq.nearby.now.ActCallBack;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.OperationView;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.StoryViewRelayoutListener;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;

class StoryPlayControllerImpl$6
  implements StoryViewRelayoutListener
{
  StoryPlayControllerImpl$6(StoryPlayControllerImpl paramStoryPlayControllerImpl, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, VideoData paramVideoData) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a.d != null) {
      this.a.d.getPlayOperationViewModel().getmBinding().findViewById(2131437180).setVisibility(0);
    }
    this.a.f.setVisibility(8);
    this.a.e.setVisibility(0);
    this.a.e.requestLayout();
    this.c.callBack.f();
  }
  
  public void a(String paramString, View paramView, int paramInt)
  {
    if (this.a.d != null) {
      this.a.d.getPlayOperationViewModel().getmBinding().findViewById(2131437180).setVisibility(8);
    }
    this.a.f.a();
    this.a.f.setVisibility(0);
    this.a.f.setOnClickListener(new StoryPlayControllerImpl.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.impl.StoryPlayControllerImpl.6
 * JD-Core Version:    0.7.0.1
 */