package com.tribe.async.dispatch;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tribe.async.log.SLog;
import com.tribe.async.utils.AssertUtils;
import java.lang.ref.WeakReference;
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
  private final ThreadLocal<PostingThreadState> mCurrentPostingThreadState = new ThreadLocal()
  {
    protected DefaultDispatcher.PostingThreadState initialValue()
    {
      return new DefaultDispatcher.PostingThreadState();
    }
  };
  private final Map<Integer, CopyOnWriteArraySet<Object>> mGroupsBySubscriber = new ConcurrentHashMap(10);
  private final InternalHandler mHandler;
  private final HandlerPoster mHandlerPoster;
  private final Looper mLooper;
  private final Map<SubscriberKey, CopyOnWriteArraySet<Wrapper>> mSubscribersByKey = new ConcurrentHashMap(10);
  
  public DefaultDispatcher(Looper paramLooper)
  {
    AssertUtils.checkNotNull(paramLooper);
    this.mLooper = paramLooper;
    this.mHandler = new InternalHandler(paramLooper);
    this.mHandlerPoster = HandlerPosterManager.instance().getHandlerPoster(paramLooper);
    this.mHandlerPoster.addPosterRunner(new HandlerPoster.PosterRunner()
    {
      public boolean acceptTag(Object paramAnonymousObject)
      {
        return "async.dispatch.DefaultDispatcher" == paramAnonymousObject;
      }
      
      public void run(@NonNull String paramAnonymousString, @NonNull Dispatcher.Dispatchable paramAnonymousDispatchable)
      {
        DefaultDispatcher.this.doDispatch(paramAnonymousString, paramAnonymousDispatchable);
      }
    });
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
  
  private void insertSubscriber(Object paramObject, Wrapper paramWrapper)
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
      SubscriberKey localSubscriberKey = makeKey((Class)localIterator.next(), paramObject);
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
  
  private SubscriberKey makeKey(Class<? extends Dispatcher.Dispatchable> paramClass, Object paramObject)
  {
    AssertUtils.checkNotNull(paramClass);
    AssertUtils.checkNotNull(paramObject);
    return new SubscriberKey(paramClass, paramObject);
  }
  
  private void notifySubscribers(Set<Wrapper> paramSet, SubscriberKey paramSubscriberKey, Dispatcher.Dispatchable paramDispatchable)
  {
    AssertUtils.checkNotNull(paramSet);
    AssertUtils.checkNotNull(paramSubscriberKey);
    AssertUtils.checkNotNull(paramDispatchable);
    paramSubscriberKey = paramSet.iterator();
    ArrayList localArrayList = new ArrayList(1);
    while (paramSubscriberKey.hasNext())
    {
      Wrapper localWrapper = (Wrapper)paramSubscriberKey.next();
      Subscriber localSubscriber = localWrapper.get();
      if (localSubscriber == null) {
        localArrayList.add(localWrapper);
      } else {
        localSubscriber.handleDispatch(paramDispatchable);
      }
    }
    paramSubscriberKey = localArrayList.iterator();
    while (paramSubscriberKey.hasNext())
    {
      paramDispatchable = (Wrapper)paramSubscriberKey.next();
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
        Wrapper localWrapper = (Wrapper)localIterator.next();
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
    ((PostingThreadState)this.mCurrentPostingThreadState.get()).eventQueue.remove(paramString);
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
    paramString = (PostingThreadState)this.mCurrentPostingThreadState.get();
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
    AssertUtils.checkNotNull(paramDispatchable);
    AssertUtils.checkNotNull(paramObject);
    int i = 0;
    SubscriberKey localSubscriberKey = makeKey(paramDispatchable.getClass(), paramObject);
    CopyOnWriteArraySet localCopyOnWriteArraySet = (CopyOnWriteArraySet)this.mSubscribersByKey.get(localSubscriberKey);
    if (localCopyOnWriteArraySet != null)
    {
      i = 1;
      notifySubscribers(localCopyOnWriteArraySet, localSubscriberKey, paramDispatchable);
    }
    localSubscriberKey = makeKey(paramDispatchable.getClass(), "root_group");
    localCopyOnWriteArraySet = (CopyOnWriteArraySet)this.mSubscribersByKey.get(localSubscriberKey);
    if (localCopyOnWriteArraySet != null)
    {
      i = 1;
      notifySubscribers(localCopyOnWriteArraySet, localSubscriberKey, paramDispatchable);
    }
    if (i != 0) {
      SLog.d("async.dispatch.DefaultDispatcher", "group = " + paramObject + ", dispatchable = " + paramDispatchable);
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
      insertSubscriber(str, new DefaultWrpper(paramSubscriber));
      return;
    }
  }
  
  public void registerWeakSubscriber(Subscriber paramSubscriber)
  {
    AssertUtils.checkNotNull(paramSubscriber);
    insertSubscriber("default_group", new WeakWrapper(paramSubscriber));
  }
  
  public void registerWeakSubscriber(@Nullable String paramString, Subscriber paramSubscriber)
  {
    AssertUtils.checkNotNull(paramSubscriber);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "default_group";
    }
    insertSubscriber(str, new WeakWrapper(paramSubscriber));
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
  
  private static class DefaultWrpper
    implements DefaultDispatcher.Wrapper
  {
    private final Subscriber mSubscriber;
    
    public DefaultWrpper(Subscriber paramSubscriber)
    {
      AssertUtils.checkNotNull(paramSubscriber);
      this.mSubscriber = paramSubscriber;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == null) {}
      while (!(paramObject instanceof DefaultWrpper)) {
        return false;
      }
      paramObject = (DefaultWrpper)paramObject;
      return this.mSubscriber.equals(paramObject.get());
    }
    
    public Subscriber get()
    {
      return this.mSubscriber;
    }
    
    public int hashCode()
    {
      return this.mSubscriber.hashCode();
    }
    
    public String toString()
    {
      return "DefaultWrapper_" + this.mSubscriber.toString();
    }
  }
  
  private class InternalHandler
    extends Handler
  {
    public InternalHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      paramMessage = (PendingPost)paramMessage.obj;
      DefaultDispatcher.this.mHandlerPoster.enqueue(paramMessage.tag, paramMessage.group, paramMessage.dispatchable);
      PendingPost.releasePendingPost(paramMessage);
    }
  }
  
  static final class PostingThreadState
  {
    boolean canceled;
    final List<PendingPost> eventQueue = new ArrayList();
    boolean isMainThread;
    boolean isPosting;
  }
  
  private static class SubscriberKey
  {
    public final Class<? extends Dispatcher.Dispatchable> dispatchClass;
    public final Object group;
    
    public SubscriberKey(Class<? extends Dispatcher.Dispatchable> paramClass, Object paramObject)
    {
      AssertUtils.checkNotNull(paramClass);
      AssertUtils.checkNotNull(paramObject);
      this.dispatchClass = paramClass;
      this.group = paramObject;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof SubscriberKey)) {
        return false;
      }
      if ((this.dispatchClass.equals(((SubscriberKey)paramObject).dispatchClass)) && (this.group.equals(((SubscriberKey)paramObject).group))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public int hashCode()
    {
      return this.dispatchClass.hashCode();
    }
    
    public String toString()
    {
      return "SubscriberKey{dispatchClass=" + this.dispatchClass + ", group=" + this.group + '}';
    }
  }
  
  private static class WeakWrapper
    implements DefaultDispatcher.Wrapper
  {
    private int mHashCode;
    private WeakReference<Subscriber> mSubscriberRef;
    
    public WeakWrapper(Subscriber paramSubscriber)
    {
      AssertUtils.checkNotNull(paramSubscriber);
      this.mHashCode = paramSubscriber.hashCode();
      this.mSubscriberRef = new WeakReference(paramSubscriber);
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == null) {}
      Object localObject;
      do
      {
        do
        {
          return false;
        } while (!(paramObject instanceof WeakWrapper));
        localObject = (WeakWrapper)paramObject;
        paramObject = get();
        localObject = ((WeakWrapper)localObject).get();
        if ((paramObject == null) && (localObject == null)) {
          return true;
        }
      } while (paramObject == null);
      return paramObject.equals(localObject);
    }
    
    public Subscriber get()
    {
      return (Subscriber)this.mSubscriberRef.get();
    }
    
    public int hashCode()
    {
      return this.mHashCode;
    }
    
    public String toString()
    {
      Object localObject = get();
      if (localObject == null) {}
      for (localObject = this.mHashCode + "";; localObject = localObject.toString()) {
        return "WeakWrapper_" + (String)localObject;
      }
    }
  }
  
  private static abstract interface Wrapper
  {
    public abstract Subscriber get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.dispatch.DefaultDispatcher
 * JD-Core Version:    0.7.0.1
 */