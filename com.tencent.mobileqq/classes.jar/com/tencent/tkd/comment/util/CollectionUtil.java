package com.tencent.tkd.comment.util;

import java.util.Collection;

public class CollectionUtil
{
  public static <T> boolean isEmpty(Collection<T> paramCollection)
  {
    return (paramCollection == null) || (paramCollection.size() == 0);
  }
  
  public static boolean isEmpty(Object[] paramArrayOfObject)
  {
    return (paramArrayOfObject == null) || (paramArrayOfObject.length == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.util.CollectionUtil
 * JD-Core Version:    0.7.0.1
 */