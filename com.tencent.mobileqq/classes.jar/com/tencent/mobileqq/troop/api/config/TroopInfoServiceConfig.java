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
  private static final Object a = new Object();
  private static AtomicBoolean b = new AtomicBoolean(false);
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_IMCoreTroopInfoServiceConfig.yml", version=1)
  private static ArrayList<Class<? extends AbsTroopInfoServiceProcessor>> c = new ArrayList();
  private static ArrayList<AbsTroopInfoServiceProcessor> d = new ArrayList();
  
  static
  {
    c.add(UpdateTroopHeadIconProcessor.class);
    c.add(DeleteTroopProcessor.class);
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoServiceConfig", 2, new Object[] { "call init from ", MobileQQ.processName, " init = ", Boolean.valueOf(b.get()) });
    }
    synchronized (a)
    {
      if (b.get()) {
        return;
      }
      b();
      b.set(true);
      return;
    }
  }
  
  public static void a(String paramString)
  {
    Object localObject = d;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsTroopInfoServiceProcessor)((Iterator)localObject).next()).a(paramString);
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    Object localObject = d;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsTroopInfoServiceProcessor)((Iterator)localObject).next()).a(paramString, paramBoolean);
      }
    }
  }
  
  private static void b()
  {
    Object localObject = c;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Class localClass = (Class)((Iterator)localObject).next();
        try
        {
          d.add(localClass.newInstance());
        }
        catch (Throwable localThrowable)
        {
          QLog.e("TroopInfoServiceConfig", 1, "Init Fail,", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopInfoServiceConfig
 * JD-Core Version:    0.7.0.1
 */