package com.tencent.mobileqq.troop.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.GridView;
import com.tencent.mobileqq.R.styleable;

public class ExtendGridView
  extends GridView
{
  protected boolean a;
  protected boolean b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  
  public ExtendGridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GridView);
    this.a = paramContext.getBoolean(1, false);
    this.b = paramContext.getBoolean(0, false);
    paramContext.recycle();
    b();
  }
  
  private void b()
  {
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    this.f = localDisplay.getWidth();
    this.g = localDisplay.getHeight();
  }
  
  public int a()
  {
    if (getWidth() > 0) {
      i = getWidth();
    } else {
      i = getMeasuredWidth();
    }
    int j = i;
    if (i <= 0) {
      j = this.f;
    }
    int i = getHorizontalSpacing();
    int k = getPaddingLeft();
    int m = getPaddingRight();
    int n = getNumColumns();
    j = (j - (k + m) - (n - 1) * i) / n;
    i = j;
    if (j < 0) {
      i = -2;
    }
    return i;
  }
  
  public int getHorizontalSpacing()
  {
    return this.c;
  }
  
  public int getNumColumns()
  {
    return this.e;
  }
  
  public int getVerticalSpacing()
  {
    return this.d;
  }
  
  @TargetApi(8)
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    b();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.a) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(536870911, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    if ((this.b) && (i < 0)) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    super.setHorizontalSpacing(paramInt);
    this.c = paramInt;
  }
  
  public void setNumColumns(int paramInt)
  {
    super.setNumColumns(paramInt);
    this.e = paramInt;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
  
  public void setPenetrateTouch(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setStretchable(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      requestLayout();
    }
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    super.setVerticalSpacing(paramInt);
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.ExtendGridView
 * JD-Core Version:    0.7.0.1
 */