package com.tencent.mobileqq.videoplatform;

import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.player.MediaInfo;

class VideoPlayerProxy$3
  implements Runnable
{
  VideoPlayerProxy$3(VideoPlayerProxy paramVideoPlayerProxy) {}
  
  public void run()
  {
    synchronized (VideoPlayerProxy.access$300(this.this$0))
    {
      if ((VideoPlayerProxy.access$300(this.this$0) != null) && (VideoPlayerProxy.access$000(this.this$0) != null))
      {
        VideoPlayerProxy.access$300(this.this$0).hasStarted = true;
        MediaInfo localMediaInfo = VideoPlayerProxy.access$000(this.this$0).getMediaInfo();
        if (localMediaInfo != null)
        {
          VideoPlayerProxy.access$300(this.this$0).videoDuration = localMediaInfo.getDurationMs();
          VideoPlayerProxy.access$300(this.this$0).videoWidth = localMediaInfo.getVideoWidth();
          VideoPlayerProxy.access$300(this.this$0).videoHeight = localMediaInfo.getVideoHeight();
          VideoPlayerProxy.access$300(this.this$0).videoBitRate = localMediaInfo.getVideoBitRate();
          VideoPlayerProxy.access$300(this.this$0).videoCodec = localMediaInfo.getVideoCodec();
          VideoPlayerProxy.access$300(this.this$0).videoProfile = localMediaInfo.getVideoProfile();
          VideoPlayerProxy.access$300(this.this$0).audioBitRate = localMediaInfo.getAudioBitRate();
          VideoPlayerProxy.access$300(this.this$0).audioChannels = localMediaInfo.getChannels();
          VideoPlayerProxy.access$300(this.this$0).audioCodec = localMediaInfo.getAudioCodec();
          VideoPlayerProxy.access$300(this.this$0).audioProfile = localMediaInfo.getAudioProfile();
          VideoPlayerProxy.access$300(this.this$0).audioSampleRate = localMediaInfo.getSampleRate();
          VideoPlayerProxy.access$300(this.this$0).containerFormat = localMediaInfo.getContainerFormat();
        }
        VideoPlayerProxy.access$300(this.this$0).startPlayTime = System.currentTimeMillis();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlayerProxy.3
 * JD-Core Version:    0.7.0.1
 */