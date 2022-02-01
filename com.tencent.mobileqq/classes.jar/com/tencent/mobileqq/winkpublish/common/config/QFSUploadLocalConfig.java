package com.tencent.mobileqq.winkpublish.common.config;

import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import cooperation.qqcircle.report.QCircleMapReporter;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import feedcloud.FeedCloudCommon.Entry;
import java.util.List;

public class QFSUploadLocalConfig
  implements IUploadLocalConfig
{
  public String getSpKey()
  {
    return "QFS";
  }
  
  public String getTag()
  {
    return "[QFSUpload]";
  }
  
  public String getTaskCacheName()
  {
    return "QFS_publish_queue";
  }
  
  public String getTraceId()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QCirclePublishQualityReporter.getTraceId());
    localStringBuilder.append("_QFS");
    return localStringBuilder.toString();
  }
  
  public void mapReport(String paramString1, String paramString2, List<FeedCloudCommon.Entry> paramList)
  {
    QCircleMapReporter localQCircleMapReporter = QCircleMapReporter.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getSpKey());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    localQCircleMapReporter.reportEnd(localStringBuilder.toString(), paramString2, paramList);
  }
  
  public void uploadQualityReport(String paramString, List<FeedCloudCommon.Entry> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getSpKey());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    QCirclePublishQualityReporter.report(localStringBuilder.toString(), paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.common.config.QFSUploadLocalConfig
 * JD-Core Version:    0.7.0.1
 */