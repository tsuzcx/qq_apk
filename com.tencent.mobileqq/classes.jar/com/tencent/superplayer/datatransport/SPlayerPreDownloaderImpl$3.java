package com.tencent.superplayer.datatransport;

import com.tencent.superplayer.api.ISPlayerPreDownloader.Listener;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.vinfo.VInfoGetter.VInfoGetterListener;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;

class SPlayerPreDownloaderImpl$3
  implements VInfoGetter.VInfoGetterListener
{
  SPlayerPreDownloaderImpl$3(SPlayerPreDownloaderImpl paramSPlayerPreDownloaderImpl, TPDownloadParamData paramTPDownloadParamData, int paramInt) {}
  
  public void onGetVInfoFailed(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, int paramInt1, int paramInt2, String paramString)
  {
    if (SPlayerPreDownloaderImpl.access$200(this.this$0) != null) {
      SPlayerPreDownloaderImpl.access$200(this.this$0).onPrepareError(this.val$taskId);
    }
  }
  
  public void onGetVInfoSuccess(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    this.val$paramData.setFileDuration(paramSuperPlayerVideoInfo.getTVideoNetInfo().getVideoDuration());
    SPlayerPreDownloaderImpl.access$100(this.this$0, paramSuperPlayerVideoInfo, this.val$paramData, this.val$taskId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPlayerPreDownloaderImpl.3
 * JD-Core Version:    0.7.0.1
 */