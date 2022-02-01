package com.tencent.mobileqq.listentogether.player;

import com.tencent.mobileqq.listentogether.data.ISong;

public abstract interface IQQMusicPlayClient
{
  public abstract void a(IConnCallback paramIConnCallback);
  
  public abstract void a(IPlayCallback paramIPlayCallback);
  
  public abstract void a(IProgressChangeCallback paramIProgressChangeCallback);
  
  public abstract void a(IStateChangeCallback paramIStateChangeCallback);
  
  public abstract boolean a();
  
  public abstract boolean a(ISong paramISong);
  
  public abstract boolean b();
  
  public abstract boolean c();
  
  public abstract boolean d();
  
  public abstract void e();
  
  public abstract int f();
  
  public abstract int g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.IQQMusicPlayClient
 * JD-Core Version:    0.7.0.1
 */