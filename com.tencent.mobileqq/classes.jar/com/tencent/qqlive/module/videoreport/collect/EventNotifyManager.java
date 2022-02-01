package com.tencent.qqlive.module.videoreport.collect;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
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
    int i;
    if (paramObject == null) {
      i = 0;
    } else {
      i = paramObject.hashCode();
    }
    localStringBuilder.append(i);
    localStringBuilder.append("_");
    localStringBuilder.append(paramIEventNotifier.getReuseType());
    return localStringBuilder.toString();
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
      localHashMap.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void notifySingleEvent(IEventNotifier paramIEventNotifier)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyEvent, notifier = ");
      localStringBuilder.append(paramIEventNotifier.getClass().getSimpleName());
      Log.i("EventNotifyManager", localStringBuilder.toString());
    }
    this.mListenerMgr.startNotify(new EventNotifyManager.3(this, paramIEventNotifier));
    paramIEventNotifier.reset();
    ReusablePool.recycle(paramIEventNotifier, paramIEventNotifier.getReuseType());
  }
  
  void addEventNotifier(Object paramObject, IEventNotifier paramIEventNotifier)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start notifier, notifier:");
    ((StringBuilder)localObject).append(paramIEventNotifier);
    Log.v("LazyInitSequence", ((StringBuilder)localObject).toString());
    paramObject = getMapKey(paramObject, paramIEventNotifier);
    try
    {
      localObject = (IEventNotifier)this.mNotifierMap.get(paramObject);
      if (localObject != null)
      {
        ((IEventNotifier)localObject).reset();
        ReusablePool.recycle(localObject, ((IEventNotifier)localObject).getReuseType());
      }
      this.mNotifierMap.put(paramObject, paramIEventNotifier);
      this.mMainHandler.removeCallbacks(this.mNotifyRunnable);
      this.mMainHandler.post(this.mNotifyRunnable);
      return;
    }
    finally {}
  }
  
  void addEventNotifierImmediately(Object paramObject, IEventNotifier paramIEventNotifier)
  {
    paramObject = getMapKey(paramObject, paramIEventNotifier);
    if (VideoReportInner.getInstance().isDebugMode())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("addEventNotifierImmediately, mapKey = ");
      ((StringBuilder)???).append(paramObject);
      ((StringBuilder)???).append(", notifier = ");
      ((StringBuilder)???).append(paramIEventNotifier.getClass().getSimpleName());
      Log.i("EventNotifyManager", ((StringBuilder)???).toString());
    }
    synchronized (this.mImmediateNotifySetLock)
    {
      if (this.mImmediateNotifySet.contains(paramObject)) {
        return;
      }
      this.mImmediateNotifySet.add(paramObject);
      notifySingleEvent(paramIEventNotifier);
      this.mMainHandler.removeCallbacks(this.mClearImmediateNotifierRunnable);
      this.mMainHandler.post(this.mClearImmediateNotifierRunnable);
      return;
    }
  }
  
  void onActivityCreate(Activity paramActivity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("EventNotifyManager.onActivityCreate(");
    ((StringBuilder)localObject).append(paramActivity.getClass().getSimpleName());
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    SimpleTracer.begin((String)localObject);
    this.mListenerMgr.startNotify(new EventNotifyManager.4(this, paramActivity));
    SimpleTracer.end((String)localObject);
  }
  
  void onActivityDestroyed(Activity paramActivity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("EventNotifyManager.onActivityDestroyed(");
    ((StringBuilder)localObject).append(paramActivity.getClass().getSimpleName());
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    SimpleTracer.begin((String)localObject);
    this.mListenerMgr.startNotify(new EventNotifyManager.9(this, paramActivity));
    SimpleTracer.end((String)localObject);
  }
  
  void onActivityPaused(Activity paramActivity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("EventNotifyManager.onActivityPaused(");
    ((StringBuilder)localObject).append(paramActivity.getClass().getSimpleName());
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    SimpleTracer.begin((String)localObject);
    this.mListenerMgr.startNotify(new EventNotifyManager.7(this, paramActivity));
    SimpleTracer.end((String)localObject);
  }
  
  void onActivityResumed(Activity paramActivity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("EventNotifyManager.onActivityResume(");
    ((StringBuilder)localObject).append(paramActivity.getClass().getSimpleName());
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    SimpleTracer.begin((String)localObject);
    this.mListenerMgr.startNotify(new EventNotifyManager.6(this, paramActivity));
    SimpleTracer.end((String)localObject);
  }
  
  void onActivityStarted(Activity paramActivity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("EventNotifyManager.onActivityStarted(");
    ((StringBuilder)localObject).append(paramActivity.getClass().getSimpleName());
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    SimpleTracer.begin((String)localObject);
    this.mListenerMgr.startNotify(new EventNotifyManager.5(this, paramActivity));
    SimpleTracer.end((String)localObject);
  }
  
  void onActivityStopped(Activity paramActivity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("EventNotifyManager.onActivityStopped(");
    ((StringBuilder)localObject).append(paramActivity.getClass().getSimpleName());
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    SimpleTracer.begin((String)localObject);
    this.mListenerMgr.startNotify(new EventNotifyManager.8(this, paramActivity));
    SimpleTracer.end((String)localObject);
  }
  
  void onChildViewAdded(View paramView1, View paramView2)
  {
    this.mListenerMgr.startNotify(new EventNotifyManager.16(this, paramView1, paramView2));
  }
  
  void onChildViewRemoved(View paramView1, View paramView2)
  {
    this.mListenerMgr.startNotify(new EventNotifyManager.15(this, paramView1, paramView2));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.EventNotifyManager
 * JD-Core Version:    0.7.0.1
 */