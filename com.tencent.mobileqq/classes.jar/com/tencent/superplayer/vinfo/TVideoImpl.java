package com.tencent.superplayer.vinfo;

import android.content.Context;
import android.os.Looper;
import com.tencent.qqlive.tvkplayer.playerwrapper.player.TVKMediaSource;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlaybackInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlaybackInfo.RequestInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlaybackParam;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerWrapperCGIModel;
import com.tencent.qqlive.tvkplayer.vinfo.TVKUserInfo;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.LogUtil;

class TVideoImpl
{
  public static final String TAG = "TVideoImpl";
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
    if (localObject1 != null)
    {
      localObject2 = this.mListener;
      if (localObject2 != null)
      {
        ((VInfoGetter.VInfoGetterListener)localObject2).onGetVInfoSuccess((SuperPlayerVideoInfo)localObject1);
        return;
      }
    }
    int i = paramSuperPlayerVideoInfo.getVideoType();
    if (i != 1)
    {
      if (i != 2)
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("doGetVInfo() playerVideoInfo.getVideoType() is ERROR = ");
        ((StringBuilder)localObject2).append(paramSuperPlayerVideoInfo.getVideoType());
        LogUtil.e((String)localObject1, ((StringBuilder)localObject2).toString());
        return;
      }
      i = 1;
    }
    else
    {
      i = 2;
    }
    Object localObject2 = new TVKPlayerVideoInfo(i, paramSuperPlayerVideoInfo.getVid(), paramSuperPlayerVideoInfo.getPid());
    ((TVKPlayerVideoInfo)localObject2).setPid(paramSuperPlayerVideoInfo.getPid());
    ((TVKPlayerVideoInfo)localObject2).setPlatform(paramSuperPlayerVideoInfo.getBusiPlatform());
    localObject1 = new TVKPlaybackParam();
    ((TVKPlaybackParam)localObject1).context(this.mContext);
    TVKUserInfo localTVKUserInfo = new TVKUserInfo();
    localTVKUserInfo.setLoginCookie(paramSuperPlayerVideoInfo.getTVideoLoginCookie());
    ((TVKPlaybackParam)localObject1).userInfo(localTVKUserInfo);
    ((TVKPlaybackParam)localObject1).videoInfo((TVKPlayerVideoInfo)localObject2);
    ((TVKPlaybackParam)localObject1).definition(paramSuperPlayerVideoInfo.getRequestDefinition());
    ((TVKPlaybackParam)localObject1).mediaSource(new TVKMediaSource((TVKPlayerVideoInfo)localObject2));
    localObject2 = new TVKPlaybackInfo();
    ((TVKPlaybackInfo)localObject2).requestInfo().flowId(((TVKPlaybackParam)localObject1).flowId());
    ((TVKPlaybackInfo)localObject2).requestInfo().definition(((TVKPlaybackParam)localObject1).definition());
    if (paramSuperPlayerVideoInfo.getVideoType() == 1) {
      ((TVKPlaybackInfo)localObject2).requestInfo().formatId(0);
    } else {
      ((TVKPlaybackInfo)localObject2).requestInfo().formatId(2);
    }
    ((TVKPlaybackInfo)localObject2).requestInfo().tag(paramSuperPlayerVideoInfo);
    this.mWrapperCGI.request(0, (TVKPlaybackParam)localObject1, (TVKPlaybackInfo)localObject2);
  }
  
  void setListener(VInfoGetter.VInfoGetterListener paramVInfoGetterListener)
  {
    this.mListener = paramVInfoGetterListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.vinfo.TVideoImpl
 * JD-Core Version:    0.7.0.1
 */