package org.extra.tools;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BroadcastUtil
  implements ScreenBroadcastReceiver.ScreenStateListener
{
  private static List<WeakReference<ScreenBroadcastReceiver.ScreenStateListener>> mDataList = new ArrayList();
  private final Object mSync = new Object();
  private ScreenBroadcastReceiver receiver = null;
  
  public static BroadcastUtil getInstance()
  {
    return BroadcastUtil.Factory.access$000();
  }
  
  private void removeUnUse()
  {
    synchronized (this.mSync)
    {
      Object localObject2 = new ArrayList();
      Object localObject4 = mDataList.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject4).next();
        if (localWeakReference.get() == null) {
          ((List)localObject2).add(localWeakReference);
        }
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (WeakReference)((Iterator)localObject2).next();
        mDataList.remove(localObject4);
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public void onScreenOff()
  {
    removeUnUse();
    int i;
    synchronized (this.mSync)
    {
      i = mDataList.size() - 1;
      if (i >= 0)
      {
        ScreenBroadcastReceiver.ScreenStateListener localScreenStateListener = (ScreenBroadcastReceiver.ScreenStateListener)((WeakReference)mDataList.get(i)).get();
        if (localScreenStateListener != null) {
          localScreenStateListener.onScreenOff();
        }
      }
      else
      {
        return;
      }
    }
  }
  
  public void onScreenOn()
  {
    removeUnUse();
    int i;
    synchronized (this.mSync)
    {
      i = mDataList.size() - 1;
      if (i >= 0)
      {
        ScreenBroadcastReceiver.ScreenStateListener localScreenStateListener = (ScreenBroadcastReceiver.ScreenStateListener)((WeakReference)mDataList.get(i)).get();
        if (localScreenStateListener != null) {
          localScreenStateListener.onScreenOn();
        }
      }
      else
      {
        return;
      }
    }
  }
  
  public void registerScreenBroadcast()
  {
    if (this.receiver != null) {
      return;
    }
    this.receiver = new ScreenBroadcastReceiver(this);
    this.receiver.register();
  }
  
  public void registerScreenBroadcast(ScreenBroadcastReceiver.ScreenStateListener paramScreenStateListener)
  {
    if (this.receiver == null) {
      return;
    }
    removeUnUse();
    if (paramScreenStateListener == null) {
      return;
    }
    synchronized (this.mSync)
    {
      Iterator localIterator = mDataList.iterator();
      while (localIterator.hasNext()) {
        if (paramScreenStateListener == ((WeakReference)localIterator.next()).get()) {
          return;
        }
      }
      paramScreenStateListener = new WeakReference(paramScreenStateListener);
      mDataList.add(paramScreenStateListener);
      return;
    }
    for (;;)
    {
      throw paramScreenStateListener;
    }
  }
  
  public void unregisterScreenBroadcast()
  {
    ScreenBroadcastReceiver localScreenBroadcastReceiver = this.receiver;
    if (localScreenBroadcastReceiver != null)
    {
      localScreenBroadcastReceiver.unregister();
      this.receiver = null;
    }
  }
  
  public void unregisterScreenBroadcast(ScreenBroadcastReceiver.ScreenStateListener paramScreenStateListener)
  {
    if (this.receiver == null) {
      return;
    }
    removeUnUse();
    if (paramScreenStateListener == null) {
      return;
    }
    Object localObject2 = this.mSync;
    Object localObject1 = null;
    try
    {
      Iterator localIterator = mDataList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (paramScreenStateListener == localWeakReference.get()) {
          localObject1 = localWeakReference;
        }
      }
      if (localObject1 != null) {
        mDataList.remove(localObject1);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramScreenStateListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.extra.tools.BroadcastUtil
 * JD-Core Version:    0.7.0.1
 */