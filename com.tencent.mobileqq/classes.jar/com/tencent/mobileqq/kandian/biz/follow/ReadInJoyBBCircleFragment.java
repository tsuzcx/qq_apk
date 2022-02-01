package com.tencent.mobileqq.kandian.biz.follow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup;
import com.tencent.mobileqq.kandian.biz.feeds.constants.IReadInJoyBBCircleFragmentConst;
import com.tencent.mobileqq.kandian.biz.feeds.controller.HeaderViewController;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyChannelViewController;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyDiandianHeaderController;
import com.tencent.mobileqq.kandian.biz.framework.RIJFrameworkHeaderManager;
import com.tencent.mobileqq.kandian.biz.reddot.KandianSubscribeReportUtils;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager.KandianSubscribeMessageObserver;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class ReadInJoyBBCircleFragment
  extends ReadInJoyBaseFragment
  implements IReadInJoyBBCircleFragmentConst, KandianSubscribeManager.KandianSubscribeMessageObserver
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TimeSliceHelper jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper = new TimeSliceHelper();
  protected ReadInJoyChannelViewController a;
  private boolean e = false;
  
  public ReadInJoyBBCircleFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController = null;
  }
  
  private void i()
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    localObject = ((Activity)localObject).getIntent();
    KandianRedDotInfo localKandianRedDotInfo = KandianSubscribeManager.a();
    if (localKandianRedDotInfo != null) {
      ((Intent)localObject).putExtra("kandian_feeds_red_pnt_info", localKandianRedDotInfo);
    }
  }
  
  private void j()
  {
    try
    {
      boolean bool = this.e;
      if (bool) {
        return;
      }
      if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_AndroidViewView != null))
      {
        Object localObject1 = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131376123);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController = ((ReadInJoyChannelViewController)ReadInJoyUtils.a.remove(Integer.valueOf(70)));
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController = new ReadInJoyChannelViewController((Activity)this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a(70);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.b(0);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a((ViewGroup)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.b(true);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.aw_();
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a((ViewGroup)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.c();
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.b();
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkCallHotwordChange, this.jdField_b_of_type_Int);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a();
        if ((localObject1 != null) && ((localObject1 instanceof ReadInJoyBaseListViewGroup))) {
          ((ReadInJoyBaseListViewGroup)localObject1).g();
        }
        ReadinjoySPEventReport.a(0, KandianSubscribeReportUtils.a(), 0);
        this.e = true;
      }
      return;
    }
    finally {}
  }
  
  private void k()
  {
    ThreadManager.executeOnSubThread(new ReadInJoyBBCircleFragment.1(this));
  }
  
  public void a()
  {
    i();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null)
    {
      localReadInJoyChannelViewController.a(true);
      return;
    }
    ReadInJoyChannelViewPagerController.d(b());
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (!this.e) {
      j();
    }
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (paramActivity != null) {
      paramActivity.i();
    }
    QLog.d("ReadInJoyBBCircleFragment", 2, "[notifyShowSelf] show!");
    i();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80093F0", "0X80093F0", 0, 0, "", "", "", "", false);
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if ((paramActivity != null) && ((paramActivity.a() instanceof ReadInJoyListViewGroup)))
    {
      paramActivity = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a()).a().a().iterator();
      while (paramActivity.hasNext())
      {
        paramBundle = (HeaderViewController)paramActivity.next();
        if ((paramBundle instanceof ReadInJoyDiandianHeaderController)) {
          paramBundle.e();
        }
      }
    }
  }
  
  public int b()
  {
    return 70;
  }
  
  public void e()
  {
    super.e();
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.h();
    }
  }
  
  public void f()
  {
    super.f();
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.a(true);
    }
  }
  
  public void g()
  {
    super.g();
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.k();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a();
    if (((localView instanceof ReadInJoyListViewGroup)) && (((ReadInJoyListViewGroup)localView).a())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = a();
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (Build.VERSION.SDK_INT >= 11)) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().setFlags(16777216, 16777216);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560199, paramViewGroup, false);
    if ((getUserVisibleHint()) || (!ReadInJoyUtils.a())) {
      j();
    }
    VideoReport.setPageId(this.jdField_a_of_type_AndroidViewView, "14");
    VideoReport.setPageParams(this.jdField_a_of_type_AndroidViewView, new RIJDtParamBuilder().a(Integer.valueOf(70)).a());
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    k();
    super.onDestroy();
    ReadInJoyLogicEngine.a().a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localObject != null)
    {
      ((ReadInJoyChannelViewController)localObject).e();
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a();
      if ((localObject != null) && ((localObject instanceof ReadInJoyBaseListViewGroup))) {
        ((ReadInJoyBaseListViewGroup)localObject).h();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController = null;
    localObject = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject != null)
    {
      localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if ((localObject != null) && (((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine() != null))
      {
        localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().a();
        if (localObject != null) {
          ((ReadInJoyUserInfoModule)localObject).a();
        }
      }
    }
  }
  
  public void onDestroyView()
  {
    ((KandianSubscribeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER)).a(this);
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.h();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController != null) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.i();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.f();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.a();
  }
  
  public void onStop()
  {
    super.onStop();
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.g();
    }
    if (!BaseActivity.mAppForground) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.b();
    }
    if (a().isFinishing())
    {
      ReadinjoySPEventReport.a(1, KandianSubscribeReportUtils.a(), 0);
      KandianSubscribeReportUtils.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.ReadInJoyBBCircleFragment
 * JD-Core Version:    0.7.0.1
 */