package com.tencent.mobileqq.tribe.fragment;

import android.view.View;
import bayz;
import bazh;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class TribeVideoListPlayerFragment$23$1
  implements Runnable
{
  public TribeVideoListPlayerFragment$23$1(bayz parambayz) {}
  
  public void run()
  {
    if (((TribeVideoListPlayerFragment.a(this.a.a) != null) && (TribeVideoListPlayerFragment.a(this.a.a).isVisible())) || (this.a.a.e))
    {
      if ((((View)this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getTag() instanceof bazh))
      {
        this.a.a.a(((bazh)((View)this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getTag()).a, this.a.a.jdField_a_of_type_Long, this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion(), true);
        this.a.a.jdField_a_of_type_Long = 0L;
      }
      this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      return;
    }
    this.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
    this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
    this.a.a.a(true);
    this.a.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.23.1
 * JD-Core Version:    0.7.0.1
 */