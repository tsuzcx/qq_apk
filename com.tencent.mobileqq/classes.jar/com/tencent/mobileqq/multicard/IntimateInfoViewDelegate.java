package com.tencent.mobileqq.multicard;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.IntimateInfoView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class IntimateInfoViewDelegate
  extends MultiCardCustomViewDelegate
{
  private IntimateInfoView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView;
  boolean jdField_a_of_type_Boolean = false;
  
  public IntimateInfoViewDelegate(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.a(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.c(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.b(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.a(3);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.b(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.c(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.a(4);
  }
  
  public void a(CardContent paramCardContent)
  {
    super.a(paramCardContent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.b(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.a(a(), a());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView = new IntimateInfoView(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.a(this);
      b(1);
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.a());
    }
    b(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.a());
    if (a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.a(a(), a());
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.h();
    }
    return true;
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoViewDelegete", 2, "doOnResume() called");
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.b(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.c();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.l();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.h();
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.b(false);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoViewDelegete", 2, "doOnPause() called");
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.g();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.a(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.i();
  }
  
  public void h() {}
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.n();
    }
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.o();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.IntimateInfoViewDelegate
 * JD-Core Version:    0.7.0.1
 */