package com.tencent.qqmini.miniapp.task;

import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager.OnInitApkgListener;

class ApkgLoadAsyncTask$1
  implements ApkgManager.OnInitApkgListener
{
  ApkgLoadAsyncTask$1(ApkgLoadAsyncTask paramApkgLoadAsyncTask, MiniAppInfo paramMiniAppInfo) {}
  
  public void onInitApkgInfo(int paramInt, ApkgInfo paramApkgInfo, String paramString)
  {
    if ((paramInt == 0) && (paramApkgInfo != null))
    {
      ApkgLoadAsyncTask.access$002(this.this$0, paramApkgInfo);
      ApkgLoadAsyncTask.access$102(this.this$0, this.val$miniAppInfo);
      this.this$0.onTaskSucceed();
      return;
    }
    this.this$0.onTaskFailed(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.ApkgLoadAsyncTask.1
 * JD-Core Version:    0.7.0.1
 */