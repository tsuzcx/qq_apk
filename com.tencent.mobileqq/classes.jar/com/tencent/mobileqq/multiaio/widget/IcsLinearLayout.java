package com.tencent.mobileqq.multiaio.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class IcsLinearLayout
  extends LinearLayout
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16843049, 16843561, 16843562 };
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private int b;
  private int c;
  private int d;
  
  public IcsLinearLayout(Context paramContext, int paramInt)
  {
    super(paramContext);
    paramContext = paramContext.obtainStyledAttributes(null, jdField_a_of_type_ArrayOfInt, paramInt, 0);
    setDividerDrawable(paramContext.getDrawable(0));
    this.d = paramContext.getDimensionPixelSize(2, 0);
    this.c = paramContext.getInteger(1, 0);
    paramContext.recycle();
  }
  
  private void a(Canvas paramCanvas)
  {
    int j = getChildCount();
    int i = 0;
    View localView;
    while (i < j)
    {
      localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8) && (a(i)))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        a(paramCanvas, localView.getTop() - localLayoutParams.topMargin);
      }
      i += 1;
    }
    if (a(j))
    {
      localView = getChildAt(j - 1);
      if (localView != null) {
        break label119;
      }
    }
    label119:
    for (i = getHeight() - getPaddingBottom() - this.b;; i = localView.getBottom())
    {
      a(paramCanvas, i);
      return;
    }
  }
  
  private void a(Canvas paramCanvas, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(getPaddingLeft() + this.d, paramInt, getWidth() - getPaddingRight() - this.d, this.b + paramInt);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == getChildCount())) {}
    for (;;)
    {
      return false;
      if ((this.c & 0x2) != 0)
      {
        paramInt -= 1;
        while (paramInt >= 0)
        {
          if (getChildAt(paramInt).getVisibility() != 8) {
            return true;
          }
          paramInt -= 1;
        }
      }
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    int j = getChildCount();
    int i = 0;
    View localView;
    while (i < j)
    {
      localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8) && (a(i)))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        b(paramCanvas, localView.getLeft() - localLayoutParams.leftMargin);
      }
      i += 1;
    }
    if (a(j))
    {
      localView = getChildAt(j - 1);
      if (localView != null) {
        break label119;
      }
    }
    label119:
    for (i = getWidth() - getPaddingRight() - this.jdField_a_of_type_Int;; i = localView.getRight())
    {
      b(paramCanvas, i);
      return;
    }
  }
  
  private void b(Canvas paramCanvas, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramInt, getPaddingTop() + this.d, this.jdField_a_of_type_Int + paramInt, getHeight() - getPaddingBottom() - this.d);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = indexOfChild(paramView);
    int j = getOrientation();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (a(i))
    {
      if (j == 1) {
        localLayoutParams.topMargin = this.b;
      }
    }
    else
    {
      int k = getChildCount();
      if ((i == k - 1) && (a(k)))
      {
        if (j != 1) {
          break label109;
        }
        localLayoutParams.bottomMargin = this.b;
      }
    }
    for (;;)
    {
      super.measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
      localLayoutParams.leftMargin = this.jdField_a_of_type_Int;
      break;
      label109:
      localLayoutParams.rightMargin = this.jdField_a_of_type_Int;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      if (getOrientation() != 1) {
        break label26;
      }
      a(paramCanvas);
    }
    for (;;)
    {
      super.onDraw(paramCanvas);
      return;
      label26:
      b(paramCanvas);
    }
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    boolean bool = false;
    if (paramDrawable == this.jdField_a_of_type_AndroidGraphicsDrawableDrawable) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (paramDrawable != null) {
      this.jdField_a_of_type_Int = (paramDrawable.getIntrinsicWidth() - 2);
    }
    for (this.b = paramDrawable.getIntrinsicHeight();; this.b = 0)
    {
      if (paramDrawable == null) {
        bool = true;
      }
      setWillNotDraw(bool);
      requestLayout();
      return;
      this.jdField_a_of_type_Int = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.IcsLinearLayout
 * JD-Core Version:    0.7.0.1
 */