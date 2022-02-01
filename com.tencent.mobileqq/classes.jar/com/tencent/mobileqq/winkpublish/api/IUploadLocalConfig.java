package com.tencent.mobileqq.winkpublish.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import feedcloud.FeedCloudCommon.Entry;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IUploadLocalConfig
  extends QRouteApi
{
  public abstract String getSpKey();
  
  public abstract String getTag();
  
  public abstract String getTaskCacheName();
  
  public abstract String getTraceId();
  
  public abstract void mapReport(String paramString1, String paramString2, List<FeedCloudCommon.Entry> paramList);
  
  public abstract void uploadQualityReport(String paramString, List<FeedCloudCommon.Entry> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig
 * JD-Core Version:    0.7.0.1
 */