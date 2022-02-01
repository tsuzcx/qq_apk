package com.tencent.mobileqq.phonecontact.processor;

import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.List;
import org.json.JSONObject;

public abstract interface IPhoneContactProcessor
{
  public abstract void a();
  
  public abstract void a(AppInterface paramAppInterface);
  
  public abstract void a(String paramString, JSONObject paramJSONObject);
  
  public abstract void a(List<PhoneContact> paramList);
  
  public abstract boolean a(boolean paramBoolean);
  
  public abstract boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, RespondQueryQQBindingStat paramRespondQueryQQBindingStat, boolean paramBoolean4, long paramLong);
  
  public abstract void b();
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.processor.IPhoneContactProcessor
 * JD-Core Version:    0.7.0.1
 */