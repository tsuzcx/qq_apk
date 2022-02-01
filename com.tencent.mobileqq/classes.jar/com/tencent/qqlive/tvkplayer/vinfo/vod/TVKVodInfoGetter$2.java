package com.tencent.qqlive.tvkplayer.vinfo.vod;

import com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter.ITVKVodInfoGetterCallback;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKVideoInfoResponse;

class TVKVodInfoGetter$2
  implements ITVKVideoInfoResponse
{
  TVKVodInfoGetter$2(TVKVodInfoGetter paramTVKVodInfoGetter) {}
  
  public void onFailure(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    TVKVodInfoGetter.access$000(this.this$0).onFailure(paramInt1, paramInt2, paramString1, paramInt3, paramString2);
  }
  
  public void onSuccess(int paramInt, TVKVideoInfo paramTVKVideoInfo)
  {
    TVKVodInfoGetter.access$000(this.this$0).onSuccess(paramInt, paramTVKVideoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVodInfoGetter.2
 * JD-Core Version:    0.7.0.1
 */