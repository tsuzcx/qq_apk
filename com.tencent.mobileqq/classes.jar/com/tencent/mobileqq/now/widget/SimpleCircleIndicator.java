package com.tencent.mobileqq.now.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R.styleable;

public class SimpleCircleIndicator
  extends View
  implements IPageIndicator
{
  private int a = 30;
  private int b;
  private int c;
  private int d;
  private boolean e;
  private boolean f;
  private int g;
  private int h;
  private int i;
  private int j;
  private Paint k;
  private int l;
  private Paint m;
  private int n;
  private ViewPager o;
  private int p = -1;
  
  public SimpleCircleIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SimpleCircleIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public SimpleCircleIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (isInEditMode()) {
      return;
    }
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SimpleCircleIndicator);
      this.a = paramContext.getDimensionPixelSize(0, 40);
      this.b = paramContext.getDimensionPixelSize(3, 10);
      this.c = paramContext.getDimensionPixelSize(7, 10);
      this.j = paramContext.getColor(2, -65536);
      this.l = paramContext.getColor(6, -1);
      this.g = paramContext.getDimensionPixelSize(4, 1);
      this.h = paramContext.getDimensionPixelSize(8, 1);
      this.e = paramContext.getBoolean(1, false);
      this.f = paramContext.getBoolean(5, false);
      paramContext.recycle();
    }
    this.d = Math.max(this.b, this.c);
    this.i = Math.max(this.g, this.h);
    this.k = new Paint();
    paramAttributeSet = this.k;
    if (this.e) {
      paramContext = Paint.Style.STROKE;
    } else {
      paramContext = Paint.Style.FILL;
    }
    paramAttributeSet.setStyle(paramContext);
    this.k.setStrokeWidth(this.g);
    this.k.setAntiAlias(true);
    this.k.setColor(this.j);
    this.m = new Paint();
    paramAttributeSet = this.m;
    if (this.f) {
      paramContext = Paint.Style.STROKE;
    } else {
      paramContext = Paint.Style.FILL;
    }
    paramAttributeSet.setStyle(paramContext);
    this.m.setStrokeWidth(this.h);
    this.m.setStyle(Paint.Style.FILL);
    this.m.setAntiAlias(true);
    this.m.setColor(this.l);
  }
  
  private int getRealCount()
  {
    try
    {
      if (this.o == null) {
        return 0;
      }
      int i1 = this.o.getAdapter().getCount();
      if ((getMaxCount() > 0) && (getMaxCount() < i1))
      {
        i1 = getMaxCount();
        return i1;
      }
      return i1;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public int getMaxCount()
  {
    return this.p;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = getWidth();
    int i5 = getRealCount();
    if (i5 <= 1) {
      return;
    }
    int i2 = this.g;
    int i3 = this.h;
    int i7 = this.a;
    int i4 = this.c;
    int i6 = this.b;
    i7 = (i5 - 1) * (i7 + i3 + i4 * 2) + i2 + i6 * 2;
    if (this.n == 0)
    {
      d1 = (i1 - i7) / 2.0F + i6 + i2 / 2;
      Double.isNaN(d1);
    }
    else
    {
      d1 = (i1 - i7) / 2.0F + i4 + i3 / 2;
      Double.isNaN(d1);
    }
    i1 = (int)(d1 + 0.5D);
    double d1 = getHeight() / 2.0F;
    Double.isNaN(d1);
    i6 = (int)(d1 + 0.5D);
    i2 = 0;
    while (i2 < i5) {
      if (i2 == this.n)
      {
        paramCanvas.drawCircle(i1, i6, this.b, this.k);
        i1 += this.a + this.c + this.b + (this.h + this.g) / 2;
        i2 += 1;
      }
      else
      {
        paramCanvas.drawCircle(i1, i6, this.c, this.m);
        i4 = i2 + 1;
        if (i4 == this.n)
        {
          i2 = this.a + this.c + this.b;
          i3 = (this.h + this.g) / 2;
        }
        else
        {
          i2 = this.a + this.c * 2;
          i3 = this.h;
        }
        i1 += i2 + i3;
        i2 = i4;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i2 = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i2 == 1073741824)
    {
      if (i1 == 1073741824) {
        break label137;
      }
      i1 = this.d * 2;
      paramInt2 = this.i;
    }
    else
    {
      paramInt1 = getRealCount();
      i2 = this.g;
      int i3 = this.h;
      int i4 = this.a;
      int i5 = this.c;
      paramInt1 = this.b * 2 + (i2 + (paramInt1 - 1) * (i3 + i4 + i5 * 2));
      if (i1 == 1073741824) {
        break label137;
      }
      i1 = this.d * 2;
      paramInt2 = this.i;
    }
    paramInt2 = i1 + paramInt2;
    label137:
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt >= getRealCount()) {
      i1 = getRealCount() - 1;
    }
    if (getRealCount() > 0) {
      this.n = (i1 % getRealCount());
    } else {
      this.n = -1;
    }
    invalidate();
  }
  
  public void setCurrentItem(int paramInt)
  {
    onPageSelected(paramInt);
  }
  
  public void setMaxCount(int paramInt)
  {
    this.p = paramInt;
    invalidate();
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    if ((paramViewPager != null) && (paramViewPager.getAdapter() != null))
    {
      paramViewPager.removeOnPageChangeListener(this);
      paramViewPager.addOnPageChangeListener(this);
      this.o = paramViewPager;
      paramViewPager.getAdapter().registerDataSetObserver(new SimpleCircleIndicator.1(this, paramViewPager));
      setCurrentItem(0);
      return;
    }
    throw new IllegalStateException("you must initial the viewpager with adapter");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.widget.SimpleCircleIndicator
 * JD-Core Version:    0.7.0.1
 */