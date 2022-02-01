package org.apache.http.impl.conn.tsccm;

import java.lang.ref.ReferenceQueue;

@Deprecated
public class RefQueueWorker
  implements Runnable
{
  protected final RefQueueHandler refHandler;
  protected final ReferenceQueue<?> refQueue;
  protected volatile Thread workerThread;
  
  public RefQueueWorker(ReferenceQueue<?> paramReferenceQueue, RefQueueHandler paramRefQueueHandler)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void run()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void shutdown()
  {
    throw new RuntimeException("Stub!");
  }
  
  public String toString()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.conn.tsccm.RefQueueWorker
 * JD-Core Version:    0.7.0.1
 */