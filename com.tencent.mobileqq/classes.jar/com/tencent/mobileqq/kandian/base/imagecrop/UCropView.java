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
  private GestureCropImageView a;
  private final OverlayView b;
  
  public UCropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UCropView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131626452, this, true);
    this.a = ((GestureCropImageView)findViewById(2131435487));
    this.b = ((OverlayView)findViewById(2131449825));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.UCropView);
    this.b.a(paramContext);
    this.a.a(paramContext);
    paramContext.recycle();
    b();
  }
  
  private void b()
  {
    this.a.setCropBoundsChangeListener(new UCropView.1(this));
    this.b.setOverlayViewChangeListener(new UCropView.2(this));
  }
  
  public void a()
  {
    removeView(this.a);
    this.a = new GestureCropImageView(getContext());
    b();
    this.a.setCropRect(getOverlayView().getCropViewRect());
    addView(this.a, 0);
  }
  
  @NonNull
  public GestureCropImageView getCropImageView()
  {
    return this.a;
  }
  
  @NonNull
  public OverlayView getOverlayView()
  {
    return this.b;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.imagecrop.UCropView
 * JD-Core Version:    0.7.0.1
 */