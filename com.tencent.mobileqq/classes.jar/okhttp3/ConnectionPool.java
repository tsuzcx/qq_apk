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
  private static final Executor executor = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
  private final Runnable cleanupRunnable = new ConnectionPool.1(this);
  boolean cleanupRunning;
  private final Deque<RealConnection> connections = new ArrayDeque();
  private final long keepAliveDurationNs;
  private final int maxIdleConnections;
  final RouteDatabase routeDatabase = new RouteDatabase();
  
  public ConnectionPool()
  {
    this(5, 5L, TimeUnit.MINUTES);
  }
  
  public ConnectionPool(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    this.maxIdleConnections = paramInt;
    this.keepAliveDurationNs = paramTimeUnit.toNanos(paramLong);
    if (paramLong > 0L) {
      return;
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("keepAliveDuration <= 0: ");
    paramTimeUnit.append(paramLong);
    throw new IllegalArgumentException(paramTimeUnit.toString());
  }
  
  private int pruneAndGetAllocationCount(RealConnection paramRealConnection, long paramLong)
  {
    List localList = paramRealConnection.allocations;
    int i = 0;
    while (i < localList.size())
    {
      Object localObject1 = (Reference)localList.get(i);
      if (((Reference)localObject1).get() != null)
      {
        i += 1;
      }
      else
      {
        localObject1 = (StreamAllocation.StreamAllocationReference)localObject1;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("A connection to ");
        ((StringBuilder)localObject2).append(paramRealConnection.route().address().url());
        ((StringBuilder)localObject2).append(" was leaked. Did you forget to close a response body?");
        localObject2 = ((StringBuilder)localObject2).toString();
        Platform.get().logCloseableLeak((String)localObject2, ((StreamAllocation.StreamAllocationReference)localObject1).callStackTrace);
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
    try
    {
      Iterator localIterator = this.connections.iterator();
      long l1 = -9223372036854775808L;
      Object localObject1 = null;
      int i = 0;
      int j = 0;
      while (localIterator.hasNext())
      {
        RealConnection localRealConnection = (RealConnection)localIterator.next();
        if (pruneAndGetAllocationCount(localRealConnection, paramLong) > 0)
        {
          j += 1;
        }
        else
        {
          int k = i + 1;
          long l2 = paramLong - localRealConnection.idleAtNanos;
          i = k;
          if (l2 > l1)
          {
            localObject1 = localRealConnection;
            l1 = l2;
            i = k;
          }
        }
      }
      if ((l1 < this.keepAliveDurationNs) && (i <= this.maxIdleConnections))
      {
        if (i > 0)
        {
          paramLong = this.keepAliveDurationNs;
          return paramLong - l1;
        }
        if (j > 0)
        {
          paramLong = this.keepAliveDurationNs;
          return paramLong;
        }
        this.cleanupRunning = false;
        return -1L;
      }
      this.connections.remove(localObject1);
      Util.closeQuietly(localObject1.socket());
      return 0L;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  boolean connectionBecameIdle(RealConnection paramRealConnection)
  {
    if ((!paramRealConnection.noNewStreams) && (this.maxIdleConnections != 0))
    {
      notifyAll();
      return false;
    }
    this.connections.remove(paramRealConnection);
    return true;
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
    Object localObject1 = new ArrayList();
    try
    {
      Iterator localIterator = this.connections.iterator();
      while (localIterator.hasNext())
      {
        RealConnection localRealConnection = (RealConnection)localIterator.next();
        if (localRealConnection.allocations.isEmpty())
        {
          localRealConnection.noNewStreams = true;
          ((List)localObject1).add(localRealConnection);
          localIterator.remove();
        }
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        Util.closeQuietly(((RealConnection)((Iterator)localObject1).next()).socket());
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  @Nullable
  RealConnection get(Address paramAddress, StreamAllocation paramStreamAllocation, Route paramRoute)
  {
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
    try
    {
      Iterator localIterator = this.connections.iterator();
      while (localIterator.hasNext())
      {
        boolean bool = ((RealConnection)localIterator.next()).allocations.isEmpty();
        if (bool) {
          i += 1;
        }
      }
      return i;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  void put(RealConnection paramRealConnection)
  {
    if (!this.cleanupRunning)
    {
      this.cleanupRunning = true;
      executor.execute(this.cleanupRunnable);
    }
    this.connections.add(paramRealConnection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.ConnectionPool
 * JD-Core Version:    0.7.0.1
 */