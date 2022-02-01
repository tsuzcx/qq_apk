package com.tencent.mobileqq.kandian.biz.viola.presenter;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentView;
import com.tencent.mobileqq.kandian.glue.viola.delegate.ViolaUiDelegate;
import com.tencent.qphone.base.util.QLog;

class ViolaFragmentPresenter$3
  implements HippyQQEngine.HippyQQEngineListener
{
  ViolaFragmentPresenter$3(ViolaFragmentPresenter paramViolaFragmentPresenter, Bundle paramBundle, ViewGroup paramViewGroup) {}
  
  public void onError(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Hippy: initHippy error statusCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", msg=");
    localStringBuilder.append(paramString);
    QLog.d("Hippy", 1, localStringBuilder.toString());
    this.c.b.h();
    if (ViolaFragmentPresenter.a(this.c).onHippyPageLoad(false, paramString)) {
      return;
    }
    if (paramInt != -11) {
      this.c.a(this.a, this.b);
    }
  }
  
  public void onSuccess()
  {
    this.c.b.h();
    this.c.b.a();
    QLog.d("Hippy", 1, "Hippy: initHippy success!");
    ViolaFragmentPresenter.a(this.c).onHippyPageLoad(true, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.presenter.ViolaFragmentPresenter.3
 * JD-Core Version:    0.7.0.1
 */