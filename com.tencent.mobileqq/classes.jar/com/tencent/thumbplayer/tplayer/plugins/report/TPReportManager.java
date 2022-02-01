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
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.TPDefaultReportInfo;
import com.tencent.thumbplayer.api.report.TPLiveReportInfo;
import com.tencent.thumbplayer.api.report.TPVodReportInfo;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.tplayer.plugins.ITPPluginBase;
import com.tencent.thumbplayer.utils.TPDiskReadWrite;
import com.tencent.thumbplayer.utils.TPGlobalEventNofication;
import com.tencent.thumbplayer.utils.TPGlobalEventNofication.OnGlobalEventChangeListener;
import com.tencent.thumbplayer.utils.TPHashMapBuilder;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPProperties;
import com.tencent.thumbplayer.utils.TPThreadUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
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
  private static final String REPORT_DATA_CACHE_NAME = "TPReportCache";
  private static final String TAG = "TPReportManager";
  private static boolean hasReportLastEvent = false;
  private static TPDiskReadWrite mCache = null;
  private boolean mAppState = true;
  private Context mContext;
  private TPReportParams.BufferingOnceParams mCurBufferingParams = null;
  private TPReportParams.UserSeekOnceParams mCurSeekParams = null;
  private int mDownloadType = 0;
  private String mErrorCode = "0";
  private TPReportManager.EventHandler mEventHandler;
  private String mFlowId = "";
  private TPGlobalEventNofication.OnGlobalEventChangeListener mGlobalEventListener = new TPReportManager.3(this);
  private boolean mIsBuffering = false;
  private boolean mIsPlayDone = true;
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
  private TPReportManager.IReportHandler mReportHandler = new TPReportManager.DefaultReportHandler(this);
  private TPDefaultReportInfo mReportInfoGetter = null;
  private TPReportParams mReportParams = null;
  private int mSeekBufferingCount = 0;
  private int mSeekBufferingDuration = 0;
  private int mSignalStrength = 0;
  private PhoneStateListener myListener;
  
  public TPReportManager(Context paramContext, Looper paramLooper)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mLooper = paramLooper;
  }
  
  private String getDeviceResolution()
  {
    if (this.mContext == null) {
      return "0";
    }
    int i = this.mContext.getResources().getDisplayMetrics().widthPixels;
    int j = this.mContext.getResources().getDisplayMetrics().heightPixels;
    return j + "*" + i;
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
  
  private boolean getMapValueBool(Map<String, Object> paramMap, String paramString, boolean paramBoolean)
  {
    if (paramMap == null) {}
    do
    {
      return paramBoolean;
      paramMap = paramMap.get(paramString);
    } while (paramMap == null);
    return ((Boolean)paramMap).booleanValue();
  }
  
  private float getMapValueFloat(Map<String, Object> paramMap, String paramString, float paramFloat)
  {
    if (paramMap == null) {}
    do
    {
      return paramFloat;
      paramMap = paramMap.get(paramString);
    } while (paramMap == null);
    return ((Float)paramMap).floatValue();
  }
  
  private int getMapValueInteger(Map<String, Object> paramMap, String paramString, int paramInt)
  {
    if (paramMap == null) {}
    do
    {
      return paramInt;
      paramMap = paramMap.get(paramString);
    } while (paramMap == null);
    return ((Integer)paramMap).intValue();
  }
  
  private long getMapValueLong(Map<String, Object> paramMap, String paramString, long paramLong)
  {
    if (paramMap == null) {}
    do
    {
      return paramLong;
      paramMap = paramMap.get(paramString);
    } while (paramMap == null);
    return ((Long)paramMap).longValue();
  }
  
  private String getMapValueString(Map<String, Object> paramMap, String paramString1, String paramString2)
  {
    if (paramMap == null) {
      return paramString2;
    }
    paramMap = paramMap.get(paramString1);
    if (paramMap != null) {}
    for (paramMap = (String)paramMap;; paramMap = paramString2) {
      return paramMap;
    }
  }
  
  private int getMobileSubType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return 2;
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
    return 4;
  }
  
  @SuppressLint({"MissingPermission"})
  private int getNetWorkType()
  {
    if (this.mContext == null) {
      return 0;
    }
    try
    {
      Object localObject = (ConnectivityManager)this.mContext.getSystemService("connectivity");
      if (localObject == null) {
        break label110;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject == null) || (!((NetworkInfo)localObject).isConnected())) {
        break label110;
      }
      switch (((NetworkInfo)localObject).getType())
      {
      case 0: 
        i = getMobileSubType(((NetworkInfo)localObject).getSubtype());
      }
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPReportManager", localException);
      i = 0;
    }
    int i = 1;
    return i;
    return 10;
    label110:
    i = 0;
    return i;
  }
  
  private String getOsVersion()
  {
    return String.format("Android %s", new Object[] { TPSystemInfo.getOsVersion() });
  }
  
  private void init()
  {
    this.mEventHandler = new TPReportManager.EventHandler(this, this.mLooper);
    this.mReportParams = new TPReportParams();
    signalStrengthRegister();
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
  
  private void initPhoneStateListener()
  {
    if (this.myListener == null) {
      this.myListener = new TPReportManager.1(this);
    }
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
    if ((this.mIsPlayDone) || (this.mPlayType == 1) || (!this.mAppState)) {}
    for (;;)
    {
      return;
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
      if (this.mPlayType == 0) {
        updateVodExParam(localTPProperties, false);
      }
      while ((mCache != null) && (!TextUtils.isEmpty(this.mFlowId)))
      {
        TPLogUtil.i("TPReportManager", "Cache report event. mFlowId: " + this.mFlowId);
        mCache.writeFile(this.mFlowId, localTPProperties.getProperties());
        return;
        if (this.mPlayType == 1) {
          updateLiveExParam(localTPProperties, false);
        }
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
    if (paramMap == null) {}
    int i;
    do
    {
      long l;
      do
      {
        return;
        l = getMapValueLong(paramMap, "etime", System.currentTimeMillis());
        i = (int)(l - this.mParamRecord.startBufferingTimeMs);
      } while ((i <= 1200) || (this.mIsSeeking));
      TPReportManager.ParamRecord localParamRecord = this.mParamRecord;
      localParamRecord.bufferingCount += 1;
      this.mParamRecord.endBufferingTimeMs = l;
      localParamRecord = this.mParamRecord;
      localParamRecord.bufferingDurationMs += (int)(this.mParamRecord.endBufferingTimeMs - this.mParamRecord.startBufferingTimeMs);
    } while (this.mCurBufferingParams == null);
    this.mCurBufferingParams.endTimeUnix = getMapValueLong(paramMap, "etime", 0L);
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
    if (paramMap == null) {}
    do
    {
      return;
      this.mIsBuffering = true;
    } while (this.mIsSeeking);
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
    this.mCurBufferingParams.lastEventInt = this.mLastEvent;
    this.mCurBufferingParams.sceneInt = this.mPlayScene;
    this.mCurBufferingParams.bufferingPresentTimeLong = (getMapValueLong(paramMap, "ptime", 0L) / 1000L);
    this.mCurBufferingParams.urlString = getMapValueString(paramMap, "url", "");
  }
  
  private void onCdnInfoUpdate(Map<String, Object> paramMap)
  {
    if (paramMap == null) {}
    do
    {
      return;
      this.mParamRecord.cdnUrl = getMapValueString(paramMap, "url", "");
      this.mParamRecord.cdnIp = getMapValueString(paramMap, "cdnip", "");
      this.mParamRecord.cdnUip = getMapValueString(paramMap, "cdnuip", "");
    } while ((TextUtils.isEmpty(this.mParamRecord.cdnUrl)) || (!this.mParamRecord.cdnUrl.contains("sid=")));
    int i = this.mParamRecord.cdnUrl.indexOf("sid=");
    int j = this.mParamRecord.cdnUrl.indexOf("&", i);
    TPReportManager.ParamRecord localParamRecord = this.mParamRecord;
    if (j > -1) {}
    for (paramMap = this.mParamRecord.cdnUrl.substring(i + 4, j);; paramMap = this.mParamRecord.cdnUrl.substring(i + 4))
    {
      localParamRecord.tuid = paramMap;
      return;
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
    if (paramMap == null) {}
    TPReportParams.GetCdnUrlParams localGetCdnUrlParams;
    do
    {
      return;
      TPProperties localTPProperties = new TPProperties();
      localGetCdnUrlParams = this.mReportParams.getGetCdnParams();
      localGetCdnUrlParams.proxyIpString = getMapValueString(paramMap, "ip", "");
      localGetCdnUrlParams.starTimeUnix = getMapValueLong(paramMap, "stime", 0L);
      localGetCdnUrlParams.endTimeUnix = getMapValueLong(paramMap, "etime", 0L);
      localGetCdnUrlParams.errCodeString = getMapValueString(paramMap, "code", "0");
      localGetCdnUrlParams.paramsToProperties(localTPProperties);
      this.mReportHandler.handleReportEvent(15, localTPProperties);
    } while ((TextUtils.isEmpty(localGetCdnUrlParams.errCodeString)) || (localGetCdnUrlParams.errCodeString.equals("0")) || (localGetCdnUrlParams.errCodeString.equals("0.0")));
    this.mErrorCode = localGetCdnUrlParams.errCodeString;
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
    for (;;)
    {
      try
      {
        paramString = paramString.substring("#EXT-X-PROGRAM-DATE-TIME:".length());
        int i = paramString.indexOf('+');
        if (i == -1) {
          continue;
        }
        paramString = paramString.substring(0, i).replace('T', ' ');
      }
      catch (Exception paramString)
      {
        TPLogUtil.e("TPReportManager", paramString);
        paramString = "";
        continue;
      }
      if (!TextUtils.isEmpty(paramString)) {
        break label119;
      }
      TPLogUtil.i("TPReportManager", "onHandleHlsTag , player_m3u8_tag , dataTime is null ");
      return;
      TPLogUtil.i("TPReportManager", "handleOnPlayerPrivaterHlsM3u8Tag , player_m3u8_tag , tag do not contains time zone");
      paramString = paramString.replace('T', ' ');
    }
    try
    {
      label119:
      paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramString);
      if (paramString == null) {
        break label217;
      }
      l1 = paramString.getTime();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        long l2;
        TPLogUtil.e("TPReportManager", paramString);
        long l1 = 0L;
      }
    }
    l2 = System.currentTimeMillis();
    TPLogUtil.i("TPReportManager", "onHandleHlsTag , player_m3u8_tag , sysCurTime: " + l2 + ", time:" + l1 + ", delay:" + (l2 - l1));
    this.mParamRecord.liveDelayMs = ((int)(l2 - l1));
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
    this.mParamRecord.isSelectedSubtitle = true;
    TPProperties localTPProperties = new TPProperties();
    TPReportParams.LoadSubtitleParams localLoadSubtitleParams = this.mReportParams.getLoadSubtitleParams();
    if (this.mReportInfoGetter != null)
    {
      localLoadSubtitleParams.cdnTypeInt = this.mReportInfoGetter.subtitleCdnType;
      localLoadSubtitleParams.cgiUrlIndex = this.mReportInfoGetter.subtitleUrlIndex;
    }
    localLoadSubtitleParams.bufferingDurationInt = getMapValueInteger(paramMap, "tduration", 0);
    localLoadSubtitleParams.subtitleUrlString = getMapValueString(paramMap, "url", "");
    localLoadSubtitleParams.starTimeUnix = getMapValueLong(paramMap, "stime", 0L);
    localLoadSubtitleParams.endTimeUnix = getMapValueLong(paramMap, "etime", 0L);
    localLoadSubtitleParams.errCodeString = getMapValueString(paramMap, "code", "0");
    localLoadSubtitleParams.paramsToProperties(localTPProperties);
    this.mReportHandler.handleReportEvent(33, localTPProperties);
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
    if ((paramMap == null) || (this.mIsPlayDone)) {
      return;
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
    this.mIsPlayDone = true;
    this.mErrorCode = "0";
    resetLocalParam();
    removeCacheEvent();
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
    this.mErrorCode = getMapValueString(paramMap, "code", "0");
    if (this.mReportInfoGetter != null) {
      this.mPlayType = this.mReportInfoGetter.getPlayType();
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
    if (paramMap == null) {}
    do
    {
      return;
      if (this.mPlayStartTimeMs > 0L)
      {
        long l1 = getMapValueLong(paramMap, "stime", System.currentTimeMillis());
        long l2 = this.mPlayDurationMs;
        this.mPlayDurationMs = (l1 - this.mPlayStartTimeMs + l2);
        this.mPlayStartTimeMs = 0L;
      }
    } while (this.mParamRecord.startPlayTimeMs <= 0L);
    paramMap = this.mParamRecord;
    paramMap.playDurationMs += (int)(System.currentTimeMillis() - this.mParamRecord.startPlayTimeMs);
    this.mParamRecord.startPlayTimeMs = 0L;
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
      long l1 = getMapValueLong(paramMap, "etime", System.currentTimeMillis());
      long l2 = this.mPlayDurationMs;
      this.mPlayDurationMs = (l1 - this.mPlayStartTimeMs + l2);
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
    TPLogUtil.i("TPReportManager", "onPrepareDone");
    if (paramMap == null) {
      return;
    }
    this.mParamRecord.endPrepareTimeMs = System.currentTimeMillis();
    this.mParamRecord.isMultiTrack = getMapValueBool(paramMap, "multitrack", false);
    TPProperties localTPProperties = new TPProperties();
    Object localObject;
    if (getMapValueInteger(paramMap, "playertype", 0) == 1)
    {
      this.mPlayerType = 0;
      this.mMediaResolution = getMapValueString(paramMap, "definition", "");
      this.mMediaDurationMs = getMapValueLong(paramMap, "duration", 0L);
      this.mMediaRate = ((int)getMapValueLong(paramMap, "rate", 0L));
      localObject = getMapValueString(paramMap, "fmt", "");
      if ((localObject == null) || (!((String)localObject).contains("hls"))) {
        break label196;
      }
    }
    label196:
    for (this.mDownloadType = 3;; this.mDownloadType = 1)
    {
      localObject = this.mReportParams.getFirstLoadParams();
      ((TPReportParams.FirstLoadParams)localObject).endTimeUnix = getMapValueLong(paramMap, "etime", 0L);
      ((TPReportParams.FirstLoadParams)localObject).errCodeString = this.mErrorCode;
      ((TPReportParams.FirstLoadParams)localObject).paramsToProperties(localTPProperties);
      this.mReportHandler.handleReportEvent(30, localTPProperties);
      this.mIsPlayDone = false;
      return;
      this.mPlayerType = 1;
      break;
    }
  }
  
  private void onProxyInfoUpdate(Map<String, Object> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      this.mNetworkSpeed = getMapValueInteger(paramMap, "speed", 0);
      TPReportManager.ParamRecord localParamRecord = this.mParamRecord;
      localParamRecord.totalSpeed += this.mNetworkSpeed;
      localParamRecord = this.mParamRecord;
      localParamRecord.getSpeedCnt += 1;
      if (this.mNetworkSpeed > this.mParamRecord.maxSpeed) {
        this.mParamRecord.maxSpeed = this.mNetworkSpeed;
      }
      paramMap = getMapValueString(paramMap, "spanId", "");
      if (!TextUtils.isEmpty(paramMap)) {
        try
        {
          paramMap = new JSONObject(paramMap);
          if ((paramMap != null) && (paramMap.has("spanId")))
          {
            this.mParamRecord.spanId = paramMap.getString("spanId");
            return;
          }
        }
        catch (Exception paramMap)
        {
          TPLogUtil.e("TPReportManager", paramMap);
        }
      }
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
  }
  
  private void onReportEvent(ITPReportProperties paramITPReportProperties)
  {
    TPLogUtil.i("TPReportManager", "onReportEvent: " + paramITPReportProperties.toString());
    TPBeaconReportWrapper.reportEvent(paramITPReportProperties);
  }
  
  private void onReportLastEvent()
  {
    TPLogUtil.i("TPReportManager", "onReportLastEvent");
    if (mCache == null) {
      return;
    }
    for (;;)
    {
      try
      {
        localArrayList = (ArrayList)mCache.readAllFile();
        if (localArrayList == null) {
          break;
        }
        i = 0;
        if (i >= localArrayList.size()) {
          break;
        }
      }
      catch (Exception localException1)
      {
        ArrayList localArrayList;
        int i;
        Properties localProperties;
        TPLogUtil.e("TPReportManager", localException1);
        return;
      }
      try
      {
        localProperties = (Properties)localArrayList.get(i);
        if (localProperties != null) {
          onReportEvent(new TPProperties(localProperties));
        }
      }
      catch (Exception localException2)
      {
        TPLogUtil.e("TPReportManager", localException2);
        continue;
      }
      i += 1;
    }
  }
  
  private void onSeekComplete(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onSeekComplete");
    this.mIsSeeking = false;
    if (paramMap == null) {}
    while (this.mCurSeekParams == null) {
      return;
    }
    this.mCurSeekParams.seekEndTimeUnix = getMapValueLong(paramMap, "etime", System.currentTimeMillis());
    this.mCurSeekParams.endPresentTimeLong = (getMapValueLong(paramMap, "petime", 0L) / 1000L);
    this.mCurSeekParams.errCodeString = this.mErrorCode;
    long l = this.mCurSeekParams.seekEndTimeUnix - this.mCurSeekParams.seekStartTimeUnix;
    if (l > 1200L)
    {
      this.mSeekBufferingCount += 1;
      this.mSeekBufferingDuration = ((int)(l + this.mSeekBufferingDuration));
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
    if (paramMap == null) {}
    do
    {
      return;
      this.mParamRecord.startPlayTimeMs = System.currentTimeMillis();
      TPReportParams.FirstRenderParams localFirstRenderParams = this.mReportParams.getFirstRenderParams();
      localFirstRenderParams.starTimeUnix = getMapValueLong(paramMap, "stime", 0L);
      if (this.mPlayStartTimeMs > 0L) {
        this.mPlayDurationMs += System.currentTimeMillis() - localFirstRenderParams.starTimeUnix;
      }
      this.mPlayStartTimeMs = localFirstRenderParams.starTimeUnix;
    } while (this.mPlayType != 1);
    this.mEventHandler.removeMessages(3000);
    this.mEventHandler.sendEmptyMessageDelayed(3000, 60000L);
  }
  
  private void onStartPrepare(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onStartPrepare");
    this.mFlowId = getMapValueString(paramMap, "flowid", "");
    this.mIsUseP2P = getMapValueBool(paramMap, "p2p", false);
    if (this.mReportInfoGetter != null) {
      this.mPlayType = this.mReportInfoGetter.getPlayType();
    }
    if (this.mPlayType == 1) {
      this.mReportHandler = new TPReportManager.LiveReportHandler(this);
    }
    for (;;)
    {
      Object localObject = new TPProperties();
      this.mReportParams.getInitParams().paramsToProperties((ITPReportProperties)localObject);
      this.mReportHandler.handleReportEvent(5, (ITPReportProperties)localObject);
      this.mParamRecord.startPrepareTimeMs = System.currentTimeMillis();
      localObject = this.mReportParams.getFirstLoadParams();
      ((TPReportParams.FirstLoadParams)localObject).cdnUrlString = this.mParamRecord.cdnUrl;
      if (TextUtils.isEmpty(((TPReportParams.FirstLoadParams)localObject).cdnUrlString)) {
        ((TPReportParams.FirstLoadParams)localObject).cdnUrlString = getMapValueString(paramMap, "url", "");
      }
      if (this.mReportInfoGetter != null) {
        ((TPReportParams.FirstLoadParams)localObject).cgiUrlIndex = this.mReportInfoGetter.cdnUrlIndex;
      }
      ((TPReportParams.FirstLoadParams)localObject).cgiUrlIndex = getMapValueInteger(paramMap, "urlindex", 0);
      ((TPReportParams.FirstLoadParams)localObject).starTimeUnix = getMapValueLong(paramMap, "stime", 0L);
      return;
      if (this.mPlayType == 0) {
        this.mReportHandler = new TPReportManager.VodReportHandler(this);
      }
    }
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
    if (paramMap == null) {}
    do
    {
      return;
      this.mParamRecord.defId = getMapValueString(paramMap, "switch", "");
      this.mParamRecord.isSwitchingDef = true;
    } while (this.mPlayType != 1);
    this.mEventHandler.removeMessages(3000);
    onLivePeriodReport();
    this.mParamRecord.startPrepareTimeMs = 0L;
    this.mParamRecord.endPrepareTimeMs = 0L;
  }
  
  private void onSwitchDefEnd(Map<String, Object> paramMap)
  {
    TPLogUtil.i("TPReportManager", "onSwitchDefEnd");
    if (paramMap == null) {}
    do
    {
      return;
      this.mParamRecord.defId = getMapValueString(paramMap, "switch", "");
      this.mParamRecord.isSwitchingDef = false;
    } while (this.mPlayType != 1);
    this.mReportHandler.handleReportEvent(30, new TPProperties());
    this.mEventHandler.removeMessages(3000);
    this.mEventHandler.sendEmptyMessageDelayed(3000, 60000L);
    this.mParamRecord.startPlayTimeMs = System.currentTimeMillis();
  }
  
  private void release()
  {
    TPLogUtil.i("TPReportManager", "release: ");
    signalStrengthUnRegister();
    TPGlobalEventNofication.removeEventListener(this.mGlobalEventListener);
    TPLogUtil.i("TPReportManager", "release: end!");
  }
  
  private void removeCacheEvent()
  {
    TPLogUtil.i("TPReportManager", "removeCacheEvent: mFlowId: " + this.mFlowId);
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
    this.mParamRecord.reset();
  }
  
  private void signalStrengthRegister()
  {
    if (this.mContext == null) {
      return;
    }
    TelephonyManager localTelephonyManager = (TelephonyManager)this.mContext.getSystemService("phone");
    if (localTelephonyManager == null)
    {
      TPLogUtil.e("TPReportManager", "getSystemService TELEPHONY_SERVICE err.");
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      initPhoneStateListener();
      localTelephonyManager.listen(this.myListener, 256);
      return;
    }
    TPThreadUtil.postRunnableOnMainThread(new TPReportManager.2(this, localTelephonyManager));
  }
  
  private void signalStrengthUnRegister()
  {
    if ((this.mContext == null) || (this.myListener == null)) {
      return;
    }
    TelephonyManager localTelephonyManager = (TelephonyManager)this.mContext.getSystemService("phone");
    if (localTelephonyManager == null)
    {
      TPLogUtil.e("TPReportManager", "getSystemService TELEPHONY_SERVICE err.");
      return;
    }
    localTelephonyManager.listen(this.myListener, 0);
  }
  
  private void updateCommonParam(ITPReportProperties paramITPReportProperties, int paramInt, boolean paramBoolean)
  {
    int i = 1;
    TPReportParams.CommonParams localCommonParams = this.mReportParams.getCommonParams();
    localCommonParams.stepInt = paramInt;
    localCommonParams.seqInt += 1;
    localCommonParams.flowIdString = this.mFlowId;
    localCommonParams.playNoString = this.mFlowId;
    localCommonParams.signalStrengthInt = this.mSignalStrength;
    localCommonParams.networkSpeedInt = this.mNetworkSpeed;
    localCommonParams.networkTypeInt = getNetWorkType();
    localCommonParams.deviceNameString = TPSystemInfo.getDeviceName();
    localCommonParams.deviceResolutionString = getDeviceResolution();
    localCommonParams.osVersionString = getOsVersion();
    localCommonParams.p2pVersionString = TPDownloadProxyHelper.getNativeLibVersion();
    localCommonParams.playerVersionString = "2.8.0.1104";
    localCommonParams.playerTypeInt = this.mPlayerType;
    label270:
    Iterator localIterator;
    if (this.mIsUseP2P)
    {
      paramInt = 1;
      localCommonParams.p2pInt = paramInt;
      localCommonParams.playTypeInt = this.mPlayType;
      if ((this.mReportInfoGetter == null) || (!paramBoolean)) {
        break label548;
      }
      localCommonParams.testIdInt = this.mReportInfoGetter.testId;
      localCommonParams.cdnIdInt = this.mReportInfoGetter.cdnId;
      localCommonParams.downloadTypeInt = this.mReportInfoGetter.dlType;
      localCommonParams.loginTypeInt = this.mReportInfoGetter.loginType;
      localCommonParams.mediaFormatInt = this.mReportInfoGetter.mediaFormat;
      localCommonParams.mediaRateInt = this.mReportInfoGetter.mediaRate;
      localCommonParams.configIdInt = this.mReportInfoGetter.configId;
      localCommonParams.platformLong = this.mReportInfoGetter.platform;
      if (!this.mReportInfoGetter.isOnline) {
        break label513;
      }
      paramInt = i;
      localCommonParams.onlineInt = paramInt;
      localCommonParams.mediaDurationFloat = this.mReportInfoGetter.mediaDuration;
      localCommonParams.uinString = this.mReportInfoGetter.uin;
      localCommonParams.qqOpenIdString = this.mReportInfoGetter.qqOpenId;
      localCommonParams.wxOpenIdString = this.mReportInfoGetter.wxOpenId;
      localCommonParams.guidString = this.mReportInfoGetter.guid;
      localCommonParams.uipString = this.mReportInfoGetter.uip;
      localCommonParams.cdnUipString = this.mReportInfoGetter.cdnUip;
      localCommonParams.cdnIpString = this.mReportInfoGetter.cdnIp;
      localCommonParams.appVersionString = this.mReportInfoGetter.appVersion;
      localCommonParams.vidString = this.mReportInfoGetter.vid;
      localCommonParams.mediaResolutionString = this.mReportInfoGetter.mediaResolution;
      localCommonParams.scenesId = this.mReportInfoGetter.scenesId;
      if (this.mReportInfoGetter.reportInfoProperties == null) {
        break label537;
      }
      localIterator = this.mReportInfoGetter.reportInfoProperties.entrySet().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label537;
      }
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (localObject2 == null)
      {
        paramITPReportProperties.put(localObject1.toString(), "");
        continue;
        paramInt = 0;
        break;
        label513:
        paramInt = 0;
        break label270;
      }
      paramITPReportProperties.put(localObject1.toString(), localObject2.toString());
    }
    label537:
    this.mPlayType = this.mReportInfoGetter.getPlayType();
    label548:
    if (localCommonParams.platformLong <= 0L) {
      localCommonParams.platformLong = TPPlayerConfig.getPlatform();
    }
    if (TextUtils.isEmpty(localCommonParams.uinString)) {
      localCommonParams.uinString = TPPlayerConfig.getUserUin();
    }
    if (TextUtils.isEmpty(localCommonParams.guidString)) {
      localCommonParams.guidString = TPPlayerConfig.getGuid();
    }
    if (TextUtils.isEmpty(localCommonParams.appVersionString)) {
      localCommonParams.appVersionString = TPPlayerConfig.getAppVersionName(this.mContext);
    }
    if (TextUtils.isEmpty(localCommonParams.uipString)) {
      localCommonParams.uipString = this.mParamRecord.cdnUip;
    }
    if (TextUtils.isEmpty(localCommonParams.cdnUipString)) {
      localCommonParams.cdnUipString = this.mParamRecord.cdnUip;
    }
    if (TextUtils.isEmpty(localCommonParams.cdnIpString)) {
      localCommonParams.cdnIpString = this.mParamRecord.cdnIp;
    }
    if (localCommonParams.downloadTypeInt <= 0) {
      localCommonParams.downloadTypeInt = this.mDownloadType;
    }
    if (TextUtils.isEmpty(localCommonParams.mediaResolutionString)) {
      localCommonParams.mediaResolutionString = this.mMediaResolution;
    }
    if (localCommonParams.mediaDurationFloat <= 0.0F) {
      localCommonParams.mediaDurationFloat = ((float)this.mMediaDurationMs / 1000.0F);
    }
    if (localCommonParams.mediaRateInt <= 0) {
      localCommonParams.mediaRateInt = this.mMediaRate;
    }
    localCommonParams.paramsToProperties(paramITPReportProperties);
  }
  
  private void updateLiveExParam(ITPReportProperties paramITPReportProperties, boolean paramBoolean)
  {
    int j = 1;
    TPReportParams.LiveExParam localLiveExParam = this.mReportParams.getLiveExParam();
    if (localLiveExParam == null) {
      return;
    }
    int i;
    if ((this.mReportInfoGetter != null) && ((this.mReportInfoGetter instanceof TPLiveReportInfo)) && (paramBoolean))
    {
      localLiveExParam.adPlayLengthInt = ((TPLiveReportInfo)this.mReportInfoGetter).adPlayLength;
      localLiveExParam.liveProgramIdInt = ((TPLiveReportInfo)this.mReportInfoGetter).programId;
      localLiveExParam.streamIdInt = ((TPLiveReportInfo)this.mReportInfoGetter).streamId;
      localLiveExParam.contentIdInt = ((TPLiveReportInfo)this.mReportInfoGetter).contentId;
      localLiveExParam.playTimeInt = ((TPLiveReportInfo)this.mReportInfoGetter).playTime;
      localLiveExParam.liveTypeInt = ((TPLiveReportInfo)this.mReportInfoGetter).liveType;
      if (((TPLiveReportInfo)this.mReportInfoGetter).isUserPay)
      {
        i = 1;
        localLiveExParam.isUserPayInt = i;
        if (!((TPLiveReportInfo)this.mReportInfoGetter).isLookBack) {
          break label695;
        }
        i = 1;
        label165:
        localLiveExParam.isLookBackInt = i;
        localLiveExParam.cdnServerString = ((TPLiveReportInfo)this.mReportInfoGetter).cdnServer;
        localLiveExParam.freeTypeInt = this.mReportInfoGetter.freeType;
        localLiveExParam.userQQString = this.mReportInfoGetter.uin;
        localLiveExParam.userIpString = this.mReportInfoGetter.uip;
        if (!this.mReportInfoGetter.enableP2p) {
          break label700;
        }
        i = 1;
        label234:
        localLiveExParam.isStreamP2PInt = i;
      }
    }
    else
    {
      if ((this.mReportInfoGetter != null) && ((this.mReportInfoGetter instanceof TPLiveReportInfo))) {
        localLiveExParam.liveDelayInt = ((TPLiveReportInfo)this.mReportInfoGetter).liveDelay;
      }
      if (!this.mIsUseP2P) {
        break label705;
      }
      i = j;
      label282:
      localLiveExParam.isUseP2PInt = i;
      localLiveExParam.downloadUrl = this.mParamRecord.cdnUrl;
      if (TextUtils.isEmpty(localLiveExParam.downloadUrl)) {
        localLiveExParam.downloadUrl = this.mReportParams.getFirstLoadParams().cdnUrlString;
      }
      localLiveExParam.downloadServerIpString = this.mParamRecord.cdnIp;
      localLiveExParam.reportTimeLong = System.currentTimeMillis();
      if (this.mParamRecord.startPlayTimeMs > 0L)
      {
        TPReportManager.ParamRecord localParamRecord = this.mParamRecord;
        localParamRecord.playDurationMs = ((int)(localParamRecord.playDurationMs + (System.currentTimeMillis() - this.mParamRecord.startPlayTimeMs)));
        if ((!this.mIsPlayDone) && (!this.mIsBuffering) && (!this.mParamRecord.isSwitchingDef)) {
          break label710;
        }
      }
    }
    label695:
    label700:
    label705:
    label710:
    for (this.mParamRecord.startPlayTimeMs = 0L;; this.mParamRecord.startPlayTimeMs = System.currentTimeMillis())
    {
      localLiveExParam.prePlayLengthInt = this.mParamRecord.playDurationMs;
      this.mParamRecord.playDurationMs = 0;
      localLiveExParam.playerVersionString = "2.8.0.1104";
      localLiveExParam.deviceTypeInt = getDeviceType();
      localLiveExParam.networkTypeInt = getNetWorkType();
      localLiveExParam.maxSpeedInt = this.mParamRecord.maxSpeed;
      this.mParamRecord.maxSpeed = 0;
      localLiveExParam.testSpeedInt = this.mNetworkSpeed;
      if (this.mParamRecord.getSpeedCnt > 0)
      {
        localLiveExParam.downSpeedInt = (this.mParamRecord.totalSpeed / this.mParamRecord.getSpeedCnt);
        this.mParamRecord.totalSpeed = 0;
        this.mParamRecord.getSpeedCnt = 0;
      }
      localLiveExParam.liveTagInt = 0;
      localLiveExParam.extraInfoString = "";
      localLiveExParam.reconnectCntInt = 0;
      localLiveExParam.connectTimeInt = 0;
      localLiveExParam.getUrlTimeInt = 0;
      localLiveExParam.defSwitchString = this.mParamRecord.defId;
      localLiveExParam.loadingTimeLong = (this.mParamRecord.endPrepareTimeMs - this.mParamRecord.startPrepareTimeMs);
      localLiveExParam.blockTimeInt = this.mParamRecord.bufferingDurationMs;
      localLiveExParam.blockCountInt = this.mParamRecord.bufferingCount;
      this.mParamRecord.bufferingCount = 0;
      this.mParamRecord.bufferingDurationMs = 0;
      localLiveExParam.errCodeInt = 0;
      localLiveExParam.fullErrCodeString = this.mErrorCode;
      localLiveExParam.spanId = this.mParamRecord.spanId;
      localLiveExParam.tuid = this.mParamRecord.tuid;
      localLiveExParam.paramsToProperties(paramITPReportProperties);
      return;
      i = 0;
      break;
      i = 0;
      break label165;
      i = 0;
      break label234;
      i = 0;
      break label282;
    }
  }
  
  private void updateVodExParam(ITPReportProperties paramITPReportProperties, boolean paramBoolean)
  {
    int j = 1;
    TPReportParams.VodExParam localVodExParam = this.mReportParams.getVodExParam();
    if (localVodExParam == null) {
      return;
    }
    if ((this.mReportInfoGetter != null) && ((this.mReportInfoGetter instanceof TPVodReportInfo)) && (paramBoolean))
    {
      localVodExParam.currentPlayInt = ((TPVodReportInfo)this.mReportInfoGetter).currentPlayState;
      localVodExParam.optimizedPlayInt = ((TPVodReportInfo)this.mReportInfoGetter).optimizedPlay;
      if (((TPVodReportInfo)this.mReportInfoGetter).hasSubtitles)
      {
        i = 1;
        localVodExParam.hasSubtitleInt = i;
        localVodExParam.bizIdInt = ((TPVodReportInfo)this.mReportInfoGetter).bizId;
        localVodExParam.clipInt = ((TPVodReportInfo)this.mReportInfoGetter).clipCount;
        localVodExParam.statusInt = ((TPVodReportInfo)this.mReportInfoGetter).videoStatus;
        localVodExParam.freeTypeInt = this.mReportInfoGetter.freeType;
      }
    }
    else
    {
      if (!this.mParamRecord.isMultiTrack) {
        break label202;
      }
      i = 1;
      label159:
      localVodExParam.multiTrackInt = i;
      if (!this.mParamRecord.isSelectedSubtitle) {
        break label207;
      }
    }
    label202:
    label207:
    for (int i = j;; i = 0)
    {
      localVodExParam.isSelectedSubtitleInt = i;
      localVodExParam.hevcLcInt = 0;
      localVodExParam.paramsToProperties(paramITPReportProperties);
      return;
      i = 0;
      break;
      i = 0;
      break label159;
    }
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
      return;
    case 100: 
      paramInt1 = 999;
    }
    for (;;)
    {
      this.mEventHandler.obtainMessage(paramInt1, paramObject).sendToTarget();
      return;
      paramInt1 = 1000;
      continue;
      paramInt1 = 1001;
      continue;
      paramInt1 = 1002;
      continue;
      paramInt1 = 1003;
      continue;
      paramInt1 = 1012;
      continue;
      paramInt1 = 1004;
      continue;
      paramInt1 = 1005;
      continue;
      paramInt1 = 1006;
      continue;
      paramInt1 = 1007;
      continue;
      paramInt1 = 1008;
      continue;
      paramInt1 = 1009;
      continue;
      paramInt1 = 1010;
      continue;
      paramInt1 = 1011;
      continue;
      paramInt1 = 1013;
      continue;
      paramInt1 = 1014;
      continue;
      paramInt1 = 1015;
      continue;
      paramInt1 = 2002;
      continue;
      paramInt1 = 1016;
      continue;
      paramInt1 = 1019;
      continue;
      paramInt1 = 1020;
      continue;
      paramInt1 = 1021;
      continue;
      paramInt1 = 1017;
      continue;
      paramInt1 = 1018;
      continue;
      paramInt1 = 1022;
    }
  }
  
  public void reportEvent(int paramInt, Map<String, Object> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1000: 
      paramInt = 2000;
    }
    for (;;)
    {
      this.mEventHandler.obtainMessage(paramInt, localObject).sendToTarget();
      return;
      paramInt = 2001;
      continue;
      paramInt = 2003;
    }
  }
  
  public void setReportInfoGetter(TPDefaultReportInfo paramTPDefaultReportInfo)
  {
    this.mReportInfoGetter = paramTPDefaultReportInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportManager
 * JD-Core Version:    0.7.0.1
 */