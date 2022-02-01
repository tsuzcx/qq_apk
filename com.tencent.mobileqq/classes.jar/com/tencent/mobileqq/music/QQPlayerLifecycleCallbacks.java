package com.tencent.mobileqq.music;

import java.util.ArrayList;
import java.util.List;
import mqq.app.AppService;

public class QQPlayerLifecycleCallbacks
{
  private final List<IQQPlayerLifeCycleCallback> a = new ArrayList();
  
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
  
  public void a(IQQPlayerLifeCycleCallback paramIQQPlayerLifeCycleCallback)
  {
    synchronized (this.a)
    {
      this.a.add(paramIQQPlayerLifeCycleCallback);
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
        ((IQQPlayerLifeCycleCallback)arrayOfObject[i]).a(paramAppService);
        i += 1;
      }
    }
  }
  
  public void b(AppService paramAppService)
  {
    Object[] arrayOfObject = a();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((IQQPlayerLifeCycleCallback)arrayOfObject[i]).b(paramAppService);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerLifecycleCallbacks
 * JD-Core Version:    0.7.0.1
 */