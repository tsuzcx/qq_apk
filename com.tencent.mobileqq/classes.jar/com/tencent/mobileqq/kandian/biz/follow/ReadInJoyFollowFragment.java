package com.tencent.mobileqq.kandian.biz.follow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyChannelViewController;
import com.tencent.mobileqq.kandian.biz.framework.RIJUGCDianDian;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabbar;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.statistics.StatisticCollector;

public class ReadInJoyFollowFragment
  extends ReadInJoyBaseFragment
{
  protected ReadInJoyChannelViewController a;
  private View b;
  private int c = 1;
  private boolean d;
  
  public static ReadInJoyFollowFragment a()
  {
    ReadInJoyFollowFragment localReadInJoyFollowFragment = new ReadInJoyFollowFragment();
    localReadInJoyFollowFragment.setArguments(new Bundle());
    return localReadInJoyFollowFragment;
  }
  
  private void w()
  {
    ViewGroup localViewGroup = (ViewGroup)this.b.findViewById(2131444326);
    this.a = new ReadInJoyChannelViewController(v());
    this.a.a(70);
    this.a.b(0);
    this.a.a(localViewGroup);
    this.a.cT_();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.a.a(paramInt1, paramInt2, paramIntent);
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    super.a(paramMessageRecord);
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    super.a(paramMessageRecord, paramInt, paramBundle);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    paramBundle = this.a;
    if (paramBundle != null) {
      paramBundle.b();
    }
    this.d = true;
    if ((RIJShowKanDianTabSp.c()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      u().erasureTabRed(2);
    }
    else
    {
      paramActivity = ((ReadInJoyNewFeedsActivity)paramActivity).n();
      int i = paramActivity.getShowingPopupTipsTapPosi();
      if (i == 2) {
        paramActivity.d(i);
      }
      if ((u() != null) && (u().getTabRedNums(2) > 0))
      {
        paramActivity = this.a;
        if (paramActivity != null) {
          paramActivity.a(true);
        }
      }
    }
    paramActivity = this.a;
    if (paramActivity != null) {
      paramActivity.i();
    }
    StatisticCollector.getInstance(v()).collectPerformance(((QQAppInterface)ReadInJoyUtils.b()).getCurrentUin(), "actReadInJoyEnterDD", true, 0L, 0L, null, null);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    super.b(paramMessageRecord);
  }
  
  public int d()
  {
    return 70;
  }
  
  public void h()
  {
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.a(true);
    }
  }
  
  public void k()
  {
    super.k();
    this.d = false;
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.h();
    }
  }
  
  public void l()
  {
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.a(true);
    }
  }
  
  public boolean m()
  {
    return RIJUGCDianDian.a();
  }
  
  public void n()
  {
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.cR_();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.a.a(paramInt1, paramInt2, paramIntent);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.e = LayoutInflater.from(v());
    this.b = this.e.inflate(2131626246, paramViewGroup, false);
    w();
    return this.b;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.e();
    ReadInJoyLogicEngine.a().u();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.a.c();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.d) {
      this.a.h();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.d) {
      this.a.i();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.d) {
      this.a.f();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.ReadInJoyFollowFragment
 * JD-Core Version:    0.7.0.1
 */