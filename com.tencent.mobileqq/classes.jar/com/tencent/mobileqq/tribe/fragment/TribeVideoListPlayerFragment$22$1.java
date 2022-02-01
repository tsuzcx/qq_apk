package com.tencent.mobileqq.tribe.fragment;

import android.view.View;
import bdlv;
import bdmc;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.superplayer.api.ISuperPlayer;

public class TribeVideoListPlayerFragment$22$1
  implements Runnable
{
  public TribeVideoListPlayerFragment$22$1(bdlv parambdlv) {}
  
  public void run()
  {
    if (((TribeVideoListPlayerFragment.a(this.a.a) != null) && (TribeVideoListPlayerFragment.a(this.a.a).isVisible())) || (this.a.a.e))
    {
      if ((((View)this.a.a.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag() instanceof bdmc))
      {
        this.a.a.a(((bdmc)((View)this.a.a.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag()).a, this.a.a.jdField_a_of_type_Long, this.a.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs(), true);
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