package com.tencent.superplayer.report;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.player.SuperPlayerMgr;
import com.tencent.superplayer.utils.HardwareUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.NetworkUtil;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.tmediacodec.util.LogUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class SPReportHelper
  implements ISPReporter
{
  public static final String SEPARATOR = ";";
  private static final String TAG = "MediaPlayerMgr.SPReportHelper";
  private Map<String, Object> mConfigMap = new HashMap();
  private SPReportEvent mEvent;
  private boolean mHasReported = false;
  private boolean mIsPrePlay = false;
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
    return paramString1 + paramString3 + paramString2;
  }
  
  private void checkAndWarning()
  {
    if ((this.mIsPrePlay) && (!this.mPrePlayViewShowCalled)) {
      LogUtil.w("MediaPlayerMgr.SPReportHelper", "Player is prePlay, but prePlayViewShow not called.");
    }
  }
  
  private void doBeforeReport()
  {
    parseConfigMapToJson();
    float f = (float)this.mEvent.duration / 1000.0F;
    if (f != 0.0F) {
      this.mEvent.bitrate = ((float)this.mEvent.fileSize / 1024.0F * 8.0F / f);
    }
    if (this.mEvent.prePlay == 0)
    {
      this.mEvent.prepareDuration = this.mEvent.realPrepareDuration;
      this.mEvent.renderDuration = this.mEvent.realRenderDuration;
    }
    for (;;)
    {
      SPReportEvent localSPReportEvent = this.mEvent;
      localSPReportEvent.totalBufferDuration += this.mEvent.secondBufferDuration;
      localSPReportEvent = this.mEvent;
      localSPReportEvent.totalBufferCount += 1;
      checkAndWarning();
      return;
      if (this.mEvent.prePlay == 2)
      {
        long l = this.mVisibleStartPrepareTime - this.mStartPrepareTime;
        this.mEvent.prepareDuration = (this.mEvent.realPrepareDuration - l);
        this.mEvent.renderDuration = (this.mEvent.realRenderDuration - l);
        if (l < 0L) {
          LogUtil.e("MediaPlayerMgr.SPReportHelper", "doBeforeReport prePlayOffsetDuration error, for prePlayOffsetDuration < 0");
        }
      }
      else if (this.mEvent.prePlay == 1)
      {
        this.mEvent.prepareDuration = 0L;
        this.mEvent.renderDuration = 0L;
      }
    }
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
  
  public void init(SuperPlayerMgr paramSuperPlayerMgr, int paramInt)
  {
    this.mPlayer = paramSuperPlayerMgr;
    this.mEvent = new SPReportEvent();
    this.mEvent.appId = SuperPlayerSDKMgr.getPlatform();
    this.mEvent.sceneId = paramInt;
    this.mEvent.sdkVersion = SuperPlayerSDKMgr.getSDKVersion();
    this.mEvent.netType = NetworkUtil.getNetWorkType();
    this.mEvent.hardwareLevel = HardwareUtil.judgeDeviceLevel(SuperPlayerSDKMgr.getContext());
    this.mEvent.deviceInfoJson = HardwareUtil.getDeviceInfoJson();
  }
  
  public void onCodecReuseInfo(TPPlayerMsg.TPMediaCodecInfo paramTPMediaCodecInfo)
  {
    if (paramTPMediaCodecInfo == null) {}
    do
    {
      do
      {
        return;
      } while (paramTPMediaCodecInfo.mediaType != TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_VIDEO);
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
          LogUtil.e("MediaPlayerMgr.SPReportHelper", "onCodecReuseInfo error:" + paramTPMediaCodecInfo.getMessage());
          return;
        }
      }
    } while (paramTPMediaCodecInfo.infoType != TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_EXCEPTION);
    LogUtil.e("MediaPlayerMgr.SPReportHelper", "codec error:" + paramTPMediaCodecInfo.msg);
    try
    {
      String str = new JSONObject(paramTPMediaCodecInfo.msg).optString("errorCode");
      this.mEvent.codecErrorCodeList = appendBySeparator(this.mEvent.codecErrorCodeList, str, ";");
      this.mEvent.codecErrorMsgList = appendBySeparator(this.mEvent.codecErrorMsgList, paramTPMediaCodecInfo.msg, ";");
      return;
    }
    catch (Throwable localThrowable)
    {
      LogUtils.e("MediaPlayerMgr.SPReportHelper", "onCodecReuseInfo error for jsonObject:" + paramTPMediaCodecInfo.msg);
    }
  }
  
  public void onDownloadProgressUpdate(TPPlayerMsg.TPDownLoadProgressInfo paramTPDownLoadProgressInfo)
  {
    if (paramTPDownLoadProgressInfo != null) {
      this.mEvent.fileSize = paramTPDownLoadProgressInfo.totalFileSize;
    }
  }
  
  public void onError(String paramString1, String paramString2)
  {
    this.mEvent.errCode = paramString1;
    this.mEvent.errDetailInfo = paramString2;
    report();
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
    if (paramSuperPlayerOption != null)
    {
      addConfigExt("playerConfigExt", paramSuperPlayerOption.toJsonString());
      this.mIsPrePlay = paramSuperPlayerOption.isPrePlay;
    }
    this.mEvent.videoSource = paramSuperPlayerVideoInfo.getVideoSource();
    this.mEvent.vid = paramSuperPlayerVideoInfo.getVid();
    this.mEvent.url = paramSuperPlayerVideoInfo.getPlayUrl();
    this.mEvent.startPosition = paramLong;
    this.mStartPrepareTime = SystemClock.uptimeMillis();
  }
  
  public void onPrePlayViewShow()
  {
    if (!this.mIsPrePlay) {
      return;
    }
    this.mPrePlayViewShowCalled = true;
    if (this.mPrepared) {}
    for (this.mEvent.prePlay = 1;; this.mEvent.prePlay = 2)
    {
      this.mVisibleStartPrepareTime = SystemClock.uptimeMillis();
      return;
    }
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
  
  public void onStop()
  {
    this.mEvent.stopPosition = this.mPlayer.getCurrentPositionMs();
    report();
  }
  
  public void onVideoBufferEnd()
  {
    if (this.mStartBufferTime != 0L)
    {
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.mStartBufferTime;
      localSPReportEvent = this.mEvent;
      localSPReportEvent.secondBufferDuration = (l1 - l2 + localSPReportEvent.secondBufferDuration);
    }
    SPReportEvent localSPReportEvent = this.mEvent;
    localSPReportEvent.secondBufferCount += 1;
    this.mStartBufferTime = 0L;
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
      LogUtil.d("MediaPlayerMgr.SPReportHelper", "report ignore for has reported.");
      return;
    }
    this.mHasReported = true;
    doBeforeReport();
    Map localMap = this.mEvent.getDataMap();
    SPBeaconReporter.report(this.mEvent.getEventName(), localMap);
    LogUtil.d("MediaPlayerMgr.SPReportHelper", "report dataMap:" + localMap);
  }
  
  public void reset()
  {
    try
    {
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
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.report.SPReportHelper
 * JD-Core Version:    0.7.0.1
 */