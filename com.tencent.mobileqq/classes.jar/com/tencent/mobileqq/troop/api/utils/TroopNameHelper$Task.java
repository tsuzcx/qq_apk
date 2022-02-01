package com.tencent.mobileqq.troop.api.utils;

import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class TroopNameHelper$Task
  implements Runnable
{
  public volatile boolean a;
  
  public TroopNameHelper$Task(TroopNameHelper paramTroopNameHelper) {}
  
  public abstract void a();
  
  public final void run()
  {
    this.a = true;
    a();
    this.a = false;
    this.this$0.a.remove(this);
    TroopNameHelper.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.utils.TroopNameHelper.Task
 * JD-Core Version:    0.7.0.1
 */