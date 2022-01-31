package com.tribe.async.dispatch;

import android.support.annotation.NonNull;

class DefaultDispatcher$2
  implements HandlerPoster.PosterRunner
{
  DefaultDispatcher$2(DefaultDispatcher paramDefaultDispatcher) {}
  
  public boolean acceptTag(Object paramObject)
  {
    return "async.dispatch.DefaultDispatcher" == paramObject;
  }
  
  public void run(@NonNull String paramString, @NonNull Dispatcher.Dispatchable paramDispatchable)
  {
    this.this$0.doDispatch(paramString, paramDispatchable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tribe.async.dispatch.DefaultDispatcher.2
 * JD-Core Version:    0.7.0.1
 */