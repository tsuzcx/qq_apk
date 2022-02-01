package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class CaptureOperateTouchLayout
  extends FrameLayout
{
  public static int a = 200;
  private static int jdField_b_of_type_Int = -1;
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CaptureOperateTouchLayout.OnCaptureOperateCallback jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout$OnCaptureOperateCallback;
  private VideoMeasureScaleView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoMeasureScaleView;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public CaptureOperateTouchLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    int i = jdField_b_of_type_Int;
    this.jdField_a_of_type_Float = i;
    this.e = i;
    this.f = i;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(BaseApplication.getContext());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout$OnCaptureOperateCallback = null;
  }
  
  public CaptureOperateTouchLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = jdField_b_of_type_Int;
    this.jdField_a_of_type_Float = i;
    this.e = i;
    this.f = i;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(BaseApplication.getContext());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout$OnCaptureOperateCallback = null;
    a();
  }
  
  public CaptureOperateTouchLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramInt = jdField_b_of_type_Int;
    this.jdField_a_of_type_Float = paramInt;
    this.e = paramInt;
    this.f = paramInt;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(BaseApplication.getContext());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout$OnCaptureOperateCallback = null;
    a();
  }
  
  private int a(float paramFloat)
  {
    return (int)(paramFloat * this.d);
  }
  
  private int a(float paramFloat, boolean paramBoolean)
  {
    return (int)Math.min(Math.max(0, b(paramFloat, paramBoolean)), this.jdField_a_of_type_Long);
  }
  
  private void a()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i = getWidth();
    int j = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
    a(paramInt / (i - j), paramBoolean);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i;
    if ((paramMotionEvent.getRawX() >= this.jdField_a_of_type_AndroidWidgetImageView.getX()) && (paramMotionEvent.getRawX() <= this.jdField_a_of_type_AndroidWidgetImageView.getX() + this.jdField_a_of_type_AndroidWidgetImageView.getWidth())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    a((int)(paramMotionEvent.getRawX() - this.jdField_a_of_type_AndroidWidgetImageView.getWidth() / 3), false);
  }
  
  private float b()
  {
    return ((View)this.jdField_a_of_type_AndroidWidgetImageView.getParent()).getRight() - this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
  }
  
  private int b(float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      float f1 = this.jdField_a_of_type_Float;
      float f2 = this.f;
      return (int)(this.e + (paramFloat - f1) * f2);
    }
    return (int)(paramFloat * (float)this.jdField_a_of_type_Long) / 1000 * 1000;
  }
  
  private void b()
  {
    CaptureOperateTouchLayout.OnCaptureOperateCallback localOnCaptureOperateCallback = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout$OnCaptureOperateCallback;
    if (localOnCaptureOperateCallback != null) {
      localOnCaptureOperateCallback.a(a());
    }
  }
  
  public float a()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    float f1 = (getWidth() - this.jdField_a_of_type_AndroidWidgetImageView.getWidth()) * paramFloat;
    this.jdField_b_of_type_Float = paramFloat;
    this.c = a(paramFloat, paramBoolean);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onIndicatorChange percent:");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(" progressX:");
      localStringBuilder.append(f1);
      localStringBuilder.append(" duration:");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append(" videoSeekPosition:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" longPressStartVideoSeekPercent:");
      localStringBuilder.append(this.jdField_a_of_type_Float);
      QLog.d("CaptureOperateTouchLayout", 2, localStringBuilder.toString());
    }
    int i = (this.jdField_a_of_type_AndroidWidgetImageView.getWidth() - this.jdField_a_of_type_AndroidWidgetTextView.getWidth()) / 2;
    this.jdField_a_of_type_AndroidWidgetImageView.setX(f1);
    this.jdField_a_of_type_AndroidWidgetTextView.setX(f1 + i);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(this.c / 1000));
    b();
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      a(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX() / b(), this.jdField_a_of_type_Boolean);
      invalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    requestDisallowInterceptTouchEvent(true);
    if (paramMotionEvent.getAction() == 0) {
      a(paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setDuration(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setOnCaptureOperateCallback(CaptureOperateTouchLayout.OnCaptureOperateCallback paramOnCaptureOperateCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout$OnCaptureOperateCallback = paramOnCaptureOperateCallback;
  }
  
  public void setup(ImageView paramImageView, TextView paramTextView1, TextView paramTextView2, VideoMeasureScaleView paramVideoMeasureScaleView, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView1;
    this.jdField_b_of_type_AndroidWidgetTextView = paramTextView2;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoMeasureScaleView = paramVideoMeasureScaleView;
    this.d = paramInt;
    this.f = (paramInt * jdField_a_of_type_Int);
    paramImageView.setOnTouchListener(new CaptureOperateTouchLayout.IndicatorTouchListener(this, new CaptureOperateTouchLayout.1(this, paramTextView2, paramVideoMeasureScaleView, paramImageView)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.CaptureOperateTouchLayout
 * JD-Core Version:    0.7.0.1
 */