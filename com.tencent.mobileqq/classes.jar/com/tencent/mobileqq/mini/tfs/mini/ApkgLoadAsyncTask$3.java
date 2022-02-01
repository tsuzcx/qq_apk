package com.tencent.mobileqq.mini.tfs.mini;

import com.tencent.mobileqq.mini.apkg.ApkgManager.OnFakeApkgListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;

class ApkgLoadAsyncTask$3
  implements ApkgManager.OnFakeApkgListener
{
  ApkgLoadAsyncTask$3(ApkgLoadAsyncTask paramApkgLoadAsyncTask, MiniAppConfig paramMiniAppConfig) {}
  
  public void onFakeApkgInfo(String paramString1, String paramString2)
  {
    AppLoaderFactory.getAppLoaderManager().onFakeApkgInfo(this.val$miniConfig, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.mini.ApkgLoadAsyncTask.3
 * JD-Core Version:    0.7.0.1
 */