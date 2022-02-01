package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import android.os.PowerManager.WakeLock;
import asst;
import asvt;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class VideoFilePresenter$7
  implements Runnable
{
  public VideoFilePresenter$7(asvt paramasvt) {}
  
  public void run()
  {
    int i;
    if (asvt.a(this.this$0) != null)
    {
      i = 1;
      if (asvt.a(this.this$0) != null) {
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
      } while (this.this$0.jdField_a_of_type_Asst.d() != 1);
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playVideo online video, but mediaplay null!");
      return;
      asvt.a(this.this$0).acquire();
      this.this$0.c();
      if (asvt.a(this.this$0))
      {
        asvt.b(this.this$0, false);
        asvt.a(this.this$0).removeCallbacks(this.this$0.jdField_a_of_type_JavaLangRunnable);
        new HashMap().put("shouq_bus_type", "bus_type_video_file");
      }
      asvt.a(this.this$0).play();
      if (i != 0) {
        asvt.a(this.this$0).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 1000L);
      }
      asvt.e(this.this$0);
    } while ((i == 0) || (!QLog.isDevelopLevel()));
    QLog.d("#@#@", 1, "userPos[" + asvt.a(this.this$0) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.7
 * JD-Core Version:    0.7.0.1
 */