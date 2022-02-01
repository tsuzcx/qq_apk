package com.tencent.thumbplayer.tplayer.plugins.report;

public class TPReportParams
{
  public static final int BUFFERING_REASON_BITRATE_JITTER = 1400109;
  public static final int BUFFERING_REASON_CDN_TIMEOUT = 1400103;
  public static final int BUFFERING_REASON_CDN_TIMEOUT_BUT_CONNECTED = 1400104;
  public static final int BUFFERING_REASON_DOWNLOAD_SHORT_TIME = 1400111;
  public static final int BUFFERING_REASON_DOWNLOAD_TASK = 1400101;
  public static final int BUFFERING_REASON_NETWORK_DEVICE_EXCEPTION = 1400102;
  public static final int BUFFERING_REASON_NETWORK_UNSTABLE = 1400100;
  public static final int BUFFERING_REASON_P2P_FASTER_THAN_HTTP = 1400110;
  public static final int BUFFERING_REASON_P2P_UPLOAD = 1400112;
  public static final int BUFFERING_REASON_RECEIVE_TIMEOUT = 1400105;
  public static final int BUFFERING_REASON_RECEIVE_TIMEOUT_BUT_CONNECTED = 1400106;
  public static final int BUFFERING_REASON_SLOWLY_SPEED = 1400107;
  public static final int BUFFERING_REASON_SLOWLY_SPEED_BUT_CONNECTED = 1400108;
  public static final String ERROR_CODE_NO_ERROR = "0";
  public static final String JSON_KEY_VAL = "val";
  public static final int LIVE_STEP_FAILED = 150;
  public static final int LIVE_STEP_LOADING_SUCC = 205;
  public static final int LIVE_STEP_PLAY = 263;
  public static final int NETWORK_TYPE_2G = 2;
  public static final int NETWORK_TYPE_3G = 3;
  public static final int NETWORK_TYPE_4G = 4;
  public static final int NETWORK_TYPE_5G = 5;
  public static final int NETWORK_TYPE_ETHERNET = 10;
  public static final int NETWORK_TYPE_UNKNOWN = 0;
  public static final int NETWORK_TYPE_WIFI = 1;
  public static final int PLAYER_STEP_BUFFERING = 35;
  public static final int PLAYER_STEP_FIRST_LOAD = 30;
  public static final int PLAYER_STEP_FIRST_RENDERING = 32;
  public static final int PLAYER_STEP_GET_CDN_URL = 15;
  public static final int PLAYER_STEP_INIT_PLAYER = 5;
  public static final int PLAYER_STEP_LOAD_SUBTITLE = 33;
  public static final int PLAYER_STEP_PLAY_DONE = 50;
  public static final int PLAYER_STEP_REDIRECT = 34;
  public static final int PLAYER_STEP_USER_SEEK = 40;
  public static final int PLAYER_TYPE_SYSTEM_PLAYER = 0;
  public static final int PLAYER_TYPE_THUMB_PLAYER = 1;
  public static final int PLAY_END_REASON_APP_EXIT = 2;
  public static final int PLAY_END_REASON_EOS = 0;
  public static final int PLAY_END_REASON_PLAYER_ERROR = 3;
  public static final int PLAY_END_REASON_USER_STOP = 1;
  public static final int PLAY_EVENT_NONE = 0;
  public static final int PLAY_EVENT_PAUSE_BY_DEVICE = 2;
  public static final int PLAY_EVENT_SCREEN_SHOT = 3;
  public static final int PLAY_EVENT_SEEK = 1;
  public static final int PLAY_SCENE_NORMAL_PLAY = 1;
  public static final int PLAY_SCENE_TRICK_PLAY = 2;
  public static final int PLAY_TYPE_LIVE = 1;
  public static final int PLAY_TYPE_UNKNOWN = -1;
  public static final int PLAY_TYPE_VOD = 0;
  public static final String PROP_KEY_DATA = "data";
  private static final String TAG = "TPReportParams";
  public static final int VIDEO_DL_TYPE_HLS = 3;
  public static final int VIDEO_DL_TYPE_MP4 = 1;
  private TPReportParams.BufferingTotalParams bufferingTotalParams = new TPReportParams.BufferingTotalParams(this);
  private TPReportParams.CommonParams commonParams = new TPReportParams.CommonParams(this);
  private TPReportParams.FirstLoadParams firstLoadParams = new TPReportParams.FirstLoadParams(this);
  private TPReportParams.FirstRenderParams firstRenderParams = new TPReportParams.FirstRenderParams(this);
  private TPReportParams.GetCdnUrlParams getCdnParams = new TPReportParams.GetCdnUrlParams(this);
  private TPReportParams.PlayerInitParams initParams = new TPReportParams.PlayerInitParams(this);
  private TPReportParams.LiveExParam liveExParam = new TPReportParams.LiveExParam(this);
  private TPReportParams.LoadSubtitleParams loadSubtitleParams = new TPReportParams.LoadSubtitleParams(this);
  private TPReportParams.PlayDoneParams playDoneParams = new TPReportParams.PlayDoneParams(this);
  private TPReportParams.RedirectParams redirectParams = new TPReportParams.RedirectParams(this);
  private TPReportParams.UserSeekTotalParams userSeekTotalParams = new TPReportParams.UserSeekTotalParams(this);
  private TPReportParams.VodExParam vodExParam = new TPReportParams.VodExParam(this);
  
