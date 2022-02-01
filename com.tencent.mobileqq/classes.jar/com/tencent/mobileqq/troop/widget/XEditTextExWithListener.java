package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import bgqs;
import com.tencent.widget.XEditTextEx;

public class XEditTextExWithListener
  extends XEditTextEx
{
  private bgqs a;
  
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
    if (this.a != null) {
      this.a.a(paramInt, paramKeyEvent);
    }
    return bool;
  }
  
  public void setOnKeyPreImeListener(bgqs parambgqs)
  {
    this.a = parambgqs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.XEditTextExWithListener
 * JD-Core Version:    0.7.0.1
 */