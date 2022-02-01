package com.tencent.mobileqq.qwallet.preload.impl;

import java.util.TimerTask;

abstract class PreloadResourceImpl$PreloadTimerTask
  extends TimerTask
{
  private boolean a = false;
  
  public abstract void a();
  
  public boolean b()
  {
    return this.a;
  }
  
  public void run()
  {
    a();
    this.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadResourceImpl.PreloadTimerTask
 * JD-Core Version:    0.7.0.1
 */