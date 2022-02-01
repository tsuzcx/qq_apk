package org.apache.http.impl.conn.tsccm;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.conn.AbstractPoolEntry;
import org.apache.http.impl.conn.AbstractPooledConnAdapter;

@Deprecated
public class BasicPooledConnAdapter
  extends AbstractPooledConnAdapter
{
  protected BasicPooledConnAdapter(ThreadSafeClientConnManager paramThreadSafeClientConnManager, AbstractPoolEntry paramAbstractPoolEntry)
  {
    super((ClientConnectionManager)null, (AbstractPoolEntry)null);
    throw new RuntimeException("Stub!");
  }
  
  protected void detach()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected ClientConnectionManager getManager()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected AbstractPoolEntry getPoolEntry()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.conn.tsccm.BasicPooledConnAdapter
 * JD-Core Version:    0.7.0.1
 */