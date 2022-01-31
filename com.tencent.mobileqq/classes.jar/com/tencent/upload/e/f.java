package com.tencent.upload.e;

public class f
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(a[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(a[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      paramString = paramString.split("\\.");
      if ((paramString != null) && (paramString.length == 4)) {
        try
        {
          int i = Integer.parseInt(paramString[0]);
          if ((i > 0) && (i <= 255))
          {
            i = Integer.parseInt(paramString[1]);
            if ((i >= 0) && (i <= 255))
            {
              i = Integer.parseInt(paramString[2]);
              if ((i >= 0) && (i <= 255))
              {
                i = Integer.parseInt(paramString[3]);
                if ((i >= 0) && (i <= 255)) {
                  return true;
                }
              }
            }
          }
        }
        catch (NumberFormatException paramString) {}
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.e.f
 * JD-Core Version:    0.7.0.1
 */