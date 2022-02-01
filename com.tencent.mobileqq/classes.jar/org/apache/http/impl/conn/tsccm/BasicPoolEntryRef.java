package org.apache.http.impl.conn.tsccm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import org.apache.http.conn.routing.HttpRoute;

@Deprecated
public class BasicPoolEntryRef
  extends WeakReference<BasicPoolEntry>
{
  public BasicPoolEntryRef(BasicPoolEntry paramBasicPoolEntry, ReferenceQueue<Object> paramReferenceQueue)
  {
    super(null, (ReferenceQueue)null);
    throw new RuntimeException("Stub!");
  }
  
  public final HttpRoute getRoute()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.conn.tsccm.BasicPoolEntryRef
 * JD-Core Version:    0.7.0.1
 */