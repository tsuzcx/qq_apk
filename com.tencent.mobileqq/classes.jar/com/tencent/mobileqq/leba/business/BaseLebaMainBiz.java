package com.tencent.mobileqq.leba.business;

import android.content.Intent;
import android.os.Looper;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.leba.entity.LeabOnPauseInfo;
import com.tencent.mobileqq.leba.entity.LebaClickReportInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.proxy.ILebaProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

public abstract class BaseLebaMainBiz
{
  ILebaProxy a;
  
  public int a()
  {
    ILebaProxy localILebaProxy = this.a;
    if (localILebaProxy != null) {
      return localILebaProxy.d();
    }
    return 0;
  }
  
  public void a(Intent paramIntent)
  {
    ILebaProxy localILebaProxy = this.a;
    if (localILebaProxy != null) {
      localILebaProxy.a(paramIntent);
    }
  }
  
  public void a(View paramView) {}
  
  public void a(View paramView, LebaViewItem paramLebaViewItem, LebaClickReportInfo paramLebaClickReportInfo) {}
  
  public void a(LeabOnPauseInfo paramLeabOnPauseInfo) {}
  
  public void a(LebaClickReportInfo paramLebaClickReportInfo)
  {
    ILebaProxy localILebaProxy = this.a;
    if (localILebaProxy != null) {
      localILebaProxy.a(paramLebaClickReportInfo);
    }
  }
  
  public void a(ILebaProxy paramILebaProxy)
  {
    this.a = paramILebaProxy;
  }
  
  public void a(Runnable paramRunnable)
  {
    ILebaProxy localILebaProxy = this.a;
    if (localILebaProxy != null) {
      localILebaProxy.a(paramRunnable);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ILebaProxy localILebaProxy = this.a;
    if (localILebaProxy != null) {
      localILebaProxy.a(paramBoolean1, paramBoolean2, paramInt);
    }
  }
  
  public AppRuntime b()
  {
    ILebaProxy localILebaProxy = this.a;
    if (localILebaProxy != null) {
      return localILebaProxy.a();
    }
    return null;
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    if (this.a != null) {
      try
      {
        if (Looper.myLooper() != Looper.getMainLooper())
        {
          this.a.a(new BaseLebaMainBiz.1(this));
          return;
        }
        this.a.b();
        return;
      }
      catch (Exception localException)
      {
        QLog.i("BaseLebaMainBiz", 1, "notifyDataSetChanged", localException);
      }
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public QBaseActivity d()
  {
    ILebaProxy localILebaProxy = this.a;
    if (localILebaProxy != null) {
      return localILebaProxy.c();
    }
    return null;
  }
  
  public void e()
  {
    ILebaProxy localILebaProxy = this.a;
    if (localILebaProxy != null) {
      localILebaProxy.e();
    }
  }
  
  public List<LebaViewItem> f()
  {
    ILebaProxy localILebaProxy = this.a;
    if (localILebaProxy != null) {
      return localILebaProxy.f();
    }
    return null;
  }
  
  public boolean g()
  {
    return false;
  }
  
  public void h()
  {
    ILebaProxy localILebaProxy = this.a;
    if (localILebaProxy != null) {
      localILebaProxy.g();
    }
  }
  
  public void i()
  {
    ILebaProxy localILebaProxy = this.a;
    if (localILebaProxy != null) {
      localILebaProxy.h();
    }
  }
  
  public HashMap<String, LebaViewItem> j()
  {
    ILebaProxy localILebaProxy = this.a;
    if (localILebaProxy != null) {
      return localILebaProxy.i();
    }
    return new HashMap();
  }
  
  public boolean k()
  {
    return a() == 1;
  }
  
  public void l() {}
  
  public void m() {}
  
  public void n() {}
  
  public void o() {}
  
  public void p() {}
  
  public void q() {}
  
  public void r() {}
  
  public void s() {}
  
  public void t() {}
  
  public void u() {}
  
  public void v() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.BaseLebaMainBiz
 * JD-Core Version:    0.7.0.1
 */