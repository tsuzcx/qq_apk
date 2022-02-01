package com.tencent.mobileqq.leba.more;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.leba.business.LebaMainBizProxy;
import com.tencent.mobileqq.leba.business.LebaMoreVipBizProxy;
import com.tencent.mobileqq.leba.core.LebaShowListManager;
import com.tencent.mobileqq.leba.entity.LebaClickReportInfo;
import com.tencent.mobileqq.leba.entity.LebaPluginSetting;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.feed.LebaFeedUtil;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import com.tencent.mobileqq.leba.observer.LebaSettingObserver;
import com.tencent.mobileqq.leba.report.LebaDaTong;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaMoreFragment
  extends QIphoneTitleBarFragment
  implements View.OnClickListener, LebaMoreAdapter.OnPluginClick
{
  protected RecyclerView a;
  protected LebaMoreAdapter b;
  protected boolean c;
  protected LebaMoreDataLogic d;
  protected int e;
  protected boolean f = false;
  LebaMainBizProxy g = new LebaMainBizProxy();
  LebaMoreVipBizProxy w = new LebaMoreVipBizProxy();
  protected Dialog x;
  protected boolean y;
  private LebaSettingObserver z = new LebaMoreFragment.5(this);
  
  private void u()
  {
    if (getQBaseActivity() == null) {
      return;
    }
    if ((getQBaseActivity().getIntent().getBooleanExtra("key_open_edit_mode", false)) && (!this.f)) {
      g();
    }
  }
  
  protected int a()
  {
    return 2131627496;
  }
  
  public void a(Context paramContext)
  {
    this.d = new LebaMoreDataLogic();
    this.d.a(r());
    this.d.a(this.w);
    this.b = new LebaMoreAdapter(paramContext, this.d, this.c, this);
    this.b.a(this.w);
    paramContext = new GridLayoutManager(getActivity(), 4);
    paramContext.setSpanSizeLookup(new LebaMoreFragment.MyLoopUp(this.b));
    this.b.a(paramContext);
    this.b.a(this.e);
    this.a = ((RecyclerView)this.t.findViewById(2131444519));
    this.a.setLayoutManager(paramContext);
    paramContext = new DefaultItemAnimator();
    paramContext.setSupportsChangeAnimations(false);
    this.a.setItemAnimator(paramContext);
    this.a.addItemDecoration(new LebaMoreFragment.MyItemDecoration(getActivity(), this.b, this.c));
    this.a.setAdapter(this.b);
    q();
    p();
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = getContext();
    if (paramLayoutInflater == null)
    {
      QLog.i("LebaMoreFragment", 1, "doOnCreateView context == null");
      return;
    }
    LebaPluginLogic.a(this.z);
    LebaShowListManager.a |= 0x1;
    this.c = ThemeUtil.isNowThemeIsNight(null, false, null);
    this.e = LebaPluginLogic.a();
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("doOnCreateView mIsNowThemeIsNight=");
    paramViewGroup.append(this.c);
    paramViewGroup.append(",mModel=");
    paramViewGroup.append(this.e);
    QLog.i("LebaMoreFragment", 1, paramViewGroup.toString());
    b();
    d();
    c();
    a(paramLayoutInflater);
    u();
    LebaDaTong.a(getActivity(), this.s, "pg_discover_list_secondary_page");
  }
  
  public void a(View paramView, LebaViewItem paramLebaViewItem)
  {
    if ((paramLebaViewItem != null) && (paramView != null))
    {
      LebaClickReportInfo localLebaClickReportInfo = new LebaClickReportInfo();
      localLebaClickReportInfo.d = false;
      this.g.a(paramView, paramLebaViewItem, localLebaClickReportInfo);
      return;
    }
    QLog.i("LebaMoreFragment", 1, "onItemClick pluginInfo == null || item.pluginInfo == null");
  }
  
  public void b()
  {
    LebaMoreFragment.RealProxy localRealProxy = new LebaMoreFragment.RealProxy();
    localRealProxy.a = this;
    this.g.a(localRealProxy);
    this.w.a();
    this.w.a(getActivity());
  }
  
  public void c()
  {
    a(getString(2131891161));
    if (this.k != null)
    {
      c(2131891163, this);
      this.k.setVisibility(8);
    }
  }
  
  public void d()
  {
    View localView = this.t.findViewById(2131436883);
    if (this.c)
    {
      localView.setBackgroundColor(getResources().getColor(2131166367));
      return;
    }
    localView.setBackgroundColor(getResources().getColor(2131166366));
  }
  
  public void e()
  {
    if (this.f)
    {
      VideoReport.setElementId(this.k, "em_discover_finish_button");
      this.d.b(r());
      s();
      return;
    }
    VideoReport.setElementId(this.k, "em_discover_manage_button");
    g();
  }
  
  public void f()
  {
    if ((this.k != null) && (this.d != null))
    {
      TextView localTextView = this.k;
      int i;
      if (this.d.e()) {
        i = 8;
      } else {
        i = 0;
      }
      localTextView.setVisibility(i);
    }
  }
  
  public void g()
  {
    this.d.b(false);
    this.f ^= true;
    if (this.k != null)
    {
      int i;
      if (this.f) {
        i = 2131891159;
      } else {
        i = 2131891163;
      }
      c(i, this);
    }
    LebaMoreAdapter localLebaMoreAdapter = this.b;
    if (localLebaMoreAdapter != null) {
      localLebaMoreAdapter.a(this.f);
    }
  }
  
  public void h()
  {
    DialogUtil.a(getContext(), 0, null, HardCodeUtil.a(2131891165), HardCodeUtil.a(2131891164), HardCodeUtil.a(2131891166), new LebaMoreFragment.1(this), new LebaMoreFragment.2(this)).show();
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
  }
  
  public boolean onBackEvent()
  {
    if ((this.f) && (this.d.c()))
    {
      h();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131436211) {
      e();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    t();
    this.g.j();
    LebaPluginLogic.b(this.z);
    super.onDestroy();
  }
  
  public void onPause()
  {
    this.g.d();
    super.onPause();
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
  }
  
  public void onResume()
  {
    this.g.a(false);
    this.g.f();
    super.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void p()
  {
    QLog.i("LebaMoreFragment", 1, "refreshData");
    ThreadManager.excute(new LebaMoreFragment.3(this), 160, null, true);
  }
  
  public void q()
  {
    QLog.i("LebaMoreFragment", 1, "loadDate");
    Object localObject = r();
    if (localObject == null)
    {
      QLog.i("LebaMoreFragment", 1, "updateDate appRuntime == null");
      return;
    }
    List localList = LebaShowListManager.a().d();
    LebaPluginSetting localLebaPluginSetting = LebaPluginLogic.a((AppRuntime)localObject, this.e);
    int j = LebaPluginLogic.b((AppRuntime)localObject, this.e);
    int i;
    if ((this.e == 2) && (LebaFeedUtil.a())) {
      i = LebaPluginLogic.c();
    } else {
      i = LebaPluginLogic.c((AppRuntime)localObject, this.e);
    }
    localObject = new LebaMoreFragment.4(this, LebaPluginLogic.a(localList, localLebaPluginSetting, j), i);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      if (getActivity() != null) {
        getActivity().runOnUiThread((Runnable)localObject);
      }
    }
    else {
      ((Runnable)localObject).run();
    }
  }
  
  public AppRuntime r()
  {
    if (getQBaseActivity() == null) {
      return null;
    }
    return getQBaseActivity().getAppRuntime();
  }
  
  protected void s()
  {
    if (getActivity() != null)
    {
      if (getActivity().isFinishing()) {
        return;
      }
      if (this.x == null) {
        this.x = DialogUtil.b(getActivity(), 2131891158);
      }
      if (!this.x.isShowing()) {
        this.x.show();
      }
    }
  }
  
  protected void t()
  {
    if (getActivity() != null)
    {
      if (getActivity().isFinishing()) {
        return;
      }
      LebaMoreFragment.6 local6 = new LebaMoreFragment.6(this);
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        if (getActivity() != null) {
          getActivity().runOnUiThread(local6);
        }
      }
      else {
        local6.run();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.more.LebaMoreFragment
 * JD-Core Version:    0.7.0.1
 */