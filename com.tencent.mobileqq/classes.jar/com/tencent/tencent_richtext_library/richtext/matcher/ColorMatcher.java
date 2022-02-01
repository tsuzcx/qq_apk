package com.tencent.tencent_richtext_library.richtext.matcher;

import java.util.HashMap;

public class ColorMatcher
  extends TextMatcher
{
  public HashMap<String, Object> a(int paramInt, boolean paramBoolean, CharSequence paramCharSequence)
  {
    paramInt = this.a.indexOf("text:");
    int i = "text:".length();
    int j = this.a.indexOf(",color");
    String str1 = this.a.substring(paramInt + i, j);
    paramInt = this.a.indexOf("color:");
    i = "color:".length();
    j = this.a.indexOf("}");
    String str2 = this.a.substring(paramInt + i, j);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tencent_richtext_library.richtext.matcher.ColorMatcher
 * JD-Core Version:    0.7.0.1
 */