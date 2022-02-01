package org.junit.internal.runners.statements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;

public class RunAfters
  extends Statement
{
  private final List<FrameworkMethod> afters;
  private final Statement next;
  private final Object target;
  
  public RunAfters(Statement paramStatement, List<FrameworkMethod> paramList, Object paramObject)
  {
    this.next = paramStatement;
    this.afters = paramList;
    this.target = paramObject;
  }
  
  public void evaluate()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      this.next.evaluate();
      Iterator localIterator1 = this.afters.iterator();
      while (localIterator1.hasNext())
      {
        FrameworkMethod localFrameworkMethod1 = (FrameworkMethod)localIterator1.next();
        try
        {
          localFrameworkMethod1.invokeExplosively(this.target, new Object[0]);
        }
        catch (Throwable localThrowable2)
        {
          localArrayList.add(localThrowable2);
        }
      }
      Iterator localIterator2;
      FrameworkMethod localFrameworkMethod2;
      Iterator localIterator3;
      FrameworkMethod localFrameworkMethod3;
      MultipleFailureException.assertEmpty(localArrayList);
    }
    catch (Throwable localThrowable1)
    {
      localArrayList.add(localThrowable1);
    }
    finally
    {
      localIterator3 = this.afters.iterator();
      while (localIterator3.hasNext())
      {
        localFrameworkMethod3 = (FrameworkMethod)localIterator3.next();
        try
        {
          localFrameworkMethod3.invokeExplosively(this.target, new Object[0]);
        }
        catch (Throwable localThrowable4)
        {
          localArrayList.add(localThrowable4);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.internal.runners.statements.RunAfters
 * JD-Core Version:    0.7.0.1
 */