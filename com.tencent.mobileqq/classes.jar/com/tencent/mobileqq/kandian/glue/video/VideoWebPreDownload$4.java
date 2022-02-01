package com.tencent.mobileqq.kandian.glue.video;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoWebPreDownload.CallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import java.util.HashMap;

class VideoWebPreDownload$4
  implements TVK_ICacheMgr.IPreloadCallback
{
  VideoWebPreDownload$4(VideoWebPreDownload paramVideoWebPreDownload) {}
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    if (VideoWebPreDownload.a(this.a) != null)
    {
      paramString2 = (String)VideoWebPreDownload.a(this.a).get(paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        VideoWebPreDownload.a(this.a).a(paramString1, paramInt, paramString2);
      }
    }
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    if (VideoWebPreDownload.a(this.a) != null)
    {
      paramString2 = (String)VideoWebPreDownload.a(this.a).get(paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        VideoWebPreDownload.a(this.a).a(paramString1, 1, paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoWebPreDownload.4
 * JD-Core Version:    0.7.0.1
 */