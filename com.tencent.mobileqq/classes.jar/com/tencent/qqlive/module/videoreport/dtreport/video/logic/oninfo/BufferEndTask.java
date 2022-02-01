package com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportFlowInfo;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportPlayerUtils;

public class BufferEndTask
  implements IOnInfoTask
{
  private static final String TAG = "BufferEndTask";
  private VideoReportFlowInfo flowInfo;
  private int playerState;
  
  public void doTask(Object paramObject, int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bufferEnd, ptr=");
    ((StringBuilder)localObject).append(paramObject);
    ((StringBuilder)localObject).append(" ,playerState=");
    ((StringBuilder)localObject).append(this.playerState);
    Log.i("BufferEndTask", ((StringBuilder)localObject).toString());
    if (this.playerState == 2)
    {
      paramObject = VideoReportPlayerUtils.debugStart();
      localObject = this.flowInfo.getVideoSession();
      if (localObject != null) {
        ((VideoSession)localObject).bufferEnd();
      }
      VideoReportPlayerUtils.debugEnd("bufferEnd", paramObject);
    }
  }
  
  public void setExtraParams(int paramInt, VideoReportFlowInfo paramVideoReportFlowInfo)
  {
    this.playerState = paramInt;
    this.flowInfo = paramVideoReportFlowInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo.BufferEndTask
 * JD-Core Version:    0.7.0.1
 */