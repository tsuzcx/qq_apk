package com.tencent.qqlive.tvkplayer.vinfo;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter.OnGetLiveInfoListener;

class TVKUrlGetter$2
  implements ITVKLiveInfoGetter.OnGetLiveInfoListener
{
  TVKUrlGetter$2(TVKUrlGetter paramTVKUrlGetter) {}
  
  public void onGetLiveInfoFailed(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo)
  {
    TVKLogUtil.i("MediaPlayerMgr[TVKUrlGetter.java]", "onGetLiveInfoFailed,requestId:" + paramInt);
    if (TVKUrlGetter.access$000(this.this$0) == null) {
      return;
    }
    if (paramTVKLiveVideoInfo == null)
    {
      TVKUrlGetter.access$000(this.this$0).onGetUrlFailed(this.this$0, paramInt, 104, 144000, null);
      return;
    }
    TVKUrlGetter.access$000(this.this$0).onGetUrlFailed(this.this$0, paramInt, 104, paramTVKLiveVideoInfo.getRetCode(), null);
  }
  
  public void onGetLiveInfoSucceed(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo)
  {
    if (TVKUrlGetter.access$000(this.this$0) == null) {
      return;
    }
    if (paramTVKLiveVideoInfo == null)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKUrlGetter.java]", "onGetLiveInfoSucceed progInfo is null ");
      TVKUrlGetter.access$000(this.this$0).onGetUrlFailed(this.this$0, paramInt, 104, 144000, null);
      return;
    }
    if (TextUtils.isEmpty(paramTVKLiveVideoInfo.getOriginalPlayUrl()))
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKUrlGetter.java]", "onGetLiveInfoSucceed url is null ");
      TVKUrlGetter.access$000(this.this$0).onGetUrlFailed(this.this$0, paramInt, 104, paramTVKLiveVideoInfo.getRetCode(), null);
      return;
    }
    TVKUrlGetter.access$000(this.this$0).onGetUrl(this.this$0, paramInt, paramTVKLiveVideoInfo.getOriginalPlayUrl(), null, paramTVKLiveVideoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKUrlGetter.2
 * JD-Core Version:    0.7.0.1
 */