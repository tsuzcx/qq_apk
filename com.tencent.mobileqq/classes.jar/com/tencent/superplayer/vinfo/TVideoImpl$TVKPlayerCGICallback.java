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
      TVideoImpl.access$100(this.this$0).onGetVInfoFailed((SuperPlayerVideoInfo)paramRequestInfo.tag(), -1, paramTVKLiveVideoInfo.getErrInfo());
    }
  }
  
  public void onGetLiveInfoSuccess(int paramInt, TVKPlaybackInfo.RequestInfo paramRequestInfo, TVKLiveVideoInfo paramTVKLiveVideoInfo)
  {
    paramRequestInfo = (SuperPlayerVideoInfo)paramRequestInfo.tag();
    paramInt = 303;
    if (paramTVKLiveVideoInfo.getStream() == 2) {
      paramInt = 301;
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
        paramInt = 302;
      }
    }
    localTVideoNetInfo.setDefinitionList(localArrayList);
    localTVideoNetInfo.setCurrentDefinition(new TVideoNetInfo.DefinitionInfo(paramTVKLiveVideoInfo.getCurDefinition().getDefn(), paramTVKLiveVideoInfo.getCurDefinition().getDefnName(), paramTVKLiveVideoInfo.getCurDefinition().getDefnRate(), paramTVKLiveVideoInfo.getCurDefinition().getDefnShowName()));
    if ((paramTVKLiveVideoInfo.getWatermarkInfos() == null) || (paramTVKLiveVideoInfo.getWatermarkInfos().size() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      localTVideoNetInfo.setHasWatermark(bool);
      paramRequestInfo.setTVideoNetInfo(localTVideoNetInfo);
      if (TVideoImpl.access$100(this.this$0) != null) {
        TVideoImpl.access$100(this.this$0).onGetVInfoSuccess(paramRequestInfo);
      }
      return;
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
    Object localObject = paramTVKVideoInfo.getPlayUrl();
    paramInt = 203;
    if (paramTVKVideoInfo.getDownloadType() == 1) {
      paramInt = 201;
    }
    ArrayList localArrayList;
    for (;;)
    {
      paramRequestInfo.setPlayUrl((String)localObject);
      paramRequestInfo.setFormat(paramInt);
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
        paramInt = 202;
      }
    }
    ((TVideoNetInfo)localObject).setDefinitionList(localArrayList);
    ((TVideoNetInfo)localObject).setCurrentDefinition(new TVideoNetInfo.DefinitionInfo(paramTVKVideoInfo.getCurDefinition().getDefn(), paramTVKVideoInfo.getCurDefinition().getDefnName(), paramTVKVideoInfo.getCurDefinition().getDefnRate(), paramTVKVideoInfo.getCurDefinition().getDefnShowName()));
    if ((paramTVKVideoInfo.getWatermarkInfos() == null) || (paramTVKVideoInfo.getWatermarkInfos().size() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      ((TVideoNetInfo)localObject).setHasWatermark(bool);
      paramRequestInfo.setTVideoNetInfo((TVideoNetInfo)localObject);
      if (TVideoImpl.access$100(this.this$0) != null) {
        TVideoImpl.access$100(this.this$0).onGetVInfoSuccess(paramRequestInfo);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.vinfo.TVideoImpl.TVKPlayerCGICallback
 * JD-Core Version:    0.7.0.1
 */