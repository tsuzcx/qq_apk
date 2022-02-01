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
  static ArrayList<WeakReference<HotVideoBlurTaskManager>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public static boolean a = false;
  Context jdField_a_of_type_AndroidContentContext;
  ArrayMap<HotVideoData, HotPicPageView.MyVideoViewHolder> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
  boolean b = false;
  
  HotVideoBlurTaskManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
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
      if (jdField_a_of_type_JavaUtilArrayList.size() < 3) {
        jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramContext));
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
      int i = jdField_a_of_type_JavaUtilArrayList.size();
      if (i >= 3) {
        return;
      }
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
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
        jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramHotVideoBlurTaskManager));
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
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
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
          } else if ((paramBoolean) && (!localHotVideoBlurTaskManager.b)) {
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
    jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pauseAllBlurTask HotVideoBlurTaskLock is:");
      localStringBuilder.append(jdField_a_of_type_Boolean);
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
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference != null)
        {
          HotVideoBlurTaskManager localHotVideoBlurTaskManager = (HotVideoBlurTaskManager)localWeakReference.get();
          if ((localHotVideoBlurTaskManager != null) && (paramHotVideoBlurTaskManager.equals(localHotVideoBlurTaskManager))) {
            jdField_a_of_type_JavaUtilArrayList.remove(localWeakReference);
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
    jdField_a_of_type_Boolean = false;
    a(true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resmueAllBlurTask HotVideoBlurTaskLock is:");
      localStringBuilder.append(jdField_a_of_type_Boolean);
      localStringBuilder.append(" TaskManagerList size is ");
      localStringBuilder.append(jdField_a_of_type_JavaUtilArrayList.size());
      QLog.d("HotVideoBlurTaskManager", 2, localStringBuilder.toString());
    }
  }
  
  void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryStartBlurTask HotVideoBlurTaskLock is:");
      localStringBuilder.append(jdField_a_of_type_Boolean);
      QLog.d("HotVideoBlurTaskManager", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.size() != 0) && (!jdField_a_of_type_Boolean))
    {
      this.b = true;
      ThreadManager.post(new HotVideoBlurTaskManager.1(this), 5, null, true);
      return;
    }
    this.b = false;
  }
  
  public void a(HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder, HotVideoData paramHotVideoData)
  {
    if ((paramMyVideoViewHolder != null) && (paramHotVideoData != null)) {
      try
      {
        if (this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.containsKey(paramHotVideoData))
        {
          int i = this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.indexOfKey(paramHotVideoData);
          this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.setValueAt(i, paramMyVideoViewHolder);
        }
        else
        {
          this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(paramHotVideoData, paramMyVideoViewHolder);
        }
        if (QLog.isColorLevel())
        {
          paramMyVideoViewHolder = new StringBuilder();
          paramMyVideoViewHolder.append("addBlurTask HotVideoData.Name is:");
          paramMyVideoViewHolder.append(paramHotVideoData.name);
          paramMyVideoViewHolder.append(" mBlurTasks size is ");
          paramMyVideoViewHolder.append(this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.size());
          QLog.d("HotVideoBlurTaskManager", 2, paramMyVideoViewHolder.toString());
        }
        if (!this.b) {
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
      if (this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.containsKey(paramHotVideoData)) {
        this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.remove(paramHotVideoData);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeTaskByData HotVideoData.Name is:");
        localStringBuilder.append(paramHotVideoData.name);
        localStringBuilder.append(" mBlurTasks size is ");
        localStringBuilder.append(this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.size());
        QLog.d("HotVideoBlurTaskManager", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoBlurTaskManager
 * JD-Core Version:    0.7.0.1
 */