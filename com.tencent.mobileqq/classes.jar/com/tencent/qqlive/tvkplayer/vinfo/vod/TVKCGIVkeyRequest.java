package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.HttpResponse;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.ITVKHttpCallback;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.InvalidResponseCodeException;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIVkeyResponse;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoConfig;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoEnum;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoHttpProcessor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.w3c.dom.Document;

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
  
  private void checkIfRetry(int paramInt)
  {
    if ((this.mUseBkurl) && (this.mCurrentHostUrlRetryCount == CURRENT_HOST_URL_RETRY_MAX_COUNT))
    {
      paramInt += 1402000;
      invokeVkeyFailureCallback(this.mRequestID, String.format("%d.%d", new Object[] { Integer.valueOf(103), Integer.valueOf(paramInt) }), paramInt);
      return;
    }
    executeRequest();
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
    int[] tmp90_88 = arrayOfInt;
    tmp90_88[0] = 0;
    int[] tmp94_90 = tmp90_88;
    tmp94_90[1] = 0;
    int[] tmp98_94 = tmp94_90;
    tmp98_94[2] = 0;
    tmp98_94;
    if (paramTVKCGIVKeyRequestParams.getRequestType() == 0) {
      tmp90_88[0] = 0;
    } else {
      tmp90_88[0] = 4;
    }
    if (localMap != null) {
      if ((localMap.containsKey("toushe")) && (localMap.containsKey("from_platform")))
      {
        tmp90_88[0] = 16;
        tmp90_88[1] = TVKUtils.optInt((String)localMap.get("from_platform"), j);
      }
      else if (localMap.containsKey("sptest"))
      {
        tmp90_88[0] = 64;
      }
      else if (localMap.containsKey("ottflag"))
      {
        tmp90_88[2] = TVKUtils.optInt((String)localMap.get("ottflag"), 0);
      }
    }
    return CKeyFacade.getCKey(str4, l, str2, str3, String.valueOf(j), str1, tmp90_88, tmp90_88.length, "");
  }
  
  private Map<String, String> getHeaders()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("User-Agent", "qqlive");
    Object localObject = this.mParams;
    if ((localObject != null) && (!TextUtils.isEmpty(((TVKCGIVKeyRequestParams)localObject).getLoginCookie())))
    {
      localHashMap.put("Cookie", this.mParams.getLoginCookie());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[vinfo][getvkey]cookie:");
      ((StringBuilder)localObject).append(this.mParams.getLoginCookie());
      TVKLogUtil.i("MediaPlayer[TVKCGIVkeyRequest.java]", ((StringBuilder)localObject).toString());
    }
    return localHashMap;
  }
  
  private Map<String, String> getQueryParams()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("vid", this.mParams.getVid());
    localHashMap.put("vt", this.mParams.getVt());
    int i;
    int j;
    if (this.mParams.getVkeyType() == 0)
    {
      i = this.mParams.getStartClipNo();
      j = this.mParams.getEndClipNo();
      localObject1 = new StringBuilder(Integer.toString(i));
      i += 1;
      while (i <= j)
      {
        ((StringBuilder)localObject1).append("|");
        ((StringBuilder)localObject1).append(String.valueOf(i));
        i += 1;
      }
      localHashMap.put("idx", ((StringBuilder)localObject1).toString());
    }
    else
    {
      localHashMap.put("filename", this.mParams.getFileName());
    }
    localHashMap.put("platform", String.valueOf(this.mParams.getPlatForm()));
    localHashMap.put("appVer", this.mParams.getAppVer());
    localHashMap.put("sdtfrom", this.mParams.getSdtFrom());
    localHashMap.put("format", this.mParams.getFormat());
    Object localObject2;
    if (!TextUtils.isEmpty(this.mParams.getUpc()))
    {
      if (this.mParams.getUpc().contains("&"))
      {
        localObject1 = this.mParams.getUpc().split("&");
      }
      else
      {
        localObject1 = new String[1];
        localObject1[0] = this.mParams.getUpc();
      }
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i].split("=");
        if (localObject2.length == 2) {
          localHashMap.put(localObject2[0], localObject2[1]);
        } else if (localObject2.length == 1) {
          localHashMap.put(localObject2[0], "");
        }
        i += 1;
      }
      localHashMap.put("path", this.mParams.getUpcPaths());
      localHashMap.put("spip", this.mParams.getUpcSPIPs());
      localHashMap.put("spport", this.mParams.getUpcSPPORTs());
    }
    localHashMap.put("newnettype", String.valueOf(this.mParams.getNetworkType()));
    localHashMap.put("qqlog", this.mParams.getLoginQQ());
    if (65 == this.mParams.getEncryptVer()) {
      localObject1 = "4.1";
    } else if (66 == this.mParams.getEncryptVer()) {
      localObject1 = "4.2";
    } else {
      localObject1 = "5.1";
    }
    localHashMap.put("encryptVer", localObject1);
    localHashMap.put("cKey", genCkey(this.mParams));
    localHashMap.put("lnk", this.mParams.getLnk());
    localHashMap.put("linkver", String.valueOf(2));
    if (!TextUtils.isEmpty(this.mParams.getWxOpenId())) {
      localHashMap.put("openid", this.mParams.getWxOpenId());
    }
    Object localObject1 = this.mParams.getExtraParamsMap();
    if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localHashMap.put(((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
      }
    }
    return localHashMap;
  }
  
  private String getRequestUrl()
  {
    String str1;
    if (this.mParams.isUseIpV6Dns()) {
      str1 = TVKVideoInfoEnum.VBKEY_V6_SERVER_NEW;
    } else if (this.mUseBkurl) {
      str1 = TVKVideoInfoEnum.VBKEY_BK_SERVER_NEW;
    } else {
      str1 = TVKVideoInfoEnum.VBKEY_SERVER_NEW;
    }
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
  }
  
  private void handleGetVkeyFailure(IOException paramIOException)
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.mStartRequestMS;
    int i;
    if ((paramIOException instanceof ITVKHttpProcessor.InvalidResponseCodeException)) {
      i = ((ITVKHttpProcessor.InvalidResponseCodeException)paramIOException).responseCode;
    } else {
      i = TVKVideoInfoErrorCodeUtil.getErrCodeByThrowable(paramIOException.getCause());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[vinfo][getvkey] failed, time cost:");
    localStringBuilder.append(l1 - l2);
    localStringBuilder.append("ms error:");
    localStringBuilder.append(paramIOException.toString());
    TVKLogUtil.e("MediaPlayer[TVKCGIVkeyRequest.java]", localStringBuilder.toString());
    if ((this.mUseBkurl) && (this.mCurrentHostUrlRetryCount == CURRENT_HOST_URL_RETRY_MAX_COUNT))
    {
      paramIOException = this.mCallback;
      if (paramIOException != null)
      {
        int j = 1402000 + i;
        paramIOException.onVkeyFailure(this.mRequestID, String.format("%d.%d", new Object[] { Integer.valueOf(103), Integer.valueOf(j) }), j);
      }
    }
    if ((i >= 16) && (i <= 20)) {
      this.mRetryWithoutHttps = true;
    }
    executeRequest();
  }
  
  private void handleGetVkeySuccess(ITVKHttpProcessor.HttpResponse paramHttpResponse)
  {
    paramHttpResponse = new String(paramHttpResponse.mData);
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.mStartRequestMS;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[vinfo][getvkey] success timecost:");
    localStringBuilder.append(l1 - l2);
    localStringBuilder.append(" xml:");
    localStringBuilder.append(paramHttpResponse);
    TVKLogUtil.i("MediaPlayer[TVKCGIVkeyRequest.java]", localStringBuilder.toString());
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
        if ((this.mCgiRetryCount <= 2) && ((paramHttpResponse.isXML85ErrorCode()) || (paramHttpResponse.isXMLHaveRetryNode())))
        {
          this.mCgiRetryCount += 1;
          paramHttpResponse = new StringBuilder();
          paramHttpResponse.append("[vinfo][getvkey] 85 error code, retry time");
          paramHttpResponse.append(this.mCgiRetryCount);
          TVKLogUtil.e("MediaPlayer[TVKCGIVkeyRequest.java]", paramHttpResponse.toString());
          this.mGetUrlCount -= 1;
          this.mCurrentHostUrlRetryCount -= 1;
          if (this.mCgiRetryCount == 2)
          {
            this.mUseBkurl ^= true;
            this.mCurrentHostUrlRetryCount = 0;
          }
          executeRequest();
          return;
        }
        invokeVkeySucessCallback(this.mRequestID, paramHttpResponse.getXml(), paramHttpResponse.getDocument());
        return;
      }
      TVKLogUtil.e("MediaPlayer[TVKCGIVkeyRequest.java]", "[vinfo][getkey] xml parse error");
      checkIfRetry(15);
      return;
    }
    TVKLogUtil.e("MediaPlayer[TVKCGIVkeyRequest.java]", "[vinfo][getvkey] response not xml");
    checkIfRetry(13);
  }
  
  private void invokeVkeyFailureCallback(String paramString1, String paramString2, int paramInt)
  {
    ITVKCGIVkeyResponse localITVKCGIVkeyResponse = this.mCallback;
    if (localITVKCGIVkeyResponse != null) {
      localITVKCGIVkeyResponse.onVkeyFailure(paramString1, paramString2, paramInt);
    }
  }
  
  private void invokeVkeySucessCallback(String paramString1, String paramString2, Document paramDocument)
  {
    ITVKCGIVkeyResponse localITVKCGIVkeyResponse = this.mCallback;
    if (localITVKCGIVkeyResponse != null) {
      localITVKCGIVkeyResponse.onVkeySuccess(paramString1, paramString2, paramDocument);
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
    boolean bool = this.mUseBkurl;
    if ((!bool) && (this.mCurrentHostUrlRetryCount == CURRENT_HOST_URL_RETRY_MAX_COUNT))
    {
      this.mUseBkurl = (bool ^ true);
      this.mCurrentHostUrlRetryCount = 0;
    }
    int i = this.mCurrentHostUrlRetryCount;
    if (i < CURRENT_HOST_URL_RETRY_MAX_COUNT)
    {
      this.mGetUrlCount += 1;
      this.mCurrentHostUrlRetryCount = (i + 1);
      Map localMap = getQueryParams();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[vinfo][getvkey] start to request, request time = ");
      localStringBuilder.append(this.mCurrentHostUrlRetryCount);
      TVKLogUtil.i("MediaPlayer[TVKCGIVkeyRequest.java]", localStringBuilder.toString());
      this.mStartRequestMS = SystemClock.elapsedRealtime();
      TVKVideoInfoHttpProcessor.getInstance().addToRequestQueue(this.mCurrentHostUrlRetryCount, getRequestUrl(), localMap, getHeaders(), this.mGetVkeyCb);
    }
  }
  
  public void setIsVkeyUseIpv6Dns(boolean paramBoolean)
  {
    this.mIsVkeyUseIpv6Dns = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVkeyRequest
 * JD-Core Version:    0.7.0.1
 */