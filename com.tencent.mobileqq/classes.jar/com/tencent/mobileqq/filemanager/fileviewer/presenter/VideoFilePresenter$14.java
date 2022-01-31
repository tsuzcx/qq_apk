package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import appt;
import aprb;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class VideoFilePresenter$14
  implements Runnable
{
  public VideoFilePresenter$14(appt paramappt) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Aprb.d(appt.a(this.this$0));
    if (this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {}
    while ((appt.b(this.this$0)) || (!this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {
      return;
    }
    int i = (int)this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    int j = (int)this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    this.this$0.jdField_a_of_type_Aprb.b(i);
    if ((!appt.c(this.this$0)) && (i > appt.b(this.this$0))) {
      appt.b(this.this$0, i);
    }
    float f = i / j;
    if (f <= 0.001D)
    {
      appt.a(this.this$0).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 100L);
      return;
    }
    if (i >= appt.a(this.this$0)) {
      this.this$0.jdField_a_of_type_Aprb.c((int)(f * 10000.0F));
    }
    appt.a(this.this$0).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.14
 * JD-Core Version:    0.7.0.1
 */