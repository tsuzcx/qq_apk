package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver.OnDrawListener;
import android.view.Window;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;

class VideoFeedsAdapter$1
  implements ViewTreeObserver.OnDrawListener
{
  int a = 0;
  
  VideoFeedsAdapter$1(VideoFeedsAdapter paramVideoFeedsAdapter, VideoPlayParam paramVideoPlayParam) {}
  
  public void onDraw()
  {
    this.a += 1;
    if (this.a == 1)
    {
      this.c.e.getWindow().getDecorView().post(new VideoFeedsAdapter.1.1(this, this));
      if (this.b == this.c.h.az) {
        this.c.f.a(this.b, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAdapter.1
 * JD-Core Version:    0.7.0.1
 */