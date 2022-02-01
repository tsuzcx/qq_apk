package com.tencent.superplayer.vinfo;

import com.tencent.qqlive.tvkplayer.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKNetVideoInfo.DefnInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlaybackInfo.RequestInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerWrapperCGIModel.CGIWrapperCallback;
import com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.api.TVideoNetInfo.DefinitionInfo;
import com.tencent.superplayer.utils.LogUtil;
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
    if (paramTVKLiveVideoInfo == null)
    {
      paramRequestInfo = TVideoImpl.TAG;
      paramTVKLiveVideoInfo = new StringBuilder();
      paramTVKLiveVideoInfo.append("onGetLiveInfoSuccess() reqType ");
      paramTVKLiveVideoInfo.append(paramInt);
      paramTVKLiveVideoInfo.append(", liveInfo == null");
      LogUtil.e(paramRequestInfo, paramTVKLiveVideoInfo.toString());
      return;
    }
    paramRequestInfo = (SuperPlayerVideoInfo)paramRequestInfo.tag();
    int i = 403;
    int j = paramTVKLiveVideoInfo.getStream();
    boolean bool2 = true;
    if (j == 2) {
      i = 401;
    } else if (paramTVKLiveVideoInfo.getStream() == 1) {
      i = 402;
    }
    paramRequestInfo.setPlayUrl(paramTVKLiveVideoInfo.getPlayUrl());
    paramRequestInfo.setFormat(i);
    TVideoNetInfo localTVideoNetInfo = new TVideoNetInfo();
    ArrayList localArrayList = new ArrayList();
    if (paramTVKLiveVideoInfo.getDefinitionList() != null)
    {
      localObject1 = paramTVKLiveVideoInfo.getDefinitionList().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TVKNetVideoInfo.DefnInfo)((Iterator)localObject1).next();
        localArrayList.add(new TVideoNetInfo.DefinitionInfo(((TVKNetVideoInfo.DefnInfo)localObject2).getDefn(), ((TVKNetVideoInfo.DefnInfo)localObject2).getDefnName(), ((TVKNetVideoInfo.DefnInfo)localObject2).getDefnRate(), ((TVKNetVideoInfo.DefnInfo)localObject2).getDefnShowName()));
      }
    }
    Object localObject1 = TVideoImpl.TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onGetLiveInfoSuccess() reqType:");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("  liveInfo.getDefinitionList() == null");
    LogUtil.e((String)localObject1, ((StringBuilder)localObject2).toString());
    localTVideoNetInfo.setDefinitionList(localArrayList);
    if (paramTVKLiveVideoInfo.getCurDefinition() != null) {
      localTVideoNetInfo.setCurrentDefinition(new TVideoNetInfo.DefinitionInfo(paramTVKLiveVideoInfo.getCurDefinition().getDefn(), paramTVKLiveVideoInfo.getCurDefinition().getDefnName(), paramTVKLiveVideoInfo.getCurDefinition().getDefnRate(), paramTVKLiveVideoInfo.getCurDefinition().getDefnShowName()));
    }
    localTVideoNetInfo.setUpdateTimeMillis(System.currentTimeMillis());
    boolean bool1 = bool2;
    if (paramTVKLiveVideoInfo.getWatermarkInfos() != null) {
      if (paramTVKLiveVideoInfo.getWatermarkInfos().size() == 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    localTVideoNetInfo.setHasWatermark(bool1);
    paramRequestInfo.setTVideoNetInfo(localTVideoNetInfo);
    VInfoCacheMgr.saveVInfoToCache(paramRequestInfo);
    if (TVideoImpl.access$100(this.this$0) != null) {
      TVideoImpl.access$100(this.this$0).onGetVInfoSuccess(paramRequestInfo);
    }
  }
  
  public void onGetVodInfoFailed(int paramInt1, TVKPlaybackInfo.RequestInfo paramRequestInfo, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    if (TVideoImpl.access$100(this.this$0) != null)
    {
      if (paramInt2 == 101)
      {
        paramInt1 = 5000;
      }
      else
      {
        paramInt1 = paramInt2;
        if (paramInt2 == 103) {
          paramInt1 = 5001;
        }
      }
      TVideoImpl.access$100(this.this$0).onGetVInfoFailed((SuperPlayerVideoInfo)paramRequestInfo.tag(), paramInt1, paramInt3, paramString1);
    }
  }
  
  public void onGetVodInfoSuccess(int paramInt, TVKPlaybackInfo.RequestInfo paramRequestInfo, TVKVideoInfo paramTVKVideoInfo)
  {
    paramRequestInfo = (SuperPlayerVideoInfo)paramRequestInfo.tag();
    int i = paramTVKVideoInfo.getDownloadType();
    boolean bool2 = true;
    if ((i != 4) && (paramTVKVideoInfo.getDownloadType() != 5))
    {
      if (paramTVKVideoInfo.getDownloadType() == 1)
      {
        paramRequestInfo.setFormat(301);
        paramRequestInfo.setPlayUrl(paramTVKVideoInfo.getPlayUrl());
      }
      else if (paramTVKVideoInfo.getDownloadType() == 3)
      {
        paramRequestInfo.setFormat(302);
        paramRequestInfo.setPlayUrl(paramTVKVideoInfo.getPlayUrl());
      }
      else
      {
        paramRequestInfo.setFormat(304);
        paramRequestInfo.setPlayUrl(paramTVKVideoInfo.getPlayUrl());
      }
    }
    else
    {
      paramRequestInfo.setFormat(303);
      paramRequestInfo.setTVideoSectionList(paramTVKVideoInfo.getSectionList());
    }
    paramRequestInfo.setVideoDurationMs(paramTVKVideoInfo.getDuration() * 1000);
    TVideoNetInfo localTVideoNetInfo = new TVideoNetInfo();
    localTVideoNetInfo.setVideoDuration(paramTVKVideoInfo.getDuration() * 1000);
    localTVideoNetInfo.setVideoSize(paramTVKVideoInfo.getFileSize());
    ArrayList localArrayList = new ArrayList();
    if (paramTVKVideoInfo.getDefinitionList() != null)
    {
      localObject1 = paramTVKVideoInfo.getDefinitionList().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TVKNetVideoInfo.DefnInfo)((Iterator)localObject1).next();
        localArrayList.add(new TVideoNetInfo.DefinitionInfo(((TVKNetVideoInfo.DefnInfo)localObject2).getDefn(), ((TVKNetVideoInfo.DefnInfo)localObject2).getDefnName(), ((TVKNetVideoInfo.DefnInfo)localObject2).getDefnRate(), ((TVKNetVideoInfo.DefnInfo)localObject2).getDefnShowName()));
      }
    }
    Object localObject1 = TVideoImpl.TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onGetVodInfoSuccess() reqType:");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("  liveInfo.getDefinitionList() == null");
    LogUtil.e((String)localObject1, ((StringBuilder)localObject2).toString());
    localTVideoNetInfo.setDefinitionList(localArrayList);
    if (paramTVKVideoInfo.getCurDefinition() != null) {
      localTVideoNetInfo.setCurrentDefinition(new TVideoNetInfo.DefinitionInfo(paramTVKVideoInfo.getCurDefinition().getDefn(), paramTVKVideoInfo.getCurDefinition().getDefnName(), paramTVKVideoInfo.getCurDefinition().getDefnRate(), paramTVKVideoInfo.getCurDefinition().getDefnShowName()));
    }
    localTVideoNetInfo.setUpdateTimeMillis(System.currentTimeMillis());
    boolean bool1 = bool2;
    if (paramTVKVideoInfo.getWatermarkInfos() != null) {
      if (paramTVKVideoInfo.getWatermarkInfos().size() == 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    localTVideoNetInfo.setHasWatermark(bool1);
    paramRequestInfo.setTVideoNetInfo(localTVideoNetInfo);
    VInfoCacheMgr.saveVInfoToCache(paramRequestInfo);
    if (TVideoImpl.access$100(this.this$0) != null) {
      TVideoImpl.access$100(this.this$0).onGetVInfoSuccess(paramRequestInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.vinfo.TVideoImpl.TVKPlayerCGICallback
 * JD-Core Version:    0.7.0.1
 */