package com.tribe.async.dispatch;

import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tribe.async.log.SLog;
import com.tribe.async.utils.AssertUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class DefaultDispatcher
  implements Dispatcher
{
  private static final int DISPATCH = 16;
  private static final String TAG = "async.dispatch.DefaultDispatcher";
  private final ThreadLocal<DefaultDispatcher.PostingThreadState> mCurrentPostingThreadState = new DefaultDispatcher.1(this);
  private final Map<Integer, CopyOnWriteArraySet<Object>> mGroupsBySubscriber = new ConcurrentHashMap(10);
  private final DefaultDispatcher.InternalHandler mHandler;
  private final HandlerPoster mHandlerPoster;
  private final Looper mLooper;
  private final Map<DefaultDispatcher.SubscriberKey, CopyOnWriteArraySet<DefaultDispatcher.Wrapper>> mSubscribersByKey = new ConcurrentHashMap(10);
  
  public DefaultDispatcher(Looper paramLooper)
  {
    AssertUtils.checkNotNull(paramLooper);
    this.mLooper = paramLooper;
    this.mHandler = new DefaultDispatcher.InternalHandler(this, paramLooper);
    this.mHandlerPoster = HandlerPosterManager.instance().getHandlerPoster(paramLooper);
    this.mHandlerPoster.addPosterRunner(new DefaultDispatcher.2(this));
  }
  
  private void dispatchSingle(Object paramObject, String paramString, Dispatcher.Dispatchable paramDispatchable)
  {
    AssertUtils.checkNotNull(paramObject);
    AssertUtils.checkNotNull(paramString);
    AssertUtils.checkNotNull(paramDispatchable);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      this.mHandlerPoster.enqueue(paramObject, paramString, paramDispatchable);
      return;
    }
    doDispatch(paramString, paramDispatchable);
  }
  
  private void insertSubscriber(Object paramObject, DefaultDispatcher.Wrapper paramWrapper)
  {
    AssertUtils.checkNotNull(paramObject);
    AssertUtils.checkNotNull(paramWrapper);
    Subscriber localSubscriber = paramWrapper.get();
    Object localObject = new ArrayList(2);
    localSubscriber.accept((List)localObject);
    if (((List)localObject).size() == 0) {
      AssertUtils.fail("Please override accept function in Subscriber", new Object[0]);
    }
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      DefaultDispatcher.SubscriberKey localSubscriberKey = makeKey((Class)localIterator.next(), paramObject);
      CopyOnWriteArraySet localCopyOnWriteArraySet = (CopyOnWriteArraySet)this.mSubscribersByKey.get(localSubscriberKey);
      localObject = localCopyOnWriteArraySet;
      if (localCopyOnWriteArraySet == null)
      {
        localObject = new CopyOnWriteArraySet();
        this.mSubscribersByKey.put(localSubscriberKey, localObject);
      }
      ((CopyOnWriteArraySet)localObject).add(paramWrapper);
    }
    insertToGroupMap(paramObject, localSubscriber);
  }
  
  private void insertToGroupMap(Object paramObject, Subscriber paramSubscriber)
  {
    AssertUtils.checkNotNull(paramObject);
    AssertUtils.checkNotNull(paramSubscriber);
    CopyOnWriteArraySet localCopyOnWriteArraySet2 = (CopyOnWriteArraySet)this.mGroupsBySubscriber.get(Integer.valueOf(paramSubscriber.hashCode()));
    CopyOnWriteArraySet localCopyOnWriteArraySet1 = localCopyOnWriteArraySet2;
    if (localCopyOnWriteArraySet2 == null)
    {
      localCopyOnWriteArraySet1 = new CopyOnWriteArraySet();
      this.mGroupsBySubscriber.put(Integer.valueOf(paramSubscriber.hashCode()), localCopyOnWriteArraySet1);
    }
    localCopyOnWriteArraySet1.add(paramObject);
  }
  
  private DefaultDispatcher.SubscriberKey makeKey(Class<? extends Dispatcher.Dispatchable> paramClass, Object paramObject)
  {
    AssertUtils.checkNotNull(paramClass);
    AssertUtils.checkNotNull(paramObject);
    return new DefaultDispatcher.SubscriberKey(paramClass, paramObject);
  }
  
  private void notifySubscribers(Set<DefaultDispatcher.Wrapper> paramSet, DefaultDispatcher.SubscriberKey paramSubscriberKey, Dispatcher.Dispatchable paramDispatchable)
  {
    AssertUtils.checkNotNull(paramSet);
    AssertUtils.checkNotNull(paramSubscriberKey);
    AssertUtils.checkNotNull(paramDispatchable);
    Iterator localIterator = paramSet.iterator();
    SLog.d("async.dispatch.DefaultDispatcher", "notifySubscribers key=%s, set=%s", new Object[] { paramSubscriberKey, paramSet });
    paramSubscriberKey = new ArrayList(1);
    while (localIterator.hasNext())
    {
      DefaultDispatcher.Wrapper localWrapper = (DefaultDispatcher.Wrapper)localIterator.next();
      Subscriber localSubscriber = localWrapper.get();
      if (localSubscriber == null) {
        paramSubscriberKey.add(localWrapper);
      } else {
        localSubscriber.handleDispatch(paramDispatchable);
      }
    }
    paramSubscriberKey = paramSubscriberKey.iterator();
    while (paramSubscriberKey.hasNext())
    {
      paramDispatchable = (DefaultDispatcher.Wrapper)paramSubscriberKey.next();
      paramSet.remove(paramDispatchable);
      this.mGroupsBySubscriber.remove(Integer.valueOf(paramDispatchable.hashCode()));
    }
  }
  
  private void removeSubscriberData(Class<? extends Dispatcher.Dispatchable> paramClass, Object paramObject, Subscriber paramSubscriber)
  {
    AssertUtils.checkNotNull(paramClass);
    AssertUtils.checkNotNull(paramObject);
    AssertUtils.checkNotNull(paramSubscriber);
    paramClass = makeKey(paramClass, paramObject);
    paramObject = (CopyOnWriteArraySet)this.mSubscribersByKey.get(paramClass);
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramObject.iterator();
      while (localIterator.hasNext())
      {
        DefaultDispatcher.Wrapper localWrapper = (DefaultDispatcher.Wrapper)localIterator.next();
        Subscriber localSubscriber = localWrapper.get();
        if ((localSubscriber != null) && (localSubscriber.equals(paramSubscriber))) {
          localArrayList.add(localWrapper);
        }
      }
      paramObject.removeAll(localArrayList);
      if (paramObject.isEmpty()) {
        this.mSubscribersByKey.remove(paramClass);
      }
      SLog.d("async.dispatch.DefaultDispatcher", "remove subscriber=%s, left=%s", new Object[] { localArrayList, paramObject });
    }
  }
  
  public void cancelDispatch(@Nullable String paramString, Dispatcher.Dispatchable paramDispatchable)
  {
    AssertUtils.checkNotNull(paramDispatchable);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "default_group";
    }
    paramString = PendingPost.obtainPendingPost("async.dispatch.DefaultDispatcher", str, paramDispatchable);
    this.mHandler.removeMessages(16, paramString);
    ((DefaultDispatcher.PostingThreadState)this.mCurrentPostingThreadState.get()).eventQueue.remove(paramString);
  }
  
  public void dispatch(Dispatcher.Dispatchable paramDispatchable)
  {
    dispatch("default_group", paramDispatchable);
  }
  
  public void dispatch(@Nullable String paramString, Dispatcher.Dispatchable paramDispatchable)
  {
    AssertUtils.checkNotNull(paramDispatchable);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "default_group";
    }
    paramString = (DefaultDispatcher.PostingThreadState)this.mCurrentPostingThreadState.get();
    List localList = paramString.eventQueue;
    localList.add(PendingPost.obtainPendingPost("async.dispatch.DefaultDispatcher", str, paramDispatchable));
    if (!paramString.isPosting)
    {
      if (Looper.getMainLooper() == Looper.myLooper()) {}
      for (boolean bool = true;; bool = false)
      {
        paramString.isMainThread = bool;
        paramString.isPosting = true;
        if (!paramString.canceled) {
          break;
        }
        throw new DispatcherException("Internal error. Abort state was not reset");
      }
      try
      {
        if (!localList.isEmpty())
        {
          paramDispatchable = (PendingPost)localList.remove(0);
          dispatchSingle(paramDispatchable.tag, paramDispatchable.group, paramDispatchable.dispatchable);
        }
        return;
      }
      finally
      {
        paramString.isPosting = false;
        paramString.isMainThread = false;
      }
    }
  }
  
  public void dispatchDelayed(Dispatcher.Dispatchable paramDispatchable, int paramInt)
  {
    dispatchDelayed("default_group", paramDispatchable, paramInt);
  }
  
  public void dispatchDelayed(@Nullable String paramString, Dispatcher.Dispatchable paramDispatchable, int paramInt)
  {
    AssertUtils.checkNotNull(paramDispatchable);
    if (paramInt == 0)
    {
      dispatch(paramString, paramDispatchable);
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "default_group";
    }
    paramString = PendingPost.obtainPendingPost("async.dispatch.DefaultDispatcher", str, paramDispatchable);
    paramString = Message.obtain(this.mHandler, 16, paramString);
    this.mHandler.sendMessageDelayed(paramString, paramInt);
  }
  
  void doDispatch(Object paramObject, Dispatcher.Dispatchable paramDispatchable)
  {
    int j = 1;
    AssertUtils.checkNotNull(paramDispatchable);
    AssertUtils.checkNotNull(paramObject);
    int i = 0;
    DefaultDispatcher.SubscriberKey localSubscriberKey = makeKey(paramDispatchable.getClass(), paramObject);
    CopyOnWriteArraySet localCopyOnWriteArraySet = (CopyOnWriteArraySet)this.mSubscribersByKey.get(localSubscriberKey);
    if (localCopyOnWriteArraySet != null)
    {
      notifySubscribers(localCopyOnWriteArraySet, localSubscriberKey, paramDispatchable);
      i = 1;
    }
    localSubscriberKey = makeKey(paramDispatchable.getClass(), "root_group");
    localCopyOnWriteArraySet = (CopyOnWriteArraySet)this.mSubscribersByKey.get(localSubscriberKey);
    if (localCopyOnWriteArraySet != null)
    {
      notifySubscribers(localCopyOnWriteArraySet, localSubscriberKey, paramDispatchable);
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        SLog.d("async.dispatch.DefaultDispatcher", "group = " + paramObject + ", dispatchable = " + paramDispatchable);
      }
      return;
    }
  }
  
  @NonNull
  public Looper getDefaultLooper()
  {
    return this.mLooper;
  }
  
  public void registerSubscriber(Subscriber paramSubscriber)
  {
    registerSubscriber("default_group", paramSubscriber);
  }
  
  public void registerSubscriber(@Nullable String paramString, Subscriber paramSubscriber)
  {
    AssertUtils.checkNotNull(paramSubscriber);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "default_group";
    }
    if (paramSubscriber != null) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtils.assertTrue(bool);
      insertSubscriber(str, new DefaultDispatcher.DefaultWrpper(paramSubscriber));
      return;
    }
  }
  
  public void registerWeakSubscriber(Subscriber paramSubscriber)
  {
    AssertUtils.checkNotNull(paramSubscriber);
    insertSubscriber("default_group", new DefaultDispatcher.WeakWrapper(paramSubscriber));
  }
  
  public void registerWeakSubscriber(@Nullable String paramString, Subscriber paramSubscriber)
  {
    AssertUtils.checkNotNull(paramSubscriber);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "default_group";
    }
    insertSubscriber(str, new DefaultDispatcher.WeakWrapper(paramSubscriber));
  }
  
  public void unRegisterSubscriber(Subscriber paramSubscriber)
  {
    if (paramSubscriber == null) {
      AssertUtils.fail("subscriber cannot be null.", new Object[0]);
    }
    do
    {
      return;
      localObject = new ArrayList(2);
      paramSubscriber.accept((List)localObject);
    } while (((List)localObject).size() == 0);
    CopyOnWriteArraySet localCopyOnWriteArraySet = (CopyOnWriteArraySet)this.mGroupsBySubscriber.get(Integer.valueOf(paramSubscriber.hashCode()));
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Class localClass = (Class)((Iterator)localObject).next();
      if (localCopyOnWriteArraySet != null)
      {
        Iterator localIterator = localCopyOnWriteArraySet.iterator();
        while (localIterator.hasNext()) {
          removeSubscriberData(localClass, localIterator.next(), paramSubscriber);
        }
      }
      else
      {
        removeSubscriberData(localClass, "default_group", paramSubscriber);
      }
    }
    this.mGroupsBySubscriber.remove(Integer.valueOf(paramSubscriber.hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tribe.async.dispatch.DefaultDispatcher
 * JD-Core Version:    0.7.0.1
 */