package com.tencent.superplayer.datatransport;

import com.tencent.superplayer.api.ISPlayerPreDownloader.Listener;
import com.tencent.superplayer.api.SuperPlayerMsg;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.report.SPPredownloadEvent;
import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy.IPreloadListener;
import java.util.Hashtable;

class SPlayerPreDownloaderImpl$4
  implements ITPPreloadProxy.IPreloadListener
{
  SPPredownloadEvent event = new SPPredownloadEvent(this.val$videoInfo, SPlayerPreDownloaderImpl.access$300(this.this$0));
  
  SPlayerPreDownloaderImpl$4(SPlayerPreDownloaderImpl paramSPlayerPreDownloaderImpl, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, int paramInt) {}
  
  public void onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    paramInt = SuperPlayerMsg.convert(paramInt);
    if (SPlayerPreDownloaderImpl.access$200(this.this$0) != null) {
      SPlayerPreDownloaderImpl.access$200(this.this$0).onInfo(paramInt, paramLong1, paramLong2, paramObject);
    }
    this.event.a(paramInt, paramLong1, paramLong2, paramObject);
  }
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    if (SPlayerPreDownloaderImpl.access$200(this.this$0) != null) {
      SPlayerPreDownloaderImpl.access$200(this.this$0).onPrepareDownloadProgressUpdate(this.val$taskid, paramInt1, paramInt2, paramLong1, paramLong2, paramString);
    }
    this.event.a(this.val$taskid, paramInt1, paramInt2, paramLong1, paramLong2, paramString);
  }
  
  public void onPrepareError()
  {
    SPlayerPreDownloaderImpl.access$400(this.this$0).remove(Integer.valueOf(this.val$taskid));
    if (SPlayerPreDownloaderImpl.access$200(this.this$0) != null) {
      SPlayerPreDownloaderImpl.access$200(this.this$0).onPrepareError(this.val$taskid);
    }
    SPPredownloadEvent localSPPredownloadEvent = this.event;
    localSPPredownloadEvent.b = false;
    localSPPredownloadEvent.c();
  }
  
  public void onPrepareSuccess()
  {
    SPlayerPreDownloaderImpl.access$400(this.this$0).remove(Integer.valueOf(this.val$taskid));
    if (SPlayerPreDownloaderImpl.access$200(this.this$0) != null) {
      SPlayerPreDownloaderImpl.access$200(this.this$0).onPrepareSuccess(this.val$taskid);
    }
    SPPredownloadEvent localSPPredownloadEvent = this.event;
    localSPPredownloadEvent.b = true;
    localSPPredownloadEvent.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPlayerPreDownloaderImpl.4
 * JD-Core Version:    0.7.0.1
 */