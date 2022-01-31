package org.junit.internal;

import java.lang.reflect.Method;
import java.util.Comparator;

class MethodSorter$2
  implements Comparator<Method>
{
  public int compare(Method paramMethod1, Method paramMethod2)
  {
    int i = paramMethod1.getName().compareTo(paramMethod2.getName());
    if (i != 0) {
      return i;
    }
    return paramMethod1.toString().compareTo(paramMethod2.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.internal.MethodSorter.2
 * JD-Core Version:    0.7.0.1
 */