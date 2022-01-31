package com.tencent.qqlive.tvkplayer.vinfo;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter.OnGetLiveInfoListener;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter.ITVKVodInfoGetterCallback;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVodInfoGetter;
import java.util.Map;

public class TVKUrlGetter
  implements ITVKUrlGetter
{
  private static final String TAG = "MediaPlayerMgr[TVKUrlGetter.java]";
  private ITVKUrlGetter.OnGetUrlListener mListener;
  private ITVKLiveInfoGetter.OnGetLiveInfoListener mLiveInfoListener = new TVKUrlGetter.2(this);
  private ITVKVodInfoGetter.ITVKVodInfoGetterCallback mVodInfoListener = new TVKUrlGetter.1(this);
  
  private boolean isValidForInputParams(Context paramContext, TVKPlayerVideoInfo paramTVKPlayerVideoInfo)
  {
    if (paramContext == null) {}
    while (paramTVKPlayerVideoInfo == null) {
      return false;
    }
    if (((TextUtils.isEmpty(paramTVKPlayerVideoInfo.getVid())) && (TextUtils.isEmpty(paramTVKPlayerVideoInfo.getConfigMapValue("vinfo_key_previd", "")))) || (paramTVKPlayerVideoInfo.getPlayType() < 1) || (paramTVKPlayerVideoInfo.getPlayType() > 8))
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKUrlGetter.java]", "isValidForInParam , vid is empty or type wrong,vid: " + paramTVKPlayerVideoInfo.getVid() + ", previd: " + paramTVKPlayerVideoInfo.getConfigMapValue("vinfo_key_previd", "") + ",type: " + paramTVKPlayerVideoInfo.getPlayType());
      return false;
    }
    return true;
  }
  
  public int getDlnaUrl(Context paramContext, TVKUserInfo paramTVKUserInfo, TVKPlayerVideoInfo paramTVKPlayerVideoInfo, String paramString, int paramInt)
  {
    if (!isValidForInputParams(paramContext, paramTVKPlayerVideoInfo))
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKUrlGetter.java]", "getDlnaUrl fail, because param is invalid!");
      throw new IllegalArgumentException("param invalid");
    }
    if (TextUtils.isEmpty(paramTVKPlayerVideoInfo.getCid())) {
      paramTVKPlayerVideoInfo.setCid(paramTVKPlayerVideoInfo.getVid());
    }
    TVKLogUtil.i("MediaPlayerMgr[TVKUrlGetter.java]", "getDlnaUrl, vid: " + paramTVKPlayerVideoInfo.getVid() + " lastDef: " + paramString);
    if (1 == paramTVKPlayerVideoInfo.getPlayType())
    {
      paramContext = TVKLiveInfoGetter.create(paramContext);
      paramContext.setOnGetLiveInfoListener(this.mLiveInfoListener);
      return paramContext.getDlnaUrl(paramTVKUserInfo, paramTVKPlayerVideoInfo.getVid(), paramString, paramTVKPlayerVideoInfo.getExtraRequestParamsMap());
    }
    paramContext = new TVKVodInfoGetter(paramContext);
    paramContext.setOnInfoGetListener(this.mVodInfoListener);
    return paramContext.getDlnaUrl(paramTVKUserInfo, paramTVKPlayerVideoInfo, paramString, paramInt);
  }
  
  public int getPlayInfo(Context paramContext, TVKUserInfo paramTVKUserInfo, TVKPlayerVideoInfo paramTVKPlayerVideoInfo, String paramString, int paramInt)
  {
    if (!isValidForInputParams(paramContext, paramTVKPlayerVideoInfo))
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKUrlGetter.java]", "getPlayInfo fail, because param is invalid!");
      throw new IllegalArgumentException("param invalid");
    }
    if (TextUtils.isEmpty(paramTVKPlayerVideoInfo.getCid())) {
      paramTVKPlayerVideoInfo.setCid(paramTVKPlayerVideoInfo.getVid());
    }
    TVKLogUtil.i("MediaPlayerMgr[TVKUrlGetter.java]", "getPlayInfo,vid:" + paramTVKPlayerVideoInfo.getVid() + ":lastDef:" + paramString);
    if (1 == paramTVKPlayerVideoInfo.getPlayType())
    {
      paramContext = TVKLiveInfoGetter.create(paramContext);
      paramContext.setOnGetLiveInfoListener(this.mLiveInfoListener);
      return paramContext.getDlnaUrl(paramTVKUserInfo, paramTVKPlayerVideoInfo.getVid(), paramString, paramTVKPlayerVideoInfo.getExtraRequestParamsMap());
    }
    paramContext = new TVKVodInfoGetter(paramContext);
    paramContext.setOnInfoGetListener(this.mVodInfoListener);
    return paramContext.getPlayInfo(paramTVKUserInfo, paramTVKPlayerVideoInfo, paramString, paramInt, 0);
  }
  
  public int inquireLiveInfo(Context paramContext, TVKUserInfo paramTVKUserInfo, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    TVKLogUtil.i("MediaPlayerMgr[TVKUrlGetter.java]", "inquireLiveInfo,progID:" + paramString1 + ":definition:" + paramString2);
    paramContext = TVKLiveInfoGetter.create(paramContext);
    paramContext.setOnGetLiveInfoListener(this.mLiveInfoListener);
    return paramContext.inquireInfo(paramTVKUserInfo, paramString1, paramString2, paramMap);
  }
  
  public void setOnGetUrlListener(ITVKUrlGetter.OnGetUrlListener paramOnGetUrlListener)
  {
    this.mListener = paramOnGetUrlListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKUrlGetter
 * JD-Core Version:    0.7.0.1
 */