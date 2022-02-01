package com.tencent.mobileqq.kandian.base.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionUtils
{
  public static <T> int a(Iterable<T> paramIterable, CollectionUtils.IPredicate<T> paramIPredicate)
  {
    if (paramIterable != null)
    {
      int i = 0;
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        if (paramIPredicate.a(paramIterable.next())) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static <T, E> List<E> a(Iterable<T> paramIterable, CollectionUtils.IAction<T, E> paramIAction)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (paramIAction != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        localArrayList.add(paramIAction.a(paramIterable.next()));
      }
    }
    return localArrayList;
  }
  
  public static <T> List<T> a(Iterable<T> paramIterable, CollectionUtils.IPredicate<T> paramIPredicate)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (paramIPredicate != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        if (paramIPredicate.a(localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.CollectionUtils
 * JD-Core Version:    0.7.0.1
 */