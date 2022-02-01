package com.tencent.qqlive.tvkplayer.vinfo.vod;

import com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter.ITVKVodInfoGetterCallback;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKVideoInfoResponse;

class TVKVodInfoGetter$2
  implements ITVKVideoInfoResponse
{
  TVKVodInfoGetter$2(TVKVodInfoGetter paramTVKVodInfoGetter) {}
  
  public void OnSuccess(int paramInt, TVKVideoInfo paramTVKVideoInfo)
  {
    TVKVodInfoGetter.access$000(this.this$0).OnSuccess(paramInt, paramTVKVideoInfo);
  }
  
  public void onFailure(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    TVKVodInfoGetter.access$000(this.this$0).onFailure(paramInt1, paramInt2, paramString1, paramInt3, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVodInfoGetter.2
 * JD-Core Version:    0.7.0.1
 */