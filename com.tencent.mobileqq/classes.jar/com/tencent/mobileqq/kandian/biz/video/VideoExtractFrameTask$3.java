package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class VideoExtractFrameTask$3
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  VideoExtractFrameTask$3(VideoExtractFrameTask paramVideoExtractFrameTask) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoExtractFrameTask.a(), 2, "播放器状态回调 onVideoPrepared");
    }
    VideoExtractFrameTask.a(this.a, System.currentTimeMillis());
    paramTVK_IMediaPlayer = new HashSet();
    Iterator localIterator = VideoExtractFrameTask.a(this.a).entrySet().iterator();
    while (localIterator.hasNext()) {
      paramTVK_IMediaPlayer.add(((Map.Entry)localIterator.next()).getKey());
    }
    VideoExtractFrameTask.a(this.a).setExtractFrameModeInfo(true, paramTVK_IMediaPlayer);
    VideoExtractFrameTask.a(this.a).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoExtractFrameTask.3
 * JD-Core Version:    0.7.0.1
 */