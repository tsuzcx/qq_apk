package com.tencent.mobileqq.winkpublish.api.impl;

import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IUploadCommonSetting;
import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.common.AUploadCommonSetting;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.List;

public class UploadCommonSettingImpl
  implements IUploadCommonSetting
{
  private String getReportId(String paramString)
  {
    Object localObject = paramString;
    if (QCircleConfigHelper.bg())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(((IUploadCommonSetting)QRoute.api(IUploadCommonSetting.class)).getSpKey());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public String getSpKey()
  {
    return AUploadCommonSetting.a().getSpKey();
  }
  
  public void reportPublishQuality(String paramString, List<FeedCloudCommon.Entry> paramList)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(getReportId(paramString), paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.api.impl.UploadCommonSettingImpl
 * JD-Core Version:    0.7.0.1
 */