package com.tribe.async.dispatch;

import android.support.annotation.NonNull;

public abstract interface Subscriber$IDispatchableListener<T extends Dispatcher.Dispatchable>
{
  public abstract void onDispatch(@NonNull T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.dispatch.Subscriber.IDispatchableListener
 * JD-Core Version:    0.7.0.1
 */