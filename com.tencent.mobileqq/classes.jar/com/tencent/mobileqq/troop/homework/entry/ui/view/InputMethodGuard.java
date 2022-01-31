package com.tencent.mobileqq.troop.homework.entry.ui.view;

import ajie;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;

public class InputMethodGuard
  extends View
{
  private int jdField_a_of_type_Int = 0;
  private InputMethodGuard.InputMethodChangeListener jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard$InputMethodChangeListener = null;
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
    getViewTreeObserver().addOnGlobalLayoutListener(new ajie(this, null));
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void setOnInputMethodChangeListener(InputMethodGuard.InputMethodChangeListener paramInputMethodChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard$InputMethodChangeListener = paramInputMethodChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard
 * JD-Core Version:    0.7.0.1
 */