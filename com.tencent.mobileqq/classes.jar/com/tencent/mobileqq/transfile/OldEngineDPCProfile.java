package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class OldEngineDPCProfile
{
  public static boolean hasGetDPC = false;
  private TimeoutParam timeoutParams = new TimeoutParam();
  
  public OldEngineDPCProfile()
  {
    updateFromDPC(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.HttpTimeoutParam.name()));
    registerObserver();
  }
  
  private void registerObserver()
  {
    OldEngineDPCProfile.1 local1 = new OldEngineDPCProfile.1(this);
    ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(local1);
  }
  
  public TimeoutParam getTimeoutParam()
  {
    return this.timeoutParams.clone();
  }
  
  public void updateFromDPC(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RichMediaStrategy", 2, "OldEngine Timeout Params : " + paramString);
      }
      paramString = paramString.split("\\|");
    } while ((paramString == null) || (paramString.length != 6));
    try
    {
      this.timeoutParams.connectTimeoutFor2G = (Integer.valueOf(paramString[0]).intValue() * 1000);
      this.timeoutParams.connectTimeoutFor3G = (Integer.valueOf(paramString[1]).intValue() * 1000);
      this.timeoutParams.connectTimeoutForWifi = (Integer.valueOf(paramString[2]).intValue() * 1000);
      this.timeoutParams.readTimeoutFor2G = (Integer.valueOf(paramString[3]).intValue() * 1000);
      this.timeoutParams.readTimeoutFor3G = (Integer.valueOf(paramString[4]).intValue() * 1000);
      this.timeoutParams.readTimeoutForWifi = (Integer.valueOf(paramString[5]).intValue() * 1000);
      hasGetDPC = true;
      return;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldEngineDPCProfile
 * JD-Core Version:    0.7.0.1
 */