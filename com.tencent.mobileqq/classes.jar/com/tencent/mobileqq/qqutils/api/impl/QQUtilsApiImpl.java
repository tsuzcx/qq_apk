package com.tencent.mobileqq.qqutils.api.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.tools.PhoneUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qqutils.api.IQQUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.utils.QQTheme;

public class QQUtilsApiImpl
  implements IQQUtilsApi
{
  public String getDeviceId()
  {
    return PhoneUtil.a(BaseApplicationImpl.sApplication, QBaseActivity.sTopActivity);
  }
  
  public String getFeatureValueAioConfig()
  {
    return ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "");
  }
  
  public boolean isActiveReporting()
  {
    return RichMediaUtil.isActiveReporting();
  }
  
  public boolean isNowSimpleUI()
  {
    return QQTheme.e();
  }
  
  public void reportHttpsSniMethod(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    HttpDownloader.reportHttpsSniMethod(paramInt1, paramString1, paramInt2, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqutils.api.impl.QQUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */