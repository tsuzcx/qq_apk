package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class AlphaClickableRelativeLayout
  extends RelativeLayout
{
  private boolean consumeDownEvent;
  private boolean mEnable;
  
  public AlphaClickableRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public AlphaClickableRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AlphaClickableRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mEnable)
    {
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if ((i == 1) || (i == 3)) {
          setAlpha(1.0F);
        }
      }
      else
      {
        setAlpha(0.5F);
        if (this.consumeDownEvent)
        {
          super.dispatchTouchEvent(paramMotionEvent);
          return true;
        }
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void enableAlphaClick(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void setConsumeDownEvent(boolean paramBoolean)
  {
    this.consumeDownEvent = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AlphaClickableRelativeLayout
 * JD-Core Version:    0.7.0.1
 */