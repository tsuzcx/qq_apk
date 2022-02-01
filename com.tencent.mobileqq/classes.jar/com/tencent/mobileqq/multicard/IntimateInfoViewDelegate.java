package com.tencent.mobileqq.multicard;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.IntimateInfoView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class IntimateInfoViewDelegate
  extends MultiCardCustomViewDelegate
{
  boolean a = false;
  private IntimateInfoView j;
  
  public IntimateInfoViewDelegate(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramBaseActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    IntimateInfoView localIntimateInfoView = this.j;
    if (localIntimateInfoView != null)
    {
      localIntimateInfoView.a(null);
      this.j = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    IntimateInfoView localIntimateInfoView = this.j;
    if (localIntimateInfoView == null) {
      return;
    }
    if (paramInt == 0)
    {
      localIntimateInfoView.c(true);
      this.j.b(true);
      this.j.d();
      this.j.a(3);
      return;
    }
    localIntimateInfoView.b(false);
    this.j.c(false);
    this.j.a(4);
  }
  
  public void a(CardContent paramCardContent)
  {
    super.a(paramCardContent);
    if (this.j != null)
    {
      if (p() != 0) {
        this.j.b(false);
      }
      this.j.a(l(), m());
      this.j.c();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.j == null)
    {
      paramBundle = null;
      Bundle localBundle = k();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.j = new IntimateInfoView(this.b, this.c, this.d, paramBundle);
      this.j.a(this);
      b(1);
      a(this.j.a());
    }
    b(this.j.a());
    if (l() != null) {
      this.j.a(l(), m());
    }
    if (this.a) {
      this.j.i();
    }
    return true;
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoViewDelegete", 2, "doOnResume() called");
    }
    this.a = true;
    if (this.j == null) {
      return;
    }
    if (p() == 0)
    {
      this.j.b(true);
      this.j.d();
    }
    else
    {
      this.j.b(false);
    }
    this.j.q();
    this.j.i();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoViewDelegete", 2, "doOnPause() called");
    }
    this.a = false;
    IntimateInfoView localIntimateInfoView = this.j;
    if (localIntimateInfoView == null) {
      return;
    }
    localIntimateInfoView.h();
  }
  
  public void e()
  {
    IntimateInfoView localIntimateInfoView = this.j;
    if (localIntimateInfoView == null) {
      return;
    }
    localIntimateInfoView.a(true);
    this.j.c();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    IntimateInfoView localIntimateInfoView = this.j;
    if (localIntimateInfoView == null) {
      return;
    }
    localIntimateInfoView.j();
  }
  
  public void h() {}
  
  public void i()
  {
    super.i();
    IntimateInfoView localIntimateInfoView = this.j;
    if (localIntimateInfoView != null) {
      localIntimateInfoView.s();
    }
  }
  
  public void j()
  {
    super.j();
    IntimateInfoView localIntimateInfoView = this.j;
    if (localIntimateInfoView != null) {
      localIntimateInfoView.t();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.IntimateInfoViewDelegate
 * JD-Core Version:    0.7.0.1
 */