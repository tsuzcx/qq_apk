package com.tencent.mobileqq.dating.widget;

import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.freshnews.BlockableEditTextView.BlockAble;
import mqq.util.WeakReference;

public class DatingCommentTextView$TouchableSpan
  extends ClickableSpan
  implements BlockableEditTextView.BlockAble
{
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private WeakReference<View.OnClickListener> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private ColorStateList b;
  
  public DatingCommentTextView$TouchableSpan(View.OnClickListener paramOnClickListener, int paramInt)
  {
    this(paramOnClickListener, ColorStateList.valueOf(paramInt), null);
  }
  
  public DatingCommentTextView$TouchableSpan(View.OnClickListener paramOnClickListener, ColorStateList paramColorStateList)
  {
    this(paramOnClickListener, paramColorStateList, null);
  }
  
  public DatingCommentTextView$TouchableSpan(View.OnClickListener paramOnClickListener, ColorStateList paramColorStateList1, ColorStateList paramColorStateList2)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramOnClickListener);
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList1;
    this.b = paramColorStateList2;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localObject != null)
    {
      localObject = (View.OnClickListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((View.OnClickListener)localObject).onClick(paramView);
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentResColorStateList;
    int i;
    if (localColorStateList != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        i = localColorStateList.getColorForState(new int[] { 16842919 }, 0);
      } else {
        i = localColorStateList.getColorForState(new int[0], 0);
      }
      paramTextPaint.setColor(i);
    }
    else
    {
      paramTextPaint.setColor(-16777216);
    }
    localColorStateList = this.b;
    if (localColorStateList != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        i = localColorStateList.getColorForState(new int[] { 16842919 }, 0);
      } else {
        i = localColorStateList.getColorForState(new int[0], 0);
      }
      paramTextPaint.bgColor = i;
      return;
    }
    paramTextPaint.bgColor = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.widget.DatingCommentTextView.TouchableSpan
 * JD-Core Version:    0.7.0.1
 */