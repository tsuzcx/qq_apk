package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import aris;
import arke;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class VideoFilePresenter$18
  implements Runnable
{
  public VideoFilePresenter$18(aris paramaris) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Arke.d(aris.a(this.this$0));
    if (this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {}
    while ((aris.b(this.this$0)) || (!this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {
      return;
    }
    int i = (int)this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    int j = (int)this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    this.this$0.jdField_a_of_type_Arke.b(i);
    if ((!aris.c(this.this$0)) && (i > aris.b(this.this$0))) {
      aris.b(this.this$0, i);
    }
    float f = i / j;
    if (f <= 0.001D)
    {
      aris.a(this.this$0).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 100L);
      return;
    }
    if (i >= aris.a(this.this$0)) {
      this.this$0.jdField_a_of_type_Arke.c((int)(f * 10000.0F));
    }
    aris.a(this.this$0).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.18
 * JD-Core Version:    0.7.0.1
 */