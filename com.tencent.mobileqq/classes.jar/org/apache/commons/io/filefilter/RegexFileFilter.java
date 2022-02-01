package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOCase;

public class RegexFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private static final long serialVersionUID = 4269646126155225062L;
  private final Pattern pattern;
  
  public RegexFileFilter(String paramString)
  {
    if (paramString != null)
    {
      this.pattern = Pattern.compile(paramString);
      return;
    }
    throw new IllegalArgumentException("Pattern is missing");
  }
  
  public RegexFileFilter(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      this.pattern = Pattern.compile(paramString, paramInt);
      return;
    }
    throw new IllegalArgumentException("Pattern is missing");
  }
  
  public RegexFileFilter(String paramString, IOCase paramIOCase)
  {
    if (paramString != null)
    {
      int j = 0;
      int i = j;
      if (paramIOCase != null)
      {
        i = j;
        if (!paramIOCase.isCaseSensitive()) {
          i = 2;
        }
      }
      this.pattern = Pattern.compile(paramString, i);
      return;
    }
    throw new IllegalArgumentException("Pattern is missing");
  }
  
  public RegexFileFilter(Pattern paramPattern)
  {
    if (paramPattern != null)
    {
      this.pattern = paramPattern;
      return;
    }
    throw new IllegalArgumentException("Pattern is missing");
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return this.pattern.matcher(paramString).matches();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.filefilter.RegexFileFilter
 * JD-Core Version:    0.7.0.1
 */