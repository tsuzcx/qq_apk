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
  private static final int[] a = { 16843049, 16843561, 16843562 };
  private Drawable b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public IcsLinearLayout(Context paramContext, int paramInt)
  {
    super(paramContext);
    paramContext = paramContext.obtainStyledAttributes(null, a, paramInt, 0);
    setDividerDrawable(paramContext.getDrawable(0));
    this.f = paramContext.getDimensionPixelSize(2, 0);
    this.e = paramContext.getInteger(1, 0);
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
      if (localView == null) {
        i = getHeight() - getPaddingBottom() - this.d;
      } else {
        i = localView.getBottom();
      }
      a(paramCanvas, i);
    }
  }
  
  private void a(Canvas paramCanvas, int paramInt)
  {
    this.b.setBounds(getPaddingLeft() + this.f, paramInt, getWidth() - getPaddingRight() - this.f, this.d + paramInt);
    this.b.draw(paramCanvas);
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == getChildCount()) {
        return false;
      }
      if ((this.e & 0x2) != 0)
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
    return false;
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
      if (localView == null) {
        i = getWidth() - getPaddingRight() - this.c;
      } else {
        i = localView.getRight();
      }
      b(paramCanvas, i);
    }
  }
  
  private void b(Canvas paramCanvas, int paramInt)
  {
    this.b.setBounds(paramInt, getPaddingTop() + this.f, this.c + paramInt, getHeight() - getPaddingBottom() - this.f);
    this.b.draw(paramCanvas);
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = indexOfChild(paramView);
    int j = getOrientation();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (a(i)) {
      if (j == 1) {
        localLayoutParams.topMargin = this.d;
      } else {
        localLayoutParams.leftMargin = this.c;
      }
    }
    int k = getChildCount();
    if ((i == k - 1) && (a(k))) {
      if (j == 1) {
        localLayoutParams.bottomMargin = this.d;
      } else {
        localLayoutParams.rightMargin = this.c;
      }
    }
    super.measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.b != null) {
      if (getOrientation() == 1) {
        a(paramCanvas);
      } else {
        b(paramCanvas);
      }
    }
    super.onDraw(paramCanvas);
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == this.b) {
      return;
    }
    this.b = paramDrawable;
    boolean bool = false;
    if (paramDrawable != null)
    {
      this.c = (paramDrawable.getIntrinsicWidth() - 2);
      this.d = paramDrawable.getIntrinsicHeight();
    }
    else
    {
      this.c = 0;
      this.d = 0;
    }
    if (paramDrawable == null) {
      bool = true;
    }
    setWillNotDraw(bool);
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.IcsLinearLayout
 * JD-Core Version:    0.7.0.1
 */