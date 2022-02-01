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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaPresenterViolaFragmentPresenter.a.d();
    if (ViolaFragmentPresenter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaPresenterViolaFragmentPresenter).onHippyPageLoad(false, paramString)) {
      return;
    }
    if (paramInt != -11) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaPresenterViolaFragmentPresenter.a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_AndroidViewViewGroup);
    }
  }
  
  public void onSuccess()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaPresenterViolaFragmentPresenter.a.d();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaPresenterViolaFragmentPresenter.a.a();
    QLog.d("Hippy", 1, "Hippy: initHippy success!");
    ViolaFragmentPresenter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaPresenterViolaFragmentPresenter).onHippyPageLoad(true, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.presenter.ViolaFragmentPresenter.3
 * JD-Core Version:    0.7.0.1
 */