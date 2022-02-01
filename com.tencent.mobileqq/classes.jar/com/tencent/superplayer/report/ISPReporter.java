package com.tencent.superplayer.report;

import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.player.SuperPlayerMgr;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import java.util.Map;

public abstract interface ISPReporter
{
  public abstract void addConfigExt(String paramString, Object paramObject);
  
  public abstract void addExtReportData(String paramString1, String paramString2);
  
  public abstract void addExtReportData(Map<String, String> paramMap);
  
  public abstract void init(SuperPlayerMgr paramSuperPlayerMgr, int paramInt);
  
  public abstract void onCodecReuseInfo(TPPlayerMsg.TPMediaCodecInfo paramTPMediaCodecInfo);
  
  public abstract void onDownloadProgressUpdate(TPPlayerMsg.TPDownLoadProgressInfo paramTPDownLoadProgressInfo);
  
  public abstract void onError(String paramString1, String paramString2);
  
  public abstract void onFirstVideoFrameRendered();
  
  public abstract void onOpenMediaPlayer(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerOption paramSuperPlayerOption);
  
  public abstract void onPrePlayViewShow();
  
  public abstract void onPrepared();
  
  public abstract void onQuicInfoUpdate(String paramString);
  
  public abstract void onRelease();
  
  public abstract void onSeek(long paramLong1, long paramLong2);
  
  public abstract void onSeekComplete();
  
  public abstract void onStart();
  
  public abstract void onStop();
  
  public abstract void onVideoBufferEnd();
  
  public abstract void onVideoBufferStart();
  
  public abstract void onVideoFrameCheckResult(int paramInt);
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.report.ISPReporter
 * JD-Core Version:    0.7.0.1
 */