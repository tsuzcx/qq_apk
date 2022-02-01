package com.tencent.pts.ui.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.pts.support.RecyclerViewCompat;
import com.tencent.pts.utils.PTSLog;

class PTSSwiperView$PTSSwiperRecyclerView
  extends RecyclerViewCompat
{
  private boolean autoPlay = false;
  private int autoPlayInterval = 5000;
  private Runnable autoPlayRunnable;
  private boolean hasDragged;
  private PTSSwiperView ptsSwiperView;
  private float touchBeginX;
  private float touchBeginY;
  
  public PTSSwiperView$PTSSwiperRecyclerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PTSSwiperView$PTSSwiperRecyclerView(PTSSwiperView paramPTSSwiperView)
  {
    super(paramPTSSwiperView.getContext());
    this.ptsSwiperView = paramPTSSwiperView;
  }
  
  private void setInterceptTouchEvent(ViewParent paramViewParent, float paramFloat1, float paramFloat2)
  {
    if ((Math.abs(paramFloat2) > PTSSwiperView.access$1200()) && (Math.abs(paramFloat2) > Math.abs(paramFloat1)))
    {
      paramViewParent.requestDisallowInterceptTouchEvent(false);
      if (PTSLog.isColorLevel()) {
        PTSLog.i("PTSSwiperView", "[dispatchTouchEvent] requestDisallowInterceptTouchEvent false");
      }
    }
    do
    {
      return;
      paramViewParent.requestDisallowInterceptTouchEvent(true);
    } while (!PTSLog.isColorLevel());
    PTSLog.i("PTSSwiperView", "[dispatchTouchEvent] requestDisallowInterceptTouchEvent true");
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    ViewParent localViewParent = getParent();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.touchBeginX = f2;
      this.touchBeginY = f1;
      this.hasDragged = false;
      removeCallbacks(this.autoPlayRunnable);
      continue;
      if (this.autoPlay) {
        postDelayed(this.autoPlayRunnable, this.autoPlayInterval);
      }
      if ((this.hasDragged) && (this.ptsSwiperView != null)) {
        PTSSwiperView.access$1100(this.ptsSwiperView);
      }
      if (localViewParent != null)
      {
        localViewParent.requestDisallowInterceptTouchEvent(false);
        PTSLog.i("PTSSwiperView", "[dispatchTouchEvent] requestDisallowInterceptTouchEvent false");
        continue;
        f2 -= this.touchBeginX;
        f1 -= this.touchBeginY;
        if (PTSLog.isColorLevel()) {
          PTSLog.d("PTSSwiperView", "[dispatchTouchEvent] dx = " + f2 + ", dy = " + f1);
        }
        if ((Math.abs(f2) > PTSSwiperView.access$1200()) || (Math.abs(f1) > PTSSwiperView.access$1200())) {
          this.hasDragged = true;
        }
        setInterceptTouchEvent(localViewParent, f2, f1);
      }
    }
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    this.autoPlay = paramBoolean;
  }
  
  public void setAutoPlayInterval(int paramInt)
  {
    this.autoPlayInterval = paramInt;
  }
  
  public void setAutoPlayRunnable(Runnable paramRunnable)
  {
    this.autoPlayRunnable = paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSSwiperView.PTSSwiperRecyclerView
 * JD-Core Version:    0.7.0.1
 */