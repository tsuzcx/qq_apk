package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Scroller;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.widget.AbsSpinner;

public class HorizontalItemIndicator
  extends ViewGroup
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Scroller jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
  private HorizontalItemIndicator.OnItemChanged jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator$OnItemChanged;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public HorizontalItemIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HorizontalItemIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HorizontalItemIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.HorizontalItemIndicator, paramInt, 0);
    try
    {
      this.jdField_a_of_type_Int = paramContext.getColor(1, -1711276033);
      this.b = paramContext.getDimensionPixelSize(2, 28);
      this.d = paramContext.getColor(0, -1);
      paramContext.recycle();
      this.c = this.b;
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      setWillNotDraw(false);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private TextView a(int paramInt)
  {
    return (TextView)getChildAt(paramInt);
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    int i;
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      i = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("currMid is ");
      ((StringBuilder)localObject).append(i);
      Log.i("tmp", ((StringBuilder)localObject).toString());
      postInvalidate();
    }
    else
    {
      i = getChildAt(this.e).getMeasuredWidth() / 2 + getChildAt(this.e).getLeft();
      j = this.f;
      if (j != this.e)
      {
        localObject = a(j);
        ((TextView)localObject).setTextSize(0, this.b);
        ((TextView)localObject).setTextColor(this.jdField_a_of_type_Int);
      }
      localObject = a(this.e);
      ((TextView)localObject).setTextSize(0, this.c);
      ((TextView)localObject).setTextColor(this.d);
    }
    int j = getMeasuredWidth() / 2;
    paramCanvas.save();
    paramCanvas.translate(j - i, 0.0F);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.drawCircle(j, getChildAt(0).getBottom() + 8 + 6, 6.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = getChildCount();
    paramInt2 = getPaddingLeft();
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = getChildAt(paramInt1);
      int i = localView.getMeasuredWidth();
      paramInt4 = localView.getMeasuredHeight();
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      paramInt2 += localMarginLayoutParams.leftMargin;
      int j = getPaddingTop() + localMarginLayoutParams.topMargin;
      i += paramInt2;
      localView.layout(paramInt2, j, i, paramInt4 + j);
      paramInt2 = localMarginLayoutParams.rightMargin + i;
      paramInt1 += 1;
    }
  }
  
  @TargetApi(11)
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = getChildCount();
    measureChildren(paramInt1, paramInt2);
    int k = 0;
    int j = 0;
    for (int i = 0; k < i1; i = m)
    {
      View localView = getChildAt(k);
      n = j;
      m = i;
      if (localView.getVisibility() != 8)
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        n = j + (localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + localView.getMeasuredWidth());
        m = Math.max(i, localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + localView.getMeasuredHeight());
      }
      k += 1;
      j = n;
    }
    int n = getPaddingLeft();
    i1 = getPaddingRight();
    k = getPaddingTop();
    int m = getPaddingBottom();
    j = Math.max(j + (n + i1), getSuggestedMinimumWidth());
    i = Math.max(i + (k + m), getSuggestedMinimumHeight());
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramInt1 = resolveSizeAndState(j, paramInt1, 0);
      paramInt2 = resolveSizeAndState(i, paramInt2, 0);
    }
    else
    {
      paramInt1 = AbsSpinner.doResolveSizeAndState(j, paramInt1, 0);
      paramInt2 = AbsSpinner.doResolveSizeAndState(i, paramInt2, 0);
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setCurrItem(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= getChildCount()) {
        return;
      }
      if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
        return;
      }
      int i = this.e;
      if (paramInt != i)
      {
        this.f = i;
        this.e = paramInt;
        HorizontalItemIndicator.OnItemChanged localOnItemChanged = this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator$OnItemChanged;
        if (localOnItemChanged != null) {
          localOnItemChanged.a(paramInt);
        }
        requestLayout();
      }
    }
  }
  
  public void setNextItem()
  {
    int i = this.e + 1;
    if (i >= getChildCount()) {
      return;
    }
    setCurrItem(i);
  }
  
  public void setOnItemChanged(HorizontalItemIndicator.OnItemChanged paramOnItemChanged)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator$OnItemChanged = paramOnItemChanged;
  }
  
  public void setPrevItem()
  {
    int i = this.e - 1;
    if (i < 0) {
      return;
    }
    setCurrItem(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.HorizontalItemIndicator
 * JD-Core Version:    0.7.0.1
 */