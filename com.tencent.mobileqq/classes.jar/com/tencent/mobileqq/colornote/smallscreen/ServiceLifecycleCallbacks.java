package com.tencent.mobileqq.colornote.smallscreen;

import java.util.ArrayList;
import java.util.List;
import mqq.app.AppService;

public class ServiceLifecycleCallbacks<Callback extends IServiceLifecycleCallback>
{
  private final List<Callback> a = new ArrayList();
  
  private Object[] a()
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (this.a.size() > 0)
        {
          Object[] arrayOfObject = this.a.toArray();
          return arrayOfObject;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public void a(Callback paramCallback)
  {
    synchronized (this.a)
    {
      this.a.add(paramCallback);
      return;
    }
  }
  
  public void a(AppService paramAppService)
  {
    Object[] arrayOfObject = a();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((IServiceLifecycleCallback)arrayOfObject[i]).a(paramAppService);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ServiceLifecycleCallbacks
 * JD-Core Version:    0.7.0.1
 */