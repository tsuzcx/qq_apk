package com.tencent.qqlive.module.videoreport.dtreport.video;

import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoHeartBeatSpUtils;

class VideoEventReporter$2
  implements Runnable
{
  VideoEventReporter$2(VideoEventReporter paramVideoEventReporter, VideoSession paramVideoSession) {}
  
  public void run()
  {
    VideoHeartBeatSpUtils.removeEndEvent(this.a.getContentId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.VideoEventReporter.2
 * JD-Core Version:    0.7.0.1
 */