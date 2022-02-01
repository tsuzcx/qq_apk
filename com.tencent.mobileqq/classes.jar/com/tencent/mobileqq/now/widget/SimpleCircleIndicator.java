package com.tencent.mobileqq.now.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import ayqw;
import com.tencent.mobileqq.R.styleable;

public class SimpleCircleIndicator
  extends View
  implements IPageIndicator
{
  private int jdField_a_of_type_Int = 30;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
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
    if (this.jdField_a_of_type_Boolean)
    {
      paramContext = Paint.Style.STROKE;
      paramAttributeSet.setStyle(paramContext);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.e);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.h);
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
      paramAttributeSet = this.jdField_b_of_type_AndroidGraphicsPaint;
      if (!this.jdField_b_of_type_Boolean) {
        break label296;
      }
    }
    label296:
    for (paramContext = Paint.Style.STROKE;; paramContext = Paint.Style.FILL)
    {
      paramAttributeSet.setStyle(paramContext);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.f);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.i);
      return;
      paramContext = Paint.Style.FILL;
      break;
    }
  }
  
  private int b()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) {
        return 0;
      }
      int n = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter().getCount();
      m = n;
      if (a() > 0)
      {
        m = n;
        if (a() < n) {
          m = a();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int m = 0;
      }
    }
    return m;
  }
  
  public int a()
  {
    return this.k;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int m = getWidth();
    int i1 = b();
    if (i1 <= 1) {}
    label283:
    for (;;)
    {
      return;
      int n = this.e + (i1 - 1) * (this.f + this.jdField_a_of_type_Int + this.c * 2) + this.jdField_b_of_type_Int * 2;
      int i2;
      if (this.j == 0)
      {
        m = (int)((m - n) / 2.0F + this.jdField_b_of_type_Int + this.e / 2 + 0.5D);
        i2 = (int)(getHeight() / 2.0F + 0.5D);
        n = 0;
      }
      for (;;)
      {
        if (n >= i1) {
          break label283;
        }
        if (n == this.j)
        {
          paramCanvas.drawCircle(m, i2, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
          m += this.jdField_a_of_type_Int + this.c + this.jdField_b_of_type_Int + (this.f + this.e) / 2;
          n += 1;
          continue;
          m = (int)((m - n) / 2.0F + this.c + this.f / 2 + 0.5D);
          break;
        }
        paramCanvas.drawCircle(m, i2, this.c, this.jdField_b_of_type_AndroidGraphicsPaint);
        n += 1;
        if (n == this.j) {
          m += this.jdField_a_of_type_Int + this.c + this.jdField_b_of_type_Int + (this.f + this.e) / 2;
        } else {
          m += this.jdField_a_of_type_Int + this.c * 2 + this.f;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if (i1 == 1073741824) {
      if (n == 1073741824) {
        paramInt2 = m;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt1 = this.d * 2 + this.g;
      paramInt2 = m;
      continue;
      paramInt2 = b();
      m = this.e;
      m = (paramInt2 - 1) * (this.f + this.jdField_a_of_type_Int + this.c * 2) + m + this.jdField_b_of_type_Int * 2;
      paramInt2 = m;
      if (n != 1073741824)
      {
        paramInt1 = this.d * 2 + this.g;
        paramInt2 = m;
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    int m = paramInt;
    if (paramInt >= b()) {
      m = b() - 1;
    }
    if (b() > 0) {}
    for (this.j = (m % b());; this.j = -1)
    {
      invalidate();
      return;
    }
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
    if ((paramViewPager == null) || (paramViewPager.getAdapter() == null)) {
      throw new IllegalStateException("you must initial the viewpager with adapter");
    }
    paramViewPager.removeOnPageChangeListener(this);
    paramViewPager.addOnPageChangeListener(this);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
    paramViewPager.getAdapter().registerDataSetObserver(new ayqw(this, paramViewPager));
    setCurrentItem(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.widget.SimpleCircleIndicator
 * JD-Core Version:    0.7.0.1
 */