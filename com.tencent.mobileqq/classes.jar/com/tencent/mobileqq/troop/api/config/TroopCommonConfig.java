package com.tencent.mobileqq.troop.api.config;

import android.content.Context;
import com.tencent.mobileqq.activity.troop.TroopCommonProcessor;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TroopCommonConfig
{
  private static AbsTroopCommonProcessor jdField_a_of_type_ComTencentMobileqqTroopApiConfigAbsTroopCommonProcessor = null;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_IMCoreTroopCommonConfig.yml", version=1)
  private static ArrayList<Class<? extends AbsTroopCommonProcessor>> jdField_a_of_type_JavaUtilArrayList;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(TroopCommonProcessor.class);
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopCommonCofig", 2, new Object[] { "call init from ", MobileQQ.processName, " init = ", Boolean.valueOf(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) });
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        return;
      }
      b();
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
    }
  }
  
  public static void a(List<String> paramList)
  {
    AbsTroopCommonProcessor localAbsTroopCommonProcessor = jdField_a_of_type_ComTencentMobileqqTroopApiConfigAbsTroopCommonProcessor;
    if (localAbsTroopCommonProcessor != null) {
      localAbsTroopCommonProcessor.a(paramList);
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    AbsTroopCommonProcessor localAbsTroopCommonProcessor = jdField_a_of_type_ComTencentMobileqqTroopApiConfigAbsTroopCommonProcessor;
    if (localAbsTroopCommonProcessor != null) {
      return localAbsTroopCommonProcessor.a(paramContext, paramString1, paramString2);
    }
    return false;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    AbsTroopCommonProcessor localAbsTroopCommonProcessor = jdField_a_of_type_ComTencentMobileqqTroopApiConfigAbsTroopCommonProcessor;
    if (localAbsTroopCommonProcessor != null) {
      return localAbsTroopCommonProcessor.a(paramAppRuntime, paramTroopInfo, paramBoolean);
    }
    return false;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    AbsTroopCommonProcessor localAbsTroopCommonProcessor = jdField_a_of_type_ComTencentMobileqqTroopApiConfigAbsTroopCommonProcessor;
    if (localAbsTroopCommonProcessor != null) {
      return localAbsTroopCommonProcessor.a(paramAppRuntime, paramString);
    }
    return false;
  }
  
  private static void b()
  {
    ArrayList localArrayList = jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (localArrayList.size() == 1)) {
      try
      {
        jdField_a_of_type_ComTencentMobileqqTroopApiConfigAbsTroopCommonProcessor = (AbsTroopCommonProcessor)((Class)jdField_a_of_type_JavaUtilArrayList.get(0)).newInstance();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("TroopCommonCofig", 1, "Init Fail,", localThrowable);
      }
    }
    QLog.e("TroopCommonCofig", 1, new Object[] { "Init Fail,", "TroopCommonConfig" });
  }
  
  public static boolean b(AppRuntime paramAppRuntime, String paramString)
  {
    AbsTroopCommonProcessor localAbsTroopCommonProcessor = jdField_a_of_type_ComTencentMobileqqTroopApiConfigAbsTroopCommonProcessor;
    if (localAbsTroopCommonProcessor != null) {
      return localAbsTroopCommonProcessor.b(paramAppRuntime, paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopCommonConfig
 * JD-Core Version:    0.7.0.1
 */