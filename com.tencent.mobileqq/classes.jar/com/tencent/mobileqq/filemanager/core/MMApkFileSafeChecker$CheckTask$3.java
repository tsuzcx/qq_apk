package com.tencent.mobileqq.filemanager.core;

import android.os.Handler;
import android.os.Looper;
import java.util.TimerTask;

class MMApkFileSafeChecker$CheckTask$3
  extends TimerTask
{
  MMApkFileSafeChecker$CheckTask$3(MMApkFileSafeChecker.CheckTask paramCheckTask) {}
  
  public void run()
  {
    if (this.a.a) {
      return;
    }
    this.a.e();
    new Handler(Looper.getMainLooper()).post(new MMApkFileSafeChecker.CheckTask.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask.3
 * JD-Core Version:    0.7.0.1
 */