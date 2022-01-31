package org.junit.runners.model;

import java.util.Comparator;
import org.junit.internal.MethodSorter;

class TestClass$MethodComparator
  implements Comparator<FrameworkMethod>
{
  public int compare(FrameworkMethod paramFrameworkMethod1, FrameworkMethod paramFrameworkMethod2)
  {
    return MethodSorter.NAME_ASCENDING.compare(paramFrameworkMethod1.getMethod(), paramFrameworkMethod2.getMethod());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.runners.model.TestClass.MethodComparator
 * JD-Core Version:    0.7.0.1
 */