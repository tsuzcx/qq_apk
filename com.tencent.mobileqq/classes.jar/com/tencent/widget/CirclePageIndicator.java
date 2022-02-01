package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.R.styleable;

public class CirclePageIndicator
  extends View
  implements PageIndicator
{
  private float a;
  private final Paint b = new Paint(1);
  private final Paint c = new Paint(1);
  private final Paint d = new Paint(1);
  private ViewPager e;
  private ViewPager.OnPageChangeListener f;
  private int g;
  private int h;
  private float i;
  private int j;
  private int k;
  private boolean l;
  private boolean m;
  private int n;
  private int o;
  private float p = -1.0F;
  private int q = -1;
  private boolean r;
  
  public CirclePageIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CirclePageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131034120);
  }
  
  public CirclePageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode()) {
      return;
    }
    Object localObject = getResources();
    int i1 = ((Resources)localObject).getColor(2131165938);
    int i2 = ((Resources)localObject).getColor(2131168104);
    int i3 = ((Resources)localObject).getColor(2131165939);
    float f1 = ((Resources)localObject).getDimension(2131297199);
    float f2 = ((Resources)localObject).getDimension(2131297198);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CirclePageIndicator, paramInt, 0);
    this.l = paramAttributeSet.getBoolean(2, true);
    this.k = paramAttributeSet.getInt(0, 0);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setColor(paramAttributeSet.getColor(5, i1));
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setColor(paramAttributeSet.getColor(7, i3));
    this.c.setStrokeWidth(paramAttributeSet.getDimension(8, f1));
    this.d.setStyle(Paint.Style.FILL);
    this.d.setColor(paramAttributeSet.getColor(4, i2));
    this.a = paramAttributeSet.getDimension(3, f2);
    this.m = paramAttributeSet.getBoolean(6, false);
    localObject = paramAttributeSet.getDrawable(1);
    if (localObject != null) {
      setBackgroundDrawable((Drawable)localObject);
    }
    paramAttributeSet.recycle();
    this.o = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(paramContext));
  }
  
  private int a(int paramInt)
  {
    int i2 = View.MeasureSpec.getMode(paramInt);
    int i1 = View.MeasureSpec.getSize(paramInt);
    paramInt = i1;
    if (i2 != 1073741824)
    {
      ViewPager localViewPager = this.e;
      if (localViewPager == null) {
        return i1;
      }
      paramInt = localViewPager.getAdapter().getCount();
      float f1 = getPaddingLeft() + getPaddingRight();
      float f2 = paramInt * 2;
      float f3 = this.a;
      paramInt = (int)(f1 + f2 * f3 + (paramInt - 1) * f3 + 1.0F);
      if (i2 == -2147483648) {
        return Math.min(paramInt, i1);
      }
    }
    return paramInt;
  }
  
  private int b(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i1 == 1073741824) {
      return paramInt;
    }
    int i2 = (int)(this.a * 2.0F + getPaddingTop() + getPaddingBottom() + 1.0F);
    if (i1 == -2147483648) {
      return Math.min(i2, paramInt);
    }
    return i2;
  }
  
  public int getCirclePadding()
  {
    return this.n;
  }
  
  public int getFillColor()
  {
    return this.d.getColor();
  }
  
  public int getOrientation()
  {
    return this.k;
  }
  
  public int getPageColor()
  {
    return this.b.getColor();
  }
  
  public float getRadius()
  {
    return this.a;
  }
  
  public int getStrokeColor()
  {
    return this.c.getColor();
  }
  
  public float getStrokeWidth()
  {
    return this.c.getStrokeWidth();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    ViewPager localViewPager = this.e;
    if (localViewPager == null) {
      return;
    }
    int i5 = localViewPager.getAdapter().getCount();
    if (i5 == 0) {
      return;
    }
    if (this.g >= i5)
    {
      setCurrentItem(i5 - 1);
      return;
    }
    int i2;
    int i3;
    int i4;
    if (this.k == 0)
    {
      i1 = getWidth();
      i2 = getPaddingLeft();
      i3 = getPaddingRight();
      i4 = getPaddingTop();
    }
    else
    {
      i1 = getHeight();
      i2 = getPaddingTop();
      i3 = getPaddingBottom();
      i4 = getPaddingLeft();
    }
    float f2 = this.a;
    int i6 = this.n;
    if (i6 == 0) {
      f1 = f2;
    } else {
      f1 = i6;
    }
    float f6 = f2 * 2.0F + f1;
    float f1 = i4;
    f2 = this.a;
    f1 += f2;
    float f3 = i2 + f2;
    f2 = f3;
    if (this.l) {
      f2 = f3 + ((i1 - i2 - i3) / 2.0F - i5 * f6 / 2.0F);
    }
    float f4 = this.a;
    f3 = f4;
    if (this.c.getStrokeWidth() > 0.0F) {
      f3 = f4 - this.c.getStrokeWidth() / 2.0F;
    }
    int i1 = 0;
    while (i1 < i5)
    {
      f4 = i1 * f6 + f2;
      float f5;
      if (this.k == 0)
      {
        f5 = f1;
      }
      else
      {
        f5 = f4;
        f4 = f1;
      }
      if (this.b.getAlpha() > 0) {
        paramCanvas.drawCircle(f4, f5, f3, this.b);
      }
      float f7 = this.a;
      if (f3 != f7) {
        paramCanvas.drawCircle(f4, f5, f7, this.c);
      }
      i1 += 1;
    }
    if (this.m) {
      i1 = this.h;
    } else {
      i1 = this.g;
    }
    f4 = i1 * f6;
    f3 = f4;
    if (!this.m) {
      f3 = f4 + this.i * f6;
    }
    if (this.k == 0)
    {
      f2 = f3 + f2;
      f3 = f1;
    }
    else
    {
      f3 += f2;
      f2 = f1;
    }
    paramCanvas.drawCircle(f2, f3, this.a, this.d);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.k == 0)
    {
      setMeasuredDimension(a(paramInt1), b(paramInt2));
      return;
    }
    setMeasuredDimension(b(paramInt1), a(paramInt2));
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.j = paramInt;
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.f;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.g = paramInt1;
    this.i = paramFloat;
    invalidate();
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.f;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if ((this.m) || (this.j == 0))
    {
      this.g = paramInt;
      this.h = paramInt;
      invalidate();
    }
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.f;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageSelected(paramInt);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (CirclePageIndicator.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.g = paramParcelable.a;
    this.h = paramParcelable.a;
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    CirclePageIndicator.SavedState localSavedState = new CirclePageIndicator.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.g;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (super.onTouchEvent(paramMotionEvent)) {
      return true;
    }
    ViewPager localViewPager = this.e;
    int i1 = 0;
    if (localViewPager != null)
    {
      if (localViewPager.getAdapter().getCount() == 0) {
        return false;
      }
      int i2 = paramMotionEvent.getAction() & 0xFF;
      if (i2 != 0)
      {
        float f1;
        float f2;
        if (i2 != 1) {
          if (i2 != 2)
          {
            if (i2 != 3)
            {
              if (i2 != 5)
              {
                if (i2 != 6) {
                  return true;
                }
                i2 = MotionEventCompat.getActionIndex(paramMotionEvent);
                if (MotionEventCompat.getPointerId(paramMotionEvent, i2) == this.q)
                {
                  if (i2 == 0) {
                    i1 = 1;
                  }
                  this.q = MotionEventCompat.getPointerId(paramMotionEvent, i1);
                }
                this.p = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.q));
                return true;
              }
              i1 = MotionEventCompat.getActionIndex(paramMotionEvent);
              this.p = MotionEventCompat.getX(paramMotionEvent, i1);
              this.q = MotionEventCompat.getPointerId(paramMotionEvent, i1);
              return true;
            }
          }
          else
          {
            f1 = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.q));
            f2 = f1 - this.p;
            if ((!this.r) && (Math.abs(f2) > this.o)) {
              this.r = true;
            }
            if (!this.r) {
              break label418;
            }
            this.p = f1;
            if ((!this.e.isFakeDragging()) && (!this.e.beginFakeDrag())) {
              break label418;
            }
            this.e.fakeDragBy(f2);
            return true;
          }
        }
        if (!this.r)
        {
          i1 = this.e.getAdapter().getCount();
          f2 = getWidth();
          f1 = f2 / 2.0F;
          f2 /= 6.0F;
          if ((this.g > 0) && (paramMotionEvent.getX() < f1 - f2))
          {
            if (i2 != 3) {
              this.e.setCurrentItem(this.g - 1);
            }
            return true;
          }
          if ((this.g < i1 - 1) && (paramMotionEvent.getX() > f1 + f2))
          {
            if (i2 != 3) {
              this.e.setCurrentItem(this.g + 1);
            }
            return true;
          }
        }
        this.r = false;
        this.q = -1;
        if (this.e.isFakeDragging())
        {
          this.e.endFakeDrag();
          return true;
        }
      }
      else
      {
        this.q = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        this.p = paramMotionEvent.getX();
      }
      label418:
      return true;
    }
    return false;
  }
  
  public void setCentered(boolean paramBoolean)
  {
    this.l = paramBoolean;
    invalidate();
  }
  
  public void setCirclePadding(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setCurrentItem(int paramInt)
  {
    ViewPager localViewPager = this.e;
    if (localViewPager != null)
    {
      localViewPager.setCurrentItem(paramInt);
      this.g = paramInt;
      invalidate();
      return;
    }
    throw new IllegalStateException("ViewPager has not been bound.");
  }
  
  public void setFillColor(int paramInt)
  {
    this.d.setColor(paramInt);
    invalidate();
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.f = paramOnPageChangeListener;
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
    }
    this.k = paramInt;
    requestLayout();
  }
  
  public void setPageColor(int paramInt)
  {
    this.b.setColor(paramInt);
    invalidate();
  }
  
  public void setRadius(float paramFloat)
  {
    this.a = paramFloat;
    invalidate();
  }
  
  public void setSnap(boolean paramBoolean)
  {
    this.m = paramBoolean;
    invalidate();
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.c.setColor(paramInt);
    invalidate();
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this.c.setStrokeWidth(paramFloat);
    invalidate();
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    ViewPager localViewPager = this.e;
    if (localViewPager == paramViewPager) {
      return;
    }
    if (localViewPager != null) {
      localViewPager.setOnPageChangeListener(null);
    }
    if (paramViewPager.getAdapter() != null)
    {
      this.e = paramViewPager;
      this.e.setOnPageChangeListener(this);
      invalidate();
      return;
    }
    throw new IllegalStateException("ViewPager does not have adapter instance.");
  }
  
  public void setViewPager(ViewPager paramViewPager, int paramInt)
  {
    setViewPager(paramViewPager);
    setCurrentItem(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.CirclePageIndicator
 * JD-Core Version:    0.7.0.1
 */