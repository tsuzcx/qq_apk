package com.tencent.mobileqq.soso.location.inject;

import com.tencent.mobileqq.app.soso.LbsGdtProcessorProxy;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class LbsGdtUtils
{
  private static final String TAG = "SOSO.LbsGdtUtils";
  @ConfigInject(configPath="Foundation/QQLocation/src/main/resources/Inject_QQLocationLbsGdtUtilsProcessor.yml", version=1)
  public static ArrayList<Class<? extends ILbsGdtUtilsProcessor>> sILbsGdtUtilsProcessorClassList = new ArrayList();
  
  static
  {
    sILbsGdtUtilsProcessorClassList.add(LbsGdtProcessorProxy.class);
  }
  
  public static String getOaid()
  {
    try
    {
      Object localObject = (ILbsGdtUtilsProcessor)((Class)sILbsGdtUtilsProcessorClassList.get(0)).newInstance();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("lbsGdtUtilsProcessor.getOaid() = ");
        localStringBuilder.append(((ILbsGdtUtilsProcessor)localObject).getOaid());
        QLog.i("SOSO.LbsGdtUtils", 2, localStringBuilder.toString());
      }
      localObject = ((ILbsGdtUtilsProcessor)localObject).getOaid();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SOSO.LbsGdtUtils", 1, localThrowable, new Object[0]);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.inject.LbsGdtUtils
 * JD-Core Version:    0.7.0.1
 */