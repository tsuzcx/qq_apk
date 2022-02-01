package dov.com.qq.im.aeeditor.view.timeline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import boew;

public class SliderView
  extends ImageView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private boew jdField_a_of_type_Boew;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public SliderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SliderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SliderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setScaleType(ImageView.ScaleType.FIT_XY);
  }
  
  private void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Boew != null) {
      this.jdField_a_of_type_Boew.a(paramFloat);
    }
  }
  
  private void a(@NonNull MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent))
    {
      getParent().requestDisallowInterceptTouchEvent(true);
      c();
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.b = true;
    }
  }
  
  private boolean a(@NonNull MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getX() >= 0.0F) && (paramMotionEvent.getX() <= getWidth());
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Float = 0.0F;
    getParent().requestDisallowInterceptTouchEvent(false);
    d();
    this.b = true;
  }
  
  private void b(@NonNull MotionEvent paramMotionEvent)
  {
    float f = (int)paramMotionEvent.getRawX();
    getParent().requestDisallowInterceptTouchEvent(true);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Boolean) {
      a(f - this.jdField_a_of_type_Float);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boew != null) {
      this.jdField_a_of_type_Boew.a();
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boew != null) {
      this.jdField_a_of_type_Boew.b();
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return false;
    }
    this.b = false;
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return this.b;
      a(paramMotionEvent);
      continue;
      b(paramMotionEvent);
      continue;
      b();
    }
  }
  
  public void setSliderListener(boew paramboew)
  {
    this.jdField_a_of_type_Boew = paramboew;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.timeline.SliderView
 * JD-Core Version:    0.7.0.1
 */