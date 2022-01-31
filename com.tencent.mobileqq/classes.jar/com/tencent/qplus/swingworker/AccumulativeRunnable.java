package com.tencent.qplus.swingworker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AccumulativeRunnable<T>
  implements Runnable
{
  private List<T> arguments = null;
  
  private final List<T> flush()
  {
    try
    {
      List localList = this.arguments;
      this.arguments = null;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void add(T... paramVarArgs)
  {
    int i = 1;
    try
    {
      if (this.arguments == null)
      {
        i = 0;
        this.arguments = new ArrayList();
      }
      Collections.addAll(this.arguments, paramVarArgs);
      if (i == 0) {
        submit();
      }
      return;
    }
    finally {}
  }
  
  public final void run()
  {
    run(flush());
  }
  
  protected abstract void run(List<T> paramList);
  
  protected void submit()
  {
    WorkerUtilities.invokeInLooper(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qplus.swingworker.AccumulativeRunnable
 * JD-Core Version:    0.7.0.1
 */