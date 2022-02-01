package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.profilecard.INearbyMomentManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class PlayOperationViewModelImpl$20$1
  implements DialogInterface.OnClickListener
{
  PlayOperationViewModelImpl$20$1(PlayOperationViewModelImpl.20 param20) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(this.a.a.app.getApp()))
    {
      QQToast.a(this.a.a.mBinding.getContext(), 1, HardCodeUtil.a(2131708249), 0).a();
      return;
    }
    ((INearbyMomentManager)this.a.a.app.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).a(this.a.a.mVideoData.a, this.a.a.mVideoData.f, this.a.a.mVideoData.k, new PlayOperationViewModelImpl.20.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.20.1
 * JD-Core Version:    0.7.0.1
 */