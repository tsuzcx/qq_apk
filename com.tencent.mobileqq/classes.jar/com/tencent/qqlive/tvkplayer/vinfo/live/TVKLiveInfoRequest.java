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
import com.tencent.qqlive.tvkplayer.vinfo.TVKLiveVideoInfo.SHOT_DIRECTION;
import com.tencent.qqlive.tvkplayer.vinfo.TVKNetVideoInfo.DefnInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKUserInfo.LoginType;
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
  private static final String TAG = "MediaPlayerMgr[TVKLiveInfoRequest.java]";
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
  private TVKLiveInfoRequest.UrlState mUrlState;
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
    int k = 0;
    TVKLiveVideoInfo localTVKLiveVideoInfo = new TVKLiveVideoInfo();
    localTVKLiveVideoInfo.setXml(paramString);
    paramString = new JSONObject(paramString);
    int i = paramString.getInt("iretcode");
    TVKLogUtil.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", "errcode " + i);
    localTVKLiveVideoInfo.setRetCode(i);
    localTVKLiveVideoInfo.setErrtitle(optString(paramString, "errtitle", null));
    localTVKLiveVideoInfo.setSubErrType(optInt(paramString, "type", 0));
    Object localObject1;
    if (paramString.has("playurl"))
    {
      localObject1 = paramString.getString("playurl");
      localTVKLiveVideoInfo.setPlayUrl((String)localObject1);
      localTVKLiveVideoInfo.setOriginalPlayUrl((String)localObject1);
    }
    if (this.mLiveInfoParams != null)
    {
      localTVKLiveVideoInfo.setGetDlnaUrl(this.mLiveInfoParams.isGetDlnaUrl());
      localTVKLiveVideoInfo.setGetPreviewInfo(this.mLiveInfoParams.getPreviewInfo());
    }
    Object localObject2;
    if (paramString.has("backurl_list"))
    {
      localObject1 = paramString.getJSONArray("backurl_list");
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
    if (paramString.has("acode")) {}
    for (i = paramString.optInt("acode");; i = 0)
    {
      int j;
      if (paramString.has("vcode"))
      {
        j = paramString.optInt("vcode");
        if (paramString.optInt("vcode") == 2) {
          localTVKLiveVideoInfo.setIsHevc(true);
        }
      }
      for (;;)
      {
        if (paramString.has("defn"))
        {
          localObject1 = new TVKNetVideoInfo.DefnInfo();
          ((TVKNetVideoInfo.DefnInfo)localObject1).setVideoCodec(j);
          ((TVKNetVideoInfo.DefnInfo)localObject1).setAudioCodec(i);
          ((TVKNetVideoInfo.DefnInfo)localObject1).setDefn(paramString.optString("defn"));
          ((TVKNetVideoInfo.DefnInfo)localObject1).setDefnName(TVKDefinitionUtils.getDefShowName(paramString.optString("defn")));
          localTVKLiveVideoInfo.setCurDefinition((TVKNetVideoInfo.DefnInfo)localObject1);
        }
        if (paramString.has("playback"))
        {
          localObject1 = new JSONObject(paramString.getString("playback"));
          if (((JSONObject)localObject1).has("playbackstart")) {
            localTVKLiveVideoInfo.setPlayBackStart(((JSONObject)localObject1).getLong("playbackstart"));
          }
          if (((JSONObject)localObject1).has("playbacktime")) {
            localTVKLiveVideoInfo.setPlayBackTime(((JSONObject)localObject1).getInt("playbacktime"));
          }
          if (((JSONObject)localObject1).has("svrtick")) {
            localTVKLiveVideoInfo.setSvrTick(((JSONObject)localObject1).getInt("svrtick"));
          }
        }
        if (paramString.has("formats"))
        {
          localObject1 = paramString.getJSONArray("formats");
          i = k;
          for (;;)
          {
            if (i < ((JSONArray)localObject1).length())
            {
              localObject2 = new TVKNetVideoInfo.DefnInfo();
              if (((JSONArray)localObject1).getJSONObject(i).has("fn")) {
                ((TVKNetVideoInfo.DefnInfo)localObject2).setDefn(((JSONArray)localObject1).getJSONObject(i).optString("fn"));
              }
              if (((JSONArray)localObject1).getJSONObject(i).has("fnname")) {
                ((TVKNetVideoInfo.DefnInfo)localObject2).setDefnShowName(((JSONArray)localObject1).getJSONObject(i).optString("fnname"));
              }
              if (((JSONArray)localObject1).getJSONObject(i).has("vip")) {
                ((TVKNetVideoInfo.DefnInfo)localObject2).setVip(((JSONArray)localObject1).getJSONObject(i).optInt("vip"));
              }
              if (((JSONArray)localObject1).getJSONObject(i).has("id")) {
                ((TVKNetVideoInfo.DefnInfo)localObject2).setDefnId(((JSONArray)localObject1).getJSONObject(i).optInt("id"));
              }
              if (((JSONArray)localObject1).getJSONObject(i).has("defnname")) {
                ((TVKNetVideoInfo.DefnInfo)localObject2).setDefnName(((JSONArray)localObject1).getJSONObject(i).optString("defnname"));
              }
              if (((JSONArray)localObject1).getJSONObject(i).has("defnrate")) {
                ((TVKNetVideoInfo.DefnInfo)localObject2).setDefnRate(((JSONArray)localObject1).getJSONObject(i).optString("defnrate"));
              }
              if ((localTVKLiveVideoInfo.getCurDefinition() != null) && (localTVKLiveVideoInfo.getCurDefinition().getDefn() != null) && (localTVKLiveVideoInfo.getCurDefinition().getDefn().equalsIgnoreCase(((TVKNetVideoInfo.DefnInfo)localObject2).getDefn())))
              {
                localTVKLiveVideoInfo.getCurDefinition().setDefnName(((TVKNetVideoInfo.DefnInfo)localObject2).getDefnName());
                localTVKLiveVideoInfo.getCurDefinition().setVip(((TVKNetVideoInfo.DefnInfo)localObject2).isVip());
                localTVKLiveVideoInfo.getCurDefinition().setDefnShowName(((TVKNetVideoInfo.DefnInfo)localObject2).getDefnShowName());
                localTVKLiveVideoInfo.getCurDefinition().setDefnRate(((TVKNetVideoInfo.DefnInfo)localObject2).getDefnRate());
              }
              localTVKLiveVideoInfo.addDefinition((TVKNetVideoInfo.DefnInfo)localObject2);
              i += 1;
              continue;
              localTVKLiveVideoInfo.setIsHevc(false);
              break;
            }
          }
        }
        if (paramString.has("live360_info"))
        {
          localObject1 = paramString.getJSONObject("live360_info");
          if (((JSONObject)localObject1).has("lens_direction"))
          {
            i = ((JSONObject)localObject1).optInt("lens_direction");
            if (1 != i) {
              break label1225;
            }
            localTVKLiveVideoInfo.setLens_direction(TVKLiveVideoInfo.SHOT_DIRECTION.SHOT_UP);
          }
        }
        for (;;)
        {
          if (paramString.has("hlsp2p")) {
            localTVKLiveVideoInfo.setHlsp2p(paramString.optInt("hlsp2p"));
          }
          return localTVKLiveVideoInfo;
          label1225:
          if (2 == i) {
            localTVKLiveVideoInfo.setLens_direction(TVKLiveVideoInfo.SHOT_DIRECTION.SHOT_DOWN);
          }
        }
        j = 0;
      }
    }
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
  
  protected String getRequestUrl(TVKLiveInfoRequest.UrlState paramUrlState)
  {
    Object localObject1;
    label50:
    int i;
    if (TVKLiveInfoRequest.UrlState.MasterUrl == paramUrlState)
    {
      paramUrlState = TVKConfigUrl.zb_cgi_host;
      if ((TextUtils.isEmpty(TVideoMgr.mOriginalUpc)) || (TVideoMgr.mFreeNetFlowRequestMap == null) || (!TVKVcSystemInfo.isNetworkTypeMobile(TVideoMgr.getApplicationContext())) || (this.mLiveInfoParams.isGetDlnaUrl())) {
        break label960;
      }
      localObject1 = TVideoMgr.mFreeNetFlowRequestMap;
      ((Map)localObject1).put("cnlid", this.mProgramId);
      ((Map)localObject1).put("cmd", "2");
      i = TVideoMgr.getVinfoPlatform();
      if ((this.mLiveInfoParams == null) || (this.mLiveInfoParams.getVideoInfo() == null)) {
        break label1509;
      }
      i = this.mLiveInfoParams.getVideoInfo().getPlatform();
    }
    label184:
    label470:
    label983:
    label1249:
    label1509:
    for (;;)
    {
      Object localObject3 = TVideoMgr.getVinfoSdtfrom();
      Object localObject2 = localObject3;
      if (this.mLiveInfoParams != null)
      {
        localObject2 = localObject3;
        if (this.mLiveInfoParams.getVideoInfo() != null) {
          localObject2 = TVideoMgr.getVinfoSdtfrom(i);
        }
      }
      ((Map)localObject1).put("platform", String.valueOf(i));
      ((Map)localObject1).put("sdtfrom", localObject2);
      int j;
      if (this.mLiveInfoParams == null)
      {
        j = 2;
        ((Map)localObject1).put("stream", String.valueOf(j));
        ((Map)localObject1).put("appVer", TVideoMgr.getPlayerVersion());
        ((Map)localObject1).put("guid", TVideoMgr.getStaGuid());
        ((Map)localObject1).put("qq", this.mUserInfo.getUin());
        ((Map)localObject1).put("wxopenid", this.mUserInfo.getWxOpenID());
        ((Map)localObject1).put("devid", TVKVcSystemInfo.getDeviceID(TVideoMgr.getApplicationContext()));
        ((Map)localObject1).put("defn", this.mDefinition);
        ((Map)localObject1).put("otype", "json");
        ((Map)localObject1).put("randnum", String.valueOf(Math.random()));
        if ((this.mLiveInfoParams == null) || (!this.mLiveInfoParams.isDolby())) {
          break label983;
        }
        ((Map)localObject1).put("audio_format", "2");
        label357:
        if ((this.mLiveInfoParams != null) && (this.mLiveInfoParams.getPreviewInfo())) {
          ((Map)localObject1).put("getpreviewinfo", "1");
        }
        if (this.mUserInfo.getLoginType() != TVKUserInfo.LoginType.LOGIN_QQ) {
          break label1000;
        }
        ((Map)localObject1).put("logintype", "1");
        if (!this.mUserInfo.isVip()) {
          break label1030;
        }
        ((Map)localObject1).put("vip_status", String.valueOf(1));
        if (65 != ((Integer)TVKMediaPlayerConfig.PlayerConfig.encrypt_ver.getValue()).intValue()) {
          break label1048;
        }
        ((Map)localObject1).put("encryptVer", "4.1");
        if (!TextUtils.isEmpty(this.mUserInfo.getOauthConsumeKey()))
        {
          ((Map)localObject1).put("openid", this.mUserInfo.getOpenId());
          ((Map)localObject1).put("access_token", this.mUserInfo.getAccessToken());
          ((Map)localObject1).put("pf", this.mUserInfo.getPf());
          ((Map)localObject1).put("oauth_consumer_key", this.mUserInfo.getOauthConsumeKey());
        }
        if (!TVKVcSystemInfo.isNetworkAvailable(TVideoMgr.getApplicationContext())) {
          break label1195;
        }
        if (TVKVcSystemInfo.getNetworkClass(TVideoMgr.getApplicationContext()) != 1) {
          break label1097;
        }
        ((Map)localObject1).put("newnettype", "1");
        if ((TVKMediaPlayerConfig.PreFetchedParams.sServerTime != 0L) || (mLastLocalTime != 0L)) {
          break label1212;
        }
      }
      for (TVKMediaPlayerConfig.PreFetchedParams.sServerTime = System.currentTimeMillis() / 1000L;; TVKMediaPlayerConfig.PreFetchedParams.sServerTime = System.currentTimeMillis() / 1000L - mLastLocalTime + mLastServerTime) {
        label1000:
        do
        {
          ((Map)localObject1).put("fntick", String.valueOf(TVKMediaPlayerConfig.PreFetchedParams.sServerTime));
          mLastLocalTime = System.currentTimeMillis() / 1000L;
          mLastServerTime = TVKMediaPlayerConfig.PreFetchedParams.sServerTime;
          TVKLogUtil.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", "getRequestUrl(): GenCkey version = " + TVideoMgr.getPlayerVersion() + " time=" + TVKMediaPlayerConfig.PreFetchedParams.sServerTime + " lasttime = " + mLastServerTime + " vid= " + this.mProgramId + " platform=" + i + ", sdtfrom=" + (String)localObject2);
          if ((this.mLiveInfoParams == null) || (!this.mLiveInfoParams.isGetDlnaUrl())) {
            break label1249;
          }
          localObject3 = new int[1];
          localObject3[0] = 1;
          this.mCKey = CKeyFacade.getCKey(TVideoMgr.getStaGuid(), TVKMediaPlayerConfig.PreFetchedParams.sServerTime, this.mProgramId, TVideoMgr.getPlayerVersion(), String.valueOf(i), (String)localObject2, (int[])localObject3, localObject3.length, "");
          TVKLogUtil.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", "getRequestUrl(): ckey5 = " + this.mCKey + " platform =" + i + ", sdtfrom=" + (String)localObject2);
          ((Map)localObject1).put("cKey", this.mCKey);
          if ((this.mLiveInfoParams == null) || (this.mLiveInfoParams.getExtraPara() == null)) {
            break label1433;
          }
          localObject2 = this.mLiveInfoParams.getExtraPara().entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            ((Map)localObject1).put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
          }
          if (TVKLiveInfoRequest.UrlState.ReServerUrl == paramUrlState)
          {
            paramUrlState = TVKConfigUrl.zb_cgi_host_bk;
            break;
          }
          paramUrlState = TVKConfigUrl.zb_cgi_host;
          break;
          localObject1 = new HashMap();
          break label50;
          j = this.mLiveInfoParams.getStreamFormat();
          break label184;
          ((Map)localObject1).put("audio_format", "1");
          break label357;
          if (this.mUserInfo.getLoginType() != TVKUserInfo.LoginType.LOGIN_WX) {
            break label415;
          }
          ((Map)localObject1).put("logintype", "2");
          break label415;
          ((Map)localObject1).put("vip_status", String.valueOf(0));
          break label440;
          if (66 == ((Integer)TVKMediaPlayerConfig.PlayerConfig.encrypt_ver.getValue()).intValue())
          {
            ((Map)localObject1).put("encryptVer", "4.2");
            break label470;
          }
          ((Map)localObject1).put("encryptVer", "5.1");
          break label470;
          if (TVKVcSystemInfo.getNetworkClass(TVideoMgr.getApplicationContext()) == 2)
          {
            ((Map)localObject1).put("newnettype", "2");
            break label588;
          }
          if (TVKVcSystemInfo.getNetworkClass(TVideoMgr.getApplicationContext()) == 3)
          {
            ((Map)localObject1).put("newnettype", "3");
            break label588;
          }
          if (TVKVcSystemInfo.getNetworkClass(TVideoMgr.getApplicationContext()) == 4)
          {
            ((Map)localObject1).put("newnettype", "4");
            break label588;
          }
          ((Map)localObject1).put("newnettype", "3");
          break label588;
          ((Map)localObject1).put("newnettype", "0");
          break label588;
        } while ((TVKMediaPlayerConfig.PreFetchedParams.sServerTime != 0L) || (mLastLocalTime == 0L));
      }
      localObject3 = new int[3];
      localObject3[0] = 0;
      localObject3[1] = 0;
      localObject3[2] = 0;
      if ((this.mLiveInfoParams != null) && (this.mLiveInfoParams.getExtraPara() != null) && (this.mLiveInfoParams.getExtraPara().containsKey("toushe")) && (this.mLiveInfoParams.getExtraPara().containsKey("from_platform")))
      {
        String str = (String)this.mLiveInfoParams.getExtraPara().get("from_platform");
        TVKLogUtil.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", "toushe, from_platform =" + str);
        localObject3[0] = 16;
        localObject3[1] = TVKUtils.optInt(str, i);
      }
      for (;;)
      {
        this.mCKey = CKeyFacade.getCKey(TVideoMgr.getStaGuid(), TVKMediaPlayerConfig.PreFetchedParams.sServerTime, this.mProgramId, TVideoMgr.getPlayerVersion(), String.valueOf(i), (String)localObject2, (int[])localObject3, localObject3.length, "");
        break;
        localObject3[0] = 0;
        localObject3[1] = 0;
      }
      if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.live_dolbyvision_enable.getValue()).booleanValue()) {
        ((Map)localObject1).put("active_sp", "1");
      }
      paramUrlState = new UriBuilder().setUrl(paramUrlState).addParam((Map)localObject1).buildUri();
      TVKLogUtil.i("MediaPlayerMgr[TVKLiveInfoRequest.java]", "getRequestUrl(): url = " + paramUrlState);
      return paramUrlState;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoRequest
 * JD-Core Version:    0.7.0.1
 */