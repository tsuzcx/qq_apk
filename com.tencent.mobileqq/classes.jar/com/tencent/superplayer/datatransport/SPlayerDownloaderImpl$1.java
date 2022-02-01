package com.tencent.superplayer.datatransport;

import com.tencent.superplayer.api.ISPlayerDownloader.Listener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener;
import java.util.Map;

class SPlayerDownloaderImpl$1
  implements ITPOfflineDownloadListener
{
  SPlayerDownloaderImpl$1(SPlayerDownloaderImpl paramSPlayerDownloaderImpl, ISPlayerDownloader.Listener paramListener, int paramInt) {}
  
  public void onDownloadCdnUrlExpired(Map<String, String> paramMap)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadCdnUrlExpired(this.val$taskId, paramMap);
    }
  }
  
  public void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadCdnUrlInfoUpdate(this.val$taskId, paramString1, paramString2, paramString3, paramString4);
    }
  }
  
  public void onDownloadCdnUrlUpdate(String paramString)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadCdnUrlUpdate(this.val$taskId, paramString);
    }
  }
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadError(this.val$taskId, paramInt1, paramInt2, paramString);
    }
  }
  
  public void onDownloadFinish()
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadFinish(this.val$taskId);
    }
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadProgressUpdate(this.val$taskId, paramInt1, paramInt2, paramLong1, paramLong2, paramString);
    }
  }
  
  public void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadProtocolUpdate(this.val$taskId, paramString1, paramString2);
    }
  }
  
  public void onDownloadStatusUpdate(int paramInt)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadStatusUpdate(this.val$taskId, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPlayerDownloaderImpl.1
 * JD-Core Version:    0.7.0.1
 */