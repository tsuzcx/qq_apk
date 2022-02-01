package com.tencent.tencent_richtext_library.richtext.matcher;

import java.util.HashMap;

public class ColorMatcher
  extends TextMatcher
{
  public HashMap<String, Object> a(int paramInt, boolean paramBoolean, CharSequence paramCharSequence)
  {
    paramInt = this.b.indexOf("text:");
    int i = this.b.indexOf(",color");
    String str1 = this.b.substring(paramInt + 5, i);
    paramInt = this.b.indexOf("color:");
    i = this.b.indexOf("}");
    String str2 = this.b.substring(paramInt + 6, i);
    paramCharSequence = new HashMap();
    try
    {
      paramCharSequence.put("text", str1);
      paramCharSequence.put("color", str2);
      return paramCharSequence;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tencent_richtext_library.richtext.matcher.ColorMatcher
 * JD-Core Version:    0.7.0.1
 */