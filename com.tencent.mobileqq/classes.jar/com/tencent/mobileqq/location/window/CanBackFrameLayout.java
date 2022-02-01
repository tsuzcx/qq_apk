package com.tencent.mobileqq.location.window;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;

public class CanBackFrameLayout
  extends FrameLayout
{
  private View.OnClickListener a;
  
  public CanBackFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public CanBackFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (paramKeyEvent.getAction() == 1) {
        this.a.onClick(this);
      }
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void setBackKeyListener(View.OnClickListener paramOnClickListener)
  {
    this.a = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.CanBackFrameLayout
 * JD-Core Version:    0.7.0.1
 */