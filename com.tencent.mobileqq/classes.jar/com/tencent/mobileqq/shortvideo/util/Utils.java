package com.tencent.mobileqq.shortvideo.util;

public class Utils
{
  private static boolean jdField_a_of_type_Boolean = false;
  private static long[] jdField_a_of_type_ArrayOfLong = new long[256];
  
  public static final long a(String paramString)
  {
    int k = 0;
    long l2;
    if ((paramString == null) || (paramString.length() == 0))
    {
      l2 = 0L;
      return l2;
    }
    if (!jdField_a_of_type_Boolean)
    {
      i = 0;
      while (i < 256)
      {
        l1 = i;
        j = 0;
        if (j < 8)
        {
          if (((int)l1 & 0x1) != 0) {}
          for (l1 = l1 >> 1 ^ 0xAC4BC9B5;; l1 >>= 1)
          {
            j += 1;
            break;
          }
        }
        jdField_a_of_type_ArrayOfLong[i] = l1;
        i += 1;
      }
      jdField_a_of_type_Boolean = true;
    }
    int j = paramString.length();
    long l1 = -1L;
    int i = k;
    for (;;)
    {
      l2 = l1;
      if (i >= j) {
        break;
      }
      k = paramString.charAt(i);
      l2 = jdField_a_of_type_ArrayOfLong[((k ^ (int)l1) & 0xFF)];
      i += 1;
      l1 = l2 ^ l1 >> 8;
    }
  }
  
  public static final String a(String paramString)
  {
    return Long.toString(a(paramString), 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.Utils
 * JD-Core Version:    0.7.0.1
 */