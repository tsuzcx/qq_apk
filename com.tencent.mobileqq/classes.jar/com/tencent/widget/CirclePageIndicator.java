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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener;
  private ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private final Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = -1.0F;
  private int jdField_c_of_type_Int;
  private final Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  private int f;
  private int g = -1;
  
  public CirclePageIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CirclePageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131034113);
  }
  
  public CirclePageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode()) {
      return;
    }
    Object localObject = getResources();
    int i = ((Resources)localObject).getColor(2131165589);
    int j = ((Resources)localObject).getColor(2131165588);
    int k = ((Resources)localObject).getColor(2131165590);
    float f1 = ((Resources)localObject).getDimension(2131296868);
    float f2 = ((Resources)localObject).getDimension(2131296867);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CirclePageIndicator, paramInt, 0);
    this.jdField_a_of_type_Boolean = paramAttributeSet.getBoolean(2, true);
    this.d = paramAttributeSet.getInt(0, 0);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramAttributeSet.getColor(5, i));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramAttributeSet.getColor(7, k));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(paramAttributeSet.getDimension(8, f1));
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(paramAttributeSet.getColor(4, j));
    this.jdField_a_of_type_Float = paramAttributeSet.getDimension(3, f2);
    this.jdField_b_of_type_Boolean = paramAttributeSet.getBoolean(6, false);
    localObject = paramAttributeSet.getDrawable(1);
    if (localObject != null) {
      setBackgroundDrawable((Drawable)localObject);
    }
    paramAttributeSet.recycle();
    this.f = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(paramContext));
  }
  
  private int a(int paramInt)
  {
    int j = View.MeasureSpec.getMode(paramInt);
    int i = View.MeasureSpec.getSize(paramInt);
    paramInt = i;
    if (j != 1073741824)
    {
      ViewPager localViewPager = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
      if (localViewPager == null) {
        return i;
      }
      paramInt = localViewPager.getAdapter().getCount();
      float f1 = getPaddingLeft() + getPaddingRight();
      float f2 = paramInt * 2;
      float f3 = this.jdField_a_of_type_Float;
      paramInt = (int)(f1 + f2 * f3 + (paramInt - 1) * f3 + 1.0F);
      if (j == -2147483648) {
        return Math.min(paramInt, i);
      }
    }
    return paramInt;
  }
  
  private int b(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {
      return paramInt;
    }
    int j = (int)(this.jdField_a_of_type_Float * 2.0F + getPaddingTop() + getPaddingBottom() + 1.0F);
    if (i == -2147483648) {
      return Math.min(j, paramInt);
    }
    return j;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    ViewPager localViewPager = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
    if (localViewPager == null) {
      return;
    }
    int n = localViewPager.getAdapter().getCount();
    if (n == 0) {
      return;
    }
    if (this.jdField_a_of_type_Int >= n)
    {
      setCurrentItem(n - 1);
      return;
    }
    int j;
    int k;
    int m;
    if (this.d == 0)
    {
      i = getWidth();
      j = getPaddingLeft();
      k = getPaddingRight();
      m = getPaddingTop();
    }
    else
    {
      i = getHeight();
      j = getPaddingTop();
      k = getPaddingBottom();
      m = getPaddingLeft();
    }
    float f2 = this.jdField_a_of_type_Float;
    int i1 = this.e;
    if (i1 == 0) {
      f1 = f2;
    } else {
      f1 = i1;
    }
    float f6 = f2 * 2.0F + f1;
    float f1 = m;
    f2 = this.jdField_a_of_type_Float;
    f1 += f2;
    float f3 = j + f2;
    f2 = f3;
    if (this.jdField_a_of_type_Boolean) {
      f2 = f3 + ((i - j - k) / 2.0F - n * f6 / 2.0F);
    }
    float f4 = this.jdField_a_of_type_Float;
    f3 = f4;
    if (this.jdField_b_of_type_AndroidGraphicsPaint.getStrokeWidth() > 0.0F) {
      f3 = f4 - this.jdField_b_of_type_AndroidGraphicsPaint.getStrokeWidth() / 2.0F;
    }
    int i = 0;
    while (i < n)
    {
      f4 = i * f6 + f2;
      float f5;
      if (this.d == 0)
      {
        f5 = f1;
      }
      else
      {
        f5 = f4;
        f4 = f1;
      }
      if (this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha() > 0) {
        paramCanvas.drawCircle(f4, f5, f3, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      float f7 = this.jdField_a_of_type_Float;
      if (f3 != f7) {
        paramCanvas.drawCircle(f4, f5, f7, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      i += 1;
    }
    if (this.jdField_b_of_type_Boolean) {
      i = this.jdField_b_of_type_Int;
    } else {
      i = this.jdField_a_of_type_Int;
    }
    f4 = i * f6;
    f3 = f4;
    if (!this.jdField_b_of_type_Boolean) {
      f3 = f4 + this.jdField_b_of_type_Float * f6;
    }
    if (this.d == 0)
    {
      f2 = f3 + f2;
      f3 = f1;
    }
    else
    {
      f3 += f2;
      f2 = f1;
    }
    paramCanvas.drawCircle(f2, f3, this.jdField_a_of_type_Float, this.jdField_c_of_type_AndroidGraphicsPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.d == 0)
    {
      setMeasuredDimension(a(paramInt1), b(paramInt2));
      return;
    }
    setMeasuredDimension(b(paramInt1), a(paramInt2));
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Float = paramFloat;
    invalidate();
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Int == 0))
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_b_of_type_Int = paramInt;
      invalidate();
    }
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageSelected(paramInt);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (CirclePageIndicator.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.jdField_a_of_type_Int = paramParcelable.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramParcelable.jdField_a_of_type_Int;
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    CirclePageIndicator.SavedState localSavedState = new CirclePageIndicator.SavedState(super.onSaveInstanceState());
    localSavedState.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (super.onTouchEvent(paramMotionEvent)) {
      return true;
    }
    ViewPager localViewPager = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
    int i = 0;
    if (localViewPager != null)
    {
      if (localViewPager.getAdapter().getCount() == 0) {
        return false;
      }
      int j = paramMotionEvent.getAction() & 0xFF;
      if (j != 0)
      {
        float f1;
        float f2;
        if (j != 1) {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 5)
              {
                if (j != 6) {
                  return true;
                }
                j = MotionEventCompat.getActionIndex(paramMotionEvent);
                if (MotionEventCompat.getPointerId(paramMotionEvent, j) == this.g)
                {
                  if (j == 0) {
                    i = 1;
                  }
                  this.g = MotionEventCompat.getPointerId(paramMotionEvent, i);
                }
                this.jdField_c_of_type_Float = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.g));
                return true;
              }
              i = MotionEventCompat.getActionIndex(paramMotionEvent);
              this.jdField_c_of_type_Float = MotionEventCompat.getX(paramMotionEvent, i);
              this.g = MotionEventCompat.getPointerId(paramMotionEvent, i);
              return true;
            }
          }
          else
          {
            f1 = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.g));
            f2 = f1 - this.jdField_c_of_type_Float;
            if ((!this.jdField_c_of_type_Boolean) && (Math.abs(f2) > this.f)) {
              this.jdField_c_of_type_Boolean = true;
            }
            if (!this.jdField_c_of_type_Boolean) {
              break label418;
            }
            this.jdField_c_of_type_Float = f1;
            if ((!this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.isFakeDragging()) && (!this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.beginFakeDrag())) {
              break label418;
            }
            this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.fakeDragBy(f2);
            return true;
          }
        }
        if (!this.jdField_c_of_type_Boolean)
        {
          i = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getAdapter().getCount();
          f2 = getWidth();
          f1 = f2 / 2.0F;
          f2 /= 6.0F;
          if ((this.jdField_a_of_type_Int > 0) && (paramMotionEvent.getX() < f1 - f2))
          {
            if (j != 3) {
              this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setCurrentItem(this.jdField_a_of_type_Int - 1);
            }
            return true;
          }
          if ((this.jdField_a_of_type_Int < i - 1) && (paramMotionEvent.getX() > f1 + f2))
          {
            if (j != 3) {
              this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setCurrentItem(this.jdField_a_of_type_Int + 1);
            }
            return true;
          }
        }
        this.jdField_c_of_type_Boolean = false;
        this.g = -1;
        if (this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.isFakeDragging())
        {
          this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.endFakeDrag();
          return true;
        }
      }
      else
      {
        this.g = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        this.jdField_c_of_type_Float = paramMotionEvent.getX();
      }
      label418:
      return true;
    }
    return false;
  }
  
  public void setCentered(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setCirclePadding(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setCurrentItem(int paramInt)
  {
    ViewPager localViewPager = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
    if (localViewPager != null)
    {
      localViewPager.setCurrentItem(paramInt);
      this.jdField_a_of_type_Int = paramInt;
      invalidate();
      return;
    }
    throw new IllegalStateException("ViewPager has not been bound.");
  }
  
  public void setFillColor(int paramInt)
  {
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
    }
    this.d = paramInt;
    requestLayout();
  }
  
  public void setPageColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setRadius(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    invalidate();
  }
  
  public void setSnap(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(paramFloat);
    invalidate();
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    ViewPager localViewPager = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
    if (localViewPager == paramViewPager) {
      return;
    }
    if (localViewPager != null) {
      localViewPager.setOnPageChangeListener(null);
    }
    if (paramViewPager.getAdapter() != null)
    {
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = paramViewPager;
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setOnPageChangeListener(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.CirclePageIndicator
 * JD-Core Version:    0.7.0.1
 */