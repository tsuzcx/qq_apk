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
    if (!this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
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
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener.displayPanel();
      }
    }
  }
  
  protected void a(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[panel] handleActionDown: invoked. isDragging: ");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      localStringBuilder.append(" Math.abs(event.getY() - firstDownY): ");
      localStringBuilder.append(Math.abs(paramMotionEvent.getY() - this.jdField_f_of_type_Float));
      localStringBuilder.append(" mTouchSlop: ");
      localStringBuilder.append(this.jdField_d_of_type_Float);
      QLog.d("PoiSlideBottomPanel", 2, localStringBuilder.toString());
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.h = (paramMotionEvent.getY() - this.jdField_g_of_type_Float);
      this.jdField_g_of_type_Float = paramMotionEvent.getY();
      float f = this.jdField_b_of_type_AndroidViewView.getY();
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener != null) && (f > this.jdField_b_of_type_Int - this.i) && (f < this.jdField_b_of_type_Int - this.j))
      {
        if (QLog.isColorLevel())
        {
          paramMotionEvent = new StringBuilder();
          paramMotionEvent.append("[panel] fadeBackground: invoked. touchingViewY: ");
          paramMotionEvent.append(f);
          paramMotionEvent.append(" mMeasureHeight: ");
          paramMotionEvent.append(this.jdField_b_of_type_Int);
          paramMotionEvent.append(" mPanelHeight: ");
          paramMotionEvent.append(this.i);
          paramMotionEvent.append(" mTitleHeightNoDisplay: ");
          paramMotionEvent.append(this.j);
          paramMotionEvent.append(" mMeasureHeight - mPanelHeight: ");
          paramMotionEvent.append(this.jdField_b_of_type_Int - this.i);
          paramMotionEvent.append(" mMeasureHeight - mTitleHeightNoDisplay: ");
          paramMotionEvent.append(this.jdField_b_of_type_Int - this.j);
          QLog.d("PoiSlideBottomPanel", 2, paramMotionEvent.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener.fadeBackground(1.0F - f / (this.jdField_b_of_type_Int - this.j));
      }
      if (this.h + f <= this.jdField_b_of_type_Int - this.i)
      {
        this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom((int)(this.jdField_b_of_type_Int - this.i - f));
        return;
      }
      if (f + this.h >= a())
      {
        if (this.jdField_e_of_type_Boolean) {
          return;
        }
        if (this.h > this.jdField_e_of_type_Int) {
          this.h = this.jdField_e_of_type_Int;
        }
        this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom((int)this.h);
        return;
      }
      this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom((int)this.h);
    }
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    boolean bool2 = false;
    if (l1 - l2 <= 500L) {
      return false;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_e_of_type_Float = paramMotionEvent.getX();
    float f = paramMotionEvent.getY();
    this.jdField_g_of_type_Float = f;
    this.jdField_f_of_type_Float = f;
    paramMotionEvent = new Rect();
    this.jdField_a_of_type_AndroidViewView.getGlobalVisibleRect(paramMotionEvent);
    boolean bool1 = bool2;
    if (this.jdField_g_of_type_Float > paramMotionEvent.top)
    {
      bool1 = bool2;
      if (this.jdField_g_of_type_Float < paramMotionEvent.bottom) {
        bool1 = true;
      }
    }
    this.jdField_d_of_type_Boolean = bool1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[panel] handleActionDown: invoked. firstDownY: ");
      localStringBuilder.append(this.jdField_f_of_type_Float);
      localStringBuilder.append(" actionRect: ");
      localStringBuilder.append(paramMotionEvent);
      localStringBuilder.append(" isConsume: ");
      localStringBuilder.append(bool1);
      QLog.d("PoiSlideBottomPanel", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public int b()
  {
    return this.jdField_g_of_type_Int;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener.hidePanel();
    }
  }
  
  protected void b(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    f();
    if (((!this.jdField_b_of_type_Boolean) && (paramMotionEvent.getY() - this.jdField_f_of_type_Float < 0.0F) && (Math.abs(paramMotionEvent.getY() - this.jdField_f_of_type_Float) > this.k)) || ((this.jdField_c_of_type_Float < 0.0F) && (Math.abs(this.jdField_c_of_type_Float) > Math.abs(this.jdField_b_of_type_Float)) && (Math.abs(this.jdField_c_of_type_Float) > this.jdField_a_of_type_Int)))
    {
      a();
    }
    else if ((l1 - l2 < 300L) && (a(this.jdField_e_of_type_Float, this.jdField_f_of_type_Float, paramMotionEvent.getX(), paramMotionEvent.getY()) < jdField_a_of_type_Float + 5.0F))
    {
      if (this.jdField_b_of_type_Boolean)
      {
        b();
      }
      else
      {
        a();
        this.jdField_g_of_type_Int = 1;
      }
    }
    else if ((!this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      int i = (int)(paramMotionEvent.getY() - this.jdField_f_of_type_Float);
      if (((!this.jdField_e_of_type_Boolean) && (i > this.jdField_f_of_type_Int)) || ((this.jdField_e_of_type_Boolean) && (i < 0) && (Math.abs(i) < this.k))) {
        c();
      }
      if ((!this.jdField_e_of_type_Boolean) && (i < 0) && (Math.abs(i) < this.k))
      {
        paramMotionEvent = findViewWithTag(Integer.valueOf(1));
        ObjectAnimator.ofFloat(paramMotionEvent, "y", new float[] { paramMotionEvent.getY(), this.jdField_b_of_type_Int - this.j }).setDuration(this.jdField_c_of_type_Int).start();
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      paramMotionEvent = findViewWithTag(Integer.valueOf(1));
      float f = paramMotionEvent.getY();
      if ((f >= this.jdField_b_of_type_Int - this.i) && (f >= this.jdField_b_of_type_Int - this.i + this.k))
      {
        if (f > this.jdField_b_of_type_Int - this.i + this.k) {
          b();
        }
      }
      else {
        ObjectAnimator.ofFloat(paramMotionEvent, "y", new float[] { f, this.jdField_b_of_type_Int - this.i }).setDuration(this.jdField_c_of_type_Int).start();
      }
    }
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.h = 0.0F;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.PoiSlideBottomPanel
 * JD-Core Version:    0.7.0.1
 */