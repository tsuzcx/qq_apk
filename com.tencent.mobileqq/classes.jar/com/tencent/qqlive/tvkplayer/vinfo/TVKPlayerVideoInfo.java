package com.tencent.qqlive.tvkplayer.vinfo;

import android.text.TextUtils;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class TVKPlayerVideoInfo
  implements Serializable
{
  public static final String PLAYER_CFG_KEY_ACCURATE_START_POS = "accurate_start_pos";
  public static final String PLAYER_CFG_KEY_AD_CLOSE = "ad_close";
  public static final String PLAYER_CFG_KEY_AUDIO_FRAME_OUTPUT = "audio_frame_output";
  public static final String PLAYER_CFG_KEY_DECREASE_DEF = "decrease_def";
  public static final String PLAYER_CFG_KEY_DOLBYAUDIO_TRACK = "track";
  public static final String PLAYER_CFG_KEY_DRM = "vinfo_key_drm";
  public static final String PLAYER_CFG_KEY_ENCODE_FORCETYPE = "encode_forcetype";
  public static final String PLAYER_CFG_KEY_ENTER_DETAIL_PAGE_TIMESTAMP = "enter_detail_page_timestamp";
  public static final String PLAYER_CFG_KEY_ENTER_MIN_BUFFER_MODE = "min_buffer_mode";
  public static final String PLAYER_CFG_KEY_ENTER_SYSPLAYER_HEVC_CAP = "sysplayer_hevc_cap";
  public static final String PLAYER_CFG_KEY_FILE_TYPE = "file_type";
  public static final String PLAYER_CFG_KEY_FROM_PLATFORM = "vinfo_key_from_platform";
  public static final String PLAYER_CFG_KEY_HISTORY_VID = "historyVid";
  public static final String PLAYER_CFG_KEY_ISFORCEONLINE = "isForceOnline";
  public static final String PLAYER_CFG_KEY_KEEP_LAST_FRAME = "keep_last_frame";
  public static final String PLAYER_CFG_KEY_LIVE_PLAYBACKTIME = "live_playbacktime";
  public static final String PLAYER_CFG_KEY_LIVE_TYPE = "live_type";
  public static final String PLAYER_CFG_KEY_NEXT_CID = "next_cid";
  public static final String PLAYER_CFG_KEY_NEXT_VID = "next_vid";
  public static final String PLAYER_CFG_KEY_PAYTYPE = "paytype";
  public static final String PLAYER_CFG_KEY_PLAYER_FORCETYPE = "player_forcetype";
  public static final String PLAYER_CFG_KEY_PLAYMODE = "playmode";
  public static final String PLAYER_CFG_KEY_PLAY_WINDOW = "play_window";
  public static final String PLAYER_CFG_KEY_PREVID = "vinfo_key_previd";
  public static final String PLAYER_CFG_KEY_SKIP_START_END = "skip_start_end";
  public static final String PLAYER_CFG_KEY_SPAUDIO = "vinfo_key_spaudio";
  public static final String PLAYER_CFG_KEY_SPTEST = "vinfo_key_sptest";
  public static final String PLAYER_CFG_KEY_SPVIDEO = "vinfo_key_spvideo";
  public static final String PLAYER_CFG_KEY_SWITCH_PLAYER = "switch_player";
  public static final String PLAYER_CFG_KEY_TOUSHE = "vinfo_key_toushe";
  public static final String PLAYER_CFG_KEY_USECACHEFLAG = "usecacheflag";
  public static final String PLAYER_CFG_KEY_VIDEO_FRAME_OUTPUT = "video_frame_output";
  public static final String PLAYER_CFG_KEY_VR_VIDEO = "vr_video";
  public static final String PLAYER_CFG_LEY_FLOWID = "flowid";
  public static final String PLAYER_REQ_KEY_DEFN_SRC = "defnsrc";
  public static final String PLAYER_REQ_KEY_LIVEQUEUE = "livequeue";
  public static final String PLAYER_REQ_KEY_LIVE_PID = "livepid";
  public static final String PLAYER_REQ_KEY_MECHINE_ID = "viewid";
  public static final String PLAYER_REQ_KEY_PAGE_ID = "pageId";
  public static final String PLAYER_REQ_KEY_PREVID = "previd";
  public static final String PLAYER_REQ_KEY_PRIVATE_DATA = "extra_data";
  public static final String PLAYER_REQ_KEY_REFER_PAGE_ID = "refer_pageId";
  public static final String PLAYER_REQ_KEY_WAITSECRETKEY = "waitSecretKey";
  public static final String PLAYER_REQ_SCENE_INFORMATION = "scene";
  public static final String PLAYER_SELF_ADAPTIVE_ID = "self_adaptive";
  public static final String PLAYER_SUBTITLE_LANGUANGE_ID = "subtitle_language";
  public static final String QUICK_SWITCH_SURFACE_VIEW = "quick_switch_surface_view";
  private static final long serialVersionUID = -374236133868823816L;
  private int bizId = 0;
  private transient Map<String, Object> mAdParamsMap;
  private Map<String, String> mAdReportInfoMap;
  private Map<String, String> mAdRequestParamMap;
  public int mBusiPlatform;
  private String mCid = "";
  private Map<String, String> mConfigMap;
  private transient WeakReference<Object> mExtraObject;
  private Map<String, String> mExtraRequestParamsMap;
  private boolean mIsNeedCharge = false;
  private int mPlayType = 5;
  private Map<String, String> mProxyExtraMap;
  private Map<String, String> mReportInfoMap;
  private String mVid = "";
  private long mVideoDuration;
  private Map<Integer, Integer> mVideoEditParametersMap;
  private String sessionId;
  
  public TVKPlayerVideoInfo()
  {
    this.mVid = "";
    this.mCid = "";
    this.mPlayType = 5;
    initParam();
  }
  
  public TVKPlayerVideoInfo(int paramInt, String paramString1, String paramString2)
  {
    this.mPlayType = paramInt;
    this.mVid = paramString1;
    this.mCid = paramString2;
    initParam();
  }
  
  private void initParam()
  {
    this.mIsNeedCharge = false;
    this.mAdRequestParamMap = new HashMap();
    this.mExtraRequestParamsMap = new HashMap();
    this.mConfigMap = new HashMap();
    this.mReportInfoMap = new HashMap();
    this.mAdReportInfoMap = new HashMap();
    this.mProxyExtraMap = new HashMap();
  }
  
  public void addAdReportInfoMap(String paramString1, String paramString2)
  {
    this.mAdReportInfoMap.put(paramString1, paramString2);
  }
  
  public void addAdReportInfoMap(Map<String, String> paramMap)
  {
    this.mAdReportInfoMap.putAll(paramMap);
  }
  
  public void addAdRequestParamMap(String paramString1, String paramString2)
  {
    this.mAdRequestParamMap.put(paramString1, paramString2);
  }
  
  public void addAdRequestParamMap(Map<String, String> paramMap)
  {
    this.mAdRequestParamMap.putAll(paramMap);
  }
  
  public void addConfigMap(String paramString1, String paramString2)
  {
    this.mConfigMap.put(paramString1, paramString2);
  }
  
  public void addExtraRequestParamsMap(String paramString1, String paramString2)
  {
    this.mExtraRequestParamsMap.put(paramString1, paramString2);
  }
  
  public void addProxyExtraMap(String paramString1, String paramString2)
  {
    this.mProxyExtraMap.put(paramString1, paramString2);
  }
  
  public void addReportInfoMap(String paramString1, String paramString2)
  {
    this.mReportInfoMap.put(paramString1, paramString2);
  }
  
  public void addReportInfoMap(Map<String, String> paramMap)
  {
    this.mReportInfoMap.putAll(paramMap);
  }
  
  public boolean configMapContainsKey(String paramString)
  {
    return this.mConfigMap.containsKey(paramString);
  }
  
  public Map<String, Object> getAdParamsMap()
  {
    return this.mAdParamsMap;
  }
  
  public Map<String, String> getAdReportInfoMap()
  {
    return this.mAdReportInfoMap;
  }
  
  public String getAdReportInfoValue(String paramString1, String paramString2)
  {
    paramString1 = (String)this.mAdReportInfoMap.get(paramString1);
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public Map<String, String> getAdRequestParamMap()
  {
    return this.mAdRequestParamMap;
  }
  
  public int getBizId()
  {
    return this.bizId;
  }
  
  public String getCid()
  {
    return this.mCid;
  }
  
  public Map<String, String> getConfigMap()
  {
    return this.mConfigMap;
  }
  
  public String getConfigMapValue(String paramString1, String paramString2)
  {
    paramString1 = (String)this.mConfigMap.get(paramString1);
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public Object getExtraObject()
  {
    if (this.mExtraObject != null) {
      return this.mExtraObject.get();
    }
    return null;
  }
  
  public String getExtraRequestParamValue(String paramString1, String paramString2)
  {
    paramString1 = (String)this.mExtraRequestParamsMap.get(paramString1);
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public Map<String, String> getExtraRequestParamsMap()
  {
    return this.mExtraRequestParamsMap;
  }
  
  public int getPlatform()
  {
    return this.mBusiPlatform;
  }
  
  public int getPlayType()
  {
    return this.mPlayType;
  }
  
  public Map<String, String> getProxyExtraMap()
  {
    return this.mProxyExtraMap;
  }
  
  public Map<String, String> getReportInfoMap()
  {
    return this.mReportInfoMap;
  }
  
  public String getReportInfoValue(String paramString1, String paramString2)
  {
    paramString1 = (String)this.mReportInfoMap.get(paramString1);
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public String getVid()
  {
    return this.mVid;
  }
  
  public long getVideoDuration()
  {
    return this.mVideoDuration;
  }
  
  public Map<Integer, Integer> getVideoEditParametersMap()
  {
    return this.mVideoEditParametersMap;
  }
  
  public boolean isNeedCharge()
  {
    return this.mIsNeedCharge;
  }
  
  public void removeAdReportInfoMap(String paramString)
  {
    this.mAdReportInfoMap.remove(paramString);
  }
  
  public void removeConfigMap(String paramString)
  {
    this.mConfigMap.remove(paramString);
  }
  
  public void removeProxyExtraMap(String paramString)
  {
    this.mProxyExtraMap.remove(paramString);
  }
  
  public void removeReportInfoMap(String paramString)
  {
    this.mReportInfoMap.remove(paramString);
  }
  
  public void setAdParamsMap(Map<String, Object> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    this.mAdParamsMap = ((Map)localObject);
  }
  
  public void setBizId(int paramInt)
  {
    this.bizId = paramInt;
  }
  
  public void setCid(String paramString)
  {
    this.mCid = paramString;
  }
  
  public void setExtraObject(Object paramObject)
  {
    this.mExtraObject = null;
    if (paramObject != null) {
      this.mExtraObject = new WeakReference(paramObject);
    }
  }
  
  public void setNeedCharge(boolean paramBoolean)
  {
    this.mIsNeedCharge = paramBoolean;
  }
  
  public void setPid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (this.mPlayType == 1) {
        this.mExtraRequestParamsMap.put("livepid", paramString);
      }
    } while (this.mPlayType != 1);
    this.mAdRequestParamMap.put("livepid", paramString);
  }
  
  public void setPlatform(int paramInt)
  {
    this.mBusiPlatform = paramInt;
  }
  
  public void setPlayType(int paramInt)
  {
    this.mPlayType = paramInt;
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public void setVid(String paramString)
  {
    this.mVid = paramString;
  }
  
  public void setVideoDuration(long paramLong)
  {
    this.mVideoDuration = paramLong;
  }
  
  public void setVideoEditParametersMap(Map<Integer, Integer> paramMap)
  {
    this.mVideoEditParametersMap = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerVideoInfo
 * JD-Core Version:    0.7.0.1
 */