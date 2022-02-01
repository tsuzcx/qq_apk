package com.tribe.async.dispatch;

import android.support.annotation.NonNull;
import java.util.List;

public abstract interface Subscriber
{
  public abstract void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> paramList);
  
  public abstract void handleDispatch(@NonNull Dispatcher.Dispatchable paramDispatchable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tribe.async.dispatch.Subscriber
 * JD-Core Version:    0.7.0.1
 */