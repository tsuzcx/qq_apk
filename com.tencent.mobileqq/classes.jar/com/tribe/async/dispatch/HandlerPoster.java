package com.tribe.async.dispatch;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.tribe.async.utils.AssertUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class HandlerPoster
  extends AbsEventBatcher<PendingPost>
{
  private final CopyOnWriteArraySet<PosterRunner> mPosterRunners = new CopyOnWriteArraySet();
  
  HandlerPoster(Looper paramLooper, int paramInt)
  {
    super(paramLooper, new PendingPostQueue(), paramInt);
  }
  
  private void notifyAllPosterRunner(@NonNull Object paramObject, @NonNull String paramString, @NonNull Dispatcher.Dispatchable paramDispatchable)
  {
    Iterator localIterator = this.mPosterRunners.iterator();
    while (localIterator.hasNext())
    {
      PosterRunner localPosterRunner = (PosterRunner)localIterator.next();
      if (localPosterRunner.acceptTag(paramObject)) {
        localPosterRunner.run(paramString, paramDispatchable);
      }
    }
  }
  
  void addPosterRunner(PosterRunner paramPosterRunner)
  {
    this.mPosterRunners.add(paramPosterRunner);
  }
  
  void enqueue(Object paramObject, String paramString, Dispatcher.Dispatchable paramDispatchable)
  {
    AssertUtils.checkNotNull(paramObject);
    AssertUtils.checkNotNull(paramString);
    AssertUtils.checkNotNull(paramDispatchable);
    enqueue(PendingPost.obtainPendingPost(paramObject, paramString, paramDispatchable));
  }
  
  protected void handleItem(PendingPost paramPendingPost)
  {
    AssertUtils.checkNotNull(paramPendingPost.group);
    AssertUtils.checkNotNull(paramPendingPost.dispatchable);
    notifyAllPosterRunner(paramPendingPost.tag, paramPendingPost.group, paramPendingPost.dispatchable);
    PendingPost.releasePendingPost(paramPendingPost);
  }
  
  void removePosterRunner(PosterRunner paramPosterRunner)
  {
    this.mPosterRunners.remove(paramPosterRunner);
  }
  
  public static abstract interface PosterRunner
  {
    public abstract boolean acceptTag(Object paramObject);
    
    public abstract void run(@NonNull String paramString, @NonNull Dispatcher.Dispatchable paramDispatchable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.dispatch.HandlerPoster
 * JD-Core Version:    0.7.0.1
 */