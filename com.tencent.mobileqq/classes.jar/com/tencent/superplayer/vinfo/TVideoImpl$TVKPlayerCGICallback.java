package com.tencent.superplayer.vinfo;

import com.tencent.qqlive.tvkplayer.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlaybackInfo.RequestInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerWrapperCGIModel.CGIWrapperCallback;
import com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

class TVideoImpl$TVKPlayerCGICallback
  implements TVKPlayerWrapperCGIModel.CGIWrapperCallback
{
  private TVideoImpl$TVKPlayerCGICallback(TVideoImpl paramTVideoImpl) {}
  
  public void onGetLiveInfoFailed(int paramInt, TVKPlaybackInfo.RequestInfo paramRequestInfo, TVKLiveVideoInfo paramTVKLiveVideoInfo)
  {
    if (TVideoImpl.access$100(this.this$0) != null) {
      TVideoImpl.access$100(this.this$0).onGetVInfoFailed((SuperPlayerVideoInfo)paramRequestInfo.tag(), -1, paramTVKLiveVideoInfo.getErrInfo());
    }
  }
  
  public void onGetLiveInfoSuccess(int paramInt, TVKPlaybackInfo.RequestInfo paramRequestInfo, TVKLiveVideoInfo paramTVKLiveVideoInfo)
  {
    paramRequestInfo = (SuperPlayerVideoInfo)paramRequestInfo.tag();
    paramInt = 203;
    if (paramTVKLiveVideoInfo.getStream() == 2) {
      paramInt = 201;
    }
    for (;;)
    {
      paramRequestInfo.setVideoInfo(paramTVKLiveVideoInfo.getPlayUrl(), paramInt);
      if (TVideoImpl.access$100(this.this$0) != null) {
        TVideoImpl.access$100(this.this$0).onGetVInfoSuccess(paramRequestInfo);
      }
      return;
      if (paramTVKLiveVideoInfo.getStream() == 1) {
        paramInt = 202;
      }
    }
  }
  
  public void onGetVodInfoFailed(int paramInt1, TVKPlaybackInfo.RequestInfo paramRequestInfo, String paramString1, int paramInt2, String paramString2)
  {
    if (TVideoImpl.access$100(this.this$0) != null) {
      TVideoImpl.access$100(this.this$0).onGetVInfoFailed((SuperPlayerVideoInfo)paramRequestInfo.tag(), paramInt2, paramString1);
    }
  }
  
  public void onGetVodInfoSuccess(int paramInt, TVKPlaybackInfo.RequestInfo paramRequestInfo, TVKVideoInfo paramTVKVideoInfo)
  {
    paramRequestInfo = (SuperPlayerVideoInfo)paramRequestInfo.tag();
    String str = paramTVKVideoInfo.getPlayUrl();
    paramInt = 103;
    if (paramTVKVideoInfo.getDownloadType() == 1) {
      paramInt = 101;
    }
    for (;;)
    {
      paramTVKVideoInfo.getDuration();
      paramRequestInfo.setVideoInfo(str, paramInt);
      if (TVideoImpl.access$100(this.this$0) != null) {
        TVideoImpl.access$100(this.this$0).onGetVInfoSuccess(paramRequestInfo);
      }
      return;
      if (paramTVKVideoInfo.getDownloadType() == 3) {
        paramInt = 102;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.vinfo.TVideoImpl.TVKPlayerCGICallback
 * JD-Core Version:    0.7.0.1
 */