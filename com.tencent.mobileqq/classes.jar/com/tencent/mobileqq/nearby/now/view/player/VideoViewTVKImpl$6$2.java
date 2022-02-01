package com.tencent.mobileqq.nearby.now.view.player;

import android.text.TextUtils;
import axny;
import axoe;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class VideoViewTVKImpl$6$2
  implements Runnable
{
  public VideoViewTVKImpl$6$2(axoe paramaxoe) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_Axny.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_Axny.c)))
    {
      this.a.jdField_a_of_type_Axny.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.a.jdField_a_of_type_Axny.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_Axny.c, 0L, 0L, null, this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
      this.a.jdField_a_of_type_Axny.jdField_a_of_type_Int = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.player.VideoViewTVKImpl.6.2
 * JD-Core Version:    0.7.0.1
 */