package com.tencent.tkd.topicsdk.widget.ucrop;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.R.styleable;
import org.jetbrains.annotations.NotNull;

public class UCropView
  extends FrameLayout
{
  private GestureCropImageView jdField_a_of_type_ComTencentTkdTopicsdkWidgetUcropGestureCropImageView;
  private final OverlayView jdField_a_of_type_ComTencentTkdTopicsdkWidgetUcropOverlayView;
  
  public UCropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UCropView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(R.layout.L, this, true);
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetUcropGestureCropImageView = ((GestureCropImageView)findViewById(R.id.ai));
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetUcropOverlayView = ((OverlayView)findViewById(R.id.ce));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.q);
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetUcropOverlayView.a(paramContext);
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetUcropGestureCropImageView.a(paramContext);
    paramContext.recycle();
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetUcropGestureCropImageView.setCropBoundsChangeListener(new UCropView.1(this));
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetUcropOverlayView.setOverlayViewChangeListener(new UCropView.2(this));
  }
  
  @NotNull
  public GestureCropImageView a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetUcropGestureCropImageView;
  }
  
  @NotNull
  public OverlayView a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetUcropOverlayView;
  }
  
  public void a()
  {
    removeView(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetUcropGestureCropImageView);
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetUcropGestureCropImageView = new GestureCropImageView(getContext());
    b();
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetUcropGestureCropImageView.setCropRect(a().a());
    addView(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetUcropGestureCropImageView, 0);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.ucrop.UCropView
 * JD-Core Version:    0.7.0.1
 */