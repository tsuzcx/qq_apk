package com.tencent.mobileqq.filemanager.core;

import android.os.Handler;
import android.os.Looper;
import atei;
import java.util.TimerTask;

public class MMApkFileSafeChecker$CheckTask$3
  extends TimerTask
{
  public MMApkFileSafeChecker$CheckTask$3(atei paramatei) {}
  
  public void run()
  {
    if (this.a.a) {
      return;
    }
    this.a.e();
    new Handler(Looper.getMainLooper()).post(new MMApkFileSafeChecker.CheckTask.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask.3
 * JD-Core Version:    0.7.0.1
 */