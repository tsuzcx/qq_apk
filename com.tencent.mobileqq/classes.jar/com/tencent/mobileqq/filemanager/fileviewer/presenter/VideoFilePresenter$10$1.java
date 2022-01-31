package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import android.os.PowerManager.WakeLock;
import aris;
import ariu;
import arke;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class VideoFilePresenter$10$1
  implements Runnable
{
  public VideoFilePresenter$10$1(ariu paramariu) {}
  
  public void run()
  {
    aris.b(this.a.a, true);
    aris.a(this.a.a, 0);
    aris.a(this.a.a).release();
    this.a.a.a.c(0);
    this.a.a.a.b(0L);
    aris.b(this.a.a);
    ThreadManagerV2.getUIHandlerV2().postDelayed(new VideoFilePresenter.10.1.1(this), 1100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.10.1
 * JD-Core Version:    0.7.0.1
 */