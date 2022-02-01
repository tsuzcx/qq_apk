package com.tencent.viola.module;

import com.tencent.viola.utils.ViolaLogUtils;

final class ViolaModuleManager$2
  implements Runnable
{
  ViolaModuleManager$2(String paramString, IModuleHolder paramIModuleHolder) {}
  
  public void run()
  {
    try
    {
      ViolaModuleManager.registerNativeModule(this.val$moduleName, this.val$holder);
      return;
    }
    catch (Exception localException)
    {
      ViolaLogUtils.e("ViolaModuleManager", localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.module.ViolaModuleManager.2
 * JD-Core Version:    0.7.0.1
 */