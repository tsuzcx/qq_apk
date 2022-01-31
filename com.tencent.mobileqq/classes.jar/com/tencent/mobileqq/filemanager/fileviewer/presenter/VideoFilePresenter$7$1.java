package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.PowerManager.WakeLock;
import appp;
import appy;
import apqx;
import com.tencent.qphone.base.util.QLog;

public class VideoFilePresenter$7$1
  implements Runnable
{
  public VideoFilePresenter$7$1(appy paramappy) {}
  
  public void run()
  {
    appp.b(this.a.a, true);
    appp.a(this.a.a, 0);
    appp.a(this.a.a).release();
    this.a.a.a.c(0);
    this.a.a.a.b(0L);
    if (QLog.isDevelopLevel()) {
      QLog.d("#@#@", 1, "setProgress 187 [0]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.7.1
 * JD-Core Version:    0.7.0.1
 */