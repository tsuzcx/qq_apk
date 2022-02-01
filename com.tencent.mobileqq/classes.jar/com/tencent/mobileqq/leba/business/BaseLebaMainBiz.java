package com.tencent.mobileqq.leba.business;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.leba.entity.LeabOnPauseInfo;
import com.tencent.mobileqq.leba.entity.LebaClickReportInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.proxy.ILebaProxy;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

public abstract class BaseLebaMainBiz
{
  ILebaProxy a;
  
  public int a()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return 0;
  }
  
  public QBaseActivity a()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return null;
  }
  
  public HashMap<String, LebaViewItem> a()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return new HashMap();
  }
  
  public List<LebaViewItem> a()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return null;
  }
  
  public AppRuntime a()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return null;
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void a(Intent paramIntent)
  {
    if (this.a != null) {
      this.a.a(paramIntent);
    }
  }
  
  public void a(View paramView) {}
  
  public void a(View paramView, LebaViewItem paramLebaViewItem, LebaClickReportInfo paramLebaClickReportInfo) {}
  
  public void a(LeabOnPauseInfo paramLeabOnPauseInfo) {}
  
  public void a(LebaClickReportInfo paramLebaClickReportInfo)
  {
    if (this.a != null) {
      this.a.a(paramLebaClickReportInfo);
    }
  }
  
  public void a(ILebaProxy paramILebaProxy)
  {
    this.a = paramILebaProxy;
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.a != null) {
      this.a.a(paramRunnable);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramBoolean1, paramBoolean2, paramInt);
    }
  }
  
  public boolean a()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return false;
  }
  
  public void b()
  {
    if (this.a != null) {
      this.a.b();
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean b()
  {
    return a() == 1;
  }
  
  public void c()
  {
    if (this.a != null) {
      this.a.c();
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public void d()
  {
    if (this.a != null) {
      this.a.d();
    }
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
  
  public void m() {}
  
  public void n() {}
  
  public void o() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.BaseLebaMainBiz
 * JD-Core Version:    0.7.0.1
 */