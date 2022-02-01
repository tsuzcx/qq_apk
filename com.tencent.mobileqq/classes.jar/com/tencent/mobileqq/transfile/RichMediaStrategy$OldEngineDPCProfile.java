package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class RichMediaStrategy$OldEngineDPCProfile
{
  public static boolean hasGetDPC;
  private RichMediaStrategy.OldEngineDPCProfile.TimeoutParam timeoutParams = new RichMediaStrategy.OldEngineDPCProfile.TimeoutParam();
  
  public RichMediaStrategy$OldEngineDPCProfile()
  {
    updateFromDPC(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.HttpTimeoutParam.name()));
    registerObserver();
  }
  
  private void registerObserver()
  {
    DeviceProfileManager.a(new RichMediaStrategy.OldEngineDPCProfile.1(this));
  }
  
  public RichMediaStrategy.OldEngineDPCProfile.TimeoutParam getTimeoutParam()
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
 * Qualified Name:     com.tencent.mobileqq.transfile.RichMediaStrategy.OldEngineDPCProfile
 * JD-Core Version:    0.7.0.1
 */