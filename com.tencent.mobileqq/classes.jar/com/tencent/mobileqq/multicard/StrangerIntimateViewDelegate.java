package com.tencent.mobileqq.multicard;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.intimate.StrangerIntimateView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class StrangerIntimateViewDelegate
  extends MultiCardCustomViewDelegate
{
  private StrangerIntimateView a;
  
  public StrangerIntimateViewDelegate(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.a(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.c(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.b(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.c();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.b(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.c(false);
  }
  
  public void a(CardContent paramCardContent)
  {
    super.a(paramCardContent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.b(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.a(a(), a());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView = new StrangerIntimateView(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.a(this);
      b(1);
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.a());
    }
    b(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.a());
    if (a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.a(a(), a());
    }
    return true;
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerIntimateViewDelegete", 2, "doOnResume() called");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.b(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.c();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.l();
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.b(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.e();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerIntimateViewDelegete", 2, "doOnPause() called");
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.a(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.a());
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateStrangerIntimateView.i();
  }
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.StrangerIntimateViewDelegate
 * JD-Core Version:    0.7.0.1
 */