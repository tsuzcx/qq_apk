package com.tencent.tbs.one.impl.policy;

import java.util.Map;

class EventEmitterImpl$1
  implements Runnable
{
  EventEmitterImpl$1(EventEmitterImpl paramEventEmitterImpl, PolicyManager paramPolicyManager, String paramString1, String paramString2, String paramString3, Map paramMap) {}
  
  public void run()
  {
    this.val$policyManager.loadComponent(this.val$componentName, null, new EventEmitterImpl.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.EventEmitterImpl.1
 * JD-Core Version:    0.7.0.1
 */