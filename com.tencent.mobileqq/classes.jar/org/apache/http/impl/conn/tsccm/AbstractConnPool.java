package org.apache.http.impl.conn.tsccm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.IdleConnectionHandler;

@Deprecated
public abstract class AbstractConnPool
  implements RefQueueHandler
{
  protected IdleConnectionHandler idleConnHandler;
  protected volatile boolean isShutDown;
  protected Set<BasicPoolEntryRef> issuedConnections;
  protected int numConnections;
  protected final Lock poolLock;
  protected ReferenceQueue<Object> refQueue;
  
  protected AbstractConnPool()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void closeConnection(OperatedClientConnection paramOperatedClientConnection)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void closeExpiredConnections()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void closeIdleConnections(long paramLong, TimeUnit paramTimeUnit)
  {
    throw new RuntimeException("Stub!");
  }
  
  public abstract void deleteClosedConnections();
  
  public void enableConnectionGC()
  {
    throw new RuntimeException("Stub!");
  }
  
  public abstract void freeEntry(BasicPoolEntry paramBasicPoolEntry, boolean paramBoolean, long paramLong, TimeUnit paramTimeUnit);
  
  public final BasicPoolEntry getEntry(HttpRoute paramHttpRoute, Object paramObject, long paramLong, TimeUnit paramTimeUnit)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected abstract void handleLostEntry(HttpRoute paramHttpRoute);
  
  public void handleReference(Reference paramReference)
  {
    throw new RuntimeException("Stub!");
  }
  
  public abstract PoolEntryRequest requestPoolEntry(HttpRoute paramHttpRoute, Object paramObject);
  
  public void shutdown()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.conn.tsccm.AbstractConnPool
 * JD-Core Version:    0.7.0.1
 */