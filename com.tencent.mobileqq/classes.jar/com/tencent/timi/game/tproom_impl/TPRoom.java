package com.tencent.timi.game.tproom_impl;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;

public class TPRoom
  implements LifecycleObserver, LifecycleOwner
{
  public static String a = "TPRoom";
  private final RoomConfig b;
  private LifecycleRegistry c = new LifecycleRegistry(this);
  
  public TPRoom(Lifecycle paramLifecycle, RoomConfig paramRoomConfig)
  {
    this.b = paramRoomConfig;
    paramLifecycle.addObserver(this);
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.c;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public void onCreate()
  {
    this.c.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onDestroy()
  {
    this.c.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onPause()
  {
    this.c.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public void onResume()
  {
    this.c.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  public void onStart()
  {
    this.c.handleLifecycleEvent(Lifecycle.Event.ON_START);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public void onStop()
  {
    this.c.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tproom_impl.TPRoom
 * JD-Core Version:    0.7.0.1
 */