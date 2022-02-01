package com.tencent.mobileqq.kandian.glue.video;

import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;

class VideoWebPreDownload$5
  implements Runnable
{
  VideoWebPreDownload$5(VideoWebPreDownload paramVideoWebPreDownload) {}
  
  public void run()
  {
    if (VideoWebPreDownload.a(this.this$0) != null)
    {
      VideoWebPreDownload.a(this.this$0).stopCacheData(20160519);
      VideoWebPreDownload.a(this.this$0).removePreloadCallback();
      VideoWebPreDownload.a(this.this$0).releasePreload(20160519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoWebPreDownload.5
 * JD-Core Version:    0.7.0.1
 */