package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.ITVKHttpCallback;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIVkeyResponse;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoConfig;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoEnum;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoHttpProcessor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TVKCGIVkeyRequest
{
  private static int CURRENT_HOST_URL_RETRY_MAX_COUNT = TVKVideoInfoConfig.getInstance().getCgiRetryTime();
  private static final String ENCRYPT_VER_4 = "4.1";
  private static final String ENCRYPT_VER_4_2 = "4.2";
  private static final String ENCRYPT_VER_5 = "5.1";
  private static final int ERR_RETRY_MAX_COUNT = 2;
  private static final String TAG = "MediaPlayer[TVKCGIVkeyRequest.java]";
  private ITVKCGIVkeyResponse mCallback = null;
  private int mCgiRetryCount = 0;
  private int mCurrentHostUrlRetryCount = 0;
  private int mGetUrlCount = 0;
  private ITVKHttpProcessor.ITVKHttpCallback mGetVkeyCb = new TVKCGIVkeyRequest.1(this);
  private boolean mIsCanceled = false;
  private boolean mIsVkeyUseIpv6Dns = false;
  private TVKCGIVKeyRequestParams mParams;
  private String mRequestID = "";
  private boolean mRetryWithoutHttps = true;
  private long mStartRequestMS = 0L;
  private boolean mUseBkurl = false;
  
  public TVKCGIVkeyRequest(TVKCGIVKeyRequestParams paramTVKCGIVKeyRequestParams, ITVKCGIVkeyResponse paramITVKCGIVkeyResponse)
  {
    this.mParams = paramTVKCGIVKeyRequestParams;
    this.mCallback = paramITVKCGIVkeyResponse;
  }
  
  private static String genCkey(TVKCGIVKeyRequestParams paramTVKCGIVKeyRequestParams)
  {
    int i = paramTVKCGIVKeyRequestParams.getEncryptVer();
    long l = TVKVideoInfoCheckTime.mServerTime + (SystemClock.elapsedRealtime() - TVKVideoInfoCheckTime.mElapsedRealTime) / 1000L;
    int j = paramTVKCGIVKeyRequestParams.getPlatForm();
    String str1 = paramTVKCGIVKeyRequestParams.getSdtFrom();
    String str2 = paramTVKCGIVKeyRequestParams.getVid();
    String str3 = paramTVKCGIVKeyRequestParams.getAppVer();
    String str4 = paramTVKCGIVKeyRequestParams.getGuid();
    if (i <= 81) {
      return CKeyFacade.getCKey(str4, l, str2, str3, String.valueOf(j), str1, "", "");
    }
    Map localMap = paramTVKCGIVKeyRequestParams.getCkeyExtraParamsMap();
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    if (paramTVKCGIVKeyRequestParams.getRequestType() == 0)
    {
      arrayOfInt[0] = 0;
      if (localMap != null)
      {
        if ((!localMap.containsKey("toushe")) || (!localMap.containsKey("from_platform"))) {
          break label202;
        }
        arrayOfInt[0] = 16;
        arrayOfInt[1] = TVKUtils.optInt((String)localMap.get("from_platform"), j);
      }
    }
    for (;;)
    {
      return CKeyFacade.getCKey(str4, l, str2, str3, String.valueOf(j), str1, arrayOfInt, arrayOfInt.length, "");
      arrayOfInt[0] = 4;
      break;
      label202:
      if (localMap.containsKey("sptest")) {
        arrayOfInt[0] = 64;
      } else if (localMap.containsKey("ottflag")) {
        arrayOfInt[2] = TVKUtils.optInt((String)localMap.get("ottflag"), 0);
      }
    }
  }
  
  private Map<String, String> getHeaders()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("User-Agent", "qqlive");
    if ((this.mParams != null) && (!TextUtils.isEmpty(this.mParams.getLoginCookie())))
    {
      localHashMap.put("Cookie", this.mParams.getLoginCookie());
      TVKLogUtil.i("MediaPlayer[TVKCGIVkeyRequest.java]", "[vinfo][getvkey]cookie:" + this.mParams.getLoginCookie());
    }
    return localHashMap;
  }
  
  private Map<String, String> getQueryParams()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("vid", this.mParams.getVid());
    localHashMap.put("vt", this.mParams.getVt());
    int i;
    Object localObject1;
    label247:
    label252:
    Object localObject2;
    if (this.mParams.getVkeyType() == 0)
    {
      i = this.mParams.getStartClipNo();
      int j = this.mParams.getEndClipNo();
      localObject1 = new StringBuilder(Integer.toString(i));
      i += 1;
      while (i <= j)
      {
        ((StringBuilder)localObject1).append("|");
        ((StringBuilder)localObject1).append(String.valueOf(i));
        i += 1;
      }
      localHashMap.put("idx", ((StringBuilder)localObject1).toString());
      localHashMap.put("platform", String.valueOf(this.mParams.getPlatForm()));
      localHashMap.put("appVer", this.mParams.getAppVer());
      localHashMap.put("sdtfrom", this.mParams.getSdtFrom());
      localHashMap.put("format", this.mParams.getFormat());
      if (TextUtils.isEmpty(this.mParams.getUpc())) {
        break label415;
      }
      if (!this.mParams.getUpc().contains("&")) {
        break label319;
      }
      localObject1 = this.mParams.getUpc().split("&");
      j = localObject1.length;
      i = 0;
      if (i >= j) {
        break label361;
      }
      localObject2 = localObject1[i].split("=");
      if (localObject2.length != 2) {
        break label337;
      }
      localHashMap.put(localObject2[0], localObject2[1]);
    }
    for (;;)
    {
      i += 1;
      break label252;
      localHashMap.put("filename", this.mParams.getFileName());
      break;
      label319:
      localObject1 = new String[1];
      localObject1[0] = this.mParams.getUpc();
      break label247;
      label337:
      if (localObject2.length == 1) {
        localHashMap.put(localObject2[0], "");
      }
    }
    label361:
    localHashMap.put("path", this.mParams.getUpcPaths());
    localHashMap.put("spip", this.mParams.getUpcSPIPs());
    localHashMap.put("spport", this.mParams.getUpcSPPORTs());
    label415:
    localHashMap.put("newnettype", String.valueOf(this.mParams.getNetworkType()));
    localHashMap.put("qqlog", this.mParams.getLoginQQ());
    if (65 == this.mParams.getEncryptVer()) {
      localObject1 = "4.1";
    }
    for (;;)
    {
      localHashMap.put("encryptVer", localObject1);
      localHashMap.put("cKey", genCkey(this.mParams));
      localHashMap.put("lnk", this.mParams.getLnk());
      localHashMap.put("linkver", String.valueOf(2));
      if (!TextUtils.isEmpty(this.mParams.getWxOpenId())) {
        localHashMap.put("openid", this.mParams.getWxOpenId());
      }
      localObject1 = this.mParams.getExtraParamsMap();
      if ((localObject1 == null) || (((Map)localObject1).isEmpty())) {
        break;
      }
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localHashMap.put(((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
      }
      if (66 == this.mParams.getEncryptVer()) {
        localObject1 = "4.2";
      } else {
        localObject1 = "5.1";
      }
    }
    return localHashMap;
  }
  
  private String getRequestUrl()
  {
    String str1;
    if (this.mParams.isUseIpV6Dns()) {
      str1 = TVKVideoInfoEnum.VBKEY_V6_SERVER_NEW;
    }
    for (;;)
    {
      String str2 = str1;
      if (!this.mRetryWithoutHttps) {
        if (!TVKVideoInfoConfig.getInstance().isEnableHttps())
        {
          str2 = str1;
          if (!TVKVideoInfoConfig.getInstance().isVkeyEnableHttps()) {}
        }
        else
        {
          str2 = str1.replaceFirst("http", "https");
        }
      }
      return str2;
      if (this.mUseBkurl) {
        str1 = TVKVideoInfoEnum.VBKEY_BK_SERVER_NEW;
      } else {
        str1 = TVKVideoInfoEnum.VBKEY_SERVER_NEW;
      }
    }
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
    if ((!this.mUseBkurl) && (this.mCurrentHostUrlRetryCount == CURRENT_HOST_URL_RETRY_MAX_COUNT)) {
      if (this.mUseBkurl) {
        break label138;
      }
    }
    label138:
    for (boolean bool = true;; bool = false)
    {
      this.mUseBkurl = bool;
      this.mCurrentHostUrlRetryCount = 0;
      if (this.mCurrentHostUrlRetryCount >= CURRENT_HOST_URL_RETRY_MAX_COUNT) {
        break;
      }
      this.mGetUrlCount += 1;
      this.mCurrentHostUrlRetryCount += 1;
      Map localMap = getQueryParams();
      TVKLogUtil.i("MediaPlayer[TVKCGIVkeyRequest.java]", "[vinfo][getvkey] start to request, request time = " + this.mCurrentHostUrlRetryCount);
      this.mStartRequestMS = SystemClock.elapsedRealtime();
      TVKVideoInfoHttpProcessor.getInstance().addToRequestQueue(this.mCurrentHostUrlRetryCount, getRequestUrl(), localMap, getHeaders(), this.mGetVkeyCb);
      return;
    }
  }
  
  public void setIsVkeyUseIpv6Dns(boolean paramBoolean)
  {
    this.mIsVkeyUseIpv6Dns = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVkeyRequest
 * JD-Core Version:    0.7.0.1
 */