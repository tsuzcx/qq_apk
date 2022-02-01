package org.apache.commons.lang;

public class CharUtils
{
  private static final Character[] CHAR_ARRAY;
  private static final String CHAR_STRING = "";
  private static final String[] CHAR_STRING_ARRAY = new String[''];
  public static final char CR = '\r';
  public static final char LF = '\n';
  
  static
  {
    CHAR_ARRAY = new Character[''];
    int i = 127;
    while (i >= 0)
    {
      CHAR_STRING_ARRAY[i] = "".substring(i, i + 1);
      CHAR_ARRAY[i] = new Character((char)i);
      i -= 1;
    }
  }
  
  public static boolean isAscii(char paramChar)
  {
    return paramChar < '';
  }
  
  public static boolean isAsciiAlpha(char paramChar)
  {
    return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  public static boolean isAsciiAlphaLower(char paramChar)
  {
    return (paramChar >= 'a') && (paramChar <= 'z');
  }
  
  public static boolean isAsciiAlphaUpper(char paramChar)
  {
    return (paramChar >= 'A') && (paramChar <= 'Z');
  }
  
  public static boolean isAsciiAlphanumeric(char paramChar)
  {
    return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= '0') && (paramChar <= '9'));
  }
  
  public static boolean isAsciiControl(char paramChar)
  {
    return (paramChar < ' ') || (paramChar == '');
  }
  
  public static boolean isAsciiNumeric(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  public static boolean isAsciiPrintable(char paramChar)
  {
    return (paramChar >= ' ') && (paramChar < '');
  }
  
  static boolean isHighSurrogate(char paramChar)
  {
    return (55296 <= paramChar) && (56319 >= paramChar);
  }
  
  public static char toChar(Character paramCharacter)
  {
    if (paramCharacter != null) {
      return paramCharacter.charValue();
    }
    throw new IllegalArgumentException("The Character must not be null");
  }
  
  public static char toChar(Character paramCharacter, char paramChar)
  {
    if (paramCharacter == null) {
      return paramChar;
    }
    return paramCharacter.charValue();
  }
  
  public static char toChar(String paramString)
  {
    if (!StringUtils.isEmpty(paramString)) {
      return paramString.charAt(0);
    }
    throw new IllegalArgumentException("The String must not be empty");
  }
  
  public static char toChar(String paramString, char paramChar)
  {
    if (StringUtils.isEmpty(paramString)) {
      return paramChar;
    }
    return paramString.charAt(0);
  }
  
  public static Character toCharacterObject(char paramChar)
  {
    Character[] arrayOfCharacter = CHAR_ARRAY;
    if (paramChar < arrayOfCharacter.length) {
      return arrayOfCharacter[paramChar];
    }
    return new Character(paramChar);
  }
  
  public static Character toCharacterObject(String paramString)
  {
    if (StringUtils.isEmpty(paramString)) {
      return null;
    }
    return toCharacterObject(paramString.charAt(0));
  }
  
  public static int toIntValue(char paramChar)
  {
    if (isAsciiNumeric(paramChar)) {
      return paramChar - '0';
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("The character ");
    localStringBuffer.append(paramChar);
    localStringBuffer.append(" is not in the range '0' - '9'");
    throw new IllegalArgumentException(localStringBuffer.toString());
  }
  
  public static int toIntValue(char paramChar, int paramInt)
  {
    if (!isAsciiNumeric(paramChar)) {
      return paramInt;
    }
    return paramChar - '0';
  }
  
  public static int toIntValue(Character paramCharacter)
  {
    if (paramCharacter != null) {
      return toIntValue(paramCharacter.charValue());
    }
    throw new IllegalArgumentException("The character must not be null");
  }
  
  public static int toIntValue(Character paramCharacter, int paramInt)
  {
    if (paramCharacter == null) {
      return paramInt;
    }
    return toIntValue(paramCharacter.charValue(), paramInt);
  }
  
  public static String toString(char paramChar)
  {
    if (paramChar < '') {
      return CHAR_STRING_ARRAY[paramChar];
    }
    return new String(new char[] { paramChar });
  }
  
  public static String toString(Character paramCharacter)
  {
    if (paramCharacter == null) {
      return null;
    }
    return toString(paramCharacter.charValue());
  }
  
  public static String unicodeEscaped(char paramChar)
  {
    if (paramChar < '\020')
    {
      localStringBuffer = new StringBuffer();
      localStringBuffer.append("\\u000");
      localStringBuffer.append(Integer.toHexString(paramChar));
      return localStringBuffer.toString();
    }
    if (paramChar < 'Ā')
    {
      localStringBuffer = new StringBuffer();
      localStringBuffer.append("\\u00");
      localStringBuffer.append(Integer.toHexString(paramChar));
      return localStringBuffer.toString();
    }
    if (paramChar < 'က')
    {
      localStringBuffer = new StringBuffer();
      localStringBuffer.append("\\u0");
      localStringBuffer.append(Integer.toHexString(paramChar));
      return localStringBuffer.toString();
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\\u");
    localStringBuffer.append(Integer.toHexString(paramChar));
    return localStringBuffer.toString();
  }
  
  public static String unicodeEscaped(Character paramCharacter)
  {
    if (paramCharacter == null) {
      return null;
    }
    return unicodeEscaped(paramCharacter.charValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.CharUtils
 * JD-Core Version:    0.7.0.1
 */