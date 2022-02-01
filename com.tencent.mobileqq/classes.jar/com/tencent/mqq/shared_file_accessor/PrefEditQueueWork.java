package com.tencent.mqq.shared_file_accessor;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.Iterator;
import java.util.LinkedList;

final class PrefEditQueueWork
{
  private static final int MSG_RUN = 0;
  private final Object mLock = new Object();
  private final Object mProcessingLock = new Object();
  private final Handler mWorkHandler;
  private final HandlerThread mWorkThread = new HandlerThread("pref-queue-work-thread", -2);
  private final LinkedList<Runnable> mWorks = new LinkedList();
  
  private PrefEditQueueWork()
  {
    this.mWorkThread.start();
    this.mWorkHandler = new PrefEditQueueWork.WorkHandler(this, this.mWorkThread.getLooper());
  }
  
  public static PrefEditQueueWork getInstance()
  {
    return PrefEditQueueWork.Holder.INSTANCE;
  }
  
  private void processPendingWork()
  {
    synchronized (this.mProcessingLock)
    {
      synchronized (this.mLock)
      {
        LinkedList localLinkedList = new LinkedList(this.mWorks);
        this.mWorks.clear();
        this.mWorkHandler.removeMessages(0);
        if (localLinkedList.size() > 0)
        {
          ??? = localLinkedList.iterator();
          while (((Iterator)???).hasNext()) {
            ((Runnable)((Iterator)???).next()).run();
          }
        }
        return;
      }
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public void queue(Runnable paramRunnable)
  {
    synchronized (this.mLock)
    {
      if (!this.mWorks.contains(paramRunnable)) {
        this.mWorks.add(paramRunnable);
      }
      this.mWorkHandler.sendEmptyMessage(0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.PrefEditQueueWork
 * JD-Core Version:    0.7.0.1
 */