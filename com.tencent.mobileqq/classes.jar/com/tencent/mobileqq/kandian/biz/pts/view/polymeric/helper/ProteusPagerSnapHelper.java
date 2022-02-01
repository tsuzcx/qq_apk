package com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.ProteusRecycleView;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.ProteusRecycleView.OnDispatchTouchEventListener;
import com.tencent.widget.pull2refresh.PagerSnapHelper;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

public class ProteusPagerSnapHelper
  extends PagerSnapHelper
  implements ProteusRecycleView.OnDispatchTouchEventListener
{
  Runnable a = new ProteusPagerSnapHelper.1(this);
  private ProteusRecycleView b;
  private int c = 3000;
  private int d = 1000;
  private boolean e = false;
  
  @Nullable
  public View a(LinearLayoutManager paramLinearLayoutManager)
  {
    int i = paramLinearLayoutManager.getChildCount();
    if (i == 0) {
      return null;
    }
    OrientationHelper localOrientationHelper = b(paramLinearLayoutManager);
    View localView = paramLinearLayoutManager.getChildAt(0);
    if (Math.abs(localOrientationHelper.getDecoratedStart(localView)) < 20) {
      return localView;
    }
    if (i > 1)
    {
      localView = paramLinearLayoutManager.getChildAt(i - 1);
      i = localOrientationHelper.getDecoratedEnd(localView);
      if (Math.abs(localOrientationHelper.getTotalSpace() - i) < 20) {
        return localView;
      }
    }
    return super.a(paramLinearLayoutManager);
  }
  
  public void a()
  {
    a(this.c);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.e = true;
    this.b.removeCallbacks(this.a);
    this.b.postDelayed(this.a, paramLong);
    this.b.b(this);
    this.b.a(this);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i != 3)) {
        return;
      }
      if (this.e) {
        this.b.postDelayed(this.a, this.c);
      }
    }
    else
    {
      this.b.removeCallbacks(this.a);
    }
  }
  
  public void a(@Nullable RecyclerViewCompat paramRecyclerViewCompat)
  {
    super.a(paramRecyclerViewCompat);
    this.b = ((ProteusRecycleView)paramRecyclerViewCompat);
  }
  
  public void b()
  {
    this.e = false;
    this.b.removeCallbacks(this.a);
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public int c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.ProteusPagerSnapHelper
 * JD-Core Version:    0.7.0.1
 */