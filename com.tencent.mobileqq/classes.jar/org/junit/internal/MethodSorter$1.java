package org.junit.internal;

import java.lang.reflect.Method;
import java.util.Comparator;

class MethodSorter$1
  implements Comparator<Method>
{
  public int compare(Method paramMethod1, Method paramMethod2)
  {
    int i = paramMethod1.getName().hashCode();
    int j = paramMethod2.getName().hashCode();
    if (i != j)
    {
      if (i < j) {
        return -1;
      }
      return 1;
    }
    return MethodSorter.NAME_ASCENDING.compare(paramMethod1, paramMethod2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.junit.internal.MethodSorter.1
 * JD-Core Version:    0.7.0.1
 */