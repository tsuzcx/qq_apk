package com.tencent.mobileqq.onlinestatus;

import android.content.Intent;

public abstract interface IAccountPanel
{
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(IAccountPanel.OnAccountExitListener paramOnAccountExitListener);
  
  public abstract void a(IAccountPanel.OnStatusChangeByUserListener paramOnStatusChangeByUserListener);
  
  public abstract void a(IAccountPanel.OnlineStatusChangedListener paramOnlineStatusChangedListener);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void c();
  
  public abstract void df_();
  
  public abstract void f();
  
  public abstract void h();
  
  public abstract void i();
  
  public abstract boolean isShowing();
  
  public abstract void j();
  
  public abstract void l();
  
  public abstract void show();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.IAccountPanel
 * JD-Core Version:    0.7.0.1
 */