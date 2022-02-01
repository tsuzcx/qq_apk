package com.tencent.mobileqq.leba;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.leba.controller.LebaController;
import com.tencent.mobileqq.leba.core.LebaShowListManager;
import com.tencent.mobileqq.leba.entity.LebaClickReportInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.proxy.ILebaProxy;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

public class Leba$RealLebaProxy
  implements ILebaProxy
{
  Leba a;
  
  public AppRuntime a()
  {
    return this.a.aF;
  }
  
  public void a(Intent paramIntent)
  {
    this.a.a(paramIntent);
  }
  
  public void a(LebaClickReportInfo paramLebaClickReportInfo)
  {
    this.a.a(paramLebaClickReportInfo);
  }
  
  public void a(Runnable paramRunnable)
  {
    this.a.b(paramRunnable);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.a.a(paramBoolean1, paramBoolean2, paramInt);
  }
  
  public void b()
  {
    this.a.b(new Leba.RealLebaProxy.1(this));
  }
  
  public QBaseActivity c()
  {
    return this.a.P();
  }
  
  public int d()
  {
    if (this.a.e != null) {
      return this.a.e.a();
    }
    return 0;
  }
  
  public void e()
  {
    this.a.b(new Leba.RealLebaProxy.2(this));
  }
  
  public List<LebaViewItem> f()
  {
    return this.a.c;
  }
  
  public void g()
  {
    LebaShowListManager.a |= 0x1;
  }
  
  public void h()
  {
    LebaShowListManager.a |= 0x2;
  }
  
  public HashMap<String, LebaViewItem> i()
  {
    return LebaShowListManager.a().f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.Leba.RealLebaProxy
 * JD-Core Version:    0.7.0.1
 */