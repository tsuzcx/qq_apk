package com.tencent.thumbplayer.tplayer.plugins.report;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.os.Message;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.TPDefaultReportInfo;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.thumbplayer.tplayer.plugins.ITPPluginBase;
import com.tencent.thumbplayer.utils.TPCommonUtils;
import com.tencent.thumbplayer.utils.TPDiskReadWrite;
import com.tencent.thumbplayer.utils.TPGlobalEventNofication;
import com.tencent.thumbplayer.utils.TPGlobalEventNofication.OnGlobalEventChangeListener;
import com.tencent.thumbplayer.utils.TPHashMapBuilder;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPProperties;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import org.json.JSONObject;

public class TPReportManager
  implements ITPBusinessReportManager, ITPPluginBase
{
  private static final boolean APP_STATE_BACKGROUND = false;
  private static final boolean APP_STATE_FOREGROUND = true;
  private static final int BUFFERING_DURATION_THRESHOLD_MS = 1200;
  private static final int DEVICE_TYPE_AN_PAD = 5;
  private static final int DEVICE_TYPE_AN_PHONE = 2;
  private static final int DEVICE_TYPE_AN_TV = 9;
  private static final String LIVE_HLS_M3U8_TAG_PREFIX = "#EXT-X-PROGRAM-DATE-TIME:";
  private static final int LIVE_REPORT_PERIOD = 60000;
  private static final int MAX_BUFFERING_REPORT_COUNT = 20;
  private static final int MAX_SEEK_REPORT_COUNT = 20;
  private static final String PROXY_HITDOWNLOADED_KEY = "hitDownloaded";
  private static final String REPORT_DATA_CACHE_NAME = "TPReportCache";
  private static final String TAG = "TPReportManager";
  private static final int VOD_HIT_DOWNLOADED_UNSET = -1;
  private static boolean hasReportLastEvent = false;
  private static TPDiskReadWrite mCache;
  private boolean mAppState = true;
  private Context mContext;
  private TPReportParams.BufferingOnceParams mCurBufferingParams = null;
  private TPReportParams.UserSeekOnceParams mCurSeekParams = null;
  private int mDownloadType = 0;
  private String mErrorCode = "0";
  private TPReportManager.EventHandler mEventHandler;
  private String mFlowId = "";
  private TPGlobalEventNofication.OnGlobalEventChangeListener mGlobalEventListener = new TPReportManager.2(this);
  private boolean mIsBuffering = false;
  private boolean mIsLoadingSubtitle = false;
  private boolean mIsPlayDone = true;
  private boolean mIsPrepare = false;
  private boolean mIsSeeking = false;
  private boolean mIsUseP2P = false;
  private int mLastEvent = 0;
  private Looper mLooper;
  private long mMediaDurationMs = 0L;
  private int mMediaRate = 0;
  private String mMediaResolution = "";
  private int mNetworkSpeed = 0;
  private final TPReportManager.ParamRecord mParamRecord = new TPReportManager.ParamRecord(this, null);
  private long mPlayDurationMs = 0L;
  private int mPlayScene = 1;
  private long mPlayStartTimeMs = 0L;
  private int mPlayType = -1;
  private int mPlayerType = 0;
  private String mProto = "";
  private String mProtoVer = "";
  private TPReportManager.IReportHandler mReportHandler = new TPReportManager.DefaultReportHandler(this);
  private TPDefaultReportInfo mReportInfoGetter = null;
  private TPReportParams mReportParams = null;
  private int mSeekBufferingCount = 0;
  private int mSeekBufferingDuration = 0;
  private int mSignalStrength = 81;
  
  public TPReportManager(Context paramContext, Looper paramLooper)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mLooper = paramLooper;
  }
  
  private String getDeviceResolution()
  {
    Object localObject = this.mContext;
    if (localObject == null) {
      return "0";
    }
    int i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels;
    int j = this.mContext.getResources().getDisplayMetrics().heightPixels;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append("*");
    ((StringBuilder)localObject).append(i);
    return ((StringBuilder)localObject).toString();
  }
  
  private int getDeviceType()
  {
    UiModeManager localUiModeManager = (UiModeManager)this.mContext.getSystemService("uimode");
    if (localUiModeManager == null) {
      return 2;
    }
    if (localUiModeManager.getCurrentModeType() == 4) {
      return 9;
    }
    if ((this.mContext.getResources().getConfiguration().screenLayout & 0xF) >= 3) {
      return 5;
    }
    return 2;
  }
  
  private void getHitDownloadedInfo(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if ((paramString.has("hitDownloaded")) && (this.mParamRecord.hitDownloaded == -1))
      {
        this.mParamRecord.hitDownloaded = paramString.getInt("hitDownloaded");
        return;
      }
    }
    catch (Exception paramString)
    {
      TPLogUtil.e("TPReportManager", paramString);
    }
  }
  
  private boolean getMapValueBool(Map<String, Object> paramMap, String paramString, boolean paramBoolean)
  {
    if (paramMap == null) {
      return paramBoolean;
    }
    paramMap = paramMap.get(paramString);
    if (paramMap != null) {
      paramBoolean = ((Boolean)paramMap).booleanValue();
    }
    return paramBoolean;
  }
  
  private float getMapValueFloat(Map<String, Object> paramMap, String paramString, float paramFloat)
  {
    if (paramMap == null) {
      return paramFloat;
    }
    paramMap = paramMap.get(paramString);
    if (paramMap != null) {
      paramFloat = ((Float)paramMap).floatValue();
    }
    return paramFloat;
  }
  
  private int getMapValueInteger(Map<String, Object> paramMap, String paramString, int paramInt)
  {
    if (paramMap == null) {
      return paramInt;
    }
    paramMap = paramMap.get(paramString);
    if (paramMap != null) {
      paramInt = ((Integer)paramMap).intValue();
    }
    return paramInt;
  }
  
  private long getMapValueLong(Map<String, Object> paramMap, String paramString, long paramLong)
  {
    if (paramMap == null) {
      return paramLong;
    }
    paramMap = paramMap.get(paramString);
    if (paramMap != null) {
      paramLong = ((Long)paramMap).longValue();
    }
    return paramLong;
  }
  
  private String getMapValueString(Map<String, Object> paramMap, String paramString1, String paramString2)
  {
    if (paramMap == null) {
      return paramString2;
    }
    paramMap = paramMap.get(paramString1);
    if (paramMap != null) {
      paramString2 = (String)paramMap;
    }
    return paramString2;
  }
  
  private int getMobileSubType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 13: 
      return 4;
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
      return 3;
    }
    return 2;
  }
  
  @SuppressLint({"MissingPermission"})
  private int getNetWorkType()
  {
    Object localObject = this.mContext;
    if (localObject == null) {
      return 0;
    }
    try
    {
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
        {
          int i = ((NetworkInfo)localObject).getType();
          if (i != 0)
          {
            if (i == 1) {
              break label87;
            }
            if (i == 9) {
              break label84;
            }
            return 0;
          }
          i = getMobileSubType(((NetworkInfo)localObject).getSubtype());
          return i;
        }
      }
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPReportManager", localException);
    }
    return 0;
    label84:
    return 10;
    label87:
    return 1;
  }
  
  private String getOsVersion()
  {
    return String.format("Android %s", new Object[] { TPSystemInfo.getOsVersion() });
  }
  
  private void handleOnSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    Object localObject = this.mContext;
    if (localObject == null) {
      return;
    }
    localObject = (TelephonyManager)((Context)localObject).getSystemService("phone");
    if (localObject == null)
    {
      TPLogUtil.e("TPReportManager", "getSystemService TELEPHONY_SERVICE err.");
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        String[] arrayOfString = paramSignalStrength.toString().split(" ");
        i = ((TelephonyManager)localObject).getNetworkType();
        int j = 0;
        if ((i == 13) && (arrayOfString.length > 9))
        {
          if (!TPCommonUtils.isNumeric(arrayOfString[9]))
          {
            i = j;
          }
          else
          {
            i = TPCommonUtils.optInt(arrayOfString[9], 0);
            continue;
            i = paramSignalStrength.getGsmSignalStrength() * 2 - 113;
            continue;
            localObject = ((TelephonyManager)localObject).getNetworkOperator();
            i = j;
            if (localObject != null)
            {
              i = j;
              if (!((String)localObject).startsWith("46000"))
              {
                i = j;
                if (!((String)localObject).startsWith("46002")) {
                  if (((String)localObject).startsWith("46007"))
                  {
                    i = j;
                  }
                  else if (((String)localObject).equals("46001"))
                  {
                    i = paramSignalStrength.getCdmaDbm();
                  }
                  else
                  {
                    i = j;
                    if (((String)localObject).equals("46003")) {
                      i = paramSignalStrength.getEvdoDbm();
                    }
                  }
                }
              }
            }
          }
          this.mSignalStrength = i;
          paramSignalStrength = new StringBuilder();
          paramSignalStrength.append("mSignalStrength=");
          paramSignalStrength.append(this.mSignalStrength);
          TPLogUtil.i("TPReportManager", paramSignalStrength.toString());
          return;
        }
      }
      catch (Throwable paramSignalStrength)
      {
        TPLogUtil.e("TPReportManager", paramSignalStrength);
        return;
      }
      if ((i != 8) && (i != 10) && (i != 9)) {
        if (i != 3) {}
      }
    }
  }
  
  private void handleSignalStrength(int paramInt)
  {
    Object localObject = this.mContext;
    if (localObject == null) {
      return;
    }
    localObject = (TelephonyManager)((Context)localObject).getSystemService("phone");
    if (localObject == null)
    {
      TPLogUtil.e("TPReportManager", "getSystemService TELEPHONY_SERVICE err.");
      return;
    }
    TPLogUtil.i("TPReportManager", "EventHandler handleMessage ");
    ((TelephonyManager)localObject).listen(new TPReportManager.1(this), paramInt);
  }
  
  private void handleSignalStrengthRegister()
  {
    handleSignalStrength(256);
  }
  
  private void handleSignalStrengthUnRegister()
  {
    handleSignalStrength(0);
  }
  
  private void init()
  {
    this.mEventHandler = new TPReportManager.EventHandler(this, this.mLooper);
    this.mReportParams = new TPReportParams();
    TPGlobalEventNofication.addEventListener(this.mGlobalEventListener);
    try
    {
      if (mCache == null) {
        mCache = new TPDiskReadWrite(this.mContext, "TPReportCache");
      }
      if (!hasReportLastEvent) {
        this.mEventHandler.obtainMessage(4000).sendToTarget();
      }
      hasReportLastEvent = true;
      return;
    }
    finally {}
  }
  
  private void on302Redirect(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "on302Redirect");
    if (paramMap == null) {
      return;
    }
    TPProperties localTPProperties = new TPProperties();
    TPReportParams.RedirectParams localRedirectParams = this.mReportParams.getRedirectParams();
    localRedirectParams.cdnTypeInt = getMapValueInteger(paramMap, "vt", 0);
    localRedirectParams.redirectCountInt = getMapValueInteger(paramMap, "t302", 0);
    localRedirectParams.redirectedUrlString = getMapValueString(paramMap, "url", "");
    localRedirectParams.starTimeUnix = getMapValueLong(paramMap, "stime", 0L);
    localRedirectParams.endTimeUnix = getMapValueLong(paramMap, "etime", 0L);
    localRedirectParams.errCodeString = getMapValueString(paramMap, "code", "0");
    localRedirectParams.paramsToProperties(localTPProperties);
    this.mReportHandler.handleReportEvent(34, localTPProperties);
  }
  
  private void onAppBackground()
  {
    TPLogUtil.i("TPReportManager", "onAppBackground");
    if ((!this.mIsPlayDone) && (this.mPlayType != 1))
    {
      if (!this.mAppState) {
        return;
      }
      this.mAppState = false;
      TPProperties localTPProperties = new TPProperties();
      this.mReportParams.getBufferingTotalParams().paramsToProperties(localTPProperties);
      this.mReportParams.getUserSeekTotalParams().paramsToProperties(localTPProperties);
      Object localObject = this.mReportParams.getPlayDoneParams();
      ((TPReportParams.PlayDoneParams)localObject).endTimeUnix = System.currentTimeMillis();
      ((TPReportParams.PlayDoneParams)localObject).reasonInt = 2;
      ((TPReportParams.PlayDoneParams)localObject).errCodeString = this.mErrorCode;
      if (this.mParamRecord.startPlayTimeMs > 0L)
      {
        TPReportManager.ParamRecord localParamRecord = this.mParamRecord;
        localParamRecord.playDurationMs += (int)(System.currentTimeMillis() - this.mParamRecord.startPlayTimeMs);
        this.mParamRecord.startPlayTimeMs = 0L;
      }
      if (this.mPlayStartTimeMs > 0L)
      {
        this.mPlayDurationMs += ((TPReportParams.PlayDoneParams)localObject).endTimeUnix - this.mPlayStartTimeMs;
        this.mPlayStartTimeMs = 0L;
      }
      ((TPReportParams.PlayDoneParams)localObject).playDurationFloat = ((float)this.mPlayDurationMs / 1000.0F);
      ((TPReportParams.PlayDoneParams)localObject).paramsToProperties(localTPProperties);
      localObject = this.mReportParams.getCommonParams();
      ((TPReportParams.CommonParams)localObject).stepInt = 50;
      ((TPReportParams.CommonParams)localObject).paramsToProperties(localTPProperties);
      int i = this.mPlayType;
      if (i == 0) {
        updateVodExParam(localTPProperties, false);
      } else if (i == 1) {
        updateLiveExParam(localTPProperties, false);
      }
      if ((mCache != null) && (!TextUtils.isEmpty(this.mFlowId)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Cache report event. mFlowId: ");
        ((StringBuilder)localObject).append(this.mFlowId);
        TPLogUtil.i("TPReportManager", ((StringBuilder)localObject).toString());
        mCache.writeFile(this.mFlowId, localTPProperties.getProperties());
      }
    }
  }
  
  private void onAppForeground()
  {
    TPLogUtil.i("TPReportManager", "onAppForeground");
    if (this.mAppState == true) {
      return;
    }
    this.mAppState = true;
    removeCacheEvent();
  }
  
  private void onBufferingEnd(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onBufferingEnd");
    this.mIsBuffering = false;
    if (!this.mParamRecord.isSwitchingDef) {
      this.mParamRecord.startPlayTimeMs = System.currentTimeMillis();
    }
    if (paramMap == null) {
      return;
    }
    long l = getMapValueLong(paramMap, "etime", System.currentTimeMillis());
    int i = (int)(l - this.mParamRecord.startBufferingTimeMs);
    if (i <= 1200) {
      return;
    }
    if (this.mIsSeeking) {
      return;
    }
    Object localObject = this.mParamRecord;
    ((TPReportManager.ParamRecord)localObject).bufferingCount += 1;
    localObject = this.mParamRecord;
    ((TPReportManager.ParamRecord)localObject).endBufferingTimeMs = l;
    ((TPReportManager.ParamRecord)localObject).bufferingDurationMs += (int)(this.mParamRecord.endBufferingTimeMs - this.mParamRecord.startBufferingTimeMs);
    localObject = this.mCurBufferingParams;
    if (localObject == null) {
      return;
    }
    ((TPReportParams.BufferingOnceParams)localObject).endTimeUnix = getMapValueLong(paramMap, "etime", 0L);
    this.mCurBufferingParams.errCodeString = this.mErrorCode;
    paramMap = this.mReportParams.getBufferingTotalParams();
    paramMap.bufferingCountInt += 1;
    paramMap.bufferingDurationInt += i;
    if (paramMap.bufferingOnceParamsList.size() < 20)
    {
      paramMap.bufferingOnceParamsList.add(this.mCurBufferingParams);
      paramMap = new TPProperties();
      this.mCurBufferingParams.paramsToProperties(paramMap);
      this.mReportHandler.handleReportEvent(35, paramMap);
    }
    this.mCurBufferingParams = null;
  }
  
  private void onBufferingStart(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onBufferingStart");
    if (paramMap == null) {
      return;
    }
    this.mIsBuffering = true;
    if (this.mIsSeeking) {
      return;
    }
    if (this.mParamRecord.startPlayTimeMs > 0L)
    {
      localObject = this.mParamRecord;
      ((TPReportManager.ParamRecord)localObject).playDurationMs += (int)(System.currentTimeMillis() - this.mParamRecord.startPlayTimeMs);
      this.mParamRecord.startPlayTimeMs = 0L;
    }
    this.mParamRecord.startBufferingTimeMs = getMapValueLong(paramMap, "stime", System.currentTimeMillis());
    this.mCurBufferingParams = this.mReportParams.createBufferingOnceParams();
    this.mCurBufferingParams.starTimeUnix = this.mParamRecord.startBufferingTimeMs;
    this.mCurBufferingParams.formatInt = getMapValueInteger(paramMap, "format", 0);
    Object localObject = this.mReportParams.getCommonParams();
    this.mCurBufferingParams.formatInt = ((TPReportParams.CommonParams)localObject).mediaFormatInt;
    this.mCurBufferingParams.reasonInt = getMapValueInteger(paramMap, "reason", 0);
    localObject = this.mCurBufferingParams;
    ((TPReportParams.BufferingOnceParams)localObject).lastEventInt = this.mLastEvent;
    ((TPReportParams.BufferingOnceParams)localObject).sceneInt = this.mPlayScene;
    ((TPReportParams.BufferingOnceParams)localObject).bufferingPresentTimeLong = (getMapValueLong(paramMap, "ptime", 0L) / 1000L);
    this.mCurBufferingParams.urlString = getMapValueString(paramMap, "url", "");
  }
  
  private void onCdnInfoUpdate(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    this.mParamRecord.cdnUrl = getMapValueString(paramMap, "url", "");
    this.mParamRecord.cdnIp = getMapValueString(paramMap, "cdnip", "");
    this.mParamRecord.cdnUip = getMapValueString(paramMap, "cdnuip", "");
    if ((!TextUtils.isEmpty(this.mParamRecord.cdnUrl)) && (this.mParamRecord.cdnUrl.contains("sid=")))
    {
      int i = this.mParamRecord.cdnUrl.indexOf("sid=");
      int j = this.mParamRecord.cdnUrl.indexOf("&", i);
      TPReportManager.ParamRecord localParamRecord = this.mParamRecord;
      if (j > -1) {
        paramMap = localParamRecord.cdnUrl.substring(i + 4, j);
      } else {
        paramMap = localParamRecord.cdnUrl.substring(i + 4);
      }
      localParamRecord.tuid = paramMap;
    }
  }
  
  private void onFirstClipOpen(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    this.mReportParams.getFirstLoadParams().firstOpenTimeUnix = getMapValueLong(paramMap, "stime", System.currentTimeMillis());
  }
  
  private void onFirstPacketRead(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    TPReportParams.LiveExParam localLiveExParam = this.mReportParams.getLiveExParam();
    long l = getMapValueLong(paramMap, "stime", System.currentTimeMillis());
    localLiveExParam.getSyncFrameDurationInt = ((int)(l - this.mParamRecord.startPrepareTimeMs));
    this.mReportParams.getFirstLoadParams().firstPacketReadTimeUnix = l;
  }
  
  private void onGetCdn(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onGetCdn");
    if (paramMap == null) {
      return;
    }
    TPProperties localTPProperties = new TPProperties();
    TPReportParams.GetCdnUrlParams localGetCdnUrlParams = this.mReportParams.getGetCdnParams();
    localGetCdnUrlParams.proxyIpString = getMapValueString(paramMap, "ip", "");
    localGetCdnUrlParams.starTimeUnix = getMapValueLong(paramMap, "stime", 0L);
    localGetCdnUrlParams.endTimeUnix = getMapValueLong(paramMap, "etime", 0L);
    localGetCdnUrlParams.errCodeString = getMapValueString(paramMap, "code", "0");
    localGetCdnUrlParams.paramsToProperties(localTPProperties);
    this.mReportHandler.handleReportEvent(15, localTPProperties);
    if ((!TextUtils.isEmpty(localGetCdnUrlParams.errCodeString)) && (!localGetCdnUrlParams.errCodeString.equals("0")) && (!localGetCdnUrlParams.errCodeString.equals("0.0"))) {
      this.mErrorCode = localGetCdnUrlParams.errCodeString;
    }
  }
  
  private void onHandleHlsTag(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      TPLogUtil.i("TPReportManager", "onHandleHlsTag, tag is null");
      return;
    }
    if (!paramString.startsWith("#EXT-X-PROGRAM-DATE-TIME:"))
    {
      TPLogUtil.i("TPReportManager", "onHandleHlsTag, tag is not start with #EXT-X-PROGRAM-DATE-TIME:");
      return;
    }
    try
    {
      paramString = paramString.substring(25);
      int i = paramString.indexOf('+');
      if (i != -1)
      {
        paramString = paramString.substring(0, i).replace('T', ' ');
      }
      else
      {
        TPLogUtil.i("TPReportManager", "handleOnPlayerPrivaterHlsM3u8Tag , player_m3u8_tag , tag do not contains time zone");
        paramString = paramString.replace('T', ' ');
      }
    }
    catch (Exception paramString)
    {
      TPLogUtil.e("TPReportManager", paramString);
      paramString = "";
    }
    if (TextUtils.isEmpty(paramString))
    {
      TPLogUtil.i("TPReportManager", "onHandleHlsTag , player_m3u8_tag , dataTime is null ");
      return;
    }
    long l2 = 0L;
    try
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramString);
      l1 = l2;
      if (paramString != null) {
        l1 = paramString.getTime();
      }
    }
    catch (Exception paramString)
    {
      TPLogUtil.e("TPReportManager", paramString);
      l1 = l2;
    }
    l2 = System.currentTimeMillis();
    paramString = new StringBuilder();
    paramString.append("onHandleHlsTag , player_m3u8_tag , sysCurTime: ");
    paramString.append(l2);
    paramString.append(", time:");
    paramString.append(l1);
    paramString.append(", delay:");
    long l1 = l2 - l1;
    paramString.append(l1);
    TPLogUtil.i("TPReportManager", paramString.toString());
    this.mParamRecord.liveDelayMs = ((int)l1);
  }
  
  private void onLivePeriodReport()
  {
    TPLogUtil.i("TPReportManager", "onLivePeriodReport");
    TPProperties localTPProperties = new TPProperties();
    this.mReportHandler.handleReportEvent(263, localTPProperties);
  }
  
  private void onLoadSubtitle(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onLoadSubtitle");
    if (paramMap == null) {
      return;
    }
    String str = getMapValueString(paramMap, "name", "");
    paramMap = getMapValueString(paramMap, "url", "");
    this.mParamRecord.subtitleInfos.add(new TPReportManager.SubtitleInfo(this, str, paramMap));
  }
  
  private void onPlayComplete(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onPlayComplete");
    if (paramMap == null) {
      return;
    }
    paramMap.put("reason", Integer.valueOf(0));
    onPlayEnd(paramMap);
  }
  
  private void onPlayEnd(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onPlayEnd");
    if (paramMap != null)
    {
      if (this.mIsPlayDone) {
        return;
      }
      this.mIsPlayDone = true;
      if ((this.mPlayType != 1) && (this.mIsPrepare)) {
        onPrepareDone(new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).build());
      }
      if (this.mIsBuffering) {
        onBufferingEnd(new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).build());
      }
      if (this.mIsSeeking) {
        onSeekComplete(new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).build());
      }
      if (this.mParamRecord.startPlayTimeMs > 0L)
      {
        localObject = this.mParamRecord;
        ((TPReportManager.ParamRecord)localObject).playDurationMs += (int)(System.currentTimeMillis() - this.mParamRecord.startPlayTimeMs);
        this.mParamRecord.startPlayTimeMs = 0L;
      }
      this.mIsSeeking = false;
      Object localObject = new TPProperties();
      this.mReportParams.getBufferingTotalParams().paramsToProperties((ITPReportProperties)localObject);
      this.mReportParams.getBufferingTotalParams().reset();
      this.mReportParams.getUserSeekTotalParams().paramsToProperties((ITPReportProperties)localObject);
      this.mReportParams.getUserSeekTotalParams().reset();
      TPReportParams.PlayDoneParams localPlayDoneParams = this.mReportParams.getPlayDoneParams();
      localPlayDoneParams.endTimeUnix = getMapValueLong(paramMap, "etime", System.currentTimeMillis());
      localPlayDoneParams.reasonInt = getMapValueInteger(paramMap, "reason", 0);
      localPlayDoneParams.errCodeString = this.mErrorCode;
      if (this.mPlayStartTimeMs > 0L)
      {
        this.mPlayDurationMs += localPlayDoneParams.endTimeUnix - this.mPlayStartTimeMs;
        this.mPlayStartTimeMs = 0L;
      }
      localPlayDoneParams.playDurationFloat = ((float)this.mPlayDurationMs / 1000.0F);
      localPlayDoneParams.paramsToProperties((ITPReportProperties)localObject);
      this.mReportHandler.handleReportEvent(50, (ITPReportProperties)localObject);
      this.mErrorCode = "0";
      this.mReportParams.resetAllParam();
      removeCacheEvent();
      resetLocalParam();
    }
  }
  
  private void onPlayerCreateDone(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onPlayerCreateDone");
    if (paramMap == null) {
      return;
    }
    TPProperties localTPProperties = new TPProperties();
    TPReportParams.PlayerInitParams localPlayerInitParams = this.mReportParams.getInitParams();
    localPlayerInitParams.playEndTimeUnix = getMapValueLong(paramMap, "etime", System.currentTimeMillis());
    localPlayerInitParams.errCodeString = this.mErrorCode;
    localPlayerInitParams.paramsToProperties(localTPProperties);
  }
  
  private void onPlayerCreateStart(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onPlayerCreateStart");
    if (paramMap == null) {
      return;
    }
    this.mReportParams.getInitParams().playStarTimeUnix = getMapValueLong(paramMap, "stime", System.currentTimeMillis());
  }
  
  private void onPlayerEarlyError(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(UUID.randomUUID().toString());
    ((StringBuilder)localObject).append(System.nanoTime());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(TPPlayerConfig.getPlatform());
    this.mFlowId = ((StringBuilder)localObject).toString();
    this.mErrorCode = getMapValueString(paramMap, "code", "0");
    localObject = this.mReportInfoGetter;
    if (localObject != null) {
      this.mPlayType = ((TPDefaultReportInfo)localObject).getPlayType();
    }
    if (this.mPlayType == 1)
    {
      paramMap = new TPProperties();
      this.mReportHandler.handleReportEvent(150, paramMap);
      return;
    }
    paramMap.put("reason", Integer.valueOf(3));
    this.mIsPlayDone = false;
    onPlayEnd(paramMap);
  }
  
  private void onPlayerError(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onPlayerError");
    if (paramMap == null) {
      return;
    }
    if (this.mParamRecord.startPlayTimeMs > 0L)
    {
      TPReportManager.ParamRecord localParamRecord = this.mParamRecord;
      localParamRecord.playDurationMs += (int)(System.currentTimeMillis() - this.mParamRecord.startPlayTimeMs);
      this.mParamRecord.startPlayTimeMs = 0L;
    }
    this.mErrorCode = getMapValueString(paramMap, "code", "0");
    if (this.mPlayType == 1)
    {
      paramMap = new TPProperties();
      this.mReportHandler.handleReportEvent(150, paramMap);
      return;
    }
    paramMap.put("reason", Integer.valueOf(3));
    onPlayEnd(paramMap);
  }
  
  private void onPlayerPause(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onPlayerPause");
    if (paramMap == null) {
      return;
    }
    if (this.mPlayStartTimeMs > 0L)
    {
      long l = getMapValueLong(paramMap, "stime", System.currentTimeMillis());
      this.mPlayDurationMs += l - this.mPlayStartTimeMs;
      this.mPlayStartTimeMs = 0L;
    }
    if (this.mParamRecord.startPlayTimeMs > 0L)
    {
      paramMap = this.mParamRecord;
      paramMap.playDurationMs += (int)(System.currentTimeMillis() - this.mParamRecord.startPlayTimeMs);
      this.mParamRecord.startPlayTimeMs = 0L;
    }
  }
  
  private void onPlayerRelease(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onPlayerRelease");
    if (paramMap == null) {
      return;
    }
    paramMap.put("reason", Integer.valueOf(1));
    onPlayEnd(paramMap);
  }
  
  private void onPlayerReset(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onPlayerReset");
    if (paramMap == null) {
      return;
    }
    paramMap.put("reason", Integer.valueOf(1));
    onPlayEnd(paramMap);
  }
  
  private void onPlayerStop(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onPlayerStop");
    if (paramMap == null) {
      return;
    }
    if (this.mPlayStartTimeMs > 0L)
    {
      long l = getMapValueLong(paramMap, "etime", System.currentTimeMillis());
      this.mPlayDurationMs += l - this.mPlayStartTimeMs;
      this.mPlayStartTimeMs = 0L;
    }
    if (this.mParamRecord.startPlayTimeMs > 0L)
    {
      TPReportManager.ParamRecord localParamRecord = this.mParamRecord;
      localParamRecord.playDurationMs += (int)(System.currentTimeMillis() - this.mParamRecord.startPlayTimeMs);
      this.mParamRecord.startPlayTimeMs = 0L;
    }
    paramMap.put("reason", Integer.valueOf(1));
    onPlayEnd(paramMap);
  }
  
  private void onPrepareDone(Map<String, Object> paramMap)
  {
    if (!this.mIsPrepare) {
      return;
    }
    this.mIsPrepare = false;
    TPLogUtil.i("TPReportManager", "onPrepareDone");
    if (paramMap == null) {
      return;
    }
    this.mParamRecord.endPrepareTimeMs = System.currentTimeMillis();
    this.mParamRecord.isMultiTrack = getMapValueBool(paramMap, "multitrack", false);
    TPProperties localTPProperties = new TPProperties();
    if (getMapValueInteger(paramMap, "playertype", 0) == 1) {
      this.mPlayerType = 0;
    } else {
      this.mPlayerType = 1;
    }
    this.mMediaResolution = getMapValueString(paramMap, "definition", "");
    this.mMediaDurationMs = getMapValueLong(paramMap, "duration", 0L);
    this.mMediaRate = ((int)getMapValueLong(paramMap, "rate", 0L));
    Object localObject = getMapValueString(paramMap, "fmt", "");
    if ((localObject != null) && (((String)localObject).contains("hls"))) {
      this.mDownloadType = 3;
    } else {
      this.mDownloadType = 1;
    }
    localObject = this.mReportParams.getFirstLoadParams();
    ((TPReportParams.FirstLoadParams)localObject).endTimeUnix = getMapValueLong(paramMap, "etime", 0L);
    ((TPReportParams.FirstLoadParams)localObject).errCodeString = this.mErrorCode;
    ((TPReportParams.FirstLoadParams)localObject).paramsToProperties(localTPProperties);
    this.mReportHandler.handleReportEvent(30, localTPProperties);
    this.mReportParams.getFirstLoadParams().reset();
  }
  
  private void onProxyInfoUpdate(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    this.mNetworkSpeed = getMapValueInteger(paramMap, "speed", 0);
    Object localObject = this.mParamRecord;
    ((TPReportManager.ParamRecord)localObject).totalSpeed += this.mNetworkSpeed;
    localObject = this.mParamRecord;
    ((TPReportManager.ParamRecord)localObject).getSpeedCnt += 1;
    if (this.mNetworkSpeed > this.mParamRecord.maxSpeed) {
      this.mParamRecord.maxSpeed = this.mNetworkSpeed;
    }
    paramMap = getMapValueString(paramMap, "spanId", "");
    if (!TextUtils.isEmpty(paramMap))
    {
      try
      {
        localObject = new JSONObject(paramMap);
        if (((JSONObject)localObject).has("spanId")) {
          this.mParamRecord.spanId = ((JSONObject)localObject).getString("spanId");
        }
      }
      catch (Exception localException)
      {
        TPLogUtil.e("TPReportManager", localException);
      }
      getHitDownloadedInfo(paramMap);
    }
  }
  
  private void onRenderingStart(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onRenderingStart");
    if (paramMap == null) {
      return;
    }
    TPProperties localTPProperties = new TPProperties();
    TPReportParams.FirstRenderParams localFirstRenderParams = this.mReportParams.getFirstRenderParams();
    localFirstRenderParams.endTimeUnix = getMapValueLong(paramMap, "etime", 0L);
    localFirstRenderParams.errCodeString = this.mErrorCode;
    localFirstRenderParams.paramsToProperties(localTPProperties);
    this.mReportHandler.handleReportEvent(32, localTPProperties);
    this.mReportParams.getFirstRenderParams().reset();
  }
  
  private void onReportEvent(ITPReportProperties paramITPReportProperties)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReportEvent: ");
    localStringBuilder.append(paramITPReportProperties.toString());
    TPLogUtil.i("TPReportManager", localStringBuilder.toString());
    TPBeaconReportWrapper.reportEvent(paramITPReportProperties);
  }
  
  private void onReportLastEvent()
  {
    TPLogUtil.i("TPReportManager", "onReportLastEvent");
    Object localObject = mCache;
    if (localObject == null) {
      return;
    }
    try
    {
      localObject = (ArrayList)((TPDiskReadWrite)localObject).readAllFile();
      if (localObject == null) {
        return;
      }
      int i = 0;
      while (i < ((ArrayList)localObject).size())
      {
        try
        {
          Properties localProperties = (Properties)((ArrayList)localObject).get(i);
          if (localProperties != null) {
            onReportEvent(new TPProperties(localProperties));
          }
        }
        catch (Exception localException2)
        {
          TPLogUtil.e("TPReportManager", localException2);
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException1)
    {
      TPLogUtil.e("TPReportManager", localException1);
    }
  }
  
  private void onReportProtocolUpdate(Map<String, Object> paramMap)
  {
    this.mProto = getMapValueString(paramMap, "proto", "");
    this.mProtoVer = getMapValueString(paramMap, "protover", "");
  }
  
  private void onSeekComplete(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onSeekComplete");
    this.mIsSeeking = false;
    if (paramMap == null) {
      return;
    }
    TPReportParams.UserSeekOnceParams localUserSeekOnceParams = this.mCurSeekParams;
    if (localUserSeekOnceParams == null) {
      return;
    }
    localUserSeekOnceParams.seekEndTimeUnix = getMapValueLong(paramMap, "etime", System.currentTimeMillis());
    this.mCurSeekParams.endPresentTimeLong = (getMapValueLong(paramMap, "petime", 0L) / 1000L);
    paramMap = this.mCurSeekParams;
    paramMap.errCodeString = this.mErrorCode;
    long l = paramMap.seekEndTimeUnix - this.mCurSeekParams.seekStartTimeUnix;
    if (l > 1200L)
    {
      this.mSeekBufferingCount += 1;
      this.mSeekBufferingDuration = ((int)(this.mSeekBufferingDuration + l));
    }
    paramMap = this.mReportParams.getUserSeekTotalParams();
    paramMap.seekTotalCountInt += 1;
    paramMap.seekBufferingDurationInt = this.mSeekBufferingDuration;
    paramMap.seekBufferingCountInt = this.mSeekBufferingCount;
    if (paramMap.seekOnceParamsList.size() < 20)
    {
      paramMap.seekOnceParamsList.add(this.mCurSeekParams);
      paramMap = new TPProperties();
      this.mCurSeekParams.paramsToProperties(paramMap);
      this.mReportHandler.handleReportEvent(40, paramMap);
    }
    this.mCurSeekParams = null;
  }
  
  private void onSelectTrack(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onSelectTrack");
    if (paramMap == null) {
      return;
    }
    if (this.mParamRecord.subtitleInfos.size() == 0) {
      return;
    }
    if (getMapValueInteger(paramMap, "tracktype", 0) != 3) {
      return;
    }
    this.mIsLoadingSubtitle = true;
    this.mParamRecord.isSelectedSubtitle = true;
    TPReportParams.LoadSubtitleParams localLoadSubtitleParams = this.mReportParams.getLoadSubtitleParams();
    localLoadSubtitleParams.starTimeUnix = getMapValueLong(paramMap, "stime", 0L);
    Object localObject = this.mReportInfoGetter;
    if (localObject != null)
    {
      localLoadSubtitleParams.cdnTypeInt = ((TPDefaultReportInfo)localObject).subtitleCdnType;
      localLoadSubtitleParams.cgiUrlIndex = this.mReportInfoGetter.subtitleUrlIndex;
    }
    long l = getMapValueLong(paramMap, "opaque", -1L);
    paramMap = getMapValueString(paramMap, "name", "");
    localObject = this.mParamRecord.subtitleInfos.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TPReportManager.SubtitleInfo localSubtitleInfo = (TPReportManager.SubtitleInfo)((Iterator)localObject).next();
      if ((!TextUtils.isEmpty(paramMap)) && (localSubtitleInfo.name.equals(paramMap)))
      {
        localLoadSubtitleParams.subtitleUrlString = localSubtitleInfo.url;
        localSubtitleInfo.opaque = l;
      }
    }
  }
  
  private void onSelectTrackDone(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onSelectTrackDone");
    if (!this.mIsLoadingSubtitle) {
      return;
    }
    if (paramMap == null) {
      return;
    }
    if (this.mParamRecord.subtitleInfos.size() == 0) {
      return;
    }
    long l = getMapValueLong(paramMap, "opaque", -1L);
    if (l == -1L) {
      return;
    }
    Object localObject = this.mParamRecord.subtitleInfos.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((TPReportManager.SubtitleInfo)((Iterator)localObject).next()).opaque == l)
      {
        localObject = this.mReportParams.getLoadSubtitleParams();
        ((TPReportParams.LoadSubtitleParams)localObject).endTimeUnix = getMapValueLong(paramMap, "etime", 0L);
        ((TPReportParams.LoadSubtitleParams)localObject).errCodeString = getMapValueString(paramMap, "code", "0");
        ((TPReportParams.LoadSubtitleParams)localObject).bufferingDurationInt = ((int)(((TPReportParams.LoadSubtitleParams)localObject).endTimeUnix - ((TPReportParams.LoadSubtitleParams)localObject).starTimeUnix));
        paramMap = new TPProperties();
        ((TPReportParams.LoadSubtitleParams)localObject).paramsToProperties(paramMap);
        this.mReportHandler.handleReportEvent(33, paramMap);
        this.mIsLoadingSubtitle = false;
      }
    }
  }
  
  private void onSetPlaySpeed(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    if (getMapValueFloat(paramMap, "scene", 1.0F) != 1.0F)
    {
      this.mPlayScene = 2;
      return;
    }
    this.mPlayScene = 1;
  }
  
  private void onStartPlayer(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onStartPlayer");
    this.mIsPlayDone = false;
    if (paramMap == null) {
      return;
    }
    this.mParamRecord.startPlayTimeMs = System.currentTimeMillis();
    long l = getMapValueLong(paramMap, "stime", 0L);
    if (this.mPlayStartTimeMs > 0L) {
      this.mPlayDurationMs += System.currentTimeMillis() - l;
    }
    this.mPlayStartTimeMs = l;
    if (this.mPlayType == 1)
    {
      this.mEventHandler.removeMessages(3000);
      this.mEventHandler.sendEmptyMessageDelayed(3000, 60000L);
    }
  }
  
  private void onStartPrepare(Map<String, Object> paramMap)
  {
    if (this.mIsPrepare) {
      return;
    }
    TPLogUtil.i("TPReportManager", "onStartPrepare");
    this.mIsPlayDone = false;
    this.mFlowId = getMapValueString(paramMap, "flowid", "");
    this.mIsUseP2P = getMapValueBool(paramMap, "p2p", false);
    Object localObject = this.mReportInfoGetter;
    if (localObject != null) {
      this.mPlayType = ((TPDefaultReportInfo)localObject).getPlayType();
    }
    int i = this.mPlayType;
    if (i == 1) {
      this.mReportHandler = new TPReportManager.LiveReportHandler(this);
    } else if (i == 0) {
      this.mReportHandler = new TPReportManager.VodReportHandler(this);
    }
    localObject = new TPProperties();
    this.mReportParams.getInitParams().paramsToProperties((ITPReportProperties)localObject);
    this.mReportHandler.handleReportEvent(5, (ITPReportProperties)localObject);
    this.mParamRecord.startPrepareTimeMs = System.currentTimeMillis();
    localObject = this.mReportParams.getFirstLoadParams();
    ((TPReportParams.FirstLoadParams)localObject).cdnUrlString = this.mParamRecord.cdnUrl;
    if (TextUtils.isEmpty(((TPReportParams.FirstLoadParams)localObject).cdnUrlString)) {
      ((TPReportParams.FirstLoadParams)localObject).cdnUrlString = getMapValueString(paramMap, "url", "");
    }
    TPDefaultReportInfo localTPDefaultReportInfo = this.mReportInfoGetter;
    if (localTPDefaultReportInfo != null) {
      ((TPReportParams.FirstLoadParams)localObject).cgiUrlIndex = localTPDefaultReportInfo.cdnUrlIndex;
    }
    ((TPReportParams.FirstLoadParams)localObject).cgiUrlIndex = getMapValueInteger(paramMap, "urlindex", 0);
    ((TPReportParams.FirstLoadParams)localObject).starTimeUnix = getMapValueLong(paramMap, "stime", 0L);
    this.mReportParams.getFirstRenderParams().starTimeUnix = getMapValueLong(paramMap, "stime", 0L);
    this.mIsPrepare = true;
  }
  
  private void onStartSeek(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onStartSeek");
    if (paramMap == null) {
      return;
    }
    if (this.mIsBuffering) {
      onBufferingEnd(new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).build());
    }
    if (this.mIsSeeking) {
      onSeekComplete(new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).put("petime", Long.valueOf(getMapValueLong(paramMap, "pstime", 0L) / 1000L)).build());
    }
    this.mIsSeeking = true;
    this.mLastEvent = 1;
    this.mCurSeekParams = this.mReportParams.createUserSeekOnceParams();
    this.mCurSeekParams.seekStartTimeUnix = getMapValueLong(paramMap, "stime", System.currentTimeMillis());
    TPReportParams.CommonParams localCommonParams = this.mReportParams.getCommonParams();
    this.mCurSeekParams.formatInt = localCommonParams.mediaFormatInt;
    this.mCurSeekParams.startPresentTimeLong = (getMapValueLong(paramMap, "pstime", 0L) / 1000L);
  }
  
  private void onSwitchDef(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onSwitchDef");
    if (paramMap == null) {
      return;
    }
    this.mParamRecord.defId = getMapValueString(paramMap, "switch", "");
    this.mParamRecord.isSwitchingDef = true;
    if (this.mPlayType == 1)
    {
      this.mEventHandler.removeMessages(3000);
      onLivePeriodReport();
      paramMap = this.mParamRecord;
      paramMap.startPrepareTimeMs = 0L;
      paramMap.endPrepareTimeMs = 0L;
    }
  }
  
  private void onSwitchDefEnd(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onSwitchDefEnd");
    if (paramMap == null) {
      return;
    }
    this.mParamRecord.defId = getMapValueString(paramMap, "switch", "");
    this.mParamRecord.isSwitchingDef = false;
    if (this.mPlayType == 1)
    {
      this.mReportHandler.handleReportEvent(30, new TPProperties());
      this.mEventHandler.removeMessages(3000);
      this.mEventHandler.sendEmptyMessageDelayed(3000, 60000L);
      this.mParamRecord.startPlayTimeMs = System.currentTimeMillis();
    }
  }
  
  private void release()
  {
    TPLogUtil.i("TPReportManager", "release: ");
    TPGlobalEventNofication.removeEventListener(this.mGlobalEventListener);
    TPLogUtil.i("TPReportManager", "release: end!");
  }
  
  private void removeCacheEvent()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeCacheEvent: mFlowId: ");
    localStringBuilder.append(this.mFlowId);
    TPLogUtil.i("TPReportManager", localStringBuilder.toString());
    if ((mCache != null) && (!TextUtils.isEmpty(this.mFlowId))) {
      mCache.rmFile(this.mFlowId);
    }
  }
  
  private void resetLocalParam()
  {
    this.mPlayStartTimeMs = 0L;
    this.mPlayDurationMs = 0L;
    this.mSeekBufferingCount = 0;
    this.mSeekBufferingDuration = 0;
    this.mIsSeeking = false;
    this.mIsBuffering = false;
    this.mIsPrepare = false;
    this.mIsLoadingSubtitle = false;
    this.mFlowId = "";
    this.mPlayerType = 0;
    this.mDownloadType = 0;
    this.mMediaRate = 0;
    this.mMediaDurationMs = 0L;
    this.mNetworkSpeed = 0;
    this.mIsUseP2P = false;
    this.mProto = "";
    this.mProtoVer = "";
    this.mMediaResolution = "";
    this.mPlayType = -1;
    this.mErrorCode = "0";
    this.mParamRecord.reset();
  }
  
  private void signalStrengthRegister()
  {
    this.mEventHandler.sendEmptyMessage(4001);
  }
  
  private void signalStrengthUnRegister()
  {
    this.mEventHandler.sendEmptyMessage(4002);
  }
  
  private void updateCommonParam(ITPReportProperties paramITPReportProperties, int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void updateLiveExParam(ITPReportProperties paramITPReportProperties, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void updateVodExParam(ITPReportProperties paramITPReportProperties, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onAttach()
  {
    init();
  }
  
  public void onDetach()
  {
    release();
  }
  
  public void onEvent(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    switch (paramInt1)
    {
    default: 
      switch (paramInt1)
      {
      default: 
        return;
      case 202: 
        paramInt1 = 1023;
        break;
      case 201: 
        paramInt1 = 1018;
        break;
      case 200: 
        paramInt1 = 1017;
      }
      break;
    case 124: 
      paramInt1 = 1022;
      break;
    case 123: 
      paramInt1 = 2005;
      break;
    case 122: 
      paramInt1 = 2004;
      break;
    case 121: 
      paramInt1 = 1021;
      break;
    case 120: 
      paramInt1 = 1020;
      break;
    case 119: 
      paramInt1 = 1019;
      break;
    case 118: 
      paramInt1 = 2002;
      break;
    case 117: 
      paramInt1 = 1016;
      break;
    case 116: 
      paramInt1 = 1015;
      break;
    case 115: 
      paramInt1 = 1014;
      break;
    case 114: 
      paramInt1 = 1013;
      break;
    case 113: 
      paramInt1 = 1011;
      break;
    case 112: 
      paramInt1 = 1010;
      break;
    case 111: 
      paramInt1 = 1009;
      break;
    case 110: 
      paramInt1 = 1008;
      break;
    case 109: 
      paramInt1 = 1007;
      break;
    case 108: 
      paramInt1 = 1006;
      break;
    case 107: 
      paramInt1 = 1005;
      break;
    case 106: 
      paramInt1 = 1004;
      break;
    case 105: 
      paramInt1 = 1012;
      break;
    case 104: 
      paramInt1 = 1003;
      break;
    case 103: 
      paramInt1 = 1002;
      break;
    case 102: 
      paramInt1 = 1001;
      break;
    case 101: 
      paramInt1 = 1000;
      break;
    case 100: 
      paramInt1 = 999;
    }
    this.mEventHandler.obtainMessage(paramInt1, paramObject).sendToTarget();
  }
  
  public void reportEvent(int paramInt, Map<String, Object> paramMap) {}
  
  public void setReportInfoGetter(TPDefaultReportInfo paramTPDefaultReportInfo)
  {
    ReportThumbPlayer.getInstance().setReportInfo(this, paramTPDefaultReportInfo);
    this.mReportInfoGetter = paramTPDefaultReportInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportManager
 * JD-Core Version:    0.7.0.1
 */