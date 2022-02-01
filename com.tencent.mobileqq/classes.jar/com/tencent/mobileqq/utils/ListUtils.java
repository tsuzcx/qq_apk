package com.tencent.mobileqq.utils;

import java.util.Collection;

public class ListUtils
{
  public static int a(Collection paramCollection)
  {
    if (paramCollection == null) {
      return 0;
    }
    return paramCollection.size();
  }
  
  public static boolean a(Collection paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ListUtils
 * JD-Core Version:    0.7.0.1
 */