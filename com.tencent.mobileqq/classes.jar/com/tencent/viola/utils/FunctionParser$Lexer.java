package com.tencent.viola.utils;

class FunctionParser$Lexer
{
  private static final char A_LOWER = 'a';
  private static final char A_UPPER = 'A';
  private static final String COMMA = ",";
  private static final char DOT = '.';
  private static final String LEFT_PARENT = "(";
  private static final char MINUS = '-';
  private static final char NINE = '9';
  private static final char PLUS = '+';
  private static final String RIGHT_PARENT = ")";
  private static final char ZERO = '0';
  private static final char Z_LOWER = 'z';
  private static final char Z_UPPER = 'Z';
  private FunctionParser.Token current;
  private int pointer = 0;
  private String source;
  private String value;
  
  private FunctionParser$Lexer(String paramString)
  {
    this.source = paramString;
  }
  
  private FunctionParser.Token getCurrentToken()
  {
    return this.current;
  }
  
  private String getCurrentTokenValue()
  {
    return this.value;
  }
  
  private boolean isCharacterOrDigit(char paramChar)
  {
    return (('0' <= paramChar) && (paramChar <= '9')) || (('a' <= paramChar) && (paramChar <= 'z')) || (('A' <= paramChar) && (paramChar <= 'Z'));
  }
  
  private boolean isFuncName(CharSequence paramCharSequence)
  {
    int i = 0;
    while (i < paramCharSequence.length())
    {
      int j = paramCharSequence.charAt(i);
      if (((97 > j) || (j > 122)) && ((65 > j) || (j > 90)) && (j != 45)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void moveOn(String paramString)
  {
    if ("(".equals(paramString))
    {
      this.current = FunctionParser.Token.LEFT_PARENT;
      this.value = "(";
      return;
    }
    if (")".equals(paramString))
    {
      this.current = FunctionParser.Token.RIGHT_PARENT;
      this.value = ")";
      return;
    }
    if (",".equals(paramString))
    {
      this.current = FunctionParser.Token.COMMA;
      this.value = ",";
      return;
    }
    if (isFuncName(paramString))
    {
      this.current = FunctionParser.Token.FUNC_NAME;
      this.value = paramString;
      return;
    }
    this.current = FunctionParser.Token.PARAM_VALUE;
    this.value = paramString;
  }
  
  private boolean moveOn()
  {
    int i = this.pointer;
    while (this.pointer < this.source.length())
    {
      char c = this.source.charAt(this.pointer);
      if (c == ' ')
      {
        int j = this.pointer;
        this.pointer = (j + 1);
        if (i == j) {
          i += 1;
        }
      }
      else if ((isCharacterOrDigit(c)) || (c == '.') || (c == '%') || (c == '-') || (c == '+'))
      {
        this.pointer += 1;
      }
      else if (i == this.pointer)
      {
        this.pointer += 1;
      }
    }
    if (i != this.pointer)
    {
      moveOn(this.source.substring(i, this.pointer));
      return true;
    }
    this.current = null;
    this.value = null;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.utils.FunctionParser.Lexer
 * JD-Core Version:    0.7.0.1
 */