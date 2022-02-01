package com.tencent.superplayer.datatransport;

import com.tencent.superplayer.api.ISPlayerPreDownloader.Listener;
import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy.IPreloadListener;
import java.util.Hashtable;

class SPlayerPreDownloaderImpl$2
  implements ITPPreloadProxy.IPreloadListener
{
  SPlayerPreDownloaderImpl$2(SPlayerPreDownloaderImpl paramSPlayerPreDownloaderImpl, int paramInt) {}
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (SPlayerPreDownloaderImpl.access$100(this.this$0) != null) {
      SPlayerPreDownloaderImpl.access$100(this.this$0).onPrepareDownloadProgressUpdate(this.val$taskid, paramInt1, paramInt2, paramLong1, paramLong2);
    }
  }
  
  public void onPrepareError()
  {
    SPlayerPreDownloaderImpl.access$200(this.this$0).remove(Integer.valueOf(this.val$taskid));
    if (SPlayerPreDownloaderImpl.access$100(this.this$0) != null) {
      SPlayerPreDownloaderImpl.access$100(this.this$0).onPrepareError(this.val$taskid);
    }
  }
  
  public void onPrepareSuccess()
  {
    SPlayerPreDownloaderImpl.access$200(this.this$0).remove(Integer.valueOf(this.val$taskid));
    if (SPlayerPreDownloaderImpl.access$100(this.this$0) != null) {
      SPlayerPreDownloaderImpl.access$100(this.this$0).onPrepareSuccess(this.val$taskid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPlayerPreDownloaderImpl.2
 * JD-Core Version:    0.7.0.1
 */