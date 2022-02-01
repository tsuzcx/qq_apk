package com.tencent.mobileqq.tribe.fragment;

import android.os.Bundle;
import com.tencent.mobileqq.tribe.playvideo.TribeVideoItem;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class TribeVideoListPlayerFragment$VideoViewHolder$2
  implements BusinessObserver
{
  TribeVideoListPlayerFragment$VideoViewHolder$2(TribeVideoListPlayerFragment.VideoViewHolder paramVideoViewHolder, TribeVideoItem paramTribeVideoItem) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoItem.k = 1;
      this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$VideoViewHolder.a.a(1, 1);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("TribeVideoListPlayerFragment", 2, "dianZan failed!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.VideoViewHolder.2
 * JD-Core Version:    0.7.0.1
 */