package com.tencent.superplayer.datatransport;

import com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener;
import java.util.Map;

class SPlayerDownloadMgr$1
  implements ITPOfflineDownloadListener
{
  SPlayerDownloadMgr$1(SPlayerDownloadMgr paramSPlayerDownloadMgr, SPlayerDownloadMgr.ISPlayerOfflineDownloadListener paramISPlayerOfflineDownloadListener) {}
  
  public void onDownloadCdnUrlExpired(Map<String, String> paramMap)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadCdnUrlExpired(paramMap);
    }
  }
  
  public void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
    }
  }
  
  public void onDownloadCdnUrlUpdate(String paramString)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadCdnUrlUpdate(paramString);
    }
  }
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadError(paramInt1, paramInt2, paramString);
    }
  }
  
  public void onDownloadFinish()
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadFinish();
    }
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2);
    }
  }
  
  public void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadProtocolUpdate(paramString1, paramString2);
    }
  }
  
  public void onDownloadStatusUpdate(int paramInt)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadStatusUpdate(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPlayerDownloadMgr.1
 * JD-Core Version:    0.7.0.1
 */