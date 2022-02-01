package com.tencent.superplayer.utils;

import java.util.Iterator;
import java.util.List;

public class MathUtils
{
  public static int a(List<Integer> paramList)
  {
    int k = paramList.size();
    int i = 0;
    int j = 0;
    if (k > 0)
    {
      paramList = paramList.iterator();
      i = j;
      while (paramList.hasNext()) {
        i += ((Integer)paramList.next()).intValue();
      }
      i /= k;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.utils.MathUtils
 * JD-Core Version:    0.7.0.1
 */