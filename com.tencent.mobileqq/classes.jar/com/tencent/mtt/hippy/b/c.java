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
    boolean bool = paramString.startsWith("HTTP/1.");
    int j = 9;
    int i;
    if (bool)
    {
      if ((paramString.length() >= 9) && (paramString.charAt(8) == ' '))
      {
        k = paramString.charAt(7) - '0';
        i = j;
        if (k != 0) {
          if (k == 1)
          {
            i = j;
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Unexpected status line: ");
            localStringBuilder.append(paramString);
            throw new ProtocolException(localStringBuilder.toString());
          }
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unexpected status line: ");
        localStringBuilder.append(paramString);
        throw new ProtocolException(localStringBuilder.toString());
      }
    }
    else
    {
      if (!paramString.startsWith("ICY ")) {
        break label324;
      }
      i = 4;
    }
    int k = paramString.length();
    j = i + 3;
    if (k >= j) {}
    try
    {
      k = Integer.parseInt(paramString.substring(i, j));
      if (paramString.length() > j)
      {
        if (paramString.charAt(j) == ' ')
        {
          paramString = paramString.substring(i + 4);
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unexpected status line: ");
          localStringBuilder.append(paramString);
          throw new ProtocolException(localStringBuilder.toString());
        }
      }
      else {
        paramString = "";
      }
      return new c(k, paramString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label250:
      break label250;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected status line: ");
    localStringBuilder.append(paramString);
    throw new ProtocolException(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected status line: ");
    localStringBuilder.append(paramString);
    throw new ProtocolException(localStringBuilder.toString());
    label324:
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected status line: ");
    localStringBuilder.append(paramString);
    throw new ProtocolException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.b.c
 * JD-Core Version:    0.7.0.1
 */