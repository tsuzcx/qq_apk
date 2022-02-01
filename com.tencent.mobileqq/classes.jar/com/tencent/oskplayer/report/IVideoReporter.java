package com.tencent.oskplayer.report;

import java.util.Map;

public abstract interface IVideoReporter
{
  public static final String SALT_LIVEVIDEO = "liveVideo";
  
  public abstract void addVideoPlayTimeRange(String paramString, long paramLong);
  
  public abstract void addVideoVisibilityEvent(Map<String, String> paramMap);
  
  public abstract void bufferingBegin(String paramString, boolean paramBoolean);
  
  public abstract void bufferingEnd(String paramString, boolean paramBoolean);
  
  public abstract void cancelPlayVideo(String paramString);
  
  public abstract void completePlayVideo(String paramString);
  
  public abstract void downloadResult(String paramString, long paramLong, Map<String, Object> paramMap);
  
  public abstract void downloadServerCost(String paramString, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void downloadServerIp(String paramString1, String paramString2);
  
  public abstract void downloadSizeAndDuration(String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  
  public abstract void failPlayVideo(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2);
  
  public abstract long getLocalStoreTotalCountLimit();
  
  public abstract ReportState getReportState(String paramString);
  
  public abstract void getSafeUrlOccurred(long paramLong);
  
  public abstract void justReportVideoEventToDc00321(String paramString, long paramLong);
  
  public abstract void loopPlayVideo(String paramString);
  
  public abstract void mediaPlayerOnInfo(String paramString, int paramInt1, int paramInt2);
  
  public abstract void preLoadOccurred(String paramString, long paramLong);
  
  public abstract void prepareAdvVideoReportInfo(String paramString, int paramInt);
  
  public abstract void prepareReportForDc00321(Object paramObject);
  
  public abstract void progressBarSeekingBegin(String paramString, long paramLong, boolean paramBoolean);
  
  public abstract void progressBarSeekingEnd(String paramString, long paramLong);
  
  public abstract void realPlayVideo(String paramString, boolean paramBoolean);
  
  public abstract void reportDecreaseRate(String paramString, int paramInt);
  
  public abstract void reportFirstRender(String paramString);
  
  public abstract void reportPreloadOccured(String paramString, boolean paramBoolean);
  
  public abstract void reportVideoDecodeScore(int paramInt);
  
  public abstract void setExtraData(String paramString1, String paramString2, Object paramObject);
  
  public abstract void setVideoDurationAndStartPlayPosition(String paramString, long paramLong1, long paramLong2);
  
  public abstract void setVideoResolution(String paramString, long paramLong1, long paramLong2);
  
  public abstract void setVideoUuid(String paramString);
  
  public abstract void startPlayVideo(String paramString1, String paramString2, long paramLong1, long paramLong2, boolean paramBoolean1, String paramString3, int paramInt, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract void startPlayVideo(String paramString1, String paramString2, long paramLong1, long paramLong2, boolean paramBoolean1, String paramString3, int paramInt1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2);
  
  public abstract void startPlayVideo(String paramString1, String paramString2, long paramLong1, long paramLong2, boolean paramBoolean1, String paramString3, int paramInt1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, boolean paramBoolean4);
  
  public abstract void stopPlayVideo(String paramString, long paramLong, int paramInt);
  
  public abstract void updatePlayScreenState(String paramString, boolean paramBoolean);
  
  public abstract void urlRedirectOccurred(String paramString1, String paramString2, long paramLong1, long paramLong2);
  
  public abstract void vKeyUpdateOccurred(String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.report.IVideoReporter
 * JD-Core Version:    0.7.0.1
 */