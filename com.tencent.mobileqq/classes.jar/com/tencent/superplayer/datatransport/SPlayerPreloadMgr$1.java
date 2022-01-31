package com.tencent.superplayer.datatransport;

import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.vinfo.VInfoGetter.VInfoGetterListener;

class SPlayerPreloadMgr$1
  implements VInfoGetter.VInfoGetterListener
{
  SPlayerPreloadMgr$1(SPlayerPreloadMgr paramSPlayerPreloadMgr) {}
  
  public void onGetVInfoFailed(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, int paramInt, String paramString) {}
  
  public void onGetVInfoSuccess(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    SPlayerPreloadMgr.access$000(this.this$0, paramSuperPlayerVideoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPlayerPreloadMgr.1
 * JD-Core Version:    0.7.0.1
 */