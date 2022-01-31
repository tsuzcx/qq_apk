package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.ITVKHttpCallback;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIVInfoResponse;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.RSAUtils;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoConfig;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoEnum;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoHttpProcessor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TVKCGIVInfoRequest
{
  private static final int CGI_RETRY_MAX_COUNT = 2;
  private static int CURRENT_HOST_URL_RETRY_MAX_COUNT = TVKVideoInfoConfig.getInstance().getCgiRetryTime();
  private static final String ENCRYPT_VER_4 = "4.1";
  private static final String ENCRYPT_VER_4_2 = "4.2";
  private static final String ENCRYPT_VER_5 = "5.1";
  private static final String TAG = "TVKPlayer[VideoInfo][TVKCGIVInfoRequest]";
  private int mCGIRetryCount = 0;
  private String mCKey = "";
  private ITVKCGIVInfoResponse mCallback;
  private int mCurrentHostUrlRetryCount = 0;
  private int mGetUrlCount;
  private ITVKHttpProcessor.ITVKHttpCallback mGetVinfoCb = new TVKCGIVInfoRequest.1(this);
  private boolean mIsCanceled = false;
  private TVKCGIVInfoRequestParams mParams = null;
  private String mRequestID = "";
  private boolean mRetryWithoutHttps = true;
  private long mStartRequestMS = 0L;
  private boolean mUseBakUrl;
  
  public TVKCGIVInfoRequest(TVKCGIVInfoRequestParams paramTVKCGIVInfoRequestParams, ITVKCGIVInfoResponse paramITVKCGIVInfoResponse)
  {
    this.mParams = paramTVKCGIVInfoRequestParams;
    this.mCallback = paramITVKCGIVInfoResponse;
    this.mRequestID = paramTVKCGIVInfoRequestParams.getRequestID();
  }
  
  private String genCkey(TVKCGIVInfoRequestParams paramTVKCGIVInfoRequestParams, Map<String, String> paramMap)
  {
    int i = paramTVKCGIVInfoRequestParams.getEncrypVer();
    int j = paramTVKCGIVInfoRequestParams.getPlatForm();
    String str1 = this.mParams.getSdtFrom();
    Object localObject2 = paramTVKCGIVInfoRequestParams.getVid();
    String str2 = paramTVKCGIVInfoRequestParams.getAppVer();
    paramTVKCGIVInfoRequestParams.getFd();
    String str3 = paramTVKCGIVInfoRequestParams.getGuid();
    Object localObject1 = localObject2;
    if (paramMap != null)
    {
      localObject1 = localObject2;
      if (paramMap.containsKey("previd"))
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)paramMap.get("previd"))) {
          localObject1 = RSAUtils.getNewVid((String)paramMap.get("previd"));
        }
      }
    }
    long l1 = TVKVideoInfoCheckTime.mServerTime;
    long l2 = (SystemClock.elapsedRealtime() - TVKVideoInfoCheckTime.mElapsedRealTime) / 1000L;
    paramMap = paramTVKCGIVInfoRequestParams.getCkeyExtraParamsMap();
    localObject2 = new int[3];
    localObject2[0] = 0;
    localObject2[1] = 0;
    localObject2[2] = 0;
    if (paramTVKCGIVInfoRequestParams.getRequestType() == 0)
    {
      localObject2[0] = 0;
      if (paramMap != null)
      {
        if ((!paramMap.containsKey("toushe")) || (!paramMap.containsKey("from_platform"))) {
          break label311;
        }
        localObject2[0] = 16;
        localObject2[1] = TVKUtils.optInt((String)paramMap.get("from_platform"), j);
      }
    }
    for (;;)
    {
      this.mCKey = CKeyFacade.getCKey(str3, l1 + l2, (String)localObject1, str2, String.valueOf(j), str1, (int[])localObject2, localObject2.length, "");
      TVKLogUtil.i("TVKPlayer[VideoInfo][TVKCGIVInfoRequest]", "[vinfo][getvinfo] GenCkey version =  vid = " + (String)localObject1 + " encryptVer = " + i + " platform= " + j + " ckey= " + this.mCKey);
      return this.mCKey;
      localObject2[0] = 4;
      break;
      label311:
      if (paramMap.containsKey("sptest")) {
        localObject2[0] = 64;
      } else if (paramMap.containsKey("ottflag")) {
        localObject2[2] = TVKUtils.optInt((String)paramMap.get("ottflag"), 0);
      } else if (paramMap.containsKey("dlna")) {
        localObject2[0] = 1;
      }
    }
  }
  
  private Map<String, String> getHeaders()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("User-Agent", "qqlive");
    if (this.mParams.useIpV6Dns()) {
      localHashMap.put("Host", TVKVideoInfoEnum.VINFO_IPV6_HOST);
    }
    for (;;)
    {
      if (3 == this.mParams.getDlType()) {
        localHashMap.put("Accept-Encoding", "gzip");
      }
      if (this.mParams.getDlType() == 0) {
        localHashMap.put("Accept-Encoding", "gzip");
      }
      if (!TextUtils.isEmpty(this.mParams.getLoginCookie())) {
        localHashMap.put("Cookie", this.mParams.getLoginCookie());
      }
      return localHashMap;
      if (this.mUseBakUrl) {
        localHashMap.put("Host", TVKVideoInfoEnum.VINFO_BK_HOST);
      } else {
        localHashMap.put("Host", TVKVideoInfoEnum.VINFO_HOST);
      }
    }
  }
  
  private int getRequestTypeForVinfo()
  {
    if (this.mParams.useIpV6Dns()) {
      return 4;
    }
    return 1;
  }
  
  private String getRequestUrl()
  {
    Object localObject1;
    Object localObject2;
    if (this.mParams.useIpV6Dns())
    {
      localObject1 = TVKVideoInfoEnum.VINFO_IPV6_SERVER;
      localObject2 = TVKVideoInfoEnum.VINFO_IPV6_HOST;
    }
    for (;;)
    {
      Object localObject3 = localObject1;
      if (this.mParams.useIpV6Dns())
      {
        localObject3 = localObject1;
        if (!TVKVideoInfoCache.getInstance().isIpv6Error())
        {
          localObject2 = new TVKVideoInfoDnsQuery((String)localObject2);
          ((TVKVideoInfoDnsQuery)localObject2).start();
        }
      }
      try
      {
        ((TVKVideoInfoDnsQuery)localObject2).join(2000L);
        localObject2 = ((TVKVideoInfoDnsQuery)localObject2).getDnsIpv6();
        localObject3 = localObject1;
        if (((ArrayList)localObject2).size() > 0) {
          localObject3 = "http://[" + (String)((ArrayList)localObject2).get(0) + "]/getvinfo";
        }
        localObject1 = localObject3;
        if (!this.mRetryWithoutHttps) {
          if (!TVKVideoInfoConfig.getInstance().isEnableHttps())
          {
            localObject1 = localObject3;
            if (!TVKVideoInfoConfig.getInstance().isVinfoEnableHttps()) {}
          }
          else
          {
            localObject1 = ((String)localObject3).replaceFirst("http", "https");
          }
        }
        return localObject1;
        if (this.mUseBakUrl)
        {
          localObject1 = TVKVideoInfoEnum.VINFO_BK_SERVER;
          localObject2 = TVKVideoInfoEnum.VINFO_BK_HOST;
          continue;
        }
        localObject1 = TVKVideoInfoEnum.VINFO_SERVER;
        localObject2 = TVKVideoInfoEnum.VINFO_HOST;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          TVKLogUtil.e("TVKPlayer[VideoInfo][TVKCGIVInfoRequest]", "DNS Exception");
        }
      }
    }
  }
  
  private Map<String, String> packRequestParams()
  {
    int j = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("vid", this.mParams.getVid());
    localHashMap.put("charge", String.valueOf(this.mParams.isCharge()));
    localHashMap.put("platform", String.valueOf(this.mParams.getPlatForm()));
    localHashMap.put("sdtfrom", this.mParams.getSdtFrom());
    localHashMap.put("fhdswitch", "0");
    localHashMap.put("sphls", "1");
    localHashMap.put("defn", this.mParams.getFormat());
    localHashMap.put("ipstack", String.valueOf(this.mParams.getipstack()));
    label331:
    label375:
    label381:
    Object localObject2;
    if (this.mParams.getDlType() == 0)
    {
      localHashMap.put("clip", "0");
      localHashMap.put("dtype", "3");
      if ((this.mParams.getCkeyExtraParamsMap() == null) || (this.mParams.getCkeyExtraParamsMap().isEmpty()))
      {
        localHashMap.put("sphls", "2");
        localHashMap.put("spgzip", "1");
      }
      if (this.mParams.getPlayerCapacity() > 0) {
        localHashMap.put("device", String.valueOf(this.mParams.getPlayerCapacity()));
      }
      if (this.mParams.getAppVer() != null) {
        localHashMap.put("appVer", this.mParams.getAppVer());
      }
      if (65 != this.mParams.getEncrypVer()) {
        break label696;
      }
      localHashMap.put("encryptVer", "4.1");
      if (TextUtils.isEmpty(this.mParams.getUpc())) {
        break label784;
      }
      if (!this.mParams.getUpc().contains("&")) {
        break label740;
      }
      localObject1 = this.mParams.getUpc().split("&");
      int k = localObject1.length;
      i = 0;
      if (i >= k) {
        break label784;
      }
      localObject2 = localObject1[i].split("=");
      if (localObject2.length != 2) {
        break label760;
      }
      localHashMap.put(localObject2[0], localObject2[1]);
    }
    for (;;)
    {
      i += 1;
      break label381;
      if (this.mParams.getDlType() == 4)
      {
        localHashMap.put("clip", "2");
        localHashMap.put("dtype", String.valueOf("1"));
        break;
      }
      if (this.mParams.getDlType() == 5)
      {
        localHashMap.put("clip", "3");
        localHashMap.put("dtype", String.valueOf("1"));
        break;
      }
      if (this.mParams.getDlType() == 1)
      {
        localHashMap.put("clip", "4");
        localHashMap.put("dtype", String.valueOf("1"));
        break;
      }
      if (this.mParams.getDlType() == 3)
      {
        localHashMap.put("clip", "0");
        localHashMap.put("dtype", "3");
        if ((this.mParams.getCkeyExtraParamsMap() != null) && (!this.mParams.getCkeyExtraParamsMap().isEmpty())) {
          break;
        }
        localHashMap.put("sphls", "2");
        localHashMap.put("spgzip", "1");
        break;
      }
      localHashMap.put("clip", "0");
      localHashMap.put("dtype", String.valueOf(this.mParams.getDlType()));
      break;
      label696:
      if (66 == this.mParams.getEncrypVer())
      {
        localHashMap.put("encryptVer", "4.2");
        break label331;
      }
      localHashMap.put("encryptVer", "5.1");
      break label331;
      label740:
      localObject1 = new String[1];
      localObject1[0] = this.mParams.getUpc();
      break label375;
      label760:
      if (localObject2.length == 1) {
        localHashMap.put(localObject2[0], "");
      }
    }
    label784:
    Object localObject1 = this.mParams.getExtraParamsMap();
    int i = j;
    if (localObject1 != null)
    {
      i = j;
      if (!((Map)localObject1).isEmpty())
      {
        localObject2 = ((Map)localObject1).entrySet().iterator();
        i = 0;
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
          i = j;
          if (localEntry != null)
          {
            i = j;
            try
            {
              if (localEntry.getKey() != null)
              {
                i = j;
                if (localEntry.getValue() != null) {
                  if (((String)localEntry.getKey()).equalsIgnoreCase("drm"))
                  {
                    i = TVKUtils.optInt((String)localEntry.getValue(), 0);
                  }
                  else
                  {
                    localHashMap.put(localEntry.getKey(), localEntry.getValue());
                    i = j;
                  }
                }
              }
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
              i = j;
            }
          }
        }
        i = j;
      }
    }
    localHashMap.put("drm", String.valueOf(i + this.mParams.getDrm()));
    localHashMap.put("cKey", genCkey(this.mParams, (Map)localObject1));
    localHashMap.put("newnettype", String.valueOf(this.mParams.getNetworkType()));
    localHashMap.put("otype", "xml");
    if (!TextUtils.isEmpty(this.mParams.getWxOpenId())) {
      localHashMap.put("openid", this.mParams.getWxOpenId());
    }
    return localHashMap;
  }
  
  public void cancelRequest()
  {
    this.mIsCanceled = true;
  }
  
  public void executeRequest()
  {
    if (this.mIsCanceled) {
      return;
    }
    if ((!this.mUseBakUrl) && (this.mCurrentHostUrlRetryCount == CURRENT_HOST_URL_RETRY_MAX_COUNT)) {
      if (this.mUseBakUrl) {
        break label138;
      }
    }
    label138:
    for (boolean bool = true;; bool = false)
    {
      this.mUseBakUrl = bool;
      this.mCurrentHostUrlRetryCount = 0;
      if (this.mCurrentHostUrlRetryCount >= CURRENT_HOST_URL_RETRY_MAX_COUNT) {
        break;
      }
      this.mGetUrlCount += 1;
      this.mCurrentHostUrlRetryCount += 1;
      Map localMap = packRequestParams();
      TVKLogUtil.i("TVKPlayer[VideoInfo][TVKCGIVInfoRequest]", "[vinfo][getvinfo] start to request, request time:" + this.mCurrentHostUrlRetryCount);
      this.mStartRequestMS = SystemClock.elapsedRealtime();
      TVKVideoInfoHttpProcessor.getInstance().addToRequestQueue(this.mCurrentHostUrlRetryCount, getRequestUrl(), localMap, getHeaders(), this.mGetVinfoCb);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVInfoRequest
 * JD-Core Version:    0.7.0.1
 */