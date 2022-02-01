package com.tencent.tbs.one.impl.loader;

import android.os.Bundle;
import com.tencent.tbs.one.impl.base.ThreadUtils;
import com.tencent.tbs.one.impl.base.task.DelegatedTask;
import com.tencent.tbs.one.impl.base.task.Task;
import com.tencent.tbs.one.impl.policy.PolicyManager;

class ComponentLoader$3
  extends DelegatedTask
{
  ComponentLoader$3(ComponentLoader paramComponentLoader, PolicyManager paramPolicyManager, Bundle paramBundle, String paramString1, float paramFloat, String paramString2, String paramString3) {}
  
  public void run(Task paramTask)
  {
    ThreadUtils.runOnCoreThread(new ComponentLoader.3.1(this, paramTask));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.ComponentLoader.3
 * JD-Core Version:    0.7.0.1
 */