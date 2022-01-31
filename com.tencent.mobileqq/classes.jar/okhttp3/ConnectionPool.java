package okhttp3;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.connection.StreamAllocation.StreamAllocationReference;
import okhttp3.internal.platform.Platform;

public final class ConnectionPool
{
  private static final Executor executor;
  private final Runnable cleanupRunnable = new ConnectionPool.1(this);
  boolean cleanupRunning;
  private final Deque<RealConnection> connections = new ArrayDeque();
  private final long keepAliveDurationNs;
  private final int maxIdleConnections;
  final RouteDatabase routeDatabase = new RouteDatabase();
  
  static
  {
    if (!ConnectionPool.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      executor = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
      return;
    }
  }
  
  public ConnectionPool()
  {
    this(5, 5L, TimeUnit.MINUTES);
  }
  
  public ConnectionPool(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    this.maxIdleConnections = paramInt;
    this.keepAliveDurationNs = paramTimeUnit.toNanos(paramLong);
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("keepAliveDuration <= 0: " + paramLong);
    }
  }
  
  private int pruneAndGetAllocationCount(RealConnection paramRealConnection, long paramLong)
  {
    List localList = paramRealConnection.allocations;
    int i = 0;
    while (i < localList.size())
    {
      Object localObject = (Reference)localList.get(i);
      if (((Reference)localObject).get() != null)
      {
        i += 1;
      }
      else
      {
        localObject = (StreamAllocation.StreamAllocationReference)localObject;
        String str = "A connection to " + paramRealConnection.route().address().url() + " was leaked. Did you forget to close a response body?";
        Platform.get().logCloseableLeak(str, ((StreamAllocation.StreamAllocationReference)localObject).callStackTrace);
        localList.remove(i);
        paramRealConnection.noNewStreams = true;
        if (localList.isEmpty())
        {
          paramRealConnection.idleAtNanos = (paramLong - this.keepAliveDurationNs);
          return 0;
        }
      }
    }
    return localList.size();
  }
  
  long cleanup(long paramLong)
  {
    Object localObject1 = null;
    long l1 = -9223372036854775808L;
    for (;;)
    {
      int j;
      int i;
      try
      {
        Iterator localIterator = this.connections.iterator();
        j = 0;
        i = 0;
        if (localIterator.hasNext())
        {
          RealConnection localRealConnection = (RealConnection)localIterator.next();
          if (pruneAndGetAllocationCount(localRealConnection, paramLong) > 0)
          {
            i += 1;
            continue;
          }
          long l2 = paramLong - localRealConnection.idleAtNanos;
          if (l2 <= l1) {
            break label184;
          }
          localObject1 = localRealConnection;
          l1 = l2;
          break label184;
        }
        if ((l1 >= this.keepAliveDurationNs) || (j > this.maxIdleConnections))
        {
          this.connections.remove(localObject1);
          Util.closeQuietly(localObject1.socket());
          return 0L;
        }
        if (j > 0)
        {
          paramLong = this.keepAliveDurationNs;
          return paramLong - l1;
        }
      }
      finally {}
      if (i > 0)
      {
        paramLong = this.keepAliveDurationNs;
        return paramLong;
      }
      this.cleanupRunning = false;
      return -1L;
      label184:
      j += 1;
    }
  }
  
  boolean connectionBecameIdle(RealConnection paramRealConnection)
  {
    assert (Thread.holdsLock(this));
    if ((paramRealConnection.noNewStreams) || (this.maxIdleConnections == 0))
    {
      this.connections.remove(paramRealConnection);
      return true;
    }
    notifyAll();
    return false;
  }
  
  public int connectionCount()
  {
    try
    {
      int i = this.connections.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Nullable
  Socket deduplicate(Address paramAddress, StreamAllocation paramStreamAllocation)
  {
    assert (Thread.holdsLock(this));
    Iterator localIterator = this.connections.iterator();
    while (localIterator.hasNext())
    {
      RealConnection localRealConnection = (RealConnection)localIterator.next();
      if ((localRealConnection.isEligible(paramAddress, null)) && (localRealConnection.isMultiplexed()) && (localRealConnection != paramStreamAllocation.connection())) {
        return paramStreamAllocation.releaseAndAcquire(localRealConnection);
      }
    }
    return null;
  }
  
  public void evictAll()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator2 = this.connections.iterator();
      while (localIterator2.hasNext())
      {
        RealConnection localRealConnection = (RealConnection)localIterator2.next();
        if (localRealConnection.allocations.isEmpty())
        {
          localRealConnection.noNewStreams = true;
          localArrayList.add(localRealConnection);
          localIterator2.remove();
        }
      }
    }
    finally {}
    Iterator localIterator1 = localObject.iterator();
    while (localIterator1.hasNext()) {
      Util.closeQuietly(((RealConnection)localIterator1.next()).socket());
    }
  }
  
  @Nullable
  RealConnection get(Address paramAddress, StreamAllocation paramStreamAllocation, Route paramRoute)
  {
    assert (Thread.holdsLock(this));
    Iterator localIterator = this.connections.iterator();
    while (localIterator.hasNext())
    {
      RealConnection localRealConnection = (RealConnection)localIterator.next();
      if (localRealConnection.isEligible(paramAddress, paramRoute))
      {
        paramStreamAllocation.acquire(localRealConnection, true);
        return localRealConnection;
      }
    }
    return null;
  }
  
  public int idleConnectionCount()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.connections.iterator();
        if (localIterator.hasNext())
        {
          boolean bool = ((RealConnection)localIterator.next()).allocations.isEmpty();
          if (bool) {
            i += 1;
          }
        }
        else
        {
          return i;
        }
      }
      finally {}
    }
  }
  
  void put(RealConnection paramRealConnection)
  {
    assert (Thread.holdsLock(this));
    if (!this.cleanupRunning)
    {
      this.cleanupRunning = true;
      executor.execute(this.cleanupRunnable);
    }
    this.connections.add(paramRealConnection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.ConnectionPool
 * JD-Core Version:    0.7.0.1
 */