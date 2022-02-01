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
    if (!NetworkUtil.isNetworkAvailable(this.a.c.app.getApp()))
    {
      QQToast.makeText(this.a.c.mBinding.getContext(), 1, HardCodeUtil.a(2131906043), 0).show();
      return;
    }
    ((INearbyMomentManager)this.a.c.app.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).a(this.a.c.mVideoData.c, this.a.c.mVideoData.y, this.a.c.mVideoData.G, new PlayOperationViewModelImpl.20.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.20.1
 * JD-Core Version:    0.7.0.1
 */