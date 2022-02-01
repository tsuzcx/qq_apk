package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;
import com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask;

@ClassTag(tag="BaselibVersionCheckTask")
public class BaselibVersionCheckTask
  extends AsyncTask
{
  public static final String TAG = "BaselibVersionCheckTask";
  private boolean mVersionUpdated = false;
  
  public BaselibVersionCheckTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  private void checkBaseLibVersionMatch(MiniAppInfo paramMiniAppInfo, BaselibLoader.BaselibContent paramBaselibContent)
  {
    if ((paramBaselibContent != null) && (paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramBaselibContent.version)) && (!TextUtils.isEmpty(paramMiniAppInfo.baselibMiniVersion)))
    {
      String str = paramMiniAppInfo.baselibMiniVersion;
      paramBaselibContent = paramBaselibContent.version;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkBaseLibVersionMatch current:");
      localStringBuilder.append(paramBaselibContent);
      localStringBuilder.append(",need:");
      localStringBuilder.append(str);
      QMLog.i("BaselibVersionCheckTask", localStringBuilder.toString());
      boolean bool = false;
      if (TextUtils.isEmpty(paramBaselibContent)) {
        bool = true;
      } else if (!TextUtils.isEmpty(str)) {
        bool = BaseLibInfo.needUpdateVersion(str, paramBaselibContent);
      }
      if (!bool)
      {
        QMLog.i("BaselibVersionCheckTask", "no need to update baselib!");
        onTaskSucceed();
        return;
      }
      if (this.mVersionUpdated)
      {
        QMLog.w("BaselibVersionCheckTask", "baselib has checked before!");
        onTaskFailed();
        return;
      }
      this.mVersionUpdated = true;
      QMLog.w("BaselibVersionCheckTask", "need update baselib!");
      AppBrandCmdProxy.g().sendCmd("cmd_update_baselib", new Bundle(), new BaselibVersionCheckTask.1(this, paramMiniAppInfo));
      return;
    }
    QMLog.e("BaselibVersionCheckTask", "version is empty, escape verison check!");
    onTaskSucceed();
  }
  
  public void executeAsync()
  {
    BaselibLoader.BaselibContent localBaselibContent = ((BaselibLoadAsyncTask)getRuntimeLoader().getTask(BaselibLoadAsyncTask.class)).getBaselibContent();
    checkBaseLibVersionMatch(((MiniAppInfoLoadTask)getRuntimeLoader().getTask(MiniAppInfoLoadTask.class)).getMiniAppInfo(), localBaselibContent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.BaselibVersionCheckTask
 * JD-Core Version:    0.7.0.1
 */