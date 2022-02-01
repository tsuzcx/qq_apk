package com.tencent.thumbplayer.core.downloadproxy.api;

import java.util.Map;

public abstract interface ITPPlayListener
{
  public static final int MESSAGE_FLV_PRELOAD_STATUS = 5;
  public static final int MESSAGE_HTTP_HEADER = 3;
  public static final int MESSAGE_NOTIFY_M3U8_CONTENT = 4;
  public static final int MESSAGE_NOTIFY_PLAYER_SWITCH_DEFINITION = 2;
  public static final int MESSAGE_PLAY_VIDEO_NO_MORE_CACHE = 1;
  
  public abstract long getAdvRemainTime();
  
  public abstract String getContentType(int paramInt, String paramString);
  
  public abstract int getCurrentPlayClipNo();
  
  public abstract long getCurrentPosition();
  
  public abstract String getDataFilePath(int paramInt, String paramString);
  
  public abstract long getDataTotalSize(int paramInt, String paramString);
  
  public abstract Object getPlayInfo(long paramLong);
  
  public abstract Object getPlayInfo(String paramString);
  
  public abstract long getPlayerBufferLength();
  
  public abstract void onDownloadCdnUrlExpired(Map<String, String> paramMap);
  
  public abstract void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void onDownloadCdnUrlUpdate(String paramString);
  
  public abstract void onDownloadError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onDownloadFinish();
  
  public abstract void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString);
  
  public abstract void onDownloadProtocolUpdate(String paramString1, String paramString2);
  
  public abstract void onDownloadStatusUpdate(int paramInt);
  
  public abstract void onPcdnDownloadFailed(String paramString);
  
  public abstract Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4);
  
  public abstract void onQuicDownloadStatusUpdate(String paramString);
  
  public abstract int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2);
  
  public abstract int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2);
  
  public abstract int onStopReadData(int paramInt1, String paramString, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
 * JD-Core Version:    0.7.0.1
 */