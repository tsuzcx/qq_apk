package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import com.tencent.widget.XEditTextEx;

public class XEditTextExWithListener
  extends XEditTextEx
{
  private XEditTextExWithListener.KeyPreImeListener b;
  
  public XEditTextExWithListener(Context paramContext)
  {
    super(paramContext);
  }
  
  public XEditTextExWithListener(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = super.onKeyPreIme(paramInt, paramKeyEvent);
    XEditTextExWithListener.KeyPreImeListener localKeyPreImeListener = this.b;
    if (localKeyPreImeListener != null) {
      localKeyPreImeListener.a(paramInt, paramKeyEvent);
    }
    return bool;
  }
  
  public void setOnKeyPreImeListener(XEditTextExWithListener.KeyPreImeListener paramKeyPreImeListener)
  {
    this.b = paramKeyPreImeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.XEditTextExWithListener
 * JD-Core Version:    0.7.0.1
 */