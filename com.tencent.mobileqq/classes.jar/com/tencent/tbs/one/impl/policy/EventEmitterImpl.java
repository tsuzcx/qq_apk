package com.tencent.tbs.one.impl.policy;

import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneEventEmitter;
import com.tencent.tbs.one.TBSOneEventEmitter.UnloadedBehavior;
import com.tencent.tbs.one.TBSOneEventReceiver;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.base.ThreadUtils;
import com.tencent.tbs.one.impl.common.ReceiverConfig;
import com.tencent.tbs.one.impl.loader.ComponentImpl;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class EventEmitterImpl
  implements TBSOneEventEmitter
{
  private WeakReference<PolicyManager> mPolicyManager;
  
  public EventEmitterImpl(PolicyManager paramPolicyManager)
  {
    this.mPolicyManager = new WeakReference(paramPolicyManager);
  }
  
  private void emit(TBSOneComponent paramTBSOneComponent, String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    if (paramTBSOneComponent.getEntryClassLoader() == null) {
      warn(paramTBSOneComponent.getName(), paramString1, paramString2, "no entry class loader found", null);
    }
    try
    {
      Class localClass = paramTBSOneComponent.getEntryClassLoader().loadClass(paramString1);
      if (TBSOneEventReceiver.class.isAssignableFrom(localClass))
      {
        ((TBSOneEventReceiver)localClass.getConstructor(new Class[0]).newInstance(new Object[0])).onReceive(paramString2, paramMap);
        return;
      }
      warn(paramTBSOneComponent.getName(), paramString1, paramString2, "can't assign receiver class to com.tencent.tbs.one.TBSOneEventReceiver", null);
      return;
    }
    catch (ClassNotFoundException paramMap)
    {
      warn(paramTBSOneComponent.getName(), paramString1, paramString2, "can't load event receiver class", paramMap);
      return;
    }
    catch (NoSuchMethodException paramMap)
    {
      warn(paramTBSOneComponent.getName(), paramString1, paramString2, "can't find constructor method for event receiver class", paramMap);
      return;
    }
    catch (Exception paramMap)
    {
      warn(paramTBSOneComponent.getName(), paramString1, paramString2, "can't construct event receiver object", paramMap);
    }
  }
  
  private static void warn(String paramString1, String paramString2)
  {
    Logging.w("Failed to emit event %s, reason: %s", new Object[] { paramString1, paramString2 });
  }
  
  private static void warn(String paramString1, String paramString2, String paramString3, String paramString4, Throwable paramThrowable)
  {
    Logging.w("Failed to emit event %s to %s#%s, reason: %s", new Object[] { paramString3, paramString1, paramString2, paramString4, paramThrowable });
  }
  
  public void emit(TBSOneEventEmitter.UnloadedBehavior paramUnloadedBehavior, String paramString1, String paramString2, String paramString3, Map<String, Object> paramMap)
  {
    PolicyManager localPolicyManager = (PolicyManager)this.mPolicyManager.get();
    if (localPolicyManager == null)
    {
      warn(paramString1, paramString2, paramString3, "TBSOneManager is not alive", null);
      return;
    }
    ComponentImpl localComponentImpl = localPolicyManager.getLoadedComponent(paramString1);
    if (localComponentImpl == null)
    {
      if (paramUnloadedBehavior == TBSOneEventEmitter.UnloadedBehavior.IGNORE)
      {
        warn(paramString1, paramString2, paramString3, "component is not loaded yet", null);
        return;
      }
      if ((paramUnloadedBehavior == TBSOneEventEmitter.UnloadedBehavior.LOAD) && (localPolicyManager.isComponentInstalled(paramString1)))
      {
        warn(paramString1, paramString2, paramString3, "component is not installed yet", null);
        return;
      }
      ThreadUtils.runOnCoreThread(new EventEmitterImpl.1(this, localPolicyManager, paramString1, paramString2, paramString3, paramMap));
      return;
    }
    emit(localComponentImpl, paramString2, paramString3, paramMap);
  }
  
  public void emit(String paramString, Map<String, Object> paramMap)
  {
    PolicyManager localPolicyManager = (PolicyManager)this.mPolicyManager.get();
    if (localPolicyManager == null) {
      warn(paramString, "TBSOneManager is not alive");
    }
    for (;;)
    {
      return;
      Object localObject = localPolicyManager.getRegisteredReceiverConfigs(paramString);
      if (localObject == null)
      {
        warn(paramString, "no event receiver found");
        return;
      }
      localObject = ((List)localObject).listIterator();
      while (((ListIterator)localObject).hasNext())
      {
        ReceiverConfig localReceiverConfig = (ReceiverConfig)((ListIterator)localObject).next();
        emit(localPolicyManager.getLoadedComponent(localReceiverConfig.getComponentName()), localReceiverConfig.getClassName(), paramString, paramMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.EventEmitterImpl
 * JD-Core Version:    0.7.0.1
 */