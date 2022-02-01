package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.channel.ChannelClassificationListView;
import com.tencent.mobileqq.kandian.biz.channel.ChannelClassificationListView.IClassData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyChannelWaterFallViewController;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants.LogoutReason;

public abstract class ReadInJoyFragmentWithSubChannel<C extends ChannelClassificationListView.IClassData>
  extends ReadInJoyBaseFragment
{
  protected ChannelClassificationListView<C> a;
  ReadInJoyFragmentWithSubChannel.ReadInjoyViewInterface b;
  ReadInJoyChannelWaterFallViewController c;
  boolean d;
  
  protected abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, ChannelClassificationListView<C> paramChannelClassificationListView);
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    ReadInJoyChannelWaterFallViewController localReadInJoyChannelWaterFallViewController = this.c;
    if (localReadInJoyChannelWaterFallViewController != null)
    {
      localReadInJoyChannelWaterFallViewController.a(true, 0);
      return;
    }
    ReadInJoyChannelViewPagerController.d(d());
  }
  
  protected void a(View paramView, int paramInt) {}
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if (RIJShowKanDianTabSp.c())
    {
      ReadInJoyChannelWaterFallViewController localReadInJoyChannelWaterFallViewController = this.c;
      if (localReadInJoyChannelWaterFallViewController != null) {
        localReadInJoyChannelWaterFallViewController.a(paramLogoutReason);
      }
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    paramActivity = this.c;
    if (paramActivity != null) {
      paramActivity.b();
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void h()
  {
    super.h();
    ReadInJoyChannelWaterFallViewController localReadInJoyChannelWaterFallViewController = this.c;
    if (localReadInJoyChannelWaterFallViewController != null) {
      localReadInJoyChannelWaterFallViewController.a(true);
    }
  }
  
  public void k()
  {
    super.k();
    this.g = false;
    ReadInJoyChannelWaterFallViewController localReadInJoyChannelWaterFallViewController = this.c;
    if (localReadInJoyChannelWaterFallViewController != null) {
      localReadInJoyChannelWaterFallViewController.p();
    }
  }
  
  public void l()
  {
    ReadInJoyChannelWaterFallViewController localReadInJoyChannelWaterFallViewController = this.c;
    if (localReadInJoyChannelWaterFallViewController != null) {
      localReadInJoyChannelWaterFallViewController.a(true);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ReadInJoyChannelWaterFallViewController localReadInJoyChannelWaterFallViewController = this.c;
    if (localReadInJoyChannelWaterFallViewController != null) {
      localReadInJoyChannelWaterFallViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    w();
    super.onCreate(paramBundle);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool;
    if (ReadInJoyHelper.Q(RIJQQAppInterfaceUtil.e()) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.d = bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("92 showSub = ");
      localStringBuilder.append(this.d);
      QLog.d("ReadInJoyFragmentWithSubChannel", 2, localStringBuilder.toString());
    }
    if ((!a()) && (this.d))
    {
      this.a = new ChannelClassificationListView(v());
      this.a.setOnItemClickListener(new ReadInJoyFragmentWithSubChannel.1(this));
    }
    this.b = x();
    this.c = new ReadInJoyChannelWaterFallViewController(d(), 0, v(), this.b);
    paramLayoutInflater = a(paramLayoutInflater, paramViewGroup, paramBundle, this.a);
    this.c.cT_();
    if (this.a != null) {
      this.c.k();
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.c.e();
  }
  
  public void onPause()
  {
    super.onPause();
    ReadInJoyChannelWaterFallViewController localReadInJoyChannelWaterFallViewController = this.c;
    if (localReadInJoyChannelWaterFallViewController != null) {
      localReadInJoyChannelWaterFallViewController.h();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.c.i();
  }
  
  public void onStop()
  {
    super.onStop();
    if (v().isFinishing())
    {
      ReadInJoyChannelWaterFallViewController localReadInJoyChannelWaterFallViewController = this.c;
      if (localReadInJoyChannelWaterFallViewController != null) {
        localReadInJoyChannelWaterFallViewController.c();
      }
    }
  }
  
  protected void w() {}
  
  public abstract ReadInJoyFragmentWithSubChannel.ReadInjoyViewInterface x();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyFragmentWithSubChannel
 * JD-Core Version:    0.7.0.1
 */