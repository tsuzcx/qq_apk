package com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportFlowInfo;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportManager;

public class LoopEndTask
  implements IOnInfoTask
{
  private static final String TAG = "LoopEndTask";
  private VideoReportFlowInfo flowInfo;
  private int playerState;
  
  public void doTask(Object paramObject, int paramInt, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loopEnd, ptr=");
    localStringBuilder.append(paramObject);
    localStringBuilder.append(" ,playerState=");
    localStringBuilder.append(this.playerState);
    Log.i("LoopEndTask", localStringBuilder.toString());
    if ((this.playerState == 2) && (!this.flowInfo.isLoopEnd()))
    {
      VideoReportManager.getInstance().loopEnd(paramObject);
      this.flowInfo.setLoopEnd(true);
    }
  }
  
  public void setExtraParams(int paramInt, VideoReportFlowInfo paramVideoReportFlowInfo)
  {
    this.playerState = paramInt;
    this.flowInfo = paramVideoReportFlowInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo.LoopEndTask
 * JD-Core Version:    0.7.0.1
 */