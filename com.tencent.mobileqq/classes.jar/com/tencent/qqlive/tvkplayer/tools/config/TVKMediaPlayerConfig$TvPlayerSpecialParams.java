package com.tencent.qqlive.tvkplayer.tools.config;

public class TVKMediaPlayerConfig$TvPlayerSpecialParams
{
  public static TVKConfigField<Boolean> buffer_report_compact_enable;
  public static TVKConfigField<Integer> buffer_timeout_1080;
  public static TVKConfigField<Integer> buffer_timeout_1080_below;
  public static TVKConfigField<Integer> captureMode;
  public static TVKConfigField<Boolean> cgi_in_uithread;
  public static TVKConfigField<String> dolby_player = new TVKConfigField("system");
  public static TVKConfigField<String> dolby_track_player;
  public static TVKConfigField<Boolean> early_push_enable;
  public static TVKConfigField<Integer> encrypt_ver;
  public static TVKConfigField<String> hevc_player;
  public static TVKConfigField<Boolean> hevc_to_h264_to_sd;
  public static TVKConfigField<Boolean> is_allow_decreases_definition;
  public static TVKConfigField<Boolean> is_allow_preload_postrollad;
  public static TVKConfigField<Boolean> is_allow_preload_video;
  public static TVKConfigField<Boolean> is_allow_switch_2_soft_in_ffmpeg;
  public static TVKConfigField<Boolean> is_allow_switch_2_soft_in_mgr;
  public static TVKConfigField<Boolean> is_only_audio_support;
  public static TVKConfigField<Boolean> is_use_cgi_cache_for_vod;
  public static TVKConfigField<Boolean> is_use_hevc;
  public static TVKConfigField<Boolean> is_use_logo;
  public static TVKConfigField<Boolean> is_use_new_def_switch;
  public static TVKConfigField<String> live_dolby_player = new TVKConfigField("self");
  public static TVKConfigField<String> live_hevc_player;
  public static TVKConfigField<String> live_player;
  public static TVKConfigField<Boolean> live_use_proxy;
  public static TVKConfigField<Integer> mediacodec_inputbuffer_timeout;
  public static TVKConfigField<Integer> mediacodec_outputbuffer_timeout;
  public static TVKConfigField<Boolean> reset_decoder_on_def_switch;
  public static TVKConfigField<Boolean> reset_del_view;
  public static TVKConfigField<Boolean> secondbuffer_check_compact_enable;
  public static TVKConfigField<Boolean> secondbuffer_check_network_enable;
  public static TVKConfigField<Boolean> selfplayer_prepared_timeout_enable;
  public static TVKConfigField<Boolean> set_display_mul_times_surfaceCreate;
  public static TVKConfigField<Boolean> use_proxy;
  public static TVKConfigField<String> vod_fmt = new TVKConfigField("hls");
  public static TVKConfigField<String> vod_player;
  
  static
  {
    live_player = new TVKConfigField("system");
    vod_player = new TVKConfigField("system");
    hevc_player = new TVKConfigField("auto");
    live_hevc_player = new TVKConfigField("auto");
    encrypt_ver = new TVKConfigField(Integer.valueOf(65));
    is_allow_preload_video = new TVKConfigField(Boolean.valueOf(false));
    is_allow_preload_postrollad = new TVKConfigField(Boolean.valueOf(false));
    is_allow_decreases_definition = new TVKConfigField(Boolean.valueOf(true));
    is_use_cgi_cache_for_vod = new TVKConfigField(Boolean.valueOf(false));
    is_allow_switch_2_soft_in_ffmpeg = new TVKConfigField(Boolean.valueOf(false));
    is_allow_switch_2_soft_in_mgr = new TVKConfigField(Boolean.valueOf(true));
    is_use_hevc = new TVKConfigField(Boolean.valueOf(true));
    captureMode = new TVKConfigField(Integer.valueOf(2));
    buffer_timeout_1080 = new TVKConfigField(Integer.valueOf(50000));
    buffer_timeout_1080_below = new TVKConfigField(Integer.valueOf(35000));
    use_proxy = new TVKConfigField(Boolean.valueOf(true));
    live_use_proxy = new TVKConfigField(Boolean.valueOf(true));
    mediacodec_inputbuffer_timeout = new TVKConfigField(Integer.valueOf(20));
    mediacodec_outputbuffer_timeout = new TVKConfigField(Integer.valueOf(20));
    is_use_new_def_switch = new TVKConfigField(Boolean.valueOf(false));
    reset_decoder_on_def_switch = new TVKConfigField(Boolean.valueOf(true));
    is_use_logo = new TVKConfigField(Boolean.valueOf(false));
    is_only_audio_support = new TVKConfigField(Boolean.valueOf(false));
    set_display_mul_times_surfaceCreate = new TVKConfigField(Boolean.valueOf(false));
    reset_del_view = new TVKConfigField(Boolean.valueOf(true));
    cgi_in_uithread = new TVKConfigField(Boolean.valueOf(false));
    dolby_track_player = new TVKConfigField("system");
    selfplayer_prepared_timeout_enable = new TVKConfigField(Boolean.valueOf(true));
    secondbuffer_check_compact_enable = new TVKConfigField(Boolean.valueOf(true));
    early_push_enable = new TVKConfigField(Boolean.valueOf(true));
    buffer_report_compact_enable = new TVKConfigField(Boolean.valueOf(true));
    secondbuffer_check_network_enable = new TVKConfigField(Boolean.valueOf(true));
    hevc_to_h264_to_sd = new TVKConfigField(Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig.TvPlayerSpecialParams
 * JD-Core Version:    0.7.0.1
 */