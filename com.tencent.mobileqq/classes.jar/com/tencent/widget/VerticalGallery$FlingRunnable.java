package com.tencent.widget;

import android.widget.Scroller;

class VerticalGallery$FlingRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private int b;
  
  public VerticalGallery$FlingRunnable(VerticalGallery paramVerticalGallery)
  {
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramVerticalGallery.getContext());
  }
  
  private void b()
  {
    this.this$0.removeCallbacks(this);
  }
  
  private void b(boolean paramBoolean)
  {
    VerticalGallery.b(this.this$0, false);
    this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
    if (paramBoolean) {
      this.this$0.a();
    }
    this.this$0.g();
  }
  
  public void a()
  {
    if (this.this$0.mItemCount == 0)
    {
      b(true);
      return;
    }
    VerticalGallery.c(this.this$0, false);
    Scroller localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    boolean bool = localScroller.computeScrollOffset();
    int j = localScroller.getCurrY();
    int i = this.b - j;
    if (i > 0) {
      VerticalGallery.a(this.this$0, this.this$0.mFirstPosition);
    }
    for (i = Math.min(this.this$0.getHeight() - this.this$0.getPaddingTop() - this.this$0.getPaddingBottom() - 1, i);; i = Math.max(-(this.this$0.getHeight() - this.this$0.getPaddingBottom() - this.this$0.getPaddingTop() - 1), i))
    {
      this.this$0.b(i);
      if ((!bool) || (VerticalGallery.b(this.this$0))) {
        break;
      }
      this.b = j;
      this.this$0.post(this);
      return;
      int k = this.this$0.getChildCount();
      VerticalGallery.a(this.this$0, k - 1 + this.this$0.mFirstPosition);
    }
    b(true);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    b();
    if (VerticalGallery.a(this.this$0))
    {
      if (paramInt < 0) {}
      for (i = 2147483647;; i = 0)
      {
        this.b = i;
        this.jdField_a_of_type_AndroidWidgetScroller.fling(0, i, 0, paramInt, 0, 2147483647, 0, 2147483647);
        this.this$0.post(this);
        return;
      }
    }
    if (paramInt < 0) {}
    for (int i = 2147483647;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_AndroidWidgetScroller.fling(i, 0, paramInt, 0, 0, 2147483647, 0, 2147483647);
      this.this$0.post(this);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.this$0.removeCallbacks(this);
    b(paramBoolean);
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if (VerticalGallery.a(this.this$0))
    {
      b();
      VerticalGallery.b(this.this$0, true);
      this.b = 0;
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, 0, -paramInt, VerticalGallery.a(this.this$0));
      this.this$0.post(this);
      return;
    }
    b();
    VerticalGallery.b(this.this$0, true);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, -paramInt, 0, VerticalGallery.a(this.this$0));
    this.this$0.post(this);
  }
  
  public void run()
  {
    if (VerticalGallery.a(this.this$0))
    {
      a();
      return;
    }
    if (this.this$0.mItemCount == 0)
    {
      b(true);
      return;
    }
    VerticalGallery.c(this.this$0, false);
    Scroller localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    boolean bool = localScroller.computeScrollOffset();
    int j = localScroller.getCurrX();
    int i = this.jdField_a_of_type_Int - j;
    if (i > 0) {
      VerticalGallery.a(this.this$0, this.this$0.mFirstPosition);
    }
    for (i = Math.min(this.this$0.getWidth() - this.this$0.getPaddingLeft() - this.this$0.getPaddingRight() - 1, i);; i = Math.max(-(this.this$0.getWidth() - this.this$0.getPaddingRight() - this.this$0.getPaddingLeft() - 1), i))
    {
      this.this$0.a(i);
      if ((!bool) || (VerticalGallery.b(this.this$0))) {
        break;
      }
      this.jdField_a_of_type_Int = j;
      this.this$0.post(this);
      return;
      int k = this.this$0.getChildCount();
      VerticalGallery.a(this.this$0, k - 1 + this.this$0.mFirstPosition);
    }
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.VerticalGallery.FlingRunnable
 * JD-Core Version:    0.7.0.1
 */