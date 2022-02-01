package com.tencent.mobileqq.doc;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITempGetProfileDetailProcessorProxy;
import com.tencent.qphone.base.util.QLog;

public class TencentDocUtils
{
  public static void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WL_DEBUG reportClickEvent actionName = ");
    localStringBuilder.append(paramString);
    QLog.d("TencentDocUtils", 1, localStringBuilder.toString());
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    boolean bool = TencentDocPref.a(paramAppInterface.getApp(), paramAppInterface.getAccount());
    if (!bool) {
      ((ITempGetProfileDetailProcessorProxy)QRoute.api(ITempGetProfileDetailProcessorProxy.class)).getTencentDocSwitch(paramAppInterface);
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("WL_DEBUG updateTencentDocUser isUser = ");
      paramAppInterface.append(bool);
      QLog.d("TencentDocUtils", 1, paramAppInterface.toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doc.TencentDocUtils
 * JD-Core Version:    0.7.0.1
 */