package com.tencent.mobileqq.leba.proxy;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.leba.entity.LebaClickReportInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

public abstract interface ILebaProxy
{
  public abstract AppRuntime a();
  
  public abstract void a(Intent paramIntent);
  
  public abstract void a(LebaClickReportInfo paramLebaClickReportInfo);
  
  public abstract void a(Runnable paramRunnable);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt);
  
  public abstract void b();
  
  public abstract QBaseActivity c();
  
  public abstract int d();
  
  public abstract void e();
  
  public abstract List<LebaViewItem> f();
  
  public abstract void g();
  
  public abstract void h();
  
  public abstract HashMap<String, LebaViewItem> i();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.proxy.ILebaProxy
 * JD-Core Version:    0.7.0.1
 */