package com.tencent.mobileqq.profilecard.processor;

import com.tencent.mobileqq.apollo.api.profilecard.impl.ApolloProfileBusinessProcessor;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class ProfileBusinessProcessorFactory
{
  private static final String TAG = "ProfileBusinessProcessorFactory";
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_ProfileBusinessProcessor.yml", version=1)
  public static ArrayList<Class<? extends AbsProfileBusinessProcessor>> sInjectProcessorClasses = new ArrayList();
  private final AtomicBoolean injectInit = new AtomicBoolean(false);
  private final List<AbsProfileBusinessProcessor> injectProcessors = new CopyOnWriteArrayList();
  
  static
  {
    sInjectProcessorClasses.add(DefaultProfileBusinessProcessor.class);
    sInjectProcessorClasses.add(TempProfileBusinessProcessor.class);
    sInjectProcessorClasses.add(TempGetProfileDetailProcessor.class);
    sInjectProcessorClasses.add(ApolloProfileBusinessProcessor.class);
  }
  
  private void initBusinessProcessors(AppRuntime paramAppRuntime)
  {
    this.injectProcessors.clear();
    Iterator localIterator = sInjectProcessorClasses.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject1 = (Class)localIterator.next();
        try
        {
          localObject1 = (AbsProfileBusinessProcessor)((Class)localObject1).getConstructor(new Class[] { AppRuntime.class }).newInstance(new Object[] { paramAppRuntime });
          if (localObject1 != null) {
            this.injectProcessors.add(localObject1);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d("ProfileBusinessProcessorFactory", 1, "getProfileBusinessProcessors fail.", localException);
            Object localObject2 = null;
          }
        }
      }
    }
  }
  
  public List<AbsProfileBusinessProcessor> getBusinessProcessors(AppRuntime paramAppRuntime)
  {
    if (!this.injectInit.get())
    {
      this.injectInit.set(true);
      initBusinessProcessors(paramAppRuntime);
    }
    return this.injectProcessors;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.processor.ProfileBusinessProcessorFactory
 * JD-Core Version:    0.7.0.1
 */