package com.tencent.superplayer.vinfo;

import android.content.Context;
import android.os.Looper;
import com.tencent.qqlive.tvkplayer.playerwrapper.player.TVKMediaSource;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlaybackInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlaybackInfo.RequestInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlaybackParam;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerWrapperCGIModel;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.SPlayerLogUtil;

class TVideoImpl
{
  public static final String TAG = TVideoImpl.class.getSimpleName();
  private Context mContext;
  private VInfoGetter.VInfoGetterListener mListener;
  private TVKPlayerWrapperCGIModel mWrapperCGI;
  private TVideoImpl.TVKPlayerCGICallback mWrapperCGICallback;
  
  TVideoImpl(Context paramContext, Looper paramLooper)
  {
    this.mContext = paramContext;
    this.mWrapperCGICallback = new TVideoImpl.TVKPlayerCGICallback(this, null);
    this.mWrapperCGI = new TVKPlayerWrapperCGIModel(paramLooper, this.mWrapperCGICallback);
  }
  
  void doGetVInfo(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    int i;
    Object localObject;
    TVKPlaybackParam localTVKPlaybackParam;
    switch (paramSuperPlayerVideoInfo.getVideoType())
    {
    default: 
      SPlayerLogUtil.e(TAG, "doGetVInfo() playerVideoInfo.getVideoType() is ERROR = " + paramSuperPlayerVideoInfo.getVideoType());
      return;
    case 1: 
      i = 2;
      localObject = new TVKPlayerVideoInfo(i, paramSuperPlayerVideoInfo.getVid(), paramSuperPlayerVideoInfo.getPid());
      ((TVKPlayerVideoInfo)localObject).setPid(paramSuperPlayerVideoInfo.getPid());
      localTVKPlaybackParam = new TVKPlaybackParam();
      localTVKPlaybackParam.context(this.mContext);
      localTVKPlaybackParam.userInfo(null);
      localTVKPlaybackParam.videoInfo((TVKPlayerVideoInfo)localObject);
      localTVKPlaybackParam.definition("");
      localTVKPlaybackParam.mediaSource(new TVKMediaSource((TVKPlayerVideoInfo)localObject));
      localObject = new TVKPlaybackInfo();
      ((TVKPlaybackInfo)localObject).requestInfo().flowId(localTVKPlaybackParam.flowId());
      ((TVKPlaybackInfo)localObject).requestInfo().definition(localTVKPlaybackParam.definition());
      if (paramSuperPlayerVideoInfo.getVideoType() == 1) {
        ((TVKPlaybackInfo)localObject).requestInfo().formatId(1);
      }
      break;
    }
    for (;;)
    {
      ((TVKPlaybackInfo)localObject).requestInfo().tag(paramSuperPlayerVideoInfo);
      this.mWrapperCGI.request(0, localTVKPlaybackParam, (TVKPlaybackInfo)localObject);
      return;
      i = 1;
      break;
      ((TVKPlaybackInfo)localObject).requestInfo().formatId(2);
    }
  }
  
  void setListener(VInfoGetter.VInfoGetterListener paramVInfoGetterListener)
  {
    this.mListener = paramVInfoGetterListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.vinfo.TVideoImpl
 * JD-Core Version:    0.7.0.1
 */