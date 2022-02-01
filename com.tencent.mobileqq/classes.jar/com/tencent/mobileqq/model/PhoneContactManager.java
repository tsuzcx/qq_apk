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
  
  public abstract void a(int paramInt, List<String> paramList);
  
  public abstract void a(PhoneContactManager.IPhoneContactListener paramIPhoneContactListener);
  
  public abstract void a(String paramString, GetOnlineInfoResp paramGetOnlineInfoResp);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract Object[] a();
  
  public abstract PhoneContact b(String paramString);
  
  public abstract String b(String paramString);
  
  public abstract void b(PhoneContactManager.IPhoneContactListener paramIPhoneContactListener);
  
  public abstract PhoneContact c(String paramString);
  
  public abstract void c(String paramString1, String paramString2);
  
  public abstract boolean c();
  
  public abstract int d();
  
  public abstract List<PhoneContact> d();
  
  public abstract boolean d();
  
  public abstract List<List<PhoneContact>> e();
  
  public abstract List<PhoneContact> f();
  
  public abstract void f();
  
  public abstract List<PhoneContact> g();
  
  public abstract boolean i();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.PhoneContactManager
 * JD-Core Version:    0.7.0.1
 */