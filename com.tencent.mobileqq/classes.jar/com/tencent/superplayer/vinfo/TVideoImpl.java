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
import com.tencent.superplayer.utils.LogUtil;

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
    Object localObject1 = VInfoCacheMgr.getVInfoFromCache(paramSuperPlayerVideoInfo);
    if ((localObject1 != null) && (this.mListener != null))
    {
      this.mListener.onGetVInfoSuccess((SuperPlayerVideoInfo)localObject1);
      return;
    }
    int i;
    Object localObject2;
    switch (paramSuperPlayerVideoInfo.getVideoType())
    {
    default: 
      LogUtil.e(TAG, "doGetVInfo() playerVideoInfo.getVideoType() is ERROR = " + paramSuperPlayerVideoInfo.getVideoType());
      return;
    case 1: 
      i = 2;
      localObject2 = new TVKPlayerVideoInfo(i, paramSuperPlayerVideoInfo.getVid(), paramSuperPlayerVideoInfo.getPid());
      ((TVKPlayerVideoInfo)localObject2).setPid(paramSuperPlayerVideoInfo.getPid());
      ((TVKPlayerVideoInfo)localObject2).setPlatform(paramSuperPlayerVideoInfo.getBusiPlatform());
      localObject1 = new TVKPlaybackParam();
      ((TVKPlaybackParam)localObject1).context(this.mContext);
      ((TVKPlaybackParam)localObject1).userInfo(null);
      ((TVKPlaybackParam)localObject1).videoInfo((TVKPlayerVideoInfo)localObject2);
      ((TVKPlaybackParam)localObject1).definition(paramSuperPlayerVideoInfo.getRequestDefinition());
      ((TVKPlaybackParam)localObject1).mediaSource(new TVKMediaSource((TVKPlayerVideoInfo)localObject2));
      localObject2 = new TVKPlaybackInfo();
      ((TVKPlaybackInfo)localObject2).requestInfo().flowId(((TVKPlaybackParam)localObject1).flowId());
      ((TVKPlaybackInfo)localObject2).requestInfo().definition(((TVKPlaybackParam)localObject1).definition());
      if (paramSuperPlayerVideoInfo.getVideoType() == 1) {
        ((TVKPlaybackInfo)localObject2).requestInfo().formatId(1);
      }
      break;
    }
    for (;;)
    {
      ((TVKPlaybackInfo)localObject2).requestInfo().tag(paramSuperPlayerVideoInfo);
      this.mWrapperCGI.request(0, (TVKPlaybackParam)localObject1, (TVKPlaybackInfo)localObject2);
      return;
      i = 1;
      break;
      ((TVKPlaybackInfo)localObject2).requestInfo().formatId(2);
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