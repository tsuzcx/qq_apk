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
    if (paramClass == Integer.TYPE) {
      return Integer.valueOf(0);
    }
    if (paramClass == Long.TYPE) {
      return Long.valueOf(0L);
    }
    if (paramClass == Double.TYPE) {
      return Integer.valueOf(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.raftannotation.utils.Utils
 * JD-Core Version:    0.7.0.1
 */