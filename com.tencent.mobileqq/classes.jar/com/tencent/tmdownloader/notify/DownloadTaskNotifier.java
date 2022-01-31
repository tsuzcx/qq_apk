package com.tencent.tmdownloader.notify;

import com.tencent.tmassistantbase.util.ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DownloadTaskNotifier
{
  public static final int COMPLETED = 4;
  public static final int FAILED = 3;
  public static final int PAUSED = 2;
  public static final int STARTED = 1;
  private static final String TAG = "DownloadTaskNotifier_";
  private static volatile DownloadTaskNotifier sInstance = null;
  private final Object locker = new Object();
  private List<WeakReference<DownloadGlobalListener>> mListener = new ArrayList();
  
  public static DownloadTaskNotifier get()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new DownloadTaskNotifier();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void addListener(DownloadGlobalListener paramDownloadGlobalListener)
  {
    if (paramDownloadGlobalListener == null) {
      return;
    }
    synchronized (this.locker)
    {
      Iterator localIterator = new ArrayList(this.mListener).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() == paramDownloadGlobalListener))
        {
          ab.c("DownloadTaskNotifier_", ">addListener " + paramDownloadGlobalListener + "已经被添加过了，放弃本次添加动作");
          return;
        }
      }
    }
    this.mListener.add(new WeakReference(paramDownloadGlobalListener));
  }
  
  public void notify(DownloadTaskInfo paramDownloadTaskInfo, int paramInt)
  {
    Object localObject2 = new ArrayList();
    for (;;)
    {
      synchronized (this.locker)
      {
        List localList = this.mListener;
        if ((localList != null) && (localList.size() > 0)) {
          ((ArrayList)localObject2).addAll(localList);
        }
        if (((ArrayList)localObject2).size() == 0) {
          return;
        }
      }
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (WeakReference)((Iterator)localObject2).next();
        if (??? == null) {}
        DownloadGlobalListener localDownloadGlobalListener;
        for (??? = null; ??? != null; localDownloadGlobalListener = (DownloadGlobalListener)localException.get())
        {
          for (;;)
          {
            switch (paramInt)
            {
            default: 
              break;
            case 1: 
              try
              {
                ((DownloadGlobalListener)???).onTaskStarted(paramDownloadTaskInfo);
              }
              catch (Exception localException) {}
            }
          }
          break;
        }
        localDownloadGlobalListener.onTaskPaused(paramDownloadTaskInfo);
        continue;
        localDownloadGlobalListener.onTaskFailed(paramDownloadTaskInfo);
        continue;
        localDownloadGlobalListener.onTaskCompleted(paramDownloadTaskInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmdownloader.notify.DownloadTaskNotifier
 * JD-Core Version:    0.7.0.1
 */