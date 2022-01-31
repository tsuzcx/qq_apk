package org.junit.internal.runners;

import java.lang.reflect.Method;
import java.util.Comparator;
import org.junit.runner.manipulation.Sorter;

class JUnit4ClassRunner$2
  implements Comparator<Method>
{
  JUnit4ClassRunner$2(JUnit4ClassRunner paramJUnit4ClassRunner, Sorter paramSorter) {}
  
  public int compare(Method paramMethod1, Method paramMethod2)
  {
    return this.val$sorter.compare(this.this$0.methodDescription(paramMethod1), this.this$0.methodDescription(paramMethod2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.internal.runners.JUnit4ClassRunner.2
 * JD-Core Version:    0.7.0.1
 */