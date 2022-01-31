package com.tribe.async.async;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public abstract interface Boss
{
  public abstract <Result> void cancelJob(Future<Result> paramFuture, boolean paramBoolean);
  
  @NonNull
  public abstract Executor getExecutor(int paramInt);
  
  @NonNull
  public abstract Executor[] getExecutors();
  
  @NonNull
  public abstract JobController getJobController();
  
  @NonNull
  public abstract Executor getLightWeightExecutor();
  
  @NonNull
  public abstract <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> paramJob);
  
  @NonNull
  public abstract <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> paramJob, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams);
  
  @NonNull
  public abstract <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> paramJob, @Nullable Params paramParams);
  
  public abstract void postLightWeightJob(Runnable paramRunnable, int paramInt);
  
  @NonNull
  public abstract <Params, Progress, Result> Worker<Progress, Result> prepareWorker(Job<Params, Progress, Result> paramJob, int paramInt, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams);
  
  @NonNull
  public abstract <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> paramJob);
  
  @NonNull
  public abstract <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> paramJob, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams);
  
  @NonNull
  public abstract <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> paramJob, @Nullable Params paramParams);
  
  @NonNull
  public abstract <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> paramJob, int paramInt);
  
  @NonNull
  public abstract <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> paramJob, int paramInt, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams);
  
  @NonNull
  public abstract <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> paramJob, int paramInt, @Nullable Params paramParams);
  
  public abstract void shutdown();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.async.Boss
 * JD-Core Version:    0.7.0.1
 */