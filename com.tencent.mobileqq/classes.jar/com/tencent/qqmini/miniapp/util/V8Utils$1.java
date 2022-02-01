package com.tencent.qqmini.miniapp.util;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback.Stub;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

final class V8Utils$1
  extends MiniCmdCallback.Stub
{
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    QMLog.d("V8Utils", "update v8rt so succeed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.V8Utils.1
 * JD-Core Version:    0.7.0.1
 */