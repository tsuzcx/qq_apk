package com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer;

import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener.EventParams;

class BaseTVKEventListener$13
  implements BaseTVKEventListener.MessageExecutor
{
  BaseTVKEventListener$13(BaseTVKEventListener paramBaseTVKEventListener) {}
  
  public void execute(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams)
  {
    this.a.handleADStop(paramITVKMediaPlayer, paramEventParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener.13
 * JD-Core Version:    0.7.0.1
 */