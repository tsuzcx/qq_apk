package com.tencent.wordsegment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex
{
  Pattern _pattern;
  
  public boolean init(String paramString)
  {
    if (paramString != null) {
      if (paramString.length() == 0) {
        return false;
      }
    }
    try
    {
      this._pattern = Pattern.compile(paramString);
    }
    catch (Exception paramString)
    {
      label24:
      break label24;
    }
    this._pattern = null;
    return this._pattern != null;
    return false;
  }
  
  public boolean match(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      Pattern localPattern = this._pattern;
      if (localPattern == null) {
        return false;
      }
      paramString = localPattern.matcher(paramString);
      if (paramString == null) {
        return false;
      }
      if (paramString.find()) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.wordsegment.Regex
 * JD-Core Version:    0.7.0.1
 */