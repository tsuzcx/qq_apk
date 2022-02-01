package com.tencent.util;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.tools.PhoneUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.utils.AppIntefaceReportWrap;

public class UtilApiImpl
  implements IUtilApi
{
  public String a()
  {
    return ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "");
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    HttpDownloader.reportHttpsSniMethod(paramInt1, paramString1, paramInt2, paramString2);
  }
  
  public void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    AppIntefaceReportWrap.a(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public boolean a()
  {
    return RichMediaUtil.isActiveReporting();
  }
  
  public String b()
  {
    return PhoneUtil.a(BaseApplicationImpl.sApplication, QBaseActivity.sTopActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.UtilApiImpl
 * JD-Core Version:    0.7.0.1
 */