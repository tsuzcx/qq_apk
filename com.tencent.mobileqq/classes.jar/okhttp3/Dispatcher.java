package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

public final class Dispatcher
{
  @Nullable
  private ExecutorService executorService;
  @Nullable
  private Runnable idleCallback;
  private int maxRequests = 64;
  private int maxRequestsPerHost = 5;
  private final Deque<RealCall.AsyncCall> readyAsyncCalls = new ArrayDeque();
  private final Deque<RealCall.AsyncCall> runningAsyncCalls = new ArrayDeque();
  private final Deque<RealCall> runningSyncCalls = new ArrayDeque();
  
  static
  {
    if (!Dispatcher.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public Dispatcher() {}
  
  public Dispatcher(ExecutorService paramExecutorService)
  {
    this.executorService = paramExecutorService;
  }
  
  private <T> void finished(Deque<T> paramDeque, T paramT)
  {
    try
    {
      if (!paramDeque.remove(paramT)) {
        throw new AssertionError("Call wasn't in-flight!");
      }
    }
    finally {}
    paramDeque = this.idleCallback;
    if ((!promoteAndExecute()) && (paramDeque != null)) {
      paramDeque.run();
    }
  }
  
  private boolean promoteAndExecute()
  {
    int i = 0;
    assert (!Thread.holdsLock(this));
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    label184:
    for (;;)
    {
      try
      {
        Iterator localIterator = this.readyAsyncCalls.iterator();
        RealCall.AsyncCall localAsyncCall;
        if (localIterator.hasNext())
        {
          localAsyncCall = (RealCall.AsyncCall)localIterator.next();
          if (this.runningAsyncCalls.size() < this.maxRequests) {}
        }
        else
        {
          if (runningCallsCount() <= 0) {
            break label184;
          }
          bool = true;
          int j = localArrayList.size();
          if (i >= j) {
            break;
          }
          ((RealCall.AsyncCall)localArrayList.get(i)).executeOn(executorService());
          i += 1;
          continue;
        }
        if (runningCallsForHost(localAsyncCall) < this.maxRequestsPerHost)
        {
          localIterator.remove();
          localArrayList.add(localAsyncCall);
          this.runningAsyncCalls.add(localAsyncCall);
          continue;
          bool = false;
        }
      }
      finally {}
    }
    return bool;
  }
  
  private int runningCallsForHost(RealCall.AsyncCall paramAsyncCall)
  {
    Iterator localIterator = this.runningAsyncCalls.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      RealCall.AsyncCall localAsyncCall = (RealCall.AsyncCall)localIterator.next();
      if (!localAsyncCall.get().forWebSocket)
      {
        if (!localAsyncCall.host().equals(paramAsyncCall.host())) {
          break label67;
        }
        i += 1;
      }
    }
    label67:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public void cancelAll()
  {
    try
    {
      Iterator localIterator1 = this.readyAsyncCalls.iterator();
      while (localIterator1.hasNext()) {
        ((RealCall.AsyncCall)localIterator1.next()).get().cancel();
      }
      localIterator2 = this.runningAsyncCalls.iterator();
    }
    finally {}
    while (localIterator2.hasNext()) {
      ((RealCall.AsyncCall)localIterator2.next()).get().cancel();
    }
    Iterator localIterator2 = this.runningSyncCalls.iterator();
    while (localIterator2.hasNext()) {
      ((RealCall)localIterator2.next()).cancel();
    }
  }
  
  void enqueue(RealCall.AsyncCall paramAsyncCall)
  {
    try
    {
      this.readyAsyncCalls.add(paramAsyncCall);
      promoteAndExecute();
      return;
    }
    finally {}
  }
  
  void executed(RealCall paramRealCall)
  {
    try
    {
      this.runningSyncCalls.add(paramRealCall);
      return;
    }
    finally
    {
      paramRealCall = finally;
      throw paramRealCall;
    }
  }
  
  public ExecutorService executorService()
  {
    try
    {
      if (this.executorService == null) {
        this.executorService = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
      }
      ExecutorService localExecutorService = this.executorService;
      return localExecutorService;
    }
    finally {}
  }
  
  void finished(RealCall.AsyncCall paramAsyncCall)
  {
    finished(this.runningAsyncCalls, paramAsyncCall);
  }
  
  void finished(RealCall paramRealCall)
  {
    finished(this.runningSyncCalls, paramRealCall);
  }
  
  public int getMaxRequests()
  {
    try
    {
      int i = this.maxRequests;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getMaxRequestsPerHost()
  {
    try
    {
      int i = this.maxRequestsPerHost;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<Call> queuedCalls()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.readyAsyncCalls.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((RealCall.AsyncCall)localIterator.next()).get());
      }
      localList2 = Collections.unmodifiableList(localList1);
    }
    finally {}
    List localList2;
    return localList2;
  }
  
  public int queuedCallsCount()
  {
    try
    {
      int i = this.readyAsyncCalls.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<Call> runningCalls()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.runningSyncCalls);
      Iterator localIterator = this.runningAsyncCalls.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((RealCall.AsyncCall)localIterator.next()).get());
      }
      localList2 = Collections.unmodifiableList(localList1);
    }
    finally {}
    List localList2;
    return localList2;
  }
  
  public int runningCallsCount()
  {
    try
    {
      int i = this.runningAsyncCalls.size();
      int j = this.runningSyncCalls.size();
      return i + j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setIdleCallback(@Nullable Runnable paramRunnable)
  {
    try
    {
      this.idleCallback = paramRunnable;
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  public void setMaxRequests(int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("max < 1: " + paramInt);
    }
    try
    {
      this.maxRequests = paramInt;
      promoteAndExecute();
      return;
    }
    finally {}
  }
  
  public void setMaxRequestsPerHost(int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("max < 1: " + paramInt);
    }
    try
    {
      this.maxRequestsPerHost = paramInt;
      promoteAndExecute();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.Dispatcher
 * JD-Core Version:    0.7.0.1
 */