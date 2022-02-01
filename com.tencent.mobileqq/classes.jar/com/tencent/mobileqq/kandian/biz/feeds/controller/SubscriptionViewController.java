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
  protected ReadInJoyObserver a = new SubscriptionViewController.1(this);
  private ViewGroup i;
  private ReadInJoyBaseListViewGroup j;
  
  public SubscriptionViewController(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.j.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.i = paramViewGroup;
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.j.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, paramInt);
    this.j.a(paramBoolean);
  }
  
  public void b()
  {
    super.b();
    Object localObject = this.j;
    if (localObject != null)
    {
      ((ReadInJoyBaseListViewGroup)localObject).a(null, null);
      this.j.b(null);
      localObject = new ViewGroup.LayoutParams(-1, -1);
      this.i.addView(this.j, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void c()
  {
    super.c();
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.j;
    if (localReadInJoyBaseListViewGroup != null)
    {
      localReadInJoyBaseListViewGroup.a(null, false);
      this.i.removeView(this.j);
    }
  }
  
  public void cT_()
  {
    super.cT_();
    b();
    ReadInJoyLogicEngine.a().y();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.a);
  }
  
  public void e()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.a);
    super.e();
    this.j.a(null, false);
    this.j.a(null);
    this.j.f();
  }
  
  public void f()
  {
    super.f();
    this.j.d();
  }
  
  public void g()
  {
    super.g();
    this.j.e();
  }
  
  public void h()
  {
    super.h();
    this.j.c();
  }
  
  public void i()
  {
    super.i();
    ReadInJoyLogicEngine.a().y();
    this.j.b();
  }
  
  public ViewGroup l()
  {
    return this.i;
  }
  
  public void t()
  {
    super.t();
    if (((this.b instanceof ReadInJoyFeedsActivity)) && (((ReadInJoyFeedsActivity)this.b).e() == 1)) {
      TroopBarAssistantManager.a().e(((BaseActivity)cQ_()).app);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.SubscriptionViewController
 * JD-Core Version:    0.7.0.1
 */