package com.tencent.mobileqq.leba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.fpsreport.FPSXListView;

public class LebaFPSXListView
  extends FPSXListView
{
  protected LebaFPSXListView.Listener a;
  
  public LebaFPSXListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LebaFPSXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LebaFPSXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.a != null) {
      this.a.k();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null) {
      return (this.a.a(paramMotionEvent)) || (super.onInterceptTouchEvent(paramMotionEvent));
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setListener(LebaFPSXListView.Listener paramListener)
  {
    this.a = paramListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.view.LebaFPSXListView
 * JD-Core Version:    0.7.0.1
 */