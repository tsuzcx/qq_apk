package com.tencent.mobileqq.vas;

import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

public class VasManager<V>
  implements Manager
{
  private final ArrayList<VasManager.ListenerHolder<V>> a = new ArrayList();
  
  public static <E> VasManager.CompleteListener<E> a(VasManager.CompleteListener<E> paramCompleteListener)
  {
    return new VasManager.WeakListener(paramCompleteListener);
  }
  
  public void a(String arg1, VasManager.CompleteListener<V> paramCompleteListener, Object paramObject)
  {
    if (paramCompleteListener != null)
    {
      paramCompleteListener = new VasManager.ListenerHolder(paramCompleteListener, paramObject, ???);
      synchronized (this.a)
      {
        this.a.add(paramCompleteListener);
        return;
      }
    }
  }
  
  public void a(String paramString, V paramV)
  {
    if (paramString == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i;
    synchronized (this.a)
    {
      i = this.a.size() - 1;
      if (i >= 0)
      {
        VasManager.ListenerHolder localListenerHolder = (VasManager.ListenerHolder)this.a.get(i);
        if (paramString.equals(localListenerHolder.b))
        {
          this.a.remove(i);
          localArrayList.add(localListenerHolder);
        }
      }
      else
      {
        paramString = localArrayList.iterator();
        while (paramString.hasNext())
        {
          ??? = (VasManager.ListenerHolder)paramString.next();
          ((VasManager.ListenerHolder)???).a.onComplete(paramV, ((VasManager.ListenerHolder)???).c);
        }
        return;
      }
    }
  }
  
  public void onDestroy()
  {
    synchronized (this.a)
    {
      this.a.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasManager
 * JD-Core Version:    0.7.0.1
 */