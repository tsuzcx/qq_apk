package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.R.styleable;

public class CirclePageIndicator
  extends View
  implements PageIndicator
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
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
    int i = ((Resources)localObject).getColor(2131165604);
    int j = ((Resources)localObject).getColor(2131165603);
    int k = ((Resources)localObject).getColor(2131165605);
    float f1 = ((Resources)localObject).getDimension(2131296867);
    float f2 = ((Resources)localObject).getDimension(2131296866);
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
    int k = View.MeasureSpec.getMode(paramInt);
    int i = View.MeasureSpec.getSize(paramInt);
    if ((k == 1073741824) || (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null)) {
      paramInt = i;
    }
    int j;
    do
    {
      return paramInt;
      paramInt = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter().getCount();
      float f1 = getPaddingLeft() + getPaddingRight();
      float f2 = paramInt * 2;
      float f3 = this.jdField_a_of_type_Float;
      j = (int)((paramInt - 1) * this.jdField_a_of_type_Float + (f1 + f2 * f3) + 1.0F);
      paramInt = j;
    } while (k != -2147483648);
    return Math.min(j, i);
  }
  
  private int b(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {
      return paramInt;
    }
    int j = (int)(2.0F * this.jdField_a_of_type_Float + getPaddingTop() + getPaddingBottom() + 1.0F);
    if (i == -2147483648) {
      return Math.min(j, paramInt);
    }
    return j;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) {}
    int n;
    do
    {
      return;
      n = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter().getCount();
    } while (n == 0);
    if (this.jdField_a_of_type_Int >= n)
    {
      setCurrentItem(n - 1);
      return;
    }
    int m;
    int k;
    int j;
    int i;
    float f2;
    float f1;
    label96:
    float f6;
    float f3;
    float f4;
    label197:
    float f5;
    if (this.d == 0)
    {
      m = getWidth();
      k = getPaddingLeft();
      j = getPaddingRight();
      i = getPaddingTop();
      f2 = this.jdField_a_of_type_Float;
      if (this.e != 0) {
        break label314;
      }
      f1 = this.jdField_a_of_type_Float;
      f6 = f2 * 2.0F + f1;
      f1 = i;
      f1 = this.jdField_a_of_type_Float + f1;
      f3 = k + this.jdField_a_of_type_Float;
      f2 = f3;
      if (this.jdField_a_of_type_Boolean) {
        f2 = f3 + ((m - k - j) / 2.0F - n * f6 / 2.0F);
      }
      f4 = this.jdField_a_of_type_Float;
      f3 = f4;
      if (this.jdField_b_of_type_AndroidGraphicsPaint.getStrokeWidth() > 0.0F) {
        f3 = f4 - this.jdField_b_of_type_AndroidGraphicsPaint.getStrokeWidth() / 2.0F;
      }
      i = 0;
      if (i >= n) {
        break label329;
      }
      f4 = i * f6 + f2;
      if (this.d != 0) {
        break label323;
      }
      f5 = f4;
      f4 = f1;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha() > 0) {
        paramCanvas.drawCircle(f5, f4, f3, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      if (f3 != this.jdField_a_of_type_Float) {
        paramCanvas.drawCircle(f5, f4, this.jdField_a_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      i += 1;
      break label197;
      m = getHeight();
      k = getPaddingTop();
      j = getPaddingBottom();
      i = getPaddingLeft();
      break;
      label314:
      f1 = this.e;
      break label96;
      label323:
      f5 = f1;
    }
    label329:
    if (this.jdField_b_of_type_Boolean)
    {
      i = this.jdField_b_of_type_Int;
      f4 = i * f6;
      f3 = f4;
      if (!this.jdField_b_of_type_Boolean) {
        f3 = f4 + this.jdField_b_of_type_Float * f6;
      }
      if (this.d != 0) {
        break label415;
      }
      f3 = f2 + f3;
      f2 = f1;
      f1 = f3;
    }
    for (;;)
    {
      paramCanvas.drawCircle(f1, f2, this.jdField_a_of_type_Float, this.jdField_c_of_type_AndroidGraphicsPaint);
      return;
      i = this.jdField_a_of_type_Int;
      break;
      label415:
      f2 += f3;
    }
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
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Float = paramFloat;
    invalidate();
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
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
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageSelected(paramInt);
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
    int i = 0;
    if (super.onTouchEvent(paramMotionEvent)) {}
    label317:
    do
    {
      do
      {
        float f1;
        float f2;
        do
        {
          do
          {
            do
            {
              return true;
              if ((this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) || (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter().getCount() == 0)) {
                return false;
              }
              j = paramMotionEvent.getAction() & 0xFF;
              switch (j)
              {
              case 4: 
              default: 
                return true;
              case 0: 
                this.g = MotionEventCompat.getPointerId(paramMotionEvent, 0);
                this.jdField_c_of_type_Float = paramMotionEvent.getX();
                return true;
              case 2: 
                f1 = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.g));
                f2 = f1 - this.jdField_c_of_type_Float;
                if ((!this.jdField_c_of_type_Boolean) && (Math.abs(f2) > this.f)) {
                  this.jdField_c_of_type_Boolean = true;
                }
                break;
              }
            } while (!this.jdField_c_of_type_Boolean);
            this.jdField_c_of_type_Float = f1;
          } while ((!this.jdField_a_of_type_AndroidSupportV4ViewViewPager.isFakeDragging()) && (!this.jdField_a_of_type_AndroidSupportV4ViewViewPager.beginFakeDrag()));
          this.jdField_a_of_type_AndroidSupportV4ViewViewPager.fakeDragBy(f2);
          return true;
          if (this.jdField_c_of_type_Boolean) {
            break label317;
          }
          i = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter().getCount();
          int k = getWidth();
          f1 = k / 2.0F;
          f2 = k / 6.0F;
          if ((this.jdField_a_of_type_Int <= 0) || (paramMotionEvent.getX() >= f1 - f2)) {
            break;
          }
        } while (j == 3);
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(this.jdField_a_of_type_Int - 1);
        return true;
        if ((this.jdField_a_of_type_Int >= i - 1) || (paramMotionEvent.getX() <= f2 + f1)) {
          break;
        }
      } while (j == 3);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(this.jdField_a_of_type_Int + 1);
      return true;
      this.jdField_c_of_type_Boolean = false;
      this.g = -1;
    } while (!this.jdField_a_of_type_AndroidSupportV4ViewViewPager.isFakeDragging());
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.endFakeDrag();
    return true;
    i = MotionEventCompat.getActionIndex(paramMotionEvent);
    this.jdField_c_of_type_Float = MotionEventCompat.getX(paramMotionEvent, i);
    this.g = MotionEventCompat.getPointerId(paramMotionEvent, i);
    return true;
    int j = MotionEventCompat.getActionIndex(paramMotionEvent);
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
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) {
      throw new IllegalStateException("ViewPager has not been bound.");
    }
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(paramInt);
    this.jdField_a_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setFillColor(int paramInt)
  {
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setOrientation(int paramInt)
  {
    switch (paramInt)
    {
    default: 
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
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == paramViewPager) {
      return;
    }
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(null);
    }
    if (paramViewPager.getAdapter() == null) {
      throw new IllegalStateException("ViewPager does not have adapter instance.");
    }
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
    invalidate();
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