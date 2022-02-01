package com.tencent.mtt.hippy.b;

import java.net.ProtocolException;

public final class c
{
  public final int a;
  public final String b;
  
  public c(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public static c a(String paramString)
  {
    int j = 9;
    int i;
    if (paramString.startsWith("HTTP/1."))
    {
      if ((paramString.length() < 9) || (paramString.charAt(8) != ' ')) {
        throw new ProtocolException("Unexpected status line: " + paramString);
      }
      int k = paramString.charAt(7) - '0';
      i = j;
      if (k != 0)
      {
        i = j;
        if (k != 1) {
          throw new ProtocolException("Unexpected status line: " + paramString);
        }
      }
    }
    else
    {
      if (!paramString.startsWith("ICY ")) {
        break label157;
      }
      i = 4;
    }
    if (paramString.length() < i + 3)
    {
      throw new ProtocolException("Unexpected status line: " + paramString);
      label157:
      throw new ProtocolException("Unexpected status line: " + paramString);
    }
    try
    {
      j = Integer.parseInt(paramString.substring(i, i + 3));
      if (paramString.length() > i + 3) {
        if (paramString.charAt(i + 3) != ' ') {
          throw new ProtocolException("Unexpected status line: " + paramString);
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new ProtocolException("Unexpected status line: " + paramString);
    }
    for (paramString = paramString.substring(i + 4);; paramString = "") {
      return new c(j, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.b.c
 * JD-Core Version:    0.7.0.1
 */