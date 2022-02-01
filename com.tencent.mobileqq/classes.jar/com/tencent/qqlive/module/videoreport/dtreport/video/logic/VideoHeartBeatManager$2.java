package com.tencent.qqlive.module.videoreport.dtreport.video.logic;

import com.tencent.qqlive.module.videoreport.dtreport.video.VideoEventReporter;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;

class VideoHeartBeatManager$2
  implements Runnable
{
  VideoHeartBeatManager$2(VideoHeartBeatManager paramVideoHeartBeatManager, VideoSession paramVideoSession) {}
  
  public void run()
  {
    VideoEventReporter.getInstance().saveStartedEvent(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoHeartBeatManager.2
 * JD-Core Version:    0.7.0.1
 */