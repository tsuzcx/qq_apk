package com.tencent.raft.codegenmeta.utils;

public class TextUtils
{
  public static boolean equals(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence1 == paramCharSequence2) {
      return true;
    }
    if ((paramCharSequence1 != null) && (paramCharSequence2 != null))
    {
      int j = paramCharSequence1.length();
      if (j == paramCharSequence2.length())
      {
        if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
          return paramCharSequence1.equals(paramCharSequence2);
        }
        int i = 0;
        while (i < j)
        {
          if (paramCharSequence1.charAt(i) != paramCharSequence2.charAt(i)) {
            return false;
          }
          i += 1;
        }
        return true;
      }
    }
    return false;
  }
  
  public static boolean isEmpty(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.raft.codegenmeta.utils.TextUtils
 * JD-Core Version:    0.7.0.1
 */