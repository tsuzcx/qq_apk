package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import aris;
import arjf;
import arke;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class VideoFilePresenter$8$1
  implements Runnable
{
  public VideoFilePresenter$8$1(arjf paramarjf) {}
  
  public void run()
  {
    if ((this.a.a.jdField_a_of_type_Boolean == true) && (this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)) {
      this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
    this.a.a.jdField_a_of_type_Arke.d(aris.a(this.a.a));
    if (aris.a(this.a.a) != null) {
      aris.a(this.a.a).postDelayed(this.a.a.jdField_a_of_type_JavaLangRunnable, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.8.1
 * JD-Core Version:    0.7.0.1
 */