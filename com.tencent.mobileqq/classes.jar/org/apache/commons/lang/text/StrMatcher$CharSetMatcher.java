package org.apache.commons.lang.text;

import java.util.Arrays;

final class StrMatcher$CharSetMatcher
  extends StrMatcher
{
  private final char[] chars;
  
  StrMatcher$CharSetMatcher(char[] paramArrayOfChar)
  {
    this.chars = ((char[])paramArrayOfChar.clone());
    Arrays.sort(this.chars);
  }
  
  public int isMatch(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    if (Arrays.binarySearch(this.chars, paramArrayOfChar[paramInt1]) >= 0) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.text.StrMatcher.CharSetMatcher
 * JD-Core Version:    0.7.0.1
 */