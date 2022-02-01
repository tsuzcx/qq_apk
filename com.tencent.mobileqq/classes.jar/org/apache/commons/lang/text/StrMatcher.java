package org.apache.commons.lang.text;

public abstract class StrMatcher
{
  private static final StrMatcher COMMA_MATCHER = new StrMatcher.CharMatcher(',');
  private static final StrMatcher DOUBLE_QUOTE_MATCHER;
  private static final StrMatcher NONE_MATCHER = new StrMatcher.NoMatcher();
  private static final StrMatcher QUOTE_MATCHER;
  private static final StrMatcher SINGLE_QUOTE_MATCHER;
  private static final StrMatcher SPACE_MATCHER;
  private static final StrMatcher SPLIT_MATCHER;
  private static final StrMatcher TAB_MATCHER = new StrMatcher.CharMatcher('\t');
  private static final StrMatcher TRIM_MATCHER;
  
  static
  {
    SPACE_MATCHER = new StrMatcher.CharMatcher(' ');
    SPLIT_MATCHER = new StrMatcher.CharSetMatcher(" \t\n\r\f".toCharArray());
    TRIM_MATCHER = new StrMatcher.TrimMatcher();
    SINGLE_QUOTE_MATCHER = new StrMatcher.CharMatcher('\'');
    DOUBLE_QUOTE_MATCHER = new StrMatcher.CharMatcher('"');
    QUOTE_MATCHER = new StrMatcher.CharSetMatcher("'\"".toCharArray());
  }
  
  public static StrMatcher charMatcher(char paramChar)
  {
    return new StrMatcher.CharMatcher(paramChar);
  }
  
  public static StrMatcher charSetMatcher(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramString.length() == 1) {
        return new StrMatcher.CharMatcher(paramString.charAt(0));
      }
      return new StrMatcher.CharSetMatcher(paramString.toCharArray());
    }
    return NONE_MATCHER;
  }
  
  public static StrMatcher charSetMatcher(char[] paramArrayOfChar)
  {
    if ((paramArrayOfChar != null) && (paramArrayOfChar.length != 0))
    {
      if (paramArrayOfChar.length == 1) {
        return new StrMatcher.CharMatcher(paramArrayOfChar[0]);
      }
      return new StrMatcher.CharSetMatcher(paramArrayOfChar);
    }
    return NONE_MATCHER;
  }
  
  public static StrMatcher commaMatcher()
  {
    return COMMA_MATCHER;
  }
  
  public static StrMatcher doubleQuoteMatcher()
  {
    return DOUBLE_QUOTE_MATCHER;
  }
  
  public static StrMatcher noneMatcher()
  {
    return NONE_MATCHER;
  }
  
  public static StrMatcher quoteMatcher()
  {
    return QUOTE_MATCHER;
  }
  
  public static StrMatcher singleQuoteMatcher()
  {
    return SINGLE_QUOTE_MATCHER;
  }
  
  public static StrMatcher spaceMatcher()
  {
    return SPACE_MATCHER;
  }
  
  public static StrMatcher splitMatcher()
  {
    return SPLIT_MATCHER;
  }
  
  public static StrMatcher stringMatcher(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {
      return new StrMatcher.StringMatcher(paramString);
    }
    return NONE_MATCHER;
  }
  
  public static StrMatcher tabMatcher()
  {
    return TAB_MATCHER;
  }
  
  public static StrMatcher trimMatcher()
  {
    return TRIM_MATCHER;
  }
  
  public int isMatch(char[] paramArrayOfChar, int paramInt)
  {
    return isMatch(paramArrayOfChar, paramInt, 0, paramArrayOfChar.length);
  }
  
  public abstract int isMatch(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.text.StrMatcher
 * JD-Core Version:    0.7.0.1
 */