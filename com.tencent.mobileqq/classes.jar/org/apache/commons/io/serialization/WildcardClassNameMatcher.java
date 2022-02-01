package org.apache.commons.io.serialization;

import org.apache.commons.io.FilenameUtils;

final class WildcardClassNameMatcher
  implements ClassNameMatcher
{
  private final String pattern;
  
  public WildcardClassNameMatcher(String paramString)
  {
    this.pattern = paramString;
  }
  
  public boolean matches(String paramString)
  {
    return FilenameUtils.wildcardMatch(paramString, this.pattern);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.serialization.WildcardClassNameMatcher
 * JD-Core Version:    0.7.0.1
 */