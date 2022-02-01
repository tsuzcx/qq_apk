package com.tencent.qqlive.module.videoreport.dtreport.video;

import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoHeartBeatSpUtils;

class VideoEventReporter$1
  implements Runnable
{
  VideoEventReporter$1(VideoEventReporter paramVideoEventReporter, VideoSession paramVideoSession) {}
  
  public void run()
  {
    VideoHeartBeatSpUtils.removeStartedEvent(this.val$videoSession.getContentId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.VideoEventReporter.1
 * JD-Core Version:    0.7.0.1
 */