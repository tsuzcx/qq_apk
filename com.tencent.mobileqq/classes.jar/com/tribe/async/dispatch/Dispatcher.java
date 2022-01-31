package com.tribe.async.dispatch;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract interface Dispatcher
{
  public static final String DEFAULT_GROUP_NAME = "default_group";
  public static final String ROOT_GROUP_NAME = "root_group";
  
  public abstract void cancelDispatch(@Nullable String paramString, Dispatcher.Dispatchable paramDispatchable);
  
  public abstract void dispatch(Dispatcher.Dispatchable paramDispatchable);
  
  public abstract void dispatch(@Nullable String paramString, Dispatcher.Dispatchable paramDispatchable);
  
  public abstract void dispatchDelayed(Dispatcher.Dispatchable paramDispatchable, int paramInt);
  
  public abstract void dispatchDelayed(@Nullable String paramString, Dispatcher.Dispatchable paramDispatchable, int paramInt);
  
  @NonNull
  public abstract Looper getDefaultLooper();
  
  public abstract void registerSubscriber(Subscriber paramSubscriber);
  
  public abstract void registerSubscriber(@Nullable String paramString, Subscriber paramSubscriber);
  
  public abstract void registerWeakSubscriber(Subscriber paramSubscriber);
  
  public abstract void registerWeakSubscriber(@Nullable String paramString, Subscriber paramSubscriber);
  
  public abstract void unRegisterSubscriber(Subscriber paramSubscriber);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tribe.async.dispatch.Dispatcher
 * JD-Core Version:    0.7.0.1
 */