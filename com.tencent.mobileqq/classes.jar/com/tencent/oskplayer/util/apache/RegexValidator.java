package com.tencent.oskplayer.util.apache;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidator
  implements Serializable
{
  private static final long serialVersionUID = -8832409930574867162L;
  private final Pattern[] patterns;
  
  public RegexValidator(String paramString)
  {
    this(paramString, true);
  }
  
  public RegexValidator(String paramString, boolean paramBoolean)
  {
    this(new String[] { paramString }, paramBoolean);
  }
  
  public RegexValidator(String[] paramArrayOfString)
  {
    this(paramArrayOfString, true);
  }
  
  public RegexValidator(String[] paramArrayOfString, boolean paramBoolean)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      throw new IllegalArgumentException("Regular expressions are missing");
    }
    this.patterns = new Pattern[paramArrayOfString.length];
    int i;
    if (paramBoolean) {
      i = 0;
    }
    while (j < paramArrayOfString.length) {
      if ((paramArrayOfString[j] == null) || (paramArrayOfString[j].length() == 0))
      {
        throw new IllegalArgumentException("Regular expression[" + j + "] is missing");
        i = 2;
      }
      else
      {
        this.patterns[j] = Pattern.compile(paramArrayOfString[j], i);
        j += 1;
      }
    }
  }
  
  public boolean isValid(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.patterns.length)
      {
        if (this.patterns[i].matcher(paramString).matches()) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public String[] match(String paramString)
  {
    int j = 0;
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.patterns.length) {
        break label92;
      }
      Matcher localMatcher = this.patterns[i].matcher(paramString);
      if (localMatcher.matches())
      {
        int k = localMatcher.groupCount();
        String[] arrayOfString = new String[k];
        i = j;
        for (;;)
        {
          paramString = arrayOfString;
          if (i >= k) {
            break;
          }
          arrayOfString[i] = localMatcher.group(i + 1);
          i += 1;
        }
      }
      i += 1;
    }
    label92:
    return null;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("RegexValidator{");
    int i = 0;
    while (i < this.patterns.length)
    {
      if (i > 0) {
        localStringBuffer.append(",");
      }
      localStringBuffer.append(this.patterns[i].pattern());
      i += 1;
    }
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
  
  public String validate(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return null;
    }
    int i = 0;
    while (i < this.patterns.length)
    {
      Matcher localMatcher = this.patterns[i].matcher(paramString);
      if (localMatcher.matches())
      {
        int k = localMatcher.groupCount();
        if (k == 1) {
          return localMatcher.group(1);
        }
        paramString = new StringBuffer();
        i = j;
        while (i < k)
        {
          String str = localMatcher.group(i + 1);
          if (str != null) {
            paramString.append(str);
          }
          i += 1;
        }
        return paramString.toString();
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.util.apache.RegexValidator
 * JD-Core Version:    0.7.0.1
 */