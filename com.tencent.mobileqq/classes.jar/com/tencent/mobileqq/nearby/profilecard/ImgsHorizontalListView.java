package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.OverScroller;

public class ImgsHorizontalListView
  extends HorizontalListView
{
  public View a;
  
  public ImgsHorizontalListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ImgsHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean a()
  {
    if (!this.c) {}
    int i;
    do
    {
      View localView;
      do
      {
        return false;
        if (!this.d) {
          if (Math.abs(this.g - this.i) < this.o) {
            i = 1;
          }
        }
        while (i != 0)
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          i = this.i;
          this.g = i;
          this.h = i;
          invalidate();
          return false;
          i = 0;
          continue;
          if (Math.abs(this.g - this.j) < this.o) {
            i = 1;
          } else {
            i = 0;
          }
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if (this.o + this.e >= 0)
        {
          this.h += this.e;
          invalidate();
          return false;
        }
        localView = getChildAt(0);
      } while (localView == null);
      i = this.h;
      int j = this.e + i;
      int k = localView.getMeasuredWidth();
      i = j;
      if (this.e <= -(k / 2 + 0.5D)) {
        i = j + k;
      }
    } while (!this.jdField_a_of_type_ComTencentWidgetOverScroller.a(this.h + getScrollX(), 0, i, i, 0, 0));
    invalidate();
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setArrow(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.ImgsHorizontalListView
 * JD-Core Version:    0.7.0.1
 */