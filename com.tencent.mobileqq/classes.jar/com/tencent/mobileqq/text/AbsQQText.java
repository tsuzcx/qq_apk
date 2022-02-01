package com.tencent.mobileqq.text;

import android.text.Spannable;

public abstract class AbsQQText
  implements Spannable, CharSequence
{
  public static final int GRAB_EMOTCATION = 3;
  public static final int SMALL_EMO_SIZE = 16;
  
  public abstract AbsQQText append(String paramString, boolean paramBoolean, int... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.text.AbsQQText
 * JD-Core Version:    0.7.0.1
 */