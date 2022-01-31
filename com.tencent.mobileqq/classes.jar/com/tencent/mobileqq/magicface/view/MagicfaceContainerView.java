package com.tencent.mobileqq.magicface.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import asdx;
import asdy;

public class MagicfaceContainerView
  extends RelativeLayout
{
  GestureDetector.SimpleOnGestureListener jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = new asdx(this);
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  public asdy a;
  boolean jdField_a_of_type_Boolean = false;
  
  public MagicfaceContainerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MagicfaceContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setMagicfaceGestureListener(asdy paramasdy)
  {
    this.jdField_a_of_type_Asdy = paramasdy;
  }
  
  public void setTouchEffect(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceContainerView
 * JD-Core Version:    0.7.0.1
 */