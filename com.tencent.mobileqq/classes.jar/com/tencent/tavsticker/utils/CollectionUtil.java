package com.tencent.tavsticker.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class CollectionUtil
{
  public static boolean isEmptyCollection(Collection<?> paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
  
  public static boolean isEmptyList(List<?> paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  public static boolean isEmptyMap(Map<?, ?> paramMap)
  {
    return (paramMap == null) || (paramMap.isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.utils.CollectionUtil
 * JD-Core Version:    0.7.0.1
 */