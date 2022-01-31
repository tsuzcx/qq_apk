package com.tencent.mobileqq.tribe.fragment;

import android.os.Handler;
import azaq;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class TribeVideoListPlayerFragment$13$1
  implements Runnable
{
  public TribeVideoListPlayerFragment$13$1(azaq paramazaq) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_Boolean = true;
    if (this.a.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.g) {
      this.a.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
    for (;;)
    {
      TribeVideoListPlayerFragment.jdField_a_of_type_AndroidOsHandler.postDelayed(new TribeVideoListPlayerFragment.13.1.1(this), 500L);
      this.a.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.b(this.a.jdField_a_of_type_Azbj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.13.1
 * JD-Core Version:    0.7.0.1
 */