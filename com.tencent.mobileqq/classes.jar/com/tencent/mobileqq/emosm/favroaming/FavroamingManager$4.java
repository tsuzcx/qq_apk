package com.tencent.mobileqq.emosm.favroaming;

import apoo;
import apow;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class FavroamingManager$4
  implements Runnable
{
  public FavroamingManager$4(apoo paramapoo) {}
  
  public void run()
  {
    Iterator localIterator = apoo.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null))
      {
        ((apow)localWeakReference.get()).a(null, this.this$0.jdField_a_of_type_Int, this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
        if (QLog.isColorLevel()) {
          QLog.i("FavroamingManager", 2, "now notify listener on file done!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.4
 * JD-Core Version:    0.7.0.1
 */