package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import arnb;
import arno;
import aron;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class VideoFilePresenter$8$1
  implements Runnable
{
  public VideoFilePresenter$8$1(arno paramarno) {}
  
  public void run()
  {
    if ((this.a.a.jdField_a_of_type_Boolean == true) && (this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)) {
      this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
    this.a.a.jdField_a_of_type_Aron.d(arnb.a(this.a.a));
    if (arnb.a(this.a.a) != null) {
      arnb.a(this.a.a).postDelayed(this.a.a.jdField_a_of_type_JavaLangRunnable, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.8.1
 * JD-Core Version:    0.7.0.1
 */