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
    if (paramTVKLiveInfoCallback == null) {
      throw new NullPointerException("callback is null");
    }
    if (paramString1 == null) {
      throw new NullPointerException("progId is null");
    }
    paramString1 = paramString1.trim();
    if (paramString1.length() == 0) {
      throw new NullPointerException("progId is blank");
    }
    this.mUserInfo = paramTVKUserInfo;
    this.mProgramId = paramString1;
    this.mDefinition = paramString2;
    this.mCallback = paramTVKLiveInfoCallback;
    this.mPlayerID = paramInt;
    this.mLiveInfoParams = paramTVKLiveInfoParams;
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
    if ((this.mLiveInfoParams != null) && (this.mLiveInfoParams.isGetDlnaUrl()))
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = 1;
      return CKeyFacade.getCKey(TVideoMgr.getStaGuid(), TVKMediaPlayerConfig.PreFetchedParams.sServerTime, this.mProgramId, TVideoMgr.getPlayerVersion(), String.valueOf(paramInt), paramString, arrayOfInt, arrayOfInt.length, "");
    }
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    if ((this.mLiveInfoParams != null) && (this.mLiveInfoParams.getExtraPara() != null) && (this.mLiveInfoParams.getExtraPara().containsKey("toushe")) && (this.mLiveInfoParams.getExtraPara().containsKey("from_platform")))
    {
      String str = (String)this.mLiveInfoParams.getExtraPara().get("from_platform");
      TVKLogUtil.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", "toushe, from_platform =" + str);
      arrayOfInt[0] = 16;
      arrayOfInt[1] = TVKUtils.optInt(str, paramInt);
    }
    for (;;)
    {
      return CKeyFacade.getCKey(TVideoMgr.getStaGuid(), TVKMediaPlayerConfig.PreFetchedParams.sServerTime, this.mProgramId, TVideoMgr.getPlayerVersion(), String.valueOf(paramInt), paramString, arrayOfInt, arrayOfInt.length, "");
      arrayOfInt[0] = 0;
      arrayOfInt[1] = 0;
    }
  }
  
  private Map<String, String> getHeaders()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("User-Agent", "qqlive");
    if ((this.mUserInfo != null) && (!TextUtils.isEmpty(this.mUserInfo.getLoginCookie())))
    {
      TVKLogUtil.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", "cookie = " + this.mUserInfo.getLoginCookie());
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
      if (TVKVcSystemInfo.getNetworkClass(TVideoMgr.getApplicationContext()) == 3) {
        return 3;
      }
      if (TVKVcSystemInfo.getNetworkClass(TVideoMgr.getApplicationContext()) == 4) {
        return 4;
      }
      return 3;
    }
    return 0;
  }
  
  private int optInt(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if (paramJSONObject.has(paramString)) {
      paramInt = paramJSONObject.optInt(paramString);
    }
    return paramInt;
  }
  
  private long optLong(JSONObject paramJSONObject, String paramString, long paramLong)
  {
    if (paramJSONObject.has(paramString)) {
      paramLong = paramJSONObject.optInt(paramString);
    }
    return paramLong;
  }
  
  private String optString(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (paramJSONObject.has(paramString1)) {
      paramString2 = paramJSONObject.optString(paramString1);
    }
    return paramString2;
  }
  
  private TVKLiveVideoInfo parseJson(String paramString)
  {
    int j = 0;
    TVKLiveVideoInfo localTVKLiveVideoInfo = new TVKLiveVideoInfo();
    localTVKLiveVideoInfo.setXml(paramString);
    paramString = new JSONObject(paramString);
    int i = paramString.optInt("iretcode");
    TVKLogUtil.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", "errcode " + i);
    localTVKLiveVideoInfo.setRetCode(i);
    localTVKLiveVideoInfo.setErrtitle(optString(paramString, "errtitle", null));
    localTVKLiveVideoInfo.setSubErrType(optInt(paramString, "type", 0));
    if (paramString.has("playurl"))
    {
      localObject1 = paramString.optString("playurl");
      localTVKLiveVideoInfo.setPlayUrl((String)localObject1);
      localTVKLiveVideoInfo.setOriginalPlayUrl((String)localObject1);
    }
    if (this.mLiveInfoParams != null)
    {
      localTVKLiveVideoInfo.setGetDlnaUrl(this.mLiveInfoParams.isGetDlnaUrl());
      localTVKLiveVideoInfo.setGetPreviewInfo(this.mLiveInfoParams.getPreviewInfo());
    }
    Object localObject1 = paramString.optJSONArray("backurl_list");
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
    localTVKLiveVideoInfo.setaCode(optInt(paramString, "acode", 0));
    localTVKLiveVideoInfo.setvCode(optInt(paramString, "vcode", 0));
    i = paramString.optInt("acode");
    int k = paramString.optInt("vcode");
    if (k == 2) {
      localTVKLiveVideoInfo.setIsHevc(true);
    }
    for (;;)
    {
      if (paramString.has("defn"))
      {
        localObject1 = new TVKNetVideoInfo.DefnInfo();
        ((TVKNetVideoInfo.DefnInfo)localObject1).setVideoCodec(k);
        ((TVKNetVideoInfo.DefnInfo)localObject1).setAudioCodec(i);
        ((TVKNetVideoInfo.DefnInfo)localObject1).setDefn(paramString.optString("defn"));
        ((TVKNetVideoInfo.DefnInfo)localObject1).setDefnName(TVKDefinitionUtils.getDefShowName(paramString.optString("defn")));
        localTVKLiveVideoInfo.setCurDefinition((TVKNetVideoInfo.DefnInfo)localObject1);
      }
      if ((paramString.has("playback")) && (!TextUtils.isEmpty(paramString.getString("playback")))) {}
      try
      {
        localObject1 = new JSONObject(paramString.getString("playback"));
        localTVKLiveVideoInfo.setPlayBackStart(((JSONObject)localObject1).optLong("playbackstart"));
        localTVKLiveVideoInfo.setPlayBackTime(((JSONObject)localObject1).optInt("playbacktime"));
        localTVKLiveVideoInfo.setSvrTick(((JSONObject)localObject1).optInt("svrtick"));
        label757:
        localObject1 = paramString.optJSONArray("formats");
        if (localObject1 != null)
        {
          i = j;
          for (;;)
          {
            if (i < ((JSONArray)localObject1).length())
            {
              if (((JSONArray)localObject1).getJSONObject(i) != null)
              {
                localObject2 = ((JSONArray)localObject1).getJSONObject(i);
                TVKNetVideoInfo.DefnInfo localDefnInfo = new TVKNetVideoInfo.DefnInfo();
                localDefnInfo.setDefn(((JSONObject)localObject2).optString("fn"));
                localDefnInfo.setDefnShowName(((JSONObject)localObject2).optString("fnname"));
                localDefnInfo.setVip(((JSONObject)localObject2).optInt("vip"));
                localDefnInfo.setDefnId(((JSONObject)localObject2).optInt("id"));
                localDefnInfo.setDefnName(((JSONObject)localObject2).optString("defnname"));
                localDefnInfo.setDefnRate(((JSONObject)localObject2).optString("defnrate"));
                if ((localTVKLiveVideoInfo.getCurDefinition() != null) && (localTVKLiveVideoInfo.getCurDefinition().getDefn() != null) && (localTVKLiveVideoInfo.getCurDefinition().getDefn().equalsIgnoreCase(localDefnInfo.getDefn())))
                {
                  localTVKLiveVideoInfo.getCurDefinition().setDefnName(localDefnInfo.getDefnName());
                  localTVKLiveVideoInfo.getCurDefinition().setVip(localDefnInfo.isVip());
                  localTVKLiveVideoInfo.getCurDefinition().setDefnShowName(localDefnInfo.getDefnShowName());
                  localTVKLiveVideoInfo.getCurDefinition().setDefnRate(localDefnInfo.getDefnRate());
                }
                localTVKLiveVideoInfo.addDefinition(localDefnInfo);
              }
              i += 1;
              continue;
              localTVKLiveVideoInfo.setIsHevc(false);
              break;
            }
          }
        }
        if (paramString.has("live360_info"))
        {
          localObject1 = paramString.optJSONObject("live360_info");
          if ((localObject1 != null) && (((JSONObject)localObject1).has("lens_direction")))
          {
            i = ((JSONObject)localObject1).optInt("lens_direction");
            if (1 != i) {
              break label1069;
            }
            localTVKLiveVideoInfo.setLensDirection(1);
          }
        }
        for (;;)
        {
          localTVKLiveVideoInfo.setHlsp2p(paramString.optInt("hlsp2p"));
          return localTVKLiveVideoInfo;
          label1069:
          if (2 == i) {
            localTVKLiveVideoInfo.setLensDirection(2);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        break label757;
      }
    }
  }
  
  private void setAudioFormat2Params(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    if ((this.mLiveInfoParams != null) && (this.mLiveInfoParams.isDolby()))
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
    if (paramMap == null) {}
    do
    {
      return;
      if (this.mUserInfo.getLoginType() == 2)
      {
        paramMap.put("logintype", "1");
        return;
      }
    } while (this.mUserInfo.getLoginType() != 3);
    paramMap.put("logintype", "2");
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
    int i = 0;
    paramString2 = paramString2.split(";");
    String str = paramString1.substring(0, paramString1.indexOf("//") + 2);
    String[] arrayOfString = new String[paramString2.length];
    while (i < paramString2.length)
    {
      arrayOfString[i] = (str + paramString2[i] + paramString1.substring(paramString1.lastIndexOf("/")));
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
    int i;
    Object localObject3;
    Object localObject2;
    if ((!TextUtils.isEmpty(TVideoMgr.mOriginalUpc)) && (TVideoMgr.mFreeNetFlowRequestMap != null) && (TVKVcSystemInfo.isNetworkTypeMobile(TVideoMgr.getApplicationContext())) && (!this.mLiveInfoParams.isGetDlnaUrl()))
    {
      localObject1 = TVideoMgr.mFreeNetFlowRequestMap;
      ((Map)localObject1).put("cnlid", this.mProgramId);
      ((Map)localObject1).put("cmd", "2");
      i = TVideoMgr.getVinfoPlatform();
      paramInt = i;
      if (this.mLiveInfoParams != null)
      {
        paramInt = i;
        if (this.mLiveInfoParams.getVideoInfo() != null) {
          paramInt = this.mLiveInfoParams.getVideoInfo().getPlatform();
        }
      }
      localObject3 = TVideoMgr.getVinfoSdtfrom();
      localObject2 = localObject3;
      if (this.mLiveInfoParams != null)
      {
        localObject2 = localObject3;
        if (this.mLiveInfoParams.getVideoInfo() != null) {
          localObject2 = TVideoMgr.getVinfoSdtfrom(paramInt);
        }
      }
      ((Map)localObject1).put("platform", String.valueOf(paramInt));
      ((Map)localObject1).put("sdtfrom", localObject2);
      if (this.mLiveInfoParams != null) {
        break label770;
      }
      i = 2;
      label179:
      ((Map)localObject1).put("stream", String.valueOf(i));
      ((Map)localObject1).put("appVer", TVideoMgr.getPlayerVersion());
      ((Map)localObject1).put("guid", TVideoMgr.getStaGuid());
      ((Map)localObject1).put("qq", this.mUserInfo.getUin());
      ((Map)localObject1).put("wxopenid", this.mUserInfo.getWxOpenID());
      ((Map)localObject1).put("devid", TVKVcSystemInfo.getDeviceID(TVideoMgr.getApplicationContext()));
      ((Map)localObject1).put("defn", this.mDefinition);
      ((Map)localObject1).put("otype", "json");
      ((Map)localObject1).put("randnum", String.valueOf(Math.random()));
      setAudioFormat2Params((Map)localObject1);
      if ((this.mLiveInfoParams != null) && (this.mLiveInfoParams.getPreviewInfo())) {
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
      if ((TVKMediaPlayerConfig.PreFetchedParams.sServerTime != 0L) || (mLastLocalTime != 0L)) {
        break label781;
      }
    }
    for (TVKMediaPlayerConfig.PreFetchedParams.sServerTime = System.currentTimeMillis() / 1000L;; TVKMediaPlayerConfig.PreFetchedParams.sServerTime = System.currentTimeMillis() / 1000L - mLastLocalTime + mLastServerTime) {
      label770:
      label781:
      do
      {
        ((Map)localObject1).put("fntick", String.valueOf(TVKMediaPlayerConfig.PreFetchedParams.sServerTime));
        mLastLocalTime = System.currentTimeMillis() / 1000L;
        mLastServerTime = TVKMediaPlayerConfig.PreFetchedParams.sServerTime;
        TVKLogUtil.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", "getRequestUrl(): GenCkey version = " + TVideoMgr.getPlayerVersion() + " time=" + TVKMediaPlayerConfig.PreFetchedParams.sServerTime + " lasttime = " + mLastServerTime + " vid= " + this.mProgramId + " platform=" + paramInt + ", sdtfrom=" + (String)localObject2);
        this.mCKey = getCkey(paramInt, (String)localObject2);
        TVKLogUtil.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", "getRequestUrl(): ckey5 = " + this.mCKey + " platform =" + paramInt + ", sdtfrom=" + (String)localObject2);
        ((Map)localObject1).put("cKey", this.mCKey);
        if ((this.mLiveInfoParams == null) || (this.mLiveInfoParams.getExtraPara() == null)) {
          break label818;
        }
        localObject2 = this.mLiveInfoParams.getExtraPara().entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          ((Map)localObject1).put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
        }
        localObject1 = new HashMap();
        break;
        i = this.mLiveInfoParams.getStreamFormat();
        break label179;
      } while ((TVKMediaPlayerConfig.PreFetchedParams.sServerTime != 0L) || (mLastLocalTime == 0L));
    }
    label818:
    if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.live_dolbyvision_enable.getValue()).booleanValue()) {
      ((Map)localObject1).put("active_sp", "1");
    }
    Object localObject1 = new UriBuilder().setUrl(str).addParam((Map)localObject1).buildUri();
    TVKLogUtil.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", "getRequestUrl(): url = " + (String)localObject1);
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
    TVKLogUtil.i("MediaPlayerMgr", "[TVKLiveInfoProcessor] httpBodyText = " + paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoRequest
 * JD-Core Version:    0.7.0.1
 */