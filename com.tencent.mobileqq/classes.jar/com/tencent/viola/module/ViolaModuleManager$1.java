package com.tencent.viola.module;

import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Map;

class ViolaModuleManager$1
  implements Runnable
{
  ViolaModuleManager$1(String paramString, boolean paramBoolean, IModuleHolder paramIModuleHolder) {}
  
  public void run()
  {
    Object localObject;
    if (ViolaModuleManager.access$000().containsKey(this.val$moduleName))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Registry Duplicate the Module name: ");
      ((StringBuilder)localObject).append(this.val$moduleName);
      ViolaLogUtils.w("ViolaModuleManager", ((StringBuilder)localObject).toString());
    }
    if (this.val$global) {
      try
      {
        localObject = this.val$holder.buildInstance();
        ((BaseModule)localObject).setModuleName(this.val$moduleName);
        ViolaModuleManager.sGlobalModuleMap.put(this.val$moduleName, localObject);
      }
      catch (Exception localException1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.val$moduleName);
        localStringBuilder.append(" class must have a default constructor without params. ");
        localStringBuilder.append(localException1);
        ViolaLogUtils.e("ViolaModuleManager", localStringBuilder.toString());
      }
    }
    try
    {
      ViolaModuleManager.registerNativeModule(this.val$moduleName, this.val$holder);
    }
    catch (Exception localException2)
    {
      ViolaLogUtils.e("ViolaModuleManager", localException2.getMessage());
    }
    ViolaModuleManager.registerJSModule(this.val$moduleName, this.val$holder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.module.ViolaModuleManager.1
 * JD-Core Version:    0.7.0.1
 */