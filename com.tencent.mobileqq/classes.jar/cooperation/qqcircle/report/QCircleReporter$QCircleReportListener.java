package cooperation.qqcircle.report;

import feedcloud.FeedCloudCommon.Entry;
import java.util.List;

public abstract interface QCircleReporter$QCircleReportListener
{
  public abstract void onAddReportData(int paramInt, List<FeedCloudCommon.Entry> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.QCircleReportListener
 * JD-Core Version:    0.7.0.1
 */