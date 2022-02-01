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
  ReadInJoyChannelWaterFallViewController jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelWaterFallViewController;
  ReadInJoyFragmentWithSubChannel.ReadInjoyViewInterface jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyFragmentWithSubChannel$ReadInjoyViewInterface;
  boolean e;
  
  protected abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, ChannelClassificationListView<C> paramChannelClassificationListView);
  
  public abstract ReadInJoyFragmentWithSubChannel.ReadInjoyViewInterface a();
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    ReadInJoyChannelWaterFallViewController localReadInJoyChannelWaterFallViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelWaterFallViewController;
    if (localReadInJoyChannelWaterFallViewController != null)
    {
      localReadInJoyChannelWaterFallViewController.a(true, 0);
      return;
    }
    ReadInJoyChannelViewPagerController.d(b());
  }
  
  protected void a(View paramView, int paramInt) {}
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if (RIJShowKanDianTabSp.c())
    {
      ReadInJoyChannelWaterFallViewController localReadInJoyChannelWaterFallViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelWaterFallViewController;
      if (localReadInJoyChannelWaterFallViewController != null) {
        localReadInJoyChannelWaterFallViewController.a(paramLogoutReason);
      }
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelWaterFallViewController;
    if (paramActivity != null) {
      paramActivity.b();
    }
  }
  
  public void d()
  {
    super.d();
    ReadInJoyChannelWaterFallViewController localReadInJoyChannelWaterFallViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelWaterFallViewController;
    if (localReadInJoyChannelWaterFallViewController != null) {
      localReadInJoyChannelWaterFallViewController.a(true);
    }
  }
  
  public void e()
  {
    super.e();
    this.b = false;
    ReadInJoyChannelWaterFallViewController localReadInJoyChannelWaterFallViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelWaterFallViewController;
    if (localReadInJoyChannelWaterFallViewController != null) {
      localReadInJoyChannelWaterFallViewController.l();
    }
  }
  
  public void f()
  {
    ReadInJoyChannelWaterFallViewController localReadInJoyChannelWaterFallViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelWaterFallViewController;
    if (localReadInJoyChannelWaterFallViewController != null) {
      localReadInJoyChannelWaterFallViewController.a(true);
    }
  }
  
  protected boolean f()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ReadInJoyChannelWaterFallViewController localReadInJoyChannelWaterFallViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelWaterFallViewController;
    if (localReadInJoyChannelWaterFallViewController != null) {
      localReadInJoyChannelWaterFallViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    a();
    super.onCreate(paramBundle);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool;
    if (ReadInJoyHelper.s(RIJQQAppInterfaceUtil.a()) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.e = bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("92 showSub = ");
      localStringBuilder.append(this.e);
      QLog.d("ReadInJoyFragmentWithSubChannel", 2, localStringBuilder.toString());
    }
    if ((!f()) && (this.e))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelChannelClassificationListView = new ChannelClassificationListView(a());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelChannelClassificationListView.setOnItemClickListener(new ReadInJoyFragmentWithSubChannel.1(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyFragmentWithSubChannel$ReadInjoyViewInterface = a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelWaterFallViewController = new ReadInJoyChannelWaterFallViewController(b(), 0, a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyFragmentWithSubChannel$ReadInjoyViewInterface);
    paramLayoutInflater = a(paramLayoutInflater, paramViewGroup, paramBundle, this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelChannelClassificationListView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelWaterFallViewController.aw_();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelChannelClassificationListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelWaterFallViewController.d();
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelWaterFallViewController.e();
  }
  
  public void onPause()
  {
    super.onPause();
    ReadInJoyChannelWaterFallViewController localReadInJoyChannelWaterFallViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelWaterFallViewController;
    if (localReadInJoyChannelWaterFallViewController != null) {
      localReadInJoyChannelWaterFallViewController.h();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelWaterFallViewController.i();
  }
  
  public void onStop()
  {
    super.onStop();
    if (a().isFinishing())
    {
      ReadInJoyChannelWaterFallViewController localReadInJoyChannelWaterFallViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelWaterFallViewController;
      if (localReadInJoyChannelWaterFallViewController != null) {
        localReadInJoyChannelWaterFallViewController.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyFragmentWithSubChannel
 * JD-Core Version:    0.7.0.1
 */