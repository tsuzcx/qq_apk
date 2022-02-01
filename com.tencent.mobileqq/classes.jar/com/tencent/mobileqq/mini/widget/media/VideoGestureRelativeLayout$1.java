package com.tencent.mobileqq.mini.widget.media;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;

class VideoGestureRelativeLayout$1
  implements View.OnTouchListener
{
  VideoGestureRelativeLayout$1(VideoGestureRelativeLayout paramVideoGestureRelativeLayout) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    QLog.d("gesturetest", 4, "onTouch: event:" + paramMotionEvent.toString());
    if ((paramMotionEvent.getAction() == 1) && (VideoGestureRelativeLayout.access$000(this.this$0)))
    {
      if (VideoGestureRelativeLayout.access$100(this.this$0) != null) {
        VideoGestureRelativeLayout.access$100(this.this$0).onEndFF_REW(paramMotionEvent);
      }
      VideoGestureRelativeLayout.access$002(this.this$0, false);
    }
    boolean bool = VideoGestureRelativeLayout.access$200(this.this$0).onTouchEvent(paramMotionEvent);
    QLog.d("gesturetest", 4, "mGestureDetector.onTouchEvent(event) return " + paramMotionEvent.toString());
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.VideoGestureRelativeLayout.1
 * JD-Core Version:    0.7.0.1
 */