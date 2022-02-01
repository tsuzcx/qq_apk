package com.tencent.qqcamerakit.common;

import java.util.ArrayList;
import java.util.Iterator;

public class Observable
{
  private Observable.TCHashMap<Integer, Observer> a = new Observable.TCHashMap(this);
  protected String b = getClass().getSimpleName();
  
  public void a(int paramInt1, int paramInt2, String paramString, Object... paramVarArgs)
  {
    try
    {
      Object localObject = this.a.b(Integer.valueOf(paramInt1));
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Observer localObserver = (Observer)((Iterator)localObject).next();
          if (localObserver != null) {
            localObserver.notify(paramInt1, paramInt2, paramString, paramVarArgs);
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(Observer paramObserver)
  {
    try
    {
      this.a.a(paramObserver);
      return;
    }
    finally
    {
      paramObserver = finally;
      throw paramObserver;
    }
  }
  
  public void a(Observer paramObserver, int... paramVarArgs)
  {
    try
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        int k = paramVarArgs[i];
        this.a.a(Integer.valueOf(k), paramObserver);
        i += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramObserver;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.common.Observable
 * JD-Core Version:    0.7.0.1
 */