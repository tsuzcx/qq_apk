package com.tencent.mobileqq.kandian.glue.video;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;

class VideoPreDownloadMgr$3
  implements ThirdVideoManager.UUIDToUrlCallback
{
  VideoPreDownloadMgr$3(VideoPreDownloadMgr paramVideoPreDownloadMgr, int paramInt) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    if (TextUtils.isEmpty(paramVideoUrlInfo.a)) {
      return;
    }
    ThreadManager.post(new VideoPreDownloadMgr.3.1(this, paramVideoUrlInfo), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr.3
 * JD-Core Version:    0.7.0.1
 */