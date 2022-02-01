package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class AlphaClickableRelativeLayout
  extends RelativeLayout
{
  private boolean a;
  private boolean b;
  
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
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      setAlpha(0.5F);
      if (this.b)
      {
        super.dispatchTouchEvent(paramMotionEvent);
        return true;
        setAlpha(1.0F);
      }
    }
  }
  
  public void setConsumeDownEvent(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AlphaClickableRelativeLayout
 * JD-Core Version:    0.7.0.1
 */