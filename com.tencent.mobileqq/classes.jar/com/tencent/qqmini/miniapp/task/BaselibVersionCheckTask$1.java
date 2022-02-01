package com.tencent.qqmini.miniapp.task;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback.Stub;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;

class BaselibVersionCheckTask$1
  extends MiniCmdCallback.Stub
{
  BaselibVersionCheckTask$1(BaselibVersionCheckTask paramBaselibVersionCheckTask, MiniAppInfo paramMiniAppInfo) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = StorageUtil.getPreference().getString("version", "1.19.0.00043");
      QMLog.i("BaselibVersionCheckTask", "updateBaseLib succ. version=" + paramBundle);
      if ((this.val$miniAppInfo != null) && ((TextUtils.isEmpty(paramBundle)) || (BaseLibInfo.needUpdateVersion(this.val$miniAppInfo.baselibMiniVersion, paramBundle))))
      {
        this.this$0.onTaskFailed(13, "APP版本需升级");
        return;
      }
      this.this$0.onTaskFailed(12, "基础库版本更新");
      return;
    }
    QMLog.e("BaselibVersionCheckTask", "updateBaseLib fail.");
    this.this$0.onTaskFailed(11, "基础库更新失败");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.BaselibVersionCheckTask.1
 * JD-Core Version:    0.7.0.1
 */