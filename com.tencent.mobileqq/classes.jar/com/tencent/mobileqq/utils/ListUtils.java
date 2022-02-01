package com.tencent.mobileqq.utils;

import java.util.Collection;

public class ListUtils
{
  public static boolean a(Collection paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
  
  public static int b(Collection paramCollection)
  {
    if (paramCollection == null) {
      return 0;
    }
    return paramCollection.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ListUtils
 * JD-Core Version:    0.7.0.1
 */