package com.tencent.qqlive.module.videoreport.dtreport.video.logic;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatProcessor.IHeartBeatCallback;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;

class VideoHeartBeatManager$1
  implements HeartBeatProcessor.IHeartBeatCallback
{
  VideoHeartBeatManager$1(VideoHeartBeatManager paramVideoHeartBeatManager) {}
  
  public void reportHeartBeat(String paramString, long paramLong1, long paramLong2) {}
  
  public void saveHeartBeatInfo(String paramString, long paramLong1, long paramLong2)
  {
    Log.i("VideoHeartBeatManager", "setHeartBeatCallback, saveHeartBeatInfo");
    ThreadUtils.execTask(new VideoHeartBeatManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoHeartBeatManager.1
 * JD-Core Version:    0.7.0.1
 */