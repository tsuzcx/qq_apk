package com.tencent.mobileqq.vas.svip.api;

import MQQ.GetRoamToastRsp;
import QC.Hamlet;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Map;

public abstract interface ISVIPHandler
{
  public abstract int a(MessageRecord paramMessageRecord);
  
  public abstract int a(String paramString);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void a(int paramInt1, String paramString, int paramInt2);
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(int paramInt, boolean paramBoolean, String paramString);
  
  public abstract void a(long paramLong);
  
  public abstract void a(GetRoamToastRsp paramGetRoamToastRsp);
  
  public abstract void a(BusinessObserver paramBusinessObserver, boolean paramBoolean);
  
  public abstract void a(MessageRecord paramMessageRecord);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, boolean paramBoolean, int paramInt);
  
  public abstract void a(ArrayList<Hamlet> paramArrayList, BusinessObserver paramBusinessObserver, boolean paramBoolean);
  
  public abstract void a(Map<String, Integer> paramMap);
  
  public abstract boolean a(GetRoamToastRsp paramGetRoamToastRsp);
  
  public abstract int b();
  
  public abstract void b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(int paramInt, boolean paramBoolean);
  
  public abstract void c(int paramInt);
  
  public abstract ToServiceMsg createToServiceMsg(String paramString, BusinessObserver paramBusinessObserver, boolean paramBoolean);
  
  public abstract int d();
  
  public abstract void d();
  
  public abstract void d(int paramInt);
  
  public abstract int e();
  
  public abstract void e();
  
  public abstract int f();
  
  public abstract void f();
  
  public abstract void f(int paramInt);
  
  public abstract int g();
  
  public abstract void g(int paramInt);
  
  public abstract void h(int paramInt);
  
  public abstract void i(int paramInt);
  
  public abstract void notifyUI(int paramInt, boolean paramBoolean, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.svip.api.ISVIPHandler
 * JD-Core Version:    0.7.0.1
 */