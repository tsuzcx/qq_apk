package com.tencent.mobileqq.winkpublish.common.config;

import com.tencent.mobileqq.winkpublish.Singleton;
import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import cooperation.qqcircle.report.QCircleMapReporter;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import feedcloud.FeedCloudCommon.Entry;
import java.util.List;

public class DefaultUploadLocalConfig
  implements IUploadLocalConfig
{
  private static final Singleton<DefaultUploadLocalConfig, Void> sSingleton = new DefaultUploadLocalConfig.1();
  
  public static DefaultUploadLocalConfig getInstance()
  {
    return (DefaultUploadLocalConfig)sSingleton.get(null);
  }
  
  public String getSpKey()
  {
    return "default";
  }
  
  public String getTag()
  {
    return "[defaultUpload]";
  }
  
  public String getTaskCacheName()
  {
    return "default_publish_queue";
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
 * Qualified Name:     com.tencent.mobileqq.winkpublish.common.config.DefaultUploadLocalConfig
 * JD-Core Version:    0.7.0.1
 */