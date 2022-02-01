package com.tencent.mobileqq.search.searchengine;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class GroupSearchEngine$3
  extends ThreadPoolExecutor
{
  GroupSearchEngine$3(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    if ((paramRunnable instanceof FutureTask)) {}
    try
    {
      ((FutureTask)paramRunnable).get();
      return;
    }
    catch (ExecutionException paramRunnable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GroupSearchEngine", 2, "Exception happened", paramRunnable);
      }
      return;
    }
    catch (Exception|Error paramRunnable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.3
 * JD-Core Version:    0.7.0.1
 */