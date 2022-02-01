package com.tencent.qqlive.tvkplayer.vinfo;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVodInfoGetter;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TVKPlayerWrapperCGIModel
{
  public static final int REQ_TYPE_ERROR_RETRY = 5;
  public static final int REQ_TYPE_HIGH_RAIL = 4;
  public static final int REQ_TYPE_LIVE_BACK_PLAY = 6;
  public static final int REQ_TYPE_LOOP_PLAY = 3;
  public static final int REQ_TYPE_NORMAL = 0;
  public static final int REQ_TYPE_SWITCH_AUDIO = 2;
  public static final int REQ_TYPE_SWITCH_DEF = 1;
  private static final int STATE_CANCELED = 2;
  private static final int STATE_COMPLETE = 3;
  private static final int STATE_INIT = 0;
  private static final int STATE_ON_GOING = 1;
  public static final String TAG = "TVKPlayer[TVKPlayerWrapper]";
  private static boolean sIsDDSInit = false;
  private static boolean sIsDDSSup = false;
  private TVKPlayerWrapperCGIModel.CGIWrapperCallback mCallback;
  private TVKPlayerWrapperCGIModel.CGICallbackHandler mHandler;
  private TVKPlayerWrapperCGIModel.CGICombineCallback mRequestCallback;
  private Queue<TVKPlayerWrapperCGIModel.CGIRequest> mRequestQueue;
  
  public TVKPlayerWrapperCGIModel(@NonNull Looper paramLooper, TVKPlayerWrapperCGIModel.CGIWrapperCallback paramCGIWrapperCallback)
  {
    this.mCallback = paramCGIWrapperCallback;
    this.mRequestQueue = new LinkedBlockingQueue();
    this.mRequestCallback = new TVKPlayerWrapperCGIModel.CGICombineCallback(this, null);
    this.mHandler = new TVKPlayerWrapperCGIModel.CGICallbackHandler(this, paramLooper);
  }
  
  private TVKPlayerWrapperCGIModel.CGIRequest buildRequest(int paramInt, TVKPlaybackParam paramTVKPlaybackParam, TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    if (paramInt == 0) {
      return buildRequestForTypeNormal(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    }
    if (paramInt == 1) {
      return buildRequestForTypeSwitchDefinition(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    }
    if (paramInt == 2) {
      return buildRequestForTypeSwitchAudio(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    }
    if (paramInt == 3) {
      return buildRequestForTypeLoopPlay(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    }
    if (paramInt == 4) {
      return buildRequestForTypeHighRail(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    }
    if (paramInt == 6) {
      return buildRequestForTypeLiveBackPlay(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    }
    if (paramInt == 5) {
      return buildRequestForTypeErrorRetry(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    }
    return buildRequestForTypeNormal(paramTVKPlaybackParam, paramTVKPlaybackInfo);
  }
  
  @NonNull
  private TVKPlayerWrapperCGIModel.CGIRequest buildRequestForTypeErrorRetry(TVKPlaybackParam paramTVKPlaybackParam, TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    playVideoInfoCommonExtraRequestMapFormat(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    TVKPlayerWrapperCGIModel.CGIRequest localCGIRequest = new TVKPlayerWrapperCGIModel.CGIRequest(null);
    localCGIRequest.reqId = -1;
    localCGIRequest.reqType = 5;
    localCGIRequest.reqState = 0;
    localCGIRequest.playbackParam = paramTVKPlaybackParam;
    localCGIRequest.playbackInfo = paramTVKPlaybackInfo;
    localCGIRequest.requestInfo = paramTVKPlaybackInfo.requestInfo().copy();
    localCGIRequest.startTimeMs = System.currentTimeMillis();
    return localCGIRequest;
  }
  
  @NonNull
  private TVKPlayerWrapperCGIModel.CGIRequest buildRequestForTypeHighRail(TVKPlaybackParam paramTVKPlaybackParam, TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    playVideoInfoCommonExtraRequestMapFormat(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    TVKPlayerWrapperCGIModel.CGIRequest localCGIRequest = new TVKPlayerWrapperCGIModel.CGIRequest(null);
    localCGIRequest.reqId = -1;
    localCGIRequest.reqType = 4;
    localCGIRequest.reqState = 0;
    localCGIRequest.playbackParam = paramTVKPlaybackParam;
    localCGIRequest.playbackInfo = paramTVKPlaybackInfo;
    localCGIRequest.requestInfo = paramTVKPlaybackInfo.requestInfo().copy();
    localCGIRequest.startTimeMs = System.currentTimeMillis();
    return localCGIRequest;
  }
  
  @NonNull
  private TVKPlayerWrapperCGIModel.CGIRequest buildRequestForTypeLiveBackPlay(TVKPlaybackParam paramTVKPlaybackParam, TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    playVideoInfoCommonExtraRequestMapFormat(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    if (-1L == paramTVKPlaybackParam.livePlayBackTimeSec()) {
      paramTVKPlaybackParam.videoInfo().getExtraRequestParamsMap().remove("playbacktime");
    } else {
      paramTVKPlaybackParam.videoInfo().getExtraRequestParamsMap().put("playbacktime", String.valueOf(paramTVKPlaybackParam.livePlayBackTimeSec()));
    }
    TVKPlayerWrapperCGIModel.CGIRequest localCGIRequest = new TVKPlayerWrapperCGIModel.CGIRequest(null);
    localCGIRequest.reqId = -1;
    localCGIRequest.reqType = 6;
    localCGIRequest.reqState = 0;
    localCGIRequest.playbackParam = paramTVKPlaybackParam;
    localCGIRequest.playbackInfo = paramTVKPlaybackInfo;
    localCGIRequest.requestInfo = paramTVKPlaybackInfo.requestInfo().copy();
    localCGIRequest.startTimeMs = System.currentTimeMillis();
    return localCGIRequest;
  }
  
  @NonNull
  private TVKPlayerWrapperCGIModel.CGIRequest buildRequestForTypeLoopPlay(TVKPlaybackParam paramTVKPlaybackParam, TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    playVideoInfoCommonExtraRequestMapFormat(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    paramTVKPlaybackParam.videoInfo().addProxyExtraMap("tv_task_type", String.valueOf(1));
    return new TVKPlayerWrapperCGIModel.CGIRequest(null);
  }
  
  @NonNull
  private TVKPlayerWrapperCGIModel.CGIRequest buildRequestForTypeNormal(TVKPlaybackParam paramTVKPlaybackParam, TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    playVideoInfoCommonExtraRequestMapFormat(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    TVKPlayerWrapperCGIModel.CGIRequest localCGIRequest = new TVKPlayerWrapperCGIModel.CGIRequest(null);
    localCGIRequest.reqId = -1;
    localCGIRequest.reqType = 0;
    localCGIRequest.reqState = 0;
    localCGIRequest.playbackParam = paramTVKPlaybackParam;
    localCGIRequest.playbackInfo = paramTVKPlaybackInfo;
    localCGIRequest.requestInfo = paramTVKPlaybackInfo.requestInfo().copy();
    localCGIRequest.startTimeMs = System.currentTimeMillis();
    return localCGIRequest;
  }
  
  @NonNull
  private TVKPlayerWrapperCGIModel.CGIRequest buildRequestForTypeSwitchAudio(TVKPlaybackParam paramTVKPlaybackParam, TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    playVideoInfoCommonExtraRequestMapFormat(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    TVKPlayerWrapperCGIModel.CGIRequest localCGIRequest = new TVKPlayerWrapperCGIModel.CGIRequest(null);
    localCGIRequest.reqId = -1;
    localCGIRequest.reqType = 2;
    localCGIRequest.reqState = 0;
    localCGIRequest.playbackParam = paramTVKPlaybackParam;
    localCGIRequest.playbackInfo = paramTVKPlaybackInfo;
    localCGIRequest.requestInfo = paramTVKPlaybackInfo.requestInfo().copy();
    localCGIRequest.startTimeMs = System.currentTimeMillis();
    return localCGIRequest;
  }
  
  @NonNull
  private TVKPlayerWrapperCGIModel.CGIRequest buildRequestForTypeSwitchDefinition(TVKPlaybackParam paramTVKPlaybackParam, TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    playVideoInfoCommonExtraRequestMapFormat(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    TVKPlayerWrapperCGIModel.CGIRequest localCGIRequest = new TVKPlayerWrapperCGIModel.CGIRequest(null);
    localCGIRequest.reqId = -1;
    localCGIRequest.reqType = 1;
    localCGIRequest.reqState = 0;
    localCGIRequest.playbackParam = paramTVKPlaybackParam;
    localCGIRequest.playbackInfo = paramTVKPlaybackInfo;
    localCGIRequest.requestInfo = paramTVKPlaybackInfo.requestInfo().copy();
    localCGIRequest.startTimeMs = System.currentTimeMillis();
    return localCGIRequest;
  }
  
  private void dumpRequest(TVKPlayerWrapperCGIModel.CGIRequest paramCGIRequest)
  {
    TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : ## videoInfo Request ##");
    String str3 = paramCGIRequest.playbackParam.videoInfo().getVid();
    String str2 = paramCGIRequest.requestInfo.definition();
    String str1 = paramCGIRequest.requestInfo.audioTrack();
    boolean bool1 = paramCGIRequest.requestInfo.h265Enable();
    boolean bool2 = paramCGIRequest.requestInfo.drmEnable();
    boolean bool3 = paramCGIRequest.requestInfo.hdr10Enable();
    boolean bool4 = paramCGIRequest.requestInfo.dolbyEnable();
    long l = paramCGIRequest.playbackParam.livePlayBackTimeSec();
    if (paramCGIRequest.reqType == 0) {
      TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request type :normal request");
    } else if (paramCGIRequest.reqType == 1) {
      TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request type :switch definition request");
    } else if (paramCGIRequest.reqType == 2) {
      TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request type :switch audio track request");
    } else if (paramCGIRequest.reqType == 3) {
      TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request type :loop play request");
    } else if (paramCGIRequest.reqType == 4) {
      TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request type :high rail request");
    } else if (paramCGIRequest.reqType == 6) {
      TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request type :live back play");
    }
    if (!TextUtils.isEmpty(str3))
    {
      paramCGIRequest = new StringBuilder();
      paramCGIRequest.append("CGI : request param : vid : ");
      paramCGIRequest.append(str3);
      TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", paramCGIRequest.toString());
    }
    paramCGIRequest = new StringBuilder();
    paramCGIRequest.append("CGI : request param : definition  :");
    paramCGIRequest.append(str2);
    TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", paramCGIRequest.toString());
    paramCGIRequest = new StringBuilder();
    paramCGIRequest.append("CGI : request param : h265Enable  :");
    paramCGIRequest.append(bool1);
    TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", paramCGIRequest.toString());
    paramCGIRequest = new StringBuilder();
    paramCGIRequest.append("CGI : request param : audioTrack  :");
    paramCGIRequest.append(str1);
    TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", paramCGIRequest.toString());
    paramCGIRequest = new StringBuilder();
    paramCGIRequest.append("CGI : request param : drmEnable   :");
    paramCGIRequest.append(bool2);
    TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", paramCGIRequest.toString());
    paramCGIRequest = new StringBuilder();
    paramCGIRequest.append("CGI : request param : hdr10Enable :");
    paramCGIRequest.append(bool3);
    TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", paramCGIRequest.toString());
    paramCGIRequest = new StringBuilder();
    paramCGIRequest.append("CGI : request param : dolbyEnable :");
    paramCGIRequest.append(bool4);
    TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", paramCGIRequest.toString());
    paramCGIRequest = new StringBuilder();
    paramCGIRequest.append("CGI : request param : playbacktimems :");
    paramCGIRequest.append(l);
    TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", paramCGIRequest.toString());
  }
  
  @Nullable
  private TVKPlayerWrapperCGIModel.CGIRequest findRequestByReqId(int paramInt)
  {
    Iterator localIterator = this.mRequestQueue.iterator();
    while (localIterator.hasNext())
    {
      TVKPlayerWrapperCGIModel.CGIRequest localCGIRequest = (TVKPlayerWrapperCGIModel.CGIRequest)localIterator.next();
      if (paramInt == localCGIRequest.reqId) {
        return localCGIRequest;
      }
    }
    return null;
  }
  
  private boolean hasRemainingOnGoingRequest()
  {
    try
    {
      Iterator localIterator = this.mRequestQueue.iterator();
      while (localIterator.hasNext())
      {
        TVKPlayerWrapperCGIModel.CGIRequest localCGIRequest = (TVKPlayerWrapperCGIModel.CGIRequest)localIterator.next();
        if (localCGIRequest.reqState != 0)
        {
          int i = localCGIRequest.reqState;
          if (i != 1) {
            break;
          }
        }
        else
        {
          return true;
        }
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static boolean isHwDolbyDSSupported()
  {
    if (sIsDDSInit) {
      return sIsDDSSup;
    }
    Object localObject1 = null;
    boolean bool2 = false;
    try
    {
      Object localObject2 = Class.forName("android.os.SystemProperties");
      localObject2 = (String)((Class)localObject2).getMethod("get", new Class[] { String.class }).invoke(localObject2, new Object[] { "dolby.ds.state" });
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    boolean bool1 = bool2;
    if (localObject1 != null) {
      if (localObject1 != null)
      {
        bool1 = bool2;
        if (localObject1.trim().equals("")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    sIsDDSSup = bool1;
    sIsDDSInit = true;
    return sIsDDSSup;
  }
  
  private void markAllRequestCanceled()
  {
    Iterator localIterator = this.mRequestQueue.iterator();
    while (localIterator.hasNext()) {
      ((TVKPlayerWrapperCGIModel.CGIRequest)localIterator.next()).reqState = 2;
    }
  }
  
  private void playVideoInfoCommonExtraRequestMapFormat(TVKPlaybackParam paramTVKPlaybackParam, TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    TVKPlayerWrapperHelper.PlayerVideoInfoHelper.configVideoInfoMapToExtralMap(paramTVKPlaybackParam.videoInfo());
    TVKPlayerWrapperHelper.PlayerVideoInfoHelper.videoInfoConfigDefinition(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    TVKPlayerWrapperHelper.PlayerVideoInfoHelper.configVideoInfoHEVCLevel(paramTVKPlaybackParam.videoInfo(), paramTVKPlaybackInfo.requestInfo().definition(), paramTVKPlaybackInfo.requestInfo().h265Enable());
    paramTVKPlaybackParam.videoInfo().addExtraRequestParamsMap("flowid", paramTVKPlaybackInfo.requestInfo().flowId());
    TVKPlayerWrapperHelper.PlayerVideoInfoHelper.configVideoInfoVersion(paramTVKPlaybackParam.videoInfo());
    TVKPlayerWrapperHelper.PlayerVideoInfoHelper.dumpVideoInfo(paramTVKPlaybackParam.videoInfo());
  }
  
  private void removeRequestByReqId(int paramInt)
  {
    this.mRequestQueue.remove(findRequestByReqId(paramInt));
  }
  
  private void sendRequest(TVKPlayerWrapperCGIModel.CGIRequest paramCGIRequest)
  {
    Object localObject = paramCGIRequest.playbackParam.context();
    TVKUserInfo localTVKUserInfo = paramCGIRequest.playbackParam.userInfo();
    TVKPlayerVideoInfo localTVKPlayerVideoInfo = paramCGIRequest.playbackParam.videoInfo();
    String str = paramCGIRequest.requestInfo.definition();
    int i = paramCGIRequest.requestInfo.formatId();
    if (localTVKPlayerVideoInfo.getPlayType() == 2)
    {
      localObject = new TVKVodInfoGetter((Context)localObject);
      ((ITVKVodInfoGetter)localObject).setOnInfoGetListener(this.mRequestCallback);
      i = ((ITVKVodInfoGetter)localObject).getPlayInfo(localTVKUserInfo, localTVKPlayerVideoInfo, str, i, 0);
    }
    else if (localTVKPlayerVideoInfo.getPlayType() == 8)
    {
      localObject = new TVKVodInfoGetter((Context)localObject);
      ((ITVKVodInfoGetter)localObject).setOnInfoGetListener(this.mRequestCallback);
      i = ((ITVKVodInfoGetter)localObject).getPlayInfo(localTVKUserInfo, localTVKPlayerVideoInfo, str, i, 0);
    }
    else if (localTVKPlayerVideoInfo.getPlayType() == 1)
    {
      localObject = TVKLiveInfoGetter.create((Context)localObject);
      ((ITVKLiveInfoGetter)localObject).setOnGetLiveInfoListener(this.mRequestCallback);
      i = ((ITVKLiveInfoGetter)localObject).getLiveInfo(localTVKUserInfo, localTVKPlayerVideoInfo, str, i, isHwDolbyDSSupported());
    }
    else
    {
      i = -1;
    }
    paramCGIRequest.reqId = i;
    paramCGIRequest.reqState = 1;
    dumpRequest(paramCGIRequest);
    this.mRequestQueue.add(paramCGIRequest);
  }
  
  public void request(int paramInt, @NonNull TVKPlaybackParam paramTVKPlaybackParam, @NonNull TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    try
    {
      paramTVKPlaybackParam = buildRequest(paramInt, paramTVKPlaybackParam, paramTVKPlaybackInfo);
      markAllRequestCanceled();
      sendRequest(paramTVKPlaybackParam);
      return;
    }
    finally
    {
      paramTVKPlaybackParam = finally;
      throw paramTVKPlaybackParam;
    }
  }
  
  public void reset()
  {
    try
    {
      markAllRequestCanceled();
      this.mRequestQueue.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerWrapperCGIModel
 * JD-Core Version:    0.7.0.1
 */