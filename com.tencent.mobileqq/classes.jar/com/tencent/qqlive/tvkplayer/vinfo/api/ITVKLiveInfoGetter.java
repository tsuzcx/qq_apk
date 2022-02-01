package com.tencent.qqlive.tvkplayer.vinfo.api;

import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKUserInfo;
import java.util.Map;

public abstract interface ITVKLiveInfoGetter
{
  public static final int LIVE_CGI_JSON_ERROR = 121008;
  public static final int LIVE_CGI_NET_ERROR = 141001;
  public static final int LIVE_CGI_PARAMS_ERROR = 143004;
  public static final int LIVE_CGI_SERVER_ERROR = 141006;
  public static final int LIVE_CGI_UNKONWN_ERROR = 144000;
  public static final int LIVE_CGI_VINFO_ERROR = 141007;
  public static final int LIVE_STREAM_FORMAT_AUTO = 0;
  public static final int LIVE_STREAM_FORMAT_FLV = 1;
  public static final int LIVE_STREAM_FORMAT_HLS = 2;
  
  public abstract int getDlnaUrl(TVKUserInfo paramTVKUserInfo, String paramString1, String paramString2, Map<String, String> paramMap);
  
  public abstract int getLiveInfo(TVKUserInfo paramTVKUserInfo, TVKPlayerVideoInfo paramTVKPlayerVideoInfo, String paramString, int paramInt, boolean paramBoolean);
  
  public abstract int inquireInfo(TVKUserInfo paramTVKUserInfo, String paramString1, String paramString2, Map<String, String> paramMap);
  
  public abstract int preLoadLiveInfo(TVKUserInfo paramTVKUserInfo, String paramString1, String paramString2, int paramInt, boolean paramBoolean, Map<String, String> paramMap);
  
  public abstract void setOnGetLiveInfoListener(ITVKLiveInfoGetter.OnGetLiveInfoListener paramOnGetLiveInfoListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter
 * JD-Core Version:    0.7.0.1
 */