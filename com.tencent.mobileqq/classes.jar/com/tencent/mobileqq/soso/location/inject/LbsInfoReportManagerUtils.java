package com.tencent.mobileqq.soso.location.inject;

import com.tencent.mobileqq.app.soso.LbsInfoReportManagerProcessorProxy;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class LbsInfoReportManagerUtils
{
  private static final String TAG = "SOSO.LbsInfoReportManagerUtils";
  @ConfigInject(configPath="Foundation/QQLocation/src/main/resources/Inject_QQLocationLbsInfoReportManagerProcessor.yml", version=1)
  public static ArrayList<Class<? extends ILbsInfoReportManagerProcessor>> sLbsInfoReportManagerClassList = new ArrayList();
  
  static
  {
    sLbsInfoReportManagerClassList.add(LbsInfoReportManagerProcessorProxy.class);
  }
  
  public static void reportLbsInfo2DC(SosoLocation paramSosoLocation, String paramString)
  {
    try
    {
      ((ILbsInfoReportManagerProcessor)((Class)sLbsInfoReportManagerClassList.get(0)).newInstance()).reportLbsInfo2DC(paramSosoLocation, paramString);
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LbsInfoReportManagerUtils", 2, "ILbsInfoReportManagerProcessor.reportLbsInfo2DC(), location = " + paramSosoLocation + ", businessTag = " + paramString);
      }
      return;
    }
    catch (Throwable paramSosoLocation)
    {
      QLog.e("SOSO.LbsInfoReportManagerUtils", 1, paramSosoLocation, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.inject.LbsInfoReportManagerUtils
 * JD-Core Version:    0.7.0.1
 */