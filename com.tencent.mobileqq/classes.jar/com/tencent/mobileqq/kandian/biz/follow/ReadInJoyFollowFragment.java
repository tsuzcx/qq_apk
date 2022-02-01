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
  private int jdField_a_of_type_Int = 1;
  private View jdField_a_of_type_AndroidViewView;
  protected ReadInJoyChannelViewController a;
  private boolean e;
  
  public static ReadInJoyFollowFragment a()
  {
    ReadInJoyFollowFragment localReadInJoyFollowFragment = new ReadInJoyFollowFragment();
    localReadInJoyFollowFragment.setArguments(new Bundle());
    return localReadInJoyFollowFragment;
  }
  
  private void a()
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131376123);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController = new ReadInJoyChannelViewController(a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a(70);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.b(0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a(localViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.aw_();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a(paramInt1, paramInt2, paramIntent);
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
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (paramBundle != null) {
      paramBundle.b();
    }
    this.e = true;
    if ((RIJShowKanDianTabSp.c()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      a().erasureTabRed(2);
    }
    else
    {
      paramActivity = ((ReadInJoyNewFeedsActivity)paramActivity).a();
      int i = paramActivity.b();
      if (i == 2) {
        paramActivity.b(i);
      }
      if ((a() != null) && (a().getTabRedNums(2) > 0))
      {
        paramActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
        if (paramActivity != null) {
          paramActivity.a(true);
        }
      }
    }
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (paramActivity != null) {
      paramActivity.i();
    }
    StatisticCollector.getInstance(a()).collectPerformance(((QQAppInterface)ReadInJoyUtils.a()).getCurrentUin(), "actReadInJoyEnterDD", true, 0L, 0L, null, null);
  }
  
  public int b()
  {
    return 70;
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    super.b(paramMessageRecord);
  }
  
  public boolean c()
  {
    return RIJUGCDianDian.a();
  }
  
  public void d()
  {
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.a(true);
    }
  }
  
  public void e()
  {
    super.e();
    this.e = false;
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.h();
    }
  }
  
  public void f()
  {
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.a(true);
    }
  }
  
  public void g()
  {
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.k();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a(paramInt1, paramInt2, paramIntent);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560199, paramViewGroup, false);
    a();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.e();
    ReadInJoyLogicEngine.a().a();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.c();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.e) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.h();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.e) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.i();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.e) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.f();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.ReadInJoyFollowFragment
 * JD-Core Version:    0.7.0.1
 */