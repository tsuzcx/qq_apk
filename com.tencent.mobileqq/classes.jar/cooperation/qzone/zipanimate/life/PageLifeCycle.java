package cooperation.qzone.zipanimate.life;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

public abstract interface PageLifeCycle
  extends LifecycleObserver
{
  @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
  public abstract void onLifecycleChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent);
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public abstract void onPageCreate(LifecycleOwner paramLifecycleOwner);
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public abstract void onPageDestroy(LifecycleOwner paramLifecycleOwner);
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public abstract void onPagePause(LifecycleOwner paramLifecycleOwner);
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public abstract void onPageResume(LifecycleOwner paramLifecycleOwner);
  
  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  public abstract void onPageStart(LifecycleOwner paramLifecycleOwner);
  
  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public abstract void onPageStop(LifecycleOwner paramLifecycleOwner);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.zipanimate.life.PageLifeCycle
 * JD-Core Version:    0.7.0.1
 */