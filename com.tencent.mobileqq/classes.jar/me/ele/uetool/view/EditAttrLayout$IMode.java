package me.ele.uetool.view;

import android.graphics.Canvas;
import android.view.MotionEvent;

public abstract interface EditAttrLayout$IMode
{
  public abstract void onDraw(Canvas paramCanvas);
  
  public abstract void triggerActionLong(MotionEvent paramMotionEvent);
  
  public abstract void triggerActionMove(MotionEvent paramMotionEvent);
  
  public abstract void triggerActionUp(MotionEvent paramMotionEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.view.EditAttrLayout.IMode
 * JD-Core Version:    0.7.0.1
 */