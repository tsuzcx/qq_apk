package com.tencent.tbs.one.impl.policy;

import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;

class EventEmitterImpl$1$1
  extends TBSOneCallback<TBSOneComponent>
{
  EventEmitterImpl$1$1(EventEmitterImpl.1 param1) {}
  
  public void onCompleted(TBSOneComponent paramTBSOneComponent)
  {
    paramTBSOneComponent = this.this$1.val$policyManager.getLoadedComponent(this.this$1.val$componentName);
    if (paramTBSOneComponent != null) {
      EventEmitterImpl.access$000(this.this$1.this$0, paramTBSOneComponent, this.this$1.val$className, this.this$1.val$eventName, this.this$1.val$params);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.EventEmitterImpl.1.1
 * JD-Core Version:    0.7.0.1
 */