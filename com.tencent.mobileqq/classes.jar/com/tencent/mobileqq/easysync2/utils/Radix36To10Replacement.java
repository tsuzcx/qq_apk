package com.tencent.mobileqq.easysync2.utils;

import java.util.regex.Matcher;

public class Radix36To10Replacement
  implements StringReplacement
{
  public String a(Matcher paramMatcher)
  {
    return Long.toString(Long.parseLong(paramMatcher.group(), Utils.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.utils.Radix36To10Replacement
 * JD-Core Version:    0.7.0.1
 */