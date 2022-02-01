package com.tencent.mobileqq.tribe.fragment;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.superplayer.api.ISuperPlayer;

class TribeVideoListPlayerFragment$22$1
  implements Runnable
{
  TribeVideoListPlayerFragment$22$1(TribeVideoListPlayerFragment.22 param22) {}
  
  public void run()
  {
    if (((TribeVideoListPlayerFragment.a(this.a.a) != null) && (TribeVideoListPlayerFragment.a(this.a.a).isVisible())) || (this.a.a.e))
    {
      if ((((View)this.a.a.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag() instanceof TribeVideoListPlayerFragment.ADViewHolder))
      {
        this.a.a.a(((TribeVideoListPlayerFragment.ADViewHolder)((View)this.a.a.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag()).a, this.a.a.jdField_a_of_type_Long, this.a.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs(), true);
        this.a.a.jdField_a_of_type_Long = 0L;
      }
      this.a.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
      return;
    }
    this.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
    this.a.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
    this.a.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
    this.a.a.a(true);
    this.a.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.22.1
 * JD-Core Version:    0.7.0.1
 */