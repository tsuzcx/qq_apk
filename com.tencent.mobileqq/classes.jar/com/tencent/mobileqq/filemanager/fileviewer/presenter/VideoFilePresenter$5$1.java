package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import aoyb;
import aoyi;
import aozd;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class VideoFilePresenter$5$1
  implements Runnable
{
  public VideoFilePresenter$5$1(aoyi paramaoyi) {}
  
  public void run()
  {
    if ((this.a.a.jdField_a_of_type_Boolean == true) && (this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)) {
      this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
    this.a.a.jdField_a_of_type_Aozd.d(aoyb.a(this.a.a));
    if (aoyb.a(this.a.a) != null) {
      aoyb.a(this.a.a).postDelayed(this.a.a.jdField_a_of_type_JavaLangRunnable, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.5.1
 * JD-Core Version:    0.7.0.1
 */