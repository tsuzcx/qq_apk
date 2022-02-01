package com.tencent.mobileqq.kandian.base.imagecrop;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R.styleable;

public class UCropView
  extends FrameLayout
{
  private GestureCropImageView jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropGestureCropImageView;
  private final OverlayView jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropOverlayView;
  
  public UCropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UCropView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131560407, this, true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropGestureCropImageView = ((GestureCropImageView)findViewById(2131368576));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropOverlayView = ((OverlayView)findViewById(2131380847));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.UCropView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropOverlayView.a(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropGestureCropImageView.a(paramContext);
    paramContext.recycle();
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropGestureCropImageView.setCropBoundsChangeListener(new UCropView.1(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropOverlayView.setOverlayViewChangeListener(new UCropView.2(this));
  }
  
  @NonNull
  public GestureCropImageView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropGestureCropImageView;
  }
  
  @NonNull
  public OverlayView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropOverlayView;
  }
  
  public void a()
  {
    removeView(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropGestureCropImageView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropGestureCropImageView = new GestureCropImageView(getContext());
    b();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropGestureCropImageView.setCropRect(a().a());
    addView(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropGestureCropImageView, 0);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.imagecrop.UCropView
 * JD-Core Version:    0.7.0.1
 */