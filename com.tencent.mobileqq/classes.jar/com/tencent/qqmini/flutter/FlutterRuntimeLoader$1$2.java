package com.tencent.qqmini.flutter;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback.Stub;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class FlutterRuntimeLoader$1$2
  extends MiniCmdCallback.Stub
{
  FlutterRuntimeLoader$1$2(FlutterRuntimeLoader.1 param1) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    QMLog.d("FlutterRuntimeLoader", "update v8rt so succeed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.FlutterRuntimeLoader.1.2
 * JD-Core Version:    0.7.0.1
 */