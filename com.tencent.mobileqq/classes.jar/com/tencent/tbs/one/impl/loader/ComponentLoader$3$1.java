package com.tencent.tbs.one.impl.loader;

import com.tencent.tbs.one.impl.base.task.Task;
import com.tencent.tbs.one.impl.policy.PolicyManager;

class ComponentLoader$3$1
  implements Runnable
{
  ComponentLoader$3$1(ComponentLoader.3 param3, Task paramTask) {}
  
  public void run()
  {
    this.this$1.val$policyManager.installDependency(this.this$1.val$options, this.this$1.val$dependency, new ComponentLoader.3.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.ComponentLoader.3.1
 * JD-Core Version:    0.7.0.1
 */