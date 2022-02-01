package com.tencent.mobileqq.text.processor;

import android.text.Spanned;

public abstract interface ITextProcessor
{
  public abstract void doSubSequence(int paramInt1, int paramInt2, StringBuilder paramStringBuilder, Spanned paramSpanned);
  
  public abstract void doToPlain(int paramInt, StringBuffer paramStringBuffer, Spanned paramSpanned);
  
  public abstract void doToString(int paramInt, StringBuilder paramStringBuilder, Spanned paramSpanned);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.text.processor.ITextProcessor
 * JD-Core Version:    0.7.0.1
 */