package com.tencent.mobileqq.flashshow.presenter.feed;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.SeekBar;

class FSFeedChildVideoPresenter$1
  implements View.OnTouchListener
{
  FSFeedChildVideoPresenter$1(FSFeedChildVideoPresenter paramFSFeedChildVideoPresenter) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    FSFeedChildVideoPresenter.a(this.a).requestDisallowInterceptTouchEvent(true);
    FSFeedChildVideoPresenter.b(this.a).onTouchEvent(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildVideoPresenter.1
 * JD-Core Version:    0.7.0.1
 */