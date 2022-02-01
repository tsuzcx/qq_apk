package com.tencent.open.appcommon;

import java.util.ArrayList;
import java.util.List;

public class CallBackEvent
{
  protected static volatile CallBackEvent a;
  protected boolean b = true;
  protected List<CallBackEvent.CallBackEventListener> c = new ArrayList();
  
  public static CallBackEvent a()
  {
    if (a == null) {
      a = new CallBackEvent();
    }
    return a;
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.b = paramBoolean;
      b(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    synchronized (this.c)
    {
      CallBackEvent.CallBackEventListener[] arrayOfCallBackEventListener = new CallBackEvent.CallBackEventListener[this.c.size()];
      this.c.toArray(arrayOfCallBackEventListener);
      int j = arrayOfCallBackEventListener.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCallBackEventListener[i].a(paramBoolean);
        i += 1;
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.CallBackEvent
 * JD-Core Version:    0.7.0.1
 */