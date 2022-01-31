package com.tencent.upload.e.a;

import android.os.Build.VERSION;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class b
  extends ThreadPoolExecutor
{
  public b(int paramInt1, int paramInt2, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, 15L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), paramThreadFactory);
  }
  
  public void execute(Runnable paramRunnable)
  {
    if ((paramRunnable instanceof a))
    {
      super.execute(paramRunnable);
      return;
    }
    submit(paramRunnable);
  }
  
  protected <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
  {
    return new a(paramRunnable, paramT);
  }
  
  protected <T> RunnableFuture<T> newTaskFor(Callable<T> paramCallable)
  {
    return new a(paramCallable);
  }
  
  public boolean remove(Runnable paramRunnable)
  {
    return super.remove(new c(paramRunnable));
  }
  
  public Future<?> submit(Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return super.submit(new c(paramRunnable));
    }
    paramRunnable = newTaskFor(new c(paramRunnable), null);
    execute(paramRunnable);
    return paramRunnable;
  }
  
  public <T> Future<T> submit(Runnable paramRunnable, T paramT)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return super.submit(new c(paramRunnable), paramT);
    }
    paramRunnable = newTaskFor(new c(paramRunnable), paramT);
    execute(paramRunnable);
    return paramRunnable;
  }
  
  public <T> Future<T> submit(Callable<T> paramCallable)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return super.submit(new b(paramCallable));
    }
    paramCallable = newTaskFor(new b(paramCallable));
    execute(paramCallable);
    return paramCallable;
  }
  
  private static class a<V>
    extends FutureTask<V>
    implements Comparable<a<V>>
  {
    private Object a;
    
    public a(Runnable paramRunnable, V paramV)
    {
      super(paramV);
      this.a = paramRunnable;
    }
    
    public a(Callable<V> paramCallable)
    {
      super();
      this.a = paramCallable;
    }
    
    public int a(a<V> parama)
    {
      if (this == parama) {}
      do
      {
        return 0;
        if (parama == null) {
          return -1;
        }
      } while ((this.a == null) || (parama.a == null) || (!this.a.getClass().equals(parama.a.getClass())) || (!(this.a instanceof Comparable)));
      return ((Comparable)this.a).compareTo(parama.a);
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof a))) {
        return false;
      }
      paramObject = (a)paramObject;
      return this.a.equals(paramObject.a);
    }
  }
  
  private static class b<T>
    extends b.d
    implements Callable<T>
  {
    protected Callable<T> a;
    
    public b(Callable<T> paramCallable)
    {
      this.a = paramCallable;
    }
    
    public T call()
      throws Exception
    {
      if (System.currentTimeMillis() - this.c > 30000L) {
        Log.w("PriorityThreadPoolExecutor", "this job hangury too long. job:" + this + ". job:" + this.a);
      }
      Object localObject = this.a.call();
      this.a = null;
      return localObject;
    }
  }
  
  private static class c
    extends b.d
    implements Runnable
  {
    protected Runnable a;
    
    public c(Runnable paramRunnable)
    {
      this.a = paramRunnable;
    }
    
    public void run()
    {
      if (System.currentTimeMillis() - this.c > 30000L) {
        Log.w("PriorityThreadPoolExecutor", "this job hangury too long. job:" + this + ". job:" + this.a);
      }
      try
      {
        this.a.run();
        this.a = null;
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.w("PriorityThreadPoolExecutor", localThrowable);
        }
      }
    }
  }
  
  private static class d
    implements Comparable<d>
  {
    protected int b = 0;
    protected long c = System.currentTimeMillis();
    
    public int a(d paramd)
    {
      int i;
      if (this == paramd) {
        i = 0;
      }
      int j;
      do
      {
        return i;
        j = paramd.b - this.b;
        i = j;
      } while (j != 0);
      return (int)(this.c - paramd.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.e.a.b
 * JD-Core Version:    0.7.0.1
 */