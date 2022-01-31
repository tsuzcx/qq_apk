package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import appp;
import apqx;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class VideoFilePresenter$12
  implements Runnable
{
  public VideoFilePresenter$12(appp paramappp) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      appp.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration());
      this.this$0.jdField_a_of_type_Apqx.a(appp.a(this.this$0));
      this.this$0.jdField_a_of_type_Apqx.b(false);
      this.this$0.jdField_a_of_type_Apqx.g(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.12
 * JD-Core Version:    0.7.0.1
 */