package com.tencent.widget;

import android.text.SpannableString;

public abstract class SpanAdapter
{
  protected static final String TAG = "spanStyle";
  public String apendString;
  public int end;
  public int start;
  
  public abstract void getSpan(SpannableString paramSpannableString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.SpanAdapter
 * JD-Core Version:    0.7.0.1
 */