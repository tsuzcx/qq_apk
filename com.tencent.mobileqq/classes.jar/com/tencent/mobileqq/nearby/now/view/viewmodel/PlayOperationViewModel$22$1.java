package com.tencent.mobileqq.nearby.now.view.viewmodel;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class PlayOperationViewModel$22$1
  implements DialogInterface.OnClickListener
{
  PlayOperationViewModel$22$1(PlayOperationViewModel.22 param22) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.g(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
    {
      QQToast.a(this.a.a.jdField_a_of_type_AndroidViewView.getContext(), 1, HardCodeUtil.a(2131708240), 0).a();
      return;
    }
    ((NearbyMomentManager)this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).a(this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a, this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.e, this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.j, new PlayOperationViewModel.22.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.22.1
 * JD-Core Version:    0.7.0.1
 */