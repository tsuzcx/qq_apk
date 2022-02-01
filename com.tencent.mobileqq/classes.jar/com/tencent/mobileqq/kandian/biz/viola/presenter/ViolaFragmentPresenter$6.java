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
    this.a.a.d();
    this.a.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "initViola success!");
    }
  }
  
  public void a(int paramInt)
  {
    this.a.a.d();
    this.a.a.b();
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
    if ((this.a.a.a()) && (paramBoolean)) {
      if (Math.abs(paramInt1) >= this.a.a.a() / 2)
      {
        if (!ViolaFragmentPresenter.a(this.a))
        {
          ViolaFragmentPresenter.a(this.a).setStatusBarFontColor(Boolean.valueOf(false));
          FlymeOSStatusBarFontUtils.a(ViolaFragmentPresenter.a(this.a), true);
          ViolaFragmentPresenter.a(this.a, true);
        }
      }
      else if (ViolaFragmentPresenter.a(this.a))
      {
        ViolaFragmentPresenter.a(this.a).setStatusBarFontColor(Boolean.valueOf(true));
        FlymeOSStatusBarFontUtils.a(ViolaFragmentPresenter.a(this.a), false);
        ViolaFragmentPresenter.a(this.a, false);
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (ViolaFragmentPresenter.a(this.a) != null) {
      ViolaFragmentPresenter.a(this.a).a(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.presenter.ViolaFragmentPresenter.6
 * JD-Core Version:    0.7.0.1
 */