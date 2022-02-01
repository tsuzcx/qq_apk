package com.tencent.mobileqq.dinifly.parser.moshi;

final class JsonScope
{
  static final int CLOSED = 8;
  static final int DANGLING_NAME = 4;
  static final int EMPTY_ARRAY = 1;
  static final int EMPTY_DOCUMENT = 6;
  static final int EMPTY_OBJECT = 3;
  static final int NONEMPTY_ARRAY = 2;
  static final int NONEMPTY_DOCUMENT = 7;
  static final int NONEMPTY_OBJECT = 5;
  
  static String getPath(int paramInt, int[] paramArrayOfInt1, String[] paramArrayOfString, int[] paramArrayOfInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('$');
    int i = 0;
    while (i < paramInt)
    {
      int j = paramArrayOfInt1[i];
      if ((j != 1) && (j != 2))
      {
        if ((j == 3) || (j == 4) || (j == 5))
        {
          localStringBuilder.append('.');
          if (paramArrayOfString[i] != null) {
            localStringBuilder.append(paramArrayOfString[i]);
          }
        }
      }
      else
      {
        localStringBuilder.append('[');
        localStringBuilder.append(paramArrayOfInt2[i]);
        localStringBuilder.append(']');
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.moshi.JsonScope
 * JD-Core Version:    0.7.0.1
 */