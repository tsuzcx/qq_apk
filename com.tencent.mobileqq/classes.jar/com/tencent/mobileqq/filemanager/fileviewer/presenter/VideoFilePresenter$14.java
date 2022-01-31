package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import android.os.PowerManager.WakeLock;
import arki;
import arnb;
import arrr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import java.util.HashMap;
import java.util.Map;

public class VideoFilePresenter$14
  implements Runnable
{
  public VideoFilePresenter$14(arnb paramarnb) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      if (arrr.c(this.this$0.jdField_a_of_type_Arki.d())) {
        QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playVideo video, but mediaplay null!");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.this$0.jdField_a_of_type_Arki.d() != 1);
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playVideo online video, but mediaplay null!");
      return;
      arnb.a(this.this$0).acquire();
      this.this$0.c();
      if (arnb.b(this.this$0))
      {
        arnb.b(this.this$0, false);
        arnb.a(this.this$0).removeCallbacks(this.this$0.jdField_a_of_type_JavaLangRunnable);
        HashMap localHashMap = new HashMap();
        localHashMap.put("shouq_bus_type", "bus_type_video_file");
        this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
        this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.this$0.jdField_a_of_type_AndroidAppActivity, arnb.a(this.this$0), arnb.a(this.this$0), 0L, this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
      }
      this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      arnb.a(this.this$0).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 1000L);
      arnb.d(this.this$0);
    } while ((!arrr.c(this.this$0.jdField_a_of_type_Arki.d())) || (!QLog.isDevelopLevel()));
    QLog.d("#@#@", 1, "userPos[" + arnb.a(this.this$0) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.14
 * JD-Core Version:    0.7.0.1
 */