package com.tencent.qqmini.sdk.launcher.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class VideoGestureRelativeLayout$1
  implements View.OnTouchListener
{
  VideoGestureRelativeLayout$1(VideoGestureRelativeLayout paramVideoGestureRelativeLayout) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (VideoGestureRelativeLayout.access$000(this.this$0)))
    {
      if (VideoGestureRelativeLayout.access$100(this.this$0) != null) {
        VideoGestureRelativeLayout.access$100(this.this$0).onEndFF_REW(paramMotionEvent);
      }
      VideoGestureRelativeLayout.access$002(this.this$0, false);
    }
    boolean bool = VideoGestureRelativeLayout.access$200(this.this$0).onTouchEvent(paramMotionEvent);
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 1)) {
      QMLog.d("gesturetest", "mGestureDetector.onTouchEvent(event) return " + bool);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout.1
 * JD-Core Version:    0.7.0.1
 */