package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.TVideoMgr;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.HttpResponse;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.ITVKHttpCallback;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.InvalidResponseCodeException;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIVInfoResponse;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.RSAUtils;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoConfig;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoEnum;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoHttpProcessor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;

public class TVKCGIVInfoRequest
{
  private static final int CGI_RETRY_MAX_COUNT = 2;
  private static int CURRENT_HOST_URL_RETRY_MAX_COUNT = TVKVideoInfoConfig.getInstance().getCgiRetryTime();
  private static final String ENCRYPT_VER_4 = "4.1";
  private static final String ENCRYPT_VER_4_2 = "4.2";
  private static final String ENCRYPT_VER_5 = "5.1";
  private static final String TAG = "MediaPlayerMgr[TVKCGIVInfoRequest.java]";
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
  
  private void callbackOnFailureOrRetry(int paramInt)
  {
    if ((this.mUseBakUrl) && (this.mCurrentHostUrlRetryCount == CURRENT_HOST_URL_RETRY_MAX_COUNT))
    {
      ITVKCGIVInfoResponse localITVKCGIVInfoResponse = this.mCallback;
      if (localITVKCGIVInfoResponse != null)
      {
        paramInt += 1401000;
        localITVKCGIVInfoResponse.onVInfoFailure(this.mRequestID, String.format("%d.%d", new Object[] { Integer.valueOf(101), Integer.valueOf(paramInt) }), paramInt);
        return;
      }
    }
    executeRequest();
  }
  
