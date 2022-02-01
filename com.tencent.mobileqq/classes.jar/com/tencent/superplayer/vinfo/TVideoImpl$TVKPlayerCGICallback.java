package com.tencent.superplayer.vinfo;

import com.tencent.qqlive.tvkplayer.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKNetVideoInfo.DefnInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlaybackInfo.RequestInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerWrapperCGIModel.CGIWrapperCallback;
import com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.api.TVideoNetInfo.DefinitionInfo;
import java.util.ArrayList;
import java.util.Iterator;

class TVideoImpl$TVKPlayerCGICallback
  implements TVKPlayerWrapperCGIModel.CGIWrapperCallback
{
  private TVideoImpl$TVKPlayerCGICallback(TVideoImpl paramTVideoImpl) {}
  
  public void onGetLiveInfoFailed(int paramInt, TVKPlaybackInfo.RequestInfo paramRequestInfo, TVKLiveVideoInfo paramTVKLiveVideoInfo)
  {
    if (TVideoImpl.access$100(this.this$0) != null) {
      TVideoImpl.access$100(this.this$0).onGetVInfoFailed((SuperPlayerVideoInfo)paramRequestInfo.tag(), 5002, 32000002, paramTVKLiveVideoInfo.getErrInfo());
    }
  }
  
  public void onGetLiveInfoSuccess(int paramInt, TVKPlaybackInfo.RequestInfo paramRequestInfo, TVKLiveVideoInfo paramTVKLiveVideoInfo)
  {
    paramRequestInfo = (SuperPlayerVideoInfo)paramRequestInfo.tag();
    paramInt = 403;
    if (paramTVKLiveVideoInfo.getStream() == 2) {
      paramInt = 401;
    }
    TVideoNetInfo localTVideoNetInfo;
    ArrayList localArrayList;
    for (;;)
    {
      paramRequestInfo.setPlayUrl(paramTVKLiveVideoInfo.getPlayUrl());
      paramRequestInfo.setFormat(paramInt);
      localTVideoNetInfo = new TVideoNetInfo();
      localArrayList = new ArrayList();
      Iterator localIterator = paramTVKLiveVideoInfo.getDefinitionList().iterator();
      while (localIterator.hasNext())
      {
        TVKNetVideoInfo.DefnInfo localDefnInfo = (TVKNetVideoInfo.DefnInfo)localIterator.next();
        localArrayList.add(new TVideoNetInfo.DefinitionInfo(localDefnInfo.getDefn(), localDefnInfo.getDefnName(), localDefnInfo.getDefnRate(), localDefnInfo.getDefnShowName()));
      }
      if (paramTVKLiveVideoInfo.getStream() == 1) {
        paramInt = 402;
      }
    }
    localTVideoNetInfo.setDefinitionList(localArrayList);
    localTVideoNetInfo.setCurrentDefinition(new TVideoNetInfo.DefinitionInfo(paramTVKLiveVideoInfo.getCurDefinition().getDefn(), paramTVKLiveVideoInfo.getCurDefinition().getDefnName(), paramTVKLiveVideoInfo.getCurDefinition().getDefnRate(), paramTVKLiveVideoInfo.getCurDefinition().getDefnShowName()));
    localTVideoNetInfo.setUpdateTimeMillis(System.currentTimeMillis());
    if ((paramTVKLiveVideoInfo.getWatermarkInfos() == null) || (paramTVKLiveVideoInfo.getWatermarkInfos().size() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      localTVideoNetInfo.setHasWatermark(bool);
      paramRequestInfo.setTVideoNetInfo(localTVideoNetInfo);
      VInfoCacheMgr.saveVInfoToCache(paramRequestInfo);
      if (TVideoImpl.access$100(this.this$0) != null) {
        TVideoImpl.access$100(this.this$0).onGetVInfoSuccess(paramRequestInfo);
      }
      return;
    }
  }
  
  public void onGetVodInfoFailed(int paramInt1, TVKPlaybackInfo.RequestInfo paramRequestInfo, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    if (TVideoImpl.access$100(this.this$0) != null)
    {
      if (paramInt2 != 101) {
        break label45;
      }
      paramInt1 = 5000;
    }
    for (;;)
    {
      TVideoImpl.access$100(this.this$0).onGetVInfoFailed((SuperPlayerVideoInfo)paramRequestInfo.tag(), paramInt1, paramInt3, paramString1);
      return;
      label45:
      paramInt1 = paramInt2;
      if (paramInt2 == 103) {
        paramInt1 = 5001;
      }
    }
  }
  
  public void onGetVodInfoSuccess(int paramInt, TVKPlaybackInfo.RequestInfo paramRequestInfo, TVKVideoInfo paramTVKVideoInfo)
  {
    paramRequestInfo = (SuperPlayerVideoInfo)paramRequestInfo.tag();
    Object localObject = paramTVKVideoInfo.getPlayUrl();
    paramInt = 303;
    if (paramTVKVideoInfo.getDownloadType() == 1) {
      paramInt = 301;
    }
    ArrayList localArrayList;
    for (;;)
    {
      paramRequestInfo.setPlayUrl((String)localObject);
      paramRequestInfo.setFormat(paramInt);
      paramRequestInfo.setVideoDurationMs(paramTVKVideoInfo.getDuration() * 1000);
      localObject = new TVideoNetInfo();
      ((TVideoNetInfo)localObject).setVideoDuration(paramTVKVideoInfo.getDuration() * 1000);
      ((TVideoNetInfo)localObject).setVideoSize(paramTVKVideoInfo.getFileSize());
      localArrayList = new ArrayList();
      Iterator localIterator = paramTVKVideoInfo.getDefinitionList().iterator();
      while (localIterator.hasNext())
      {
        TVKNetVideoInfo.DefnInfo localDefnInfo = (TVKNetVideoInfo.DefnInfo)localIterator.next();
        localArrayList.add(new TVideoNetInfo.DefinitionInfo(localDefnInfo.getDefn(), localDefnInfo.getDefnName(), localDefnInfo.getDefnRate(), localDefnInfo.getDefnShowName()));
      }
      if (paramTVKVideoInfo.getDownloadType() == 3) {
        paramInt = 302;
      }
    }
    ((TVideoNetInfo)localObject).setDefinitionList(localArrayList);
    ((TVideoNetInfo)localObject).setCurrentDefinition(new TVideoNetInfo.DefinitionInfo(paramTVKVideoInfo.getCurDefinition().getDefn(), paramTVKVideoInfo.getCurDefinition().getDefnName(), paramTVKVideoInfo.getCurDefinition().getDefnRate(), paramTVKVideoInfo.getCurDefinition().getDefnShowName()));
    ((TVideoNetInfo)localObject).setUpdateTimeMillis(System.currentTimeMillis());
    if ((paramTVKVideoInfo.getWatermarkInfos() == null) || (paramTVKVideoInfo.getWatermarkInfos().size() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      ((TVideoNetInfo)localObject).setHasWatermark(bool);
      paramRequestInfo.setTVideoNetInfo((TVideoNetInfo)localObject);
      VInfoCacheMgr.saveVInfoToCache(paramRequestInfo);
      if (TVideoImpl.access$100(this.this$0) != null) {
        TVideoImpl.access$100(this.this$0).onGetVInfoSuccess(paramRequestInfo);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.vinfo.TVideoImpl.TVKPlayerCGICallback
 * JD-Core Version:    0.7.0.1
 */