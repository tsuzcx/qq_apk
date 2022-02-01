package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.config.extension.BizTroopCustomizedProcessorRegister;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopSurveyHandlerProcessorConfig
{
  private static ArrayList<AbsTroopSurveyHandlerProcessor> a = new ArrayList();
  private static TroopSurveyHandlerProcessorConfig b;
  
  private TroopSurveyHandlerProcessorConfig()
  {
    b();
  }
  
  public static TroopSurveyHandlerProcessorConfig a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new TroopSurveyHandlerProcessorConfig();
        }
      }
      finally {}
    }
    return b;
  }
  
  private static void b()
  {
    if (BizTroopCustomizedProcessorRegister.c != null)
    {
      Iterator localIterator = BizTroopCustomizedProcessorRegister.c.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsTroopSurveyHandlerProcessor)((Class)localObject).newInstance();
          a.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("TroopSurveyHandlerProcessorConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, @NonNull ToServiceMsg paramToServiceMsg, String paramString, @NonNull oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopSurveyHandlerProcessor)localIterator.next()).a(paramAppInterface, paramToServiceMsg, paramString, paramOIDBSSOPkg);
    }
  }
  
  public void a(@NonNull String paramString)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopSurveyHandlerProcessor)localIterator.next()).a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopSurveyHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */