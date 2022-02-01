package org.apache.commons.lang.text;

final class StrMatcher$TrimMatcher
  extends StrMatcher
{
  public int isMatch(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArrayOfChar[paramInt1] <= ' ') {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.text.StrMatcher.TrimMatcher
 * JD-Core Version:    0.7.0.1
 */