package com.tencent.mobileqq.dinifly;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class LottieTask<T>
{
  public static Executor EXECUTOR = ;
  private final Set<LottieListener<Throwable>> failureListeners = new LinkedHashSet(1);
  private final Handler handler = new Handler(Looper.getMainLooper());
  @Nullable
  private volatile LottieResult<T> result = null;
  private final Set<LottieListener<T>> successListeners = new LinkedHashSet(1);
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public LottieTask(Callable<LottieResult<T>> paramCallable)
  {
    this(paramCallable, false);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  LottieTask(Callable<LottieResult<T>> paramCallable, boolean paramBoolean)
  {
    if (paramBoolean) {
      try
      {
        setResult((LottieResult)paramCallable.call());
        return;
      }
      catch (Throwable paramCallable)
      {
        setResult(new LottieResult(paramCallable));
        return;
      }
    }
    EXECUTOR.execute(new LottieTask.LottieFutureTask(this, paramCallable));
  }
  
  private void notifyFailureListeners(Throwable paramThrowable)
  {
    try
    {
      Object localObject = new ArrayList(this.failureListeners);
      if (((List)localObject).isEmpty())
      {
        Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", paramThrowable);
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((LottieListener)((Iterator)localObject).next()).onResult(paramThrowable);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramThrowable;
    }
  }
  
  private void notifyListeners()
  {
    this.handler.post(new LottieTask.1(this));
  }
  
  private void notifySuccessListeners(T paramT)
  {
    try
    {
      Iterator localIterator = new ArrayList(this.successListeners).iterator();
      while (localIterator.hasNext()) {
        ((LottieListener)localIterator.next()).onResult(paramT);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramT;
    }
  }
  
  private void setResult(@Nullable LottieResult<T> paramLottieResult)
  {
    if (this.result == null)
    {
      this.result = paramLottieResult;
      notifyListeners();
      return;
    }
    throw new IllegalStateException("A task may only be set once.");
  }
  
  public LottieTask<T> addFailureListener(LottieListener<Throwable> paramLottieListener)
  {
    try
    {
      if ((this.result != null) && (this.result.getException() != null)) {
        paramLottieListener.onResult(this.result.getException());
      }
      this.failureListeners.add(paramLottieListener);
      return this;
    }
    finally {}
  }
  
  public LottieTask<T> addListener(LottieListener<T> paramLottieListener)
  {
    try
    {
      if ((this.result != null) && (this.result.getValue() != null)) {
        paramLottieListener.onResult(this.result.getValue());
      }
      this.successListeners.add(paramLottieListener);
      return this;
    }
    finally {}
  }
  
  public LottieTask<T> removeFailureListener(LottieListener<Throwable> paramLottieListener)
  {
    try
    {
      this.failureListeners.remove(paramLottieListener);
      return this;
    }
    finally
    {
      paramLottieListener = finally;
      throw paramLottieListener;
    }
  }
  
  public LottieTask<T> removeListener(LottieListener<T> paramLottieListener)
  {
    try
    {
      this.successListeners.remove(paramLottieListener);
      return this;
    }
    finally
    {
      paramLottieListener = finally;
      throw paramLottieListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieTask
 * JD-Core Version:    0.7.0.1
 */