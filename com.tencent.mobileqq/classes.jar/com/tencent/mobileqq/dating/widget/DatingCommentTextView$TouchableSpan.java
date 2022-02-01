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
  private boolean a;
  private ColorStateList b;
  private ColorStateList c;
  private WeakReference<View.OnClickListener> d;
  
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
    this.d = new WeakReference(paramOnClickListener);
    this.b = paramColorStateList1;
    this.c = paramColorStateList2;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.d;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.widget.DatingCommentTextView.TouchableSpan
 * JD-Core Version:    0.7.0.1
 */