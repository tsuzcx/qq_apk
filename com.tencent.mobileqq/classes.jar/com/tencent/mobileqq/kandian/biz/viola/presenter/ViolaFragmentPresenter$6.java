package com.tencent.mobileqq.kandian.biz.viola.presenter;

import com.tencent.mobileqq.kandian.base.utils.FlymeOSStatusBarFontUtils;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView.ViolaViewListener;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentView;
import com.tencent.mobileqq.kandian.biz.viola.contract.ViolaFragmentCommonLogicContract;
import com.tencent.mobileqq.kandian.glue.viola.delegate.ViolaUiDelegate;
import com.tencent.qphone.base.util.QLog;

class ViolaFragmentPresenter$6
  implements IViolaBaseView.ViolaViewListener
{
  ViolaFragmentPresenter$6(ViolaFragmentPresenter paramViolaFragmentPresenter) {}
  
  public void a()
  {
    this.a.b.h();
    this.a.b.a();
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "initViola success!");
    }
  }
  
  public void a(int paramInt)
  {
    this.a.b.h();
    this.a.b.f();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initViola error,error code=");
      localStringBuilder.append(paramInt);
      QLog.e("ViolaFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if ((this.a.b.d()) && (paramBoolean)) {
      if (Math.abs(paramInt1) >= this.a.b.m() / 2)
      {
        if (!ViolaFragmentPresenter.c(this.a))
        {
          ViolaFragmentPresenter.a(this.a).setStatusBarFontColor(Boolean.valueOf(false));
          FlymeOSStatusBarFontUtils.a(ViolaFragmentPresenter.d(this.a), true);
          ViolaFragmentPresenter.a(this.a, true);
        }
      }
      else if (ViolaFragmentPresenter.c(this.a))
      {
        ViolaFragmentPresenter.a(this.a).setStatusBarFontColor(Boolean.valueOf(true));
        FlymeOSStatusBarFontUtils.a(ViolaFragmentPresenter.d(this.a), false);
        ViolaFragmentPresenter.a(this.a, false);
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (ViolaFragmentPresenter.b(this.a) != null) {
      ViolaFragmentPresenter.b(this.a).a(paramInt);
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initViola process,process code=");
      localStringBuilder.append(paramInt);
      QLog.d("ViolaFragment", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.presenter.ViolaFragmentPresenter.6
 * JD-Core Version:    0.7.0.1
 */