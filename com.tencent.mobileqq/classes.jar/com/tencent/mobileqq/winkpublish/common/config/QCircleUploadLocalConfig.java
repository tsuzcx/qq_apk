package com.tencent.mobileqq.winkpublish.common.config;

import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import cooperation.qqcircle.report.QCircleMapReporter;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import feedcloud.FeedCloudCommon.Entry;
import java.util.List;

public class QCircleUploadLocalConfig
  implements IUploadLocalConfig
{
  public String getSpKey()
  {
    return "QC";
  }
  
  public String getTag()
  {
    return "[QCUpload]";
  }
  
  public String getTaskCacheName()
  {
    return "publish_queue";
  }
  
  public String getTraceId()
  {
    return QCirclePublishQualityReporter.getTraceId();
  }
  
  public void mapReport(String paramString1, String paramString2, List<FeedCloudCommon.Entry> paramList)
  {
    QCircleMapReporter.getInstance().reportEnd(paramString1, paramString2, paramList);
  }
  
  public void uploadQualityReport(String paramString, List<FeedCloudCommon.Entry> paramList)
  {
    QCirclePublishQualityReporter.report(paramString, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.common.config.QCircleUploadLocalConfig
 * JD-Core Version:    0.7.0.1
 */