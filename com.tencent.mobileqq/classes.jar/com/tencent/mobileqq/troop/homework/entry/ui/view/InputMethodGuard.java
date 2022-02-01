package com.tencent.mobileqq.troop.homework.entry.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import bfbr;
import bfbs;

public class InputMethodGuard
  extends View
{
  private int jdField_a_of_type_Int = 0;
  private bfbr jdField_a_of_type_Bfbr = null;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = false;
  
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
    getViewTreeObserver().addOnGlobalLayoutListener(new bfbs(this, null));
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void setOnInputMethodChangeListener(bfbr parambfbr)
  {
    this.jdField_a_of_type_Bfbr = parambfbr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard
 * JD-Core Version:    0.7.0.1
 */