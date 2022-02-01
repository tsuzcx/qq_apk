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
    else
    {
      paramViewParent.requestDisallowInterceptTouchEvent(true);
      if (PTSLog.isColorLevel()) {
        PTSLog.i("PTSSwiperView", "[dispatchTouchEvent] requestDisallowInterceptTouchEvent true");
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    ViewParent localViewParent = getParent();
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      Object localObject;
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label248;
          }
        }
        else
        {
          f2 -= this.touchBeginX;
          f1 -= this.touchBeginY;
          if (PTSLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[dispatchTouchEvent] dx = ");
            ((StringBuilder)localObject).append(f2);
            ((StringBuilder)localObject).append(", dy = ");
            ((StringBuilder)localObject).append(f1);
            PTSLog.d("PTSSwiperView", ((StringBuilder)localObject).toString());
          }
          if ((Math.abs(f2) > PTSSwiperView.access$1200()) || (Math.abs(f1) > PTSSwiperView.access$1200())) {
            this.hasDragged = true;
          }
          setInterceptTouchEvent(localViewParent, f2, f1);
          break label248;
        }
      }
      if (this.autoPlay) {
        postDelayed(this.autoPlayRunnable, this.autoPlayInterval);
      }
      if (this.hasDragged)
      {
        localObject = this.ptsSwiperView;
        if (localObject != null) {
          PTSSwiperView.access$1100((PTSSwiperView)localObject);
        }
      }
      if (localViewParent != null)
      {
        localViewParent.requestDisallowInterceptTouchEvent(false);
        PTSLog.i("PTSSwiperView", "[dispatchTouchEvent] requestDisallowInterceptTouchEvent false");
      }
    }
    else
    {
      this.touchBeginX = f2;
      this.touchBeginY = f1;
      this.hasDragged = false;
      removeCallbacks(this.autoPlayRunnable);
    }
    label248:
    return super.dispatchTouchEvent(paramMotionEvent);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSSwiperView.PTSSwiperRecyclerView
 * JD-Core Version:    0.7.0.1
 */