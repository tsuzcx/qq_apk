package com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo;

import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportFlowInfo;

public abstract interface IOnInfoTask
{
  public abstract void doTask(Object paramObject, int paramInt, long paramLong1, long paramLong2);
  
  public abstract void setExtraParams(int paramInt, VideoReportFlowInfo paramVideoReportFlowInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo.IOnInfoTask
 * JD-Core Version:    0.7.0.1
 */