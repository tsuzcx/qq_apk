package com.tencent.mobileqq.leba.more;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.leba.core.LebaShowListManager;
import com.tencent.mobileqq.leba.entity.LebaClickReportInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.proxy.ILebaProxy;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaMoreFragment$RealProxy
  implements ILebaProxy
{
  LebaMoreFragment a;
  
  public AppRuntime a()
  {
    return this.a.r();
  }
  
  public void a(Intent paramIntent)
  {
    this.a.startActivity(paramIntent);
  }
  
  public void a(LebaClickReportInfo paramLebaClickReportInfo) {}
  
  public void a(Runnable paramRunnable)
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.runOnUiThread(paramRunnable);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void b() {}
  
  public QBaseActivity c()
  {
    return this.a.getQBaseActivity();
  }
  
  public int d()
  {
    return 0;
  }
  
  public void e() {}
  
  public List<LebaViewItem> f()
  {
    if (this.a.d != null) {
      return this.a.d.d();
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
 * Qualified Name:     com.tencent.mobileqq.leba.more.LebaMoreFragment.RealProxy
 * JD-Core Version:    0.7.0.1
 */