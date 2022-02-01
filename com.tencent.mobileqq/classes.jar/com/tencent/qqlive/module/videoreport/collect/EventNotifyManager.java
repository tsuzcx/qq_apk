package com.tencent.qqlive.module.videoreport.collect;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.notifier.IEventNotifier;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCompat;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.trace.SimpleTracer;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class EventNotifyManager
{
  private static final String TAG = "EventNotifyManager";
  private Runnable mClearImmediateNotifierRunnable = new EventNotifyManager.2(this);
  private Set<String> mImmediateNotifySet = new HashSet();
  private final Object mImmediateNotifySetLock = new Object();
  private ListenerMgr<IEventListener> mListenerMgr = new ListenerMgr();
  private Handler mMainHandler = new Handler(Looper.getMainLooper());
  private Map<String, IEventNotifier> mNotifierMap = new HashMap();
  private Runnable mNotifyRunnable = new EventNotifyManager.1(this);
  
  private String getMapKey(Object paramObject, IEventNotifier paramIEventNotifier)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramObject == null) {}
    for (int i = 0;; i = paramObject.hashCode()) {
      return i + "_" + paramIEventNotifier.getReuseType();
    }
  }
  
  private void notifyEvent()
  {
    try
    {
      if (this.mNotifierMap.isEmpty()) {
        return;
      }
      HashMap localHashMap = new HashMap(this.mNotifierMap);
      this.mNotifierMap.clear();
      Iterator localIterator = localHashMap.values().iterator();
      while (localIterator.hasNext()) {
        notifySingleEvent((IEventNotifier)localIterator.next());
      }
      localObject.clear();
    }
    finally {}
  }
  
  private void notifySingleEvent(IEventNotifier paramIEventNotifier)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventNotifyManager", "notifyEvent, notifier = " + paramIEventNotifier.getClass().getSimpleName());
    }
    this.mListenerMgr.startNotify(new EventNotifyManager.3(this, paramIEventNotifier));
    paramIEventNotifier.reset();
    ReusablePool.recycle(paramIEventNotifier, paramIEventNotifier.getReuseType());
  }
  
  void addEventNotifier(Object paramObject, IEventNotifier paramIEventNotifier)
  {
    Log.v("LazyInitSequence", "start notifier, notifier:" + paramIEventNotifier);
    paramObject = getMapKey(paramObject, paramIEventNotifier);
    try
    {
      IEventNotifier localIEventNotifier = (IEventNotifier)this.mNotifierMap.get(paramObject);
      if (localIEventNotifier != null)
      {
        localIEventNotifier.reset();
        ReusablePool.recycle(localIEventNotifier, localIEventNotifier.getReuseType());
      }
      this.mNotifierMap.put(paramObject, paramIEventNotifier);
      this.mMainHandler.removeCallbacks(this.mNotifyRunnable);
      this.mMainHandler.post(this.mNotifyRunnable);
      return;
    }
    finally {}
  }
  
  void addEventNotifierImmediately(Object arg1, IEventNotifier paramIEventNotifier)
  {
    String str = getMapKey(???, paramIEventNotifier);
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventNotifyManager", "addEventNotifierImmediately, mapKey = " + str + ", notifier = " + paramIEventNotifier.getClass().getSimpleName());
    }
    synchronized (this.mImmediateNotifySetLock)
    {
      if (this.mImmediateNotifySet.contains(str)) {
        return;
      }
      this.mImmediateNotifySet.add(str);
      notifySingleEvent(paramIEventNotifier);
      this.mMainHandler.removeCallbacks(this.mClearImmediateNotifierRunnable);
      this.mMainHandler.post(this.mClearImmediateNotifierRunnable);
      return;
    }
  }
  
  void onActivityCreate(Activity paramActivity)
  {
    String str = "EventNotifyManager.onActivityCreate(" + paramActivity.getClass().getSimpleName() + ")";
    SimpleTracer.begin(str);
    this.mListenerMgr.startNotify(new EventNotifyManager.4(this, paramActivity));
    SimpleTracer.end(str);
  }
  
  void onActivityDestroyed(Activity paramActivity)
  {
    String str = "EventNotifyManager.onActivityDestroyed(" + paramActivity.getClass().getSimpleName() + ")";
    SimpleTracer.begin(str);
    this.mListenerMgr.startNotify(new EventNotifyManager.9(this, paramActivity));
    SimpleTracer.end(str);
  }
  
  void onActivityPaused(Activity paramActivity)
  {
    String str = "EventNotifyManager.onActivityPaused(" + paramActivity.getClass().getSimpleName() + ")";
    SimpleTracer.begin(str);
    this.mListenerMgr.startNotify(new EventNotifyManager.7(this, paramActivity));
    SimpleTracer.end(str);
  }
  
  void onActivityResumed(Activity paramActivity)
  {
    String str = "EventNotifyManager.onActivityResume(" + paramActivity.getClass().getSimpleName() + ")";
    SimpleTracer.begin(str);
    this.mListenerMgr.startNotify(new EventNotifyManager.6(this, paramActivity));
    SimpleTracer.end(str);
  }
  
  void onActivityStarted(Activity paramActivity)
  {
    String str = "EventNotifyManager.onActivityStarted(" + paramActivity.getClass().getSimpleName() + ")";
    SimpleTracer.begin(str);
    this.mListenerMgr.startNotify(new EventNotifyManager.5(this, paramActivity));
    SimpleTracer.end(str);
  }
  
  void onActivityStopped(Activity paramActivity)
  {
    String str = "EventNotifyManager.onActivityStopped(" + paramActivity.getClass().getSimpleName() + ")";
    SimpleTracer.begin(str);
    this.mListenerMgr.startNotify(new EventNotifyManager.8(this, paramActivity));
    SimpleTracer.end(str);
  }
  
  void onDialogHide(Activity paramActivity, Dialog paramDialog)
  {
    this.mListenerMgr.startNotify(new EventNotifyManager.14(this, paramActivity, paramDialog));
  }
  
  void onDialogShow(Activity paramActivity, Dialog paramDialog)
  {
    this.mListenerMgr.startNotify(new EventNotifyManager.13(this, paramActivity, paramDialog));
  }
  
  void onFragmentDestroyView(FragmentCompat paramFragmentCompat)
  {
    this.mListenerMgr.startNotify(new EventNotifyManager.12(this, paramFragmentCompat));
  }
  
  void onFragmentPaused(FragmentCompat paramFragmentCompat)
  {
    this.mListenerMgr.startNotify(new EventNotifyManager.11(this, paramFragmentCompat));
  }
  
  void onFragmentResumed(FragmentCompat paramFragmentCompat)
  {
    this.mListenerMgr.startNotify(new EventNotifyManager.10(this, paramFragmentCompat));
  }
  
  void registerEventListener(IEventListener paramIEventListener)
  {
    this.mListenerMgr.register(paramIEventListener);
  }
  
  void unregisterEventListener(IEventListener paramIEventListener)
  {
    this.mListenerMgr.unregister(paramIEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.EventNotifyManager
 * JD-Core Version:    0.7.0.1
 */