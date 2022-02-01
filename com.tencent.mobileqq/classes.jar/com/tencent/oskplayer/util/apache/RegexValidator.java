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
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
    {
      this.patterns = new Pattern[paramArrayOfString.length];
      int j = 0;
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 2;
      }
      while (j < paramArrayOfString.length) {
        if ((paramArrayOfString[j] != null) && (paramArrayOfString[j].length() != 0))
        {
          this.patterns[j] = Pattern.compile(paramArrayOfString[j], i);
          j += 1;
        }
        else
        {
          paramArrayOfString = new StringBuilder();
          paramArrayOfString.append("Regular expression[");
          paramArrayOfString.append(j);
          paramArrayOfString.append("] is missing");
          throw new IllegalArgumentException(paramArrayOfString.toString());
        }
      }
      return;
    }
    paramArrayOfString = new IllegalArgumentException("Regular expressions are missing");
    for (;;)
    {
      throw paramArrayOfString;
    }
  }
  
  public boolean isValid(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      Pattern[] arrayOfPattern = this.patterns;
      if (i >= arrayOfPattern.length) {
        break;
      }
      if (arrayOfPattern[i].matcher(paramString).matches()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public String[] match(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int j = 0;
    int i = 0;
    for (;;)
    {
      Object localObject = this.patterns;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i].matcher(paramString);
      if (((Matcher)localObject).matches())
      {
        int k = ((Matcher)localObject).groupCount();
        paramString = new String[k];
        for (i = j; i < k; i = j)
        {
          j = i + 1;
          paramString[i] = ((Matcher)localObject).group(j);
        }
        return paramString;
      }
      i += 1;
    }
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
    if (paramString == null) {
      return null;
    }
    int j = 0;
    int i = 0;
    for (;;)
    {
      Object localObject = this.patterns;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i].matcher(paramString);
      if (((Matcher)localObject).matches())
      {
        int k = ((Matcher)localObject).groupCount();
        if (k == 1) {
          return ((Matcher)localObject).group(1);
        }
        paramString = new StringBuffer();
        i = j;
        while (i < k)
        {
          j = i + 1;
          String str = ((Matcher)localObject).group(j);
          i = j;
          if (str != null)
          {
            paramString.append(str);
            i = j;
          }
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