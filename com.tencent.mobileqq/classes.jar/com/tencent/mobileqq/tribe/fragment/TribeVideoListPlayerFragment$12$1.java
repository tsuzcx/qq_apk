package com.tencent.mobileqq.tribe.fragment;

import android.os.Handler;
import com.tencent.superplayer.api.ISuperPlayer;

class TribeVideoListPlayerFragment$12$1
  implements Runnable
{
  TribeVideoListPlayerFragment$12$1(TribeVideoListPlayerFragment.12 param12) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_Boolean = true;
    if (this.a.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.g) {
      this.a.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.pause();
    }
    for (;;)
    {
      TribeVideoListPlayerFragment.jdField_a_of_type_AndroidOsHandler.postDelayed(new TribeVideoListPlayerFragment.12.1.1(this), 500L);
      this.a.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.b(this.a.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$BaseVideoViewHolder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.12.1
 * JD-Core Version:    0.7.0.1
 */