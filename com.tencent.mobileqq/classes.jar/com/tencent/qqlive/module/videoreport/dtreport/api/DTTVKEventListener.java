package com.tencent.qqlive.module.videoreport.dtreport.api;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder.Factory;
import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener.AdType;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener.EventParams;
import com.tencent.qqlive.tvkplayer.api.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;

public class DTTVKEventListener
  extends BaseTVKEventListener
{
  private static final String TAG = "DTTVKEventListener";
  private final IDTTVKDataProvider mProvider;
  
  private DTTVKEventListener(IDTTVKDataProvider paramIDTTVKDataProvider)
  {
    this.mProvider = paramIDTTVKDataProvider;
  }
  
  public static DTTVKEventListener create(IDTTVKDataProvider paramIDTTVKDataProvider)
  {
    return new DTTVKEventListener(paramIDTTVKDataProvider);
  }
  
  protected void handleADPlay(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams)
  {
    paramITVKMediaPlayer = new StringBuilder();
    paramITVKMediaPlayer.append("[VideoPlayReport] handleADPlay, flowId=");
    paramITVKMediaPlayer.append(paramEventParams.getFlowId());
    Log.d("DTTVKEventListener", paramITVKMediaPlayer.toString());
  }
  
  protected void handleADPrepared(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams)
  {
    paramITVKMediaPlayer = new StringBuilder();
    paramITVKMediaPlayer.append("[VideoPlayReport] handleADPrepared, flowId=");
    paramITVKMediaPlayer.append(paramEventParams.getFlowId());
    Log.d("DTTVKEventListener", paramITVKMediaPlayer.toString());
    paramITVKMediaPlayer = paramEventParams.getFlowId();
    ITVKPlayerEventListener.AdType localAdType = (ITVKPlayerEventListener.AdType)paramEventParams.getParamByKey("adtype");
    long l = ((Long)paramEventParams.getParamByKey("adduration")).longValue();
    ITVKDataBinder.Factory.with(paramITVKMediaPlayer).onAdPrepared(localAdType, l);
  }
  
  protected void handleADStop(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams)
  {
    paramITVKMediaPlayer = new StringBuilder();
    paramITVKMediaPlayer.append("[VideoPlayReport] handleADStop, flowId=");
    paramITVKMediaPlayer.append(paramEventParams.getFlowId());
    Log.d("DTTVKEventListener", paramITVKMediaPlayer.toString());
    ITVKDataBinder.Factory.with(paramEventParams.getFlowId()).onAdStop();
  }
  
  protected void handleNetVideoInfo(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams)
  {
    paramITVKMediaPlayer = new StringBuilder();
    paramITVKMediaPlayer.append("[VideoPlayReport] handleNetVideoInfo, flowId=");
    paramITVKMediaPlayer.append(paramEventParams.getFlowId());
    Log.d("DTTVKEventListener", paramITVKMediaPlayer.toString());
    paramITVKMediaPlayer = paramEventParams.getFlowId();
    paramEventParams = (TVKNetVideoInfo)paramEventParams.getParamByKey("TVKNetVideoInfo");
    if (paramEventParams == null) {
      return;
    }
    ITVKDataBinder.Factory.with(paramITVKMediaPlayer).onNetVideoInfo(paramEventParams);
  }
  
  protected void handleOpenMedia(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams)
  {
    paramITVKMediaPlayer = new StringBuilder();
    paramITVKMediaPlayer.append("[VideoPlayReport] handleOpenMedia, flowId=");
    paramITVKMediaPlayer.append(paramEventParams.getFlowId());
    Log.d("DTTVKEventListener", paramITVKMediaPlayer.toString());
    paramITVKMediaPlayer = (TVKPlayerVideoInfo)paramEventParams.getParamByKey("TVKPlayerVideoInfo");
    if (paramITVKMediaPlayer == null) {
      return;
    }
    String str = paramEventParams.getFlowId();
    paramEventParams = (String)paramEventParams.getParamByKey("url");
    if (TextUtils.isEmpty(paramITVKMediaPlayer.getFlowId())) {
      paramITVKMediaPlayer.setFlowId(str);
    }
    ITVKDataBinder.Factory.init(str, this.mProvider);
    ITVKDataBinder.Factory.with(str).onOpenMedia(paramITVKMediaPlayer, paramEventParams);
  }
  
  protected void handleUpdateReportParam(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams)
  {
    paramITVKMediaPlayer = new StringBuilder();
    paramITVKMediaPlayer.append("[VideoPlayReport] handleUpdateReportParam, flowId=");
    paramITVKMediaPlayer.append(paramEventParams.getFlowId());
    Log.d("DTTVKEventListener", paramITVKMediaPlayer.toString());
    paramITVKMediaPlayer = paramEventParams.getFlowId();
    paramEventParams = (TVKProperties)paramEventParams.getParamByKey("TVKProperties");
    if (paramEventParams == null) {
      return;
    }
    ITVKDataBinder.Factory.with(paramITVKMediaPlayer).onUpdateReportParam(paramEventParams);
  }
  
  protected void handleVideoPlay(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams)
  {
    paramITVKMediaPlayer = new StringBuilder();
    paramITVKMediaPlayer.append("[VideoPlayReport] handleVideoPlay, flowId=");
    paramITVKMediaPlayer.append(paramEventParams.getFlowId());
    Log.d("DTTVKEventListener", paramITVKMediaPlayer.toString());
    ITVKDataBinder.Factory.with(paramEventParams.getFlowId()).onVideoPlay();
  }
  
  protected void handleVideoPrepared(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams)
  {
    paramITVKMediaPlayer = new StringBuilder();
    paramITVKMediaPlayer.append("[VideoPlayReport] handleVideoPrepared, flowId=");
    paramITVKMediaPlayer.append(paramEventParams.getFlowId());
    Log.d("DTTVKEventListener", paramITVKMediaPlayer.toString());
    paramITVKMediaPlayer = paramEventParams.getFlowId();
    long l = ((Long)paramEventParams.getParamByKey("videoDuration")).longValue();
    ITVKDataBinder.Factory.with(paramITVKMediaPlayer).onVideoPrepared(l);
  }
  
  protected void handleVideoStop(ITVKMediaPlayer paramITVKMediaPlayer, ITVKPlayerEventListener.EventParams paramEventParams)
  {
    paramITVKMediaPlayer = new StringBuilder();
    paramITVKMediaPlayer.append("[VideoPlayReport] handleVideoStop, flowId=");
    paramITVKMediaPlayer.append(paramEventParams.getFlowId());
    Log.d("DTTVKEventListener", paramITVKMediaPlayer.toString());
    paramITVKMediaPlayer = paramEventParams.getFlowId();
    ITVKDataBinder.Factory.with(paramITVKMediaPlayer).onVideoStop();
    ITVKDataBinder.Factory.release(paramITVKMediaPlayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.api.DTTVKEventListener
 * JD-Core Version:    0.7.0.1
 */