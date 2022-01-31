package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import android.os.PowerManager.WakeLock;
import apnb;
import appt;
import apug;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import java.util.HashMap;
import java.util.Map;

public class VideoFilePresenter$10
  implements Runnable
{
  public VideoFilePresenter$10(appt paramappt) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      if (apug.c(this.this$0.jdField_a_of_type_Apnb.c())) {
        QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playVideo video, but mediaplay null!");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.this$0.jdField_a_of_type_Apnb.d() != 1);
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playVideo online video, but mediaplay null!");
      return;
      appt.a(this.this$0).acquire();
      this.this$0.c();
      if (appt.b(this.this$0))
      {
        appt.b(this.this$0, false);
        appt.a(this.this$0).removeCallbacks(this.this$0.jdField_a_of_type_JavaLangRunnable);
        HashMap localHashMap = new HashMap();
        localHashMap.put("shouq_bus_type", "bus_type_video_file");
        this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
        this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.this$0.jdField_a_of_type_AndroidAppActivity, appt.a(this.this$0), appt.a(this.this$0), 0L, this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
      }
      this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      appt.a(this.this$0).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 1000L);
      appt.d(this.this$0);
    } while ((!apug.c(this.this$0.jdField_a_of_type_Apnb.c())) || (!QLog.isDevelopLevel()));
    QLog.d("#@#@", 1, "userPos[" + appt.a(this.this$0) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.10
 * JD-Core Version:    0.7.0.1
 */