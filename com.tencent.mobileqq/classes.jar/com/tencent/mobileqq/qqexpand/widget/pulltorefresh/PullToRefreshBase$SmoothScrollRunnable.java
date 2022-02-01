package com.tencent.mobileqq.qqexpand.widget.pulltorefresh;

import android.view.animation.Interpolator;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.ViewCompat;

final class PullToRefreshBase$SmoothScrollRunnable
  implements Runnable
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final PullToRefreshBase.OnSmoothScrollFinishedListener jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$OnSmoothScrollFinishedListener;
  private boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private int c = -1;
  
  public PullToRefreshBase$SmoothScrollRunnable(PullToRefreshBase paramPullToRefreshBase, int paramInt1, int paramInt2, long paramLong, PullToRefreshBase.OnSmoothScrollFinishedListener paramOnSmoothScrollFinishedListener)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = PullToRefreshBase.a(paramPullToRefreshBase);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$OnSmoothScrollFinishedListener = paramOnSmoothScrollFinishedListener;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.this$0.removeCallbacks(this);
  }
  
  public void run()
  {
    if (this.jdField_b_of_type_Long == -1L)
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
    }
    else
    {
      long l = Math.max(Math.min((System.currentTimeMillis() - this.jdField_b_of_type_Long) * 1000L / this.jdField_a_of_type_Long, 1000L), 0L);
      int i = Math.round((this.jdField_b_of_type_Int - this.jdField_a_of_type_Int) * this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation((float)l / 1000.0F));
      this.c = (this.jdField_b_of_type_Int - i);
      this.this$0.a(this.c);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int != this.c))
    {
      ViewCompat.a(this.this$0, this);
      return;
    }
    PullToRefreshBase.OnSmoothScrollFinishedListener localOnSmoothScrollFinishedListener = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$OnSmoothScrollFinishedListener;
    if (localOnSmoothScrollFinishedListener != null) {
      localOnSmoothScrollFinishedListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.SmoothScrollRunnable
 * JD-Core Version:    0.7.0.1
 */