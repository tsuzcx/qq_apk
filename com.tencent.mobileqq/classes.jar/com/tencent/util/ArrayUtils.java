package com.tencent.util;

import java.util.List;

public class ArrayUtils
{
  public static <T> boolean contains(T[] paramArrayOfT, T paramT)
  {
    if (paramArrayOfT != null)
    {
      if (paramT == null) {
        return false;
      }
      int j = paramArrayOfT.length;
      int i = 0;
      while (i < j)
      {
        T ? = paramArrayOfT[i];
        if ((? != null) && (?.equals(paramT))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean isOutOfArrayIndex(int paramInt, List paramList)
  {
    return (paramList == null) || (paramInt < 0) || (paramInt >= paramList.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.ArrayUtils
 * JD-Core Version:    0.7.0.1
 */