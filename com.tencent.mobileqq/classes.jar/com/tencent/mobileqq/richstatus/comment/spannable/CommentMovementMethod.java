package com.tencent.mobileqq.richstatus.comment.spannable;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.BaseMovementMethod;
import android.text.method.Touch;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

public class CommentMovementMethod
  extends BaseMovementMethod
{
  private int jdField_a_of_type_Int;
  private BackgroundColorSpan jdField_a_of_type_AndroidTextStyleBackgroundColorSpan;
  public final String a;
  private boolean jdField_a_of_type_Boolean = true;
  private ClickableSpan[] jdField_a_of_type_ArrayOfAndroidTextStyleClickableSpan;
  private int b;
  
  public CommentMovementMethod(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = "CommentMovementMethod";
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    Object localObject;
    if (i == 0)
    {
      i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      int k = paramTextView.getTotalPaddingLeft();
      int m = paramTextView.getTotalPaddingTop();
      int n = paramTextView.getScrollX();
      int i1 = paramTextView.getScrollY();
      localObject = paramTextView.getLayout();
      i = ((Layout)localObject).getOffsetForHorizontal(((Layout)localObject).getLineForVertical(j - m + i1), i - k + n);
      this.jdField_a_of_type_ArrayOfAndroidTextStyleClickableSpan = ((ClickableSpan[])paramSpannable.getSpans(i, i, ClickableSpan.class));
      if (this.jdField_a_of_type_ArrayOfAndroidTextStyleClickableSpan.length > 0)
      {
        a(false);
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.jdField_a_of_type_ArrayOfAndroidTextStyleClickableSpan[0]), paramSpannable.getSpanEnd(this.jdField_a_of_type_ArrayOfAndroidTextStyleClickableSpan[0]));
        this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan = new BackgroundColorSpan(this.b);
        paramSpannable.setSpan(this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan, paramSpannable.getSpanStart(this.jdField_a_of_type_ArrayOfAndroidTextStyleClickableSpan[0]), paramSpannable.getSpanEnd(this.jdField_a_of_type_ArrayOfAndroidTextStyleClickableSpan[0]), 33);
      }
      else
      {
        a(true);
        paramTextView.setBackgroundColor(this.jdField_a_of_type_Int);
      }
    }
    else if (i == 1)
    {
      localObject = this.jdField_a_of_type_ArrayOfAndroidTextStyleClickableSpan;
      if (localObject.length > 0)
      {
        localObject[0].onClick(paramTextView);
        localObject = this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan;
        if (localObject != null) {
          paramSpannable.removeSpan(localObject);
        }
      }
      Selection.removeSelection(paramSpannable);
      paramTextView.setBackgroundResource(2131167333);
    }
    else if (i != 2)
    {
      localObject = this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan;
      if (localObject != null) {
        paramSpannable.removeSpan(localObject);
      }
      paramTextView.setBackgroundResource(2131167333);
    }
    return Touch.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.spannable.CommentMovementMethod
 * JD-Core Version:    0.7.0.1
 */