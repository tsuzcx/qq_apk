package com.tencent.mobileqq.multicard;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.intimate.StrangerIntimateView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class StrangerIntimateViewDelegate
  extends MultiCardCustomViewDelegate
{
  private StrangerIntimateView a;
  
  public StrangerIntimateViewDelegate(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramBaseActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    StrangerIntimateView localStrangerIntimateView = this.a;
    if (localStrangerIntimateView != null)
    {
      localStrangerIntimateView.a(null);
      this.a = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    StrangerIntimateView localStrangerIntimateView = this.a;
    if (localStrangerIntimateView == null) {
      return;
    }
    if (paramInt == 0)
    {
      localStrangerIntimateView.c(true);
      this.a.b(true);
      this.a.d();
      return;
    }
    localStrangerIntimateView.b(false);
    this.a.c(false);
  }
  
  public void a(CardContent paramCardContent)
  {
    super.a(paramCardContent);
    if (this.a != null)
    {
      if (p() != 0) {
        this.a.b(false);
      }
      this.a.a(l(), m());
      this.a.c();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.a == null)
    {
      paramBundle = null;
      Bundle localBundle = k();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.a = new StrangerIntimateView(this.b, this.c, this.d, paramBundle);
      this.a.a(this);
      b(1);
      a(this.a.a());
    }
    b(this.a.a());
    if (l() != null) {
      this.a.a(l(), m());
    }
    return true;
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerIntimateViewDelegete", 2, "doOnResume() called");
    }
    if (this.a == null) {
      return;
    }
    if (p() == 0)
    {
      this.a.b(true);
      this.a.d();
    }
    else
    {
      this.a.b(false);
      this.a.f();
    }
    this.a.q();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerIntimateViewDelegete", 2, "doOnPause() called");
    }
  }
  
  public void e()
  {
    StrangerIntimateView localStrangerIntimateView = this.a;
    if (localStrangerIntimateView == null) {
      return;
    }
    localStrangerIntimateView.a(true);
    this.a.c();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.a == null) {
      return;
    }
    if (this.f != null)
    {
      this.f.removeView(this.a.a());
      this.f = null;
    }
    this.a.j();
  }
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.StrangerIntimateViewDelegate
 * JD-Core Version:    0.7.0.1
 */