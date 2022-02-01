package com.tencent.mobileqq.onlinestatus;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import mqq.app.AppRuntime;

public abstract class BaseOnlineStatusDisplayInfo
{
  public String a;
  public String b;
  public String c;
  public boolean d = false;
  public String e = "";
  protected BaseOnlineStatusDisplayInfo.UpdateUIListener f;
  public long g;
  protected QBaseActivity h;
  protected AppRuntime i;
  protected boolean j = true;
  
  public BaseOnlineStatusDisplayInfo(long paramLong, BaseOnlineStatusDisplayInfo.UpdateUIListener paramUpdateUIListener, AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity)
  {
    this.f = paramUpdateUIListener;
    this.h = paramQBaseActivity;
    this.g = paramLong;
    this.i = paramAppRuntime;
  }
  
  protected abstract void a();
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public abstract void a(boolean paramBoolean);
  
  public void a(boolean paramBoolean, long paramLong)
  {
    this.j = paramBoolean;
  }
  
  public abstract void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem);
  
  public abstract void b();
  
  public boolean c()
  {
    return true;
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo
 * JD-Core Version:    0.7.0.1
 */