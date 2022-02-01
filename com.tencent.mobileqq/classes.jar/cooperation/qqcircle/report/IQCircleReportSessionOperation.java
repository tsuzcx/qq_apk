package cooperation.qqcircle.report;

import feedcloud.FeedCloudCommon.StCommonExt;

public abstract interface IQCircleReportSessionOperation
{
  public abstract FeedCloudCommon.StCommonExt getSession(boolean paramBoolean);
  
  public abstract void updateSession(FeedCloudCommon.StCommonExt paramStCommonExt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.IQCircleReportSessionOperation
 * JD-Core Version:    0.7.0.1
 */