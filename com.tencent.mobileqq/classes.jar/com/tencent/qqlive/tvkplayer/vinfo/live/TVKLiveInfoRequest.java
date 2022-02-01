package com.tencent.qqlive.tvkplayer.vinfo.live;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.TVideoMgr;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigField;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigUrl;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig.PlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig.PreFetchedParams;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKDefinitionUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKHttpProcessorFactory;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.qqlive.tvkplayer.tools.utils.UriBuilder;
import com.tencent.qqlive.tvkplayer.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKNetVideoInfo.DefnInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TVKLiveInfoRequest
{
  private static final int DEFAULT_ERR85_RETRY_COUNT = 3;
  private static final int DEFAULT_RETRY_COUNT = 3;
  private static final String ENCRYPT_VER_4 = "4.1";
  private static final String ENCRYPT_VER_4_2 = "4.2";
  private static final String ENCRYPT_VER_5 = "5.1";
  public static final String TAG = "MediaPlayerMgr[TVKLiveInfoRequest.java]";
  public static final int URL_STATE_MASTER_URL = 1;
  public static final int URL_STATE_RESERVER_URL = 2;
  private static long mLastLocalTime = 0L;
  private static long mLastServerTime = 0L;
  private static final String mLiveFd = "dcmg";
  private int m85RetryCount = 0;
  private String mCKey;
  private TVKLiveInfoCallback mCallback = null;
  private String mDefinition = "";
  private TVKLiveInfoParams mLiveInfoParams;
  private int mPlayerID;
  private String mProgramId = "";
  private String mRequestUrl;
  private int mRetryCount;
  @TVKLiveInfoRequest.UrlState
  private int mUrlState;
  private TVKUserInfo mUserInfo;
  
  protected TVKLiveInfoRequest(int paramInt, TVKUserInfo paramTVKUserInfo, String paramString1, String paramString2, TVKLiveInfoCallback paramTVKLiveInfoCallback, TVKLiveInfoParams paramTVKLiveInfoParams)
  {
    if (paramTVKLiveInfoCallback != null)
    {
      if (paramString1 != null)
      {
        paramString1 = paramString1.trim();
        if (paramString1.length() != 0)
        {
          this.mUserInfo = paramTVKUserInfo;
          this.mProgramId = paramString1;
          this.mDefinition = paramString2;
          this.mCallback = paramTVKLiveInfoCallback;
          this.mPlayerID = paramInt;
          this.mLiveInfoParams = paramTVKLiveInfoParams;
          return;
        }
        throw new NullPointerException("progId is blank");
      }
      throw new NullPointerException("progId is null");
    }
    throw new NullPointerException("callback is null");
  }
  
  private String chooseUrlByUrlKey(@TVKLiveInfoRequest.UrlState int paramInt)
  {
    if (1 == paramInt) {
      return TVKConfigUrl.zb_cgi_host;
    }
    if (2 == paramInt) {
      return TVKConfigUrl.zb_cgi_host_bk;
    }
    return TVKConfigUrl.zb_cgi_host;
  }
  
  private String getCkey(int paramInt, String paramString)
  {
    Object localObject1 = this.mLiveInfoParams;
    if ((localObject1 != null) && (((TVKLiveInfoParams)localObject1).isGetDlnaUrl()))
    {
      localObject1 = new int[1];
      localObject1[0] = 1;
      return CKeyFacade.getCKey(TVideoMgr.getStaGuid(), TVKMediaPlayerConfig.PreFetchedParams.sServerTime, this.mProgramId, TVideoMgr.getPlayerVersion(), String.valueOf(paramInt), paramString, (int[])localObject1, localObject1.length, "");
    }
    localObject1 = new int[3];
    Object tmp56_55 = localObject1;
    tmp56_55[0] = 0;
    Object tmp60_56 = tmp56_55;
    tmp60_56[1] = 0;
    Object tmp64_60 = tmp60_56;
    tmp64_60[2] = 0;
    tmp64_60;
    Object localObject2 = this.mLiveInfoParams;
    if ((localObject2 != null) && (((TVKLiveInfoParams)localObject2).getExtraPara() != null) && (this.mLiveInfoParams.getExtraPara().containsKey("toushe")) && (this.mLiveInfoParams.getExtraPara().containsKey("from_platform")))
    {
      localObject2 = (String)this.mLiveInfoParams.getExtraPara().get("from_platform");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("toushe, from_platform =");
      localStringBuilder.append((String)localObject2);
      TVKLogUtil.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", localStringBuilder.toString());
      localObject1[0] = 16;
      localObject1[1] = TVKUtils.optInt((String)localObject2, paramInt);
    }
    else
    {
      localObject1[0] = 0;
      localObject1[1] = 0;
    }
    return CKeyFacade.getCKey(TVideoMgr.getStaGuid(), TVKMediaPlayerConfig.PreFetchedParams.sServerTime, this.mProgramId, TVideoMgr.getPlayerVersion(), String.valueOf(paramInt), paramString, (int[])localObject1, localObject1.length, "");
  }
  
  private Map<String, String> getHeaders()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("User-Agent", "qqlive");
    Object localObject = this.mUserInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((TVKUserInfo)localObject).getLoginCookie())))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cookie = ");
      ((StringBuilder)localObject).append(this.mUserInfo.getLoginCookie());
      TVKLogUtil.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", ((StringBuilder)localObject).toString());
      localHashMap.put("Cookie", this.mUserInfo.getLoginCookie());
      return localHashMap;
    }
    TVKLogUtil.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", "cookie is empty");
    return localHashMap;
  }
  
  private int getNetworkType()
  {
    if (TVKVcSystemInfo.isNetworkAvailable(TVideoMgr.getApplicationContext()))
    {
      if (TVKVcSystemInfo.getNetworkClass(TVideoMgr.getApplicationContext()) == 1) {
        return 1;
      }
      if (TVKVcSystemInfo.getNetworkClass(TVideoMgr.getApplicationContext()) == 2) {
        return 2;
      }
      if (TVKVcSystemInfo.getNetworkClass(TVideoMgr.getApplicationContext()) == 3) {}
      while (TVKVcSystemInfo.getNetworkClass(TVideoMgr.getApplicationContext()) != 4) {
        return 3;
      }
      return 4;
    }
    return 0;
  }
  
  private int getPlatform()
  {
    int j = TVideoMgr.getVinfoPlatform();
    TVKLiveInfoParams localTVKLiveInfoParams = this.mLiveInfoParams;
    int i = j;
    if (localTVKLiveInfoParams != null)
    {
      i = j;
      if (localTVKLiveInfoParams.getVideoInfo() != null) {
        i = this.mLiveInfoParams.getVideoInfo().getPlatform();
      }
    }
    return i;
  }
  
  private void innerParseJsonFormats(TVKLiveVideoInfo paramTVKLiveVideoInfo, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("formats");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        if (paramJSONObject.getJSONObject(i) != null)
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
          TVKNetVideoInfo.DefnInfo localDefnInfo = new TVKNetVideoInfo.DefnInfo();
          localDefnInfo.setDefn(localJSONObject.optString("fn"));
          localDefnInfo.setDefnShowName(localJSONObject.optString("fnname"));
          localDefnInfo.setVip(localJSONObject.optInt("vip"));
          localDefnInfo.setDefnId(localJSONObject.optInt("id"));
          localDefnInfo.setDefnName(localJSONObject.optString("defnname"));
          localDefnInfo.setDefnRate(localJSONObject.optString("defnrate"));
          if ((paramTVKLiveVideoInfo.getCurDefinition() != null) && (paramTVKLiveVideoInfo.getCurDefinition().getDefn() != null) && (paramTVKLiveVideoInfo.getCurDefinition().getDefn().equalsIgnoreCase(localDefnInfo.getDefn())))
          {
            paramTVKLiveVideoInfo.getCurDefinition().setDefnName(localDefnInfo.getDefnName());
            paramTVKLiveVideoInfo.getCurDefinition().setVip(localDefnInfo.isVip());
            paramTVKLiveVideoInfo.getCurDefinition().setDefnShowName(localDefnInfo.getDefnShowName());
            paramTVKLiveVideoInfo.getCurDefinition().setDefnRate(localDefnInfo.getDefnRate());
          }
          paramTVKLiveVideoInfo.addDefinition(localDefnInfo);
        }
        i += 1;
      }
    }
  }
  
  private void innerParseJsonLive360Info(TVKLiveVideoInfo paramTVKLiveVideoInfo, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("live360_info"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("live360_info");
      if ((paramJSONObject != null) && (paramJSONObject.has("lens_direction")))
      {
        int i = paramJSONObject.optInt("lens_direction");
        if (1 == i)
        {
          paramTVKLiveVideoInfo.setLensDirection(1);
          return;
        }
        if (2 == i) {
          paramTVKLiveVideoInfo.setLensDirection(2);
        }
      }
    }
  }
  
  private int optInt(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if (paramJSONObject.has(paramString)) {
      return paramJSONObject.optInt(paramString);
    }
    return paramInt;
  }
  
  private long optLong(JSONObject paramJSONObject, String paramString, long paramLong)
  {
    if (paramJSONObject.has(paramString)) {
      return paramJSONObject.optInt(paramString);
    }
    return paramLong;
  }
  
  private String optString(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (paramJSONObject.has(paramString1)) {
      return paramJSONObject.optString(paramString1);
    }
    return paramString2;
  }
  
  private TVKLiveVideoInfo parseJson(String paramString)
  {
    TVKLiveVideoInfo localTVKLiveVideoInfo = new TVKLiveVideoInfo();
    localTVKLiveVideoInfo.setXml(paramString);
    paramString = new JSONObject(paramString);
    int i = paramString.optInt("iretcode");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("errcode ");
    ((StringBuilder)localObject1).append(i);
    TVKLogUtil.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", ((StringBuilder)localObject1).toString());
    localTVKLiveVideoInfo.setRetCode(i);
    localTVKLiveVideoInfo.setErrtitle(optString(paramString, "errtitle", null));
    localTVKLiveVideoInfo.setSubErrType(optInt(paramString, "type", 0));
    if (paramString.has("playurl"))
    {
      localObject1 = paramString.optString("playurl");
      localTVKLiveVideoInfo.setPlayUrl((String)localObject1);
      localTVKLiveVideoInfo.setOriginalPlayUrl((String)localObject1);
    }
    localObject1 = this.mLiveInfoParams;
    if (localObject1 != null)
    {
      localTVKLiveVideoInfo.setGetDlnaUrl(((TVKLiveInfoParams)localObject1).isGetDlnaUrl());
      localTVKLiveVideoInfo.setGetPreviewInfo(this.mLiveInfoParams.getPreviewInfo());
    }
    localObject1 = paramString.optJSONArray("backurl_list");
    Object localObject2;
    if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
    {
      localObject2 = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2[i] = ((JSONArray)localObject1).getJSONObject(i).getString("url");
        i += 1;
      }
      localTVKLiveVideoInfo.setBackPlayUrl((String[])localObject2);
    }
    localTVKLiveVideoInfo.setCdnId(optInt(paramString, "cdnid", 0));
    localTVKLiveVideoInfo.setPlayTime(optInt(paramString, "playtime", 0));
    localTVKLiveVideoInfo.setStream(optInt(paramString, "stream", 0));
    localTVKLiveVideoInfo.setPrePlayTime(optInt(paramString, "totalplaytime", 0));
    localTVKLiveVideoInfo.setNeedPay(optInt(paramString, "ispay", 0));
    localTVKLiveVideoInfo.setPay(optInt(paramString, "isuserpay", 0));
    localTVKLiveVideoInfo.setPrePlayCountPerDay(optInt(paramString, "previewcnt", 0));
    localTVKLiveVideoInfo.setRestPrePlayCount(optInt(paramString, "restpreviewcnt", 0));
    localTVKLiveVideoInfo.setServerTime(optLong(paramString, "svrtick", 0L));
    localTVKLiveVideoInfo.setErrInfo(optString(paramString, "errinfo", null));
    localTVKLiveVideoInfo.setRand(optString(paramString, "rand", null));
    localTVKLiveVideoInfo.setBufferLoadingTime(optInt(paramString, "load", 0));
    localTVKLiveVideoInfo.setSecondBufferTime(optInt(paramString, "buffer", 0));
    localTVKLiveVideoInfo.setSecondMinBufferTime(optInt(paramString, "min", 0));
    localTVKLiveVideoInfo.setSecondMaxBufferTime(optInt(paramString, "max", 0));
    localTVKLiveVideoInfo.setTargetId(optString(paramString, "targetid", null));
    localTVKLiveVideoInfo.setDanmuState(optInt(paramString, "bullet_flag", 0));
    localTVKLiveVideoInfo.setQueueStatus(optInt(paramString, "queue_status", 0));
    localTVKLiveVideoInfo.setQueueRank(optInt(paramString, "queue_rank", 0));
    localTVKLiveVideoInfo.setQueueVipJump(optInt(paramString, "queue_vip_jump", 0));
    localTVKLiveVideoInfo.setQueueSessionKey(optString(paramString, "queue_session_key", null));
    localTVKLiveVideoInfo.setIretDetailCode(optInt(paramString, "iretdetailcode", 0));
    localTVKLiveVideoInfo.setLive360(optInt(paramString, "live360", 0));
    localTVKLiveVideoInfo.setAcode(optInt(paramString, "acode", 0));
    localTVKLiveVideoInfo.setVcode(optInt(paramString, "vcode", 0));
    i = paramString.optInt("acode");
    int j = paramString.optInt("vcode");
    if (j == 2) {
      localTVKLiveVideoInfo.setIsHevc(true);
    } else {
      localTVKLiveVideoInfo.setIsHevc(false);
    }
    if (paramString.has("defn"))
    {
      localObject1 = new TVKNetVideoInfo.DefnInfo();
      ((TVKNetVideoInfo.DefnInfo)localObject1).setVideoCodec(j);
      ((TVKNetVideoInfo.DefnInfo)localObject1).setAudioCodec(i);
      ((TVKNetVideoInfo.DefnInfo)localObject1).setDefn(paramString.optString("defn"));
      ((TVKNetVideoInfo.DefnInfo)localObject1).setDefnName(TVKDefinitionUtils.getDefShowName(paramString.optString("defn")));
      localTVKLiveVideoInfo.setCurDefinition((TVKNetVideoInfo.DefnInfo)localObject1);
    }
    if ((paramString.has("playback")) && (!TextUtils.isEmpty(paramString.getString("playback")))) {
      try
      {
        localObject1 = new JSONObject(paramString.getString("playback"));
        localTVKLiveVideoInfo.setPlayBackStart(((JSONObject)localObject1).optLong("playbackstart"));
        localTVKLiveVideoInfo.setPlayBackTime(((JSONObject)localObject1).optInt("playbacktime"));
        localTVKLiveVideoInfo.setSvrTick(((JSONObject)localObject1).optInt("svrtick"));
      }
      catch (JSONException localJSONException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parseJson error = ");
        ((StringBuilder)localObject2).append(localJSONException.toString());
        TVKLogUtil.e("MediaPlayerMgr[TVKLiveInfoRequest.java]", ((StringBuilder)localObject2).toString());
      }
    }
    innerParseJsonFormats(localTVKLiveVideoInfo, paramString);
    innerParseJsonLive360Info(localTVKLiveVideoInfo, paramString);
    localTVKLiveVideoInfo.setHlsp2p(paramString.optInt("hlsp2p"));
    return localTVKLiveVideoInfo;
  }
  
  private void setAudioFormat2Params(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    TVKLiveInfoParams localTVKLiveInfoParams = this.mLiveInfoParams;
    if ((localTVKLiveInfoParams != null) && (localTVKLiveInfoParams.isDolby()))
    {
      paramMap.put("audio_format", "2");
      return;
    }
    paramMap.put("audio_format", "1");
  }
  
  private void setEncryptVer2Params(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    if (65 == ((Integer)TVKMediaPlayerConfig.PlayerConfig.encrypt_ver.getValue()).intValue())
    {
      paramMap.put("encryptVer", "4.1");
      return;
    }
    if (66 == ((Integer)TVKMediaPlayerConfig.PlayerConfig.encrypt_ver.getValue()).intValue())
    {
      paramMap.put("encryptVer", "4.2");
      return;
    }
    paramMap.put("encryptVer", "5.1");
  }
  
  private void setLoginType2Params(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    if (this.mUserInfo.getLoginType() == 2)
    {
      paramMap.put("logintype", "1");
      return;
    }
    if (this.mUserInfo.getLoginType() == 3) {
      paramMap.put("logintype", "2");
    }
  }
  
  private void setVipStatus2Params(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    if (this.mUserInfo.isVip())
    {
      paramMap.put("vip_status", String.valueOf(1));
      return;
    }
    paramMap.put("vip_status", String.valueOf(0));
  }
  
  String[] dealBakUrl(String paramString1, String paramString2)
  {
    paramString2 = paramString2.split(";");
    int j = paramString1.indexOf("//");
    int i = 0;
    String str = paramString1.substring(0, j + 2);
    String[] arrayOfString = new String[paramString2.length];
    while (i < paramString2.length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramString2[i]);
      localStringBuilder.append(paramString1.substring(paramString1.lastIndexOf("/")));
      arrayOfString[i] = localStringBuilder.toString();
      i += 1;
    }
    return arrayOfString;
  }
  
  public void execute()
  {
    this.mRequestUrl = getRequestUrl(this.mUrlState);
    TVKHttpProcessorFactory.getInstance().getAsync(this.mRequestUrl, getHeaders(), 5000, new TVKLiveInfoRequest.1(this));
  }
  
  protected String getRequestUrl(@TVKLiveInfoRequest.UrlState int paramInt)
  {
    String str = chooseUrlByUrlKey(paramInt);
    if ((!TextUtils.isEmpty(TVideoMgr.mOriginalUpc)) && (TVideoMgr.mFreeNetFlowRequestMap != null) && (TVKVcSystemInfo.isNetworkTypeMobile(TVideoMgr.getApplicationContext())) && (!this.mLiveInfoParams.isGetDlnaUrl())) {
      localObject1 = TVideoMgr.mFreeNetFlowRequestMap;
    } else {
      localObject1 = new HashMap();
    }
    ((Map)localObject1).put("cnlid", this.mProgramId);
    ((Map)localObject1).put("cmd", "2");
    int i = getPlatform();
    Object localObject3 = TVideoMgr.getVinfoSdtfrom();
    TVKLiveInfoParams localTVKLiveInfoParams = this.mLiveInfoParams;
    Object localObject2 = localObject3;
    if (localTVKLiveInfoParams != null)
    {
      localObject2 = localObject3;
      if (localTVKLiveInfoParams.getVideoInfo() != null) {
        localObject2 = TVideoMgr.getVinfoSdtfrom(i);
      }
    }
    ((Map)localObject1).put("platform", String.valueOf(i));
    ((Map)localObject1).put("sdtfrom", localObject2);
    localObject3 = this.mLiveInfoParams;
    if (localObject3 == null) {
      paramInt = 2;
    } else {
      paramInt = ((TVKLiveInfoParams)localObject3).getStreamFormat();
    }
    ((Map)localObject1).put("stream", String.valueOf(paramInt));
    ((Map)localObject1).put("appVer", TVideoMgr.getPlayerVersion());
    ((Map)localObject1).put("guid", TVideoMgr.getStaGuid());
    ((Map)localObject1).put("qq", this.mUserInfo.getUin());
    ((Map)localObject1).put("wxopenid", this.mUserInfo.getWxOpenID());
    ((Map)localObject1).put("devid", TVKVcSystemInfo.getDeviceID(TVideoMgr.getApplicationContext()));
    ((Map)localObject1).put("defn", this.mDefinition);
    ((Map)localObject1).put("otype", "json");
    ((Map)localObject1).put("randnum", String.valueOf(Math.random()));
    setAudioFormat2Params((Map)localObject1);
    localObject3 = this.mLiveInfoParams;
    if ((localObject3 != null) && (((TVKLiveInfoParams)localObject3).getPreviewInfo())) {
      ((Map)localObject1).put("getpreviewinfo", "1");
    }
    setLoginType2Params((Map)localObject1);
    setVipStatus2Params((Map)localObject1);
    setEncryptVer2Params((Map)localObject1);
    if (!TextUtils.isEmpty(this.mUserInfo.getOauthConsumeKey()))
    {
      ((Map)localObject1).put("openid", this.mUserInfo.getOpenId());
      ((Map)localObject1).put("access_token", this.mUserInfo.getAccessToken());
      ((Map)localObject1).put("pf", this.mUserInfo.getPf());
      ((Map)localObject1).put("oauth_consumer_key", this.mUserInfo.getOauthConsumeKey());
    }
    ((Map)localObject1).put("newnettype", String.valueOf(getNetworkType()));
    if ((TVKMediaPlayerConfig.PreFetchedParams.sServerTime == 0L) && (mLastLocalTime == 0L)) {
      TVKMediaPlayerConfig.PreFetchedParams.sServerTime = System.currentTimeMillis() / 1000L;
    } else if ((TVKMediaPlayerConfig.PreFetchedParams.sServerTime == 0L) && (mLastLocalTime != 0L)) {
      TVKMediaPlayerConfig.PreFetchedParams.sServerTime = System.currentTimeMillis() / 1000L - mLastLocalTime + mLastServerTime;
    }
    ((Map)localObject1).put("fntick", String.valueOf(TVKMediaPlayerConfig.PreFetchedParams.sServerTime));
    mLastLocalTime = System.currentTimeMillis() / 1000L;
    mLastServerTime = TVKMediaPlayerConfig.PreFetchedParams.sServerTime;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("getRequestUrl(): GenCkey version = ");
    ((StringBuilder)localObject3).append(TVideoMgr.getPlayerVersion());
    ((StringBuilder)localObject3).append(" time=");
    ((StringBuilder)localObject3).append(TVKMediaPlayerConfig.PreFetchedParams.sServerTime);
    ((StringBuilder)localObject3).append(" lasttime = ");
    ((StringBuilder)localObject3).append(mLastServerTime);
    ((StringBuilder)localObject3).append(" vid= ");
    ((StringBuilder)localObject3).append(this.mProgramId);
    ((StringBuilder)localObject3).append(" platform=");
    ((StringBuilder)localObject3).append(i);
    ((StringBuilder)localObject3).append(", sdtfrom=");
    ((StringBuilder)localObject3).append((String)localObject2);
    TVKLogUtil.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", ((StringBuilder)localObject3).toString());
    this.mCKey = getCkey(i, (String)localObject2);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("getRequestUrl(): ckey5 = ");
    ((StringBuilder)localObject3).append(this.mCKey);
    ((StringBuilder)localObject3).append(" platform =");
    ((StringBuilder)localObject3).append(i);
    ((StringBuilder)localObject3).append(", sdtfrom=");
    ((StringBuilder)localObject3).append((String)localObject2);
    TVKLogUtil.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", ((StringBuilder)localObject3).toString());
    ((Map)localObject1).put("cKey", this.mCKey);
    localObject2 = this.mLiveInfoParams;
    if ((localObject2 != null) && (((TVKLiveInfoParams)localObject2).getExtraPara() != null))
    {
      localObject2 = this.mLiveInfoParams.getExtraPara().entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((Map)localObject1).put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
      }
    }
    if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.live_dolbyvision_enable.getValue()).booleanValue()) {
      ((Map)localObject1).put("active_sp", "1");
    }
    Object localObject1 = new UriBuilder().setUrl(str).addParam((Map)localObject1).buildUri();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getRequestUrl(): url = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    TVKLogUtil.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  protected String getUserAgent()
  {
    return "qqlive";
  }
  
  protected boolean isServerTimeErr(String paramString)
  {
    paramString = parseOutput(paramString);
    if ((paramString != null) && (paramString.getRetCode() == 32) && (paramString.getSubErrType() == -3))
    {
      TVKMediaPlayerConfig.PreFetchedParams.sServerTime = paramString.getServerTime();
      TVKMediaPlayerConfig.PreFetchedParams.sRandKey = paramString.getRand();
      TVKMediaPlayerConfig.PreFetchedParams.sElapsedRealTime = SystemClock.elapsedRealtime();
      return true;
    }
    return false;
  }
  
  protected TVKLiveVideoInfo parseOutput(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[TVKLiveInfoProcessor] httpBodyText = ");
    localStringBuilder.append(paramString);
    TVKLogUtil.i("MediaPlayerMgr", localStringBuilder.toString());
    try
    {
      paramString = parseJson(paramString);
      return paramString;
    }
    catch (JSONException paramString)
    {
      TVKLogUtil.i("MediaPlayerMgr", "[TVKLiveInfoProcessor] parse error!");
      TVKLogUtil.e("MediaPlayerMgr[TVKLiveInfoRequest.java]", paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoRequest
 * JD-Core Version:    0.7.0.1
 */