package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyFeedsActivity;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;

public class SubscriptionViewController
  extends ReadInJoyBaseViewController
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
  protected ReadInJoyObserver a;
  
  public SubscriptionViewController(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new SubscriptionViewController.1(this);
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a(paramBoolean);
  }
  
  public void aw_()
  {
    super.aw_();
    b();
    ReadInJoyLogicEngine.a().e();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void b()
  {
    super.b();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if (localObject != null)
    {
      ((ReadInJoyBaseListViewGroup)localObject).a(null, null);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.b(null);
      localObject = new ViewGroup.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void c()
  {
    super.c();
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if (localReadInJoyBaseListViewGroup != null)
    {
      localReadInJoyBaseListViewGroup.a(null, false);
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup);
    }
  }
  
  public void e()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a(null, false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a(null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.f();
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.d();
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.e();
  }
  
  public void h()
  {
    super.h();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.c();
  }
  
  public void i()
  {
    super.i();
    ReadInJoyLogicEngine.a().e();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.b();
  }
  
  public void m()
  {
    super.m();
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof ReadInJoyFeedsActivity)) && (((ReadInJoyFeedsActivity)this.jdField_a_of_type_AndroidAppActivity).a() == 1)) {
      TroopBarAssistantManager.a().d(((BaseActivity)a()).app);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.SubscriptionViewController
 * JD-Core Version:    0.7.0.1
 */