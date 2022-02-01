package com.tencent.tkd.topicsdk.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.tkd.topicsdk.ucrop.R.id;
import com.tencent.tkd.topicsdk.ucrop.R.layout;
import com.tencent.tkd.topicsdk.ucrop.R.styleable;

public class UCropView
  extends FrameLayout
{
  private GestureCropImageView jdField_a_of_type_ComTencentTkdTopicsdkUcropViewGestureCropImageView;
  private final OverlayView jdField_a_of_type_ComTencentTkdTopicsdkUcropViewOverlayView;
  
  public UCropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UCropView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(R.layout.a, this, true);
    this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewGestureCropImageView = ((GestureCropImageView)findViewById(R.id.a));
    this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewOverlayView = ((OverlayView)findViewById(R.id.b));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.b);
    this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewOverlayView.a(paramContext);
    this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewGestureCropImageView.a(paramContext);
    paramContext.recycle();
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewGestureCropImageView.setCropBoundsChangeListener(new UCropView.1(this));
    this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewOverlayView.setOverlayViewChangeListener(new UCropView.2(this));
  }
  
  @NonNull
  public GestureCropImageView a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewGestureCropImageView;
  }
  
  @NonNull
  public OverlayView a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewOverlayView;
  }
  
  public void a()
  {
    removeView(this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewGestureCropImageView);
    this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewGestureCropImageView = new GestureCropImageView(getContext());
    b();
    this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewGestureCropImageView.setCropRect(a().a());
    addView(this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewGestureCropImageView, 0);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.view.UCropView
 * JD-Core Version:    0.7.0.1
 */