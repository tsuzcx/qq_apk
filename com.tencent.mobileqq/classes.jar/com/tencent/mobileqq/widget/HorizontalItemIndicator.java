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
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private HorizontalItemIndicator.OnItemChanged g;
  private Paint h = new Paint();
  private Scroller i = new Scroller(getContext());
  
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
      this.a = paramContext.getColor(1, -1711276033);
      this.b = paramContext.getDimensionPixelSize(2, 28);
      this.d = paramContext.getColor(0, -1);
      paramContext.recycle();
      this.c = this.b;
      this.h.setStyle(Paint.Style.FILL);
      this.h.setColor(-1);
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
    int j;
    Object localObject;
    if (this.i.computeScrollOffset())
    {
      j = this.i.getCurrX();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("currMid is ");
      ((StringBuilder)localObject).append(j);
      Log.i("tmp", ((StringBuilder)localObject).toString());
      postInvalidate();
    }
    else
    {
      j = getChildAt(this.e).getMeasuredWidth() / 2 + getChildAt(this.e).getLeft();
      k = this.f;
      if (k != this.e)
      {
        localObject = a(k);
        ((TextView)localObject).setTextSize(0, this.b);
        ((TextView)localObject).setTextColor(this.a);
      }
      localObject = a(this.e);
      ((TextView)localObject).setTextSize(0, this.c);
      ((TextView)localObject).setTextColor(this.d);
    }
    int k = getMeasuredWidth() / 2;
    paramCanvas.save();
    paramCanvas.translate(k - j, 0.0F);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.drawCircle(k, getChildAt(0).getBottom() + 8 + 6, 6.0F, this.h);
  }
  
  public int getCurrItem()
  {
    return this.e;
  }
  
  public HorizontalItemIndicator.OnItemChanged getOnItemChanged()
  {
    return this.g;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = getChildCount();
    paramInt2 = getPaddingLeft();
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = getChildAt(paramInt1);
      int j = localView.getMeasuredWidth();
      paramInt4 = localView.getMeasuredHeight();
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      paramInt2 += localMarginLayoutParams.leftMargin;
      int k = getPaddingTop() + localMarginLayoutParams.topMargin;
      j += paramInt2;
      localView.layout(paramInt2, k, j, paramInt4 + k);
      paramInt2 = localMarginLayoutParams.rightMargin + j;
      paramInt1 += 1;
    }
  }
  
  @TargetApi(11)
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = getChildCount();
    measureChildren(paramInt1, paramInt2);
    int m = 0;
    int k = 0;
    for (int j = 0; m < i2; j = n)
    {
      View localView = getChildAt(m);
      i1 = k;
      n = j;
      if (localView.getVisibility() != 8)
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        i1 = k + (localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + localView.getMeasuredWidth());
        n = Math.max(j, localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + localView.getMeasuredHeight());
      }
      m += 1;
      k = i1;
    }
    int i1 = getPaddingLeft();
    i2 = getPaddingRight();
    m = getPaddingTop();
    int n = getPaddingBottom();
    k = Math.max(k + (i1 + i2), getSuggestedMinimumWidth());
    j = Math.max(j + (m + n), getSuggestedMinimumHeight());
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramInt1 = resolveSizeAndState(k, paramInt1, 0);
      paramInt2 = resolveSizeAndState(j, paramInt2, 0);
    }
    else
    {
      paramInt1 = AbsSpinner.doResolveSizeAndState(k, paramInt1, 0);
      paramInt2 = AbsSpinner.doResolveSizeAndState(j, paramInt2, 0);
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
      if (!this.i.isFinished()) {
        return;
      }
      int j = this.e;
      if (paramInt != j)
      {
        this.f = j;
        this.e = paramInt;
        HorizontalItemIndicator.OnItemChanged localOnItemChanged = this.g;
        if (localOnItemChanged != null) {
          localOnItemChanged.a(paramInt);
        }
        requestLayout();
      }
    }
  }
  
  public void setNextItem()
  {
    int j = this.e + 1;
    if (j >= getChildCount()) {
      return;
    }
    setCurrItem(j);
  }
  
  public void setOnItemChanged(HorizontalItemIndicator.OnItemChanged paramOnItemChanged)
  {
    this.g = paramOnItemChanged;
  }
  
  public void setPrevItem()
  {
    int j = this.e - 1;
    if (j < 0) {
      return;
    }
    setCurrItem(j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.HorizontalItemIndicator
 * JD-Core Version:    0.7.0.1
 */