package com.tencent.superplayer.datatransport;

import com.tencent.superplayer.api.ISPlayerPreLoader.Listener;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.vinfo.VInfoGetter.VInfoGetterListener;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;

class SPlayerPreLoaderImpl$2
  implements VInfoGetter.VInfoGetterListener
{
  SPlayerPreLoaderImpl$2(SPlayerPreLoaderImpl paramSPlayerPreLoaderImpl, TPDownloadParamData paramTPDownloadParamData) {}
  
  public void onGetVInfoFailed(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, int paramInt, String paramString)
  {
    if (SPlayerPreLoaderImpl.access$100(this.this$0) != null) {
      SPlayerPreLoaderImpl.access$100(this.this$0).onPrepareError();
    }
  }
  
  public void onGetVInfoSuccess(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    this.val$paramData.setFileDuration(paramSuperPlayerVideoInfo.getTVideoNetInfo().getVideoDuration());
    this.val$paramData.setFileSize(paramSuperPlayerVideoInfo.getTVideoNetInfo().getVideoSize());
    SPlayerPreLoaderImpl.access$000(this.this$0, paramSuperPlayerVideoInfo, this.val$paramData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPlayerPreLoaderImpl.2
 * JD-Core Version:    0.7.0.1
 */