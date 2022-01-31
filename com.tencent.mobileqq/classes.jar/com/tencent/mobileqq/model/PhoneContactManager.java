package com.tencent.mobileqq.model;

import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.data.PhoneContact;
import friendlist.GetOnlineInfoResp;
import java.util.List;
import mqq.manager.Manager;

public abstract interface PhoneContactManager
  extends Manager
{
  public abstract RespondQueryQQBindingStat a();
  
  public abstract PhoneContact a(String paramString);
  
  public abstract String a(String paramString);
  
  public abstract void a(PhoneContactManager.IPhoneContactListener paramIPhoneContactListener);
  
  public abstract void a(String paramString, GetOnlineInfoResp paramGetOnlineInfoResp);
  
  public abstract PhoneContact b(String paramString);
  
  public abstract String b(String paramString);
  
  public abstract void b(PhoneContactManager.IPhoneContactListener paramIPhoneContactListener);
  
  public abstract void b(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract int c();
  
  public abstract PhoneContact c(String paramString);
  
  public abstract void c(String paramString1, String paramString2);
  
  public abstract boolean c();
  
  public abstract List d();
  
  public abstract void d();
  
  public abstract List e();
  
  public abstract List f();
  
  public abstract List g();
  
  public abstract void g();
  
  public abstract boolean g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.model.PhoneContactManager
 * JD-Core Version:    0.7.0.1
 */