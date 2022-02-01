package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import android.os.PowerManager.WakeLock;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

class VideoFilePresenter$7
  implements Runnable
{
  VideoFilePresenter$7(VideoFilePresenter paramVideoFilePresenter) {}
  
  public void run()
  {
    int i;
    if (VideoFilePresenter.j(this.this$0) != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (VideoFilePresenter.a(this.this$0) == null)
    {
      if (i != 0)
      {
        QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playVideo video, but mediaplay null!");
        return;
      }
      if (this.this$0.c.w() == 1) {
        QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playVideo online video, but mediaplay null!");
      }
      return;
    }
    VideoFilePresenter.k(this.this$0).acquire();
    this.this$0.j();
    if (VideoFilePresenter.l(this.this$0))
    {
      VideoFilePresenter.b(this.this$0, false);
      VideoFilePresenter.b(this.this$0).removeCallbacks(this.this$0.k);
      new HashMap().put("shouq_bus_type", "bus_type_video_file");
    }
    VideoFilePresenter.a(this.this$0).play();
    if (i != 0) {
      VideoFilePresenter.b(this.this$0).postDelayed(this.this$0.k, 1000L);
    }
    VideoFilePresenter.m(this.this$0);
    if ((i != 0) && (QLog.isDevelopLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("userPos[");
      localStringBuilder.append(VideoFilePresenter.h(this.this$0));
      localStringBuilder.append("]");
      QLog.d("#@#@", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.7
 * JD-Core Version:    0.7.0.1
 */