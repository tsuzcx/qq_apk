package com.tencent.mobileqq.video;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

class VipVideoPlayActivity$VideoPlayerPreparedListener
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  VipVideoPlayActivity$VideoPlayerPreparedListener(VipVideoPlayActivity paramVipVideoPlayActivity) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipVideoPlayActivity", 2, "video player prepared");
    }
    this.a.runOnUiThread(new VipVideoPlayActivity.VideoPlayerPreparedListener.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.video.VipVideoPlayActivity.VideoPlayerPreparedListener
 * JD-Core Version:    0.7.0.1
 */