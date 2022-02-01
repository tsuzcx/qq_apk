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
    if (VideoFilePresenter.a(this.this$0) != null)
    {
      i = 1;
      if (VideoFilePresenter.a(this.this$0) != null) {
        break label63;
      }
      if (i == 0) {
        break label40;
      }
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playVideo video, but mediaplay null!");
    }
    label40:
    label63:
    do
    {
      do
      {
        return;
        i = 0;
        break;
      } while (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d() != 1);
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playVideo online video, but mediaplay null!");
      return;
      VideoFilePresenter.a(this.this$0).acquire();
      this.this$0.c();
      if (VideoFilePresenter.a(this.this$0))
      {
        VideoFilePresenter.b(this.this$0, false);
        VideoFilePresenter.a(this.this$0).removeCallbacks(this.this$0.jdField_a_of_type_JavaLangRunnable);
        new HashMap().put("shouq_bus_type", "bus_type_video_file");
      }
      VideoFilePresenter.a(this.this$0).play();
      if (i != 0) {
        VideoFilePresenter.a(this.this$0).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 1000L);
      }
      VideoFilePresenter.e(this.this$0);
    } while ((i == 0) || (!QLog.isDevelopLevel()));
    QLog.d("#@#@", 1, "userPos[" + VideoFilePresenter.a(this.this$0) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.7
 * JD-Core Version:    0.7.0.1
 */