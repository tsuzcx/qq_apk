package org.apache.http.impl.conn.tsccm;

import java.util.concurrent.TimeUnit;

@Deprecated
public abstract interface PoolEntryRequest
{
  public abstract void abortRequest();
  
  public abstract BasicPoolEntry getPoolEntry(long paramLong, TimeUnit paramTimeUnit);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.conn.tsccm.PoolEntryRequest
 * JD-Core Version:    0.7.0.1
 */