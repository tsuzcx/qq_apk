package com.tencent.mobileqq.phonecontact.processor;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class PhoneContactInjectFactory
{
  @ConfigInject(configPath="Business/qq-phonecontact-impl/src/main/resources/Inject_PhoneContactProcessor.yml", version=1)
  private static ArrayList<Class<? extends IPhoneContactProcessor>> a = new ArrayList();
  
  static
  {
    a.add(PhoneContactProcessor.class);
  }
  
  public static IPhoneContactProcessor a(AppInterface paramAppInterface)
  {
    try
    {
      Object localObject = (IPhoneContactProcessor)((Class)a.get(0)).newInstance();
      try
      {
        ((IPhoneContactProcessor)localObject).a(paramAppInterface);
        return localObject;
      }
      catch (Exception localException2)
      {
        paramAppInterface = (AppInterface)localObject;
        localObject = localException2;
      }
      QLog.d("IMCore.PhoneContact.PhoneContactInjectFactory", 1, "getProcessor", localException1);
    }
    catch (Exception localException1)
    {
      paramAppInterface = null;
    }
    return paramAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.processor.PhoneContactInjectFactory
 * JD-Core Version:    0.7.0.1
 */