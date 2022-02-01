package org.apache.commons.io.serialization;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class RegexpClassNameMatcher
  implements ClassNameMatcher
{
  private final Pattern pattern;
  
  public RegexpClassNameMatcher(String paramString)
  {
    this(Pattern.compile(paramString));
  }
  
  public RegexpClassNameMatcher(Pattern paramPattern)
  {
    if (paramPattern == null) {
      throw new IllegalArgumentException("Null pattern");
    }
    this.pattern = paramPattern;
  }
  
  public boolean matches(String paramString)
  {
    return this.pattern.matcher(paramString).matches();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.serialization.RegexpClassNameMatcher
 * JD-Core Version:    0.7.0.1
 */