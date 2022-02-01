package com.tencent.tbs.one.impl;

import com.tencent.tbs.one.TBSOneCallback;

public final class b<T>
  extends TBSOneCallback<T>
{
  T a;
  int b = 0;
  String c;
  private boolean d;
  
  private void a()
  {
    try
    {
      this.d = true;
      notify();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(long paramLong)
  {
    label19:
    try
    {
      boolean bool = this.d;
      if (bool) {}
    }
    finally {}
    try
    {
      wait(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label19;
    }
    this.b = 103;
    this.c = "Failed to wait for loading result";
  }
  
  public final void onCompleted(T paramT)
  {
    this.a = paramT;
    a();
  }
  
  public final void onError(int paramInt, String paramString)
  {
    this.b = paramInt;
    this.c = paramString;
    a();
  }
  
  public final void onProgressChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.b
 * JD-Core Version:    0.7.0.1
 */