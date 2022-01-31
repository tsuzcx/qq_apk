package com.tribe.async.dispatch;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.tribe.async.utils.AssertUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class HandlerPoster
  extends AbsEventBatcher<PendingPost>
{
  private final CopyOnWriteArraySet<HandlerPoster.PosterRunner> mPosterRunners = new CopyOnWriteArraySet();
  
  HandlerPoster(Looper paramLooper, int paramInt)
  {
    super(paramLooper, new PendingPostQueue(), paramInt);
  }
  
  private void notifyAllPosterRunner(@NonNull Object paramObject, @NonNull String paramString, @NonNull Dispatcher.Dispatchable paramDispatchable)
  {
    Iterator localIterator = this.mPosterRunners.iterator();
    while (localIterator.hasNext())
    {
      HandlerPoster.PosterRunner localPosterRunner = (HandlerPoster.PosterRunner)localIterator.next();
      if (localPosterRunner.acceptTag(paramObject)) {
        localPosterRunner.run(paramString, paramDispatchable);
      }
    }
  }
  
  void addPosterRunner(HandlerPoster.PosterRunner paramPosterRunner)
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
  
  void removePosterRunner(HandlerPoster.PosterRunner paramPosterRunner)
  {
    this.mPosterRunners.remove(paramPosterRunner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tribe.async.dispatch.HandlerPoster
 * JD-Core Version:    0.7.0.1
 */