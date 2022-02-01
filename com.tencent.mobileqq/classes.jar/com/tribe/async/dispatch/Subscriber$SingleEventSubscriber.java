package com.tribe.async.dispatch;

import android.os.Looper;
import android.support.annotation.NonNull;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class Subscriber$SingleEventSubscriber<EVENT extends Dispatcher.Dispatchable>
  extends Subscriber.LooperSubscriber
{
  private Class clazz;
  
  public Subscriber$SingleEventSubscriber()
  {
    super(Looper.getMainLooper());
    Type[] arrayOfType = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments();
    this.clazz = ((Class)arrayOfType[(arrayOfType.length - 1)]);
  }
  
  public void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> paramList)
  {
    paramList.add(this.clazz);
  }
  
  public final void onDispatch(@NonNull Dispatcher.Dispatchable paramDispatchable)
  {
    onDispatch2(paramDispatchable);
  }
  
  protected abstract void onDispatch2(@NonNull EVENT paramEVENT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.dispatch.Subscriber.SingleEventSubscriber
 * JD-Core Version:    0.7.0.1
 */