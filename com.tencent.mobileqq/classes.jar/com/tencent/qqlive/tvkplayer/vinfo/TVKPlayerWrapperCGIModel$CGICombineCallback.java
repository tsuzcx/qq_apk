package com.tencent.qqlive.tvkplayer.vinfo;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKPlayerUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter.OnGetLiveInfoListener;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter.ITVKVodInfoGetterCallback;

class TVKPlayerWrapperCGIModel$CGICombineCallback
  implements ITVKLiveInfoGetter.OnGetLiveInfoListener, ITVKVodInfoGetter.ITVKVodInfoGetterCallback
{
  private TVKPlayerWrapperCGIModel$CGICombineCallback(TVKPlayerWrapperCGIModel paramTVKPlayerWrapperCGIModel) {}
  
  private void handleOnFailure(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    TVKPlayerWrapperCGIModel.CGIRequest localCGIRequest = TVKPlayerWrapperCGIModel.access$700(this.this$0, paramInt1);
    if (processVideoInfoIsRequestExpired(localCGIRequest))
    {
      TVKPlayerWrapperCGIModel.access$800(this.this$0, paramInt1);
      return;
    }
    localCGIRequest.reqState = 3;
    TVKPlayerWrapperCGIModel.access$800(this.this$0, paramInt1);
    TVKPlayerWrapperCGIModel.access$900(this.this$0).onGetVodInfoFailed(localCGIRequest.reqType, localCGIRequest.requestInfo, paramInt2, paramString1, paramInt3, paramString2);
  }
  
  private void handleOnGetLiveInfoFailed(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo)
  {
    TVKPlayerWrapperCGIModel.CGIRequest localCGIRequest = TVKPlayerWrapperCGIModel.access$700(this.this$0, paramInt);
    if (processVideoInfoIsRequestExpired(localCGIRequest))
    {
      TVKPlayerWrapperCGIModel.access$800(this.this$0, paramInt);
      return;
    }
    localCGIRequest.reqState = 3;
    TVKPlayerWrapperCGIModel.access$800(this.this$0, paramInt);
    TVKPlayerWrapperCGIModel.access$900(this.this$0).onGetLiveInfoFailed(localCGIRequest.reqType, localCGIRequest.requestInfo, paramTVKLiveVideoInfo);
  }
  
  private void handleOnGetLiveInfoSucceed(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo)
  {
    TVKPlayerWrapperCGIModel.CGIRequest localCGIRequest = TVKPlayerWrapperCGIModel.access$700(this.this$0, paramInt);
    if (processVideoInfoIsRequestExpired(localCGIRequest))
    {
      TVKPlayerWrapperCGIModel.access$800(this.this$0, paramInt);
      return;
    }
    localCGIRequest.reqState = 3;
    TVKPlayerWrapperCGIModel.access$800(this.this$0, paramInt);
    TVKPlayerWrapperCGIModel.access$900(this.this$0).onGetLiveInfoSuccess(localCGIRequest.reqType, localCGIRequest.requestInfo, paramTVKLiveVideoInfo);
  }
  
  private void handleOnSuccess(int paramInt, TVKVideoInfo paramTVKVideoInfo)
  {
    TVKPlayerWrapperCGIModel.CGIRequest localCGIRequest = TVKPlayerWrapperCGIModel.access$700(this.this$0, paramInt);
    if (processVideoInfoIsRequestExpired(localCGIRequest))
    {
      TVKPlayerWrapperCGIModel.access$800(this.this$0, paramInt);
      return;
    }
    localCGIRequest.reqState = 3;
    TVKPlayerWrapperCGIModel.access$800(this.this$0, paramInt);
    if (processVideoInfoIsNeedReRequestVideoInfo(localCGIRequest, paramTVKVideoInfo))
    {
      localCGIRequest.playbackInfo.requestInfo().h265Enable(false);
      this.this$0.request(localCGIRequest.reqType, localCGIRequest.playbackParam, localCGIRequest.playbackInfo);
      return;
    }
    TVKPlayerWrapperCGIModel.access$900(this.this$0).onGetVodInfoSuccess(localCGIRequest.reqType, localCGIRequest.requestInfo, paramTVKVideoInfo);
  }
  
  private boolean processVideoInfoIsHEVCNotSupported(TVKPlayerWrapperCGIModel.CGIRequest paramCGIRequest, TVKNetVideoInfo paramTVKNetVideoInfo)
  {
    if (!paramTVKNetVideoInfo.isHevc()) {}
    while ((paramTVKNetVideoInfo.getCurDefinition() == null) || (TextUtils.isEmpty(paramTVKNetVideoInfo.getCurDefinition().getDefn())) || (paramCGIRequest.playbackParam.videoInfo().getPlayType() != 2)) {
      return false;
    }
    int j = TVKUtils.optInt(paramCGIRequest.playbackParam.videoInfo().getConfigMapValue("sysplayer_hevc_cap", ""), 0);
    int i;
    if (j == 1)
    {
      i = 28;
      if (TVKPlayerUtils.getDefnHevcLevel(paramTVKNetVideoInfo.getCurDefinition().getDefn(), i) > 0) {
        break label107;
      }
    }
    label107:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i = j;
      if (j != 2) {
        break;
      }
      i = 33;
      break;
    }
  }
  
  private boolean processVideoInfoIsNeedReRequestVideoInfo(TVKPlayerWrapperCGIModel.CGIRequest paramCGIRequest, TVKNetVideoInfo paramTVKNetVideoInfo)
  {
    if (TVKPlayerWrapperCGIModel.access$1000(this.this$0))
    {
      TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : video info success , has remaining request , no need re request.");
      return false;
    }
    if (processVideoInfoIsHEVCNotSupported(paramCGIRequest, paramTVKNetVideoInfo))
    {
      TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : video info success , h265 level higher than system , re request h264");
      return true;
    }
    TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : video info success , and no need re request new.");
    return false;
  }
  
  private boolean processVideoInfoIsRequestExpired(TVKPlayerWrapperCGIModel.CGIRequest paramCGIRequest)
  {
    if (paramCGIRequest == null) {}
    while (paramCGIRequest.reqState == 2) {
      return true;
    }
    return false;
  }
  
  public void onFailure(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    TVKPlayerWrapperCGIModel.access$300(this.this$0).post(new TVKPlayerWrapperCGIModel.CGICombineCallback.1(this, paramInt1, paramInt2, paramString1, paramInt3, paramString2));
  }
  
  public void onGetLiveInfoFailed(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo)
  {
    TVKPlayerWrapperCGIModel.access$300(this.this$0).post(new TVKPlayerWrapperCGIModel.CGICombineCallback.4(this, paramInt, paramTVKLiveVideoInfo));
  }
  
  public void onGetLiveInfoSucceed(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo)
  {
    TVKPlayerWrapperCGIModel.access$300(this.this$0).post(new TVKPlayerWrapperCGIModel.CGICombineCallback.3(this, paramInt, paramTVKLiveVideoInfo));
  }
  
  public void onSuccess(int paramInt, TVKVideoInfo paramTVKVideoInfo)
  {
    TVKPlayerWrapperCGIModel.access$300(this.this$0).post(new TVKPlayerWrapperCGIModel.CGICombineCallback.2(this, paramInt, paramTVKVideoInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerWrapperCGIModel.CGICombineCallback
 * JD-Core Version:    0.7.0.1
 */