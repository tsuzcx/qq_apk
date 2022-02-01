package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.qwallet.temp.IQwTemp;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongView;
import com.tencent.qphone.base.util.QLog;

class RedPacketKSongFragment$5
  implements MediaPlayer.OnPreparedListener
{
  RedPacketKSongFragment$5(RedPacketKSongFragment paramRedPacketKSongFragment, boolean paramBoolean) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketKSongFragment", 2, "playSong onPrepared");
    }
    RedPacketKSongFragment.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapImplRedPacketKSongFragment, true);
    QQAudioUtils.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapImplRedPacketKSongFragment.getQBaseActivity(), true);
    ((IQwTemp)QRoute.api(IQwTemp.class)).mediaPlayer_doStop(true, this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapImplRedPacketKSongFragment.getQBaseActivity().getAppRuntime());
    paramMediaPlayer.start();
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapImplRedPacketKSongFragment.a.a(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKSongFragment.5
 * JD-Core Version:    0.7.0.1
 */