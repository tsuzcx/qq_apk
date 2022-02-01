package com.tencent.mobileqq.mini.tfs.mini;

import com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

class ApkgLoadAsyncTask$1
  implements Runnable
{
  ApkgLoadAsyncTask$1(ApkgLoadAsyncTask paramApkgLoadAsyncTask, MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    ApkgMainProcessManager.checkShouldLoadPkgInMainProcess(this.val$miniConfig, new ApkgLoadAsyncTask.1.1(this), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.mini.ApkgLoadAsyncTask.1
 * JD-Core Version:    0.7.0.1
 */