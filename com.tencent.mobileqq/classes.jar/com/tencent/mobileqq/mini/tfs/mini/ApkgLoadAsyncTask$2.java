package com.tencent.mobileqq.mini.tfs.mini;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager;
import com.tencent.mobileqq.mini.apkg.ApkgManager.OnInitApkgListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.qphone.base.util.QLog;

class ApkgLoadAsyncTask$2
  implements ApkgManager.OnInitApkgListener
{
  ApkgLoadAsyncTask$2(ApkgLoadAsyncTask paramApkgLoadAsyncTask, MiniAppConfig paramMiniAppConfig) {}
  
  public void onInitApkgInfo(int paramInt, ApkgInfo paramApkgInfo, String paramString)
  {
    QLog.i("miniapp-start", 1, "initApkgByConfig end. result=" + paramInt + "; msg : " + paramString);
    ApkgMainProcessManager.removeSubProcessLoadTask(this.val$miniConfig);
    this.this$0.errorMsg = paramString;
    if ((paramInt == 0) && (paramApkgInfo != null))
    {
      MiniAppFileManager.getInstance().initFileManager(paramApkgInfo, false);
      QLog.i("miniapp-start", 1, "initApkgByConfig appid=" + paramApkgInfo.appId + " appName=" + paramApkgInfo.apkgName);
      ApkgLoadAsyncTask.access$102(this.this$0, paramApkgInfo);
      ApkgLoadAsyncTask.access$202(this.this$0, null);
      this.this$0.onTaskSucceed();
      return;
    }
    this.this$0.onTaskFailed(paramInt, paramString);
    ApkgLoadAsyncTask.access$102(this.this$0, null);
    ApkgLoadAsyncTask.access$202(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.mini.ApkgLoadAsyncTask.2
 * JD-Core Version:    0.7.0.1
 */