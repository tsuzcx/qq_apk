package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnDrawListener;
import android.view.Window;

class VideoFeedsAdapter$1$1
  implements Runnable
{
  VideoFeedsAdapter$1$1(VideoFeedsAdapter.1 param1, ViewTreeObserver.OnDrawListener paramOnDrawListener) {}
  
  public void run()
  {
    this.b.c.e.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */