package com.tencent.superplayer.report;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.player.SuperPlayerMgr;
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
    return paramString1 + paramString3 + paramString2;
  }
  
  private void checkAndWarning()
  {
    if ((this.mIsPrePlay) && (!this.mPrePlayViewShowCalled)) {
      LogUtil.w("SPReportHelper", "Player is prePlay, but prePlayViewShow not called.");
    }
  }
  
  private void doBeforeReport()
  {
    float f2 = 0.0F;
    parseConfigMapToJson();
    this.mEvent.stopPosition = this.mPlayer.getCurrentPositionMs();
    float f1 = (float)this.mEvent.duration / 1000.0F;
    if (f1 != 0.0F) {
      this.mEvent.bitrate = ((float)this.mEvent.fileSize / 1024.0F * 8.0F / f1);
    }
    SPReportEvent localSPReportEvent;
    long l;
    if (this.mEvent.prePlay == 0)
    {
      this.mEvent.prepareDuration = this.mEvent.realPrepareDuration;
      this.mEvent.renderDuration = this.mEvent.realRenderDuration;
      this.mEvent.totalBufferDuration = (this.mEvent.realPrepareDuration + this.mEvent.secondBufferDuration);
      this.mEvent.totalBufferCount = (this.mEvent.secondBufferCount + 1);
      localSPReportEvent = this.mEvent;
      localSPReportEvent.playDuration += this.mEvent.stopPosition - this.mLastPlayPosition;
      l = this.mPlayer.getDurationMs();
      localSPReportEvent = this.mEvent;
      if (l == 0L) {
        break label344;
      }
    }
    label344:
    for (f1 = this.mEvent.seekDuration * 1.0F / (float)l;; f1 = 0.0F)
    {
      localSPReportEvent.seekPercent = f1;
      localSPReportEvent = this.mEvent;
      f1 = f2;
      if (l != 0L) {
        f1 = (float)this.mEvent.seekStartTime * 1.0F / (float)l;
      }
      localSPReportEvent.seekStartPercent = f1;
      checkAndWarning();
      return;
      if (this.mEvent.prePlay == 2)
      {
        l = this.mVisibleStartPrepareTime - this.mStartPrepareTime;
        this.mEvent.prepareDuration = (this.mEvent.realPrepareDuration - l);
        this.mEvent.renderDuration = (this.mEvent.realRenderDuration - l);
        if (l >= 0L) {
          break;
        }
        LogUtil.e("SPReportHelper", "doBeforeReport prePlayOffsetDuration error, for prePlayOffsetDuration < 0");
        break;
      }
      if (this.mEvent.prePlay != 1) {
        break;
      }
      this.mEvent.prepareDuration = 0L;
      this.mEvent.renderDuration = 0L;
      break;
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
    this.mEvent.sceneId = paramInt;
    this.mEvent.sdkVersion = SuperPlayerSDKMgr.getSDKVersion();
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
          LogUtil.e("SPReportHelper", "onCodecReuseInfo error:" + paramTPMediaCodecInfo.getMessage());
          return;
        }
      }
    } while (paramTPMediaCodecInfo.infoType != TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_EXCEPTION);
    LogUtil.e("SPReportHelper", "codec error:" + paramTPMediaCodecInfo.msg);
    try
    {
      String str = new JSONObject(paramTPMediaCodecInfo.msg).optString("errorCode");
      this.mEvent.codecErrorCodeList = appendBySeparator(this.mEvent.codecErrorCodeList, str, ";");
      this.mEvent.codecErrorMsgList = appendBySeparator(this.mEvent.codecErrorMsgList, paramTPMediaCodecInfo.msg, ";");
      return;
    }
    catch (Throwable localThrowable)
    {
      LogUtils.e("SPReportHelper", "onCodecReuseInfo error for jsonObject:" + paramTPMediaCodecInfo.msg);
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
    long l = this.mPlayer.getCurrentPositionMs();
    paramString1 = this.mEvent;
    if (l > 0L) {}
    for (;;)
    {
      paramString1.stopPosition = l;
      this.mEvent.success = false;
      return;
      l = this.mEvent.stopPosition;
    }
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
      this.mEvent.isEnableQuic = paramSuperPlayerOption.superPlayerDownOption.enableUseQuic;
      this.mEvent.isEnableQuicPlaintext = paramSuperPlayerOption.superPlayerDownOption.enableQuicPlaintext;
      this.mEvent.isEnableQuicConnectionMigration = paramSuperPlayerOption.superPlayerDownOption.enableQuicConnectionMigration;
      this.mEvent.quicCongestionType = paramSuperPlayerOption.superPlayerDownOption.quicCongestionType;
    }
    this.mEvent.videoSource = paramSuperPlayerVideoInfo.getVideoSource();
    this.mEvent.vid = paramSuperPlayerVideoInfo.getVid();
    this.mEvent.url = paramSuperPlayerVideoInfo.getPlayUrl();
    this.mEvent.startPosition = paramLong;
    this.mEvent.playDuration = 0L;
    this.mLastPlayPosition = paramLong;
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
  
  public void onQuicInfoUpdate(String paramString)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("isDownloadByQuic")) {
          this.mEvent.isDownloadByQuic = true;
        }
        if (localJSONObject.has("downloadComplete"))
        {
          localObject = localJSONObject.getString("downloadComplete");
          if (TextUtils.equals((CharSequence)localObject, "quic"))
          {
            localObject = this.mEvent;
            ((SPReportEvent)localObject).quicDownloadCompleteCnt += 1;
          }
        }
        else
        {
          if (localJSONObject.has("downloadFailed"))
          {
            localObject = localJSONObject.getString("downloadFailed");
            if (!TextUtils.equals((CharSequence)localObject, "quic")) {
              break label273;
            }
            localObject = this.mEvent;
            ((SPReportEvent)localObject).quicDownloadFailCnt += 1;
          }
          if (localJSONObject.has("isDownloadByQuicPlaintext"))
          {
            localObject = localJSONObject.getString("isDownloadByQuicPlaintext");
            this.mEvent.isDownloadByQuicPlaintext = TextUtils.equals("true", (CharSequence)localObject);
          }
          if (localJSONObject.has("ServerIP")) {
            this.mEvent.headerServerIP = localJSONObject.optString("ServerIP");
          }
          if (localJSONObject.has("ClientIP")) {
            this.mEvent.headerClientIP = localJSONObject.optString("ClientIP");
          }
          if (!localJSONObject.has("CDNIP")) {
            break;
          }
          this.mEvent.CDNIP = localJSONObject.optString("CDNIP");
          return;
        }
        if (!TextUtils.equals((CharSequence)localObject, "http")) {
          continue;
        }
        localObject = this.mEvent;
        ((SPReportEvent)localObject).httpDownloadCompleteCnt += 1;
        continue;
        if (!TextUtils.equals((CharSequence)localObject, "http")) {
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        LogUtils.e("SPReportHelper", "onQuicInfoUpdate error for jsonObject:" + paramString);
        return;
      }
      label273:
      Object localObject = this.mEvent;
      ((SPReportEvent)localObject).httpDownloadFailCnt += 1;
    }
  }
  
  public void onRelease()
  {
    long l;
    SPReportEvent localSPReportEvent;
    if (!this.mHasStop)
    {
      l = this.mPlayer.getCurrentPositionMs();
      localSPReportEvent = this.mEvent;
      if (l <= 0L) {
        break label36;
      }
    }
    for (;;)
    {
      localSPReportEvent.stopPosition = l;
      report();
      return;
      label36:
      l = this.mEvent.stopPosition;
    }
  }
  
  public void onSeek(long paramLong1, long paramLong2)
  {
    SPReportEvent localSPReportEvent = this.mEvent;
    localSPReportEvent.playDuration += paramLong1 - this.mLastPlayPosition;
    this.mEvent.hadSeek = true;
    localSPReportEvent = this.mEvent;
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
    if (l > 0L) {}
    for (;;)
    {
      localSPReportEvent.stopPosition = l;
      this.mHasStop = true;
      report();
      return;
      l = this.mEvent.stopPosition;
    }
  }
  
  public void onVideoBufferEnd()
  {
    long l;
    SPReportEvent localSPReportEvent;
    if (this.mStartBufferTime != 0L)
    {
      l = SystemClock.uptimeMillis() - this.mStartBufferTime;
      localSPReportEvent = this.mEvent;
      localSPReportEvent.secondBufferDuration += l;
    }
    for (;;)
    {
      localSPReportEvent = this.mEvent;
      localSPReportEvent.secondBufferCount += 1;
      this.mStartBufferTime = 0L;
      if (this.mHasStartSeek)
      {
        localSPReportEvent = this.mEvent;
        localSPReportEvent.seekBufferCount += 1;
        localSPReportEvent = this.mEvent;
        localSPReportEvent.seekBufferDuration = ((int)(l + localSPReportEvent.seekBufferDuration));
      }
      return;
      l = 0L;
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
    LogUtil.d("SPReportHelper", "report dataMap:" + localMap);
  }
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 98	com/tencent/superplayer/report/SPReportHelper:mPlayer	Lcom/tencent/superplayer/player/SuperPlayerMgr;
    //   6: invokevirtual 104	com/tencent/superplayer/player/SuperPlayerMgr:getCurrentPositionMs	()J
    //   9: lstore_2
    //   10: aload_0
    //   11: getfield 96	com/tencent/superplayer/report/SPReportHelper:mEvent	Lcom/tencent/superplayer/report/SPReportEvent;
    //   14: astore 4
    //   16: lload_2
    //   17: lconst_0
    //   18: lcmp
    //   19: ifle +63 -> 82
    //   22: aload 4
    //   24: lload_2
    //   25: putfield 109	com/tencent/superplayer/report/SPReportEvent:stopPosition	J
    //   28: aload_0
    //   29: invokevirtual 520	com/tencent/superplayer/report/SPReportHelper:report	()V
    //   32: aload_0
    //   33: lconst_0
    //   34: putfield 38	com/tencent/superplayer/report/SPReportHelper:mStartPrepareTime	J
    //   37: aload_0
    //   38: lconst_0
    //   39: putfield 42	com/tencent/superplayer/report/SPReportHelper:mStartBufferTime	J
    //   42: aload_0
    //   43: lconst_0
    //   44: putfield 40	com/tencent/superplayer/report/SPReportHelper:mVisibleStartPrepareTime	J
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 46	com/tencent/superplayer/report/SPReportHelper:mIsPrePlay	Z
    //   52: aload_0
    //   53: iconst_0
    //   54: putfield 48	com/tencent/superplayer/report/SPReportHelper:mPrepared	Z
    //   57: aload_0
    //   58: iconst_0
    //   59: putfield 52	com/tencent/superplayer/report/SPReportHelper:mPrePlayViewShowCalled	Z
    //   62: aload_0
    //   63: getfield 96	com/tencent/superplayer/report/SPReportHelper:mEvent	Lcom/tencent/superplayer/report/SPReportEvent;
    //   66: getfield 216	com/tencent/superplayer/report/SPReportEvent:sceneId	I
    //   69: istore_1
    //   70: aload_0
    //   71: aload_0
    //   72: getfield 98	com/tencent/superplayer/report/SPReportHelper:mPlayer	Lcom/tencent/superplayer/player/SuperPlayerMgr;
    //   75: iload_1
    //   76: invokevirtual 579	com/tencent/superplayer/report/SPReportHelper:init	(Lcom/tencent/superplayer/player/SuperPlayerMgr;I)V
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: aload_0
    //   83: getfield 96	com/tencent/superplayer/report/SPReportHelper:mEvent	Lcom/tencent/superplayer/report/SPReportEvent;
    //   86: getfield 109	com/tencent/superplayer/report/SPReportEvent:stopPosition	J
    //   89: lstore_2
    //   90: goto -68 -> 22
    //   93: astore 4
    //   95: aload_0
    //   96: monitorexit
    //   97: aload 4
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	SPReportHelper
    //   69	7	1	i	int
    //   9	81	2	l	long
    //   14	9	4	localSPReportEvent	SPReportEvent
    //   93	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	93	finally
    //   22	79	93	finally
    //   82	90	93	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.report.SPReportHelper
 * JD-Core Version:    0.7.0.1
 */