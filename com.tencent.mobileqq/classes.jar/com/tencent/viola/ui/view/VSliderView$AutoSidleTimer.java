package com.tencent.viola.ui.view;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

class VSliderView$AutoSidleTimer
  extends Handler
  implements Runnable
{
  private WeakReference<VSliderView> mSliderViewPagerWeakReference;
  
  public VSliderView$AutoSidleTimer(VSliderView paramVSliderView1, VSliderView paramVSliderView2)
  {
    super(Looper.getMainLooper());
    this.mSliderViewPagerWeakReference = new WeakReference(paramVSliderView2);
  }
  
  public void post()
  {
    postDelayed(0);
  }
  
  public void postDelayed(int paramInt)
  {
    if (paramInt == 0)
    {
      post(this);
      return;
    }
    postDelayed(this, paramInt);
  }
  
  public void run()
  {
    if ((this.this$0.isShown()) && (this.mSliderViewPagerWeakReference != null) && (this.mSliderViewPagerWeakReference.get() != null))
    {
      VSliderView.access$200((VSliderView)this.mSliderViewPagerWeakReference.get());
      postDelayed(VSliderView.access$300(this.this$0));
    }
  }
  
  public void startTimer(int paramInt)
  {
    if ((this.mSliderViewPagerWeakReference != null) && (this.mSliderViewPagerWeakReference.get() != null))
    {
      removeCallbacks(this);
      postDelayed(paramInt);
    }
  }
  
  public void stopTimer()
  {
    if ((this.mSliderViewPagerWeakReference != null) && (this.mSliderViewPagerWeakReference.get() != null)) {
      removeCallbacks(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.view.VSliderView.AutoSidleTimer
 * JD-Core Version:    0.7.0.1
 */