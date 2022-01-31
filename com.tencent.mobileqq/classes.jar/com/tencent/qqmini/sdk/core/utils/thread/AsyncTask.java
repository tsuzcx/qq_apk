package com.tencent.qqmini.sdk.core.utils.thread;

import android.os.Message;
import bgls;
import bglt;
import bglu;
import bglv;
import bglw;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AsyncTask<Params, Progress, Result>
{
  private static final BlockingQueue<Runnable> jdField_a_of_type_JavaUtilConcurrentBlockingQueue;
  public static final Executor a;
  private static final ThreadFactory jdField_a_of_type_JavaUtilConcurrentThreadFactory = new bgls();
  public static final Executor b;
  private static volatile Executor c = jdField_b_of_type_JavaUtilConcurrentExecutor;
  private volatile AsyncTask.Status jdField_a_of_type_ComTencentQqminiSdkCoreUtilsThreadAsyncTask$Status;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private final AtomicBoolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue(10);
    jdField_a_of_type_JavaUtilConcurrentExecutor = new ThreadPoolExecutor(1, 128, 1L, TimeUnit.SECONDS, jdField_a_of_type_JavaUtilConcurrentBlockingQueue, jdField_a_of_type_JavaUtilConcurrentThreadFactory);
    jdField_b_of_type_JavaUtilConcurrentExecutor = new bglw(null);
  }
  
  private Result a(Result paramResult)
  {
    bglu.a.obtainMessage(1, new bglt(this, new Object[] { paramResult })).sendToTarget();
    return paramResult;
  }
  
  private void c(Result paramResult)
  {
    if (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a(paramResult);
    }
  }
  
  private void d(Result paramResult)
  {
    if (a()) {
      b(paramResult);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreUtilsThreadAsyncTask$Status = AsyncTask.Status.FINISHED;
      return;
      a(paramResult);
    }
  }
  
  protected void a() {}
  
  protected void a(Result paramResult) {}
  
  public void a(Progress... paramVarArgs) {}
  
  public final boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  protected void b(Result paramResult)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.thread.AsyncTask
 * JD-Core Version:    0.7.0.1
 */