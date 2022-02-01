package com.tencent.mobileqq.troop.widget;

import android.text.Layout;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

public class ExpandableTextView$OnGlobalLayoutListenerByEllipsize
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public ExpandableTextView$OnGlobalLayoutListenerByEllipsize(TextView paramTextView, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(this.jdField_a_of_type_Int + 1);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
  }
  
  public void onGlobalLayout()
  {
    int i;
    if (this.jdField_a_of_type_AndroidWidgetTextView.getLineCount() > this.jdField_a_of_type_Int)
    {
      i = this.jdField_a_of_type_AndroidWidgetTextView.getLayout().getLineEnd(this.jdField_a_of_type_Int - 1);
      localCharSequence = this.jdField_a_of_type_AndroidWidgetTextView.getText();
    }
    try
    {
      localCharSequence = localCharSequence.subSequence(0, i - 3);
      str = "...";
    }
    catch (Exception localException)
    {
      String str;
      label56:
      break label56;
    }
    CharSequence localCharSequence = this.jdField_a_of_type_AndroidWidgetTextView.getText();
    str = "";
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localCharSequence);
    this.jdField_a_of_type_AndroidWidgetTextView.append(str);
    this.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.ExpandableTextView.OnGlobalLayoutListenerByEllipsize
 * JD-Core Version:    0.7.0.1
 */