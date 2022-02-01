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
  private static volatile DownloadTaskNotifier sInstance;
  private final Object locker = new Object();
  private List<WeakReference<DownloadGlobalListener>> mListener = new ArrayList();
  
  public static DownloadTaskNotifier get()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new DownloadTaskNotifier();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public void addListener(DownloadGlobalListener paramDownloadGlobalListener)
  {
    if (paramDownloadGlobalListener == null) {
      return;
    }
    synchronized (this.locker)
    {
      Object localObject2 = new ArrayList(this.mListener).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject2).next();
        if ((localWeakReference != null) && (localWeakReference.get() == paramDownloadGlobalListener))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(">addListener ");
          ((StringBuilder)localObject2).append(paramDownloadGlobalListener);
          ((StringBuilder)localObject2).append("已经被添加过了，放弃本次添加动作");
          ab.c("DownloadTaskNotifier_", ((StringBuilder)localObject2).toString());
          return;
        }
      }
      this.mListener.add(new WeakReference(paramDownloadGlobalListener));
      return;
    }
    for (;;)
    {
      throw paramDownloadGlobalListener;
    }
  }
  
  public void notify(DownloadTaskInfo paramDownloadTaskInfo, int paramInt)
  {
    Object localObject2 = new ArrayList();
    synchronized (this.locker)
    {
      List localList = this.mListener;
      if ((localList != null) && (localList.size() > 0)) {
        ((ArrayList)localObject2).addAll(localList);
      }
      if (((ArrayList)localObject2).size() == 0) {
        return;
      }
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (WeakReference)((Iterator)localObject2).next();
        if (??? == null) {
          ??? = null;
        } else {
          ??? = (DownloadGlobalListener)((WeakReference)???).get();
        }
        if ((??? != null) && ((paramInt == 1) || ((paramInt == 2) || ((paramInt == 3) || (paramInt == 4))))) {}
        try
        {
          ((DownloadGlobalListener)???).onTaskCompleted(paramDownloadTaskInfo);
        }
        catch (Exception localException) {}
        ((DownloadGlobalListener)???).onTaskFailed(paramDownloadTaskInfo);
        continue;
        ((DownloadGlobalListener)???).onTaskPaused(paramDownloadTaskInfo);
        continue;
        ((DownloadGlobalListener)???).onTaskStarted(paramDownloadTaskInfo);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.notify.DownloadTaskNotifier
 * JD-Core Version:    0.7.0.1
 */