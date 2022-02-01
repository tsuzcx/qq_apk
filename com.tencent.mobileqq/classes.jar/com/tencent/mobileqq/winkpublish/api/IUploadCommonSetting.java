package com.tencent.mobileqq.winkpublish.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import feedcloud.FeedCloudCommon.Entry;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IUploadCommonSetting
  extends QRouteApi
{
  public abstract String getSpKey();
  
  public abstract void reportPublishQuality(String paramString, List<FeedCloudCommon.Entry> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.api.IUploadCommonSetting
 * JD-Core Version:    0.7.0.1
 */