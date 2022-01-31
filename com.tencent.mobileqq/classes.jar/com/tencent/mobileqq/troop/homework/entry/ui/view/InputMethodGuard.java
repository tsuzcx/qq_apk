package com.tencent.mobileqq.troop.homework.entry.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import bcbg;
import bcbh;

public class InputMethodGuard
  extends View
{
  private int jdField_a_of_type_Int = 0;
  private bcbg jdField_a_of_type_Bcbg = null;
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
    getViewTreeObserver().addOnGlobalLayoutListener(new bcbh(this, null));
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void setOnInputMethodChangeListener(bcbg parambcbg)
  {
    this.jdField_a_of_type_Bcbg = parambcbg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard
 * JD-Core Version:    0.7.0.1
 */