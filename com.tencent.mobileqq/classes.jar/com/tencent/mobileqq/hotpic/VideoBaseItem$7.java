package com.tencent.mobileqq.hotpic;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnNetVideoInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;

class VideoBaseItem$7
  implements TVK_IMediaPlayer.OnNetVideoInfoListener
{
  VideoBaseItem$7(VideoBaseItem paramVideoBaseItem) {}
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (QLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = new StringBuilder();
      paramTVK_IMediaPlayer.append("[MediaPlayer] onNetVideoInfo what=");
      paramTVK_IMediaPlayer.append(paramTVK_NetVideoInfo.getErrInfo());
      paramTVK_IMediaPlayer.append(",extra=");
      paramTVK_IMediaPlayer.append(paramTVK_NetVideoInfo.getState());
      paramTVK_IMediaPlayer.append(",mCacheProgress=");
      QLog.d("VideoBaseItem", 2, paramTVK_IMediaPlayer.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.VideoBaseItem.7
 * JD-Core Version:    0.7.0.1
 */