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
  private int jdField_a_of_type_Int = 30;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k = -1;
  
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
      this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(0, 40);
      this.jdField_b_of_type_Int = paramContext.getDimensionPixelSize(3, 10);
      this.c = paramContext.getDimensionPixelSize(7, 10);
      this.h = paramContext.getColor(2, -65536);
      this.i = paramContext.getColor(6, -1);
      this.e = paramContext.getDimensionPixelSize(4, 1);
      this.f = paramContext.getDimensionPixelSize(8, 1);
      this.jdField_a_of_type_Boolean = paramContext.getBoolean(1, false);
      this.jdField_b_of_type_Boolean = paramContext.getBoolean(5, false);
      paramContext.recycle();
    }
    this.d = Math.max(this.jdField_b_of_type_Int, this.c);
    this.g = Math.max(this.e, this.f);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    paramAttributeSet = this.jdField_a_of_type_AndroidGraphicsPaint;
    if (this.jdField_a_of_type_Boolean) {
      paramContext = Paint.Style.STROKE;
    } else {
      paramContext = Paint.Style.FILL;
    }
    paramAttributeSet.setStyle(paramContext);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.e);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.h);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    paramAttributeSet = this.jdField_b_of_type_AndroidGraphicsPaint;
    if (this.jdField_b_of_type_Boolean) {
      paramContext = Paint.Style.STROKE;
    } else {
      paramContext = Paint.Style.FILL;
    }
    paramAttributeSet.setStyle(paramContext);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.f);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.i);
  }
  
  private int b()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager == null) {
        return 0;
      }
      int m = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getAdapter().getCount();
      if ((a() > 0) && (a() < m))
      {
        m = a();
        return m;
      }
      return m;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public int a()
  {
    return this.k;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int m = getWidth();
    int i3 = b();
    if (i3 <= 1) {
      return;
    }
    int n = this.e;
    int i1 = this.f;
    int i5 = this.jdField_a_of_type_Int;
    int i2 = this.c;
    int i4 = this.jdField_b_of_type_Int;
    i5 = (i3 - 1) * (i5 + i1 + i2 * 2) + n + i4 * 2;
    if (this.j == 0)
    {
      d1 = (m - i5) / 2.0F + i4 + n / 2;
      Double.isNaN(d1);
    }
    else
    {
      d1 = (m - i5) / 2.0F + i2 + i1 / 2;
      Double.isNaN(d1);
    }
    m = (int)(d1 + 0.5D);
    double d1 = getHeight() / 2.0F;
    Double.isNaN(d1);
    i4 = (int)(d1 + 0.5D);
    n = 0;
    while (n < i3) {
      if (n == this.j)
      {
        paramCanvas.drawCircle(m, i4, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
        m += this.jdField_a_of_type_Int + this.c + this.jdField_b_of_type_Int + (this.f + this.e) / 2;
        n += 1;
      }
      else
      {
        paramCanvas.drawCircle(m, i4, this.c, this.jdField_b_of_type_AndroidGraphicsPaint);
        i2 = n + 1;
        if (i2 == this.j)
        {
          n = this.jdField_a_of_type_Int + this.c + this.jdField_b_of_type_Int;
          i1 = (this.f + this.e) / 2;
        }
        else
        {
          n = this.jdField_a_of_type_Int + this.c * 2;
          i1 = this.f;
        }
        m += n + i1;
        n = i2;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int n = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (n == 1073741824)
    {
      if (m == 1073741824) {
        break label137;
      }
      m = this.d * 2;
      paramInt2 = this.g;
    }
    else
    {
      paramInt1 = b();
      n = this.e;
      int i1 = this.f;
      int i2 = this.jdField_a_of_type_Int;
      int i3 = this.c;
      paramInt1 = this.jdField_b_of_type_Int * 2 + (n + (paramInt1 - 1) * (i1 + i2 + i3 * 2));
      if (m == 1073741824) {
        break label137;
      }
      m = this.d * 2;
      paramInt2 = this.g;
    }
    paramInt2 = m + paramInt2;
    label137:
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    int m = paramInt;
    if (paramInt >= b()) {
      m = b() - 1;
    }
    if (b() > 0) {
      this.j = (m % b());
    } else {
      this.j = -1;
    }
    invalidate();
  }
  
  public void setCurrentItem(int paramInt)
  {
    onPageSelected(paramInt);
  }
  
  public void setMaxCount(int paramInt)
  {
    this.k = paramInt;
    invalidate();
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    if ((paramViewPager != null) && (paramViewPager.getAdapter() != null))
    {
      paramViewPager.removeOnPageChangeListener(this);
      paramViewPager.addOnPageChangeListener(this);
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = paramViewPager;
      paramViewPager.getAdapter().registerDataSetObserver(new SimpleCircleIndicator.1(this, paramViewPager));
      setCurrentItem(0);
      return;
    }
    throw new IllegalStateException("you must initial the viewpager with adapter");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.widget.SimpleCircleIndicator
 * JD-Core Version:    0.7.0.1
 */