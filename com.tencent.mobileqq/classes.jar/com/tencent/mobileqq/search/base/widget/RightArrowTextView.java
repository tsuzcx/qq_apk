package com.tencent.mobileqq.search.base.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class RightArrowTextView
  extends TextView
{
  public RightArrowTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RightArrowTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RightArrowTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    Drawable localDrawable = getResources().getDrawable(2130852405);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramCharSequence.toString());
    ((StringBuilder)localObject).append("[arrow]");
    localObject = new SpannableString(((StringBuilder)localObject).toString());
    ((SpannableString)localObject).setSpan(new ImageSpan(localDrawable, 1), paramCharSequence.length(), paramCharSequence.length() + 7, 17);
    super.setText((CharSequence)localObject, paramBufferType);
    setContentDescription(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.widget.RightArrowTextView
 * JD-Core Version:    0.7.0.1
 */