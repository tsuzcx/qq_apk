package com.tencent.mobileqq.profilecommon.processor;

import com.tencent.mobileqq.addfriend.processor.switchprocessor.AddFriendSettingProcessor;
import com.tencent.mobileqq.apollo.push.ApolloPushControlProcessor;
import com.tencent.mobileqq.qassistant.setting.AssistantSwitchImpl;
import com.tencent.mobileqq.qqexpand.config.profile.ExpandProfileProcessor;
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
    a.add(TempSettingProcessor.class);
    a.add(TroopHonorRichProcessor.class);
    a.add(TroopLuckyCharacterProcessor.class);
    a.add(TroopHonorSwitchProcessor.class);
    a.add(VipProcessor.class);
    a.add(AssistantSwitchImpl.class);
    a.add(ExpandProfileProcessor.class);
    a.add(AddFriendSettingProcessor.class);
  }
  
  public ProfileCommonProcessorFactory(AppRuntime paramAppRuntime)
  {
    a(paramAppRuntime);
  }
  
  private void a(AppRuntime paramAppRuntime)
  {
    this.b.clear();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Class)localIterator.next();
      Object localObject2;
      try
      {
        localObject1 = (AbsProfileCommonProcessor)((Class)localObject1).getConstructor(new Class[] { AppRuntime.class }).newInstance(new Object[] { paramAppRuntime });
      }
      catch (Exception localException)
      {
        QLog.d("ProfileCommonProcessorFactory", 1, "getProfileBusinessProcessors fail.", localException);
        localObject2 = null;
      }
      if (localObject2 != null) {
        this.b.add(localObject2);
      }
    }
  }
  
  public <T extends AbsProfileCommonProcessor> T a(Class<? extends AbsProfileCommonProcessor> paramClass)
  {
    Iterator localIterator = this.b.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      AbsProfileCommonProcessor localAbsProfileCommonProcessor = (AbsProfileCommonProcessor)localIterator.next();
      if (localAbsProfileCommonProcessor.getClass().equals(paramClass)) {
        localObject = localAbsProfileCommonProcessor;
      }
    }
    return localObject;
  }
  
  public AbsProfileCommonProcessor a(String paramString)
  {
    Iterator localIterator = this.b.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      AbsProfileCommonProcessor localAbsProfileCommonProcessor = (AbsProfileCommonProcessor)localIterator.next();
      if (localAbsProfileCommonProcessor.getProcessorKey().equals(paramString)) {
        localObject = localAbsProfileCommonProcessor;
      }
    }
    return localObject;
  }
  
  public ArrayList<AbsProfileCommonProcessor> a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.processor.ProfileCommonProcessorFactory
 * JD-Core Version:    0.7.0.1
 */