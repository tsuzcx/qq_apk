package com.tencent.mobileqq.filemanager.widget;

import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;

public class QFileClickableSpan
  extends ClickableSpan
{
  private boolean a;
  private ColorStateList b;
  private ColorStateList c;
  private View.OnClickListener d;
  
  public QFileClickableSpan(View.OnClickListener paramOnClickListener, ColorStateList paramColorStateList)
  {
    this(paramOnClickListener, paramColorStateList, null);
  }
  
  public QFileClickableSpan(View.OnClickListener paramOnClickListener, ColorStateList paramColorStateList1, ColorStateList paramColorStateList2)
  {
    this.d = paramOnClickListener;
    this.b = paramColorStateList1;
    this.c = paramColorStateList2;
  }
  
  public void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = this.d;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    ColorStateList localColorStateList = this.b;
    int i;
    if (localColorStateList != null)
    {
      if (this.a) {
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
    localColorStateList = this.c;
    if (localColorStateList != null)
    {
      if (this.a) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QFileClickableSpan
 * JD-Core Version:    0.7.0.1
 */