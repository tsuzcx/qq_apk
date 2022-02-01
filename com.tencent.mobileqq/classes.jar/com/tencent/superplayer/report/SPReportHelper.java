package com.tencent.superplayer.report;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.player.SuperPlayerMgr;
import com.tencent.superplayer.utils.DisplayUtil;
import com.tencent.superplayer.utils.HDRUtil;
import com.tencent.superplayer.utils.HardwareUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.tmediacodec.util.LogUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class SPReportHelper
  implements ISPReporter
{
  public static final String SEPARATOR = ";";
  private static final String TAG = "SPReportHelper";
  private Map<String, Object> mConfigMap = new HashMap();
  private SPReportEvent mEvent;
  private boolean mHasReported = false;
  private boolean mHasStartSeek = false;
  private boolean mHasStop = false;
  private boolean mIsPrePlay = false;
  private long mLastPlayPosition = 0L;
  private SuperPlayerMgr mPlayer;
  private boolean mPrePlayViewShowCalled = false;
  private boolean mPrepared = false;
  private long mStartBufferTime = 0L;
  private long mStartPrepareTime = 0L;
  private long mVisibleStartPrepareTime = 0L;
  
  private String appendBySeparator(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString3);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private void checkAndWarning()
  {
    if ((this.mIsPrePlay) && (!this.mPrePlayViewShowCalled)) {
      LogUtil.w("SPReportHelper", "Player is prePlay, but prePlayViewShow not called.");
    }
  }
  
  private void doBeforeReport()
  {
    parseConfigMapToJson();
    this.mEvent.stopPosition = this.mPlayer.getCurrentPositionMs();
    float f1 = (float)this.mEvent.duration / 1000.0F;
    float f2 = 0.0F;
    if (f1 != 0.0F)
    {
      localSPReportEvent = this.mEvent;
      localSPReportEvent.bitrate = ((float)localSPReportEvent.fileSize / 1024.0F * 8.0F / f1);
    }
    if (this.mEvent.prePlay == 0)
    {
      localSPReportEvent = this.mEvent;
      localSPReportEvent.prepareDuration = localSPReportEvent.realPrepareDuration;
      localSPReportEvent = this.mEvent;
      localSPReportEvent.renderDuration = localSPReportEvent.realRenderDuration;
    }
    else if (this.mEvent.prePlay == 2)
    {
      l = this.mVisibleStartPrepareTime - this.mStartPrepareTime;
      localSPReportEvent = this.mEvent;
      localSPReportEvent.prepareDuration = (localSPReportEvent.realPrepareDuration - l);
      localSPReportEvent = this.mEvent;
      localSPReportEvent.renderDuration = (localSPReportEvent.realRenderDuration - l);
      if (l < 0L) {
        LogUtil.e("SPReportHelper", "doBeforeReport prePlayOffsetDuration error, for prePlayOffsetDuration < 0");
      }
    }
    else if (this.mEvent.prePlay == 1)
    {
      localSPReportEvent = this.mEvent;
      localSPReportEvent.prepareDuration = 0L;
      localSPReportEvent.renderDuration = 0L;
    }
    SPReportEvent localSPReportEvent = this.mEvent;
    localSPReportEvent.totalBufferDuration = (localSPReportEvent.realPrepareDuration + this.mEvent.secondBufferDuration);
    localSPReportEvent = this.mEvent;
    localSPReportEvent.totalBufferCount = (localSPReportEvent.secondBufferCount + 1);
    localSPReportEvent = this.mEvent;
    localSPReportEvent.playDuration += this.mEvent.stopPosition - this.mLastPlayPosition;
    long l = this.mPlayer.getDurationMs();
    localSPReportEvent = this.mEvent;
    if (l != 0L) {
      f1 = localSPReportEvent.seekDuration * 1.0F / (float)l;
    } else {
      f1 = 0.0F;
    }
    localSPReportEvent.seekPercent = f1;
    localSPReportEvent = this.mEvent;
    f1 = f2;
    if (l != 0L) {
      f1 = (float)localSPReportEvent.seekStartTime * 1.0F / (float)l;
    }
    localSPReportEvent.seekStartPercent = f1;
    checkAndWarning();
  }
  
  private void parseConfigMapToJson()
  {
    JSONObject localJSONObject = new JSONObject(this.mConfigMap);
    this.mEvent.configExt = localJSONObject.toString();
  }
  
  public void addConfigExt(String paramString, Object paramObject)
  {
    this.mConfigMap.put(paramString, paramObject);
  }
  
  public void addExtReportData(String paramString1, String paramString2)
  {
    this.mEvent.extReportData.put(paramString1, paramString2);
  }
  
  public void addExtReportData(Map<String, String> paramMap)
  {
    this.mEvent.extReportData.putAll(paramMap);
  }
  
  public void init(SuperPlayerMgr paramSuperPlayerMgr, int paramInt)
  {
    this.mPlayer = paramSuperPlayerMgr;
    this.mEvent = new SPReportEvent();
    this.mEvent.appId = SuperPlayerSDKMgr.getPlatform();
    paramSuperPlayerMgr = this.mEvent;
    paramSuperPlayerMgr.sceneId = paramInt;
    paramSuperPlayerMgr.sdkVersion = SuperPlayerSDKMgr.getSDKVersion();
    this.mEvent.hardwareLevel = HardwareUtil.judgeDeviceLevel(SuperPlayerSDKMgr.getContext());
    this.mEvent.deviceInfoJson = HardwareUtil.getDeviceInfoJson();
    this.mEvent.screenWidth = DisplayUtil.a();
    this.mEvent.screenHeight = DisplayUtil.b();
    this.mEvent.hdrSupport = HDRUtil.a();
  }
  
  public void onCodecReuseInfo(TPPlayerMsg.TPMediaCodecInfo paramTPMediaCodecInfo)
  {
    if (paramTPMediaCodecInfo == null) {
      return;
    }
    if (paramTPMediaCodecInfo.mediaType == TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_VIDEO)
    {
      if (paramTPMediaCodecInfo.infoType == TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_READY)
      {
        paramTPMediaCodecInfo = paramTPMediaCodecInfo.msg;
        this.mEvent.videoCodecJson = paramTPMediaCodecInfo;
        try
        {
          paramTPMediaCodecInfo = new JSONObject(paramTPMediaCodecInfo);
          this.mEvent.videoCodecEnable = paramTPMediaCodecInfo.optBoolean("reuseEnable");
          this.mEvent.videoCodecReused = paramTPMediaCodecInfo.optBoolean("isReuse");
          this.mEvent.videoTotalCodecDuration = paramTPMediaCodecInfo.optInt("totalCodec");
          return;
        }
        catch (Throwable paramTPMediaCodecInfo)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onCodecReuseInfo error:");
          ((StringBuilder)localObject).append(paramTPMediaCodecInfo.getMessage());
          LogUtil.e("SPReportHelper", ((StringBuilder)localObject).toString());
          return;
        }
      }
      if (paramTPMediaCodecInfo.infoType == TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_EXCEPTION)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("codec error:");
        ((StringBuilder)localObject).append(paramTPMediaCodecInfo.msg);
        LogUtil.e("SPReportHelper", ((StringBuilder)localObject).toString());
      }
    }
    try
    {
      localObject = new JSONObject(paramTPMediaCodecInfo.msg).optString("errorCode");
      this.mEvent.codecErrorCodeList = appendBySeparator(this.mEvent.codecErrorCodeList, (String)localObject, ";");
      this.mEvent.codecErrorMsgList = appendBySeparator(this.mEvent.codecErrorMsgList, paramTPMediaCodecInfo.msg, ";");
      return;
    }
    catch (Throwable localThrowable)
    {
      label235:
      break label235;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCodecReuseInfo error for jsonObject:");
    ((StringBuilder)localObject).append(paramTPMediaCodecInfo.msg);
    LogUtils.e("SPReportHelper", ((StringBuilder)localObject).toString());
  }
  
  public void onDownloadProgressUpdate(TPPlayerMsg.TPDownLoadProgressInfo paramTPDownLoadProgressInfo)
  {
    if (paramTPDownLoadProgressInfo != null) {
      this.mEvent.fileSize = paramTPDownLoadProgressInfo.totalFileSize;
    }
  }
  
  public void onError(String paramString1, String paramString2)
  {
    SPReportEvent localSPReportEvent = this.mEvent;
    localSPReportEvent.errCode = paramString1;
    localSPReportEvent.errDetailInfo = paramString2;
    long l = this.mPlayer.getCurrentPositionMs();
    paramString1 = this.mEvent;
    if (l <= 0L) {
      l = paramString1.stopPosition;
    }
    paramString1.stopPosition = l;
    this.mEvent.success = false;
  }
  
  public void onFirstVideoFrameRendered()
  {
    if ((this.mEvent.realRenderDuration == 0L) && (this.mStartPrepareTime != 0L)) {
      this.mEvent.realRenderDuration = (SystemClock.uptimeMillis() - this.mStartPrepareTime);
    }
  }
  
  public void onOpenMediaPlayer(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerOption paramSuperPlayerOption)
  {
    this.mHasReported = false;
    this.mHasStop = false;
    if (paramSuperPlayerOption != null)
    {
      addExtReportData(paramSuperPlayerOption.toReportMap());
      this.mIsPrePlay = paramSuperPlayerOption.isPrePlay;
      this.mEvent.quicEnableMode = paramSuperPlayerOption.superPlayerDownOption.quicEnableMode;
      this.mEvent.isEnableQuicPlaintext = paramSuperPlayerOption.superPlayerDownOption.enableQuicPlaintext;
      this.mEvent.isEnableQuicConnectionMigration = paramSuperPlayerOption.superPlayerDownOption.enableQuicConnectionMigration;
      this.mEvent.quicCongestionType = paramSuperPlayerOption.superPlayerDownOption.quicCongestionType;
    }
    this.mEvent.videoSource = paramSuperPlayerVideoInfo.getVideoSource();
    this.mEvent.vid = paramSuperPlayerVideoInfo.getVid();
    this.mEvent.url = paramSuperPlayerVideoInfo.getPlayUrl();
    paramSuperPlayerVideoInfo = this.mEvent;
    paramSuperPlayerVideoInfo.startPosition = paramLong;
    paramSuperPlayerVideoInfo.playDuration = 0L;
    this.mLastPlayPosition = paramLong;
    this.mStartPrepareTime = SystemClock.uptimeMillis();
  }
  
  public void onPrePlayViewShow()
  {
    if (!this.mIsPrePlay) {
      return;
    }
    this.mPrePlayViewShowCalled = true;
    if (this.mPrepared) {
      this.mEvent.prePlay = 1;
    } else {
      this.mEvent.prePlay = 2;
    }
    this.mVisibleStartPrepareTime = SystemClock.uptimeMillis();
  }
  
  public void onPrepared()
  {
    this.mPrepared = true;
    this.mEvent.width = this.mPlayer.getVideoWidth();
    this.mEvent.height = this.mPlayer.getVideoHeight();
    this.mEvent.duration = this.mPlayer.getDurationMs();
    this.mEvent.flowId = this.mPlayer.getFlowId();
    MediaInfo localMediaInfo = this.mPlayer.getMediaInfo();
    if (localMediaInfo != null)
    {
      this.mEvent.videoFormat = localMediaInfo.getContainerFormat();
      this.mEvent.videoCodec = localMediaInfo.getVideoCodec();
      this.mEvent.videoProfile = localMediaInfo.getVideoProfile();
      this.mEvent.codecMimeType = localMediaInfo.getCodecMimeType();
    }
    if ((this.mEvent.realPrepareDuration == 0L) && (this.mStartPrepareTime != 0L)) {
      this.mEvent.realPrepareDuration = (SystemClock.uptimeMillis() - this.mStartPrepareTime);
    }
  }
  
  public void onQuicInfoUpdate(String paramString)
  {
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onQuicInfoUpdate jsonObject:");
      ((StringBuilder)localObject1).append(paramString);
      LogUtils.d("SPReportHelper", ((StringBuilder)localObject1).toString());
      localObject1 = new JSONObject(paramString);
      if (((JSONObject)localObject1).has("isDownloadByQuic")) {
        this.mEvent.isDownloadByQuic = true;
      }
      boolean bool = ((JSONObject)localObject1).has("downloadComplete");
      Object localObject2;
      if (bool)
      {
        localObject2 = ((JSONObject)localObject1).getString("downloadComplete");
        if (TextUtils.equals((CharSequence)localObject2, "quic"))
        {
          localObject2 = this.mEvent;
          ((SPReportEvent)localObject2).quicDownloadCompleteCnt += 1;
        }
        else if (TextUtils.equals((CharSequence)localObject2, "http"))
        {
          localObject2 = this.mEvent;
          ((SPReportEvent)localObject2).httpDownloadCompleteCnt += 1;
        }
      }
      if (((JSONObject)localObject1).has("downloadFailed"))
      {
        localObject2 = ((JSONObject)localObject1).getString("downloadFailed");
        if (TextUtils.equals((CharSequence)localObject2, "quic"))
        {
          localObject2 = this.mEvent;
          ((SPReportEvent)localObject2).quicDownloadFailCnt += 1;
        }
        else if (TextUtils.equals((CharSequence)localObject2, "http"))
        {
          localObject2 = this.mEvent;
          ((SPReportEvent)localObject2).httpDownloadFailCnt += 1;
        }
      }
      if (((JSONObject)localObject1).has("isDownloadByQuicPlaintext"))
      {
        localObject2 = ((JSONObject)localObject1).getString("isDownloadByQuicPlaintext");
        this.mEvent.isDownloadByQuicPlaintext = TextUtils.equals("true", (CharSequence)localObject2);
      }
      if (((JSONObject)localObject1).has("ServerIP")) {
        this.mEvent.headerServerIP = ((JSONObject)localObject1).optString("ServerIP");
      }
      if (((JSONObject)localObject1).has("ClientIP")) {
        this.mEvent.headerClientIP = ((JSONObject)localObject1).optString("ClientIP");
      }
      if (!((JSONObject)localObject1).has("CDNIP")) {
        break label358;
      }
      this.mEvent.CDNIP = ((JSONObject)localObject1).optString("CDNIP");
      return;
    }
    catch (JSONException localJSONException)
    {
      Object localObject1;
      label327:
      label358:
      break label327;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onQuicInfoUpdate error for jsonObject:");
    ((StringBuilder)localObject1).append(paramString);
    LogUtils.e("SPReportHelper", ((StringBuilder)localObject1).toString());
  }
  
  public void onRelease()
  {
    if (!this.mHasStop)
    {
      long l = this.mPlayer.getCurrentPositionMs();
      SPReportEvent localSPReportEvent = this.mEvent;
      if (l <= 0L) {
        l = localSPReportEvent.stopPosition;
      }
      localSPReportEvent.stopPosition = l;
    }
    report();
  }
  
  public void onSeek(long paramLong1, long paramLong2)
  {
    SPReportEvent localSPReportEvent = this.mEvent;
    localSPReportEvent.playDuration += paramLong1 - this.mLastPlayPosition;
    localSPReportEvent = this.mEvent;
    localSPReportEvent.hadSeek = true;
    localSPReportEvent.seekCount += 1;
    localSPReportEvent = this.mEvent;
    localSPReportEvent.seekDuration = ((int)(localSPReportEvent.seekDuration + Math.abs(paramLong2 - paramLong1)));
    if (this.mEvent.seekStartTime == 0L) {
      this.mEvent.seekStartTime = paramLong1;
    }
    this.mHasStartSeek = true;
    this.mLastPlayPosition = paramLong2;
  }
  
  public void onSeekComplete()
  {
    this.mHasStartSeek = false;
  }
  
  public void onStart()
  {
    this.mEvent.hadStart = true;
  }
  
  public void onStop()
  {
    long l = this.mPlayer.getCurrentPositionMs();
    SPReportEvent localSPReportEvent = this.mEvent;
    if (l <= 0L) {
      l = localSPReportEvent.stopPosition;
    }
    localSPReportEvent.stopPosition = l;
    this.mHasStop = true;
    report();
  }
  
  public void onVideoBufferEnd()
  {
    long l;
    if (this.mStartBufferTime != 0L)
    {
      l = SystemClock.uptimeMillis() - this.mStartBufferTime;
      localSPReportEvent = this.mEvent;
      localSPReportEvent.secondBufferDuration += l;
    }
    else
    {
      l = 0L;
    }
    SPReportEvent localSPReportEvent = this.mEvent;
    localSPReportEvent.secondBufferCount += 1;
    this.mStartBufferTime = 0L;
    if (this.mHasStartSeek)
    {
      localSPReportEvent = this.mEvent;
      localSPReportEvent.seekBufferCount += 1;
      localSPReportEvent = this.mEvent;
      localSPReportEvent.seekBufferDuration = ((int)(localSPReportEvent.seekBufferDuration + l));
    }
  }
  
  public void onVideoBufferStart()
  {
    this.mStartBufferTime = SystemClock.uptimeMillis();
  }
  
  public void onVideoFrameCheckResult(int paramInt)
  {
    this.mEvent.videoFrameCheckCode = paramInt;
  }
  
  public void report()
  {
    if (this.mHasReported)
    {
      LogUtil.d("SPReportHelper", "report ignore for has reported.");
      return;
    }
    this.mHasReported = true;
    doBeforeReport();
    Map localMap = this.mEvent.getDataMap();
    SPBeaconReporter.report(this.mEvent.getEventName(), localMap);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report dataMap:");
    localStringBuilder.append(localMap);
    LogUtil.d("SPReportHelper", localStringBuilder.toString());
  }
  
  public void reset()
  {
    try
    {
      long l = this.mPlayer.getCurrentPositionMs();
      SPReportEvent localSPReportEvent = this.mEvent;
      if (l <= 0L) {
        l = this.mEvent.stopPosition;
      }
      localSPReportEvent.stopPosition = l;
      report();
      this.mStartPrepareTime = 0L;
      this.mStartBufferTime = 0L;
      this.mVisibleStartPrepareTime = 0L;
      this.mIsPrePlay = false;
      this.mPrepared = false;
      this.mPrePlayViewShowCalled = false;
      int i = this.mEvent.sceneId;
      init(this.mPlayer, i);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.report.SPReportHelper
 * JD-Core Version:    0.7.0.1
 */