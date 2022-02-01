package com.tencent.mobileqq.magicface.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class MagicfaceContainerView
  extends RelativeLayout
{
  boolean a = false;
  MagicfaceContainerView.MagicfaceGestureListener b;
  GestureDetector.SimpleOnGestureListener c = new MagicfaceContainerView.1(this);
  GestureDetector d;
  
  public MagicfaceContainerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MagicfaceContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = new GestureDetector(this.c);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.a) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.a)
    {
      this.d.onTouchEvent(paramMotionEvent);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setMagicfaceGestureListener(MagicfaceContainerView.MagicfaceGestureListener paramMagicfaceGestureListener)
  {
    this.b = paramMagicfaceGestureListener;
  }
  
  public void setTouchEffect(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceContainerView
 * JD-Core Version:    0.7.0.1
 */