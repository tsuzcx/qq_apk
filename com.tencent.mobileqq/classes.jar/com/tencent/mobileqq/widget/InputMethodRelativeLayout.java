package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import bemk;
import beml;

public class InputMethodRelativeLayout
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new bemk(this);
  public beml a;
  private boolean jdField_a_of_type_Boolean;
  
  public InputMethodRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  public InputMethodRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  private int a()
  {
    Rect localRect = new Rect();
    getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
  
  public void setOnSizeChangedListenner(beml parambeml)
  {
    this.jdField_a_of_type_Beml = parambeml;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.InputMethodRelativeLayout
 * JD-Core Version:    0.7.0.1
 */