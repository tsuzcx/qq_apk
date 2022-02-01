package com.tencent.mobileqq.troop.api.config;

import com.tencent.mobileqq.activity.troop.DeleteTroopProcessor;
import com.tencent.mobileqq.activity.troop.UpdateTroopHeadIconProcessor;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public class TroopInfoServiceConfig
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_IMCoreTroopInfoServiceConfig.yml", version=1)
  private static ArrayList<Class<? extends AbsTroopInfoServiceProcessor>> jdField_a_of_type_JavaUtilArrayList;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static ArrayList<AbsTroopInfoServiceProcessor> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(UpdateTroopHeadIconProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(DeleteTroopProcessor.class);
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoServiceConfig", 2, new Object[] { "call init from ", MobileQQ.processName, " init = ", Boolean.valueOf(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) });
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
  
  public static void a(String paramString)
  {
    if (b != null)
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext()) {
        ((AbsTroopInfoServiceProcessor)localIterator.next()).a(paramString);
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (b != null)
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext()) {
        ((AbsTroopInfoServiceProcessor)localIterator.next()).a(paramString, paramBoolean);
      }
    }
  }
  
  private static void b()
  {
    if (jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        try
        {
          b.add(localClass.newInstance());
        }
        catch (Throwable localThrowable)
        {
          QLog.e("TroopInfoServiceConfig", 1, "Init Fail,", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopInfoServiceConfig
 * JD-Core Version:    0.7.0.1
 */