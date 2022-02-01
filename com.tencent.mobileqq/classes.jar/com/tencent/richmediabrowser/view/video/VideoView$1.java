package com.tencent.richmediabrowser.view.video;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.SeekBar;

class VideoView$1
  implements View.OnTouchListener
{
  VideoView$1(VideoView paramVideoView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = new Rect();
    this.a.playBar.getHitRect(paramView);
    int i;
    if ((paramMotionEvent.getY() >= paramView.top - 600) && (paramMotionEvent.getY() <= paramView.bottom + 600)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return false;
    }
    float f2 = paramView.top + (paramView.height() >> 1);
    float f1 = paramMotionEvent.getX() - paramView.left;
    if (f1 < 0.0F) {
      f1 = 0.0F;
    } else if (f1 > paramView.width()) {
      f1 = paramView.width();
    }
    paramView = MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), paramMotionEvent.getAction(), f1, f2, paramMotionEvent.getMetaState());
    boolean bool = this.a.playBar.onTouchEvent(paramView);
    paramView.recycle();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.video.VideoView.1
 * JD-Core Version:    0.7.0.1
 */