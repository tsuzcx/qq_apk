package com.tencent.mobileqq.nearby.now.view.viewmodel;

import android.app.Activity;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.DeleteFeedCallback;
import com.tencent.mobileqq.widget.QQToast;

class PlayOperationViewModel$22$1$1
  implements NearbyMomentManager.DeleteFeedCallback
{
  PlayOperationViewModel$22$1$1(PlayOperationViewModel.22.1 param1) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      NearbyMomentManager localNearbyMomentManager = (NearbyMomentManager)this.a.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER);
      if (localNearbyMomentManager != null) {
        localNearbyMomentManager.d(paramString);
      }
      PlayOperationViewModel.a(this.a.a.a, paramString);
      if ((this.a.a.a.jdField_a_of_type_AndroidViewView.getContext() instanceof Activity)) {
        ((BaseActivity)this.a.a.a.jdField_a_of_type_AndroidViewView.getContext()).finish();
      }
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131708241), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.22.1.1
 * JD-Core Version:    0.7.0.1
 */