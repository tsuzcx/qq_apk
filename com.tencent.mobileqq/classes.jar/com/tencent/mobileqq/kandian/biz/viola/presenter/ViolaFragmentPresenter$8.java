package com.tencent.mobileqq.kandian.biz.viola.presenter;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView.ViolaViewListener;
import com.tencent.mobileqq.kandian.glue.viola.delegate.ViolaUiDelegate;
import com.tencent.qphone.base.util.QLog;

class ViolaFragmentPresenter$8
  implements IViolaBaseView.ViolaViewListener
{
  ViolaFragmentPresenter$8(ViolaFragmentPresenter paramViolaFragmentPresenter) {}
  
  public void a()
  {
    this.a.b.h();
    this.a.b.a();
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "reloadPage success!");
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (ViolaFragmentPresenter.d(this.a) != null) {
      localObject = ViolaFragmentPresenter.d(this.a).getMainLooper();
    } else {
      localObject = BaseActivity.sTopActivity.getMainLooper();
    }
    new Handler((Looper)localObject).postDelayed(new ViolaFragmentPresenter.8.1(this), 1000L);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reloadPage error,error code=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("ViolaFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reloadPage process,process code=");
      localStringBuilder.append(paramInt);
      QLog.d("ViolaFragment", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.presenter.ViolaFragmentPresenter.8
 * JD-Core Version:    0.7.0.1
 */