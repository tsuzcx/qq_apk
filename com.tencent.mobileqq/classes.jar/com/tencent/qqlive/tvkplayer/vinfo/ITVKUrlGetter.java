package com.tencent.qqlive.tvkplayer.vinfo;

import android.content.Context;
import java.util.Map;

public abstract interface ITVKUrlGetter
{
  public static final int AV_FORMAT_AUTO = 0;
  public static final int AV_FORMAT_LIVE_FLV = 1;
  public static final int AV_FORMAT_LIVE_HLS = 2;
  public static final int AV_FORMAT_VOD_5_MIN = 4;
  public static final int AV_FORMAT_VOD_HLS = 3;
  public static final int AV_FORMAT_VOD_WHOLE_MP4 = 1;
  public static final int FREE_PAY = 0;
  public static final int Free_PAYED = 0;
  public static final int HAS_PAYED = 1;
  public static final int KKLiveMediaPlayCKeyError = 32;
  public static final int KKLiveMediaPlayErrorAuthFailedInPay = 23;
  public static final int KKLiveMediaPlayErrorLoginInfoVerifyFailed = 28;
  public static final int KKLiveMediaPlayErrorLostLoginInfo = 25;
  public static final int KKLiveMediaPlayErrorNoLogin = 31;
  public static final int KKLiveMediaPlayErrorNoPay = 30;
  public static final int KKLiveMediaPlayErrorTryLookCalculateFailed = 47;
  public static final int KKLiveMediaPlayErrorTryWatchChanceUsed = 45;
  public static final int KKLiveMediaPlayErrorWeiXinVerifyFailed = 48;
  public static final int NEED_PAY = 1;
  public static final int UNLOGIN = -1;
  
  public abstract int getDlnaUrl(Context paramContext, TVKUserInfo paramTVKUserInfo, TVKPlayerVideoInfo paramTVKPlayerVideoInfo, String paramString, int paramInt);
  
  public abstract int getPlayInfo(Context paramContext, TVKUserInfo paramTVKUserInfo, TVKPlayerVideoInfo paramTVKPlayerVideoInfo, String paramString, int paramInt);
  
  public abstract int inquireLiveInfo(Context paramContext, TVKUserInfo paramTVKUserInfo, String paramString1, String paramString2, Map<String, String> paramMap);
  
  public abstract void setOnGetUrlListener(ITVKUrlGetter.OnGetUrlListener paramOnGetUrlListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ITVKUrlGetter
 * JD-Core Version:    0.7.0.1
 */