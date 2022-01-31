package com.tencent.widget;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import bhsi;
import bhuz;

class AbsListView$FlingRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private final bhuz jdField_a_of_type_Bhuz;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new AbsListView.FlingRunnable.1(this);
  
  AbsListView$FlingRunnable(AbsListView paramAbsListView)
  {
    this.jdField_a_of_type_Bhuz = new bhuz(paramAbsListView.getContext());
  }
  
  void a()
  {
    this.this$0.mTouchMode = -1;
    this.this$0.removeCallbacks(this);
    this.this$0.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.this$0.reportScrollStateChange(0);
    AbsListView.access$2000(this.this$0);
    this.jdField_a_of_type_Bhuz.a();
    if (AbsListView.access$1600(this.this$0) != null) {
      AbsListView.access$1602(this.this$0, AbsListView.access$2100(this.this$0, AbsListView.access$1600(this.this$0)));
    }
  }
  
  void a(int paramInt)
  {
    int i;
    if (paramInt < 0)
    {
      i = 2147483647;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Bhuz.a(0, i, 0, paramInt, 0, 2147483647, 0, 2147483647);
      this.this$0.mTouchMode = 4;
      if (Build.VERSION.SDK_INT < 16) {
        break label86;
      }
      this.this$0.postOnAnimation(this);
    }
    for (;;)
    {
      if (AbsListView.access$1600(this.this$0) == null) {
        AbsListView.access$1602(this.this$0, AbsListView.access$1700(this.this$0, "AbsListView-fling"));
      }
      return;
      i = 0;
      break;
      label86:
      this.this$0.post(this);
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bhuz.b();
    int i = this.jdField_a_of_type_Bhuz.b();
    i = this.jdField_a_of_type_Int - i;
    if (i != 0)
    {
      i = -i;
      if (paramInt1 >= 0) {
        break label167;
      }
    }
    label167:
    for (int j = 2147483647;; j = 0)
    {
      this.jdField_a_of_type_Int = j;
      this.jdField_a_of_type_Bhuz.a(0, j + i, 0, paramInt1 - i, paramInt2);
      this.this$0.mTouchMode = 4;
      this.this$0.invalidate();
      this.this$0.removeCallbacks(this);
      if (Build.VERSION.SDK_INT < 16) {
        break label173;
      }
      this.this$0.postOnAnimation(this);
      return;
      Interpolator localInterpolator = this.jdField_a_of_type_Bhuz.a();
      if (localInterpolator != null)
      {
        i = (int)localInterpolator.getInterpolation(16.0F / paramInt2) * paramInt1;
        break;
      }
      float f = 16.0F / paramInt2;
      i = (int)(1.0F - (1.0F - f) * (1.0F - f)) * paramInt1;
      break;
    }
    label173:
    this.this$0.post(this);
  }
  
  void b()
  {
    this.this$0.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 40L);
  }
  
  void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bhuz.a(0, this.this$0.getScrollY(), paramInt, paramInt, paramInt, paramInt))
    {
      this.this$0.mTouchMode = 6;
      this.this$0.invalidate();
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.this$0.postOnAnimation(this);
        return;
      }
      this.this$0.post(this);
      return;
    }
    this.this$0.mTouchMode = -1;
    this.this$0.reportScrollStateChange(0);
  }
  
  void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {}
    for (int i = 2147483647;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Bhuz.a(0, i, 0, paramInt1, paramInt2);
      this.this$0.mTouchMode = 4;
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      this.this$0.postOnAnimation(this);
      return;
    }
    this.this$0.post(this);
  }
  
  @TargetApi(9)
  void c(int paramInt)
  {
    int i = 0;
    if (this.this$0.mForHongBao) {
      i = this.this$0.getSpringbackOffset();
    }
    bhuz localbhuz = this.jdField_a_of_type_Bhuz;
    int j;
    if (paramInt > 0)
    {
      j = this.this$0.mTopOverflingDistance;
      localbhuz.a(paramInt, i, j);
      i = this.this$0.getOverScrollMode();
      if ((i != 0) && ((i != 1) || (AbsListView.access$1800(this.this$0)))) {
        break label165;
      }
      this.this$0.mTouchMode = 6;
      i = (int)this.jdField_a_of_type_Bhuz.a();
      if (this.this$0.mEdgeGlowTop != null)
      {
        if (paramInt <= 0) {
          break label151;
        }
        this.this$0.mEdgeGlowTop.a(i);
      }
    }
    for (;;)
    {
      this.this$0.invalidate();
      if (Build.VERSION.SDK_INT < 16) {
        break label216;
      }
      this.this$0.postOnAnimation(this);
      return;
      j = this.this$0.mBottomOverflingDistance;
      break;
      label151:
      this.this$0.mEdgeGlowBottom.a(i);
      continue;
      label165:
      this.this$0.mTouchMode = -1;
      if (this.this$0.mPositionScroller != null) {
        this.this$0.mPositionScroller.a();
      }
      if (AbsListView.access$1900(this.this$0) != null) {
        AbsListView.access$1900(this.this$0).b();
      }
    }
    label216:
    this.this$0.post(this);
  }
  
  @TargetApi(9)
  public void run()
  {
    int k = 1;
    int i;
    int j;
    switch (this.this$0.mTouchMode)
    {
    case 5: 
    default: 
      a();
    case 3: 
      do
      {
        return;
      } while (this.jdField_a_of_type_Bhuz.a());
    case 4: 
      AdapterView.traceBegin("AbsListView.FlingRunable.onfling");
      for (;;)
      {
        try
        {
          if (this.this$0.mDataChanged) {
            this.this$0.layoutChildren();
          }
          if ((this.this$0.mItemCount == 0) || (this.this$0.getChildCount() == 0))
          {
            a();
            return;
          }
          Object localObject1 = this.jdField_a_of_type_Bhuz;
          boolean bool = ((bhuz)localObject1).b();
          int m = ((bhuz)localObject1).b();
          i = this.jdField_a_of_type_Int - m;
          if (i > 0)
          {
            this.this$0.mMotionPosition = this.this$0.mFirstPosition;
            localObject1 = this.this$0.getChildAt(0);
            this.this$0.mMotionViewOriginalTop = ((View)localObject1).getTop();
            i = Math.min(this.this$0.getHeight() - AbsListView.access$2200(this.this$0) - AbsListView.access$2300(this.this$0) - 1, i);
            localObject1 = this.this$0.getChildAt(this.this$0.mMotionPosition - this.this$0.mFirstPosition);
            if (localObject1 == null) {
              break;
            }
            j = ((View)localObject1).getTop();
            if ((!this.this$0.trackMotionScroll(i, i)) || (i == 0)) {
              break label652;
            }
            label254:
            if (k != 0) {
              if (localObject1 != null)
              {
                j = -(i - (((View)localObject1).getTop() - j));
                if ((!this.this$0.mForHongBao) || (j <= 0))
                {
                  i = j;
                  if (bool)
                  {
                    c(j);
                    i = this.jdField_a_of_type_Bhuz.b();
                  }
                  this.this$0.overScrollBy(0, i, 0, this.this$0.getScrollY(), 0, 0, 0, this.this$0.mOverscrollDistance, false);
                }
              }
            }
          }
          else
          {
            j = this.this$0.getChildCount() - 1;
            this.this$0.mMotionPosition = (this.this$0.mFirstPosition + j);
            localObject1 = this.this$0.getChildAt(j);
            this.this$0.mMotionViewOriginalTop = ((View)localObject1).getTop();
            i = Math.max(-(this.this$0.getHeight() - AbsListView.access$2400(this.this$0) - AbsListView.access$2500(this.this$0) - 1), i);
            continue;
          }
          if ((bool) && (k == 0))
          {
            this.this$0.invalidate();
            this.jdField_a_of_type_Int = m;
            if (Build.VERSION.SDK_INT >= 16)
            {
              this.this$0.postOnAnimation(this);
              return;
            }
            this.this$0.post(this);
            continue;
          }
          a();
        }
        finally
        {
          AdapterView.traceEnd();
        }
      }
    }
    label642:
    label652:
    label657:
    for (;;)
    {
      bhuz localbhuz;
      label560:
      try
      {
        localbhuz = this.jdField_a_of_type_Bhuz;
        if (!localbhuz.b()) {
          break label642;
        }
        j = this.this$0.getScrollY();
        k = localbhuz.b();
        if (!this.this$0.overScrollBy(0, k - j, 0, j, 0, 0, 0, this.this$0.mOverscrollDistance, false)) {
          break label608;
        }
        if ((j > 0) || (k <= 0)) {
          break label592;
        }
        i = 1;
        break label657;
      }
      finally {}
      k = (int)localbhuz.a();
      i = k;
      if (j != 0) {
        i = -k;
      }
      localbhuz.a();
      a(i);
      return;
      label592:
      i = 0;
      break label657;
      label597:
      j = 0;
      label608:
      do
      {
        b(0);
        return;
        this.this$0.invalidate();
        if (Build.VERSION.SDK_INT >= 16)
        {
          this.this$0.postOnAnimation(this);
          return;
        }
        this.this$0.post(this);
        return;
        a();
        return;
        j = 0;
        break;
        k = 0;
        break label254;
        if ((j < 0) || (k >= 0)) {
          break label597;
        }
        j = 1;
        if (i != 0) {
          break label560;
        }
      } while (j == 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AbsListView.FlingRunnable
 * JD-Core Version:    0.7.0.1
 */