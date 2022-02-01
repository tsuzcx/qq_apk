package com.tencent.mobileqq.troop.managerfactory.api.impl;

import com.tencent.mobileqq.troop.managerfactory.api.IManagerFactoryService;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public final class ManagerFactoryServiceImpl
  implements IManagerFactoryService
{
  private static final String TAG = "ManagerFactoryImpl";
  private AppRuntime mAppRuntime;
  private ConcurrentHashMap<Class, Object> managerLocks = new ConcurrentHashMap();
  private ConcurrentHashMap<Class, Manager> managers = new ConcurrentHashMap();
  
  private <T extends Manager> T createManager(Class<T> paramClass)
  {
    if (this.managerLocks.get(paramClass) == null) {
      synchronized (this.managerLocks)
      {
        if (this.managerLocks.get(paramClass) == null) {
          this.managerLocks.put(paramClass, new Object());
        }
      }
    }
    synchronized (this.managerLocks.get(paramClass))
    {
      ??? = (Manager)this.managers.get(paramClass);
      if (??? != null)
      {
        return ???;
        paramClass = finally;
        throw paramClass;
      }
      localObject2 = ???;
      localObject3 = ???;
      localObject4 = ???;
      localObject5 = ???;
      try
      {
        Constructor localConstructor = paramClass.getDeclaredConstructor(new Class[] { AppRuntime.class });
        localObject2 = ???;
        localObject3 = ???;
        localObject4 = ???;
        localObject5 = ???;
        localConstructor.setAccessible(true);
        localObject2 = ???;
        localObject3 = ???;
        localObject4 = ???;
        localObject5 = ???;
        ??? = (Manager)localConstructor.newInstance(new Object[] { this.mAppRuntime });
        localObject2 = ???;
        if (??? != null)
        {
          localObject2 = ???;
          localObject3 = ???;
          localObject4 = ???;
          localObject5 = ???;
          this.managers.put(paramClass, ???);
          localObject2 = ???;
        }
      }
      catch (IllegalAccessException paramClass)
      {
        for (;;)
        {
          QLog.e("ManagerFactoryImpl", 1, new Object[] { "IllegalAccessException:", paramClass.toString() });
        }
      }
      catch (InstantiationException paramClass)
      {
        for (;;)
        {
          QLog.e("ManagerFactoryImpl", 1, new Object[] { "InstantiationException:", paramClass.toString() });
          localObject2 = localObject3;
        }
      }
      catch (NoSuchMethodException paramClass)
      {
        for (;;)
        {
          QLog.e("ManagerFactoryImpl", 1, new Object[] { "NoSuchMethodException:", paramClass.toString() });
          localObject2 = localObject4;
        }
      }
      catch (InvocationTargetException paramClass)
      {
        for (;;)
        {
          QLog.e("ManagerFactoryImpl", 1, new Object[] { "InvocationTargetException:", paramClass.toString() });
          localObject2 = localObject5;
        }
      }
      return localObject2;
    }
  }
  
  public <T extends Manager> T getManager(Class<T> paramClass)
  {
    Object localObject = (Manager)this.managers.get(paramClass);
    if (localObject != null) {}
    Manager localManager;
    do
    {
      return localObject;
      localManager = createManager(paramClass);
      localObject = localManager;
    } while (localManager != null);
    QLog.e("ManagerFactoryImpl", 1, "build Manager service fatal api:" + paramClass.getSimpleName());
    throw new IllegalStateException("build Manager fatal api:" + paramClass.getSimpleName());
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mAppRuntime = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.managers.values().iterator();
    while (localIterator.hasNext()) {
      ((Manager)localIterator.next()).onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.managerfactory.api.impl.ManagerFactoryServiceImpl
 * JD-Core Version:    0.7.0.1
 */