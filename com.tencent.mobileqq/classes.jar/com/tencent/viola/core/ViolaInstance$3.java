package com.tencent.viola.core;

import com.tencent.viola.module.BaseModule;
import com.tencent.viola.module.ViolaModuleManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class ViolaInstance$3
  implements Runnable
{
  ViolaInstance$3(ViolaInstance paramViolaInstance, Map paramMap) {}
  
  public void run()
  {
    Object localObject = this.val$moduleMap;
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BaseModule)((Iterator)localObject).next()).onActivityDestroy();
      }
    }
    ViolaModuleManager.destroy(ViolaInstance.access$400(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.ViolaInstance.3
 * JD-Core Version:    0.7.0.1
 */