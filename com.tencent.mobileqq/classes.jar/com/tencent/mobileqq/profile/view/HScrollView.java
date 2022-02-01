package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

public class HScrollView
  extends HorizontalScrollView
  implements Runnable
{
  private Handler a = new Handler();
  private HScrollView.ScrollViewListener b;
  private int c = -9999999;
  private int d = 1;
  
  public HScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 1)
    {
      if (i == 2)
      {
        this.d = 2;
        this.b.a(this.d);
        this.a.removeCallbacks(this);
      }
    }
    else {
      this.a.post(this);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void run()
  {
    if (getScrollX() == this.c)
    {
      this.d = 1;
      localScrollViewListener = this.b;
      if (localScrollViewListener != null) {
        localScrollViewListener.a(this.d);
      }
      this.a.removeCallbacks(this);
      return;
    }
    this.d = 3;
    HScrollView.ScrollViewListener localScrollViewListener = this.b;
    if (localScrollViewListener != null) {
      localScrollViewListener.a(this.d);
    }
    this.c = getScrollX();
    this.a.postDelayed(this, 50L);
  }
  
  public void setOnScrollListener(HScrollView.ScrollViewListener paramScrollViewListener)
  {
    this.b = paramScrollViewListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.HScrollView
 * JD-Core Version:    0.7.0.1
 */