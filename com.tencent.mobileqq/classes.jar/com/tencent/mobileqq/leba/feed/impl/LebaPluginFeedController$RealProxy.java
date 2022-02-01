package com.tencent.mobileqq.leba.feed.impl;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.leba.core.LebaShowListManager;
import com.tencent.mobileqq.leba.entity.LebaClickReportInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.feed.LebaPluginsFeedView;
import com.tencent.mobileqq.leba.proxy.ILebaProxy;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaPluginFeedController$RealProxy
  implements ILebaProxy
{
  LebaPluginFeedController a;
  
  public AppRuntime a()
  {
    return this.a.j();
  }
  
  public void a(Intent paramIntent)
  {
    QBaseActivity localQBaseActivity = this.a.k();
    if (localQBaseActivity != null) {
      localQBaseActivity.startActivity(paramIntent);
    }
  }
  
  public void a(LebaClickReportInfo paramLebaClickReportInfo) {}
  
  public void a(Runnable paramRunnable)
  {
    QBaseActivity localQBaseActivity = this.a.k();
    if (localQBaseActivity != null) {
      localQBaseActivity.runOnUiThread(paramRunnable);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.a.l();
  }
  
  public void b()
  {
    if (LebaPluginFeedController.b(this.a) != null) {
      LebaPluginFeedController.b(this.a).b();
    }
  }
  
  public QBaseActivity c()
  {
    return this.a.k();
  }
  
  public int d()
  {
    return 0;
  }
  
  public void e() {}
  
  public List<LebaViewItem> f()
  {
    if (LebaPluginFeedController.b(this.a) != null) {
      return LebaPluginFeedController.b(this.a).getData();
    }
    return null;
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
 * Qualified Name:     com.tencent.mobileqq.leba.feed.impl.LebaPluginFeedController.RealProxy
 * JD-Core Version:    0.7.0.1
 */