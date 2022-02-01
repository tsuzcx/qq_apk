package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

public final class StreamAllocation
{
  public final Address address;
  public final Call call;
  private final Object callStackTrace;
  private boolean canceled;
  private HttpCodec codec;
  private RealConnection connection;
  private final ConnectionPool connectionPool;
  public final EventListener eventListener;
  private int refusedStreamCount;
  private boolean released;
  private boolean reportedAcquired;
  private Route route;
  private RouteSelector.Selection routeSelection;
  private final RouteSelector routeSelector;
  
  public StreamAllocation(ConnectionPool paramConnectionPool, Address paramAddress, Call paramCall, EventListener paramEventListener, Object paramObject)
  {
    this.connectionPool = paramConnectionPool;
    this.address = paramAddress;
    this.call = paramCall;
    this.eventListener = paramEventListener;
    this.routeSelector = new RouteSelector(paramAddress, routeDatabase(), paramCall, paramEventListener);
    this.callStackTrace = paramObject;
  }
  
  private Socket deallocate(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {
      this.codec = null;
    }
    if (paramBoolean2) {
      this.released = true;
    }
    Object localObject = this.connection;
    if (localObject != null)
    {
      if (paramBoolean1) {
        ((RealConnection)localObject).noNewStreams = true;
      }
      if ((this.codec == null) && ((this.released) || (this.connection.noNewStreams)))
      {
        release(this.connection);
        if (this.connection.allocations.isEmpty())
        {
          this.connection.idleAtNanos = System.nanoTime();
          if (Internal.instance.connectionBecameIdle(this.connectionPool, this.connection))
          {
            localObject = this.connection.socket();
            break label128;
          }
        }
        localObject = null;
        label128:
        this.connection = null;
        return localObject;
      }
    }
    return null;
  }
  
  private RealConnection findConnection(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    Object localObject6;
    int i;
    Object localObject7;
    int k;
    label242:
    Object localObject5;
    label645:
    label648:
    label662:
    synchronized (this.connectionPool)
    {
      if (!this.released)
      {
        if (this.codec == null)
        {
          if (!this.canceled)
          {
            localObject6 = this.connection;
            Object localObject11 = releaseIfNoNewStreams();
            Object localObject1 = this.connection;
            Object localObject9 = null;
            if (localObject1 != null)
            {
              localObject1 = this.connection;
              localObject6 = null;
              ??? = localObject6;
              if (!this.reportedAcquired) {
                ??? = null;
              }
              if (localObject1 != null) {
                break label645;
              }
              Internal.instance.get(this.connectionPool, this.address, this, null);
              if (this.connection != null)
              {
                localObject6 = this.connection;
                localObject1 = null;
                i = 1;
              }
              else
              {
                localObject7 = this.route;
                break label648;
              }
              Util.closeQuietly((Socket)localObject11);
              if (??? != null) {
                this.eventListener.connectionReleased(this.call, (Connection)???);
              }
              if (i != 0) {
                this.eventListener.connectionAcquired(this.call, (Connection)localObject6);
              }
              if (localObject6 != null)
              {
                this.route = this.connection.route();
                return localObject6;
              }
              if (localObject1 == null)
              {
                localObject7 = this.routeSelection;
                if ((localObject7 == null) || (!((RouteSelector.Selection)localObject7).hasNext()))
                {
                  this.routeSelection = this.routeSelector.next();
                  k = 1;
                  break label242;
                }
              }
              k = 0;
              synchronized (this.connectionPool)
              {
                if (!this.canceled)
                {
                  int j = i;
                  localObject7 = localObject6;
                  if (k != 0)
                  {
                    ??? = this.routeSelection.getAll();
                    int m = ((List)???).size();
                    k = 0;
                    j = i;
                    localObject7 = localObject6;
                    if (k < m)
                    {
                      localObject11 = (Route)((List)???).get(k);
                      Internal.instance.get(this.connectionPool, this.address, this, (Route)localObject11);
                      if (this.connection == null) {
                        break label662;
                      }
                      localObject7 = this.connection;
                      this.route = ((Route)localObject11);
                      j = 1;
                    }
                  }
                  localObject6 = localObject7;
                  if (j == 0)
                  {
                    localObject6 = localObject1;
                    if (localObject1 == null) {
                      localObject6 = this.routeSelection.next();
                    }
                    this.route = ((Route)localObject6);
                    this.refusedStreamCount = 0;
                    localObject6 = new RealConnection(this.connectionPool, (Route)localObject6);
                    acquire((RealConnection)localObject6, false);
                  }
                  if (j != 0)
                  {
                    this.eventListener.connectionAcquired(this.call, (Connection)localObject6);
                    return localObject6;
                  }
                  ((RealConnection)localObject6).connect(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, this.call, this.eventListener);
                  routeDatabase().connected(((RealConnection)localObject6).route());
                  synchronized (this.connectionPool)
                  {
                    this.reportedAcquired = true;
                    Internal.instance.put(this.connectionPool, (RealConnection)localObject6);
                    localObject7 = localObject9;
                    localObject1 = localObject6;
                    if (((RealConnection)localObject6).isMultiplexed())
                    {
                      localObject7 = Internal.instance.deduplicate(this.connectionPool, this.address, this);
                      localObject1 = this.connection;
                    }
                    Util.closeQuietly((Socket)localObject7);
                    this.eventListener.connectionAcquired(this.call, (Connection)localObject1);
                    return localObject1;
                  }
                }
                throw new IOException("Canceled");
              }
            }
          }
          else
          {
            throw new IOException("Canceled");
          }
        }
        else {
          throw new IllegalStateException("codec != null");
        }
      }
      else {
        throw new IllegalStateException("released");
      }
    }
  }
  
