package com.tencent.mobileqq.location.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.widget.ISlidePanelListener;
import com.tencent.mobileqq.widget.SlideBottomPanel;
import com.tencent.qphone.base.util.QLog;

public class PoiSlideBottomPanel
  extends SlideBottomPanel
{
  private View a;
  private View b;
  private int g;
  
  public PoiSlideBottomPanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PoiSlideBottomPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PoiSlideBottomPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_g_of_type_Int = 2;
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void a()
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      View localView = findViewWithTag(Integer.valueOf(1));
      float f1 = localView.getY();
      float f2 = this.jdField_b_of_type_Int;
      float f3 = this.i;
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { localView.getY(), this.jdField_b_of_type_Int - this.i }).setDuration(this.jdField_c_of_type_Int);
      localValueAnimator.setTarget(localView);
      localValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      localValueAnimator.addUpdateListener(new PoiSlideBottomPanel.2(this, localView, f1, f2 - f3));
      localValueAnimator.addListener(new PoiSlideBottomPanel.3(this));
      localValueAnimator.start();
      this.jdField_b_of_type_Boolean = true;
      this.jdField_e_of_type_Boolean = false;
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener == null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener.displayPanel();
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_d_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        f();
        if (this.jdField_b_of_type_AndroidViewView == null) {
          this.jdField_b_of_type_AndroidViewView = findViewWithTag(Integer.valueOf(1));
        }
        if ((!this.jdField_c_of_type_Boolean) && (Math.abs(paramMotionEvent.getY() - this.jdField_f_of_type_Float) > this.jdField_d_of_type_Float))
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_g_of_type_Float = paramMotionEvent.getY();
          this.jdField_b_of_type_AndroidViewView.addOnLayoutChangeListener(new PoiSlideBottomPanel.1(this));
        }
        if (QLog.isColorLevel()) {
          QLog.d("PoiSlideBottomPanel", 2, "[panel] handleActionDown: invoked. isDragging: " + this.jdField_c_of_type_Boolean + " Math.abs(event.getY() - firstDownY): " + Math.abs(paramMotionEvent.getY() - this.jdField_f_of_type_Float) + " mTouchSlop: " + this.jdField_d_of_type_Float);
        }
      } while (!this.jdField_c_of_type_Boolean);
      this.h = (paramMotionEvent.getY() - this.jdField_g_of_type_Float);
      this.jdField_g_of_type_Float = paramMotionEvent.getY();
      float f = this.jdField_b_of_type_AndroidViewView.getY();
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener != null) && (f > this.jdField_b_of_type_Int - this.i) && (f < this.jdField_b_of_type_Int - this.j))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PoiSlideBottomPanel", 2, "[panel] fadeBackground: invoked. touchingViewY: " + f + " mMeasureHeight: " + this.jdField_b_of_type_Int + " mPanelHeight: " + this.i + " mTitleHeightNoDisplay: " + this.j + " mMeasureHeight - mPanelHeight: " + (this.jdField_b_of_type_Int - this.i) + " mMeasureHeight - mTitleHeightNoDisplay: " + (this.jdField_b_of_type_Int - this.j));
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener.fadeBackground(1.0F - f / (this.jdField_b_of_type_Int - this.j));
      }
      if (this.h + f <= this.jdField_b_of_type_Int - this.i)
      {
        this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom((int)(this.jdField_b_of_type_Int - this.i - f));
        return;
      }
      if (f + this.h < a()) {
        break;
      }
    } while (this.jdField_e_of_type_Boolean);
    if (this.h > this.jdField_e_of_type_Int) {
      this.h = this.jdField_e_of_type_Int;
    }
    this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom((int)this.h);
    return;
    this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom((int)this.h);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 500L) {
      bool2 = bool1;
    }
    do
    {
      return bool2;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_e_of_type_Float = paramMotionEvent.getX();
      float f = paramMotionEvent.getY();
      this.jdField_g_of_type_Float = f;
      this.jdField_f_of_type_Float = f;
      paramMotionEvent = new Rect();
      this.jdField_a_of_type_AndroidViewView.getGlobalVisibleRect(paramMotionEvent);
      bool1 = bool2;
      if (this.jdField_g_of_type_Float > paramMotionEvent.top)
      {
        bool1 = bool2;
        if (this.jdField_g_of_type_Float < paramMotionEvent.bottom) {
          bool1 = true;
        }
      }
      this.jdField_d_of_type_Boolean = bool1;
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("PoiSlideBottomPanel", 2, "[panel] handleActionDown: invoked. firstDownY: " + this.jdField_f_of_type_Float + " actionRect: " + paramMotionEvent + " isConsume: " + bool1);
    return bool1;
  }
  
  public int b()
  {
    return this.jdField_g_of_type_Int;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      View localView = findViewWithTag(Integer.valueOf(1));
      int i = (int)(this.jdField_b_of_type_Int - this.j);
      float f = localView.getY();
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { localView.getY(), this.jdField_b_of_type_Int - this.j });
      localValueAnimator.setInterpolator(this.jdField_b_of_type_AndroidViewAnimationInterpolator);
      localValueAnimator.setTarget(localView);
      localValueAnimator.setDuration(500L);
      localValueAnimator.addUpdateListener(new PoiSlideBottomPanel.4(this, localView, f, i));
      localValueAnimator.addListener(new PoiSlideBottomPanel.5(this));
      localValueAnimator.start();
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener == null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener.hidePanel();
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    f();
    float f;
    if (((!this.jdField_b_of_type_Boolean) && (paramMotionEvent.getY() - this.jdField_f_of_type_Float < 0.0F) && (Math.abs(paramMotionEvent.getY() - this.jdField_f_of_type_Float) > this.k)) || ((this.jdField_c_of_type_Float < 0.0F) && (Math.abs(this.jdField_c_of_type_Float) > Math.abs(this.jdField_b_of_type_Float)) && (Math.abs(this.jdField_c_of_type_Float) > this.jdField_a_of_type_Int)))
    {
      a();
      if (this.jdField_b_of_type_Boolean)
      {
        paramMotionEvent = findViewWithTag(Integer.valueOf(1));
        f = paramMotionEvent.getY();
        if ((f >= this.jdField_b_of_type_Int - this.i) && (f >= this.jdField_b_of_type_Int - this.i + this.k)) {
          break label436;
        }
        ObjectAnimator.ofFloat(paramMotionEvent, "y", new float[] { f, this.jdField_b_of_type_Int - this.i }).setDuration(this.jdField_c_of_type_Int).start();
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      this.h = 0.0F;
      return;
      if ((l1 - l2 < 300L) && (a(this.jdField_e_of_type_Float, this.jdField_f_of_type_Float, paramMotionEvent.getX(), paramMotionEvent.getY()) < jdField_a_of_type_Float + 5.0F))
      {
        if (this.jdField_b_of_type_Boolean)
        {
          b();
          break;
        }
        a();
        this.jdField_g_of_type_Int = 1;
        break;
      }
      if ((this.jdField_b_of_type_Boolean) || (!this.jdField_c_of_type_Boolean)) {
        break;
      }
      int i = (int)(paramMotionEvent.getY() - this.jdField_f_of_type_Float);
      if (((!this.jdField_e_of_type_Boolean) && (i > this.jdField_f_of_type_Int)) || ((this.jdField_e_of_type_Boolean) && (i < 0) && (Math.abs(i) < this.k))) {
        c();
      }
      if ((this.jdField_e_of_type_Boolean) || (i >= 0) || (Math.abs(i) >= this.k)) {
        break;
      }
      paramMotionEvent = findViewWithTag(Integer.valueOf(1));
      ObjectAnimator.ofFloat(paramMotionEvent, "y", new float[] { paramMotionEvent.getY(), this.jdField_b_of_type_Int - this.j }).setDuration(this.jdField_c_of_type_Int).start();
      break;
      label436:
      if (f > this.jdField_b_of_type_Int - this.i + this.k) {
        b();
      }
    }
  }
  
  public void setBottomHeight(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setDisplayFromType(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
  }
  
  public void setDragView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void setTitleHeightNoDisplay(int paramInt)
  {
    this.j = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.PoiSlideBottomPanel
 * JD-Core Version:    0.7.0.1
 */