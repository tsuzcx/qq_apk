package com.tencent.qqlive.tvkplayer.tools.config;

public class TVKConfigUrl
{
  private static final String CHECK_TIME_BK_SERVER = "http://bkvv.video.qq.com/checktime";
  private static final String CHECK_TIME_SERVER = "http://vv.video.qq.com/checktime";
  private static final String DEFAULT_AD_CONFIG_SERVER = "http://commdata.v.qq.com/commdatav2";
  private static final String DEFAULT_INFO_ZB_BK_SERVER = "http://bk.info.zb.qq.com/";
  private static final String DEFAULT_INFO_ZB_SERVER = "http://info.zb.qq.com/";
  private static final String DEFAULT_SDK_CONFIG_SERVER = "https://sdksp.video.qq.com/getmfomat";
  private static final String DEFAULT_SDK_CONFIG_SERVER_QQLIVE = "https://sdkconfig.video.qq.com/getmfomat";
  private static final String LicenceHostFileName = "LicenceHost.json";
  private static final String OPEN_VINFO_SERVER = "https://graph.qq.com/v3/video/get_v_info";
  private static final String OPEN_VKEY_SERVER = "https://graph.qq.com/v3/video/get_v_key";
  private static final String TAG = "MediaPlayerMgr[TVKConfigUrl.java]";
  private static final String VBKEY_BK_SERVER = "http://bkvv.video.qq.com/getvbkey";
  private static final String VBKEY_IPV6_SERVER = "http://vv6.video.qq.com/getvbkey";
  private static final String VBKEY_SERVER = "http://vv.video.qq.com/getvbkey";
  private static final String VINFO_BK_HOST = "bkvv.video.qq.com";
  private static final String VINFO_BK_SERVER = "http://bkvv.video.qq.com/getvinfo";
  private static final String VINFO_HOST = "vv.video.qq.com";
  private static final String VINFO_IPV6_HOST = "vv6.video.qq.com";
  private static final String VINFO_IPV6_SERVER = "http://vv6.video.qq.com/getvinfo";
  private static final String VINFO_SERVER = "http://vv.video.qq.com/getvinfo";
  private static final String VKEY_BK_SERVER = "http://bkvv.video.qq.com/getvkey";
  private static final String VKEY_SERVER = "http://vv.video.qq.com/getvkey";
  public static String ad_config_cgi_host;
  public static String licence_host_config = "";
  public static String open_vinfo_cgi_host;
  public static String open_vkey_cgi_host;
  public static String sdk_config_cgi_host;
  public static String sdk_config_cgi_host_qqlive;
  public static String time_cgi_host;
  public static String time_cgi_host_bk;
  public static String vbkey_cgi_host;
  public static String vbkey_cgi_host_bk;
  public static String vbkey_ipv6_cgi_host;
  public static String vinfo_bk_host;
  public static String vinfo_cgi_host = "http://vv.video.qq.com/getvinfo";
  public static String vinfo_cgi_host_bk = "http://bkvv.video.qq.com/getvinfo";
  public static String vinfo_cgi_ipv6_host = "http://vv6.video.qq.com/getvinfo";
  public static String vinfo_host = "vv.video.qq.com";
  public static String vinfo_ipv6_host;
  public static String vkey_cgi_host;
  public static String vkey_cgi_host_bk;
  public static String zb_cgi_host;
  public static String zb_cgi_host_bk;
  
  static
  {
    vinfo_bk_host = "bkvv.video.qq.com";
    vinfo_ipv6_host = "vv6.video.qq.com";
    vkey_cgi_host = "http://vv.video.qq.com/getvkey";
    vkey_cgi_host_bk = "http://bkvv.video.qq.com/getvkey";
    time_cgi_host = "http://vv.video.qq.com/checktime";
    time_cgi_host_bk = "http://bkvv.video.qq.com/checktime";
    open_vinfo_cgi_host = "https://graph.qq.com/v3/video/get_v_info";
    open_vkey_cgi_host = "https://graph.qq.com/v3/video/get_v_key";
    ad_config_cgi_host = "http://commdata.v.qq.com/commdatav2";
    sdk_config_cgi_host = "https://sdksp.video.qq.com/getmfomat";
    sdk_config_cgi_host_qqlive = "https://sdkconfig.video.qq.com/getmfomat";
    vbkey_cgi_host = "http://vv.video.qq.com/getvbkey";
    vbkey_cgi_host_bk = "http://bkvv.video.qq.com/getvbkey";
    vbkey_ipv6_cgi_host = "http://vv6.video.qq.com/getvbkey";
    zb_cgi_host = "http://info.zb.qq.com/";
    zb_cgi_host_bk = "http://bk.info.zb.qq.com/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.config.TVKConfigUrl
 * JD-Core Version:    0.7.0.1
 */