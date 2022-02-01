package com.tencent.mobileqq.qwallet.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.LinearLayout;

public class MyLinearLayout
  extends LinearLayout
{
  private MyLinearLayout.DispatchKeyEventListener a;
  
  public MyLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public MyLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MyLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    MyLinearLayout.DispatchKeyEventListener localDispatchKeyEventListener = this.a;
    if ((localDispatchKeyEventListener != null) && (localDispatchKeyEventListener.a(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void setDispatchKeyEventListener(MyLinearLayout.DispatchKeyEventListener paramDispatchKeyEventListener)
  {
    this.a = paramDispatchKeyEventListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.widget.MyLinearLayout
 * JD-Core Version:    0.7.0.1
 */