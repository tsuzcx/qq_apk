package com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer;

import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener.EventParams;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener.PlayerEvent;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseTVKEventListener
  implements ITVKPlayerEventListener
{
  private final Map<ITVKPlayerEventListener.PlayerEvent, BaseTVKEventListener.MessageExecutor> mMessageHandler = new HashMap();
  
  protected BaseTVKEventListener()
  {
    msgFunctionInit();
  }
  
  private void msgFunctionInit()
  {
    this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_OPEN_MEDIA, new BaseTVKEventListener.1(this));
    this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_CGI_RECEIVED, new BaseTVKEventListener.2(this));
    this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_UPDATE_REPORT_PARAM, new BaseTVKEventListener.3(this));
    this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_VIDEO_PREPARING, new BaseTVKEventListener.4(this));
    this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_VIDEO_PREPARED, new BaseTVKEventListener.5(this));
    this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_VIDEO_PLAYING, new BaseTVKEventListener.6(this));
    this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_VIDEO_PAUSED, new BaseTVKEventListener.7(this));
    this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_VIDEO_STOPED, new BaseTVKEventListener.8(this));
    this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_AD_PREPARING, new BaseTVKEventListener.9(this));
    this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_AD_PREPARED, new BaseTVKEventListener.10(this));
    this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_AD_PLAYING, new BaseTVKEventListener.11(this));
    this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_AD_PAUSED, new BaseTVKEventListener.12(this));
    this.mMessageHandler.put(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_AD_STOPED, new BaseTVKEventListener.13(this));
  }
  
  protected void handleADPause(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams) {}
  
  protected void handleADPlay(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams) {}
  
  protected void handleADPrepared(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams) {}
  
  protected void handleADPreparing(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams) {}
  
  protected void handleADStop(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams) {}
  
  protected void handleNetVideoInfo(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams) {}
  
  protected void handleOpenMedia(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams) {}
  
  protected void handleUpdateReportParam(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams) {}
  
  protected void handleVideoPause(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams) {}
  
  protected void handleVideoPlay(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams) {}
  
  protected void handleVideoPrepared(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams) {}
  
  protected void handleVideoPreparing(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams) {}
  
  protected void handleVideoStop(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams) {}
  
  public void onPlayerEvent(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.PlayerEvent paramPlayerEvent, ITVKPlayerEventListener.EventParams paramEventParams)
  {
    paramPlayerEvent = (BaseTVKEventListener.MessageExecutor)this.mMessageHandler.get(paramPlayerEvent);
    if (paramPlayerEvent != null) {
      paramPlayerEvent.execute(paramITVKMediaPlayer, paramEventParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener
 * JD-Core Version:    0.7.0.1
 */