package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.view.OrientationEventListener;

class VideoFeedsListView$2
  extends OrientationEventListener
{
  VideoFeedsListView$2(VideoFeedsListView paramVideoFeedsListView, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (VideoFeedsListView.b(this.a)) {
      return;
    }
    if (!VideoFeedsListView.c(this.a)) {
      return;
    }
    if (!VideoFeedsListView.d(this.a)) {
      return;
    }
    if (VideoFeedsListView.a(this.a) == 1) {
      return;
    }
    if (VideoFeedsListView.e(this.a)) {
      return;
    }
    if (!VideoFeedsListView.a(this.a, paramInt)) {
      return;
    }
    if ((!VideoFeedsListView.f(this.a)) && (VideoFeedsListView.g(this.a))) {
      return;
    }
    VideoFeedsListView.b(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsListView.2
 * JD-Core Version:    0.7.0.1
 */