package com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportFlowInfo;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportPlayerUtils;

public class BufferStartTask
  implements IOnInfoTask
{
  private static final String TAG = "BufferStartTask";
  private VideoReportFlowInfo flowInfo;
  private int playerState;
  
  public void doTask(Object paramObject, int paramInt, long paramLong1, long paramLong2)
  {
    Log.i("BufferStartTask", "bufferStart, ptr=" + paramObject + " ,playerState=" + this.playerState);
    if (this.playerState == 2)
    {
      paramObject = VideoReportPlayerUtils.debugStart();
      VideoSession localVideoSession = this.flowInfo.getVideoSession();
      if (localVideoSession != null) {
        localVideoSession.bufferStart();
      }
      VideoReportPlayerUtils.debugEnd("bufferStart", paramObject);
    }
  }
  
  public void setExtraParams(int paramInt, VideoReportFlowInfo paramVideoReportFlowInfo)
  {
    this.playerState = paramInt;
    this.flowInfo = paramVideoReportFlowInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo.BufferStartTask
 * JD-Core Version:    0.7.0.1
 */