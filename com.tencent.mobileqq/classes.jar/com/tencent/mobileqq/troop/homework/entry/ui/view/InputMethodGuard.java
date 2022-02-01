package com.tencent.mobileqq.troop.homework.entry.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;

public class InputMethodGuard
  extends View
{
  private boolean a = true;
  private boolean b = false;
  private int c = 0;
  private InputMethodGuard.InputMethodChangeListener d = null;
  
  public InputMethodGuard(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InputMethodGuard(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InputMethodGuard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    getViewTreeObserver().addOnGlobalLayoutListener(new InputMethodGuard.InputMethodListener(this, null));
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public int getInputMethodHeight()
  {
    return this.c;
  }
  
  public void setOnInputMethodChangeListener(InputMethodGuard.InputMethodChangeListener paramInputMethodChangeListener)
  {
    this.d = paramInputMethodChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard
 * JD-Core Version:    0.7.0.1
 */