  private RealConnection findHealthyConnection(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      RealConnection localRealConnection = findConnection(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1);
      synchronized (this.connectionPool)
      {
        if ((localRealConnection.successCount == 0) && (!localRealConnection.isMultiplexed())) {
          return localRealConnection;
        }
        if (!localRealConnection.isHealthy(paramBoolean2)) {
          noNewStreams();
        } else {
          return localRealConnection;
        }
      }
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void release(RealConnection paramRealConnection)
  {
    int j = paramRealConnection.allocations.size();
    int i = 0;
    while (i < j)
    {
      if (((Reference)paramRealConnection.allocations.get(i)).get() == this)
      {
        paramRealConnection.allocations.remove(i);
        return;
      }
      i += 1;
    }
    paramRealConnection = new IllegalStateException();
    for (;;)
    {
      throw paramRealConnection;
    }
  }
  
  private Socket releaseIfNoNewStreams()
  {
    RealConnection localRealConnection = this.connection;
    if ((localRealConnection != null) && (localRealConnection.noNewStreams)) {
      return deallocate(false, false, true);
    }
    return null;
  }
  
  private RouteDatabase routeDatabase()
  {
    return Internal.instance.routeDatabase(this.connectionPool);
  }
  
  public void acquire(RealConnection paramRealConnection, boolean paramBoolean)
  {
    if (this.connection == null)
    {
      this.connection = paramRealConnection;
      this.reportedAcquired = paramBoolean;
      paramRealConnection.allocations.add(new StreamAllocation.StreamAllocationReference(this, this.callStackTrace));
      return;
    }
    throw new IllegalStateException();
  }
  
  public void cancel()
  {
    synchronized (this.connectionPool)
    {
      this.canceled = true;
      HttpCodec localHttpCodec = this.codec;
      RealConnection localRealConnection = this.connection;
      if (localHttpCodec != null)
      {
        localHttpCodec.cancel();
        return;
      }
      if (localRealConnection != null) {
        localRealConnection.cancel();
      }
      return;
    }
  }
  
  public HttpCodec codec()
  {
    synchronized (this.connectionPool)
    {
      HttpCodec localHttpCodec = this.codec;
      return localHttpCodec;
    }
  }
  
  public RealConnection connection()
  {
    try
    {
      RealConnection localRealConnection = this.connection;
      return localRealConnection;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean hasMoreRoutes()
  {
    if (this.route == null)
    {
      RouteSelector.Selection localSelection = this.routeSelection;
      if (((localSelection == null) || (!localSelection.hasNext())) && (!this.routeSelector.hasNext())) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public HttpCodec newStream(okhttp3.OkHttpClient arg1, okhttp3.Interceptor.Chain paramChain, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface 266 1 0
    //   6: istore 4
    //   8: aload_2
    //   9: invokeinterface 269 1 0
    //   14: istore 5
    //   16: aload_2
    //   17: invokeinterface 272 1 0
    //   22: istore 6
    //   24: aload_1
    //   25: invokevirtual 277	okhttp3/OkHttpClient:pingIntervalMillis	()I
    //   28: istore 7
    //   30: aload_1
    //   31: invokevirtual 280	okhttp3/OkHttpClient:retryOnConnectionFailure	()Z
    //   34: istore 8
    //   36: aload_0
    //   37: iload 4
    //   39: iload 5
    //   41: iload 6
    //   43: iload 7
    //   45: iload 8
    //   47: iload_3
    //   48: invokespecial 282	okhttp3/internal/connection/StreamAllocation:findHealthyConnection	(IIIIZZ)Lokhttp3/internal/connection/RealConnection;
    //   51: aload_1
    //   52: aload_2
    //   53: aload_0
    //   54: invokevirtual 286	okhttp3/internal/connection/RealConnection:newCodec	(Lokhttp3/OkHttpClient;Lokhttp3/Interceptor$Chain;Lokhttp3/internal/connection/StreamAllocation;)Lokhttp3/internal/http/HttpCodec;
    //   57: astore_2
    //   58: aload_0
    //   59: getfield 41	okhttp3/internal/connection/StreamAllocation:connectionPool	Lokhttp3/ConnectionPool;
    //   62: astore_1
    //   63: aload_1
    //   64: monitorenter
    //   65: aload_0
    //   66: aload_2
    //   67: putfield 64	okhttp3/internal/connection/StreamAllocation:codec	Lokhttp3/internal/http/HttpCodec;
    //   70: aload_1
    //   71: monitorexit
    //   72: aload_2
    //   73: areturn
    //   74: astore_2
    //   75: aload_1
    //   76: monitorexit
    //   77: aload_2
    //   78: athrow
    //   79: astore_1
    //   80: new 288	okhttp3/internal/connection/RouteException
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 291	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	StreamAllocation
    //   0	89	2	paramChain	okhttp3.Interceptor.Chain
    //   0	89	3	paramBoolean	boolean
    //   6	32	4	i	int
    //   14	26	5	j	int
    //   22	20	6	k	int
    //   28	16	7	m	int
    //   34	12	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   65	72	74	finally
    //   75	77	74	finally
    //   36	65	79	java/io/IOException
    //   77	79	79	java/io/IOException
  }
  
  public void noNewStreams()
  {
    synchronized (this.connectionPool)
    {
      RealConnection localRealConnection = this.connection;
      Socket localSocket = deallocate(true, false, false);
      if (this.connection != null) {
        localRealConnection = null;
      }
      Util.closeQuietly(localSocket);
      if (localRealConnection != null) {
        this.eventListener.connectionReleased(this.call, localRealConnection);
      }
      return;
    }
  }
  
  public void release()
  {
    synchronized (this.connectionPool)
    {
      RealConnection localRealConnection = this.connection;
      Socket localSocket = deallocate(false, true, false);
      if (this.connection != null) {
        localRealConnection = null;
      }
      Util.closeQuietly(localSocket);
      if (localRealConnection != null)
      {
        Internal.instance.timeoutExit(this.call, null);
        this.eventListener.connectionReleased(this.call, localRealConnection);
        this.eventListener.callEnd(this.call);
      }
      return;
    }
  }
  
  public Socket releaseAndAcquire(RealConnection paramRealConnection)
  {
    if ((this.codec == null) && (this.connection.allocations.size() == 1))
    {
      Reference localReference = (Reference)this.connection.allocations.get(0);
      Socket localSocket = deallocate(true, false, false);
      this.connection = paramRealConnection;
      paramRealConnection.allocations.add(localReference);
      return localSocket;
    }
    throw new IllegalStateException();
  }
  
  public Route route()
  {
    return this.route;
  }
  
  public void streamFailed(IOException paramIOException)
  {
    for (;;)
    {
      synchronized (this.connectionPool)
      {
        if ((paramIOException instanceof StreamResetException))
        {
          paramIOException = ((StreamResetException)paramIOException).errorCode;
          if (paramIOException == ErrorCode.REFUSED_STREAM)
          {
            this.refusedStreamCount += 1;
            if (this.refusedStreamCount <= 1) {
              break label200;
            }
            this.route = null;
          }
          else
          {
            if (paramIOException == ErrorCode.CANCEL) {
              break label200;
            }
            this.route = null;
          }
        }
        else
        {
          if ((this.connection == null) || ((this.connection.isMultiplexed()) && (!(paramIOException instanceof ConnectionShutdownException)))) {
            break label200;
          }
          if (this.connection.successCount == 0)
          {
            if ((this.route != null) && (paramIOException != null)) {
              this.routeSelector.connectFailed(this.route, paramIOException);
            }
            this.route = null;
            break label195;
            paramIOException = this.connection;
            Socket localSocket = deallocate(bool, false, true);
            if ((this.connection != null) || (!this.reportedAcquired)) {
              break label205;
            }
            Util.closeQuietly(localSocket);
            if (paramIOException != null) {
              this.eventListener.connectionReleased(this.call, paramIOException);
            }
            return;
          }
        }
      }
      label195:
      boolean bool = true;
      continue;
      label200:
      bool = false;
      continue;
      label205:
      paramIOException = null;
    }
  }
  
  public void streamFinished(boolean paramBoolean, HttpCodec paramHttpCodec, long paramLong, IOException paramIOException)
  {
    this.eventListener.responseBodyEnd(this.call, paramLong);
    ConnectionPool localConnectionPool = this.connectionPool;
    if (paramHttpCodec != null) {}
    try
    {
      if (paramHttpCodec == this.codec)
      {
        if (!paramBoolean)
        {
          paramHttpCodec = this.connection;
          paramHttpCodec.successCount += 1;
        }
        paramHttpCodec = this.connection;
        Socket localSocket = deallocate(paramBoolean, false, true);
        if (this.connection != null) {
          paramHttpCodec = null;
        }
        paramBoolean = this.released;
        Util.closeQuietly(localSocket);
        if (paramHttpCodec != null) {
          this.eventListener.connectionReleased(this.call, paramHttpCodec);
        }
        if (paramIOException != null)
        {
          paramHttpCodec = Internal.instance.timeoutExit(this.call, paramIOException);
          this.eventListener.callFailed(this.call, paramHttpCodec);
          return;
        }
        if (paramBoolean)
        {
          Internal.instance.timeoutExit(this.call, null);
          this.eventListener.callEnd(this.call);
        }
        return;
      }
      paramIOException = new StringBuilder();
      paramIOException.append("expected ");
      paramIOException.append(this.codec);
      paramIOException.append(" but was ");
      paramIOException.append(paramHttpCodec);
      throw new IllegalStateException(paramIOException.toString());
    }
    finally {}
  }
  
  public String toString()
  {
    RealConnection localRealConnection = connection();
    if (localRealConnection != null) {
      return localRealConnection.toString();
    }
    return this.address.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.connection.StreamAllocation
 * JD-Core Version:    0.7.0.1
 */