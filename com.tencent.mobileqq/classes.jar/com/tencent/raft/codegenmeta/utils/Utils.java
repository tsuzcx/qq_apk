package com.tencent.raft.codegenmeta.utils;

import java.util.Collection;
import java.util.Map;

public class Utils
{
  public static String getDeclareRefName(String paramString)
  {
    return paramString.replace("$declares.", "");
  }
  
  public static boolean isEmpty(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0);
  }
  
  public static boolean isEmpty(Collection<?> paramCollection)
  {
    return (paramCollection == null) || (paramCollection.size() == 0);
  }
  
  public static boolean isEmpty(Map<?, ?> paramMap)
  {
    return (paramMap == null) || (paramMap.size() == 0);
  }
  
  public static boolean isNotEmpty(CharSequence paramCharSequence)
  {
    return !isEmpty(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.codegenmeta.utils.Utils
 * JD-Core Version:    0.7.0.1
 */