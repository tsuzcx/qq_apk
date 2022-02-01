package com.tencent.mtt.hippy.common;

public abstract class HippyThreadRunnable<T>
  implements Runnable
{
  private T mParam;
  
  public HippyThreadRunnable() {}
  
  public HippyThreadRunnable(T paramT)
  {
    this.mParam = paramT;
  }
  
  public void run()
  {
    try
    {
      run(this.mParam);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public abstract void run(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.common.HippyThreadRunnable
 * JD-Core Version:    0.7.0.1
 */