  public TPReportParams()
  {
    this.commonParams.reset();
    this.initParams.reset();
    this.getCdnParams.reset();
    this.firstLoadParams.reset();
    this.firstRenderParams.reset();
    this.loadSubtitleParams.reset();
    this.redirectParams.reset();
    this.bufferingTotalParams.reset();
    this.userSeekTotalParams.reset();
    this.playDoneParams.reset();
  }
  
  public TPReportParams.BufferingOnceParams createBufferingOnceParams()
  {
    return new TPReportParams.BufferingOnceParams(this);
  }
  
  public TPReportParams.UserSeekOnceParams createUserSeekOnceParams()
  {
    return new TPReportParams.UserSeekOnceParams(this);
  }
  
  public TPReportParams.BufferingTotalParams getBufferingTotalParams()
  {
    return this.bufferingTotalParams;
  }
  
  public TPReportParams.CommonParams getCommonParams()
  {
    return this.commonParams;
  }
  
  public TPReportParams.FirstLoadParams getFirstLoadParams()
  {
    return this.firstLoadParams;
  }
  
  public TPReportParams.FirstRenderParams getFirstRenderParams()
  {
    return this.firstRenderParams;
  }
  
  public TPReportParams.GetCdnUrlParams getGetCdnParams()
  {
    return this.getCdnParams;
  }
  
  public TPReportParams.PlayerInitParams getInitParams()
  {
    return this.initParams;
  }
  
  public TPReportParams.LiveExParam getLiveExParam()
  {
    return this.liveExParam;
  }
  
  public TPReportParams.LoadSubtitleParams getLoadSubtitleParams()
  {
    return this.loadSubtitleParams;
  }
  
  public TPReportParams.PlayDoneParams getPlayDoneParams()
  {
    return this.playDoneParams;
  }
  
  public TPReportParams.RedirectParams getRedirectParams()
  {
    return this.redirectParams;
  }
  
  public TPReportParams.UserSeekTotalParams getUserSeekTotalParams()
  {
    return this.userSeekTotalParams;
  }
  
  public TPReportParams.VodExParam getVodExParam()
  {
    return this.vodExParam;
  }
  
  public void resetAllParam()
  {
    this.commonParams.reset();
    this.initParams.reset();
    this.firstLoadParams.reset();
    this.firstRenderParams.reset();
    this.loadSubtitleParams.reset();
    this.getCdnParams.reset();
    this.redirectParams.reset();
    this.bufferingTotalParams.reset();
    this.userSeekTotalParams.reset();
    this.playDoneParams.reset();
    this.liveExParam.reset();
    this.vodExParam.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportParams
 * JD-Core Version:    0.7.0.1
 */