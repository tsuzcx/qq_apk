package com.tencent.qqmini.nativePlugins;

import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

final class CMShowKitFileManager$1
  extends TimerTask
{
  public void run()
  {
    QLog.e("CMShowKitFileManager", 1, "getLocalRes timeout.");
    CMShowKitFileManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.CMShowKitFileManager.1
 * JD-Core Version:    0.7.0.1
 */