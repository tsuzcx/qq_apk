package com.tencent.mobileqq.search.util.intercept.cache;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class SogouInterceptPatternCache
{
  private static final Map<String, Pattern> a = new HashMap();
  
  @Nullable
  public static Pattern a(String paramString)
  {
    Pattern localPattern;
    label68:
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return null;
      }
      if (a.containsKey(paramString))
      {
        paramString = (Pattern)a.get(paramString);
        return paramString;
      }
    }
    finally {}
    try
    {
      localPattern = Pattern.compile(paramString);
      a.put(paramString, localPattern);
      return localPattern;
    }
    catch (Exception paramString)
    {
      break label68;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.intercept.cache.SogouInterceptPatternCache
 * JD-Core Version:    0.7.0.1
 */