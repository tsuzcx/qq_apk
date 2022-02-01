package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.emosm.favroaming.SyncListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

class FavroamingManagerServiceImpl$4
  implements Runnable
{
  FavroamingManagerServiceImpl$4(FavroamingManagerServiceImpl paramFavroamingManagerServiceImpl) {}
  
  public void run()
  {
    Iterator localIterator = FavroamingManagerServiceImpl.access$900(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null))
      {
        ((SyncListener)localWeakReference.get()).onFileDone(null, this.this$0.needDownloadCount, this.this$0.downloadCount.get());
        if (QLog.isColorLevel()) {
          QLog.i("FavroamingManager", 2, "now notify listener on file done!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */