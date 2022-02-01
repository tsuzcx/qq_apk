package com.tencent.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AnimationUtils;
import blgl;

class AbsListView$MoveToBottomScroller
  implements Runnable
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private int d;
  private int e;
  
  AbsListView$MoveToBottomScroller(AbsListView paramAbsListView) {}
  
  void a()
  {
    boolean bool = true;
    int i = this.this$0.mFirstPosition;
    int j = this.this$0.getChildCount();
    i = this.this$0.mItemCount - (i + j - 1) - 1;
    if (i == 0)
    {
      i = AbsListView.access$2600(this.this$0);
      j = AbsListView.access$2700(this.this$0);
      int k = this.this$0.mListPadding.bottom;
      this.e = (this.this$0.getChildAt(this.this$0.getChildCount() - 1).getBottom() - (i - j - k));
      if (this.e == 0)
      {
        b();
        return;
      }
      this.d = 400;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 3;
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.this$0.postOnAnimation(this);
        return;
      }
      this.this$0.post(this);
      return;
    }
    this.jdField_c_of_type_Float = (this.this$0.getHeight() * i / this.this$0.getChildCount() / 300.0F);
    this.jdField_a_of_type_Float = (this.jdField_c_of_type_Float / 100.0F);
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = (this.this$0.mItemCount - 1);
    if (i == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      this.this$0.postOnAnimation(this);
      return;
      bool = false;
    }
    this.this$0.post(this);
  }
  
  void b()
  {
    this.this$0.removeCallbacks(this);
    this.this$0.mScrollToBottom = false;
  }
  
  public void run()
  {
    int i = 0;
    AdapterView.traceBegin("AbsListView.MoveToBottomScroller.run");
    for (;;)
    {
      int j;
      try
      {
        j = (int)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long);
        switch (this.jdField_b_of_type_Int)
        {
        case 0: 
          i -= this.jdField_a_of_type_Int;
          if (this.this$0.trackMotionScroll(-i, -i)) {
            break label564;
          }
          i = this.this$0.getChildCount();
          int k = this.this$0.mFirstPosition;
          if ((this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 1) || (k + i - 1 < this.jdField_c_of_type_Int)) {
            break label524;
          }
          k = AbsListView.access$2800(this.this$0);
          int m = AbsListView.access$2900(this.this$0);
          int n = this.this$0.mListPadding.bottom;
          this.e = (this.this$0.getChildAt(i - 1).getBottom() - (k - m - n));
          if (this.e != 0) {
            break label426;
          }
          b();
          return;
        }
      }
      finally
      {
        AdapterView.traceEnd();
      }
      if (j > 100)
      {
        this.jdField_b_of_type_Float = this.jdField_c_of_type_Float;
        i = (int)(this.jdField_c_of_type_Float * j - this.jdField_c_of_type_Float * 400.0F / 8.0F);
        this.jdField_a_of_type_Float = 0.0F;
        this.jdField_b_of_type_Int = 2;
      }
      else
      {
        this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float * j);
        i = (int)(this.jdField_b_of_type_Float * j / 2.0F);
        continue;
        i = (int)(this.jdField_c_of_type_Float * j - this.jdField_c_of_type_Float * 400.0F / 8.0F);
        continue;
        if (j > this.d)
        {
          i = this.e - this.jdField_a_of_type_Int;
          this.this$0.trackMotionScroll(-i, -i);
          AdapterView.traceEnd();
          return;
        }
        this.jdField_b_of_type_Float -= this.jdField_a_of_type_Float * j;
        i = (int)(this.e - this.jdField_b_of_type_Float * (this.d - j) / 2.0F);
        continue;
        if (j > this.d)
        {
          i = this.e - this.jdField_a_of_type_Int;
          this.this$0.trackMotionScroll(-i, -i);
          AdapterView.traceEnd();
          return;
        }
        float f = j;
        i = (int)(blgl.a(f / this.d) * this.e);
        continue;
        label426:
        this.d = (400 - j);
        if (this.d < 100) {
          this.d = 100;
        }
        this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
        this.jdField_a_of_type_Int = 0;
        if ((this.jdField_b_of_type_Float * 1000.0F > AbsListView.access$1500(this.this$0)) && (!this.jdField_a_of_type_Boolean))
        {
          this.jdField_b_of_type_Int = 1;
          this.jdField_b_of_type_Float = (this.e * 2.0F / this.d);
          this.jdField_a_of_type_Float = (this.jdField_b_of_type_Float / this.d);
          label524:
          if (Build.VERSION.SDK_INT < 16) {
            break label552;
          }
          this.this$0.postOnAnimation(this);
        }
        for (;;)
        {
          AdapterView.traceEnd();
          return;
          this.jdField_b_of_type_Int = 3;
          break;
          label552:
          this.this$0.post(this);
          continue;
          label564:
          b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AbsListView.MoveToBottomScroller
 * JD-Core Version:    0.7.0.1
 */