  private void fillClipAndDtypeParams(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      TVKCGIVInfoRequestParams localTVKCGIVInfoRequestParams = this.mParams;
      if (localTVKCGIVInfoRequestParams == null) {
        return;
      }
      if (localTVKCGIVInfoRequestParams.getDlType() == 0)
      {
        paramMap.put("clip", "0");
        paramMap.put("dtype", "3");
        return;
      }
      if (this.mParams.getDlType() == 4)
      {
        paramMap.put("clip", "2");
        paramMap.put("dtype", "1");
        return;
      }
      if (this.mParams.getDlType() == 5)
      {
        paramMap.put("clip", "3");
        paramMap.put("dtype", "1");
        return;
      }
      if (this.mParams.getDlType() == 1)
      {
        paramMap.put("clip", "4");
        paramMap.put("dtype", "1");
        return;
      }
      if (this.mParams.getDlType() == 3)
      {
        paramMap.put("clip", "0");
        paramMap.put("dtype", "3");
        return;
      }
      paramMap.put("clip", "0");
      paramMap.put("dtype", String.valueOf(this.mParams.getDlType()));
    }
  }
  
  private void fillEncryptVerParam(Map<String, String> paramMap)
  {
    if (65 == this.mParams.getEncrypVer())
    {
      paramMap.put("encryptVer", "4.1");
      return;
    }
    if (66 == this.mParams.getEncrypVer())
    {
      paramMap.put("encryptVer", "4.2");
      return;
    }
    paramMap.put("encryptVer", "5.1");
  }
  
  private void fillUpcParam(Map<String, String> paramMap)
  {
    if (!TextUtils.isEmpty(this.mParams.getUpc()))
    {
      String[] arrayOfString1;
      if (this.mParams.getUpc().contains("&"))
      {
        arrayOfString1 = this.mParams.getUpc().split("&");
      }
      else
      {
        arrayOfString1 = new String[1];
        arrayOfString1[0] = this.mParams.getUpc();
      }
      int j = arrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString2 = arrayOfString1[i].split("=");
        if (arrayOfString2.length == 2) {
          paramMap.put(arrayOfString2[0], arrayOfString2[1]);
        } else if (arrayOfString2.length == 1) {
          paramMap.put(arrayOfString2[0], "");
        }
        i += 1;
      }
    }
  }
  
  private int findAppDrmType(Map<String, String> paramMap)
  {
    int j = 0;
    int i = j;
    if (paramMap != null)
    {
      i = j;
      if (!paramMap.isEmpty())
      {
        Iterator localIterator = paramMap.entrySet().iterator();
        i = 0;
        for (;;)
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          i = j;
          if (localEntry != null)
          {
            i = j;
            try
            {
              if (localEntry.getKey() != null) {
                if (localEntry.getValue() == null)
                {
                  i = j;
                }
                else if (((String)localEntry.getKey()).equalsIgnoreCase("drm"))
                {
                  i = TVKUtils.optInt((String)localEntry.getValue(), 0);
                }
                else
                {
                  paramMap.put(localEntry.getKey(), localEntry.getValue());
                  i = j;
                }
              }
            }
            catch (Throwable localThrowable)
            {
              TVKLogUtil.e("MediaPlayerMgr[TVKCGIVInfoRequest.java]", localThrowable, "packRequestParams failed");
              i = j;
            }
          }
        }
        i = j;
      }
    }
    return i;
  }
  
  private String genCkey(TVKCGIVInfoRequestParams paramTVKCGIVInfoRequestParams, Map<String, String> paramMap)
  {
    int i = paramTVKCGIVInfoRequestParams.getEncrypVer();
    int j = paramTVKCGIVInfoRequestParams.getPlatForm();
    String str1 = paramTVKCGIVInfoRequestParams.getSdtFrom();
    Object localObject = paramTVKCGIVInfoRequestParams.getVid();
    String str2 = paramTVKCGIVInfoRequestParams.getAppVer();
    paramTVKCGIVInfoRequestParams.getFd();
    String str3 = paramTVKCGIVInfoRequestParams.getGuid();
    if ((paramMap != null) && (paramMap.containsKey("previd")) && (!TextUtils.isEmpty((CharSequence)paramMap.get("previd")))) {
      paramMap = RSAUtils.getNewVid((String)paramMap.get("previd"));
    } else {
      paramMap = (Map<String, String>)localObject;
    }
    long l1 = TVKVideoInfoCheckTime.mServerTime;
    long l2 = (SystemClock.elapsedRealtime() - TVKVideoInfoCheckTime.mElapsedRealTime) / 1000L;
    localObject = paramTVKCGIVInfoRequestParams.getCkeyExtraParamsMap();
    int[] arrayOfInt = new int[3];
    int[] tmp127_125 = arrayOfInt;
    tmp127_125[0] = 0;
    int[] tmp131_127 = tmp127_125;
    tmp131_127[1] = 0;
    int[] tmp135_131 = tmp131_127;
    tmp135_131[2] = 0;
    tmp135_131;
    if (paramTVKCGIVInfoRequestParams.getRequestType() == 0) {
      tmp131_127[0] = 0;
    } else {
      tmp131_127[0] = 4;
    }
    if (localObject != null) {
      if ((((Map)localObject).containsKey("toushe")) && (((Map)localObject).containsKey("from_platform")))
      {
        tmp131_127[0] = 16;
        tmp131_127[1] = TVKUtils.optInt((String)((Map)localObject).get("from_platform"), j);
      }
      else if (((Map)localObject).containsKey("sptest"))
      {
        tmp131_127[0] = 64;
      }
      else if (((Map)localObject).containsKey("ottflag"))
      {
        tmp131_127[2] = TVKUtils.optInt((String)((Map)localObject).get("ottflag"), 0);
      }
      else if (((Map)localObject).containsKey("dlna"))
      {
        tmp131_127[0] = 1;
      }
    }
    this.mCKey = CKeyFacade.getCKey(tmp127_125, l1 + l2, paramMap, str2, String.valueOf(j), str1, tmp131_127, tmp131_127.length, "");
    paramTVKCGIVInfoRequestParams = new StringBuilder();
    paramTVKCGIVInfoRequestParams.append("[vinfo][getvinfo] GenCkey appVer = ");
    paramTVKCGIVInfoRequestParams.append(TVideoMgr.getPlayerVersion());
    paramTVKCGIVInfoRequestParams.append(" vid = ");
    paramTVKCGIVInfoRequestParams.append(paramMap);
    paramTVKCGIVInfoRequestParams.append(" encryptVer = ");
    paramTVKCGIVInfoRequestParams.append(i);
    paramTVKCGIVInfoRequestParams.append(" platform= ");
    paramTVKCGIVInfoRequestParams.append(j);
    paramTVKCGIVInfoRequestParams.append(" ckey= ");
    paramTVKCGIVInfoRequestParams.append(this.mCKey);
    TVKLogUtil.i("MediaPlayerMgr[TVKCGIVInfoRequest.java]", paramTVKCGIVInfoRequestParams.toString());
    return this.mCKey;
  }
  
  private Map<String, String> getHeaders()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("User-Agent", "qqlive");
    if (this.mParams.useIpV6Dns()) {
      localHashMap.put("Host", TVKVideoInfoEnum.VINFO_IPV6_HOST);
    } else if (this.mUseBakUrl) {
      localHashMap.put("Host", TVKVideoInfoEnum.VINFO_BK_HOST);
    } else {
      localHashMap.put("Host", TVKVideoInfoEnum.VINFO_HOST);
    }
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
    if (this.mParams.useIpV6Dns())
    {
      localObject1 = TVKVideoInfoEnum.VINFO_IPV6_SERVER;
      localObject3 = TVKVideoInfoEnum.VINFO_IPV6_HOST;
    }
    else if (this.mUseBakUrl)
    {
      localObject1 = TVKVideoInfoEnum.VINFO_BK_SERVER;
      localObject3 = TVKVideoInfoEnum.VINFO_BK_HOST;
    }
    else
    {
      localObject1 = TVKVideoInfoEnum.VINFO_SERVER;
      localObject3 = TVKVideoInfoEnum.VINFO_HOST;
    }
    Object localObject2 = localObject1;
    if (this.mParams.useIpV6Dns())
    {
      localObject2 = localObject1;
      if (!TVKVideoInfoCache.getInstance().isIpv6Error())
      {
        localObject2 = new TVKVideoInfoDnsQuery((String)localObject3);
        ((TVKVideoInfoDnsQuery)localObject2).start();
      }
    }
    try
    {
      ((TVKVideoInfoDnsQuery)localObject2).join(2000L);
    }
    catch (Exception localException)
    {
      label93:
      break label93;
    }
    TVKLogUtil.e("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "DNS Exception");
    Object localObject3 = ((TVKVideoInfoDnsQuery)localObject2).getDnsIpv6();
    localObject2 = localObject1;
    if (((ArrayList)localObject3).size() > 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("http://[");
      ((StringBuilder)localObject1).append((String)((ArrayList)localObject3).get(0));
      ((StringBuilder)localObject1).append("]/getvinfo");
      localObject2 = ((StringBuilder)localObject1).toString();
    }
    Object localObject1 = localObject2;
    if (!this.mRetryWithoutHttps) {
      if (!TVKVideoInfoConfig.getInstance().isEnableHttps())
      {
        localObject1 = localObject2;
        if (!TVKVideoInfoConfig.getInstance().isVinfoEnableHttps()) {}
      }
      else
      {
        localObject1 = ((String)localObject2).replaceFirst("http", "https");
      }
    }
    return localObject1;
  }
  
  private void handleHttpCallbackOnFailure(IOException paramIOException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getvinfo onFailure, e:");
    localStringBuilder.append(paramIOException.toString());
    TVKLogUtil.i("MediaPlayerMgr[TVKCGIVInfoRequest.java]", localStringBuilder.toString());
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.mStartRequestMS;
    int i;
    if ((paramIOException instanceof ITVKHttpProcessor.InvalidResponseCodeException)) {
      i = ((ITVKHttpProcessor.InvalidResponseCodeException)paramIOException).responseCode;
    } else {
      i = TVKVideoInfoErrorCodeUtil.getErrCodeByThrowable(paramIOException.getCause());
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[vinfo][getvinfo] failed, time cost:");
    localStringBuilder.append(l1 - l2);
    localStringBuilder.append("ms error:");
    localStringBuilder.append(paramIOException.toString());
    TVKLogUtil.e("MediaPlayerMgr[TVKCGIVInfoRequest.java]", localStringBuilder.toString());
    if ((this.mUseBakUrl) && (this.mCurrentHostUrlRetryCount == CURRENT_HOST_URL_RETRY_MAX_COUNT))
    {
      paramIOException = this.mCallback;
      if (paramIOException != null)
      {
        int j = 1401000 + i;
        paramIOException.onVInfoFailure(this.mRequestID, String.format("%d.%d", new Object[] { Integer.valueOf(101), Integer.valueOf(j) }), j);
      }
    }
    if ((i >= 16) && (i <= 20)) {
      this.mRetryWithoutHttps = true;
    }
    if (this.mParams.useIpV6Dns()) {
      TVKVideoInfoCache.getInstance().setIpv6Error(true);
    }
    executeRequest();
  }
  
  private void handleHttpCallbackOnSuccess(ITVKHttpProcessor.HttpResponse paramHttpResponse)
  {
    TVKLogUtil.i("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "getvinfo onSuccess.");
    try
    {
      boolean bool = paramHttpResponse.mHeaders.containsKey("Content-Encoding");
      if ((bool) && (((List)paramHttpResponse.mHeaders.get("Content-Encoding")).contains("gzip")))
      {
        paramHttpResponse = TVKUtils.gzipDeCompress(paramHttpResponse.mData);
        if (paramHttpResponse != null) {
          paramHttpResponse = new String(paramHttpResponse, "UTF-8");
        } else {
          paramHttpResponse = "";
        }
      }
      else
      {
        paramHttpResponse = new String(paramHttpResponse.mData, "UTF-8");
      }
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.mStartRequestMS;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[vinfo][getvinfo] success time cost:");
      ((StringBuilder)localObject).append(l1 - l2);
      ((StringBuilder)localObject).append(" xml:");
      ((StringBuilder)localObject).append(paramHttpResponse);
      TVKLogUtil.i("MediaPlayerMgr[TVKCGIVInfoRequest.java]", ((StringBuilder)localObject).toString());
      if (!paramHttpResponse.contains("<?xml"))
      {
        this.mRetryWithoutHttps = false;
        executeRequest();
        return;
      }
      if (!TextUtils.isEmpty(paramHttpResponse))
      {
        paramHttpResponse = new TVKCGIParser(paramHttpResponse);
        if (paramHttpResponse.init())
        {
          if ((this.mCGIRetryCount <= 2) && ((paramHttpResponse.isXML85ErrorCode()) || (paramHttpResponse.isXMLHaveRetryNode())))
          {
            TVKLogUtil.i("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] cgi return retry or 85 error");
            this.mCGIRetryCount += 1;
            this.mCurrentHostUrlRetryCount -= 1;
            this.mGetUrlCount -= 1;
            if (this.mCGIRetryCount == 2)
            {
              this.mUseBakUrl ^= true;
              this.mCurrentHostUrlRetryCount = 0;
            }
            executeRequest();
            return;
          }
          localObject = this.mCallback;
          if (localObject != null) {
            ((ITVKCGIVInfoResponse)localObject).onVInfoSuccess(this.mRequestID, paramHttpResponse.getXml(), paramHttpResponse.getDocument());
          }
        }
        else
        {
          TVKLogUtil.e("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] xml parse error");
          callbackOnFailureOrRetry(15);
        }
      }
      else
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] return xml error!");
        callbackOnFailureOrRetry(13);
      }
      return;
    }
    catch (Exception paramHttpResponse)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKCGIVInfoRequest.java]", paramHttpResponse);
      callbackOnFailureOrRetry(23);
    }
  }
  
  private Map<String, String> packRequestParams()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("vid", this.mParams.getVid());
    localHashMap.put("charge", String.valueOf(this.mParams.isCharge()));
    localHashMap.put("platform", String.valueOf(this.mParams.getPlatForm()));
    localHashMap.put("sdtfrom", this.mParams.getSdtFrom());
    localHashMap.put("fhdswitch", "0");
    localHashMap.put("sphls", "1");
    localHashMap.put("defn", this.mParams.getFormat());
    localHashMap.put("ipstack", String.valueOf(this.mParams.getipstack()));
    fillClipAndDtypeParams(localHashMap);
    if ((this.mParams.getDlType() == 0) || (this.mParams.getDlType() == 3))
    {
      if ((this.mParams.getCkeyExtraParamsMap() != null) && (!this.mParams.getCkeyExtraParamsMap().isEmpty())) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        localHashMap.put("sphls", "2");
        localHashMap.put("spgzip", "1");
      }
    }
    if (this.mParams.getPlayerCapacity() > 0) {
      localHashMap.put("device", String.valueOf(this.mParams.getPlayerCapacity()));
    }
    if (this.mParams.getAppVer() != null) {
      localHashMap.put("appVer", this.mParams.getAppVer());
    }
    fillEncryptVerParam(localHashMap);
    fillUpcParam(localHashMap);
    Map localMap = this.mParams.getExtraParamsMap();
    int i = findAppDrmType(localMap);
    localHashMap.put("drm", String.valueOf(this.mParams.getDrm() + i));
    localHashMap.put("cKey", genCkey(this.mParams, localMap));
    localHashMap.put("newnettype", String.valueOf(this.mParams.getNetworkType()));
    localHashMap.put("otype", "xml");
    if (!TextUtils.isEmpty(this.mParams.getWxOpenId())) {
      localHashMap.put("openid", this.mParams.getWxOpenId());
    }
    localHashMap.put("spwm", "1");
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
    boolean bool = this.mUseBakUrl;
    if ((!bool) && (this.mCurrentHostUrlRetryCount == CURRENT_HOST_URL_RETRY_MAX_COUNT))
    {
      this.mUseBakUrl = (bool ^ true);
      this.mCurrentHostUrlRetryCount = 0;
    }
    int i = this.mCurrentHostUrlRetryCount;
    if (i < CURRENT_HOST_URL_RETRY_MAX_COUNT)
    {
      this.mGetUrlCount += 1;
      this.mCurrentHostUrlRetryCount = (i + 1);
      Map localMap = packRequestParams();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[vinfo][getvinfo] start to request, request time:");
      localStringBuilder.append(this.mCurrentHostUrlRetryCount);
      TVKLogUtil.i("MediaPlayerMgr[TVKCGIVInfoRequest.java]", localStringBuilder.toString());
      this.mStartRequestMS = SystemClock.elapsedRealtime();
      TVKVideoInfoHttpProcessor.getInstance().addToRequestQueue(this.mCurrentHostUrlRetryCount, getRequestUrl(), localMap, getHeaders(), this.mGetVinfoCb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVInfoRequest
 * JD-Core Version:    0.7.0.1
 */