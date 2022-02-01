package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.Scroller;

public class TroopMemberListSlideItem
  extends FrameLayout
{
  protected int a;
  protected View a;
  protected Scroller a;
  protected boolean a;
  protected View b;
  private boolean b;
  
  public TroopMemberListSlideItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    a(paramContext);
  }
  
  public TroopMemberListSlideItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    a(paramContext);
  }
  
  protected void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
  }
  
  public void a(boolean paramBoolean)
  {
    if (getScrollX() > 0) {
      return;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, this.jdField_a_of_type_Int, 0);
    }
    for (;;)
    {
      invalidate();
      return;
      scrollTo(this.jdField_a_of_type_Int, 0);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (getScrollX() == 0) {
      return;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(this.jdField_a_of_type_Int, 0, -this.jdField_a_of_type_Int, 0);
    }
    for (;;)
    {
      invalidate();
      return;
      scrollTo(0, 0);
    }
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), 0);
      invalidate();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidViewView = getChildAt(0);
    this.jdField_b_of_type_AndroidViewView = getChildAt(1);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.width == -1)) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
    if (this.jdField_a_of_type_Boolean) {
      paramInt1 = getMeasuredWidth();
    }
    this.jdField_a_of_type_AndroidViewView.layout(0, 0, paramInt1, this.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
    this.jdField_b_of_type_AndroidViewView.layout(paramInt1, 0, this.jdField_b_of_type_AndroidViewView.getMeasuredWidth() + paramInt1, this.jdField_b_of_type_AndroidViewView.getMeasuredHeight());
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_a_of_type_Int = this.jdField_b_of_type_AndroidViewView.getMeasuredWidth();
  }
  
  public void setSlideEnabled(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean)
    {
      setClickable(true);
      return;
    }
    setClickable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TroopMemberListSlideItem
 * JD-Core Version:    0.7.0.1
 */