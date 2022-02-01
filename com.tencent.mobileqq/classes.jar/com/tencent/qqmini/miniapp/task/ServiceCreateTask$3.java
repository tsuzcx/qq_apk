package com.tencent.qqmini.miniapp.task;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback.Stub;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

final class ServiceCreateTask$3
  extends MiniCmdCallback.Stub
{
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    QMLog.d("ServiceCreateTask", "update v8rt so succeed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.ServiceCreateTask.3
 * JD-Core Version:    0.7.0.1
 */