package com.tencent.mobileqq.widget;

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
    Drawable localDrawable = getResources().getDrawable(2130846025);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    SpannableString localSpannableString = new SpannableString(paramCharSequence.toString() + "[arrow]");
    localSpannableString.setSpan(new ImageSpan(localDrawable, 1), paramCharSequence.length(), paramCharSequence.length() + "[arrow]".length(), 17);
    super.setText(localSpannableString, paramBufferType);
    setContentDescription(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RightArrowTextView
 * JD-Core Version:    0.7.0.1
 */