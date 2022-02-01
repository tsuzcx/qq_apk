package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.app.Activity;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.profilecard.INearbyMomentManager;
import com.tencent.mobileqq.nearby.profilecard.moment.DeleteFeedCallback;
import com.tencent.mobileqq.widget.QQToast;

class PlayOperationViewModelImpl$20$1$1
  implements DeleteFeedCallback
{
  PlayOperationViewModelImpl$20$1$1(PlayOperationViewModelImpl.20.1 param1) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      INearbyMomentManager localINearbyMomentManager = (INearbyMomentManager)this.a.a.a.app.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER);
      if (localINearbyMomentManager != null) {
        localINearbyMomentManager.c(paramString);
      }
      PlayOperationViewModelImpl.access$1300(this.a.a.a, paramString);
      if ((this.a.a.a.mBinding.getContext() instanceof Activity)) {
        ((BaseActivity)this.a.a.a.mBinding.getContext()).finish();
      }
    }
    else
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131708250), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.20.1.1
 * JD-Core Version:    0.7.0.1
 */