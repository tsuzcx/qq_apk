package com.tencent.open.agent.auth.presenter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;

class BaseAuthorityPresenter$5
  implements DialogInterface.OnClickListener
{
  BaseAuthorityPresenter$5(BaseAuthorityPresenter paramBaseAuthorityPresenter, Runnable paramRunnable) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterBaseAuthorityPresenter.a.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter.5
 * JD-Core Version:    0.7.0.1
 */