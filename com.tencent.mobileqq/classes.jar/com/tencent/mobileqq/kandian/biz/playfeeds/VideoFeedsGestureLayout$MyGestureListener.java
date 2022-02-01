package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.SystemClock;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.CustomClickListener;

class VideoFeedsGestureLayout$MyGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  VideoFeedsGestureLayout$MyGestureListener(VideoFeedsGestureLayout paramVideoFeedsGestureLayout) {}
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (VideoFeedsGestureLayout.a(this.a) != null))
    {
      VideoFeedsGestureLayout.a(this.a, SystemClock.uptimeMillis());
      VideoFeedsGestureLayout.a(this.a).a(this.a, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (VideoFeedsGestureLayout.a(this.a) != null) {
      VideoFeedsGestureLayout.a(this.a).b(this.a);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    int i = VideoFeedsHelper.b(VideoFeedsGestureLayout.a(this.a))[0];
    i = VideoFeedsHelper.b(VideoFeedsGestureLayout.a(this.a))[1];
    paramFloat1 = paramMotionEvent1.getY() - paramMotionEvent2.getY();
    paramFloat2 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
    if (VideoFeedsGestureLayout.a(this.a) == 0) {
      if (Math.abs(paramFloat2) - Math.abs(paramFloat1) < 0.0F)
      {
        if (paramMotionEvent1.getX() < this.a.getWidth() / 2) {
          VideoFeedsGestureLayout.a(this.a, 2);
        } else {
          VideoFeedsGestureLayout.a(this.a, 1);
        }
      }
      else {
        VideoFeedsGestureLayout.a(this.a, 3);
      }
    }
    i = VideoFeedsGestureLayout.a(this.a);
    if ((i != 1) && (i != 2))
    {
      if (i != 3) {
        return false;
      }
      if (VideoFeedsGestureLayout.a(this.a) != null)
      {
        paramFloat2 /= this.a.getWidth() / 4 * 3;
        paramFloat1 = paramFloat2;
        if (Math.abs(paramFloat2) > 1.0F) {
          if (paramFloat2 > 1.0F) {
            paramFloat1 = 1.0F;
          } else {
            paramFloat1 = -1.0F;
          }
        }
        paramMotionEvent1 = this.a;
        paramMotionEvent1.a(VideoFeedsGestureLayout.a(paramMotionEvent1), paramFloat1);
        return false;
      }
    }
    else if (VideoFeedsGestureLayout.a(this.a) != null)
    {
      paramFloat2 = paramFloat1 / (this.a.getHeight() / 2);
      paramFloat1 = paramFloat2;
      if (Math.abs(paramFloat2) > 1.0F) {
        if (paramFloat2 > 1.0F) {
          paramFloat1 = 1.0F;
        } else {
          paramFloat1 = -1.0F;
        }
      }
      paramMotionEvent1 = this.a;
      paramMotionEvent1.a(VideoFeedsGestureLayout.a(paramMotionEvent1), paramFloat1);
    }
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((VideoFeedsGestureLayout.a(this.a) != null) && (SystemClock.uptimeMillis() - VideoFeedsGestureLayout.a(this.a) > 500L)) {
      VideoFeedsGestureLayout.a(this.a).a(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGestureLayout.MyGestureListener
 * JD-Core Version:    0.7.0.1
 */