package com.tencent.tbs.one.impl.loader;

import android.os.Bundle;
import com.tencent.tbs.one.impl.base.ThreadUtils;
import com.tencent.tbs.one.impl.base.task.DelegatedTask;
import com.tencent.tbs.one.impl.base.task.Task;
import com.tencent.tbs.one.impl.common.DEPSConfig.ComponentConfig;

class ComponentLoader$2
  extends DelegatedTask
{
  ComponentLoader$2(ComponentLoader paramComponentLoader, Bundle paramBundle, DEPSConfig.ComponentConfig paramComponentConfig, float paramFloat, String paramString1, String paramString2) {}
  
  public void run(Task paramTask)
  {
    ThreadUtils.runOnCoreThread(new ComponentLoader.2.1(this, paramTask));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.ComponentLoader.2
 * JD-Core Version:    0.7.0.1
 */