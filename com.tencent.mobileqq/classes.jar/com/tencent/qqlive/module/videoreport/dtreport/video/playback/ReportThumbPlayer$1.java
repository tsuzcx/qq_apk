package com.tencent.qqlive.module.videoreport.dtreport.video.playback;

import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportManager;

class ReportThumbPlayer$1
  implements Runnable
{
  ReportThumbPlayer$1(ReportThumbPlayer paramReportThumbPlayer, Object paramObject) {}
  
  public void run()
  {
    VideoReportManager.getInstance().start(this.val$playerObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer.1
 * JD-Core Version:    0.7.0.1
 */