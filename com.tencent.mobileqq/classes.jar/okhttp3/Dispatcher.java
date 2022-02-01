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
  
  public Dispatcher() {}
  
  public Dispatcher(ExecutorService paramExecutorService)
  {
    this.executorService = paramExecutorService;
  }
  
  private <T> void finished(Deque<T> paramDeque, T paramT)
  {
    try
    {
      if (paramDeque.remove(paramT))
      {
        paramDeque = this.idleCallback;
        if ((!promoteAndExecute()) && (paramDeque != null)) {
          paramDeque.run();
        }
        return;
      }
      throw new AssertionError("Call wasn't in-flight!");
    }
    finally {}
  }
  
  private boolean promoteAndExecute()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = this.readyAsyncCalls.iterator();
      while (localIterator.hasNext())
      {
        RealCall.AsyncCall localAsyncCall = (RealCall.AsyncCall)localIterator.next();
        if (this.runningAsyncCalls.size() >= this.maxRequests) {
          break;
        }
        if (runningCallsForHost(localAsyncCall) < this.maxRequestsPerHost)
        {
          localIterator.remove();
          localArrayList.add(localAsyncCall);
          this.runningAsyncCalls.add(localAsyncCall);
        }
      }
      j = runningCallsCount();
      i = 0;
      if (j <= 0) {
        break label182;
      }
      bool = true;
    }
    finally
    {
      for (;;)
      {
        int j;
        int i;
        for (;;)
        {
          throw localObject;
        }
        boolean bool = false;
      }
    }
    j = localArrayList.size();
    while (i < j)
    {
      ((RealCall.AsyncCall)localArrayList.get(i)).executeOn(executorService());
      i += 1;
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
      if ((!localAsyncCall.get().forWebSocket) && (localAsyncCall.host().equals(paramAsyncCall.host()))) {
        i += 1;
      }
    }
    return i;
  }
  
  public void cancelAll()
  {
    try
    {
      Iterator localIterator = this.readyAsyncCalls.iterator();
      while (localIterator.hasNext()) {
        ((RealCall.AsyncCall)localIterator.next()).get().cancel();
      }
      localIterator = this.runningAsyncCalls.iterator();
      while (localIterator.hasNext()) {
        ((RealCall.AsyncCall)localIterator.next()).get().cancel();
      }
      localIterator = this.runningSyncCalls.iterator();
      while (localIterator.hasNext()) {
        ((RealCall)localIterator.next()).cancel();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
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
      Object localObject1 = new ArrayList();
      Iterator localIterator = this.readyAsyncCalls.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject1).add(((RealCall.AsyncCall)localIterator.next()).get());
      }
      localObject1 = Collections.unmodifiableList((List)localObject1);
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
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
      Object localObject1 = new ArrayList();
      ((List)localObject1).addAll(this.runningSyncCalls);
      Iterator localIterator = this.runningAsyncCalls.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject1).add(((RealCall.AsyncCall)localIterator.next()).get());
      }
      localObject1 = Collections.unmodifiableList((List)localObject1);
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
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
    if (paramInt >= 1) {
      try
      {
        this.maxRequests = paramInt;
        promoteAndExecute();
        return;
      }
      finally {}
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("max < 1: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setMaxRequestsPerHost(int paramInt)
  {
    if (paramInt >= 1) {
      try
      {
        this.maxRequestsPerHost = paramInt;
        promoteAndExecute();
        return;
      }
      finally {}
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("max < 1: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.Dispatcher
 * JD-Core Version:    0.7.0.1
 */