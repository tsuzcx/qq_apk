package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyPrivacyListFragment
  extends IphoneTitleBarFragment
  implements ReadInJoyPrivacyListView.LoadMoreCallback
{
  private ReadInJoyPrivacyListView a = null;
  private ReadInJoyPrivacyListAdapter b = null;
  private long c = 0L;
  private List<Long> d = new ArrayList();
  private int e = 0;
  private int f = 0;
  private boolean g = true;
  private ReadInJoyObserver h = new ReadInJoyPrivacyListFragment.1(this);
  
  public void a()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity == null) {
      return;
    }
    if ((localBaseActivity.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      localBaseActivity.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(localBaseActivity.getWindow(), localBaseActivity.isClearCoverLayer);
      if (localBaseActivity.mSystemBarComp == null) {
        localBaseActivity.mSystemBarComp = new SystemBarCompact(localBaseActivity, true, -1);
      }
      localBaseActivity.mSystemBarComp.init();
      if (ThemeUtil.isInNightMode(localBaseActivity.app))
      {
        if ((!SystemUtil.d()) && (!SystemUtil.g()))
        {
          localBaseActivity.mSystemBarComp.setStatusBarColor(-7829368);
        }
        else
        {
          localBaseActivity.mSystemBarComp.setStatusBarColor(-7829368);
          localBaseActivity.mSystemBarComp.setStatusBarDarkMode(true);
        }
      }
      else if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
      {
        localBaseActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
        localBaseActivity.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!SystemUtil.g())
      {
        localBaseActivity.mSystemBarComp.setStatusBarColor(-2368549);
      }
      else
      {
        localBaseActivity.mSystemBarComp.setStatusBarColor(-1);
        localBaseActivity.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
    if (this.leftView != null)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130851519);
    }
    if (this.centerView != null) {
      this.centerView.setTextColor(-16777216);
    }
    this.vg.setBackgroundColor(-1);
  }
  
  public void b()
  {
    ReadInJoyLogicEngine.a().a(this.c, this.f, 30);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a = ((ReadInJoyPrivacyListView)this.mContentView.findViewById(2131437330));
    this.b = new ReadInJoyPrivacyListAdapter(getBaseActivity(), this.d);
    this.a.setAdapter(this.b);
    this.a.setLoadMoreCallback(this);
    setTitle(HardCodeUtil.a(2131910346));
    if (this.leftView != null) {
      this.leftView.setText(HardCodeUtil.a(2131901576));
    }
    a();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.h);
  }
  
  protected int getContentLayoutId()
  {
    return 2131626304;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = getBaseActivity().getIntent().getLongExtra("feeds_id", 0L);
    ReadInJoyLogicEngine.a().a(this.c, this.f, 30);
    RIJDtReportHelper.a.a(getBaseActivity());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyPrivacyListFragment
 * JD-Core Version:    0.7.0.1
 */