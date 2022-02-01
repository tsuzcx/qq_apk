package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.vas.watchword.VasWatchWord;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

public class VasManager<V>
  implements Manager
{
  private final ArrayList<VasManager.ListenerHolder<V>> a = new ArrayList();
  
  static
  {
    VasWatchWord.a.a();
  }
  
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
    for (;;)
    {
      int i;
      synchronized (this.a)
      {
        i = this.a.size() - 1;
        if (i >= 0)
        {
          VasManager.ListenerHolder localListenerHolder = (VasManager.ListenerHolder)this.a.get(i);
          if (paramString.equals(localListenerHolder.jdField_a_of_type_JavaLangString))
          {
            this.a.remove(i);
            localArrayList.add(localListenerHolder);
          }
        }
        else
        {
          paramString = localArrayList.iterator();
          if (!paramString.hasNext()) {
            break;
          }
          ??? = (VasManager.ListenerHolder)paramString.next();
          ((VasManager.ListenerHolder)???).jdField_a_of_type_ComTencentMobileqqVasVasManager$CompleteListener.onComplete(paramV, ((VasManager.ListenerHolder)???).jdField_a_of_type_JavaLangObject);
        }
      }
      i -= 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasManager
 * JD-Core Version:    0.7.0.1
 */