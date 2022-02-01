package com.tencent.raft.raftannotation.utils;

import java.util.Collection;

public class Utils
{
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.isEmpty()) || (paramString.trim().isEmpty());
  }
  
  public static boolean isEmpty(Collection paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
  
  public static Object makeParamValue(Class<?> paramClass)
  {
    Class localClass = Integer.TYPE;
    Integer localInteger = Integer.valueOf(0);
    if (paramClass == localClass) {
      return localInteger;
    }
    if (paramClass == Long.TYPE) {
      return Long.valueOf(0L);
    }
    if (paramClass == Double.TYPE) {
      return localInteger;
    }
    if (paramClass == Float.TYPE) {
      return Float.valueOf(0.0F);
    }
    if (paramClass == Boolean.TYPE) {
      return Boolean.valueOf(false);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.raft.raftannotation.utils.Utils
 * JD-Core Version:    0.7.0.1
 */