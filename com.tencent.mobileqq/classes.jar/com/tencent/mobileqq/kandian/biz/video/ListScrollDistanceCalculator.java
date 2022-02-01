package com.tencent.mobileqq.kandian.biz.video;

import android.view.View;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class ListScrollDistanceCalculator
  implements AbsListView.OnScrollListener
{
  private ListScrollDistanceCalculator.ScrollDistanceListener a;
  private boolean b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 != 0)
    {
      if (!this.b) {
        return;
      }
      paramAbsListView = paramAbsListView.getChildAt(0);
      paramInt3 = paramAbsListView.getTop();
      int i = paramAbsListView.getBottom();
      int j = paramAbsListView.getHeight();
      paramInt2 = this.c;
      if (paramInt1 > paramInt2)
      {
        this.e += this.d;
        paramInt2 = paramInt3 - this.e;
      }
      else
      {
        if (paramInt1 < paramInt2)
        {
          this.f -= this.d;
          paramInt2 = this.f;
        }
        else
        {
          paramInt2 = this.f;
        }
        paramInt2 = i - paramInt2;
      }
      this.h = paramInt2;
      this.g += paramInt2;
      paramAbsListView = this.a;
      if (paramAbsListView != null) {
        paramAbsListView.a(paramInt2, this.g);
      }
      this.e = paramInt3;
      this.f = i;
      this.d = j;
      this.c = paramInt1;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView.getCount() == 0) {
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      View localView = paramAbsListView.getChildAt(0);
      this.c = paramAbsListView.getFirstVisiblePosition();
      this.e = localView.getTop();
      this.f = localView.getBottom();
      this.d = localView.getHeight();
      this.b = true;
      this.g = 0;
      return;
    }
    this.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.ListScrollDistanceCalculator
 * JD-Core Version:    0.7.0.1
 */