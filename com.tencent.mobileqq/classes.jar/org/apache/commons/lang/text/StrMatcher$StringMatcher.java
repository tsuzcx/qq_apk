package org.apache.commons.lang.text;

final class StrMatcher$StringMatcher
  extends StrMatcher
{
  private final char[] chars;
  
  StrMatcher$StringMatcher(String paramString)
  {
    this.chars = paramString.toCharArray();
  }
  
  public int isMatch(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.chars.length;
    if (paramInt1 + i > paramInt3) {
      return 0;
    }
    paramInt2 = 0;
    for (;;)
    {
      char[] arrayOfChar = this.chars;
      if (paramInt2 >= arrayOfChar.length) {
        break;
      }
      if (arrayOfChar[paramInt2] != paramArrayOfChar[paramInt1]) {
        return 0;
      }
      paramInt2 += 1;
      paramInt1 += 1;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.text.StrMatcher.StringMatcher
 * JD-Core Version:    0.7.0.1
 */