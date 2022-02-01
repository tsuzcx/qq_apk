package com.tencent.xweb.extension.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;

public class ClickableFrameLayout
  extends FrameLayout
{
  private View.OnClickListener a;
  private GestureDetector b;
  
  public ClickableFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ClickableFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ClickableFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public ClickableFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.a != null;
  }
  
  public void setGestureDetector(GestureDetector paramGestureDetector)
  {
    this.b = paramGestureDetector;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.a = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.extension.video.ClickableFrameLayout
 * JD-Core Version:    0.7.0.1
 */