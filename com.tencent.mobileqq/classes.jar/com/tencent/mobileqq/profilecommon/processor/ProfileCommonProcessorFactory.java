package com.tencent.mobileqq.profilecommon.processor;

import com.tencent.mobileqq.apollo.api.push.impl.ApolloPushControlProcessor;
import com.tencent.mobileqq.extendfriend.config.ExpandProfileProcessor;
import com.tencent.mobileqq.qassistant.setting.AssistantSwitchImpl;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class ProfileCommonProcessorFactory
{
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_ProfileCommonProcessor.yml", version=1)
  public static ArrayList<Class<? extends AbsProfileCommonProcessor>> a = new ArrayList();
  private final ArrayList<AbsProfileCommonProcessor> b = new ArrayList();
  
  static
  {
    a.add(ApolloPushControlProcessor.class);
    a.add(AvatarHistoryNumProcessor.class);
    a.add(CallPushProcessor.class);
    a.add(FileAssistProcessor.class);
    a.add(HonorRichProcessor.class);
    a.add(KidModeProcessor.class);
    a.add(PaiYiPaiProcessor.class);
    a.add(TroopHonorRichProcessor.class);
    a.add(TroopLuckyCharacterProcessor.class);
    a.add(TroopHonorSwitchProcessor.class);
    a.add(AssistantSwitchImpl.class);
    a.add(ExpandProfileProcessor.class);
  }
  
  public ProfileCommonProcessorFactory(AppRuntime paramAppRuntime)
  {
    a(paramAppRuntime);
  }
  
  private void a(AppRuntime paramAppRuntime)
  {
    this.b.clear();
    Iterator localIterator = a.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject1 = (Class)localIterator.next();
        try
        {
          localObject1 = (AbsProfileCommonProcessor)((Class)localObject1).getConstructor(new Class[] { AppRuntime.class }).newInstance(new Object[] { paramAppRuntime });
          if (localObject1 != null) {
            this.b.add(localObject1);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d("ProfileCommonProcessorFactory", 1, "getProfileBusinessProcessors fail.", localException);
            Object localObject2 = null;
          }
        }
      }
    }
  }
  
  public <T extends AbsProfileCommonProcessor> T a(Class<? extends AbsProfileCommonProcessor> paramClass)
  {
    Object localObject = null;
    Iterator localIterator = this.b.iterator();
    if (localIterator.hasNext())
    {
      AbsProfileCommonProcessor localAbsProfileCommonProcessor = (AbsProfileCommonProcessor)localIterator.next();
      if (!localAbsProfileCommonProcessor.getClass().equals(paramClass)) {
        break label50;
      }
      localObject = localAbsProfileCommonProcessor;
    }
    label50:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  public AbsProfileCommonProcessor a(String paramString)
  {
    Object localObject = null;
    Iterator localIterator = this.b.iterator();
    if (localIterator.hasNext())
    {
      AbsProfileCommonProcessor localAbsProfileCommonProcessor = (AbsProfileCommonProcessor)localIterator.next();
      if (!localAbsProfileCommonProcessor.getProcessorKey().equals(paramString)) {
        break label50;
      }
      localObject = localAbsProfileCommonProcessor;
    }
    label50:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  public ArrayList<AbsProfileCommonProcessor> a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.processor.ProfileCommonProcessorFactory
 * JD-Core Version:    0.7.0.1
 */