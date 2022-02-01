package com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer;

import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener.EventParams;

class BaseTVKEventListener$6
  implements BaseTVKEventListener.MessageExecutor
{
  BaseTVKEventListener$6(BaseTVKEventListener paramBaseTVKEventListener) {}
  
  public void execute(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams)
  {
    this.a.handleVideoPlay(paramITVKMediaPlayer, paramEventParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener.6
 * JD-Core Version:    0.7.0.1
 */