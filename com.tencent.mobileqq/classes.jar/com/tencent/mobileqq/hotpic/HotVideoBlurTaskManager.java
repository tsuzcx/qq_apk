package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class HotVideoBlurTaskManager
{
  public static boolean c = false;
  static ArrayList<WeakReference<HotVideoBlurTaskManager>> d = new ArrayList();
  ArrayMap<HotVideoData, HotPicPageView.MyVideoViewHolder> a = new ArrayMap();
  Context b;
  boolean e = false;
  
  HotVideoBlurTaskManager(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static HotVideoBlurTaskManager a(Context paramContext)
  {
    try
    {
      a(false);
      if (paramContext == null) {
        return null;
      }
      paramContext = new HotVideoBlurTaskManager(paramContext);
      if (d.size() < 3) {
        d.add(new WeakReference(paramContext));
      }
      return paramContext;
    }
    finally {}
  }
  
  public static void a(HotVideoBlurTaskManager paramHotVideoBlurTaskManager)
  {
    int j = 0;
    try
    {
      a(false);
      if (paramHotVideoBlurTaskManager == null) {
        return;
      }
      int i = d.size();
      if (i >= 3) {
        return;
      }
      Iterator localIterator = d.iterator();
      Object localObject;
      do
      {
        do
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (WeakReference)localIterator.next();
        } while (localObject == null);
        localObject = (HotVideoBlurTaskManager)((WeakReference)localObject).get();
      } while ((localObject == null) || (!paramHotVideoBlurTaskManager.equals(localObject)));
      i = 1;
      if (i == 0) {
        d.add(new WeakReference(paramHotVideoBlurTaskManager));
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramHotVideoBlurTaskManager;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = d.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference == null)
        {
          localArrayList.add(localWeakReference);
        }
        else
        {
          HotVideoBlurTaskManager localHotVideoBlurTaskManager = (HotVideoBlurTaskManager)localWeakReference.get();
          if (localHotVideoBlurTaskManager == null) {
            localArrayList.add(localWeakReference);
          } else if ((paramBoolean) && (!localHotVideoBlurTaskManager.e)) {
            localHotVideoBlurTaskManager.a();
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static void b()
  {
    c = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pauseAllBlurTask HotVideoBlurTaskLock is:");
      localStringBuilder.append(c);
      QLog.d("HotVideoBlurTaskManager", 2, localStringBuilder.toString());
    }
  }
  
  public static void b(HotVideoBlurTaskManager paramHotVideoBlurTaskManager)
  {
    try
    {
      a(false);
      if (paramHotVideoBlurTaskManager == null) {
        return;
      }
      Iterator localIterator = d.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference != null)
        {
          HotVideoBlurTaskManager localHotVideoBlurTaskManager = (HotVideoBlurTaskManager)localWeakReference.get();
          if ((localHotVideoBlurTaskManager != null) && (paramHotVideoBlurTaskManager.equals(localHotVideoBlurTaskManager))) {
            d.remove(localWeakReference);
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramHotVideoBlurTaskManager;
    }
  }
  
  public static void c()
  {
    c = false;
    a(true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resmueAllBlurTask HotVideoBlurTaskLock is:");
      localStringBuilder.append(c);
      localStringBuilder.append(" TaskManagerList size is ");
      localStringBuilder.append(d.size());
      QLog.d("HotVideoBlurTaskManager", 2, localStringBuilder.toString());
    }
  }
  
  void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryStartBlurTask HotVideoBlurTaskLock is:");
      localStringBuilder.append(c);
      QLog.d("HotVideoBlurTaskManager", 2, localStringBuilder.toString());
    }
    if ((this.a.size() != 0) && (!c))
    {
      this.e = true;
      ThreadManager.post(new HotVideoBlurTaskManager.1(this), 5, null, true);
      return;
    }
    this.e = false;
  }
  
  public void a(HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder, HotVideoData paramHotVideoData)
  {
    if ((paramMyVideoViewHolder != null) && (paramHotVideoData != null)) {
      try
      {
        if (this.a.containsKey(paramHotVideoData))
        {
          int i = this.a.indexOfKey(paramHotVideoData);
          this.a.setValueAt(i, paramMyVideoViewHolder);
        }
        else
        {
          this.a.put(paramHotVideoData, paramMyVideoViewHolder);
        }
        if (QLog.isColorLevel())
        {
          paramMyVideoViewHolder = new StringBuilder();
          paramMyVideoViewHolder.append("addBlurTask HotVideoData.Name is:");
          paramMyVideoViewHolder.append(paramHotVideoData.name);
          paramMyVideoViewHolder.append(" mBlurTasks size is ");
          paramMyVideoViewHolder.append(this.a.size());
          QLog.d("HotVideoBlurTaskManager", 2, paramMyVideoViewHolder.toString());
        }
        if (!this.e) {
          a();
        }
        return;
      }
      finally {}
    }
  }
  
  public void a(HotVideoData paramHotVideoData)
  {
    if (paramHotVideoData == null) {
      return;
    }
    try
    {
      if (this.a.containsKey(paramHotVideoData)) {
        this.a.remove(paramHotVideoData);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeTaskByData HotVideoData.Name is:");
        localStringBuilder.append(paramHotVideoData.name);
        localStringBuilder.append(" mBlurTasks size is ");
        localStringBuilder.append(this.a.size());
        QLog.d("HotVideoBlurTaskManager", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoBlurTaskManager
 * JD-Core Version:    0.7.0.1
 */