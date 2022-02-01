package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class UpScrollHideView
  extends FrameLayout
{
  private float a;
  private int b = -1;
  private int c = 0;
  private UpScrollHideView.onViewHideListener d = null;
  
  public UpScrollHideView(Context paramContext)
  {
    super(paramContext, null);
  }
  
  public UpScrollHideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842880);
  }
  
  public UpScrollHideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
        }
        else
        {
          i = paramMotionEvent.findPointerIndex(this.b);
          if (i == -1) {
            return true;
          }
          float f = paramMotionEvent.getY(i);
          this.c = ((int)(this.a - f));
          i = this.c;
          if (i <= 0) {
            break label145;
          }
          scrollTo(0, i);
          return true;
        }
      }
      if (this.c > getHeight())
      {
        setVisibility(8);
        paramMotionEvent = this.d;
        if (paramMotionEvent != null) {
          paramMotionEvent.a();
        }
      }
      else
      {
        scrollTo(0, 0);
      }
      this.b = -1;
      return true;
    }
    else
    {
      this.a = paramMotionEvent.getY();
      this.b = paramMotionEvent.getPointerId(0);
    }
    label145:
    return true;
  }
  
  public void setOnViewHideListener(UpScrollHideView.onViewHideListener paramonViewHideListener)
  {
    this.d = paramonViewHideListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.UpScrollHideView
 * JD-Core Version:    0.7.0.1
 */