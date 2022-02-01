package com.yolo.esports.download.cb;

import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.ThreadPool;
import com.yolo.esports.download.common.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TaskCallbackCenter
{
  private static volatile TaskCallbackCenter a;
  private Map<String, LinkedList<DownloadTaskListener>> b = new HashMap();
  private LinkedList<DownloadTaskListener> c = new LinkedList();
  private final Object d = new Object();
  
  public static TaskCallbackCenter a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TaskCallbackCenter();
        }
      }
      finally {}
    }
    return a;
  }
  
  private List<DownloadTaskListener> a(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.d)
    {
      paramString = (LinkedList)this.b.get(paramString);
      if ((paramString != null) && (paramString.size() > 0)) {
        localLinkedList.addAll(paramString);
      }
      localLinkedList.addAll(this.c);
      return localLinkedList;
    }
  }
  
  private void d(String paramString, DownloadInfo paramDownloadInfo)
  {
    paramString = a(paramString);
    if (paramString.size() == 0) {
      return;
    }
    paramString = paramString.iterator();
    for (;;)
    {
      DownloadTaskListener localDownloadTaskListener;
      if (paramString.hasNext())
      {
        localDownloadTaskListener = (DownloadTaskListener)paramString.next();
        if (localDownloadTaskListener == null) {}
      }
      else
      {
        try
        {
          localDownloadTaskListener.b(paramDownloadInfo);
        }
        catch (Exception localException) {}
        return;
      }
    }
  }
  
  private void e(String paramString, DownloadInfo paramDownloadInfo)
  {
    paramString = a(paramString);
    if (paramString.size() == 0) {
      return;
    }
    paramString = paramString.iterator();
    for (;;)
    {
      DownloadTaskListener localDownloadTaskListener;
      if (paramString.hasNext())
      {
        localDownloadTaskListener = (DownloadTaskListener)paramString.next();
        if (localDownloadTaskListener == null) {}
      }
      else
      {
        try
        {
          localDownloadTaskListener.a(paramDownloadInfo);
        }
        catch (Exception localException) {}
        return;
      }
    }
  }
  
  private void f(String paramString, DownloadInfo paramDownloadInfo)
  {
    paramString = a(paramString);
    if (paramString.size() == 0) {
      return;
    }
    paramString = paramString.iterator();
    for (;;)
    {
      DownloadTaskListener localDownloadTaskListener;
      if (paramString.hasNext())
      {
        localDownloadTaskListener = (DownloadTaskListener)paramString.next();
        if (localDownloadTaskListener == null) {}
      }
      else
      {
        try
        {
          localDownloadTaskListener.c(paramDownloadInfo);
        }
        catch (Exception localException) {}
        return;
      }
    }
  }
  
  public void a(DownloadTaskListener paramDownloadTaskListener)
  {
    if (paramDownloadTaskListener == null) {
      return;
    }
    synchronized (this.d)
    {
      Object localObject2 = new ArrayList(this.c).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        DownloadTaskListener localDownloadTaskListener = (DownloadTaskListener)((Iterator)localObject2).next();
        if ((localDownloadTaskListener != null) && (localDownloadTaskListener == paramDownloadTaskListener))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[addListener(TaskListener listener)]listener");
          ((StringBuilder)localObject2).append(paramDownloadTaskListener);
          ((StringBuilder)localObject2).append("已经被添加过了，放弃本次添加动作");
          Logger.a("TaskCallbackCenter", ((StringBuilder)localObject2).toString());
          return;
        }
      }
      this.c.add(paramDownloadTaskListener);
      return;
    }
    for (;;)
    {
      throw paramDownloadTaskListener;
    }
  }
  
  public void a(String paramString, DownloadInfo paramDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTaskStateChanged:");
    localStringBuilder.append(paramDownloadInfo);
    Logger.a("TaskCallbackCenter", localStringBuilder.toString());
    ThreadPool.c(new TaskCallbackCenter.1(this, paramString, paramDownloadInfo));
  }
  
  public void b(DownloadTaskListener paramDownloadTaskListener)
  {
    synchronized (this.d)
    {
      this.c.remove(paramDownloadTaskListener);
      return;
    }
  }
  
  public void b(String paramString, DownloadInfo paramDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTaskStart:");
    localStringBuilder.append(paramDownloadInfo);
    Logger.a("TaskCallbackCenter", localStringBuilder.toString());
    ThreadPool.c(new TaskCallbackCenter.2(this, paramString, paramDownloadInfo));
  }
  
  public void c(String paramString, DownloadInfo paramDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTaskProgressChanged:");
    localStringBuilder.append(paramDownloadInfo);
    Logger.a("TaskCallbackCenter", localStringBuilder.toString());
    ThreadPool.c(new TaskCallbackCenter.3(this, paramString, paramDownloadInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.download.cb.TaskCallbackCenter
 * JD-Core Version:    0.7.0.1
 */