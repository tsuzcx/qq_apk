package com.tencent.mobileqq.mqsafeedit;

public class StringUtil
{
  public static String toSemiAngleString(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    if (i >= paramString.length) {
      return String.valueOf(paramString);
    }
    if (paramString[i] == '　') {
      paramString[i] = 32;
    }
    for (;;)
    {
      i += 1;
      break;
      if ((paramString[i] > 65280) && (paramString[i] < 65375)) {
        paramString[i] = ((char)(paramString[i] - 65248));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mqsafeedit.StringUtil
 * JD-Core Version:    0.7.0.1
 */