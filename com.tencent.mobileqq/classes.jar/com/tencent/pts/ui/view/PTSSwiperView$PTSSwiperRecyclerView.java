package com.tencent.pts.ui.view;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.pts.support.RecyclerViewCompat;

class PTSSwiperView$PTSSwiperRecyclerView
  extends RecyclerViewCompat
{
  private boolean autoPlay = false;
  private int autoPlayInterval = 5000;
  private Runnable autoPlayRunnable;
  
  public PTSSwiperView$PTSSwiperRecyclerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      removeCallbacks(this.autoPlayRunnable);
      continue;
      if (this.autoPlay) {
        postDelayed(this.autoPlayRunnable, this.autoPlayInterval);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSSwiperView.PTSSwiperRecyclerView
 * JD-Core Version:    0.7.0.1
 */