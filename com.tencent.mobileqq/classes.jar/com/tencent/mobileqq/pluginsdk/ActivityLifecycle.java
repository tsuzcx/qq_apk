package com.tencent.mobileqq.pluginsdk;

import android.app.Activity;
import android.content.Intent;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class ActivityLifecycle
{
  private static ReferenceQueue<ActivityLifecycle.ActivityLifecycleCallback> mCallbackReferenceQueue = new ReferenceQueue();
  private static ArrayList<WeakReference<ActivityLifecycle.ActivityLifecycleCallback>> mWeakCallbackArrayList = new ArrayList();
  
  public static void onNewIntent(Activity paramActivity, Intent paramIntent)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("ActivityLifecycle onNewIntent");
    }
    try
    {
      synchronized (mWeakCallbackArrayList)
      {
        Iterator localIterator = mWeakCallbackArrayList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            ActivityLifecycle.ActivityLifecycleCallback localActivityLifecycleCallback = (ActivityLifecycle.ActivityLifecycleCallback)((WeakReference)localIterator.next()).get();
            if (localActivityLifecycleCallback == null) {
              continue;
            }
            try
            {
              localActivityLifecycleCallback.onNewIntent(paramActivity, paramIntent);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
      }
    }
    catch (ConcurrentModificationException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    for (;;)
    {
      throw paramActivity;
    }
  }
  
  public static void onPause(Activity paramActivity)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("ActivityLifecycle onPause");
    }
    try
    {
      synchronized (mWeakCallbackArrayList)
      {
        Iterator localIterator = mWeakCallbackArrayList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            ActivityLifecycle.ActivityLifecycleCallback localActivityLifecycleCallback = (ActivityLifecycle.ActivityLifecycleCallback)((WeakReference)localIterator.next()).get();
            if (localActivityLifecycleCallback == null) {
              continue;
            }
            try
            {
              localActivityLifecycleCallback.onPause(paramActivity);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
      }
    }
    catch (ConcurrentModificationException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    for (;;)
    {
      throw paramActivity;
    }
  }
  
  public static void onResume(Activity paramActivity)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("ActivityLifecycle onResume");
    }
    try
    {
      synchronized (mWeakCallbackArrayList)
      {
        Iterator localIterator = mWeakCallbackArrayList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            ActivityLifecycle.ActivityLifecycleCallback localActivityLifecycleCallback = (ActivityLifecycle.ActivityLifecycleCallback)((WeakReference)localIterator.next()).get();
            if (localActivityLifecycleCallback == null) {
              continue;
            }
            try
            {
              localActivityLifecycleCallback.onResume(paramActivity);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
      }
    }
    catch (ConcurrentModificationException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    for (;;)
    {
      throw paramActivity;
    }
  }
  
  public static void registerNFCEventCallback(ActivityLifecycle.ActivityLifecycleCallback paramActivityLifecycleCallback)
  {
    if (paramActivityLifecycleCallback == null) {
      return;
    }
    if (DebugHelper.sDebug)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("ActivityLifecycle registerNFCEventCallback;callback=");
      ((StringBuilder)???).append(paramActivityLifecycleCallback.getClass().getName());
      DebugHelper.log(((StringBuilder)???).toString());
    }
    synchronized (mWeakCallbackArrayList)
    {
      Object localObject2;
      for (;;)
      {
        localObject2 = mCallbackReferenceQueue.poll();
        if (localObject2 == null) {
          break;
        }
        mWeakCallbackArrayList.remove(localObject2);
      }
      try
      {
        localObject2 = mWeakCallbackArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ActivityLifecycle.ActivityLifecycleCallback localActivityLifecycleCallback = (ActivityLifecycle.ActivityLifecycleCallback)((WeakReference)((Iterator)localObject2).next()).get();
          if (localActivityLifecycleCallback == paramActivityLifecycleCallback) {
            return;
          }
        }
      }
      catch (ConcurrentModificationException localConcurrentModificationException)
      {
        label113:
        break label113;
      }
      paramActivityLifecycleCallback = new WeakReference(paramActivityLifecycleCallback, mCallbackReferenceQueue);
      mWeakCallbackArrayList.add(paramActivityLifecycleCallback);
      return;
    }
  }
  
  public void unregister(ActivityLifecycle.ActivityLifecycleCallback paramActivityLifecycleCallback)
  {
    if (paramActivityLifecycleCallback == null) {
      return;
    }
    synchronized (mWeakCallbackArrayList)
    {
      try
      {
        Iterator localIterator = mWeakCallbackArrayList.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((ActivityLifecycle.ActivityLifecycleCallback)localWeakReference.get() == paramActivityLifecycleCallback)
          {
            mWeakCallbackArrayList.remove(localWeakReference);
            return;
          }
        }
      }
      catch (ConcurrentModificationException paramActivityLifecycleCallback)
      {
        label62:
        label72:
        break label62;
      }
      return;
      break label72;
      throw paramActivityLifecycleCallback;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ActivityLifecycle
 * JD-Core Version:    0.7.0.1
 */